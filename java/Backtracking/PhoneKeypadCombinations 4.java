import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneKeypadCombinations {
    public List<Stirng> phoneKeypadCombinations(String digits) {
        Map<Character, String> keypadMap = new HashMap<>();
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), digits, keypadMap, result);
        return result;
    }

    private void backtrack(int i, List<Character> currCombination, String digits, Map<Character, String> keypadMap, List<String> result) {
        // Termination condition: if all digits have been considered, add the
        // current combination to the output list.
        if (currCombination.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c: currCombination) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        for (char letter: keypadMap.get(digits.charAt(i)).toCharArray()) {
            // Add the current letter.
            currCombination.add(letter);
            // Recursively explore all paths that branch from this combination.
            backtrack(i + 1, currCombination, digits, keypadMap, result);
            // Backtrack by removing the letter we just added.
            currCombination.remove(currCombination.size() - 1);
        }
    }
}
