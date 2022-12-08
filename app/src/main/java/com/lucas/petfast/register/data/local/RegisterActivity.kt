package com.lucas.petfast.register.data.local

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.petfast.databinding.ActivityLoginBinding
import com.lucas.petfast.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRegisterClient.setOnClickListener {
            Intent(this, RegisterClientActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btRegisterPetshop.setOnClickListener {
            Intent(this, RegisterPetshopActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}