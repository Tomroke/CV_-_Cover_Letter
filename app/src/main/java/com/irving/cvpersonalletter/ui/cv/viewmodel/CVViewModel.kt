package com.irving.cvpersonalletter.ui.cv.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.database.PersonalInfoData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVViewModel(val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _personalInfo = MutableLiveData<PersonalInfoData>()
    val personalInfo: LiveData<PersonalInfoData>
        get() = _personalInfo

    private val _personalImage = MutableLiveData<Uri>()
    val personalImage: LiveData<Uri>
        get() = _personalImage

    private var _allCV = MutableLiveData<MutableList<CVData>>()
    val allCv: LiveData<MutableList<CVData>>
        get() = _allCV

    private var _cvWithUri = MutableLiveData<MutableList<CVData>>()
    val cvWithUri: LiveData<MutableList<CVData>>
        get() = _cvWithUri

    private val _navigateToDetailedCV = MutableLiveData<Int>()
    val navigateToDetailedCV
        get() = _navigateToDetailedCV

    fun onCVClicked(id: Int) { _navigateToDetailedCV.value = id }
    fun onCVClickedNavigated() { _navigateToDetailedCV.value = null }


    init {
        startFetchingPersonalInfo()
        startFetchingAllCV()
    }

    fun startFetchingPersonalImage(uri: String){
        uiScope.launch {
            _personalImage.value = getPersonalImageFromFirebase(uri)
        }
    }

    private suspend fun getPersonalImageFromFirebase(uri: String): Uri? {
        return database.getSingleImage(uri)
    }

    fun startFetchingCVImages(){
        uiScope.launch {
            val newAllCv: MutableList<CVData> = mutableListOf()
            for (cv in _allCV.value!!){
                cv.image = getCVImageFromFirebase(cv.image).toString()
                newAllCv.add(cv)
            }
            _cvWithUri.value = newAllCv
        }
    }

    private suspend fun getCVImageFromFirebase(uri: String): Uri? {
        return database.getSingleImage(uri)
    }

    private fun startFetchingPersonalInfo(){
        uiScope.launch {
            _personalInfo.value = getPersonalInfoFromFirebase()
        }
    }

    private suspend fun getPersonalInfoFromFirebase(): PersonalInfoData {
        return database.getPersonalInfo()
    }

    private fun startFetchingAllCV(){
        uiScope.launch {
            _allCV.value = getAllCVFromFirebase()
        }
    }

    private suspend fun getAllCVFromFirebase(): MutableList<CVData> {
        return database.getAllCVFromFire()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}