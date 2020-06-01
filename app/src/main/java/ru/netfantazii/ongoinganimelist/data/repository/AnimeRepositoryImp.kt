package ru.netfantazii.ongoinganimelist.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import ru.netfantazii.ongoinganimelist.data.source.remote.ShikimoriApi
import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.model.Status
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository
import java.lang.IllegalArgumentException

class AnimeRepositoryImp(
    private val api: ShikimoriApi,
    private val dispatcher: CoroutineDispatcher
) : BaseRepository(), AnimeRepository {
    private val maxPage = 100000
    private val maxAnimeLimit = 50
    override suspend fun getOngoings(page: Int, limit: Int): Result<List<AnimeShortDetails>> {
        if (page < 1 || page > maxPage) throw IllegalArgumentException("Page number should be between 1 and 100000")
        if (limit < 1 || limit > maxAnimeLimit) throw IllegalArgumentException("Anime limit should be between 1 and 50")
        return safeApiCall(dispatcher) {
            val animes = api.getAnimeList(Status.ONGOING.toString(), page, limit)
            animes.forEach { appendBaseUrl(it) }
            animes
        }
    }

    override suspend fun getAnimeDetails(id: Int): Result<AnimeFullDetails> =
        safeApiCall(dispatcher) {
            val animes = api.getAnime(id)
            appendBaseUrl(animes)
            animes
        }

    private fun appendBaseUrl(animeShortDetails: AnimeShortDetails) {
        val poster = animeShortDetails.poster
        val baseUrl = ShikimoriApi.baseUrl
        poster?.let {
            it.originalSizeUrl = appendBefore(it.originalSizeUrl, baseUrl)
            it.previewSizeUrl = appendBefore(it.previewSizeUrl, baseUrl)
            it.x48SizeUrl = appendBefore(it.x48SizeUrl, baseUrl)
            it.x96SizeUrl = appendBefore(it.x96SizeUrl, baseUrl)
        }
    }

    @Suppress("SameParameterValue")
    private fun appendBefore(s: String, appendix: String): String = appendix + s
}