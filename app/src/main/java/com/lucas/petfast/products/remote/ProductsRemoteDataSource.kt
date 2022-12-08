package com.lucas.petfast.products.remote

import com.lucas.petfast.RetrofitNetworkClient
import com.lucas.petfast.model.ErrorModel
import com.lucas.petfast.model.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductsRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(ProductApi::class.java)

    suspend fun fetchTransactions(): ResultModel<List<ProductsResponse>, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                ResultModel.Success(service.fetch())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }
}