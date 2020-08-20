package com.irving.cvpersonalletter.database

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.tasks.await
import java.net.URI


@ExperimentalCoroutinesApi
class FireDAO: LiveData<CVData>(){
    private val TAG: String = "FireDB"
    private val dbCV = FirebaseFirestore.getInstance().collection("cvTest")
    private val dbPI = FirebaseFirestore.getInstance().collection("personalInfo")
    private val dbMethods = FirebaseFirestore.getInstance().collection("contactingMethods")
    private var storage = FirebaseStorage.getInstance()

    suspend fun getSingleImage(url: String): Uri {
        val storageRef = storage.reference.child(url).downloadUrl
            .addOnFailureListener { error ->
            Log.e(TAG, "$error")
        }
        return storageRef.await()
    }

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

    suspend fun getSingleCV(cvId: Int): CVData {
        val snapshot = dbCV.whereEqualTo("cvId", cvId).get().await()
        return snapshot.first().toObject()
}

    suspend fun getContactingMethods(): MutableList<ContactMeData>{
        val contactingMethods: MutableList<ContactMeData> = mutableListOf()
        val snapshot = dbMethods.get().await()
        for (snap in snapshot){
            contactingMethods.add(snap.toObject())
        }
        return contactingMethods
    }

}
