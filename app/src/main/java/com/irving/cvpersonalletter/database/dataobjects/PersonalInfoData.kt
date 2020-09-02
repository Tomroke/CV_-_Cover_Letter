package com.irving.cvpersonalletter.database.dataobjects

import android.net.Uri

data class PersonalInfoData (
    var name: String = "",
    val image: String = "",
    var imageUri: Uri? = null,
    var address: String = "",
    var phone: String = "",
    var email: String = ""
    )