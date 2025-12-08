package actions.ui;

import model.ui.UserAccount;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

public class RegisterUIActions extends BaseUIActions {

    public RegisterUIActions(WebDriver driver) {
        super(driver);
    }

    private RegisterPage registerPage;

    public void registerNewUser() {
        UserAccount userAccount = new UserAccount("src/test/resources/ui/createAccountData.json");
        registerPage = new RegisterPage(driver);
        registerPage.registerUser(userAccount);
    }
}
