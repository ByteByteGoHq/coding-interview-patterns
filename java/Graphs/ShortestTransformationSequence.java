import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestTransformationSequence {
    public int shortestTransformationSequence(String start, String end, List<String> dictionary) {
        Set<String> dictionarySet  = new HashSet<>(dictionary);
        if (!dictionarySet.contains(start) && !dictionarySet.contains(end)) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int dist = 0;
        // Use level-order traversal to find the shortest path from the 
        // start word to the end word.
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String currWord = queue.poll();
                // If we found the end word, we've reached it via the 
                // shortest path.
                if (currWord.equals(end)) {
                    return dist + 1;
                }
                // Generate all possible words that have a one-letter 
                // difference to the current word.
                char[] currWordArray = currWord.toCharArray();
                for (int i = 0; i < currWord.length(); i++) {
                    char tmp = currWordArray[i];
                    for (char c : lowerCaseAlphabet.toCharArray()) {
                        currWordArray[i] = c;
                        String nextWord = new String(currWordArray);
                        // If 'next_word' exists in the dictionary, it's a 
                        // neighbor of the current word. If unvisited, add it
                        // to the queue to be processed in the next level.
                        if (dictionarySet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    currWordArray[i] = tmp;
                }
            }
            dist++;
        }
        // If there is no way to reach the end node, then no path exists.
        return 0;
    }
}
