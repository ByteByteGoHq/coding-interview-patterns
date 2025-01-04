package common.tries

import common.tries.DesignTrie.Trie
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class DesignTrieTest {

    @Test
    fun `Expected containing word`() {
        assertTrue { trie.search("banana") }
        assertTrue { trie.search("pineapple") }
    }

    @Test
    fun `Expected not containing word`() {
        assertFalse { trie.search("kiwi") }
    }

    @Test
    fun `Expected contain prefix`() {
        assertTrue { trie.hasPrefix("water") }
        assertTrue { trie.hasPrefix("black") }
    }

    @Test
    fun `Expected not contain prefix`() {
        assertFalse { trie.hasPrefix("white") }
    }

    companion object {

        val fruits: List<String> = listOf(
            "apple",
            "banana",
            "grape",
            "orange",
            "watermelon",
            "strawberry",
            "blueberry",
            "mango",
            "pineapple",
            "peach",
            "cherry",
            "pear",
            "plum",
            "blackberry",
            "raspberry",
            "coconut",
            "papaya"
        )

        private lateinit var trie: Trie

        @JvmStatic
        @BeforeAll
        fun init() {
            trie = Trie()
            for (fruit in fruits) {
                trie.insert(fruit)
            }
        }
    }
}