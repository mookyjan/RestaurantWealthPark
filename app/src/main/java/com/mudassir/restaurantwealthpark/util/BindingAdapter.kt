package com.mudassir.restaurantwealthpark.util

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mudassir.restaurantwealthpark.R


@BindingAdapter("android:src")
    fun bindingImage(imageView: ImageView, urlPath: String?) {
        urlPath?.let {
            Glide.with(imageView.context)
                .load(it)
                .error(ContextCompat.getDrawable(imageView.context, R.drawable.loading))
                .into(imageView)
        }
    }
