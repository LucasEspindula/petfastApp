package com.lucas.petfast.products.domain.usecase

import com.lucas.petfast.model.ErrorModel
import com.lucas.petfast.model.ResultModel
import com.lucas.petfast.products.remote.ProductsResponse
import com.lucas.petfast.products.repository.ProductsRepository

class ProductsUseCase {

    private val repository by lazy {
        ProductsRepository()
    }

    suspend fun fetchTransactions(): ResultModel<List<ProductsResponse>, ErrorModel> {
        return repository.fetchTransactions()
    }
}