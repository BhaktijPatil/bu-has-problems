package destiny.bu.problems.medium;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreakRecursion("leetcodecodeleet", List.of("leet", "code")));
        System.out.println(new WordBreak().wordBreak("leetcodecodeleet", List.of("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isPositionReachable = new boolean[s.length()+1];

        isPositionReachable[0] = true;

        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(isPositionReachable));
            if (isPositionReachable[i]) {
                for (String word : wordDict) {
                    System.out.println(word + " " + i);
                    if (s.startsWith(word, i)) {
                        isPositionReachable[i + word.length()] = true;
                    }
                }
            }
        }
        return isPositionReachable[s.length()];
    }

    public boolean wordBreakRecursion(String s, List<String> wordDict) {
        return removeWordIfPossible(s, wordDict, 0);
    }

    private boolean removeWordIfPossible(String s, List<String> wordDict, int currIndex) {
        return currIndex == s.length() || wordDict.stream()
                .filter(word -> {
                    int endIndex = currIndex + word.length();
                    System.out.println(currIndex + " " + word + " " + word.length());
                    return endIndex <= s.length() && s.substring(currIndex, endIndex).equals(word);
                })
                .anyMatch(word -> removeWordIfPossible(s, wordDict, currIndex + word.length()));
    }
}
