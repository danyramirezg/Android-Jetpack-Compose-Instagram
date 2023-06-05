package com.example.android_jetpack_compose_instagram.Login.data

import com.example.android_jetpack_compose_instagram.Login.data.network.LoginService

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}