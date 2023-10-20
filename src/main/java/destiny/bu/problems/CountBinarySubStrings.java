package destiny.bu.problems;

/*
Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.



Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.


Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountBinarySubStrings {
    public int countBinarySubstrings(String s) {
        List<Integer> consecutiveCounts = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                consecutiveCounts.add(count);
                count = 1;
            } else {
                count++;
            }
            if (i == s.length() - 1) {
                consecutiveCounts.add(count);
            }
        }

        System.out.println(consecutiveCounts);

        if(consecutiveCounts.size() <= 1) {
            return 0;
        }

        int subStringCount = 0;
        for (int i = 1; i < consecutiveCounts.size(); i++) {
            subStringCount += Math.min(consecutiveCounts.get(i), consecutiveCounts.get(i-1));
        }
        return subStringCount;
    }
}
