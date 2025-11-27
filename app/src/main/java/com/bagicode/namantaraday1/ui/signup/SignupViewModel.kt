package com.bagicode.smkn8jakarta.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bagicode.namantaraday1.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SignupUiState())
    val state: StateFlow<SignupUiState> = _state

    fun register(username: String, fullname: String, dateOfBirth: String, password: String) {
        viewModelScope.launch {
            _state.value = SignupUiState(isLoading = true)

            val result = registerUseCase(username, fullname, dateOfBirth, password)

            result.onSuccess { data ->
                _state.value = SignupUiState(
                    isLoading = false,
                    success = true,
                    message = data
                )
            }

            result.onFailure { e ->
                _state.value = SignupUiState(
                    isLoading = false,
                    success = false,
                    message = e.message ?: "Terjadi kesalahan"
                )
            }
        }
    }
}