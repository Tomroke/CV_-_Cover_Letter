package com.irving.cvpersonalletter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.irving.cvpersonalletter.database.ContactMeData

@BindingAdapter("contactingIcon")
fun ImageView.setContactingIcon (item: ContactMeData?){
    item?.let {
        setImageResource(
            when (item.contactingIcon){
                1 -> R.drawable.ic_linkedin
                2 -> R.drawable.ic_email
                3 -> R.drawable.ic_old_phone
                4 -> R.drawable.ic_github
                else -> R.drawable.ic_linkedin

            }
        )
    }
}