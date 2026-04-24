package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    // Get driver instance from DriverFactory
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    /**
     * Click action on element
     */
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Type text into input field
     */
    protected void type(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Get visible text from element
     */
    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Check if element is displayed
     */
    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}