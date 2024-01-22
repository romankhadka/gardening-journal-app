package com.roman.gardeningjournal.ui.gardenlog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.roman.gardeningjournal.R
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.databinding.FragmentAddPlantBinding
import java.util.Calendar

class AddPlantFragment : Fragment() {

    private lateinit var binding: FragmentAddPlantBinding
    private val viewModel: GardenLogViewModel by viewModels {
        GardenLogViewModelFactory(requireActivity().application)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_plant, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgBack.setOnClickListener { requireActivity().onBackPressed() }

        binding.btnAddPlant.setOnClickListener {
            if (!validate()) return@setOnClickListener
            val plantName = binding.etPlantName.text.toString()
            val plantType = binding.etType.text.toString()
            val wateringFrequency = binding.etWateringFrequency.text.toString().toInt()
            val plantingDate = binding.tvPlantDate.text.toString()
            val plant = Plant(0, plantName, plantType, wateringFrequency, plantingDate)

            viewModel.insert(plant)
            activity?.onBackPressed()
        }

        binding.tvPlantDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                binding.tvPlantDate.text = selectedDate
            },
            year, month, day
        ).show()
    }

    private fun validate(): Boolean {
        if (binding.etPlantName.text.isEmpty()) {
            binding.etPlantName.error = "Plant Name is required!!"
            binding.etPlantName.requestFocus()
            return false
        } else if (binding.etType.text.isEmpty()) {
            binding.etType.error = "Type is required!!"
            binding.etType.requestFocus()
            return false
        } else if (binding.etWateringFrequency.text.isEmpty()) {
            binding.etWateringFrequency.error = "Watering Frequency is required!!"
            binding.etWateringFrequency.requestFocus()
            return false
        } else if (binding.tvPlantDate.text.isEmpty()) {
            binding.tvPlantDate.error = "Type is required!!"
            binding.tvPlantDate.requestFocus()
            return false
        }
        return true
    }
}