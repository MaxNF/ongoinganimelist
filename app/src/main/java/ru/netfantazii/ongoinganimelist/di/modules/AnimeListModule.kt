package ru.netfantazii.ongoinganimelist.di.modules

import androidx.recyclerview.widget.DiffUtil
import dagger.Binds
import dagger.Module
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeShortDetailsDiffCallback

@Module
abstract class AnimeListModule {
    @Binds
    abstract fun bindDiffCallback(animeShortDetailsDiffCallback: AnimeShortDetailsDiffCallback): DiffUtil.ItemCallback<AnimeShortDetails>
}