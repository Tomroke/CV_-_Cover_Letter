package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.FirebaseImageStatus
import com.irving.cvpersonalletter.database.dataobjects.CVData
import com.irving.cvpersonalletter.database.dataobjects.PersonalInfoData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*
import java.lang.Exception

@ExperimentalCoroutinesApi
class CVViewModel(val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _status = MutableLiveData<FirebaseImageStatus>()
    val status: LiveData<FirebaseImageStatus>
        get() = _status

    private val _personalInfo = MutableLiveData<PersonalInfoData>()
    val personalInfo: LiveData<PersonalInfoData>
        get() = _personalInfo

    private var _allCV = MutableLiveData<MutableList<CVData>>()
    val allCv: LiveData<MutableList<CVData>>
        get() = _allCV

    private val _navigateToDetailedCV = MutableLiveData<Int>()
    val navigateToDetailedCV
        get() = _navigateToDetailedCV

    fun onCVClicked(id: Int) { _navigateToDetailedCV.value = id }
    fun onCVClickedNavigated() { _navigateToDetailedCV.value = null }


    init {
        startDataFetching()
    }

    private fun startDataFetching() {
        uiScope.launch {
            try {
                _status.value = FirebaseImageStatus.LOADING
                val personalInfoResult = getPersonalInfoFromFirebase()
                val cvDataResult = getAllCVFromFirebase()

                _status.value = FirebaseImageStatus.DONE
                _personalInfo.value = personalInfoResult
                _allCV.value = cvDataResult

            }catch (error: Exception){
                _status.value = FirebaseImageStatus.ERROR

            }
        }
    }


    private suspend fun getPersonalInfoFromFirebase(): PersonalInfoData {
        return database.getPersonalInfo()
    }


    private suspend fun getAllCVFromFirebase(): MutableList<CVData> {
        return database.getAllCVFromFire()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}