package ru.netfantazii.ongoinganimelist.ui.animelist.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.netfantazii.ongoinganimelist.databinding.ItemAnimeShortBinding
import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.ui.animelist.AnimeListFragment
import ru.netfantazii.ongoinganimelist.ui.animelist.AnimeListFragmentDirections
import javax.inject.Inject

class AnimeShortDetailsViewHolder(private val binding: ItemAnimeShortBinding) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {
    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(animeShortDetails: AnimeShortDetails) {
        binding.anime = animeShortDetails
        binding.executePendingBindings()
    }

    override fun onClick(v: View) {
        val fragment = v.findFragment<AnimeListFragment>()
        val anime = binding.anime
        anime?.let {
            val action =
                AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailsFragment(it.id)
            fragment.findNavController().navigate(action)
        }
    }
}

@FragmentScope
class AnimeListAdapter @Inject constructor(diffCallback: DiffUtil.ItemCallback<AnimeShortDetails>) :
    PagedListAdapter<AnimeShortDetails, AnimeShortDetailsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeShortDetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimeShortBinding.inflate(layoutInflater, parent, false)
        return AnimeShortDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeShortDetailsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}