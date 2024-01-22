package com.roman.gardeningjournal.ui.gardenlog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.roman.gardeningjournal.R
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.databinding.FragmentGardenLogBinding

class GardenLogFragment : Fragment() {

    private val viewModel: GardenLogViewModel by viewModels {
        GardenLogViewModelFactory(requireActivity().application)
    }
    private lateinit var binding: FragmentGardenLogBinding
    private lateinit var navController: NavController
    private var listPlant = mutableListOf<Plant>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_garden_log, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val adapter = GardenLogAdapter(listPlant)
        adapter.setItemClickListener(object : GardenLogAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = bundleOf("plantId" to listPlant[position].id)
                navController.navigate(
                    R.id.action_gardenLogFragment_to_plantDetailsFragment,
                    bundle
                )
            }
        })

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter = adapter

        viewModel.gardenPlants.observe(viewLifecycleOwner, Observer {
            if (it == null || it.isEmpty()) {
                addSampleData()
            } else {
                listPlant.clear()
                listPlant.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

        binding.fabAddPlant.setOnClickListener {
            navController.navigate(R.id.action_gardenLogFragment_to_addPlantFragment)
        }
    }

    private fun addSampleData() {
        val samplePlants = mutableListOf<Plant>()
        samplePlants.add(
            Plant(
                name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate
                = "2023-01-01"
            )
        )
        samplePlants.add(
            Plant(
                name = "Tomato", type = "Vegetable", wateringFrequency = 3,
                plantingDate = "2023-02-15"
            )
        )
        samplePlants.add(
            Plant(
                name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate =
                "2023-03-10"
            )
        )
        for (plant in samplePlants) {
            viewModel.insert(plant)
        }
    }
}