package service.ui.remote;

import config.FrontendConfig;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import service.ui.BrowserService;


import java.net.URL;
import java.time.Duration;

@Getter
public class ChromeBrowserRemoteService implements BrowserService
{

    private WebDriver driver;

    @SneakyThrows
    @Override
    public void openBrowser(FrontendConfig frontendConfig) {
        ChromeOptions chromeOptions = (ChromeOptions) getBrowserOptions(frontendConfig);
        driver = new RemoteWebDriver(new URL(frontendConfig.remoteUrl), chromeOptions);
        driver.get(frontendConfig.url);
        driver.manage().window().maximize();
    }

    @Override
    public Object getBrowserOptions(FrontendConfig frontendConfig) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(frontendConfig.gpu);
        chromeOptions.addArguments(frontendConfig.infoBars);
        chromeOptions.addArguments(frontendConfig.sandbox);
        if (frontendConfig.headless == true) {
            chromeOptions.addArguments("--headless=new");
        }
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(frontendConfig.implicitWait));
        chromeOptions.setScriptTimeout(Duration.ofSeconds(frontendConfig.scriptTimeout));
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(frontendConfig.pageLoadTimeout));
        return chromeOptions;
    }
}
