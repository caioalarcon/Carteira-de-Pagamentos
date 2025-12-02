package com.example.carteiradepagamentos.data.remote

import com.example.carteiradepagamentos.domain.service.AuthorizeService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkAuthorizeService @Inject constructor(
    private val api: AuthorizeApi
) : AuthorizeService {

    override suspend fun authorizeTransfer(amountInCents: Long): Result<Boolean> {
        return try {
            val value = amountInCents / 100.0
            val response = api.authorize(AuthorizeRequest(value = value))
            if (response.authorized) {
                Result.success(true)
            } else {
                val message = response.reason ?: "operation not allowed"
                Result.failure(IllegalStateException(message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
