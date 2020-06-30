package com.example.cvpersonalletter.ui.cv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CVViewModel : ViewModel() {

    private val programmer: MutableLiveData<MutableMap<String, String>> = MutableLiveData(mutableMapOf())

    init {
        programmer.value!!["name"] = ("J. Tommy Irving")
        programmer.value!!["address"] = ("Ringvägen 78, Stockholm")
        programmer.value!!["numb"] = ("070 336 71 90")
        programmer.value!!["email"] = ("j.t.i@hotmail.se")
    }

    fun getProgrammer(): MutableLiveData<MutableMap<String, String>> {
        return programmer
    }



}