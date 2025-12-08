package utils;

import io.cucumber.java.Scenario;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

    @Getter
    private static Scenario scenario;
    private static final Logger logger = LogManager.getLogger();

    public static void startTestCase(String scenarioName, Scenario scenario) {
        LoggerUtils.scenario = scenario;
        //logger.info("****** Execution started: " + testName + " ******");
        String message = String.format("========== Execution Started: %s ==========", scenarioName);
        logger.info(message);
        scenario.log(message);
    }

    public static void endTestCase(String scenarioName) {
        //logger.info("****** Execution ended: " + testName + " ******");
        String message = String.format("========== Execution Finished: %s ==========", scenarioName);
        logger.info(message);
        scenario.log(message);
    }

    public static void infoTest(String message) {
        logger.info(message);
    }

    public static void info(Object message) {
        logger.info(message);
        scenario.log(message.toString());
    }

    public static void errorTest(String message) {
        logger.error(message);
    }
}
