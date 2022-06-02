package com.example.android_kotlin_tutorial.ui.main.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_tutorial.R
import com.example.android_kotlin_tutorial.models.Product
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.android_kotlin_tutorial.App
import com.example.android_kotlin_tutorial.ui.detail.activities.DetailActivity

class ProductAdapter (
    private val productList: MutableList<Product>  //primary ctor prm olarak bunu isteyecek
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {  //türetilen class ın ctor ını çağır anlamında, ctor yaratıp içinde super yazmamıza gerek kalmıyor

    class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var btnGoDetail: Button
        var cbIsLiked: CheckBox
        init {
            tvTitle = itemView.findViewById(R.id.tvTitle)
            btnGoDetail = itemView.findViewById(R.id.btnGoDetail)
            cbIsLiked = itemView.findViewById(R.id.cbIsLiked)
        }
    }

    private lateinit var mParent: ViewGroup
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        mParent = parent
        mContext = parent.context
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product, parent, false
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
        holder.btnGoDetail.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java).apply {
                putExtra(App.Companion.PRODUCT_ID, prod.Id)
            }
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    private fun updateView(holder: ProductViewHolder) {
        if (holder.cbIsLiked.isChecked) {
            holder.tvTitle.setTextColor(mContext.getColor(R.color.purple_200))
        } else {
            holder.tvTitle.setTextColor(mContext.getColor(R.color.black))
        }
    }

    fun addItem(product: Product) {
        productList.add(product)
        notifyItemInserted(productList.size -1)
    }

    fun removeLikedItems() {
        productList.removeAll { prod ->
            if (prod.IsLiked) notifyItemRemoved(productList.indexOf(prod))
            //mParent.findViewById<RecyclerView>(R.id.productListRecyclerView).invalidate()
            prod.IsLiked
        }
    }
}