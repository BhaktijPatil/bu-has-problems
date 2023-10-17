package destiny.bu.problems;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

0 <= rowIndex <= 33


Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class PascalsTriangle {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] pascalRow = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex / 2; i++) {
            pascalRow[i] = Math.toIntExact(calculateElement(i, rowIndex));
            System.out.println(pascalRow[i]);
        }
        for (int i = rowIndex; i > rowIndex / 2; i--) {
            pascalRow[i] = pascalRow[rowIndex-i];
            System.out.println(pascalRow[i]);
        }
        return Arrays.asList(pascalRow);
    }

    private long calculateElement(int i, int rowIndex) {
        return factorial(rowIndex) / (factorial(rowIndex - i) * factorial(i));
    }
}
