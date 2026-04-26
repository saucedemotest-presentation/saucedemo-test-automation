package stepdefinitions;

import core.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginSteps {

    // Page objects
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();

    /**
     * Navigates to SauceDemo login page
     */
    @Given("user is on the SauceDemo login page")
    public void user_is_on_saucedemo_login_page() {
        loginPage.openLoginPage();
    }

    /**
     * Logs in using valid credentials
     */
    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login(
                JsonReader.getData("validUser.username"),
                JsonReader.getData("validUser.password")
        );
    }

    /**
     * Logs in using invalid credentials
     */
    @When("user logs in with invalid credentials")
    public void user_logs_in_with_invalid_credentials() {
        loginPage.login(
                JsonReader.getData("invalidUser.username"),
                JsonReader.getData("invalidUser.password")
        );
    }

    /**
     * Logs in using locked user credentials
     */
    @When("user logs in with locked user credentials")
    public void user_logs_in_with_locked_user_credentials() {
        loginPage.login(
                JsonReader.getData("lockedUser.username"),
                JsonReader.getData("lockedUser.password")
        );
    }

    /**
     * Logs in using performance glitch user credentials
     */
    @When("user logs in with performance glitch user credentials")
    public void user_logs_in_with_performance_glitch_user_credentials() {
        loginPage.login(
                JsonReader.getData("performanceUser.username"),
                JsonReader.getData("performanceUser.password")
        );
    }

    /**
     * Validates successful login by checking inventory page
     */
    @Then("user should be on the inventory home page")
    public void user_should_be_on_inventory_home_page() {
        Assert.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "Expected inventory home page to be displayed after valid login"
        );
    }

    /**
     * Validates error message for invalid credentials
     */
    @Then("user should see invalid login error message")
    public void user_should_see_invalid_login_error_message() {
        Assert.assertEquals(
                loginPage.getErrorMessageText(),
                JsonReader.getData("expectedMessages.invalidLoginError"),
                "Invalid login error message mismatch"
        );
    }

    /**
     * Validates error message for locked user
     */
    @Then("user should see locked user error message")
    public void user_should_see_locked_user_error_message() {
        Assert.assertEquals(
                loginPage.getErrorMessageText(),
                JsonReader.getData("expectedMessages.lockedUserError"),
                "Locked user error message mismatch"
        );
    }
}