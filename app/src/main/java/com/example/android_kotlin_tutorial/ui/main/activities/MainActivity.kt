package com.example.android_kotlin_tutorial.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_kotlin_tutorial.databinding.ActivityMainBinding
import com.example.android_kotlin_tutorial.models.Product
import com.example.android_kotlin_tutorial.models.ProductId
import com.example.android_kotlin_tutorial.ui.main.adapters.ProductAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prodAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(this)
        prodAdapter = ProductAdapter(mutableListOf())
        binding.productListRecyclerView.adapter = prodAdapter

        binding.addButton.setOnClickListener() {
            val prod = Product(ProductId.getNew(), binding.productTitleEditText.text.toString(), false)
            prodAdapter.addItem(prod)
            binding.productTitleEditText.text.clear()
        }

        binding.delButton.setOnClickListener {
            prodAdapter.removeLikedItems()
        }
    }
}