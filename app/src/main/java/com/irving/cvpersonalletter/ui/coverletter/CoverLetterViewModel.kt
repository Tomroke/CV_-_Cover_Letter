package com.irving.cvpersonalletter.ui.coverletter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.FirebaseImageStatus
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.database.dataobjects.CoverLetterData
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CoverLetterViewModel (private val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _status = MutableLiveData<FirebaseImageStatus>()
    val status: LiveData<FirebaseImageStatus>
        get() = _status

    private val _coverLetter = MutableLiveData<CoverLetterData>()
    val coverLetter: LiveData<CoverLetterData>
        get() = _coverLetter

    init {
        startFetchingCoverLetterFromDatabase()
    }

    private fun startFetchingCoverLetterFromDatabase() {
        uiScope.launch {
            try {
                _status.value = FirebaseImageStatus.LOADING
                val coverLetterData = getCoverLetterData()

                _status.value = FirebaseImageStatus.DONE
                _coverLetter.value = coverLetterData

            }catch (error: Exception){
                _status.value = FirebaseImageStatus.ERROR
            }
        }
    }

    private suspend fun getCoverLetterData(): CoverLetterData {
        return database.getCoverLetter()
    }
}