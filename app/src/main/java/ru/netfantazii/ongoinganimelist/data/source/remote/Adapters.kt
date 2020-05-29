package ru.netfantazii.ongoinganimelist.data.source.remote

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.lang.NumberFormatException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

class AnimeDetailsAdapter {
    @FromJson
    fun stringToFloat(s: String): Float {
        return try {
            s.toFloat()
        } catch (e: NumberFormatException) {
            -1f
        }
    }

    @ToJson
    fun floatToString(f: Float) = f.toString()

    @FromJson
    fun stringToDate(s: String): LocalDate {
        return try {
            LocalDate.parse(s, DateTimeFormatter.ISO_DATE)
        } catch (e: DateTimeParseException) {
            LocalDate.MIN
        }
    }

    @ToJson
    fun dateToString(d: LocalDate) = d.toString()
}