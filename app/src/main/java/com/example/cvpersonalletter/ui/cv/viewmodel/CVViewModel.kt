package com.example.cvpersonalletter.ui.cv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CVViewModel : ViewModel() {
    private val _cvName = MutableLiveData("J. Tommy Irving")
    private val _cvAddress = MutableLiveData("Ringvägen 78, Stockholm")
    private val _cvPhone = MutableLiveData("070 336 71 90")
    private val _cvEmail = MutableLiveData("j.t.i@hotmail.se")

    val cvName: LiveData<String> = _cvName
    val cvAddress: LiveData<String> = _cvAddress
    val cvPhone: LiveData<String> = _cvPhone
    val cvEmail: LiveData<String> = _cvEmail

}