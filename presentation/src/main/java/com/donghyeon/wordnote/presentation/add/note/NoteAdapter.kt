package com.donghyeon.wordnote.presentation.add.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerNoteBinding

class NoteAdapter(
    private val viewModel: NoteViewModel,
) : BaseAdapter<NoteData>(viewModel.diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        binding = RecyclerNoteBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding as RecyclerNoteBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(getItem(position) as NoteData)
        }
    }

    inner class ViewHolder(
        private val binding: RecyclerNoteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(noteData: NoteData) {
            binding.apply {
                this.noteData = noteData
                vm = viewModel
            }
        }
    }
}
