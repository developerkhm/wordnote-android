package com.donghyeon.wordnote.presentation.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("bindItemList")
fun RecyclerView.bindItemList(itemList: List<Nothing>?) {
    itemList ?: return
    (this.adapter as BaseAdapter<*>).submitList(itemList)
}
