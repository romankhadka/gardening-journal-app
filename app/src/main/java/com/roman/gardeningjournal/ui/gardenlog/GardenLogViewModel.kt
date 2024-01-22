package com.roman.gardeningjournal.ui.gardenlog

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.data.repositories.PlantRepository
import kotlinx.coroutines.launch

class GardenLogViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlantRepository

    val gardenPlants: LiveData<List<Plant>>

    init {
        repository = PlantRepository(application)
        gardenPlants = repository.allPlants
    }

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun update(plant: Plant) = viewModelScope.launch {
        repository.update(plant)
    }
}