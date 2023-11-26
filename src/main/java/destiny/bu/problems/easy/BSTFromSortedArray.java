package destiny.bu.problems.easy;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BSTFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return formTree(nums, 0, nums.length - 1);
    }

    private TreeNode formTree(int[] nums, int currMinIndex, int currMaxIndex) {
        if(currMinIndex > currMaxIndex){
            return null;
        }
        int mid = (currMinIndex + currMaxIndex)/2;
        return new TreeNode(nums[mid], formTree(nums, currMinIndex, mid - 1) , formTree(nums, mid + 1, currMaxIndex));
    }
}
