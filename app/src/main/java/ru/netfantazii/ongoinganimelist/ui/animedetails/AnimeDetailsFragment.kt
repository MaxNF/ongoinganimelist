package ru.netfantazii.ongoinganimelist.ui.animedetails

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeDetailsBinding
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeListBinding
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.base.BaseFragment

class AnimeDetailsFragment : BaseFragment() {

    private val args by navArgs<AnimeDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAnimeDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = getViewModel<AnimeDetailsViewModel>(factory).apply { getAnime(args.animeId) }
            lifecycleOwner = this@AnimeDetailsFragment
            Log.d("BCLICK", "NEWF: ")
        }.root
    }
}