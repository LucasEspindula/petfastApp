package com.lucas.petfast.register.data.remote

import com.lucas.petfast.RetrofitNetworkClient
import com.lucas.petfast.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(RegisterApi::class.java)

    suspend fun registerClient(clientModel: ClientModel): ResultModel<NewClientModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val user = service.client(clientModel)
                ResultModel.Success(user.mapModelClientToNewModel())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    suspend fun registerPetshop(petshopModel: PetshopModel): ResultModel<NewPetshopModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val user = service.petshop(petshopModel)
                ResultModel.Success(user.mapModelPetshopToNewModel())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel)
            }
        }
    }

    private fun ClientModel.mapModelClientToNewModel(): NewClientModel {
        return NewClientModel(
            cpf = cpf,
            username = username,
            password = password,
            contactModel = contactModel,
            addressModel = addressModel
        )
    }

    private fun PetshopModel.mapModelPetshopToNewModel(): NewPetshopModel {
        return NewPetshopModel(
            cnpj = cnpj,
            username = username,
            password = password,
            contactModel = contactModel,
            addressModel = addressModel
        )
    }
}