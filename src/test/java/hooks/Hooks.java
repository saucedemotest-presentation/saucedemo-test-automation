package hooks;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    /**
     * Runs before each Cucumber scenario.
     * Starts a fresh browser instance for every test scenario.
     */
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    /**
     * Runs after each Cucumber scenario.
     * Captures screenshot on failure and closes browser.
     */
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}