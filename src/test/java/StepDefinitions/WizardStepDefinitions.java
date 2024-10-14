package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class WizardStepDefinitions {

    private Response response;

    public WizardStepDefinitions(LoginStepDefinitions loginStepDefinitions)  {
    }

    @Given("that user wants to review the list of Elixirs")
    public void usingElixirEndpoint() {
        RestAssured.basePath = "Elixirs";
    }

    @When("the user asks for a list of all elixirs")
    public void getListElixirs() {
        response = RestAssured.given()
                .log().all()
                .get();
    }

    @Then("the user receives a list of all elixirs and their ids")
    public void receiveListElixirs() {

            response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/ElixirDto.json"));

    }


    @And("the user receives a successful response for a list request")
    public void theUserReceivesASuccessfulHttpStatusCode() {
        response.then().assertThat().statusCode(200);
    }
}
