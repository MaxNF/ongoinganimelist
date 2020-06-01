package ru.netfantazii.ongoinganimelist.ui.animedetails

import androidx.lifecycle.ViewModel
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchAnimeFullDetailsUseCase
import javax.inject.Inject

class AnimeDetailsViewModel @Inject constructor(fetchAnimeFullDetailsUseCase: FetchAnimeFullDetailsUseCase) : ViewModel() {
}