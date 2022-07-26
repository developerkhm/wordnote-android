package com.donghyeon.wordnote.presentation.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerNoteSelectBinding

class NoteSelectAdapter(
    private val viewModel: NoteSelectViewModel
) : BaseAdapter<NoteData>(
    object : DiffUtil.ItemCallback<NoteData>() {
        override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData) =
            oldItem.note == newItem.note
    }
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        binding = RecyclerNoteSelectBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding as RecyclerNoteSelectBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(getItem(position) as NoteData)
        }
    }

    inner class ViewHolder(
        private val binding: RecyclerNoteSelectBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(noteData: NoteData) {
            with(binding) {
                this.noteData = noteData
                vm = viewModel
            }
        }
    }
}
