package StepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import services.ConfigurationService;
import sogeti.api.context.World;

public class LoginStepDefinitions {

    private World world;
    private ConfigurationService service;

    public LoginStepDefinitions(World world, ConfigurationService configurationService) {

        this.world = world;
        this.service = configurationService;
    }
    @Given("user wants to access the {string} api")
    public void userWantsToAccessTheWizardWorldApi(String apiName) {
        service.initializeApis();
        RestAssured.basePath = service.getApis().getApi(apiName).getBaseUrl();
    }
}
