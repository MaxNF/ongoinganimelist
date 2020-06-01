package ru.netfantazii.ongoinganimelist.binding

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("app:loadImage")
fun bindLoadImage(view: ImageView, url: String?) {
    if (url == null) {
        //TODO("add placeholder image")
    } else {
        Glide.with(view).load(url).into(view)
    }
}