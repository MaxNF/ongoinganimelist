package ru.netfantazii.ongoinganimelist.domain.model

import java.io.Serializable

data class AnimeCachedData(
    val id: Int,
    val englishName: String?,
    val russianName: String?,
    val posterUrl: String?
) : Serializable {
}