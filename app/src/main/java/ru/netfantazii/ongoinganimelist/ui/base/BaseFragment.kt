package ru.netfantazii.ongoinganimelist.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.netfantazii.ongoinganimelist.di.ViewModelFactory
import javax.inject.Inject

open class BaseFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}