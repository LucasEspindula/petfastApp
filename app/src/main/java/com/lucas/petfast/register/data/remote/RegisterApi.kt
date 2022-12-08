package com.lucas.petfast.register.data.remote

import com.lucas.petfast.model.ClientModel
import com.lucas.petfast.model.PetshopModel
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {

    @POST("user/client")
    suspend fun client(
        @Body clientModel: ClientModel
    ): ClientModel

    @POST("user/petshop")
    suspend fun petshop(
        @Body petshopModel: PetshopModel
    ): PetshopModel
}