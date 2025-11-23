package service;

import io.restassured.response.Response;
import model.UserRequest;
import service.endpoints.UserEndpoints;

public class UserServiceImpl implements UserServiceInterface {

    private final CommonService service;

    public UserServiceImpl() {
        service = new CommonService();
    }

    @Override
    public Response createUser(UserRequest body) {
        return service.post(body, UserEndpoints.USER_POST);
    }

    @Override
    public Response login(UserRequest body) {
        return service.post(body, UserEndpoints.USER_LOGIN);
    }

    @Override
    public Response getUserDetails(String token) {
        return service.get(token, UserEndpoints.USER_DETAILS);
    }

    @Override
    public Response updateUserDetails(UserRequest body, String token) {
        return service.patch(body, token, UserEndpoints.USER_DETAILS);
    }

    @Override
    public Response forgotPassword(UserRequest body, String token) {
        return service.post(body, token, UserEndpoints.FORGOT_PASSWORD);
    }

    @Override
    public Response userLogout(String token) {
        return service.delete(token, UserEndpoints.USER_LOGOUT);
    }

    @Override
    public Response deleteAccount(String token) {
        return service.delete(token, UserEndpoints.DELETE_ACCOUNT);
    }

}
