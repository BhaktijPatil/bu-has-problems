package destiny.bu;

import destiny.bu.algorithms.MergeSortedArrays;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

        MergeSortedArrays solution = new MergeSortedArrays();
//        Object result = solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        long endTime = System.nanoTime();
//        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + " | Result : " + result);
    }
}