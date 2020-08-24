package com.irving.cvpersonalletter.database

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class PersonalInfoData (
    var name: String = "",
    val image: String = "",
    var imageUri: Uri? = null,
    var address: String = "",
    var phone: String = "",
    var email: String = ""
    )