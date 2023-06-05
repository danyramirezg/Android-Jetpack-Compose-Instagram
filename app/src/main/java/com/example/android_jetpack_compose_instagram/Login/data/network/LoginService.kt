package com.example.android_jetpack_compose_instagram.Login.data.network

import com.example.android_jetpack_compose_instagram.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// This class calls the interface LoginClient
class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false
        }
    }
}