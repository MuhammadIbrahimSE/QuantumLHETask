package com.example.nytimespopularapi.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.nytimespopularapi.R

@BindingAdapter("android:srcImage")
fun setImageSrc(imageView: ImageView, srcImage: String?) {
    Glide.with(imageView.context).load(srcImage).transform(RoundedCorners(24))
        .error(R.mipmap.ic_launcher)
        .into(imageView)
}
