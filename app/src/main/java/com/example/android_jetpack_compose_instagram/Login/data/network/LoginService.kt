package com.example.android_jetpack_compose_instagram.Login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.math.log

// This class calls the interface LoginClient
class LoginService @Inject constructor(private val loginClient: LoginClient){

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}