package com.lucas.petfast.register.data.local

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucas.petfast.databinding.ActivityRegisterClientBinding
import com.lucas.petfast.model.Address
import com.lucas.petfast.model.Contact
import com.lucas.petfast.model.NewClientModel
import com.lucas.petfast.products.list.ProductListActivity

class RegisterClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterClientBinding
    private lateinit var viewModel: RegisterClientViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterClientViewModel()

        binding.btRegister.setOnClickListener {
            viewModel.registerClient(
                NewClientModel(
                    username = binding.etUsername.text.toString(),
                    password = binding.etPassword.text.toString(),
                    cpf = binding.etCpf.text.toString(),
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
                }
            }
        }
    }
}