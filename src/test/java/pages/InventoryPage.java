package pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    // Locators
    private final By cartIcon = By.className("shopping_cart_link");
    private final By pageTitle = By.className("title");

    /**
     * Adds the product to the cart.
     */
    public void addProductToCart(String productName) {
        By productAddToCartButton = By.xpath(
                "//div[@class='inventory_item' and .//div[text()='" + productName + "']]//button"
        );

        click(productAddToCartButton);
    }

    /**
     * Navigates to the cart page.
     */
    public void goToCart() {
        click(cartIcon);
    }

    /**
     * Validates that the Inventory (home) page is displayed.
     * Uses page title "Products" for stable and reliable verification.
     *
     * @return true if inventory page is displayed correctly
     */
    public boolean isInventoryPageDisplayed() {
        return isDisplayed(pageTitle) &&
                getText(pageTitle).equalsIgnoreCase("Products");
    }
}