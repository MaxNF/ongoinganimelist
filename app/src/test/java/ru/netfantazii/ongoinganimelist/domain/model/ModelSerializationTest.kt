package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Moshi
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ru.netfantazii.ongoinganimelist.data.source.remote.AnimeDetailsAdapter


class ModelSerializationTest {

    private val converter = Moshi.Builder()
        .add(AnimeDetailsAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    @Test
    fun jsonToAnimeShortDetailsTest_objectCreatedFieldsAssignedCorrectly() {
        val animeShortDetailsAdapter = converter.adapter(AnimeShortDetails::class.java)
        val animeShortDetails = animeShortDetailsAdapter.fromJson(JsonTestStrings.jsonShortDetailsString)!!
        assertThat(animeShortDetails.id).isEqualTo(6505)
        assertThat(animeShortDetails.englishName).isEqualTo("There She Is!!")
        assertThat(animeShortDetails.russianName).isEqualTo("А вот и она!")
        assertThat(animeShortDetails.poster?.originalSizeUrl).isEqualTo("/system/animes/original/6505.jpg?1577456413")
        assertThat(animeShortDetails.poster?.previewSizeUrl).isEqualTo("/system/animes/preview/6505.jpg?1577456413")
        assertThat(animeShortDetails.poster?.x96SizeUrl).isEqualTo("/system/animes/x96/6505.jpg?1577456413")
        assertThat(animeShortDetails.poster?.x48SizeUrl).isEqualTo("/system/animes/x48/6505.jpg?1577456413")
        assertThat(animeShortDetails.url).isEqualTo("/animes/6505-there-she-is")
        assertThat(animeShortDetails.kind).isEqualTo(Kind.ONA)
        assertThat(animeShortDetails.score).isEqualTo(7.95f)
        assertThat(animeShortDetails.status).isEqualTo(Status.RELEASED)
        assertThat(animeShortDetails.episodes).isEqualTo(5)
        assertThat(animeShortDetails.episodesAired).isEqualTo(0)
        assertThat(animeShortDetails.airedOn).isEqualTo(JsonTestStrings.correctAiredOnDate)
        assertThat(animeShortDetails.releasedOn).isEqualTo(JsonTestStrings.correctReleasedOnDate)
    }

    @Test
    fun jsonToAnimeFullDetailsTest_objectCreatedFieldsAssignedCorrectly() {
        val animeFullDetailsAdapter = converter.adapter(AnimeFullDetails::class.java)
        val animeFullDetails = animeFullDetailsAdapter.fromJson(JsonTestStrings.jsonFullDetailsString)!!
        assertThat(animeFullDetails.id).isEqualTo(6505)
        assertThat(animeFullDetails.englishName).isEqualTo("There She Is!!")
        assertThat(animeFullDetails.russianName).isEqualTo("А вот и она!")
        assertThat(animeFullDetails.poster?.originalSizeUrl).isEqualTo("/system/animes/original/6505.jpg?1577456413")
        assertThat(animeFullDetails.poster?.previewSizeUrl).isEqualTo("/system/animes/preview/6505.jpg?1577456413")
        assertThat(animeFullDetails.poster?.x96SizeUrl).isEqualTo("/system/animes/x96/6505.jpg?1577456413")
        assertThat(animeFullDetails.poster?.x48SizeUrl).isEqualTo("/system/animes/x48/6505.jpg?1577456413")
        assertThat(animeFullDetails.url).isEqualTo("/animes/6505-there-she-is")
        assertThat(animeFullDetails.kind).isEqualTo(Kind.ONA)
        assertThat(animeFullDetails.score).isEqualTo(7.95f)
        assertThat(animeFullDetails.status).isEqualTo(Status.RELEASED)
        assertThat(animeFullDetails.episodes).isEqualTo(5)
        assertThat(animeFullDetails.episodesAired).isEqualTo(0)
        assertThat(animeFullDetails.airedOn).isEqualTo(JsonTestStrings.correctAiredOnDate)
        assertThat(animeFullDetails.releasedOn).isEqualTo(JsonTestStrings.correctReleasedOnDate)
        assertThat(animeFullDetails.description).isEqualTo("История разворачивается вокруг крольчихи Докхи, встретившей и полюбившей кота Наби. Общество в этом мире не приемлет отношений между разными видами, и Наби решительно отвергает Докхи. Но любовь всегда найдёт свою дорогу, и видя, как сильны чувства девушки и что она настроена решительно, Наби в конце концов сдаётся и, несмотря на всеобщее осуждение, даёт Докхи шанс, найдя и в ней что-то привлекательное для себя.")
        assertThat(animeFullDetails.rating).isEqualTo(Rating.G)
        assertThat(animeFullDetails.genres?.size).isEqualTo(2)
        assertThat(animeFullDetails.genres?.get(0)?.id ).isEqualTo(4)
        assertThat(animeFullDetails.genres?.get(0)?.englishName).isEqualTo("Comedy")
        assertThat(animeFullDetails.genres?.get(0)?.russianName).isEqualTo("Комедия")
        assertThat(animeFullDetails.genres?.get(1)?.id).isEqualTo(22)
        assertThat(animeFullDetails.genres?.get(1)?.englishName).isEqualTo("Romance")
        assertThat(animeFullDetails.genres?.get(1)?.russianName).isEqualTo("Романтика")
        assertThat(animeFullDetails.studios?.size).isEqualTo(1)
        assertThat(animeFullDetails.studios?.get(0)?.id).isEqualTo(341)
        assertThat(animeFullDetails.studios?.get(0)?.name).isEqualTo("SamBakZa")
        assertThat(animeFullDetails.studios?.get(0)?.filteredName).isEqualTo("SamBakZa")
    }
}