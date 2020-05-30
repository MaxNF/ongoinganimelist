package ru.netfantazii.ongoinganimelist.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.netfantazii.ongoinganimelist.data.source.remote.ShikimoriApi
import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.model.Status
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository

class AnimeRepositoryImp(private val api: ShikimoriApi, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : BaseRepository(), AnimeRepository {
    override suspend fun getOngoings(page: Int): Result<List<AnimeShortDetails>> =
        safeApiCall(dispatcher) { api.getAnimeList(Status.ONGOING.toString()) }

    override suspend fun getAnimeDetails(id: Int): Result<AnimeFullDetails> =
        safeApiCall(dispatcher) { api.getAnime(id) }
}