package com.irving.cvpersonalletter.ui.coverletter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.database.dataobjects.CoverLetterData
import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
class CoverLetterViewModel (private val database: Repository) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _coverLetter = MutableLiveData<CoverLetterData>()
    val coverLetter: LiveData<CoverLetterData>
        get() = _coverLetter

    init {
        startFetchingCoverLetterFromDatabase()
    }

    private fun startFetchingCoverLetterFromDatabase() {
        uiScope.launch {
            getCoverLetterData()
        }
    }

    private suspend fun getCoverLetterData() {
        _coverLetter.value = database.getCoverLetter()
    }
}