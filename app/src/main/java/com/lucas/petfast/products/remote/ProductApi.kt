package com.lucas.petfast.products.remote

import retrofit2.http.GET

interface ProductApi {

    @GET("product/request")
    suspend fun fetch(
    ): List<ProductsResponse>
}