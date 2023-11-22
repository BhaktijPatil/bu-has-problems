package destiny.bu.online.tests;

import java.util.List;

public class GoldmanSachsInterviewQuestion {
    /*
      Instructions to candidate.
      1) Run this code in the REPL to observe its behaviour. The
       execution entry point is main.
      2) Consider adding some additional tests in doTestsPass().
      3) Implement getLowestPrices() correctly.
      4) If time permits, some possible follow-ups.
      Question:
      A popular online retailer allows vendors to specify different prices in advance
      for the same item throughout the day. We now need to design an algorithm that
      helps identify the lowest price for the item at any point of the day.
      Assumptions:
      1) For the algorithm, assume all vendors are selling the same product
      and there is only one product being sold. Given a list that has
      vendor information - ( startTime, endTime, price ) of the deal,
      return a sorted list with different possible intervals and
      the least price of the product during the interval.
      2) The interval is inclusive of start and end time.
      3) All the 3 values passed by the vendor are integers.
    */
    class Problem1 {
        /* Problem Name is &&& Lowest Price &&& PLEASE DO NOT REMOVE THIS LINE. */

        // different prices in advance for the same item throughout the day
        // identify the lowest price for the item at any point of the day.
        // all vendors are selling the same product and there is only one product being sold
        // return a sorted list with different possible intervals and the least price of the product during the interval.

        public class Solution1 {

            /**
             * Execution entry point.
             */
            public static void main(String[] args) {
                if (doTestsPass()) {
                    System.out.println("All tests passed");
                } else {
                    System.out.println("Tests failed");
                }
            }

            private static List<Interval> getLowestPrices(List<Interval> vendors) {
                // Solve here
                return null;
            }

            /**
             * Returns true if the tests pass. Otherwise, false.
             */
            private static boolean doTestsPass() {
                var inputList = List.of(
                        new Interval(1, 5, 20),
                        new Interval(3, 8, 15),
                        new Interval(7, 10, 8));
                var expectedList = List.of(
                        new Interval(1, 3, 20),
                        new Interval(3, 7, 15),
                        new Interval(7, 10, 8));

                return expectedList.equals(getLowestPrices(inputList));
            }

            private record Interval(int startTime, int endTime, int price) {
            }
        }
    }

    class Problem2 {
        /* Problem Name is &&& Snowpack &&& PLEASE DO NOT REMOVE THIS LINE. */
        class Solution2 {
            /*
             ** Instructions to candidate.
             **  1) Given an array of non-negative integers representing the elevations
             **     from the vertical cross section of a range of hills, determine how
             **     many units of snow could be captured between the hills.
             **
             **     See the example array and elevation map below.
             **                                 ___
             **             ___                |   |        ___
             **            |   |        ___    |   |___    |   |
             **         ___|   |    ___|   |   |   |   |   |   |
             **     ___|___|___|___|___|___|___|___|___|___|___|___
             **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
             **                                 ___
             **             ___                |   |        ___
             **            |   | *   *  _*_  * |   |_*_  * |   |
             **         ___|   | *  _*_|   | * |   |   | * |   |
             **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
             **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
             **
             **     Solution: In this example 13 units of snow (*) could be captured.
             **
             **  2) Consider adding some additional tests in doTestsPass().
             **  3) Implement computeSnowpack() correctly.
             */

            /*
             **  Find the amount of snow that could be captured.
             */
            public static int computeSnowpack(int[] arr) {
                int startIndex = 0;
                int totalSnowArea = 0;
                int currHillArea = 0;
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] > arr[startIndex] && i - startIndex == 1) {
                        startIndex = i;
                        System.out.println("Start Index Update : " + startIndex);
                    } else if (arr[i] > arr[startIndex] && i - startIndex > 1) {
                        totalSnowArea += Math.min(arr[startIndex], arr[i]) * (i - startIndex - 1) - currHillArea;
                        System.out.println("Snow Area Update : " + totalSnowArea);
                        startIndex = i;
                        System.out.println("Start Index Update : " + startIndex);
                    } else {
                        currHillArea += arr[i];
                        System.out.println("Hill area Update : " + arr[i]);
                    }
                }
                if (startIndex != arr.length - 1) {
                    int max = 0;
                    currHillArea = 0;
                    for (int i = arr.length - 1; i > startIndex; i--) {
                        if (arr[i] > arr[max]) {
                            max = i;
                            currHillArea = 0;
                            System.out.println("Max Update : " + arr[max]);
                        } else {
                            currHillArea += arr[i];
                            System.out.println("Hill area Update : " + arr[i]);
                        }
                    }
                    System.out.println("Snow Area Update : " + (arr[max] * (max - startIndex - 1) - currHillArea));
                    totalSnowArea += arr[max] * (max - startIndex - 1) - currHillArea;
                }

                System.out.println(totalSnowArea);
                return totalSnowArea;
            }

            /*
             **  Returns true if the tests pass. Otherwise, returns false;
             */
            public static boolean doTestsPass() {
                boolean result = true;
                result &= computeSnowpack(new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 13;
                return result;
            }

            /*
             **  Execution entry point.
             */
            public static void main(String[] args) {
                if (doTestsPass()) {
                    System.out.println("All tests pass");
                } else {
                    System.out.println("Tests fail.");
                }
            }
        }
    }
}
