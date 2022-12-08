package com.lucas.petfast.products.repository

import com.lucas.petfast.model.ErrorModel
import com.lucas.petfast.model.ResultModel
import com.lucas.petfast.products.remote.ProductsRemoteDataSource
import com.lucas.petfast.products.remote.ProductsResponse

class ProductsRepository {

    private val dataSource by lazy {
        ProductsRemoteDataSource()
    }

    suspend fun fetchTransactions(): ResultModel<List<ProductsResponse>, ErrorModel> {
        return dataSource.fetchTransactions()
    }
}