//package destiny.bu.online.tests;
//
///*
//100115. Find Champion I
//
//There are n teams numbered from 0 to n - 1 in a tournament.
//
//Given a 0-indexed 2D boolean matrix grid of size n * n. For all i, j that 0 <= i, j <= n - 1 and i != j team i is stronger than team j if grid[i][j] == 1, otherwise, team j is stronger than team i.
//
//Team a will be the champion of the tournament if there is no team b that is stronger than team a.
//
//Return the team that will be the champion of the tournament.
//
//Example 1:
//
//Input: grid = [[0,1],[0,0]]
//Output: 0
//Explanation: There are two teams in this tournament.
//grid[0][1] == 1 means that team 0 is stronger than team 1. So team 0 will be the champion.
//Example 2:
//
//Input: grid = [[0,0,1],[1,0,1],[0,0,0]]
//Output: 1
//Explanation: There are three teams in this tournament.
//grid[1][0] == 1 means that team 1 is stronger than team 0.
//grid[1][2] == 1 means that team 1 is stronger than team 2.
//So team 1 will be the champion.
//
//
//Constraints:
//
//n == grid.length
//n == grid[i].length
//2 <= n <= 100
//grid[i][j] is either 0 or 1.
//For all i, j that i != j, grid[i][j] != grid[j][i].
//The input is generated such that if team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.
// */
//
///*
//100116. Find Champion II
//
//There are n teams numbered from 0 to n - 1 in a tournament; each team is also a node in a DAG.
//
//You are given the integer n and a 0-indexed 2D integer array edges of length m representing the DAG, where edges[i] = [ui, vi] indicates that there is a directed edge from team ui to team vi in the graph.
//
//A directed edge from a to b in the graph means that team a is stronger than team b and team b is weaker than team a.
//
//Team a will be the champion of the tournament if there is no team b that is stronger than team a.
//
//Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return -1.
//
//Notes
//
//A cycle is a series of nodes a1, a2, ..., an, an+1 such that node a1 is the same node as node an+1, the nodes a1, a2, ..., an are distinct, and there is a directed edge from the node ai to node ai+1 for every i in the range [1, n].
//A DAG is a directed graph that does not have any cycle.
//
//
//Example 1:
//
//Input: n = 3, edges = [[0,1],[1,2]]
//Output: 0
//Explanation: Team 1 is weaker than team 0. Team 2 is weaker than team 1. So the champion is team 0.
//Example 2:
//
//Input: n = 4, edges = [[0,2],[1,3],[1,2]]
//Output: -1
//Explanation: Team 2 is weaker than team 0 and team 1. Team 3 is weaker than team 1. But team 1 and team 0 are not weaker than any other teams. So the answer is -1.
//
//Constraints:
//
//1 <= n <= 100
//m == edges.length
//0 <= m <= n * (n - 1) / 2
//edges[i].length == 2
//0 <= edge[i][j] <= n - 1
//edges[i][0] != edges[i][1]
//The input is generated such that if team a is stronger than team b, team b is not stronger than team a.
//The input is generated such that if team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.
// */
//
///*
//You are given a 0-indexed integer array nums.
//
//A subsequence of nums having length k and consisting of indices i0 < i1 < ... < ik-1 is balanced if the following holds:
//
//nums[ij] - nums[ij-1] >= ij - ij-1, for every j in the range [1, k - 1].
//A subsequence of nums having length 1 is considered balanced.
//
//Return an integer denoting the maximum possible sum of elements in a balanced subsequence of nums.
//
//A subsequence of an array is a new non-empty array that is formed from the original array by deleting some (possibly none) of the elements without disturbing the relative positions of the remaining elements.
//
//
//
//Example 1:
//
//Input: nums = [3,3,5,6]
//Output: 14
//Explanation: In this example, the subsequence [3,5,6] consisting of indices 0, 2, and 3 can be selected.
//nums[2] - nums[0] >= 2 - 0.
//nums[3] - nums[2] >= 3 - 2.
//Hence, it is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
//The subsequence consisting of indices 1, 2, and 3 is also valid.
//It can be shown that it is not possible to get a balanced subsequence with a sum greater than 14.
//Example 2:
//
//Input: nums = [5,-1,-3,8]
//Output: 13
//Explanation: In this example, the subsequence [5,8] consisting of indices 0 and 3 can be selected.
//nums[3] - nums[0] >= 3 - 0.
//Hence, it is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
//It can be shown that it is not possible to get a balanced subsequence with a sum greater than 13.
//Example 3:
//
//Input: nums = [-2,-1]
//Output: -1
//Explanation: In this example, the subsequence [-1] can be selected.
//It is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
// */
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class LeetCodeWeeklyContest {
//    public int findChampion(int[][] grid) {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[j][i] == 1) {
//                    break;
//                } else if (j == grid[i].length - 1) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public int findChampion(int[][] grid) {
//        int isCurrChampion = -1;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[j][i] == 1) {
//                    break;
//                } else if (j == grid[i].length - 1) {
//                    if (isCurrChampion != -1) {
//                        return -1;
//                    }
//                    isCurrChampion = i;
//                }
//            }
//        }
//        return isCurrChampion;
//    }
//
//    public int findChampion(int n, int[][] edges) {
//        int[][] grid = new int[n][n];
//        for (int i = 0; i < edges.length; i++) {
//            grid[edges[i][0]][edges[i][1]] = 1;
//        }
//        return findChampion(grid);
//    }
//
//    public long maxBalancedSubsequenceSum(int[] nums) {
//        int ptr1 = 0;
//        int ptr2 = 1;
//        int maxSum = 0;
//        int ptr2Temp = ptr2;
//
//        while (ptr2 < nums.length) {
//            if (nums[ptr1] < 0) {
//                ptr1++;
//            } else if (nums[ptr2] - nums[ptr1] >= ptr2 - ptr1) {
//                maxSum += nums[ptr1];
//                ptr1 = ptr2;
//                ptr2Temp = ptr2;
//            }
//            ptr2++;
//        }
//        if (maxSum != 0) {
//            maxSum += nums[ptr2Temp];
//        }
//        return maxSum == 0 ? Arrays.stream(nums).max().orElse(0) : maxSum;
//    }
//
//    public long maxBalancedSubsequenceSum(int[] nums) {
//        int ptr1 = 0;
//        int ptr2 = 1;
//        int maxSum = 0;
//        int ptr2Temp = ptr2;
//
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        while (ptr2 < nums.length) {
//            System.out.println(ptr1 + " " + ptr2);
//            if (nums[ptr1] < 0) {
//                ptr1++;
//            } else if (nums[ptr2] - nums[ptr1] >= ptr2 - ptr1) {
//                maxSum += nums[ptr1];
//                ptr1 = ptr2;
//                ptr2Temp = ptr2;
//            }
//            ptr2++;
//        }
//        maxSum += nums[ptr2Temp];
//        return Math.max(maxSum, Arrays.stream(nums).max().orElse(0));
//    }
//
//    public long maxBalancedSubsequenceSum(int[] nums) {
//        int ptr1 = 0;
//        int ptr2 = 1;
//        ArrayList<Integer> subSequence = new ArrayList<>();
//        while (ptr2 < nums.length) {
//            if (nums[ptr2] - nums[ptr1] >= ptr2 - ptr1) {
//                if (subSequence.isEmpty()) {
//                    subSequence.add(nums[ptr1]);
//                }
//                subSequence.add(nums[ptr2]);
//                ptr1 = ptr2;
//            }
//            ptr2++;
//        }
//        if (subSequence.isEmpty()) {
//            subSequence.add(Arrays.stream(nums).max().orElse(-100));
//        }
//        return subSequence.stream().mapToInt(Integer::intValue).sum();
//    }
//}
