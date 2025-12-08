package pages;

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

/*    public SecureAreaPage logIntoApplication(RequestAccount requestAccount) {
        usernameElement.sendKeys(requestAccount.getUserName());
        LoggerUtils.info("The user fills the username " + requestAccount.getUserName());

        passwordElement.sendKeys(requestAccount.getPassword());
        LoggerUtils.info("The user fills the password " + requestAccount.getPassword());

        loginElement.click();
        LoggerUtils.info("The user click on login button");

        return new ProfilePage(driver);
    }*/

}
