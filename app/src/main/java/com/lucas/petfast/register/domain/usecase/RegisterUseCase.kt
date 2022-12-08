package com.lucas.petfast.register.domain.usecase

import com.lucas.petfast.model.*
import com.lucas.petfast.register.data.repository.RegisterRepository

class RegisterUseCase {

    private val repository by lazy {
        RegisterRepository()
    }

    suspend fun registerClient(clientModel: ClientModel): ResultModel<NewClientModel, ErrorModel> {
        return repository.registerClient(clientModel)
    }

    suspend fun registerPetshop(petshopModel: PetshopModel): ResultModel<NewPetshopModel, ErrorModel> {
        return repository.registerPetshop(petshopModel)
    }
}