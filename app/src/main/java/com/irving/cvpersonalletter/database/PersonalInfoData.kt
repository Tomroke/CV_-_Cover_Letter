package com.irving.cvpersonalletter.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class PersonalInfoData (
    var name: String = "",
    val imageURL: String = "",
    var address: String = "",
    var phone: String = "",
    var email: String = ""
    )