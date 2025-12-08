package service.ui;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;

@Getter
public class SharedData {

    private WebDriver driver;

    public void initializeDriver() {
        driver = new BrowserFactory().getDriver();
        LoggerUtils.info("Driver successfully initialized.");
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        LoggerUtils.info("Driver successfully closed.");
    }
}
