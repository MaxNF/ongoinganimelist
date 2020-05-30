package ru.netfantazii.ongoinganimelist.domain.repository

import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.data.repository.Result

interface AnimeRepository {
    suspend fun getOngoings(page: Int): Result<List<AnimeShortDetails>>
    suspend fun getAnimeDetails(id: Int): Result<AnimeFullDetails>
}