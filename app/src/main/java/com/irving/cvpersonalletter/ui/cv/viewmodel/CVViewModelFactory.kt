package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Suppress("UNCHECKED_CAST")
class CVViewModelFactory( private val dataSource: Repository ): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CVViewModel::class.java)) {
            return CVViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
