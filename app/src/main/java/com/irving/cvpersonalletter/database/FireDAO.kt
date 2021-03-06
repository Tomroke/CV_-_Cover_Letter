package com.irving.cvpersonalletter.database

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.storage.FirebaseStorage
import com.irving.cvpersonalletter.database.dataobjects.CVData
import com.irving.cvpersonalletter.database.dataobjects.ContactMeData
import com.irving.cvpersonalletter.database.dataobjects.CoverLetterData
import com.irving.cvpersonalletter.database.dataobjects.PersonalInfoData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.tasks.await


@ExperimentalCoroutinesApi
class FireDAO: LiveData<CVData>(){
    private val TAG: String = "FireDB"
    private val dbCV = FirebaseFirestore.getInstance().collection("cvData")
    private val dbPI = FirebaseFirestore.getInstance().collection("personalInfo")
    private val dbMethods = FirebaseFirestore.getInstance().collection("contactingMethods")
    private val dbCL = FirebaseFirestore.getInstance().collection("coverLetter")
    private var storage = FirebaseStorage.getInstance()

    private suspend fun getSingleImage(url: String): Uri? {
        return if (url.isNotEmpty()){
            val storageRef = storage.reference.child(url).downloadUrl
                .addOnFailureListener { error ->
                    Log.e(TAG, "$url \n$error")
                }
            storageRef.await()
        } else{
            null
        }
    }

    suspend fun getAllCVFromFire(): MutableList<CVData>{
        val cvDataList: MutableList<CVData> = mutableListOf()
        val snapshot = dbCV.get().await()

        for (snap in snapshot){
            cvDataList.add(snap.toObject())
        }

        for (cv in cvDataList){
            cv.imageUri = getSingleImage(cv.image)
        }

        return cvDataList
    }

    suspend fun getPersonalInfo(): PersonalInfoData {
        val personalInfoData: PersonalInfoData
        val snapshot = dbPI.get().await()
        personalInfoData = snapshot.documents.first().toObject()!!
        personalInfoData.imageUri = getSingleImage(personalInfoData.image)
        return personalInfoData
    }

    suspend fun getSingleCV(cvId: Int): CVData {
        val singleCV: CVData
        val snapshot = dbCV.whereEqualTo("cvId", cvId).get().await()
        singleCV = snapshot.documents.first().toObject()!!
        singleCV.imageUri = getSingleImage(singleCV.image)
        return singleCV
}

    suspend fun getContactingMethods(): MutableList<ContactMeData>{
        val contactingMethods: MutableList<ContactMeData> = mutableListOf()
        val snapshot = dbMethods.get().await()
        for (snap in snapshot){
            contactingMethods.add(snap.toObject())
        }
        return contactingMethods
    }

    suspend fun getCoverLetter(): CoverLetterData{
        val coverLetterData: CoverLetterData
        val snapshot = dbCL.get().await()
        coverLetterData = snapshot.first().toObject()
        return coverLetterData
    }
}
