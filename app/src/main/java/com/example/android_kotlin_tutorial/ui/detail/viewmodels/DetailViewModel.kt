package com.example.android_kotlin_tutorial.ui.detail.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel() {

    val liveDesc: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val liveColor: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}