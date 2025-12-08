package service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import utils.LoggerUtils;
import utils.PropertyUtils;

import java.util.concurrent.TimeUnit;

public class ServiceHelper {

    static PropertyUtils propertyUtils = new PropertyUtils("config");

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
        return "Request URI: " + propertyUtils.getAllData().get("baseUri") + path;
    }

    private static String getRequestMethod(String methodType) {
        return "Request Method: " + methodType;
    }

    @SneakyThrows
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
