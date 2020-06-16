package ru.netfantazii.ongoinganimelist.binding

import android.graphics.Color
import android.transition.PathMotion
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.transition.ArcMotion
import com.bumptech.glide.Glide
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform

@BindingAdapter("app:loadImage")
fun bindLoadImage(view: ImageView, url: String?) {
    if (url == null) {
        //TODO("add placeholder image")
    } else {
        Glide.with(view).load(url)
            .into(view)
    }
}

@BindingAdapter("app:customBackground")
fun bindBackground(view: View, color: Int) {
    view.setBackgroundColor(color)
}

@BindingAdapter("app:transformFromView", "app:transformToView")
fun bindViewTransformation(container: ViewGroup, firstView: View, secondView: View) {
    firstView.setOnClickListener {
        TransitionManager.beginDelayedTransition(
            container,
            getTransformation(firstView, secondView)
        )
        firstView.visibility = View.INVISIBLE
        secondView.visibility = View.VISIBLE
    }
    secondView.setOnClickListener {
        TransitionManager.beginDelayedTransition(
            container,
            getTransformation(secondView, firstView)
        )
        secondView.visibility = View.INVISIBLE
        firstView.visibility = View.VISIBLE
    }
}

private fun getTransformation(fromView: View, toView: View) = MaterialContainerTransform().apply {
    startView = fromView
    endView = toView
    duration = 650
    pathMotion = MaterialArcMotion()
    scrimColor = Color.TRANSPARENT
}