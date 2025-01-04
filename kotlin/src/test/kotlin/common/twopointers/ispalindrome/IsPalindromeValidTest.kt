package common.twopointers.ispalindrome

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class IsPalindromeValidTest {

    private val question = IsPalindromeValid()

    @Test
    fun `Test palindrome expect true`() {
        Assertions.assertAll(
            Executable { Assertions.assertTrue(question.solution("racecar")) },
            Executable { Assertions.assertTrue(question.solution("a+2c!2a")) },
            Executable { Assertions.assertTrue(question.solution("abba")) },
        )
    }

    @Test
    fun `Test palindrome expect false`() {
        Assertions.assertAll(
            Executable { Assertions.assertFalse(question.solution("abc123")) },
            Executable { Assertions.assertFalse(question.solution("acbba")) },
        )
    }
}