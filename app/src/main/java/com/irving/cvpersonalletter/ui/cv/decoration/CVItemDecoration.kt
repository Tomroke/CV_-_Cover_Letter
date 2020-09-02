package com.irving.cvpersonalletter.ui.cv.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CVItemDecoration constructor (private val space: Int): RecyclerView.ItemDecoration() {


    override fun getItemOffsets( outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.set(space, space, space, space)
    }

}