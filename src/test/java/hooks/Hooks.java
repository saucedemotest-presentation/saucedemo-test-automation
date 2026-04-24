package hooks;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
     * Closes the browser and removes the driver instance.
     */
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}