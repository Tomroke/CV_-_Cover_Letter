package com.example.cvpersonalletter.ui.contactme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactMeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Contact Me"
    }
    val text: LiveData<String> = _text
}