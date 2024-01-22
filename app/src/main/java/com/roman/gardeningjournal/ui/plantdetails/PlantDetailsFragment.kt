package com.roman.gardeningjournal.ui.plantdetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.roman.gardeningjournal.R
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPlantDetailsBinding
    private val viewModel: PlantDetailsViewModel by viewModels {
        PlantDetailsViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_plant_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnClickListener { requireActivity().onBackPressed() }

        val plantId = arguments?.getInt("plantId") ?: 0

        viewModel.getPlantById(plantId).observe(viewLifecycleOwner) { plant ->
            plant?.let { displayPlantDetails(it) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayPlantDetails(plant: Plant) {
        binding.tvPlantName.text = plant.name
        binding.tvPlantType.text = "Type: ${plant.type}"
        binding.tvPlantWater.text = "Watering ${plant.wateringFrequency} days "
        binding.tvPlantDate.text = "Planting Date: ${plant.plantingDate}"
    }
}