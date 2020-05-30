package ru.netfantazii.ongoinganimelist.domain.model

import com.squareup.moshi.Json
import java.util.*

enum class Kind {
    @Json(name = "tv")
    TV,

    @Json(name = "movie")
    MOVIE,

    @Json(name = "ova")
    OVA,

    @Json(name = "ona")
    ONA,

    @Json(name = "special")
    SPECIAL,

    @Json(name = "music")
    MUSIC,

    @Json(name = "tv_13")
    TV_13,

    @Json(name = "tv_24")
    TV_24,

    @Json(name = "tv_48")
    TV_48;

    override fun toString(): String {
        return super.toString().toLowerCase(Locale.ROOT)
    }
}

enum class Status {
    @Json(name = "anons")
    ANONS,

    @Json(name = "ongoing")
    ONGOING,

    @Json(name = "released")
    RELEASED;

    override fun toString(): String {
        return super.toString().toLowerCase(Locale.ROOT)
    }
}

enum class Rating {
    @Json(name = "none")
    NONE,

    @Json(name = "g")
    G,

    @Json(name = "pg")
    PG,

    @Json(name = "pg_13")
    PG_13,

    @Json(name = "r")
    R,

    @Json(name = "r_plus")
    R_PLUS,

    @Json(name = "rx")
    RX;

    override fun toString(): String {
        return super.toString().toLowerCase(Locale.ROOT)
    }
}