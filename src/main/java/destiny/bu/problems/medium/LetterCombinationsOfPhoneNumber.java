package destiny.bu.problems.medium;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    Map<Character, List<Character>> letterDigitmap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z'));

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> letterCombinations = List.of("");
        for (Character digit : digits.toCharArray()) {
            List<String> newCombinations = new ArrayList<>();
            for (Character character : letterDigitmap.get(digit)) {
                for (String s : letterCombinations) {
                    newCombinations.add(s + character);
                }
            }
            letterCombinations = newCombinations;
        }
        if (letterCombinations.size() == 1) {
            return List.of();
        }
        return letterCombinations;
    }
}

