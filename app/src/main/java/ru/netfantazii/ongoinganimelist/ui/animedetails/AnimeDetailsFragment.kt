package ru.netfantazii.ongoinganimelist.ui.animedetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.navArgs
import androidx.transition.ArcMotion
import androidx.transition.Fade
import com.google.android.material.transition.MaterialContainerTransform
import kotlinx.android.synthetic.main.card_details.*
import kotlinx.android.synthetic.main.fragment_anime_details.*
import ru.netfantazii.ongoinganimelist.Constants
import ru.netfantazii.ongoinganimelist.R
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeDetailsBinding
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.base.BaseFragment

class AnimeDetailsFragment : BaseFragment() {
    private val args by navArgs<AnimeDetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
            .apply {
                duration = Constants.TRANSITION_DURATION_MS
                setPathMotion(ArcMotion())
                scrimColor = ContextCompat.getColor(requireContext(), R.color.backgroundColor)
            }
        returnTransition = Fade()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAnimeDetailsBinding.inflate(inflater, container, false).apply {
            viewModel =
                getViewModel<AnimeDetailsViewModel>(factory).apply { getAnime(args.animeCachedData.id) }
            lifecycleOwner = this@AnimeDetailsFragment
            detailsContainer.transitionName = args.transitionName
            animeCachedData = args.animeCachedData
            fab = detailsFab
            details = cardDetails.animeDetails
        }.root
    }
}