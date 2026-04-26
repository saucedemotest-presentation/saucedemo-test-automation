package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@CHECKOUT",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/checkout.html",
                "json:target/cucumber-reports/checkout.json"
        },
        monochrome = true,
        dryRun = false
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {
}