package destiny.bu.problems.medium;

import java.util.HashSet;

public class LongestNonRepeatingSubStringLength {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        int longestSubStringLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            while (chars.contains(s.charAt(end))) {
                chars.remove(s.charAt(start));
                start++;
            }
            chars.add(s.charAt(end));
            longestSubStringLength = Math.max(chars.size(), longestSubStringLength);
        }
        return longestSubStringLength;
    }

    public int lengthOfLongestSubstringApproachOne(String s) {
        HashSet<Character> chars = new HashSet<>();
        char[] sArr = s.toCharArray();
        int longestSubStringLength = 0;

        for (int i = 0; i < sArr.length; i++) {
            if (chars.contains(sArr[i])) {
                longestSubStringLength = Math.max(longestSubStringLength, chars.size());
                System.out.println(chars.size());
                i -= (chars.size() - 1);
                chars = new HashSet<>();
            } else {
                chars.add(sArr[i]);
            }
        }
        return Math.max(longestSubStringLength, chars.size());
    }
}
