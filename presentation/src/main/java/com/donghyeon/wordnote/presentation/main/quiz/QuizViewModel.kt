package com.donghyeon.wordnote.presentation.main.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import com.donghyeon.wordnote.domain.model.QuizData
import com.donghyeon.wordnote.presentation.base.BaseViewModel

class QuizViewModel : BaseViewModel() {

    private val _quizDataList = MutableLiveData<List<QuizData>>()
    val quizDataList: LiveData<List<QuizData>> = _quizDataList

    val diffUtil = object : DiffUtil.ItemCallback<QuizData>() {
        override fun areItemsTheSame(oldItem: QuizData, newItem: QuizData): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: QuizData, newItem: QuizData): Boolean {
            return oldItem.title == newItem.title
        }
    }

    init {
        _quizDataList.value = listOf(
            QuizData("단어 카드"),
            QuizData("사지선다"),
            QuizData("받아쓰기"),
            QuizData("깜빡이")
        )
    }
}
