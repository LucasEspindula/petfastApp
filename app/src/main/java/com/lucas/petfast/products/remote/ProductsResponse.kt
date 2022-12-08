package com.lucas.petfast.products.remote

data class ProductsResponse (
    val name: String,
    val description: String,
    val value: Double,
    val typeProduct: String
)