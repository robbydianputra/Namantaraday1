package com.bagicode.smkn8jakarta.ui.signup

data class SignupUiState(
    val isLoading: Boolean = false,
    val message: String? = null,
    val success: Boolean = false
)