package destiny.bu;

import destiny.bu.problems.RemoveDuplicatesFromArray;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

//        PascalsTriangle solution = new PascalsTriangle();
//        Object result = solution.getRow(33);

//        SearchInsertPosition solution = new SearchInsertPosition();
//        Object result = solution.searchInsert(new int[]{2, 7, 8, 9, 10}, 9);

        RemoveDuplicatesFromArray solution = new RemoveDuplicatesFromArray();
        int[] array = {1,1,1,2,2,2,3,3};
        Object result = solution.removeDuplicatesApproachTwo(array) + " " + Arrays.toString(array);

        long endTime = System.nanoTime();
        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + "ns | Result : " + result);
    }
}