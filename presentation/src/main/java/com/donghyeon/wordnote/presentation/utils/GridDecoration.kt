package com.donghyeon.wordnote.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridDecoration(
    private val layoutManager: GridLayoutManager,
    private val offset: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val spanIndex = (view.layoutParams as? GridLayoutManager.LayoutParams)?.spanIndex
        if (spanIndex == null) {
            outRect.set(0, 0, 0, 0)
        } else {
            val pos = parent.getChildAdapterPosition(view)
            val half = offset.div(2)
            val top: Int
            val bottom: Int
            val left: Int
            val right: Int
            if (pos < layoutManager.spanCount) {
                top = offset
                bottom = half
            } else if (pos >= state.itemCount - layoutManager.spanCount) {
                top = half
                bottom = offset
            } else {
                top = half
                bottom = half
            }
            when (spanIndex) {
                0 -> {
                    left = offset
                    right = half
                }
                layoutManager.spanCount - 1 -> {
                    left = half
                    right = offset
                }
                else -> {
                    left = half
                    right = half
                }
            }
            outRect.set(left, top, right, bottom)
        }
    }
}
