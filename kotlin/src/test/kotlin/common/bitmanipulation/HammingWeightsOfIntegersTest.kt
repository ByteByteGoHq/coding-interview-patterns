package common.bitmanipulation

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class HammingWeightsOfIntegersTest {

    private val question = HammingWeightsOfIntegers()

    @Test
    fun `Verify set bit count by AND 1`() {
        assertContentEquals(listOf(1, 1, 2, 1, 2, 2), question.solution(6))
    }

    @Test
    fun `Verify set bit count by count operation`() {
        assertContentEquals(listOf(1, 1, 2, 1, 2, 2), question.solution2(6))
    }

}