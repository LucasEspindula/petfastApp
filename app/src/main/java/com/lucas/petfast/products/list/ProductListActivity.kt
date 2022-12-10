package com.lucas.petfast.products.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.petfast.databinding.ActivityProductListBinding
import com.lucas.petfast.products.remote.ProductsResponse

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

        viewModel.productsLiveData.observe(this) { products ->
            if (products != null && products.isNotEmpty()) {
                val productsMapper = products.map {
                    ProductsResponse(
                        name = it.name,
                        value = it.value,
                        description = it.description,
                        typeProduct = it.typeProduct
                    )
                }

                binding.rcList.adapter = adapterProducts
                adapterProducts.addList(productsMapper)
            }
        }
    }
}