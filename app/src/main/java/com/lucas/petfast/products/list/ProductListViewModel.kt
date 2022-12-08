package com.lucas.petfast.products.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.petfast.products.domain.usecase.ProductsUseCase
import com.lucas.petfast.products.remote.ProductsResponse
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val products: MutableLiveData<List<ProductsResponse>> = MutableLiveData()
    val productsLiveData: LiveData<List<ProductsResponse>> = products

    private val usecase by lazy {
        ProductsUseCase()
    }

    fun callProducts() {
        viewModelScope.launch {
            products.value = usecase.fetchTransactions().get()
        }
    }
}