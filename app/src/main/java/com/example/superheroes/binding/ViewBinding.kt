package com.example.superheroes.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun bindLoadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .fitCenter()
        .into(view)
}

@BindingAdapter("goneIfNotNull")
fun goneIfNotNull(view: View, it: Any?) {
    view.visibility = if (it != null) View.GONE else View.VISIBLE
}

