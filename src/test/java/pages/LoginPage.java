package pages;

import core.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    /**
     * Opens the SauceDemo login page using URL from config.properties.
     */
    public void openLoginPage() {
        driver.get(ConfigReader.getProperty("app.baseUrl"));
    }

    /**
     * Performs login with provided username and password.
     */
    public void login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
    }

    /**
     * Returns login error message text.
     */
    public String getErrorMessageText() {
        return getText(errorMessage);
    }
}