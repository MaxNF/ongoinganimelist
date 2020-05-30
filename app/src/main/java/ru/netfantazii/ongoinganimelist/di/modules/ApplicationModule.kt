package ru.netfantazii.ongoinganimelist.di.modules

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.di.ViewModelKey
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.ui.animedetails.AnimeDetailsFragment
import ru.netfantazii.ongoinganimelist.ui.animedetails.AnimeDetailsViewModel
import ru.netfantazii.ongoinganimelist.ui.animelist.AnimeListFragment
import ru.netfantazii.ongoinganimelist.ui.animelist.AnimeListViewModel
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeShortDetailsDiffCallback

@Module
abstract class ApplicationModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ApplicationProvidesModule::class])
    abstract fun contributeAnimeListInjector(): AnimeListFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ApplicationProvidesModule::class])
    abstract fun contributeAnimeDetailsInjector(): AnimeDetailsFragment

    @Binds
    abstract fun bindDiffCallback(animeShortDetailsDiffCallback: AnimeShortDetailsDiffCallback): DiffUtil.ItemCallback<AnimeShortDetails>

    @Binds
    @IntoMap
    @ViewModelKey(AnimeListViewModel::class)
    abstract fun bindAnimeListViewModel(animeListViewModel: AnimeListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnimeDetailsViewModel::class)
    abstract fun bindAnimeDetailsViewModel(animeDetailsViewModel: AnimeDetailsViewModel): ViewModel
}