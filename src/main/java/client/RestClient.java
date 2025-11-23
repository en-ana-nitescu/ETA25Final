package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.PropertyUtils;
import utils.RequestType;

public class RestClient {

    PropertyUtils propertyUtils = new PropertyUtils("config");

    //method to configure the client
    private RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        requestSpecification.baseUri(propertyUtils.getAllData().get("baseUri"));
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification;
    }

    //method that returns a response based on client configuration
    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        switch (requestType) {
            case RequestType.REQUEST_POST:
                return prepareClient(requestSpecification).post(endpoint);
            case RequestType.REQUEST_GET:
                return prepareClient(requestSpecification).get(endpoint);
            case RequestType.REQUEST_PUT:
                return prepareClient(requestSpecification).put(endpoint);
            case RequestType.REQUEST_DELETE:
                return prepareClient(requestSpecification).delete(endpoint);
            case RequestType.REQUEST_PATCH:
                return prepareClient(requestSpecification).patch(endpoint);
        }
        return null;
    }
}
