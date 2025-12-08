package pages;

import model.ui.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggerUtils;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "submit-login")
    private WebElement loginElement;

    public SecureAreaPage logIntoApplication(UserAccount userAccount) {
        usernameElement.sendKeys(userAccount.getUserName());
        LoggerUtils.info("The user fills the username " + userAccount.getUserName());

        passwordElement.sendKeys(userAccount.getPassword());
        LoggerUtils.info("The user fills the password " + userAccount.getPassword());

        loginElement.click();
        LoggerUtils.info("The user click on login button");

        return new SecureAreaPage(driver);
    }

}
