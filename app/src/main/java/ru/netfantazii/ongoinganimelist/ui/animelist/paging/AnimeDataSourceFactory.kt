package ru.netfantazii.ongoinganimelist.ui.animelist.paging

import androidx.paging.DataSource
import kotlinx.coroutines.CoroutineScope
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchOngoingAnimesUseCase
import javax.inject.Inject

//class AnimeDataSourceFactory (
//    private val scope: CoroutineScope,
//    private val fetchOngoingAnimesUseCase: FetchOngoingAnimesUseCase
//) : DataSource.Factory<Int, AnimeShortDetails>() {
//
//    override fun create(): DataSource<Int, AnimeShortDetails> {
//        return AnimeDataSource(scope, fetchOngoingAnimesUseCase)
//    }
//}