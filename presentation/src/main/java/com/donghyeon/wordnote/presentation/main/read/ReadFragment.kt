package com.donghyeon.wordnote.presentation.main.read

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donghyeon.wordnote.presentation.R
import com.donghyeon.wordnote.presentation.base.BaseFragment
import com.donghyeon.wordnote.presentation.databinding.FragmentReadBinding
import com.donghyeon.wordnote.presentation.note.NoteSelectFragment
import com.donghyeon.wordnote.presentation.utils.LinearDecoration
import com.donghyeon.wordnote.presentation.utils.dp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReadFragment : BaseFragment<FragmentReadBinding, ReadViewModel>(
    R.layout.fragment_read
) {

    @Inject lateinit var adapter: ReadAdapter

    override val viewModel by viewModels<ReadViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setViewModel(viewModel)
        with(binding) {
            vm = viewModel
            rvItem.adapter = adapter
            rvItem.addItemDecoration(LinearDecoration(15.dp))
        }
        viewModel.readState.observe(viewLifecycleOwner) {
            when (it) {
                ReadState.SetNote -> {
                    NoteSelectFragment(false).let { fragment ->
                        fragment.showNoteFragment(
                            requireActivity().supportFragmentManager,
                            fragment.tag
                        ) {
                            setView()
                        }
                    }
                }
            }
        }
        setView()
    }

    private fun setView() {
        viewModel.getSelectedNote()
        viewModel.getItemList()
    }
}
