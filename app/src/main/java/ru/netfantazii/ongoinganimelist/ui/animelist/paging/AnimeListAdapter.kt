package ru.netfantazii.ongoinganimelist.ui.animelist.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.netfantazii.ongoinganimelist.databinding.ShortDetailsViewHolderBinding
import ru.netfantazii.ongoinganimelist.di.FragmentScope
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import javax.inject.Inject

class AnimeShortDetailsViewHolder(private val binding: ShortDetailsViewHolderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(animeShortDetails: AnimeShortDetails) {
        binding.animeShortDetails = animeShortDetails
        binding.executePendingBindings()
    }
}

@FragmentScope
class AnimeListAdapter @Inject constructor(diffCallback: DiffUtil.ItemCallback<AnimeShortDetails>) :
    PagedListAdapter<AnimeShortDetails, AnimeShortDetailsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeShortDetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ShortDetailsViewHolderBinding.inflate(layoutInflater, parent, false)
        return AnimeShortDetailsViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: AnimeShortDetailsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}