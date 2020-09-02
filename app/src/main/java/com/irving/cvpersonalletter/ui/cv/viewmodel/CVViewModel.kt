package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.dataobjects.CVData
import com.irving.cvpersonalletter.database.dataobjects.PersonalInfoData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVViewModel(val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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
        startFetchingPersonalInfo()
        startFetchingAllCV()
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