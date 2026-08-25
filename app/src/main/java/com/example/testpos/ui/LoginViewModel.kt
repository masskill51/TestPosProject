package com.example.testpos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testpos.data.AuthResponse
import com.example.testpos.data.LoginRequest
import com.example.testpos.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val authResponse: AuthResponse? = null
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginState(isLoading = true)
            try {
                val response = RetrofitClient.instance.login(LoginRequest(username, password))
                _uiState.value = LoginState(authResponse = response)
            } catch (e: Exception) {
                _uiState.value = LoginState(error = "Login failed: ${e.message}")
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
