package ru.netfantazii.ongoinganimelist.ui.animelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchOngoingAnimesUseCase
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeDataSource
import javax.inject.Inject

class AnimeListViewModel @Inject constructor(fetchOngoingAnimesUseCase: FetchOngoingAnimesUseCase) :
    ViewModel() {
    val pagedAnimeList: LiveData<PagedList<AnimeShortDetails>>

    init {
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(40)
            .setPageSize(20)
            .setEnablePlaceholders(false)
            .build()
        pagedAnimeList =
            LivePagedListBuilder(object : DataSource.Factory<Int, AnimeShortDetails>() {
                override fun create(): DataSource<Int, AnimeShortDetails> =
                    AnimeDataSource(viewModelScope, fetchOngoingAnimesUseCase)
            }, config).build()
    }
}