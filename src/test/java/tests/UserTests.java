package tests;

import actions.HealthCheckActions;
import actions.UserActions;
import model.UserRequest;
import model.UserResponse;
import org.testng.annotations.Test;
import utils.LoggerUtils;
import utils.PropertyUtils;

public class UserTests extends Hooks {

    @Test
    public void testMethod() {
        LoggerUtils.infoTest("Health check step");

        if (healthCheck() == 200) {
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
        } else {
            LoggerUtils.infoTest("Health check failed. Skipping further steps.");
        }
    }

}
