package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Poster(
    @Json(name = "original") var originalSizeUrl: String,
    @Json(name = "preview") var previewSizeUrl: String,
    @Json(name = "x96") var x96SizeUrl: String,
    @Json(name = "x48") var x48SizeUrl: String
)