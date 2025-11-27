package com.bagicode.namantaraday1.domain.usecase

import com.bagicode.namantaraday1.data.repository.NamantaraRepository
import javax.inject.Inject


class GetTokenUseCase @Inject constructor(
    private val repository: NamantaraRepository
) {
    suspend operator fun invoke(): String {
        return repository.getToken()
    }
}