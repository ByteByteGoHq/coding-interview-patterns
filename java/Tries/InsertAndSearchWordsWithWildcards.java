import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

public class InsertAndSearchWordsWithWildcards {
    TrieNode root;

    public InsertAndSearchWordsWithWildcards() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        // Start searching from the root of the trie.
        return searchHelper(0, word, this.root);
    }

    private boolean searchHelper(int wordIndex, String word, TrieNode node) {
        for (int i = wordIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            // If a wildcard character is encountered, recursively
            // search for the rest of the word from each child node.
            if (c == '.') {
                for (TrieNode child : node.children.values()) {
                    // If a match is found, return true.
                    if (searchHelper(i + 1, word, child)) {
                        return true;
                    }
                }
                return false;
            } else if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return false;
            }
        }
        // After processing the last character, return true if we've
        // reached the end of a word.
        return node.isWord;
    }
}
