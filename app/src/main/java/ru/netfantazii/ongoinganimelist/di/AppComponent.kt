package ru.netfantazii.ongoinganimelist.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.netfantazii.ongoinganimelist.AnimeApplication
import ru.netfantazii.ongoinganimelist.di.modules.ApplicationModule
import javax.inject.Singleton

@AppScope
@Component(modules = [ApplicationModule::class, AndroidInjectionModule::class, ViewModelBuilder::class])
interface AppComponent {
    fun inject(app: AnimeApplication)
}