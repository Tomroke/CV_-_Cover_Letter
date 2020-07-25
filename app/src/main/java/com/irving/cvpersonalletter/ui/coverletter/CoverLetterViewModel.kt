package com.irving.cvpersonalletter.ui.coverletter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoverLetterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Cover Letter"
    }
    val text: LiveData<String> = _text
}