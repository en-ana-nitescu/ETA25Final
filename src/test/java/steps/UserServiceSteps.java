package steps;

import actions.ui.LoginUIActions;
import actions.ui.RegisterUIActions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import service.ui.SharedData;

public class UserServiceSteps extends BaseSteps {

    private Hooks hooks;
    private RegisterUIActions registerUIActions;
    private LoginUIActions loginUIActions;

    public UserServiceSteps(SharedData sharedData) {
        super(sharedData);
    }

    @When("I create a new account from back-end")
    public void createNewAccountFromBackEnd() {
        hooks = new Hooks(sharedData);
        hooks.createUser();
    }

    @And("I login with the new account")
    public void loginWithNewAccount() {
        hooks.login();
    }

    @Then("I retrieve the user details")
    public void retrieveUserDetails() {
        hooks.getUserDetails();
    }


    @Given("I register new user from ui")
    public void registerNewUserFromUi() {
        registerUIActions = new RegisterUIActions(sharedData.getDriver());
        registerUIActions.registerNewUser();
    }

    @Then("I can login with the new user")
    public void iCanLoginWithTheNewUser() {
        loginUIActions = new LoginUIActions(sharedData.getDriver());
        loginUIActions.logIntoApplication();
    }
}
