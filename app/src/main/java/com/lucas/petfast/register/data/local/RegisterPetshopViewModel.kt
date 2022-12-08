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
                message.value = "The CNPJ field cannot be empty!"
            } else {
                val newUser = PetshopModel(
                    cnpj = newPetshopModel.cnpj,
                    username = newPetshopModel.username,
                    password = newPetshopModel.password,
                    contactModel = newPetshopModel.contactModel,
                    addressModel = newPetshopModel.addressModel
                )

                userCreated.value = true
                usecase.registerPetshop(newUser)
                message.value = "Profile created successfully!"
            }
        }
    }
}