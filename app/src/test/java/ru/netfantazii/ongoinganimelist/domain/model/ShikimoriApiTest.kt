package ru.netfantazii.ongoinganimelist.domain.model

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import ru.netfantazii.ongoinganimelist.data.source.remote.ShikimoriApi

class ShikimoriApiTest {

    private lateinit var shikimoriApi: ShikimoriApi

    @Before
    fun createApi() {
        shikimoriApi = ShikimoriApi.create()
    }

    @Test
    fun getAnimeOngoingsListTest_ListOfAnimeShortDetailsCreated() {
        val list = runBlocking { shikimoriApi.getAnimeList(Status.ONGOING.toString(), 1, 20) }
        assertThat(list).hasSize(20)
    }

    @Test
    fun getAnimeWithIdTest_AnimeFullDetailsCreated() {
        val anime = runBlocking { shikimoriApi.getAnime(1) }
        assertThat(anime).isNotNull()
    }
}