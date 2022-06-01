package com.example.android_kotlin_tutorial.ui.main.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_tutorial.R
import com.example.android_kotlin_tutorial.models.Product
import com.example.android_kotlin_tutorial.ui.main.adapters.ProductAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var prodAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvProd = findViewById<RecyclerView>(R.id.productListRecyclerView)
        val etProdTitle = findViewById<EditText>(R.id.productTitleEditText)
        rvProd.layoutManager = LinearLayoutManager(this)
        prodAdapter = ProductAdapter(mutableListOf())
        rvProd.adapter = prodAdapter

        findViewById<Button>(R.id.addButton).setOnClickListener() {
            val prod = Product(etProdTitle.text.toString(), false)
            prodAdapter.addItem(prod)
        }

        findViewById<Button>(R.id.delButton).setOnClickListener {
            prodAdapter.removeLikedItems()
        }
    }
}