package ru.netfantazii.ongoinganimelist.ui.animelist.paging

import androidx.recyclerview.widget.DiffUtil
import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import javax.inject.Inject

@FragmentScope
class AnimeShortDetailsDiffCallback @Inject constructor(
) : DiffUtil.ItemCallback<AnimeShortDetails>() {

    override fun areItemsTheSame(oldItem: AnimeShortDetails, newItem: AnimeShortDetails): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: AnimeShortDetails,
        newItem: AnimeShortDetails
    ): Boolean {
        return !(oldItem.airedOn != newItem.airedOn ||
                oldItem.englishName != newItem.englishName ||
                oldItem.episodes != newItem.episodes ||
                oldItem.episodesAired != newItem.episodesAired ||
                oldItem.kind != newItem.kind ||
                oldItem.posterUrl != newItem.posterUrl ||
                oldItem.releasedOn != newItem.releasedOn ||
                oldItem.russianName != newItem.russianName ||
                oldItem.score != newItem.score ||
                oldItem.status != newItem.status)
    }
}