package destiny.bu.online.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCBiWeeklyContest118 {
    public static void main(String[] args) {
        System.out.println(minimumCoins(new int[]{3, 1, 2}) + "\t4");
        System.out.println(minimumCoins(new int[]{1, 10, 1, 1}) + "\t2");

//        System.out.println(maximizeSquareHoleArea(2, 3, new int[]{2, 3}, new int[]{2, 3, 4}));
//        System.out.println(maximizeSquareHoleArea(11, 6, new int[]{8, 9, 6}, new int[]{5, 3, 6, 4, 2, 7}));
    }

    /*
0-indexed array of strings words and a character x.
Return an array of indices representing the words that contain the character x.
returned array may be in any order.

Example 1:

Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
Example 2:

Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
Example 3:

Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words. Hence, we return an empty array.


Constraints:

1 <= words.length <= 50
1 <= words[i].length <= 50
x is a lowercase English letter.
words[i] consists only of lowercase English letters.
     */

//    public static int minimumCoins(int[] prices) {
//        return getMinPrice(prices, prices.length);
//    }
//
//    private static int getMinPrice(int[] prices, int i) {
//        int minPrice = Integer.MAX_VALUE;
//        for (int temp = i - 1; i - temp <= temp && temp > 0; temp--) {
//            if ((temp - 1) == 0) {
//                return prices[0];
//            }
//            minPrice = Math.min(getMinPrice(prices, temp) + (i == prices.length ? 0 : prices[temp - 1]), minPrice);
//        }
//        return minPrice;
//    }

    public static int minimumCoins(int[] prices) {
        int[] bestPrices = new int[prices.length];
        bestPrices[0] = prices[0];

        // Set all to max value
        for (int i = 1; i < bestPrices.length; i++) {
            bestPrices[i] = Integer.MAX_VALUE;
        }

        // DP
        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0 && i - j <= j; j--) {
                bestPrices[i] = Math.min(bestPrices[i], prices[i] + bestPrices[j]);
            }
        }

        System.out.println(Arrays.toString(bestPrices));

        return bestPrices[bestPrices.length - 1];
    }

    public static int minimumCoinsApp1(int[] prices) {
        int minimumCoins = 0;
        int freeCount = 0;
        for (int i = 0; i < prices.length; i++) {
            System.out.println("I : " + i + "\tCurr Price : " + prices[i] + "\tMin coins : " + minimumCoins + "\tFree Count : " + freeCount);
            if (freeCount > 0) {
                freeCount--;
            } else {
                if (i > 1) {
                    int j = i - 1;
                    while (j > 0) {
                        System.out.println("Rolling backwards");
                        if (prices[j] < prices[i] && i - j >= prices[j]) {
                            minimumCoins += prices[i];
                            freeCount += i + 1;
                            break;
                        }
                        j--;
                    }
                }

                minimumCoins += prices[i];
                freeCount += i + 1;
            }
        }
        return minimumCoins;
    }

    /*
You are at a fruit market with different types of exotic fruits on display.

You are given a 1-indexed array prices, where prices[i] denotes the number of coins needed to purchase the ith fruit.

The fruit market has the following offer:

If you purchase the ith fruit at prices[i] coins, you can get the next i fruits for free.
Note that even if you can take fruit j for free, you can still purchase it for prices[j] coins to receive a new offer.

Return the minimum number of coins needed to acquire all the fruits.

Example 1:

Input: prices = [3,1,2]
Output: 4
Explanation: You can acquire the fruits as follows:
- Purchase the 1st fruit with 3 coins, you are allowed to take the 2nd fruit for free.
- Purchase the 2nd fruit with 1 coin, you are allowed to take the 3rd fruit for free.
- Take the 3rd fruit for free.
Note that even though you were allowed to take the 2nd fruit for free, you purchased it because it is more optimal.
It can be proven that 4 is the minimum number of coins needed to acquire all the fruits.
Example 2:

Input: prices = [1,10,1,1]
Output: 2
Explanation: You can acquire the fruits as follows:
- Purchase the 1st fruit with 1 coin, you are allowed to take the 2nd fruit for free.
- Take the 2nd fruit for free.
- Purchase the 3rd fruit for 1 coin, you are allowed to take the 4th fruit for free.
- Take the 4th fruit for free.
It can be proven that 2 is the minimum number of coins needed to acquire all the fruits.


Constraints:

1 <= prices.length <= 1000
1 <= prices[i] <= 105

---
prices[i] = coins for purchase ith fruit.
If purchase at prices[i] coins, you can get the next i fruits for free.
even if you can take fruit j for free, you can still purchase it for prices[j] coins to receive a new offer.

Return the minimum number of coins needed to acquire all the fruits.
     */

    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxConsecutiveHBars = 0;
        int maxConsecutiveVBars = 0;

        int consecutiveHBars = 1;
        int consecutiveVBars = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - hBars[i - 1] == 1) {
                consecutiveHBars++;
            } else {
                maxConsecutiveHBars = Math.max(maxConsecutiveHBars, consecutiveHBars);
                consecutiveHBars = 1;
            }
        }
        maxConsecutiveHBars = Math.max(maxConsecutiveHBars, consecutiveHBars);

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - vBars[i - 1] == 1) {
                consecutiveVBars++;
            } else {
                maxConsecutiveVBars = Math.max(maxConsecutiveVBars, consecutiveVBars);
                consecutiveVBars = 1;
            }
        }
        maxConsecutiveVBars = Math.max(maxConsecutiveVBars, consecutiveVBars);

        System.out.println("Max h : " + maxConsecutiveHBars);
        System.out.println("Max v : " + maxConsecutiveVBars);

        int side = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;
        return side * side;
    }

    /*
    You are given a 0-indexed integer array nums.

You can perform any number of operations, where each operation involves selecting a subarray of the array and replacing it with the sum of its elements. For example, if the given array is [1,3,5,6] and you select subarray [3,5] the array will convert to [1,8,6].

Return the maximum length of a non-decreasing array that can be made after applying operations.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [5,2,2]
Output: 1
Explanation: This array with length 3 is not non-decreasing.
We have two ways to make the array length two.
First, choosing subarray [2,2] converts the array to [5,4].
Second, choosing subarray [5,2] converts the array to [7,2].
In these two ways the array is not non-decreasing.
And if we choose subarray [5,2,2] and replace it with [9] it becomes non-decreasing.
So the answer is 1.
Example 2:

Input: nums = [1,2,3,4]
Output: 4
Explanation: The array is non-decreasing. So the answer is 4.
Example 3:

Input: nums = [4,3,2,6]
Output: 3
Explanation: Replacing [3,2] with [5] converts the given array to [4,5,6] that is non-decreasing.
Because the given array is not non-decreasing, the maximum possible answer is 3.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
     */

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> wordsContaining = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].chars().mapToObj(value -> (char) value).anyMatch(character -> character == x)) {
                wordsContaining.add(i);
            }
        }
        return wordsContaining;
    }

    public int findMaximumLength(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {

            }
        }
        return nums.length;
    }
}
