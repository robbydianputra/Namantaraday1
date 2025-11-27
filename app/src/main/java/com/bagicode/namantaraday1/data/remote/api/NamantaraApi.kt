package com.bagicode.namantaraday1.data.remote.api

import com.bagicode.namantaraday1.data.remote.response.BaseResponse
import com.bagicode.namantaraday1.data.remote.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NamantaraApi {

    @FormUrlEncoded
    @POST("auth/login.php")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : BaseResponse<LoginResponse>

    @FormUrlEncoded
    @POST("auth/register.php")
    suspend fun register(
        @Field("username") username: String,
        @Field("fullname") fullname: String,
        @Field("dateOfBirth") dateOfBirth: String,
        @Field("password") password: String
    ): BaseResponse<Any>
}