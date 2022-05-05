package com.donghyeon.wordnote

import com.donghyeon.wordnote.domain.usecase.AddItemUseCase
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals

@ExperimentalCoroutinesApi
class AddItemUseCaseTest {

    private val addItemUseCase = AddItemUseCase(mockk(relaxed = true))

    @Test
    fun testAddItemUseCase_word_empty() = runTest {
        assertEquals(
            addItemUseCase(
                0,
                "",
                "사과"
            ).first(),
            "단어를 입력하세요"
        )
    }

    @Test
    fun testAddItemUseCase_description_empty() = runTest {
        assertEquals(
            addItemUseCase(
                0,
                "apple",
                ""
            ).first(),
            "설명을 입력하세요"
        )
    }

    @Test
    fun testAddItemUseCase_word_en() = runTest {
        assertEquals(
            addItemUseCase(
                0,
                "사과",
                "사과"
            ).first(),
            "단어는 영문만 입력하세요"
        )
    }

    @Test
    fun testAddItemUseCase_complete() = runTest {
        addItemUseCase(
            0,
            "apple",
            "사과"
        ).collectIndexed { index, value ->
            if (index == 0) {
                assertEquals(value, "추가 되었습니다")
            }
            if (index == 1) {
                assertEquals(value, true)
            }
        }
    }
}
