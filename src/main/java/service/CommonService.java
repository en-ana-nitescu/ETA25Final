package service;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.RequestType;

public class CommonService {

    RequestSpecification requestSpecification;
    Response response;
    private static final String AUTHORIZATION_HEADER_KEY = "x-auth-token";

    public Response get(String endpoint) {
        requestSpecification = RestAssured.given();
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_GET);

        response = performRequest(RequestType.REQUEST_GET, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response post(Object body, String endpoint) {
        requestSpecification = RestAssured.given();
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_POST);

        response = performRequest(RequestType.REQUEST_POST, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response get(String token, String endpoint) {
        requestSpecification = RestAssured.given();
        requestSpecification.header(AUTHORIZATION_HEADER_KEY, token);
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_GET);

        response = performRequest(RequestType.REQUEST_GET, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response patch(Object body, String token, String endpoint) {
        requestSpecification = RestAssured.given();
        requestSpecification.header(AUTHORIZATION_HEADER_KEY, token);
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_PATCH);

        response = performRequest(RequestType.REQUEST_PATCH, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response post(Object body, String token, String endpoint) {
        requestSpecification = RestAssured.given();
        requestSpecification.header(AUTHORIZATION_HEADER_KEY, token);
        requestSpecification.body(body);
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_POST);

        response = performRequest(RequestType.REQUEST_POST, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    public Response delete(String token, String endpoint) {
        requestSpecification = RestAssured.given();
        requestSpecification.header(AUTHORIZATION_HEADER_KEY, token);
        ServiceHelper.requestLogs(requestSpecification, endpoint, RequestType.REQUEST_DELETE);

        response = performRequest(RequestType.REQUEST_DELETE, requestSpecification, endpoint);
        ServiceHelper.responseLogs(response);
        return response;
    }

    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endpoint);
    }
}
