package tests;

import org.testng.annotations.Test;
import service.ui.SharedData;
import steps.Hooks;
import utils.LoggerUtils;

public class UserTests extends Hooks {

    public UserTests(SharedData sharedData) {
        super(sharedData);
    }

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

            LoggerUtils.infoTest("Step7: login again with created user");
            login();

            LoggerUtils.infoTest("Step8: delete user account");
            deleteAccount();

        } else {
            LoggerUtils.infoTest("Health check failed. Skipping further steps.");
        }
    }

}
