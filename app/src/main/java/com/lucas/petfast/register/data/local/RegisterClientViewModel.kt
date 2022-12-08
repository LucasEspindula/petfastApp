package com.lucas.petfast.register.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.petfast.model.ClientModel
import com.lucas.petfast.model.NewClientModel
import com.lucas.petfast.register.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterClientViewModel : ViewModel() {

    private val usecase by lazy {
        RegisterUseCase()
    }

    private val userCreated: MutableLiveData<Boolean> = MutableLiveData(false)
    val userCreatedLiveData: LiveData<Boolean> = userCreated

    private val message: MutableLiveData<String> = MutableLiveData()
    val shouldShowMessage: LiveData<String> = message

    fun registerClient(newClientModel: NewClientModel) {
        viewModelScope.launch {
            if (newClientModel.cpf.isBlank()) {
                message.value = "The CPF field cannot be empty!"
            } else {
                val newUser = ClientModel(
                    cpf = newClientModel.cpf,
                    username = newClientModel.username,
                    password = newClientModel.password,
                    contactModel = newClientModel.contactModel,
                    addressModel = newClientModel.addressModel
                )

                userCreated.value = true
                usecase.registerClient(newUser)
                message.value = "Profile created successfully!"
            }
        }
    }
}