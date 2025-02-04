import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    public TrieNode() {
        this.children = new HashMap<>();
        this.word = null;
    }
}

public class FindAllWordsOnABoard {
    public List<String> findAllWordsOnABoard(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        // Insert every word into the trie.
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word;
        }
        List<String> res = new ArrayList<>();
        // Start a DFS call from each cell of the board that contains a
        // child of the root node, which represents the first letter of a
        // word in the trie.
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, r, c, root.children.get(board[r][c]), res);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        // If the current node represents the end of a word, add the word to
        // the result.
        if (node.word != null) {
            res.add(node.word);
            // Ensure the current word is only added once.
            node.word = null;
        }
        char temp = board[r][c];
        // Mark the current cell as visited.
        board[r][c] = '#';
        // Explore all adjacent cells that correspond with a child of the
        // current TrieNode.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : dirs) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (isWithinBounds(nextR, nextC, board) && node.children.containsKey(board[nextR][nextC])) {
                dfs(board, nextR, nextC, node.children.get(board[nextR][nextC]), res);
            }
        }
        // Backtrack by reverting the cell back to its original character.
        board[r][c] = temp;
    }

    private boolean isWithinBounds(int r, int c, char[][] board) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length;
    }
}
