package common.tries

data class TrieNode(
    var isWord: Boolean = false,
    var word: String? = null,
    val children: Array<TrieNode?> = Array(26) { null }
)
