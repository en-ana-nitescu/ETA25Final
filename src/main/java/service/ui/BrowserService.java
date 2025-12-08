package service.ui;


import config.FrontendConfig;

public interface BrowserService {

    void openBrowser(FrontendConfig frontendConfig);
    Object getBrowserOptions(FrontendConfig frontendConfig);
}
