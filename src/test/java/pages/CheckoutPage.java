package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By confirmationMessage = By.className("complete-header");
    private final By backHomeButton = By.id("back-to-products");

    /**
     * Enters checkout customer information and continues to overview page.
     */
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        waitForElementVisible(firstNameInput);

        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);

        click(continueButton);
    }
    /**
     * Completes the order from checkout overview page.
     */
    public void finishCheckout(){
        click(finishButton);
    }

    /**
     * Validates whether order confirmation message is displayed.
     */
    public boolean isConfirmationMessageDisplayed() {
        return isDisplayed(confirmationMessage);
    }

    /**
     * Returns order confirmation message text.
     */
    public String getConfirmationMessageText() {
        return getText(confirmationMessage);
    }

    /**
     * Clicks Back Home button after successful checkout.
     * Useful for validating navigation stability, especially with performance glitch user.
     */
    public void clickBackHome() {
        click(backHomeButton);
    }
}