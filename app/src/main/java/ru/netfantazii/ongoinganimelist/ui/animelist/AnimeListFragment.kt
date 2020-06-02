package ru.netfantazii.ongoinganimelist.ui.animelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeListBinding
import ru.netfantazii.ongoinganimelist.di.ViewModelFactory
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeListAdapter
import ru.netfantazii.ongoinganimelist.ui.base.BaseFragment
import javax.inject.Inject

class AnimeListFragment : BaseFragment() {

    @Inject
    lateinit var adapter: AnimeListAdapter

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

    fun navigateToDetails(animeId: Int) {
        val action =
            AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailsFragment(animeId)
        this.findNavController().navigate(action)
    }
}