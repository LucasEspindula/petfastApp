package com.lucas.petfast.register.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.petfast.model.NewPetshopModel
import com.lucas.petfast.model.PetshopModel
import com.lucas.petfast.register.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterPetshopViewModel : ViewModel() {

    private val usecase by lazy {
        RegisterUseCase()
    }

    private val userCreated: MutableLiveData<Boolean> = MutableLiveData(false)
    val userCreatedLiveData: LiveData<Boolean> = userCreated

    private val message: MutableLiveData<String> = MutableLiveData()
    val shouldShowMessage: LiveData<String> = message

    fun registerPetshop(newPetshopModel: NewPetshopModel) {
        viewModelScope.launch {
            if (newPetshopModel.cnpj.isBlank()) {
                message.value = "CNPJ não pode ser vazio."
            } else if (newPetshopModel.username.isBlank()) {
                message.value = "Nome de usuário não pode ser vazio."
            } else if (newPetshopModel.password.isBlank()) {
                message.value = "Senha não pode ser vazia."
            } else if (newPetshopModel.address.city.isBlank()) {
                message.value = "Cidade não pode ser vazia."
            } else if (newPetshopModel.address.number.isBlank()) {
                message.value = "Número de endereço não pode ser vazio."
            } else if (newPetshopModel.address.road.isBlank()) {
                message.value = "Nome da rua não pode ser vazia."
            } else if (newPetshopModel.address.district.isBlank()) {
                message.value = "Bairro residêncial não pode ser vazio."
            } else if (newPetshopModel.address.state.isBlank()) {
                message.value = "Estado residente não pode ser vazio."
            } else if (newPetshopModel.address.zipCode.isBlank()) {
                message.value = "CEP não pode ser vazio."
            } else {
                val newUser = PetshopModel(
                    cnpj = newPetshopModel.cnpj,
                    username = newPetshopModel.username,
                    password = newPetshopModel.password,
                    contact = newPetshopModel.contact,
                    address = newPetshopModel.address
                )

                userCreated.value = true
                usecase.registerPetshop(newUser)
                message.value = "Profile created successfully!"
            }
        }
    }
}