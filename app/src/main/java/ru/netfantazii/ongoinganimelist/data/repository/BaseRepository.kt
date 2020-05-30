package ru.netfantazii.ongoinganimelist.data.repository

import com.squareup.moshi.Moshi
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

data class ErrorResponse(
    val error_description: String,
    val causes: Map<String, String> = emptyMap()
)

sealed class Result<out T> {
    data class Success<out T>(val value: T): Result<T>()
    data class HttpError(val code: Int? = null, val error: ErrorResponse?): Result<Nothing>()
    object NetworkError: Result<Nothing>()
}

open class BaseRepository {
    private val TAG = "BaseRepository"

    suspend fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Result<T> {
        return withContext(dispatcher) {
            try {
                Result.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> Result.NetworkError
                    is HttpException -> {
                        val code = throwable.code()
                        val errorResponse = convertErrorBody(throwable)
                        Result.HttpError(code, errorResponse)
                    }
                    else -> {
                        Result.HttpError(null, null)
                    }
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
        return try {
            throwable.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (exception: Exception) {
            null
        }
    }
}