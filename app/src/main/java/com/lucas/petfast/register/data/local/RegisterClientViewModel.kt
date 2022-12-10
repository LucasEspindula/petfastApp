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
                message.value = "CPF não pode ser vazio."
            } else if (newClientModel.username.isBlank()) {
                message.value = "Nome de usuário não pode ser vazio."
            } else if (newClientModel.password.isBlank()) {
                message.value = "Senha não pode ser vazia."
            } else if (newClientModel.address.city.isBlank()) {
                message.value = "Cidade não pode ser vazia."
            } else if (newClientModel.address.number.isBlank()) {
                message.value = "Número de endereço não pode ser vazio."
            } else if (newClientModel.address.road.isBlank()) {
                message.value = "Nome da rua não pode ser vazia."
            } else if (newClientModel.address.district.isBlank()) {
                message.value = "Bairro residêncial não pode ser vazio."
            } else if (newClientModel.address.state.isBlank()) {
                message.value = "Estado residente não pode ser vazio."
            } else if (newClientModel.address.zipCode.isBlank()) {
                message.value = "CEP não pode ser vazio."
            } else {
                val newUser = ClientModel(
                    cpf = newClientModel.cpf,
                    username = newClientModel.username,
                    password = newClientModel.password,
                    contact = newClientModel.contact,
                    address = newClientModel.address
                )

                userCreated.value = true
                usecase.registerClient(newUser)
                message.value = "Profile created successfully!"
            }
        }
    }
}