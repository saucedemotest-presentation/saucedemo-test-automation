package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@LOGIN",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/login.html",
                "json:target/cucumber-reports/login.json"
        },
        monochrome = true,
        dryRun = false
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}