package com.lucas.petfast.model

data class PetshopModel (
    val id: Int = 0,
    val username: String,
    val password: String,
    val cnpj: String,
    val addressModel: AddressModel,
    val contactModel: ContactModel
)