package StepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class LoginStepDefinitions {

    @Given("user wants to access the wizard api")
    public void userWantsToAccessTheWizardWorldApi() {

        RestAssured.baseURI = "http://wizard-world-api.herokuapp.com";

    }
}
