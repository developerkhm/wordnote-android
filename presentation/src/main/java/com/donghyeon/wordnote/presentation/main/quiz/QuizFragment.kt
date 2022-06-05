package com.donghyeon.wordnote.presentation.main.quiz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentQuizBinding
import com.donghyeon.wordnote.presentation.utils.ItemDecoration
import com.donghyeon.wordnote.presentation.utils.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : BaseFragment<FragmentQuizBinding, QuizViewModel>(
    R.layout.fragment_quiz
) {

    override val viewModel by viewModels<QuizViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            vm = viewModel
            rvQuiz.adapter = QuizAdapter(viewModel)
            rvQuiz.addItemDecoration(ItemDecoration(15.dp))
        }
    }
}
