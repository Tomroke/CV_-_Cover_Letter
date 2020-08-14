/*
* The icons used are from the site www.flaticon.com.
* The linkedin & github icon were made by Freepik found at https://www.flaticon.com/authors/freepik,
* wile the email & phone icon were made by Gregor Cresnar found at https://www.flaticon.com/authors/gregor-cresnar
* */

package com.irving.cvpersonalletter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.irving.cvpersonalletter.database.ContactMeData

@BindingAdapter("setContactingIcon")
fun ImageView.setContactingIcon (item: ContactMeData?){
    item?.let {
        setImageResource(
            when (item.contactingIcon){
                1 -> R.drawable.ic_linkedin
                2 -> R.drawable.ic_email
                3 -> R.drawable.ic_phone
                4 -> R.drawable.ic_github
                else -> R.drawable.ic_linkedin

            }
        )
    }
}

@BindingAdapter ("setCvImages")
fun setCvImages (view: ImageView, url: String?){
    if (!url.isNullOrEmpty()){
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_phone)
            .circleCrop()
            .into(view)
    }
}