package StepDefinitions;

import io.cucumber.java.en.Given;
import sogeti.api.context.World;

public class LoginStepDefinitions {

    private World world;

    public LoginStepDefinitions(World world) {
        this.world = world;
    }
    @Given("user wants to access the wizard-world-api")
    public void userWantsToAccessTheWizardWorldApi() {
        world.setHost("https://wizard-world-api.herokuapp.com/");
    }
}
