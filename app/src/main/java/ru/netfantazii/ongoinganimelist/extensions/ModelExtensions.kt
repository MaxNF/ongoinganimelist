package ru.netfantazii.ongoinganimelist.extensions

import android.content.Context
import ru.netfantazii.ongoinganimelist.R
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.domain.model.Kind

fun AnimeShortDetails.isRussianNameAvailable(): Boolean = !this.russianName.isNullOrBlank()

fun AnimeShortDetails.getFormattedKind(context: Context): String {
    val kind = if (this.kind != null) {
        when (this.kind) {
            Kind.MOVIE -> context.getString(R.string.kind_movie)
            Kind.MUSIC -> context.getString(R.string.kind_music)
            Kind.ONA -> context.getString(R.string.kind_ona)
            Kind.OVA -> context.getString(R.string.kind_ova)
            Kind.SPECIAL -> context.getString(R.string.kind_special)
            Kind.TV, Kind.TV_13, Kind.TV_24, Kind.TV_48 -> context.getString(R.string.kind_tv)
        }
    } else {
        context.getString(R.string.kind_unkown)
    }
    return "$kind ${getEpisodeCountIfNotZero(this, context)}".trim()
}

private fun getEpisodeCountIfNotZero(
    animeShortDetails: AnimeShortDetails,
    context: Context
): String {
    val episodesTotal = animeShortDetails.episodes
    val episodesAired = animeShortDetails.episodesAired
    return if (episodesTotal != null && episodesTotal > 0) {
        if (episodesAired != null && episodesTotal - episodesAired > 0) {
            context.getString(R.string.episodes_ongoing, episodesAired, episodesTotal)
        } else {
            context.getString(R.string.episodes_finished, episodesTotal)
        }
    } else {
        ""
    }
}