package destiny.bu;

import destiny.bu.dynamic.programming.MinCostForPainting;
import destiny.bu.interfaces.Solution;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

        Solution solution = new MinCostForPainting();
        Object result = solution.run();

        long endTime = System.nanoTime();
        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + " | Result : " + result);
    }
}