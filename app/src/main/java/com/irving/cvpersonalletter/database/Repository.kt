package com.irving.cvpersonalletter.database

import com.irving.cvpersonalletter.database.dataobjects.CVData
import com.irving.cvpersonalletter.database.dataobjects.ContactMeData
import com.irving.cvpersonalletter.database.dataobjects.CoverLetterData
import com.irving.cvpersonalletter.database.dataobjects.PersonalInfoData
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class Repository private constructor( private val fireDAO: FireDAO ){

    suspend fun getAllCVFromFire(): MutableList<CVData> {
        return fireDAO.getAllCVFromFire()
    }

    suspend fun getPersonalInfo(): PersonalInfoData {
        return fireDAO.getPersonalInfo()
    }

    suspend fun getSingleCv(cvId: Int): CVData {
        return fireDAO.getSingleCV(cvId)
    }

    suspend fun getContactingMethods(): MutableList<ContactMeData>{
        return fireDAO.getContactingMethods()
    }

    suspend fun getCoverLetter(): CoverLetterData{
        return fireDAO.getCoverLetter()
    }

    companion object{
        @Volatile private var instance: Repository? = null
        fun getInstance(fireDAO: FireDAO) =
            instance ?: synchronized(this) {
                instance ?: Repository(fireDAO).also { instance = it }
            }
    }

}