package destiny.bu.problems.easy;
/*
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1111", "111"));
    }

    private static int addBinaryDigits(int carry, StringBuilder binarySum, Character x, Character y) {
        int sum = Character.getNumericValue(x) + Character.getNumericValue(y) + carry;
        binarySum.insert(0, sum % 2);
        return sum / 2;
    }

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder binarySum = new StringBuilder();

        while (indexA >= 0 || indexB >= 0) {
            char x = (indexA >= 0) ? a.charAt(indexA) : '0';
            char y = (indexB >= 0) ? b.charAt(indexB) : '0';

            carry = addBinaryDigits(carry, binarySum, x, y);

            if (indexA >= 0) indexA--;
            if (indexB >= 0) indexB--;
        }

        if (carry == 1) {
            binarySum.insert(0, 1);
        }

        return binarySum.toString();
    }
}
