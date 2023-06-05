package com.example.android_jetpack_compose_instagram.Login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_jetpack_compose_instagram.Login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isEnable = MutableLiveData<Boolean>()
    val isEnable: LiveData<Boolean> = _isEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected() {
        viewModelScope.launch {

            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                Log.i("Test", "It´s working!")
            }
            _isLoading.value = false
        }
    }
}