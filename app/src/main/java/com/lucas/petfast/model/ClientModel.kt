package com.lucas.petfast.model

data class ClientModel(
    val username: String,
    val password: String,
    val cpf: String,
    val address: Address,
    val contact: Contact
)