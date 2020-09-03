package com.irving.cvpersonalletter.database.dataobjects

import android.net.Uri

data class CVData(
    val cvId: Int = 0,
    var image: String = "",
    var imageUri: Uri? = null,
    val occupation: String = "",
    val date: String = "",
    val location: String = "",
    val paraOne: String = "",
    val paraTwo: String = "",
    val paraThree: String = ""
    )