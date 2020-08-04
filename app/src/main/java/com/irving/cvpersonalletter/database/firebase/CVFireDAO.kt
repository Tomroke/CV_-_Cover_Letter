package com.irving.cvpersonalletter.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.irving.cvpersonalletter.database.CVData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.tasks.await

@ExperimentalCoroutinesApi
class CVFireDAO: LiveData<CVData>(){
    private val TAG: String = "FireDB"
    private val db = FirebaseFirestore.getInstance().collection("cvTest")

    suspend fun getAllCVFromFire(): MutableList<CVData>{
        val cvDataList: MutableList<CVData> = mutableListOf()
        val snapshot = db.get().await()
        for (snap in snapshot){
            cvDataList.add(snap.toObject())
        }
        return cvDataList
    }


}