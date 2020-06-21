package ru.netfantazii.ongoinganimelist.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import ru.netfantazii.ongoinganimelist.R

@BindingAdapter("app:setUpNavigationIcon", "app:setUpHomeIcon")
fun bindToolbar(toolbar: MaterialToolbar, navigationDrawable: Drawable?, homeDrawable: Drawable?) {
    val fragment = toolbar.findFragment<Fragment>()
    val navController = fragment.findNavController()
    if (navController.currentDestination?.id == R.id.animeListFragment) {
        toolbar.navigationIcon = homeDrawable
    } else {
        toolbar.navigationIcon = navigationDrawable
    }
    toolbar.setNavigationOnClickListener {
        navController.navigateUp()
    }
}

@BindingAdapter("app:toast")
fun bindToast(view: View, message: LiveData<String>) {
    if (message.value != null) {
        val context = view.context
        Toast.makeText(context, message.value, Toast.LENGTH_LONG).show()
    }
}