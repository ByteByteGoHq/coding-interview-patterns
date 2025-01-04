package common.bitmanipulation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LonelyIntegerTest {

    private val question = LonelyInteger()

    @Test
    fun `Expect return lonely integer`() {
        assertEquals(2, question.solution(listOf(1, 3, 3, 2, 1)))
        assertEquals(8, question.solution(listOf(3, 1, 4, 8, 1, 3, 4)))
    }

}