package service;

import io.restassured.response.Response;
import model.UserRequest;

public interface UserServiceInterface {

    Response createUser(UserRequest body);
    Response login(UserRequest body);
    Response getUserDetails(String token);
    Response updateUserDetails(UserRequest body, String token);
    Response forgotPassword(UserRequest body, String token);
    Response userLogout(String token);
    Response deleteAccount(String token);

}
