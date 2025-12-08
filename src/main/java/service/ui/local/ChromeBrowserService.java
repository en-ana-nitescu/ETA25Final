package service.ui.local;


import config.FrontendConfig;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import service.ui.BrowserService;


import java.time.Duration;

@Getter
public class ChromeBrowserService implements BrowserService
{

    private WebDriver driver;

    @Override
    public void openBrowser(FrontendConfig frontendConfig) {
        ChromeOptions chromeOptions = (ChromeOptions) getBrowserOptions(frontendConfig);
        driver = new ChromeDriver(chromeOptions);
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
