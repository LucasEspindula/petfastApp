package com.lucas.petfast.model

data class PetshopModel(
    val username: String,
    val password: String,
    val cnpj: String,
    val address: Address,
    val contact: Contact
)