package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sogeti.api.context.World;

public class WizardStepDefinitions {

    private Response response;
    private final Logger logger = LoggerFactory.getLogger(WizardStepDefinitions.class);
    private World world;

    public WizardStepDefinitions(World world)  {

        this.world = world;
    }

    @Given("that user wants to review the list of Elixirs")
    public void usingElixirEndpoint() {
        world.setBaseUri("Elixirs");
    }

    @When("the user asks for a list of all elixirs")
    public void getListElixirs() {
        response = RestAssured.given()
                .log().all()
                .baseUri(world.getHost())
                .basePath(world.getBaseUri())
                .get();
    }

    @Then("the user receives a list of all elixirs and their ids")
    public void receiveListElixirs() {

            response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/elixirs.json"));

    }


    @And("the user receives a successful response for a list request")
    public void theUserReceivesASuccessfulHttpStatusCode() {
        response.then().assertThat().statusCode(200);
    }
}
