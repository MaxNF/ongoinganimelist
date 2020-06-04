package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genre(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val englishName: String,
    @field:Json(name = "russian") val russianName: String
) {
    override fun toString(): String {
        return russianName
    }
}