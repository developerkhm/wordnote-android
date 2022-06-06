package com.donghyeon.wordnote.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearDecoration(
    private val offset: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildAdapterPosition(view)
        val offsetHalf = offset.div(2)
        val top = if (pos == 0) offset else offsetHalf
        val bottom = if (pos == state.itemCount - 1) offset else offsetHalf
        outRect.set(offset, top, offset, bottom)
    }
}
