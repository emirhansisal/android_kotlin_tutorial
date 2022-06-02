package com.example.android_kotlin_tutorial.models

data class Product(
    var Id: Int,
    var Title: String,
    var IsLiked: Boolean
)

class ProductId {
    companion object {
        private var _id = 0
        fun getNew() = _id++
    }
}
