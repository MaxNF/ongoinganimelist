package ru.netfantazii.ongoinganimelist.ui.animelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeListBinding
import ru.netfantazii.ongoinganimelist.di.ViewModelFactory
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeListAdapter
import javax.inject.Inject

class AnimeListFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var adapter: AnimeListAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAnimeListBinding.inflate(inflater, container, false).apply {
            adapter = this@AnimeListFragment.adapter
            viewModel = getViewModel(factory)
            lifecycleOwner = this@AnimeListFragment
        }.root
    }
}