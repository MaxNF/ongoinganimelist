package ru.netfantazii.ongoinganimelist.domain.repository

import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails

interface AnimeRepository {
    fun getOngoings(page: Int): List<AnimeShortDetails>
    fun getAnimeDetails(id: Int): AnimeFullDetails
}