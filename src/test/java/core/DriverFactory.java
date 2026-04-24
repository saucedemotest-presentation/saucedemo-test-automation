package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // ThreadLocal ensures each test thread gets its own WebDriver instance
    // This helps in parallel execution and avoids conflicts between tests
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver instance
     * - Sets up the ChromeDriver using WebDriverManager
     * - Launches the browser
     * - Maximizes the browser window
     */
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    /**
     * Returns the current WebDriver instance
     * - Used across the framework to access the browser
     * - Ensures all classes use the same driver instance per test
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quits the WebDriver instance
     * - Closes the browser after test execution
     * - Removes the driver from ThreadLocal to prevent memory leaks
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}