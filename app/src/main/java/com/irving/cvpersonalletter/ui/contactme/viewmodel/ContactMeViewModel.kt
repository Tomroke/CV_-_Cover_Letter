package com.irving.cvpersonalletter.ui.contactme.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.ContactMeData
import com.irving.cvpersonalletter.database.PersonalInfoData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class ContactMeViewModel(val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _contactMe = MutableLiveData<MutableList<ContactMeData>>()
    val contactMe: LiveData<MutableList<ContactMeData>>
        get() = _contactMe

    init {
        startFetchingContactingMethods()
    }

    private fun startFetchingContactingMethods(){
        uiScope.launch {
            _contactMe.value = getContactingMethodsFromFirebase()
        }
    }

    private suspend fun getContactingMethodsFromFirebase(): MutableList<ContactMeData> {
        return database.getContactingMethods()
    }

}