package com.lucas.petfast.model

data class ClientModel (
    val id: Int = 0,
    val username: String,
    val password: String,
    val cpf: String,
    val addressModel: AddressModel,
    val contactModel: ContactModel
)