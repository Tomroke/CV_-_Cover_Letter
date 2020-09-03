package com.irving.cvpersonalletter.ui.contactme.viewmodel

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.FirebaseImageStatus
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.database.dataobjects.ContactMeData
import de.cketti.mailto.EmailIntentBuilder
import kotlinx.coroutines.*


@ExperimentalCoroutinesApi
class ContactMeViewModel(val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _status = MutableLiveData<FirebaseImageStatus>()
    val status: LiveData<FirebaseImageStatus>
        get() = _status

    private val _contactMe = MutableLiveData<MutableList<ContactMeData>>()
    val contactMe: LiveData<MutableList<ContactMeData>>
        get() = _contactMe

    init {
        startFetchingContactingMethods()
    }

    private fun startFetchingContactingMethods(){
        uiScope.launch {
            try {
                _status.value = FirebaseImageStatus.LOADING
                val contactMeData = getContactingMethodsFromFirebase()

                _status.value = FirebaseImageStatus.DONE
                _contactMe.value = contactMeData

            }catch (error: Exception){
                _status.value = FirebaseImageStatus.ERROR
            }
        }
    }

    private suspend fun getContactingMethodsFromFirebase(): MutableList<ContactMeData> {
        return database.getContactingMethods()
    }

    fun contactMeWith(method: String, link: String, context: Context){
        when(method){
            "LinkedIn" -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(context, browserIntent, null)
            }
            "Email" -> {
                val emailIntent = EmailIntentBuilder.from(context).to(link).subject("We checked out your App!").build()
                startActivity(context, emailIntent, null)
            }
            "Phone" -> {
                val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$link"))
                startActivity(context, phoneIntent, null)
            }
            "Github" -> {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(context, browserIntent, null)
            }
        }
    }
}