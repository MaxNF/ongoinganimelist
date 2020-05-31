package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate
import java.util.*

@JsonClass(generateAdapter = true)
class AnimeFullDetails(
    id: Int,
    englishName: String?,
    russianName: String?,
    posterUrl: PosterUrl?,
    url: String?,
    kind: Kind?,
    score: Float?,
    status: Status?,
    episodes: Int?,
    episodesAired: Int?,
    airedOn: LocalDate?,
    releasedOn: LocalDate?,
    @field:Json(name = "rating") val rating: Rating?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "genres") val genres: List<Genre>?,
    @field:Json(name = "studios") val studios: List<Studio>?
) : AnimeShortDetails(
    id,
    englishName,
    russianName,
    posterUrl,
    url,
    kind,
    score,
    status,
    episodes,
    episodesAired,
    airedOn,
    releasedOn
)