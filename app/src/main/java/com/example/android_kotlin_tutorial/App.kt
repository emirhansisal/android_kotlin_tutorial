package com.example.android_kotlin_tutorial

import android.app.Application

class App: Application() {

    companion object {
        const val EXTRA_MESSAGE = "com.example.android_kotlin_tutorial.EXTRA_MESSAGE"
        const val PRODUCT_ID = "com.example.android_kotlin_tutorial.PRODUCT_ID"

    }
}