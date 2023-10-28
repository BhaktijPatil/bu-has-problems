package destiny.bu;

import destiny.bu.online.tests.Result;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        long startTime = System.nanoTime();

//        Object result = Result.getScoreDifference(List.of(3, 6, 2, 3, 5));
        Object result = Result.maxProfit(1, 10, List.of(30, 59, 110));

        long endTime = System.nanoTime();
        LOGGER.info("Execution | Success | Time to Run : " + (endTime - startTime) + "ns | Result : " + result);
    }
}