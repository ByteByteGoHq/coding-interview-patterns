import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

public class DesignATrie {
    TrieNode root;

    public DesignATrie() {
        this.root = new TrieNode();    
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            // For each character in the word, if it's not a child of
            // the current node, create a new TrieNode for that
            // character.
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        // Mark the last node as the end of a word.
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            // For each character in the word, if it's not a child of
            // the current node, the word doesn't exist in the Trie.
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        // Return whether the current node is marked as the end of the
        // word.
        return node.isWord;
    }

    public boolean hasPrefix(String prefix) {
        TrieNode node = this.root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        // Once we've traversed the nodes corresponding to each
        // character in the prefix, return True.
        return true;
    }
}
