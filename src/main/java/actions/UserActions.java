package actions;

import io.restassured.response.Response;
import model.UserRequest;
import model.UserResponse;
import service.UserServiceImpl;
import utils.ResponseStatus;

import static org.testng.Assert.assertEquals;

public class UserActions {

    private final UserServiceImpl userServiceImpl;
    Response response;
    //UserResponse userResponse;

    public UserActions() {
        userServiceImpl = new UserServiceImpl();
    }

    public UserResponse createUser(UserRequest body) {
        response = userServiceImpl.createUser(body);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_CREATED);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "User account created successfully");
        assertEquals(userResponse.getData().getEmail(), body.getEmail());
        assertEquals(userResponse.getData().getName(), body.getName());

        return userResponse;
    }

    public UserResponse login(UserRequest body) {
        response = userServiceImpl.login(body);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "Login successful");
        assertEquals(userResponse.getData().getEmail(), body.getEmail());
        assertEquals(userResponse.getData().getName(), body.getName());

        return userResponse;
    }

    public UserResponse getUserDetails(String token) {
        response = userServiceImpl.getUserDetails(token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "Profile successful");

        return userResponse;
    }

    public UserResponse updateUserDetails(UserRequest body, String token) {
        response = userServiceImpl.updateUserDetails(body, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "Profile updated successful");
        assertEquals(userResponse.getData().getName(), body.getName());
        assertEquals(userResponse.getData().getEmail(), body.getEmail());
        assertEquals(userResponse.getData().getPhone(), body.getPhone());
        assertEquals(userResponse.getData().getCompany(), body.getCompany());

        return userResponse;
    }

    public UserResponse forgotPassword(UserRequest body, String token) {
        response = userServiceImpl.forgotPassword(body, token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "Password reset link successfully sent to " + body.getEmail() + ". Please verify by clicking on the given link");

        return userResponse;
    }

    public UserResponse userLogout(String token) {
        response = userServiceImpl.userLogout(token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "User has been successfully logged out");

        return userResponse;
    }

    public UserResponse deleteAccount(String token) {
        response = userServiceImpl.deleteAccount(token);
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        UserResponse userResponse = response.body().as(UserResponse.class);
        assertEquals(userResponse.getSuccess(), true);
        assertEquals(userResponse.getMessage(), "Successful Request");

        return userResponse;
    }
}
