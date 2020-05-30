package ru.netfantazii.ongoinganimelist.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import ru.netfantazii.ongoinganimelist.data.repository.AnimeRepositoryImp
import ru.netfantazii.ongoinganimelist.data.source.remote.ShikimoriApi
import ru.netfantazii.ongoinganimelist.di.AppScope
import ru.netfantazii.ongoinganimelist.domain.repository.AnimeRepository

@Module
class ApplicationProvidesModule {

    @AppScope
    @Provides
    fun provideShikimoriApi(): ShikimoriApi = ShikimoriApi.create()

    @AppScope
    @Provides
    fun provideAnimeRepository(api: ShikimoriApi): AnimeRepository =
        AnimeRepositoryImp(api, Dispatchers.IO)
}