package com.donghyeon.wordnote.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.ItemData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerItemBinding

class MainAdapter(
    private val viewModel: MainViewModel,
) : BaseAdapter<ItemData>(viewModel.diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        binding = RecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding as RecyclerItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolder) {
            holder.bind(getItem(position) as ItemData)
        }
    }

    inner class MainViewHolder(
        private val binding: RecyclerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemData: ItemData) {
            binding.apply {
                this.itemData = itemData
                vm = viewModel
            }
        }
    }
}
