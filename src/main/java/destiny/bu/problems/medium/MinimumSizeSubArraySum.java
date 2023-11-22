package destiny.bu.problems.medium;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

import java.util.Comparator;
import java.util.List;

public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        List.of(1).stream().max(Comparator.comparingInt(value -> value));
        int minLength = Integer.MAX_VALUE;
        int currLenStart = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - currLenStart + 1);
                sum -= nums[currLenStart];
                currLenStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
