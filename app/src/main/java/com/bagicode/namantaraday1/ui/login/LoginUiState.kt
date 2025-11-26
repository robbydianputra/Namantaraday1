package com.bagicode.smkn8jakarta.ui.signin

data class LoginUiState(
    val isLoading: Boolean = false,
    val message: String? = null,
    val success: Boolean = false
)