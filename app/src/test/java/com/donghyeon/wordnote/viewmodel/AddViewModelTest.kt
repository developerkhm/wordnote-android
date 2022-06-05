package com.donghyeon.wordnote.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.donghyeon.wordnote.FakeRepositoryImpl
import com.donghyeon.wordnote.MainCoroutineRule
import com.donghyeon.wordnote.TestDispatcherImpl
import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteUseCase
import com.donghyeon.wordnote.presentation.main.add.AddModel
import com.donghyeon.wordnote.presentation.main.add.AddViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class AddViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var addViewModel: AddViewModel

    @Before
    fun setUp() {
        val fakeRepository = FakeRepositoryImpl()
        val testDispatcher = TestDispatcherImpl(mainCoroutineRule.testDispatcher)
        addViewModel = AddViewModel(
            GetNoteUseCase(testDispatcher, fakeRepository),
            AddItemUseCase(fakeRepository)
        )
    }

    @Test
    fun getNote() {
        assertEquals(
            addViewModel.addModel.value,
            AddModel()
        )
        addViewModel.getNote()
        assertEquals(
            addViewModel.addModel.value,
            AddModel(
                1,
                0,
                "나의 단어장",
                ""
            )
        )
    }
}
