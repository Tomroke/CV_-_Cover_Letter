package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.FirebaseImageStatus
import com.irving.cvpersonalletter.database.dataobjects.CVData
import com.irving.cvpersonalletter.database.Repository
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVDetailsViewModel (val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _status = MutableLiveData<FirebaseImageStatus>()
    val status: LiveData<FirebaseImageStatus>
        get() = _status

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
            try {
                _status.value = FirebaseImageStatus.LOADING
                val singleCV = getSingleCVFromFirebase()

                _status.value = FirebaseImageStatus.DONE
                _singleCV.value = singleCV

            }catch (error: Exception){
                _status.value = FirebaseImageStatus.ERROR
            }

        }
    }

    private suspend fun getSingleCVFromFirebase(): CVData {
        return if (cvID.value != null){
            database.getSingleCv(cvID.value!!)
        }else{
            CVData()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}