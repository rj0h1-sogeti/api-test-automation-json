import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = "cucumber.plugin", value = "html:target/cucumber.html")
public class TestRunner {
}
