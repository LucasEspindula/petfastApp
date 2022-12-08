package com.lucas.petfast.register.data.repository

import com.lucas.petfast.model.*
import com.lucas.petfast.register.data.remote.RegisterRemoteDataSource

class RegisterRepository {

    private val dataSource by lazy {
        RegisterRemoteDataSource()
    }

    suspend fun registerClient(clientModel: ClientModel): ResultModel<NewClientModel, ErrorModel> {
        return dataSource.registerClient(clientModel)
    }

    suspend fun registerPetshop(petshopModel: PetshopModel): ResultModel<NewPetshopModel, ErrorModel> {
        return dataSource.registerPetshop(petshopModel)
    }
}