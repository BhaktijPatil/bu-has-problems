package destiny.bu.problems;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class IsPalindrome {

    private static boolean isValidChar(Character leftChar) {
        return (leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9');
    }

    public boolean isPalindromeApproachTwo(String s) {
        int rightPointer = s.length() - 1;
        int leftPointer = 0;
        while (leftPointer < rightPointer) {
            char leftChar = Character.toLowerCase(s.charAt(leftPointer));
            char rightChar = Character.toLowerCase(s.charAt(rightPointer));
            if (!Character.isLetterOrDigit(leftChar)) {
                leftPointer++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                rightPointer--;
            } else if (rightChar != leftChar) {
                return false;
            } else {
                leftPointer++;
                rightPointer--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int[] charArr = s.chars()
                .filter(leftChar -> (leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'))
                .toArray();

        for (int i = 0; i < charArr.length / 2; i++) {
            if (charArr[i] != charArr[charArr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
