package destiny.bu.online.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCodeContest {
    public static void main(String[] args) {
        System.out.println(sumCounts(List.of(1, 1)));
    }
//
//    public static int sumCounts(List<Integer> nums) {
//        long distinctCount = nums.stream().distinct().count();
//        long sumOfSquares = 0;
//        for (long i = 0; i < nums.size(); i++) {
//            long squareElement = Math.min(i + 1, distinctCount);
//            sumOfSquares += (nums.size() - i) * (squareElement) * (squareElement);
//        }
//        return Math.toIntExact(sumOfSquares);
//    }

    public static int sumCounts(List<Integer> nums) {
        int sumOfSquares = 0;

        for (long elementCount = 1; elementCount <= nums.size(); elementCount++) {
            for (long startIndex = 0; startIndex <= nums.size() - elementCount; startIndex++) {
                Set<Integer> distinctInts = new HashSet<>();
                long index = 0;
                while (index < elementCount) {
                    distinctInts.add(nums.get(Math.toIntExact(startIndex + index)));
                    index++;
                }
                sumOfSquares += distinctInts.size() * distinctInts.size();
            }
        }
        return sumOfSquares;
    }


    public int sumCounts(int[] nums) {
        long sumOfSquares = 0;

        for (long elementCount = 1; elementCount <= nums.length; elementCount++) {
            for (long startIndex = 0; startIndex <= nums.length - elementCount; startIndex++) {
                Set<Integer> distinctInts = new HashSet<>();
                long index = 0;
                while (index < elementCount) {
                    distinctInts.add(nums[Math.toIntExact(startIndex + index)]);
                    index++;
                }
                sumOfSquares = (sumOfSquares + ((long) distinctInts.size() * distinctInts.size())) % 1000000007;
            }
        }
        return Math.toIntExact(sumOfSquares);
    }
//
//    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//        List<Integer> smallNums = nums.stream().filter(num -> num < target).sorted().toList();
//        int longestSubsequence = -1;
//        for (int i = 0; i < smallNums.size(); i++) {
//            int remainingTarget = target - smallNums.get(i);
//            for (int j = 0; j < smallNums.size(); j++) {
//                for (int sequenceLength = 0; sequenceLength < smallNums.size(); sequenceLength++) {
//
//                }
//            }
//        }
//    }
//
//    public int minChanges(String s) {
//        int zeroCount = 0;
//        int oneCount = 0;
//
//        for (char c : s.toCharArray()) {
//            switch (c) {
//                case '0' -> zeroCount++;
//                case '1' -> oneCount++;
//            }
//        }
//
//        return Math.max(zeroCount, oneCount) - Math.min(zeroCount, oneCount);
//    }
}
