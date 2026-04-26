package pages;

import core.DriverFactory;
import core.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class BasePage {

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        int explicitWait = Integer.parseInt(ConfigReader.getProperty("wait.explicit"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }

    protected void click(By locator) {
        logger.info("Clicking element: {}", locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        demoPause();
    }

    protected void type(By locator, String text) {
        logger.info("Typing into element: {}", locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
        demoPause();
    }

    protected String getText(By locator) {
        logger.info("Getting text from element: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isDisplayed(By locator) {
        logger.info("Checking visibility of element: {}", locator);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitForElementVisible(By locator) {
        logger.info("Waiting for element to be visible: {}", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void demoPause() {
        String demoMode = ConfigReader.getProperty("demo.mode");
        if ("true".equalsIgnoreCase(demoMode)) {
            try {
                int delay = Integer.parseInt(ConfigReader.getProperty("demo.delay"));
                Thread.sleep(delay);
            } catch (Exception ignored) {}
        }
    }
}