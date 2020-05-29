package ru.netfantazii.ongoinganimelist.data.source.remote

import com.squareup.moshi.Moshi
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory

interface ShikimoriApi {
    companion object {
        fun create() {

        }

        private fun create(httpUrl: HttpUrl) {
            val logging =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            val converter = Moshi.Builder()


        }
    }
}