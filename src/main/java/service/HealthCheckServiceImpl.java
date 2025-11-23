package service;

import io.restassured.response.Response;

public class HealthCheckServiceImpl {

    private final CommonService service;

    public HealthCheckServiceImpl() {
        service = new CommonService();
    }

    public Response healthCheck() {
        return service.get(HealthCheckEndpoints.HEALTH_CHECK);
    }

}
