package com.example.android_jetpack_compose_instagram.Login.domain

import com.example.android_jetpack_compose_instagram.Login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()
    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}