package com.bagicode.namantaraday1.domain.usecase

import com.bagicode.namantaraday1.data.mapper.toUserDomain
import com.bagicode.namantaraday1.data.repository.NamantaraRepository
import com.bagicode.namantaraday1.domain.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repo : NamantaraRepository
) {

    suspend operator fun invoke(username: String, password: String) : Result<User> {
        return try {
            val response = repo.login(username, password)
            if (response.status.equals("success") && response.data != null) {
                val user = response.data.toUserDomain()
                Result.success(user)
            } else {
                Result.failure(Exception(response.message))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
