package com.irving.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CVDetailsViewModel (val database: CVFireDAO) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _singleCV = MutableLiveData<CVData>()
    val work: LiveData<CVData>
        get() = _singleCV

    //TODO REMOVE MOCK DATA
    init {
        startFetchingOneCV()
    }

    fun startFetchingOneCV() {
        uiScope.launch {
            _singleCV.value = getCVFromFireBase()
        }
    }

    private suspend fun getCVFromFireBase(): CVData? {
        return database.getSingleCV("D78yDDQEoPljo2g5RM8q")
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}