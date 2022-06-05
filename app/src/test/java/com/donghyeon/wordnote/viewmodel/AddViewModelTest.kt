package com.donghyeon.wordnote.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.donghyeon.wordnote.FakeRepositoryImpl
import com.donghyeon.wordnote.MainCoroutineRule
import com.donghyeon.wordnote.TestDispatcherImpl
import com.donghyeon.wordnote.domain.model.NoteData
import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import com.donghyeon.wordnote.domain.usecase.GetNoteUseCase
import com.donghyeon.wordnote.presentation.base.BaseState
import com.donghyeon.wordnote.presentation.main.add.AddModel
import com.donghyeon.wordnote.presentation.main.add.AddState
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
            AddItemUseCase(testDispatcher, fakeRepository)
        )
    }

    @Test
    fun getNote() = with(addViewModel) {
        getNote()
        assertEquals(addModel.value, AddModel(1, "나의 단어장"))
    }

    @Test
    fun addItem_success() = with(addViewModel) {
        addModel.value = AddModel(
            1,
            "나의 단어장",
            "Apple",
            "사과"
        )
        addItem()
        assertEquals(addModel.value, AddModel(1, "나의 단어장"))
    }

    @Test
    fun addItem_failed_none() = with(addViewModel) {
        addModel.value = AddModel(
            1,
            "나의 단어장",
            "",
            ""
        )
        addItem()
        assertEquals(baseState.value, BaseState.ShowMessage("단어를 입력하세요"))
    }

    @Test
    fun selectedNote() = with(addViewModel) {
        selectedNote()
        assertEquals(addState.value, AddState.SelectedNote)
    }

    @Test
    fun setNote() = with(addViewModel) {
        setNote(NoteData(2, "너의 단어장"))
        assertEquals(addModel.value, AddModel(2, "너의 단어장"))
    }
}
