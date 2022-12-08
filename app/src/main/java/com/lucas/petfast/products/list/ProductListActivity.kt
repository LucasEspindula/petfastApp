package com.lucas.petfast.products.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.petfast.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    private lateinit var viewModel: ProductListViewModel

    private val adapterProducts: ProductListAdapter by lazy {
        ProductListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProductListViewModel()
        viewModel.callProducts()

        viewModel.productsLiveData.observe(this) {
            binding.rcList.adapter = adapterProducts
        }
    }
}