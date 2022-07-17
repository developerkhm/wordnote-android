package com.donghyeon.wordnote.presentation.main.quiz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentQuizBinding
import com.donghyeon.wordnote.presentation.utils.GridDecoration
import com.donghyeon.wordnote.presentation.utils.dp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment : BaseFragment<FragmentQuizBinding, QuizViewModel>(
    R.layout.fragment_quiz
) {

    @Inject lateinit var adapter: QuizAdapter

    override val viewModel by viewModels<QuizViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            vm = viewModel
            val layoutManager = GridLayoutManager(context, 2)
            rvQuiz.adapter = adapter
            rvQuiz.layoutManager = layoutManager
            rvQuiz.addItemDecoration(GridDecoration(layoutManager, 15.dp))
        }
    }
}
