use std::collections::HashMap;

fn backtrack(
    i: usize,
    curr_combination: &mut Vec<char>,
    digits: &[char],
    keypad_map: &HashMap<char, &str>,
    res: &mut Vec<String>,
) {
    // Termination condition: if all digits have been considered
    // Add the current combination to the output list
    if curr_combination.len() == digits.len() {
        res.push(curr_combination.iter().collect());
        return;
    }

    // PYTHON = for letter in keypad_map[digits[i]]...
    if let Some(&digit) = digits.get(i) {
        if let Some(letters) = keypad_map.get(&digit) {
            for letter in letters.chars() {
                // Add current letter
                curr_combination.push(letter);
                // Recursively explore all paths that branch from this combination.
                backtrack(i + 1, curr_combination, digits, keypad_map, res);
                // Backtrack by removing the letter we just added.
                curr_combination.pop();
            }
        }
    }
}

fn phone_keypad_combinations(digits: &str) -> Vec<String> {
    let index = 0;
    let mut curr_combination = Vec::new();
    let digits_chars: Vec<char> = digits.chars().collect(); // collect chars once
    let keypad_map = HashMap::from([
        ('2', "abc"),
        ('3', "def"),
        ('4', "ghi"),
        ('5', "jkl"),
        ('6', "mno"),
        ('7', "pqrs"),
        ('8', "tuv"),
        ('9', "wxyz"),
    ]);
    let mut res = Vec::new();

    backtrack(
        index,
        &mut curr_combination,
        &digits_chars,
        &keypad_map,
        &mut res,
    );
    res
}
