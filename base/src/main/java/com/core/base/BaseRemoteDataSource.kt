package com.core.base


import com.core.network.exception.Failure
import com.core.network.functional.Either
import retrofit2.Call

open class BaseRemoteDataSource {
    fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            val baseResponse = (transform((response.body() ?: default)) as? BaseResponse)
            when (response.isSuccessful) {
                true -> Either.Success(transform((response.body() ?: default)))
                else -> {
                    val failure = Failure.FeatureError
                    failure.response = response
                    failure.errorMsg = baseResponse?.message
                    Either.Failure(failure)
                }
            }
        } catch (exception: Throwable) {
            Either.Failure(Failure.ServerError)
        }
    }
}
