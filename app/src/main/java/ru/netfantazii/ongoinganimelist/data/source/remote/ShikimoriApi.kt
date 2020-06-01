package ru.netfantazii.ongoinganimelist.data.source.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails

interface ShikimoriApi {
    companion object {
        const val baseUrl = "https://shikimori.one"
        private const val apiBaseUrl = "https://shikimori.one/api/"
        fun create(): ShikimoriApi {
            val logging =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            val moshi = Moshi.Builder()
                .add(AnimeDetailsAdapter())
                .add(KotlinJsonAdapterFactory())
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .client(httpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
            return retrofit.create(ShikimoriApi::class.java)
        }
    }

    @GET("animes")
    suspend fun getAnimeList(
        @Query("status") status: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<AnimeShortDetails>

    @GET("animes/{id}")
    suspend fun getAnime(@Path("id") animeId: Int): AnimeFullDetails
}