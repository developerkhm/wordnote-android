package com.donghyeon.wordnote.presentation.quiz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentQuizBinding

class QuizFragment : BaseFragment<FragmentQuizBinding, QuizViewModel>(
    R.layout.fragment_quiz
) {

    override val viewModel by activityViewModels<QuizViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }
}
