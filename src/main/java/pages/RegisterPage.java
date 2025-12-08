package pages;

import model.ui.UserAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LoggerUtils;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(css = "#register > button")
    private WebElement registerElement;

    public LoginPage registerUser(UserAccount userAccount) {
        usernameElement.sendKeys(userAccount.getUserName());
        LoggerUtils.info("The user fills the username " + userAccount.getUserName());

        passwordElement.sendKeys(userAccount.getPassword());
        LoggerUtils.info("The user fills the password " + userAccount.getPassword());

        confirmPassword.sendKeys(userAccount.getPassword());
        LoggerUtils.info("The user confirms the password " + userAccount.getPassword());

        registerElement.click();
        LoggerUtils.info("The user submits the register form");

        return new LoginPage(driver);
    }

}
