package com.bagicode.namantaraday1.domain.usecase

import com.bagicode.namantaraday1.data.repository.NamantaraRepository
import javax.inject.Inject
import kotlin.text.equals

class RegisterUseCase @Inject constructor(
    private val repository: NamantaraRepository
) {

    suspend operator fun invoke(username: String, fullname: String, dateOfBirth: String, password: String): Result<String?> {
        return try {
            val response = repository.register(username, fullname, dateOfBirth, password)

            if (response.status.equals("success")) {
                Result.success(response.message)
            } else {
                Result.failure(Exception(response.message))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}