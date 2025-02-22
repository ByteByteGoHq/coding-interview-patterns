import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestTransformationSequenceOptimized {
    public int shortestTransformationSequenceOptimized(String start, String end, List<String> dictionary) {
        Set<String> dictionarySet  = new HashSet<>(dictionary);
        if (!dictionarySet.contains(start) && !dictionarySet.contains(end)) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        Queue<String> startQueue = new LinkedList<>();
        Set<String> startVisited = new HashSet<>();
        Queue<String> endQueue =  new LinkedList<>();
        Set<String> endVisited = new HashSet<>();
        startQueue.offer(start);
        startVisited.add(start);
        endQueue.offer(end);
        endVisited.add(end);
        int levelStart, levelEnd;
        levelStart = levelEnd = 0;
        // Perform a level-order traversal from the start word and another 
        // from the end word.
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            // Explore the next level of the traversal that starts from the 
            // start word. If it meets the other traversal, the shortest 
            // path between 'start' and 'end' has been found.
            levelStart++;
            if (exploreLevel(startQueue, startVisited, endVisited, dictionarySet)) {
                return levelStart + levelEnd + 1;
            }
            // Explore the next level of the traversal that starts from the  
            // end word.
            levelEnd++;
            if (exploreLevel(endQueue, endVisited, startVisited, dictionarySet)) {
                return levelStart + levelEnd + 1;
            }
        }
        // If the traversals never met, then no path exists.
        return 0;
    }

    // This function explores the next level in the level-order traversal 
    // and checks if two searches meet.
    private boolean exploreLevel(Queue<String> queue, Set<String> visited, Set<String> otherVisited, Set<String> dictionarySet) {
        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        int size = queue.size();
        for (int j = 0; j < size; j++) {
            String currWord = queue.poll();
            char[] currWordArray = currWord.toCharArray();
            for (int i = 0; i < currWord.length(); i++) {
                char tmp = currWordArray[i];
                for (char c : lowerCaseAlphabet.toCharArray()) {
                    currWordArray[i] = c;
                    String nextWord = new String(currWordArray);
                    // If 'nextWord' has been visited during the other
                    // traversal, it means both searches have met.
                    if (otherVisited.contains(nextWord)) {
                        return true;
                    }
                    if (dictionarySet.contains(nextWord) && !visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
                currWordArray[i] = tmp;
            }
        }
        // If no word has been visited by the other traversal, the searches 
        // have not met yet.
        return false;
    }
}
