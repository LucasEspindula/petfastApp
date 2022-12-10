package com.lucas.petfast.register.data.local

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucas.petfast.databinding.ActivityRegisterPetshopBinding
import com.lucas.petfast.model.Address
import com.lucas.petfast.model.Contact
import com.lucas.petfast.model.NewPetshopModel
import com.lucas.petfast.products.list.ProductListActivity

class RegisterPetshopActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterPetshopBinding
    private lateinit var viewModel: RegisterPetshopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterPetshopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterPetshopViewModel()

        binding.btRegister.setOnClickListener {
            viewModel.registerPetshop(
                NewPetshopModel(
                    username = binding.etCommercialName.text.toString(),
                    password = binding.etPassword.text.toString(),
                    cnpj = binding.etCnpj.text.toString(),
                    contact = Contact(
                        email = binding.etEmail.text.toString(),
                        telephone = binding.etPhone.text.toString()
                    ),
                    address = Address(
                        city = binding.etCity.text.toString(),
                        district = binding.etDistrict.text.toString(),
                        number = binding.etNumber.text.toString(),
                        road = binding.etRoad.text.toString(),
                        state = binding.etState.text.toString(),
                        zipCode = binding.etZipcode.text.toString(),
                        complement = binding.etComplement.text.toString()
                    )
                )
            )
        }

        viewModel.shouldShowMessage.observe(this) { shouldShow ->
            if (!shouldShow.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    shouldShow,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        viewModel.userCreatedLiveData.observe(this) { userCreated ->
            if (userCreated) {
                Intent(this, ProductListActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}