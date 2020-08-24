package com.irving.cvpersonalletter.database

import android.net.Uri

data class CVData(
    val cvId: Int = 0,
    var image: String = "",
    var imageUri: Uri? = null,
    val title: String = "",
    val date: String = "",
    val employer: String = "",
    val paraOne: String = "",
    val paraTwo: String = "",
    val paraThree: String = ""
    )
