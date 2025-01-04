package common.tries

class DesignTrie {
    class Trie {
        val root = TrieNode()

        // insert
        fun insert(word: String) {
            var node = root
            for (c in word.toCharArray()) {
                // For each character in the word, if it's not a child of
                // the current node, create a new TrieNode for that
                // character.
                val index = c - 'a'
                if (node.children[index] == null) {
                    node.children[index] = TrieNode()
                }
                node = node.children[index]!!
            }
            // Mark the last node as the end of a word.
            node.isWord = true
        }

        // search
        fun search(word: String): Boolean {
            var node = root
            for (c in word.toCharArray()) {
                // For each character in the word, if it's not a child of
                // the current node, the word doesn't exist in the Trie.
                val index = c - 'a'
                if (node.children[index] == null) {
                    return false
                }
                node = node.children[index]!!
            }
            // Return whether the current node is marked as the end of the word.
            return node.isWord
        }

        // hasPrefix
        fun hasPrefix(word: String): Boolean {
            var node = root
            for (c in word.toCharArray()) {
                val index = c - 'a'
                if (node.children[index] == null) {
                    return false
                }
                node = node.children[index]!!
            }
            // Once we've traversed the nodes corresponding to each
            // character in the prefix, return True.
            return true
        }
    }
}