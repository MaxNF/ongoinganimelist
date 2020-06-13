package ru.netfantazii.ongoinganimelist.binding

import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

@BindingAdapter("app:connectWithNavigation")
fun bindToolbar(toolbar: MaterialToolbar, connect: Boolean) {
    if (connect) {
        val navController = toolbar.findFragment<Fragment>().findNavController()
        toolbar.setupWithNavController(navController)
    }
}

@BindingAdapter("app:toast")
fun bindToast(view: View, message: LiveData<String>) {
    if (message.value != null) {
        val context = view.context
        Toast.makeText(context, message.value, Toast.LENGTH_LONG).show()
    }
}