package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    private static final Logger logger = LogManager.getLogger();

    public static void startTestCase(String testName) {
        logger.info("****** Execution started: " + testName + " ******");
    }

    public static void endTestCase(String testName) {
        logger.info("****** Execution ended: " + testName + " ******");
    }

    public static void infoTest(String message) {
        logger.info(message);
    }

    public static void errorTest(String message) {
        logger.error(message);
    }
}
