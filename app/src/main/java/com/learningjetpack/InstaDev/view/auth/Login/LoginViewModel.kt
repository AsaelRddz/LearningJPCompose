package com.learningjetpack.InstaDev.view.auth.Login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        // actualizar los valores
        _uiState.update { state ->
            // como es val el modelo y no puedo variar
            // se copia el objeto y se cambia
            state.copy(email = email)
        }

        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }

        verifyLogin()
    }

    private fun verifyLogin() {
        val enabledLogin =
            isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)

        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)