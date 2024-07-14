package com.app.clean_architecture_kotlin.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.app.clean_architecture_kotlin.R
import com.app.clean_architecture_kotlin.databinding.ActivityLoginBinding
import com.app.clean_architecture_kotlin.presentation.viewmodel.LoginViewModel
import com.app.clean_architecture_kotlin.utils.extension.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        getObservers()
        clickListeners()
    }

    private fun initViews() {
        loginViewModel._waitForServer.value = false
        loginViewModel.waitForServer.observe(this) {
            if (it) {
                binding.progressBar.beVisible()
                binding.loginBtn.isEnabled = false
            } else {
                binding.progressBar.beGone()
                binding.loginBtn.isEnabled = true
            }
        }
        loginViewModel.apiErrorToast.observe(this) { error ->
            toast(error.toString())
        }
    }

    private fun getObservers() {
        lifecycleScope.launch(Dispatchers.Main) {
            loginViewModel.loginUserDataFlow.collect { data ->
                prefs.authToken = data.token.toString()
                toast("Logged in")
                startActivity(Intent(this@LoginActivity, MainActivity::class.java)).apply { finish() }
            }
        }
    }

    private fun clickListeners() {
        binding.loginBtn.setOnClickListener {
            if (isValidate()) {
                loginViewModel.loginUser(
                    binding.etUsername.text.toString(), binding.etPassword.text.toString()
                )
            }
        }
    }

    private fun isValidate(): Boolean {
        if (binding.etUsername.text!!.isEmpty() || binding.etUsername.text!!.isBlank()) {
            toast(getString(R.string.enter_username))
            return false
        }else if (binding.etPassword.text!!.isEmpty() || binding.etPassword.text!!.isBlank()) {
            toast(getString(R.string.enter_password))
            return false
        } else if (binding.etPassword.text!!.length < 8) {
            toast(getString(R.string.password_too_short))
            return false
        } else if (!isInternetAvailable()) {
            toast(getString(R.string.internet_not_available))
            return false
        } else {
            return true
        }
    }
}