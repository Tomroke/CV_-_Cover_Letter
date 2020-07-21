package com.example.cvpersonalletter.ui.cv.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cvpersonalletter.data.Work

class CVDetailsViewModel : ViewModel() {
    private var _work = MutableLiveData<Work>()

    val work: LiveData<Work>
        get() = _work

    //TODO REMOVE MOCK DATA
    init {
        _work = MutableLiveData(Work())
    }

}