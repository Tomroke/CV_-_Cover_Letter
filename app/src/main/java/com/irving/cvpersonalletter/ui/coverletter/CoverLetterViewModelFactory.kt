package com.irving.cvpersonalletter.ui.coverletter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.ui.contactme.ContactMeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Suppress("UNCHECKED_CAST")
class CoverLetterViewModelFactory(private val dataSource: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoverLetterViewModel::class.java)) {
            return CoverLetterViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}