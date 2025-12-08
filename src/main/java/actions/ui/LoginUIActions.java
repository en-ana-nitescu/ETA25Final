package actions.ui;

import context.DataContext;
import context.keys.RequestKeys;
import model.ui.UserAccount;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginUIActions extends BaseUIActions {

    private LoginPage loginPage;

    public LoginUIActions(WebDriver driver) {
        super(driver);
    }

    public void logIntoApplication() {
        UserAccount userAccount = DataContext.getData(RequestKeys.REQUEST_OBJECT.getKey(), UserAccount.class);
        loginPage = new LoginPage(driver);
        loginPage.logIntoApplication(userAccount);
    }
}
