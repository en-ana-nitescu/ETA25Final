package tests;

import actions.UserActions;
import model.UserRequest;
import model.UserResponse;
import org.testng.annotations.Test;
import utils.LoggerUtils;
import utils.PropertyUtils;

public class UserTests {

    UserActions userActions;
    public PropertyUtils propertyUtils;
    UserRequest userRequest;
    UserResponse userResponse;
    public String userId;
    public String email;
    public String token;

    @Test
    public void testMethod() {
        LoggerUtils.infoTest("Step1: create new user");
        createUser();

        LoggerUtils.infoTest("Step2: login with created user");
        login();

        LoggerUtils.infoTest("Step3: get user details");
        getUserDetails();

        LoggerUtils.infoTest("Step4: update user details");
        updateUserDetails();

        LoggerUtils.infoTest("Step5: send password reset request");
        forgotPassword();

        LoggerUtils.infoTest("Step6: logout user");
        userLogout();
    }

    public void createUser() {
        userActions = new UserActions();
        propertyUtils = new PropertyUtils("userData");
        userRequest = new UserRequest(propertyUtils.getAllData());

        userResponse = userActions.createUser(userRequest);
        userId = userResponse.getData().getId();
        email = userResponse.getData().getEmail();
    }

    public void login() {
        userRequest.setEmail(email);
        userResponse = userActions.login(userRequest);
        token = userResponse.getData().getToken();
    }

    public void getUserDetails() {
        userResponse = userActions.getUserDetails(token);
    }

    public void updateUserDetails() {
        userResponse = userActions.updateUserDetails(userRequest, token);
    }

    public void forgotPassword() {
        userResponse = userActions.forgotPassword(userRequest, token);
    }

    public void userLogout() {
        userResponse = userActions.userLogout(token);
    }

    //TODO: deleteUser method can be added later
}
