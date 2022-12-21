package com.core.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GlideManager
@Inject constructor(
    private val glide: RequestManager
) {
    @BindingAdapter("app:imageUrl")
    fun getImage(imgView: ImageView, imageUrl: String) {
        glide.load(imageUrl)
            .placeholder(R.drawable.warning)
            .circleCrop()
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.warning)
            .into(imgView)
    }
}