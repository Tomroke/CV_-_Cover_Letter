package com.irving.cvpersonalletter.ui.contactme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.Repository

class ContactMeViewModel(val database: Repository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Contact Me"
    }
    val text: LiveData<String> = _text
}