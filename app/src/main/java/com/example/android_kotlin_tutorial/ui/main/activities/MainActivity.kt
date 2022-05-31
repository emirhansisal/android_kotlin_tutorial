package com.example.android_kotlin_tutorial.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kotlin_tutorial.R
import com.example.android_kotlin_tutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}