package com.irving.cvpersonalletter.ui.cv.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVDetailsViewModel (val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _singleCV = MutableLiveData<CVData>()
    val singleCV: LiveData<CVData>
        get() = _singleCV

    private var _cvID = MutableLiveData<Int>()
    val cvID: LiveData<Int>
        get() = _cvID

    fun setCVID(id: Int){
        if (id != _cvID.value){
            _cvID.value = id
        }
    }

    fun startFetchingSingleCV() {
        uiScope.launch {
            getSingleCVFromFirebase()
        }
    }

    private suspend fun getSingleCVFromFirebase() {
        if (cvID.value != null){
            _singleCV.value = database.getSingleCv(cvID.value!!)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}