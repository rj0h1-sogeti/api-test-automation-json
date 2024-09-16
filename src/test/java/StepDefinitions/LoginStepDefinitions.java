package StepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import services.ConfigurationService;
import sogeti.api.context.World;

public class LoginStepDefinitions {

    private ConfigurationService service;

    public LoginStepDefinitions(ConfigurationService configurationService) {

        this.service = configurationService;
    }
    @Given("user wants to access the {string} api")
    public void userWantsToAccessTheWizardWorldApi(String apiName) {

        service.initializeApis();
        RestAssured.baseURI = service.getApis().getApi(apiName).getScheme() + "://"
                + service.getApis().getApi(apiName).getUri();

    }
}
