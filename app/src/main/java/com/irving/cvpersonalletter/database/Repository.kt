package com.irving.cvpersonalletter.database

import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class Repository private constructor( private val fireDAO: FireDAO ){

    suspend fun getAllCVFromFire(): MutableList<CVData> {
        return fireDAO.getAllCVFromFire()
    }

    suspend fun getPersonalInfo(): PersonalInfoData {
        return fireDAO.getPersonalInfo()
    }

    suspend fun getSingleCv(cvId: Int): CVData{
        return fireDAO.getSingleCV(cvId)
    }

    companion object{
        @Volatile private var instance: Repository? = null
        fun getInstance(fireDAO: FireDAO) =
            instance ?: synchronized(this) {
                instance ?: Repository(fireDAO).also { instance = it }
            }
    }

}