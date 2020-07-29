package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Suppress("UNCHECKED_CAST")
class CVDetailedViewModelFactory(private val dataSource: CVFireDAO): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CVDetailsViewModel::class.java)) {
            return CVDetailsViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}