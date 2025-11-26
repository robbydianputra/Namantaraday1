package com.bagicode.namantaraday1.data.mapper

import com.bagicode.namantaraday1.data.remote.response.LoginResponse
import com.bagicode.namantaraday1.domain.model.User

fun LoginResponse.toUserDomain(): User {
    return User(
        id = this.user?.id ?: 0,
        name = this.user?.name.orEmpty() ,
        username = this.user?.username.orEmpty(),
        image = this.user?.image.orEmpty(),
        token = this.token.orEmpty(),
    )
}