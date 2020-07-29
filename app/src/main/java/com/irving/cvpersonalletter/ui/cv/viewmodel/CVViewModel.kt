package com.irving.cvpersonalletter.ui.cv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVViewModel(val database: CVFireDAO) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _cvName = MutableLiveData("J. Tommy Irving")
    val cvName: LiveData<String>
        get() = _cvName

    private val _cvAddress = MutableLiveData("Ringvägen 78, Stockholm")
    val cvAddress: LiveData<String>
        get() = _cvAddress

    private val _cvPhone = MutableLiveData("070 336 71 90")
    val cvPhone: LiveData<String>
        get() = _cvPhone

    private val _cvEmail = MutableLiveData("j.t.i@hotmail.se")
    val cvEmail: LiveData<String>
        get() = _cvEmail


    private var _allCV = MutableLiveData<MutableList<CVData>>()
    val allCv: LiveData<MutableList<CVData>>
        get() = _allCV


    private val _navigateToDetailedCV = MutableLiveData<String>()
    val navigateToDetailedCV
        get() = _navigateToDetailedCV

    fun onCVClicked(id: String) { _navigateToDetailedCV.value = id }
    fun onCVClickedNavigated() { _navigateToDetailedCV.value = null }


    init {
        startFetchingAllCV()
    }

    fun startFetchingAllCV(){
        uiScope.launch {
            _allCV.value = getAllCVFromFirebase()
            Log.i("FireDB", "in launch \n${_allCV.value}")
        }
    }

    private suspend fun getAllCVFromFirebase(): MutableList<CVData> {
        return database.getAllCV()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}