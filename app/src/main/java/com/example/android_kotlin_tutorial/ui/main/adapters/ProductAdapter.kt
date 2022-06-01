package com.example.android_kotlin_tutorial.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_tutorial.R
import com.example.android_kotlin_tutorial.models.Product
import android.widget.TextView

class ProductAdapter (
    private val productList: MutableList<Product>
) : RecyclerView.Adapter<ProductAdapter.ProdViewHolder>() {  //türettiğimiz class ın ctor ını çağır anlamında, ctor yaratıp içinde super yazmamıza gerek kalmıyor

    class ProdViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var cbIsLiked: CheckBox
        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            cbIsLiked = itemView.findViewById(R.id.cbIsLiked)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdViewHolder {
        return ProdViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent
            )
        )
    }

    override fun onBindViewHolder(holder: ProdViewHolder, position: Int) {
        val prod = productList[position]
        holder.tvTitle.text = prod.Title
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}