package ru.netfantazii.ongoinganimelist.binding

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("app:loadImage")
fun bindLoadImage(view: ImageView, url: String?) {
    if (url == null) {
        //TODO("add placeholder image")
    } else {
        Log.d("GLIDE", "URL: $url")
        Glide.with(view).load(url).into(view)
    }
}

@BindingAdapter("app:toast")
fun bindToast(view: View, message: LiveData<String>) {
    if (message.value != null) {
        val context = view.context
        Toast.makeText(context, message.value, Toast.LENGTH_LONG).show()
    }
}