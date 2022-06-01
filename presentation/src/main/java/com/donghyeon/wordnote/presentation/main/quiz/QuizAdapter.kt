package com.donghyeon.wordnote.presentation.main.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.donghyeon.wordnote.domain.model.QuizData
import com.donghyeon.wordnote.presentation.base.BaseAdapter
import com.donghyeon.wordnote.presentation.databinding.RecyclerQuizBinding

class QuizAdapter(
    private val viewModel: QuizViewModel,
) : BaseAdapter<QuizData>(viewModel.diffUtil) {

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
            binding.apply {
                this.quizData = quizData
            }
        }
    }
}
