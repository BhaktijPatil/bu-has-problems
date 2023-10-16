package destiny.bu;

import destiny.bu.algorithms.MergeSortedArrays;
import destiny.bu.algorithms.ValidParenthesis;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

        ValidParenthesis solution = new ValidParenthesis();
        Object result = solution.isValid("()");

        long endTime = System.nanoTime();
        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + "ns | Result : " + result);
    }
}