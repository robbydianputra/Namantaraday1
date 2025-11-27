package com.bagicode.namantaraday1.data.repository

import com.bagicode.namantaraday1.data.remote.api.NamantaraApi
import com.bagicode.namantaraday1.data.remote.response.BaseResponse
import com.bagicode.namantaraday1.data.remote.response.LoginResponse
import javax.inject.Inject

class NamantaraRepository @Inject constructor(
    private val api: NamantaraApi
) {
    suspend fun login(username: String, password: String): BaseResponse<LoginResponse> {
        return api.login(username, password)
    }

    suspend fun register(username: String, fullname: String, dateOfBirth: String, password: String): BaseResponse<Any> {
        return api.register(username, fullname, dateOfBirth, password)
    }


}