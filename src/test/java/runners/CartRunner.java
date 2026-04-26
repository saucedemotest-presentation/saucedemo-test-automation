package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        tags = "@CART",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cart.html",
                "json:target/cucumber-reports/cart.json"
        },
        monochrome = true,
        dryRun = false
)
public class CartRunner extends AbstractTestNGCucumberTests {
}