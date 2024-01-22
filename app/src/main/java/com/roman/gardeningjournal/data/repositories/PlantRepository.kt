package com.roman.gardeningjournal.data.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.data.PlantDao
import com.roman.gardeningjournal.data.PlantDatabase

class PlantRepository(application: Application) {

    private val plantDao: PlantDao
    val allPlants: LiveData<List<Plant>>

    init {
        val database = PlantDatabase.getDatabase(application)
        plantDao = database.plantDao()
        allPlants = plantDao.getAllPlants()
    }

    suspend fun insert(plant: Plant) {
        plantDao.insert(plant)
    }

    suspend fun update(plant: Plant) {
        plantDao.update(plant)
    }

    suspend fun delete(plant: Plant) {
        plantDao.delete(plant.id)
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return plantDao.getPlantById(plantId)
    }
}