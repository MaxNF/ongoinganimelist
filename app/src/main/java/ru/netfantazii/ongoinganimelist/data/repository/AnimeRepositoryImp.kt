package ru.netfantazii.ongoinganimelist.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.netfantazii.ongoinganimelist.data.source.remote.ShikimoriApi
import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.model.Status
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class AnimeRepositoryImp (
    private val api: ShikimoriApi,
    private val dispatcher: CoroutineDispatcher
) : BaseRepository(), AnimeRepository {
    private val maxPage = 100000
    private val maxAnimeLimit = 50
    override suspend fun getOngoings(page: Int, limit: Int): Result<List<AnimeShortDetails>> {
        if (page < 1 || page > maxPage) throw IllegalArgumentException("Page number should be between 1 and 100000")
        if (limit < 1 || limit > maxAnimeLimit) throw IllegalArgumentException("Anime limit should be between 1 and 50")
        return safeApiCall(dispatcher) { api.getAnimeList(Status.ONGOING.toString(), page, limit) }
    }

    override suspend fun getAnimeDetails(id: Int): Result<AnimeFullDetails> =
        safeApiCall(dispatcher) { api.getAnime(id) }
}