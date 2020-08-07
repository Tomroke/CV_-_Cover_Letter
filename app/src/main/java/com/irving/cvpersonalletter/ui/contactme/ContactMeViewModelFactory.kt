package com.irving.cvpersonalletter.ui.contactme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Suppress("UNCHECKED_CAST")
class ContactMeViewModelFactory(private val dataSource: Repository): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContactMeViewModel::class.java)) {
                return ContactMeViewModel(dataSource) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
