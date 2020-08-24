/*
* The icons used are from the site www.flaticon.com.
* The linkedin & github icon were made by Freepik found at https://www.flaticon.com/authors/freepik,
* wile the email & phone icon were made by Gregor Cresnar found at https://www.flaticon.com/authors/gregor-cresnar
* */

package com.irving.cvpersonalletter

import android.net.Uri
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.irving.cvpersonalletter.database.ContactMeData

@BindingAdapter("setContactingIcon")
fun ImageView.setContactingIcon(item: ContactMeData?){
    item?.let {
        setImageResource(
            when (item.contactingIcon) {
                1 -> R.drawable.ic_linkedin
                2 -> R.drawable.ic_email
                3 -> R.drawable.ic_phone
                4 -> R.drawable.ic_github
                else -> R.drawable.ic_baseline_error_outline_24

            }
        )
    }
}

@BindingAdapter("setPersonalImageWithGlide")
fun setPersonalImageWithGlide(view: ImageView, uri: Uri?){
    Glide.with(view.context)
        .load(uri)
        .centerInside()
        .circleCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

//TODO FIX PLACEHOLDER, ERROR
@BindingAdapter("setImagesWithGlide")
fun setImagesWithGlide(view: ImageView, uri: Uri?){
    val circularProgressDrawable = CircularProgressDrawable(view.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setStyle(CircularProgressDrawable.LARGE)
    circularProgressDrawable.start()

    var requestOptions = RequestOptions()
    requestOptions = requestOptions.transform(CenterInside(), RoundedCorners(32))
    requestOptions = requestOptions.placeholder(circularProgressDrawable)
    requestOptions = requestOptions.error(R.drawable.ic_baseline_error_outline_24)
    requestOptions = requestOptions.skipMemoryCache(true)

    Glide.with(view.context)
        .load(uri)
        .apply(requestOptions)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}