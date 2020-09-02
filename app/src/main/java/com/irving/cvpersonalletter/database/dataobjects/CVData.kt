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
//1 	January
//2 	February
//3 	March
//4 	April
//5 	May
//6 	June
//7 	July
//8 	August
//9 	September
//10 	October
//11 	November
//12 	December