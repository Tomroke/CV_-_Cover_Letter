package com.irving.cvpersonalletter.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class PersonalInfoData (
    var name: String = "",
    var adress: String = "",
    var phone: String = "",
    var email: String = ""
    )