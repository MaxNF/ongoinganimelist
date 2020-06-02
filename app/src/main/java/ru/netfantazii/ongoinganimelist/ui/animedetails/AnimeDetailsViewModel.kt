package ru.netfantazii.ongoinganimelist.ui.animedetails

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.netfantazii.ongoinganimelist.R
import ru.netfantazii.ongoinganimelist.data.repository.Result
import ru.netfantazii.ongoinganimelist.domain.model.AnimeFullDetails
import ru.netfantazii.ongoinganimelist.domain.usecase.FetchAnimeFullDetailsUseCase
import javax.inject.Inject

class AnimeDetailsViewModel @Inject constructor(
    private val applicationContext: Context,
    private val fetchAnimeFullDetailsUseCase: FetchAnimeFullDetailsUseCase
) :
    ViewModel() {
    val animeLiveData: MutableLiveData<AnimeFullDetails> = MutableLiveData()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    fun getAnime(id: Int) {
        viewModelScope.launch {
            when (val result = fetchAnimeFullDetailsUseCase(id)) {
                is Result.Success -> animeLiveData.postValue(result.value)
                is Result.HttpError -> toastLiveData.postValue(
                    applicationContext.getString(
                        R.string.http_error,
                        result.code
                    )
                )
                is Result.NetworkError -> toastLiveData.postValue(applicationContext.getString(R.string.network_error))
            }
        }
    }
}