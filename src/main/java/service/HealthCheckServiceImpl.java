package service;

import io.restassured.response.Response;
import service.endpoints.HealthCheckEndpoints;

public class HealthCheckServiceImpl {

    private final CommonService service;

    public HealthCheckServiceImpl() {
        service = new CommonService();
    }

    public Response healthCheck() {
        return service.get(HealthCheckEndpoints.HEALTH_CHECK);
    }

}
