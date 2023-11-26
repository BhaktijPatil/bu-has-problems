package destiny.bu.problems.medium;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

/*
Two adjacent values cannot be chosen
Choose max sum

Start house has to be house 0 ot house 1

Approach 1 ->
maxRobbery[nums.length]
maxRobbery[0] = nums[0]
maxRobbery[1] = nums[1]
maxRobbery[2] = nums[0] + nums[2]
maxRobbery[3] = nums[0] + nums[3] OR nums[1] + nums[3] = Math.max(maxRobbery[n-2], maxRobbery[n-3]) + nums[n]
maxRobbery[4] = nums[0] + nums[2] + nums[4] OR nums[1] + nums[4] = Math.max(maxRobbery[n-2], maxRobbery[n-3]) + nums[n]

[100 0 0 100 1 1 100]
*/

public class MaxRobbery {
    public int rob(int[] nums) {

        int houseCount = nums.length;

        if (houseCount == 1) {
            return nums[0];
        }

        int[] maxRobbery = new int[houseCount];

        if (houseCount > 2) {
            maxRobbery[2] = nums[2] + nums[0];
        }
        if (houseCount > 1) {
            maxRobbery[1] = nums[1];
        }
        if (houseCount > 0) {
            maxRobbery[0] = nums[0];
        }

        for (int i = 3; i < houseCount; i++) {
            maxRobbery[i] = Math.max(maxRobbery[i - 2], maxRobbery[i - 3]) + nums[i];
        }

        return Math.max(maxRobbery[houseCount - 1], maxRobbery[houseCount - 2]);
    }
}
