package ru.netfantazii.ongoinganimelist.ui.animedetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import ru.netfantazii.ongoinganimelist.Constants
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeDetailsBinding
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.base.BaseFragment

class AnimeDetailsFragment : BaseFragment() {

    private val args by navArgs<AnimeDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = Constants.TRANSITION_DURATION_MS
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAnimeDetailsBinding.inflate(inflater, container, false).apply {
            viewModel = getViewModel<AnimeDetailsViewModel>(factory).apply { getAnime(args.animeCachedData.id) }
            lifecycleOwner = this@AnimeDetailsFragment
            detailsRoot.transitionName = args.transitionName
            animeCachedData = args.animeCachedData
        }.root
    }
}