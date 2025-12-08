package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/UserTestsFeature.feature",
        glue = {"steps"},
        plugin = {"pretty",
                "json:target/cucumber-html-reports/UserTestsFeature.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
