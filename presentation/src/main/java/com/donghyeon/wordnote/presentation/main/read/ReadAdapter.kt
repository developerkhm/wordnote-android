package com.donghyeon.wordnote.presentation.main.read

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerItemBinding
import javax.inject.Inject

class ReadAdapter @Inject constructor() : BaseAdapter<ItemData>(
    object : DiffUtil.ItemCallback<ItemData>() {
        override fun areItemsTheSame(oldItem: ItemData, newItem: ItemData) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ItemData, newItem: ItemData) =
            oldItem.id == newItem.id && oldItem.word == newItem.word
    }
) {

    private lateinit var viewModel: ReadViewModel

    fun setViewModel(viewModel: ReadViewModel) {
        this.viewModel = viewModel
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        binding = RecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding as RecyclerItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(getItem(position) as ItemData)
        }
    }

    inner class ViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemData: ItemData) {
            with(binding) {
                this.itemData = itemData
                vm = viewModel
            }
        }
    }
}
