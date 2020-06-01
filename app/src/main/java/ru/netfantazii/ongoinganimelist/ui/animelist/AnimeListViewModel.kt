package ru.netfantazii.ongoinganimelist.ui.animelist

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchOngoingAnimesUseCase
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeDataSource
import javax.inject.Inject

@FragmentScope
class AnimeListViewModel @Inject constructor(fetchOngoingAnimesUseCase: FetchOngoingAnimesUseCase) :
    ViewModel() {
    val pagedAnimeList: LiveData<PagedList<AnimeShortDetails>>

    init {
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(50)
            .setPageSize(50)
            .setEnablePlaceholders(false)
            .build()

        pagedAnimeList =
            LivePagedListBuilder(object : DataSource.Factory<Int, AnimeShortDetails>() {
                override fun create(): DataSource<Int, AnimeShortDetails> =
                    AnimeDataSource(viewModelScope, fetchOngoingAnimesUseCase)
            }, config).build()
    pagedAnimeList.observeForever { Log.d("Binding", ": TRIGGERED ${it.size}") }
    }
    }