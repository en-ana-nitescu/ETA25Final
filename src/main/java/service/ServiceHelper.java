package service;

import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tools.jackson.databind.ObjectMapper;
import utils.LoggerUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ServiceHelper {

    public static void requestLogs(RequestSpecification requestSpecification, String path, String methodType) {
        LoggerUtils.infoTest("====Request info====");
        LoggerUtils.infoTest(getRequestURL(path));
        LoggerUtils.infoTest(getRequestMethod(methodType));
        LoggerUtils.infoTest(getRequestBody(requestSpecification));
    }

    public static void responseLogs(Response response) {
        LoggerUtils.infoTest("====Response info====");
        LoggerUtils.infoTest(getResponseStatusCode(response));
        LoggerUtils.infoTest(getResponseStatus(response));
        LoggerUtils.infoTest(getResponseTime(response));
        LoggerUtils.infoTest(getResponseBody(response));
    }

    private static String getRequestURL(String path) {
        return "Request URI: https://demoqa.com/" + path;
    }

    private static String getRequestMethod(String methodType) {
        return "Request Method: " + methodType;
    }

    private static String getRequestBody(RequestSpecification requestSpecification) {
        String json = "";
        Object requestBody = ((RequestSpecificationImpl) requestSpecification).getBody();
        if (requestBody != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.readTree(requestBody.toString()).toPrettyString();
        }
        return "Request body: \n" + json;
    }

    private static String getResponseStatusCode(Response response) {
        return "Response status code: " + response.getStatusCode();
    }

    private static String getResponseStatus(Response response) {
        return "Response status: " + response.getStatusLine();
    }

    private static String getResponseTime(Response response) {
        return "Response time seconds: " + response.timeIn(TimeUnit.SECONDS);
    }

    private static String getResponseBody(Response response) {
        if (response.getBody() != null) {
            return "Response body: \n" + response.getBody().asPrettyString();
        } else {
            return "Response body is empty";
        }
    }
}
