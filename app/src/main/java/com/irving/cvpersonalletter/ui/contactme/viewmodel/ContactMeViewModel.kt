package com.irving.cvpersonalletter.ui.contactme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.ContactMeData
import com.irving.cvpersonalletter.database.Repository

class ContactMeViewModel(val database: Repository) : ViewModel() {

    private val _contactMe = MutableLiveData<MutableList<ContactMeData>>()
    val contactMe: LiveData<MutableList<ContactMeData>>
        get() = _contactMe
}