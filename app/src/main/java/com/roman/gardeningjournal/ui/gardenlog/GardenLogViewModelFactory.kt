package com.roman.gardeningjournal.ui.gardenlog

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GardenLogViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GardenLogViewModel::class.java)) {
            return GardenLogViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
