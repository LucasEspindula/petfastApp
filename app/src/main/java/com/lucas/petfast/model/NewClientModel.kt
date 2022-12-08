package com.lucas.petfast.model

data class NewClientModel (
    val username: String,
    val password: String,
    val cpf: String,
    val addressModel: AddressModel,
    val contactModel: ContactModel
)

