package destiny.bu;

import destiny.bu.problems.BuyAndSellStock;
import destiny.bu.problems.RomanToInteger;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

//        PascalsTriangle solution = new PascalsTriangle();
//        Object result = solution.getRow(33);

//        SearchInsertPosition solution = new SearchInsertPosition();
//        Object result = solution.searchInsert(new int[]{2, 7, 8, 9, 10}, 9);

//        RemoveDuplicatesFromArrayTwo solution = new RemoveDuplicatesFromArrayTwo();
//        int[] array = {0, 0, 1};
//        Object result = solution.removeDuplicates(array) + " " + Arrays.toString(array);

//        RotateArray solution = new RotateArray();
//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        solution.rotate(array, 3);

//        BuyAndSellStock solution = new BuyAndSellStock();
//        Object result = solution.maxProfit(new int[]{1, 4, 2});

        RomanToInteger solution = new RomanToInteger();
        Object result = solution.romanToIntApproachTwo("MCMXCIV");

        long endTime = System.nanoTime();
        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + "ns | Result : " + result);
    }
}