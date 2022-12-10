package com.lucas.petfast.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.lucas.petfast.databinding.ActivitySplashBinding
import com.lucas.petfast.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            Intent(this, LoginActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }, 3000)
    }
}