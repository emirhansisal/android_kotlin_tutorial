package com.example.android_kotlin_tutorial.ui.main.adapters

import android.content.Context
import android.graphics.Color
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
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {  //türettiğimiz class ın ctor ını çağır anlamında, ctor yaratıp içinde super yazmamıza gerek kalmıyor

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var cbIsLiked: CheckBox
        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            cbIsLiked = itemView.findViewById(R.id.cbIsLiked)
        }
    }

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        mContext = parent.context
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val prod = productList[position]
        holder.tvTitle.text = prod.Title
        holder.cbIsLiked.isChecked = prod.IsLiked
        updateView(holder)
        holder.cbIsLiked.setOnCheckedChangeListener { _, isChecked ->
            prod.IsLiked = isChecked
            updateView(holder)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    private fun updateView(holder: ProductViewHolder) {
        if (holder.cbIsLiked.isChecked) {
            holder.tvTitle.highlightColor = mContext.getColor(R.color.purple_200)
        } else {
            holder.tvTitle.highlightColor = mContext.getColor(R.color.white)
        }
    }

    fun addItem(product: Product) {
        productList.add(product)
        notifyItemInserted(productList.size -1)
    }

    fun removeLikedItems() {
        productList.removeAll { prod ->
            if (prod.IsLiked) notifyItemRemoved(productList.indexOf(prod))
            prod.IsLiked
        }
    }
}