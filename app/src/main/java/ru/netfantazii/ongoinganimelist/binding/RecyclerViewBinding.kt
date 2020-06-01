package ru.netfantazii.ongoinganimelist.binding

import android.content.Context
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netfantazii.ongoinganimelist.domain.model.AnimeShortDetails
import ru.netfantazii.ongoinganimelist.ui.animelist.paging.AnimeListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: AnimeListAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterPagedList")
fun bindAdapterPagedList(view: RecyclerView, pagedList : PagedList<AnimeShortDetails>?) {
        (view.adapter as AnimeListAdapter).submitList(pagedList)
}