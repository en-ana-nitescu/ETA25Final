package service.ui;


import config.Configuration;
import config.GeneralXml;
import org.openqa.selenium.WebDriver;
import service.ui.local.ChromeBrowserService;
import service.ui.remote.ChromeBrowserRemoteService;

public class BrowserFactory {

    public WebDriver getDriver() {
        String ciCd = System.getProperty("ciCd");
        String browser = System.getProperty("browser");

        Configuration configuration = GeneralXml.createConfig(Configuration.class);

        if (Boolean.parseBoolean(ciCd)) {
            configuration.frontendConfig.headless = true;

            switch (browser) {
                case BrowserType.CHROME:
                    ChromeBrowserRemoteService browserService = new ChromeBrowserRemoteService();
                    browserService.openBrowser(configuration.frontendConfig);
                    return browserService.getDriver();
                case BrowserType.FIREFOX:

            }
        } else {
            browser = configuration.frontendConfig.localBrowser;

            switch (browser) {
                case BrowserType.CHROME:
                    ChromeBrowserService browserService = new ChromeBrowserService();
                    browserService.openBrowser(configuration.frontendConfig);
                    return browserService.getDriver();
                case BrowserType.FIREFOX:
            }
        }

        return null;
    }
}
