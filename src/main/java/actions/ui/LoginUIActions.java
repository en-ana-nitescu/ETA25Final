package actions.ui;

import model.ui.UserAccount;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginUIActions extends BaseUIActions {

    private LoginPage loginPage;

    public LoginUIActions(WebDriver driver) {
        super(driver);
    }

    public void logIntoApplication() {
        //UserAccount userAccount = DataContext.getData(RequestKeys.REQUEST_OBJECT.getKey(), UserAccount.class);
        UserAccount userAccount = new UserAccount("src/test/resources/ui/createAccountData.json");
        loginPage = new LoginPage(driver);
        loginPage.logIntoApplication(userAccount);
    }
}
