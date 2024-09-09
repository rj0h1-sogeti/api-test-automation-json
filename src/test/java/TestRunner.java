import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/wizard.feature")
@ConfigurationParameter(key = "cucumber.glue", value = "StepDefinitions")
@ConfigurationParameter(key = "cucumber.plugin", value = "html:target/cucumber.html")
public class TestRunner {
}
