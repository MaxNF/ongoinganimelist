package ru.netfantazii.ongoinganimelist.binding

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ru.netfantazii.ongoinganimelist.ui.animedetails.AnimeDetailsFragment
import java.lang.IllegalStateException

@BindingAdapter("app:loadImage")
fun bindLoadImage(view: ImageView, url: String?) {
//    return

    if (url == null) {
        //TODO("add placeholder image")
    } else {
        Glide.with(view).load(url)
            .into(view)
    }
}

@BindingAdapter("app:toast")
fun bindToast(view: View, message: LiveData<String>) {
    if (message.value != null) {
        val context = view.context
        Toast.makeText(context, message.value, Toast.LENGTH_LONG).show()
    }
}