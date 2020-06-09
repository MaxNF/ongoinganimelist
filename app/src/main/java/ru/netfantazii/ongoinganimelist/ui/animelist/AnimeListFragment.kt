package ru.netfantazii.ongoinganimelist.ui.animelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.transition.Hold
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_anime_list.*
import ru.netfantazii.ongoinganimelist.Constants
import ru.netfantazii.ongoinganimelist.databinding.FragmentAnimeListBinding
import ru.netfantazii.ongoinganimelist.di.ViewModelFactory
import ru.netfantazii.ongoinganimelist.domain.model.AnimeCachedData
import ru.netfantazii.ongoinganimelist.extensions.getViewModel
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeListAdapter
import ru.netfantazii.ongoinganimelist.ui.base.BaseFragment
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AnimeListFragment : BaseFragment() {

    @Inject
    lateinit var adapter: AnimeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = Hold()
            .apply { duration = Constants.TRANSITION_DURATION_MS }
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
            postponeEnterTransition()
            animeRecyclerView.apply {
                viewTreeObserver.addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
            }
        }.root
    }

    fun navigateToDetails(viewWithSharedElement: View, animeCachedData: AnimeCachedData) {
        val extras =
            FragmentNavigatorExtras(viewWithSharedElement to viewWithSharedElement.transitionName)
        val action =
            AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailsFragment(
                animeCachedData, viewWithSharedElement.transitionName
            )
        findNavController().navigate(action, extras)
    }
}