package destiny.bu.problems.medium;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 5, 4};
        System.out.println(new KthLargestElementInArray().findKthLargestWithArray(nums, 3));
    }

    // With priority queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = 0; i <= k - 1; i++) {
            heap.poll();
        }
        return heap.peek();
    }

    // With array
    public int findKthLargestWithArray(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i);
        }
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[nums.length - 1];
            nums = Arrays.copyOfRange(nums, 0, nums.length - 1);
            maxHeapify(nums, 0);
        }
        return nums[0];
    }

    private int maxHeapify(int[] nums, int i) {
        int right = i * 2 + 1;
        int left = i * 2 + 2;

        int largest = i;

        if (right < nums.length && nums[largest] < nums[right]) {
            largest = right;
        }

        if (left < nums.length && nums[largest] < nums[left]) {
            largest = left;
        }

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            return maxHeapify(nums, largest);
        }
        return nums[largest];
    }
}
