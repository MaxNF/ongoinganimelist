package ru.netfantazii.ongoinganimelist.ui.animelist.paging

import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.netfantazii.ongoinganimelist.data.repository.Result
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchOngoingAnimesUseCase
import javax.inject.Inject

class AnimeDataSource (
    private val scope: CoroutineScope,
    private val fetchOngoingAnimesUseCase: FetchOngoingAnimesUseCase
) :
    PageKeyedDataSource<Int, AnimeShortDetails>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, AnimeShortDetails>
    ) {
        scope.launch {
            val result = fetchOngoingAnimesUseCase(1, params.requestedLoadSize)
            if (result is Result.Success) {
                callback.onResult(result.value, null, 2)
            } else {
                handleError(result)
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, AnimeShortDetails>
    ) {
        scope.launch {
            val result = fetchOngoingAnimesUseCase(params.key, params.requestedLoadSize)
            if (result is Result.Success) {
                val nextKey = params.key + 1
                callback.onResult(result.value, nextKey)
            } else {
                handleError(result)
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, AnimeShortDetails>
    ) {
    }

    private fun <T> handleError(result: Result<T>) {
        when (result) {
            is Result.NetworkError -> {
            }
            is Result.HttpError -> {
            }
        }
    }
}