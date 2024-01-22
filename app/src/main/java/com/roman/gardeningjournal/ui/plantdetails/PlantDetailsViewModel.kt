package com.roman.gardeningjournal.ui.plantdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.data.repositories.PlantRepository

class PlantDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val plantRepository: PlantRepository

    init {
        plantRepository = PlantRepository(application)
    }

    fun getPlantById(plantId: Int) : LiveData<Plant> {
        return plantRepository.getPlantById(plantId)
    }
}
