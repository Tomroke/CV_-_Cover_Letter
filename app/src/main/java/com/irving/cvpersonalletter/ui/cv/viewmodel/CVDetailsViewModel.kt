package com.irving.cvpersonalletter.ui.cv.viewmodel

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
    val work: LiveData<CVData>
        get() = _singleCV

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}