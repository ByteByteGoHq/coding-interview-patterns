use std::collections::HashMap;

pub fn phone_keypad_combinations(digits: String) -> Vec<String> {
    if digits.is_empty() {
        return Vec::new();
    }
    
    let mut keypad_map = HashMap::new();
    keypad_map.insert('2', "abc");
    keypad_map.insert('3', "def");
    keypad_map.insert('4', "ghi");
    keypad_map.insert('5', "jkl");
    keypad_map.insert('6', "mno");
    keypad_map.insert('7', "pqrs");
    keypad_map.insert('8', "tuv");
    keypad_map.insert('9', "wxyz");
    
    let mut res: Vec<String> = Vec::new();
    let mut curr_combination: Vec<char> = Vec::new();
    
    let digits_chars: Vec<char> = digits.chars().collect();
    backtrack(0, &mut curr_combination, &digits_chars, &keypad_map, &mut res);
    
    res
}

fn backtrack(
    i: usize,
    curr_combination: &mut Vec<char>,
    digits: &Vec<char>,
    keypad_map: &HashMap<char, &str>,
    res: &mut Vec<String>
) {
    // Termination condition: if all digits have been considered, add the
    // current combination to the output list.
    if curr_combination.len() == digits.len() {
        res.push(curr_combination.iter().collect());
        return;
    }
    
    let digit = digits[i];
    if let Some(letters) = keypad_map.get(&digit) {
        for letter in letters.chars() {
            // Add the current letter.
            curr_combination.push(letter);
            
            // Recursively explore all paths that branch from this combination.
            backtrack(i + 1, curr_combination, digits, keypad_map, res);
            
            // Backtrack by removing the letter we just added.
            curr_combination.pop();
        }
    }
}
