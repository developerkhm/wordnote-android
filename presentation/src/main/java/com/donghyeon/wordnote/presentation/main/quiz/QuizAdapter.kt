package com.donghyeon.wordnote.presentation.main.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.QuizData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerQuizBinding

class QuizAdapter(
    private val viewModel: QuizViewModel
) : BaseAdapter<QuizData>(
    object : DiffUtil.ItemCallback<QuizData>() {
        override fun areItemsTheSame(oldItem: QuizData, newItem: QuizData) =
            oldItem.title == newItem.title
        override fun areContentsTheSame(oldItem: QuizData, newItem: QuizData) =
            oldItem.title == newItem.title
    }
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        binding = RecyclerQuizBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding as RecyclerQuizBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(getItem(position) as QuizData)
        }
    }

    inner class ViewHolder(
        private val binding: RecyclerQuizBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(quizData: QuizData) {
            with(binding) {
                this.quizData = quizData
            }
        }
    }
}
