package ru.netfantazii.ongoinganimelist.domain.usecase

import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository
import javax.inject.Inject

@FragmentScope
class FetchOngoingAnimesUseCase @Inject constructor(private val repository: AnimeRepository) {
    suspend operator fun invoke(page: Int, limit: Int) = repository.getOngoings(page, limit)
}