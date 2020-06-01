package ru.netfantazii.ongoinganimelist.extensions

import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails

fun AnimeShortDetails.isRussianNameAvailable(): Boolean = !this.russianName.isNullOrBlank()