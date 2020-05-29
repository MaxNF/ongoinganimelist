package ru.netfantazii.ongoinganimelist.data.repository

import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository

class AnimeRepositoryImp : AnimeRepository {
    override fun getOngoings(page: Int): List<AnimeShortDetails> {
        TODO("Not yet implemented")
    }

    override fun getAnimeDetails(id: Int): AnimeFullDetails {
        TODO("Not yet implemented")
    }
}