package service.api;

import io.restassured.response.Response;
import service.api.endpoints.HealthCheckEndpoints;

public class HealthCheckServiceImpl {

    private final CommonService service;

    public HealthCheckServiceImpl() {
        service = new CommonService();
    }

    public Response healthCheck() {
        return service.get(HealthCheckEndpoints.HEALTH_CHECK);
    }

}
