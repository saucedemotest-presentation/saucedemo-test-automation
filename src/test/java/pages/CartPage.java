package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {


    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By productNameLocator = By.className("inventory_item_name");

    /**
     * Returns list of product names present in cart.
     * Wait added to handle slow loading scenarios.
     */
    public List<String> getProductNamesFromCart() {
        waitForElementVisible(productNameLocator);

        List<WebElement> productElements = driver.findElements(productNameLocator);

        return productElements.stream()
                .map(WebElement::getText)
                .toList();
    }

    /**
     * Removes specific product from cart using product name.
     */
    public void removeProductFromCart(String productName) {
        By removeButton = By.xpath(
                "//div[contains(@class,'cart_item') and .//div[text()='" + productName + "']]//button"
        );

        click(removeButton);
    }

    /**
     * Clicks continue shopping button.
     */
    public void continueShopping() {
        click(continueShoppingButton);
    }

    /**
     * Proceeds to checkout page.
     */
    public void proceedToCheckout() {
        click(checkoutButton);
    }
}