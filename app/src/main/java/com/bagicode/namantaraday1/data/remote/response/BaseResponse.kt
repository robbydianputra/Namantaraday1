package com.bagicode.namantaraday1.data.remote.response


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    val `data`: T?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?
)