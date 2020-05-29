package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate
import java.util.*

@JsonClass(generateAdapter = true)
open class AnimeShortDetails(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val englishName: String,
    @field:Json(name = "russian") val russianName: String,
    @field:Json(name = "image") val posterUrl: PosterUrl,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "kind") val kind: Kind,
    @field:Json(name = "score") val score: Float,
    @field:Json(name = "status") val status: Status,
    @field:Json(name = "episodes") val episodes: Int,
    @field:Json(name = "episodes_aired") val episodesAired: Int,
    @field:Json(name = "aired_on") val airedOn: LocalDate,
    @field:Json(name = "released_on") val releasedOn: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AnimeShortDetails) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}