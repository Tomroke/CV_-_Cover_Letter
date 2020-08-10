package com.irving.cvpersonalletter.database

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.tasks.await

@ExperimentalCoroutinesApi
class CVFireDAO: LiveData<CVData>(){
    private val TAG: String = "FireDB"
    private val dbCV = FirebaseFirestore.getInstance().collection("cvTest")
    private val dbPI = FirebaseFirestore.getInstance().collection("personalInfo")

    suspend fun getAllCVFromFire(): MutableList<CVData>{
        val cvDataList: MutableList<CVData> = mutableListOf()
        val snapshot = dbCV.get().await()
        for (snap in snapshot){
            cvDataList.add(snap.toObject())
        }
        return cvDataList
    }

    suspend fun getPersonalInfo(): PersonalInfoData {
        val snapshot = dbPI.get().await()
        return snapshot.first().toObject()
    }


}