package actions;

import io.restassured.response.Response;
import service.HealthCheckServiceImpl;
import utils.ResponseStatus;

import static org.testng.Assert.assertEquals;

public class HealthCheckActions {

    private final HealthCheckServiceImpl healthCheckService;
    Response response;

    public HealthCheckActions() {
        healthCheckService = new HealthCheckServiceImpl();
    }

    public int healthCheck() {
        response = healthCheckService.healthCheck();
        assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
        assertEquals(response.jsonPath().getString("message"), "Notes API is Running");
        return response.getStatusCode();
    }
}
