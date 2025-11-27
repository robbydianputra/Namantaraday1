package com.bagicode.namantaraday1.ui.signup

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bagicode.namantaraday1.databinding.ActivitySignupBinding
import com.bagicode.smkn8jakarta.ui.signup.SignupViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.tvSignin.setOnClickListener {
            finish()
        }

        binding.btnSignup.setOnClickListener {
            viewModel.register("robby", "robby d", "2 Jan 1997", "123456")
        }

        lifecycleScope.launch {
            viewModel.state.collect { ui ->
                if (ui.isLoading) {
                    Toast.makeText(this@SignupActivity, "Loading...", Toast.LENGTH_SHORT).show()
                }

                ui.message?.let {
                    Toast.makeText(this@SignupActivity, it, Toast.LENGTH_SHORT).show()
                }

                if (ui.success) {
                    finish()
                }
            }
        }
    }
}