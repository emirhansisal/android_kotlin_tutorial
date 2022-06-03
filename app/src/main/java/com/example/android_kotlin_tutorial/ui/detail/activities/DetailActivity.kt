package com.example.android_kotlin_tutorial.ui.detail.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.android_kotlin_tutorial.App
import com.example.android_kotlin_tutorial.databinding.ActivityDetailBinding
import com.example.android_kotlin_tutorial.models.ProductDetail
import com.example.android_kotlin_tutorial.models.ProductDetailList
import com.example.android_kotlin_tutorial.ui.detail.viewmodels.DetailViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var productId: Int = 0
    private var productDetail: ProductDetail? = null
    private val rand = Random(645842)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productId = intent.getIntExtra(App.PRODUCT_ID, 0)
        productDetail = ProductDetailList.items.firstOrNull {
            it.ProductId == productId
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.liveColor.observe(this, Observer {
            binding.tvDesc.setBackgroundColor(it)
        })
        viewModel.liveDesc.observe(this, Observer {
            binding.tvDesc.text = it
        })

        viewModel.liveColor.value = productDetail?.Color ?: 0
        viewModel.liveDesc.value = productDetail?.Desc ?: ""

        this.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    delay(1000L)
                    myRunner()
                }
            }
        }
    }

    fun myRunner() {
        viewModel.liveColor.value = rand.nextInt(Int.MAX_VALUE)
        val desc = viewModel.liveDesc.value ?: ""
        viewModel.liveDesc.value = desc + "!"
    }

}


