package stepdefinitions;

import core.JsonReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import java.util.ArrayList;
import java.util.List;

public class CheckoutSteps {

    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    private List<String> selectedProducts = new ArrayList<>();

    @And("user adds {string} product to the cart")
    public void user_adds_product_to_the_cart(String productName) {
        selectedProducts.add(productName);
        inventoryPage.addProductToCart(productName);
    }

    @And("user navigates to the cart")
    public void user_navigates_to_the_cart() {
        inventoryPage.goToCart();

        List<String> actualProductsInCart = cartPage.getProductNamesFromCart();

        Assert.assertEquals(
                actualProductsInCart.size(),
                selectedProducts.size(),
                "Cart product count does not match selected product count"
        );

        Assert.assertTrue(
                actualProductsInCart.containsAll(selectedProducts),
                "Cart products do not match selected products"
        );
    }

    @And("user removes {string} product from the cart")
    public void user_removes_product_from_the_cart(String productName) {
        cartPage.removeProductFromCart(productName);
        selectedProducts.remove(productName);
    }

    @Then("cart should contain only selected remaining products")
    public void cart_should_contain_only_selected_remaining_products() {
        List<String> actualProductsInCart = cartPage.getProductNamesFromCart();

        Assert.assertEquals(
                actualProductsInCart.size(),
                selectedProducts.size(),
                "Cart product count after removal does not match expected remaining product count"
        );

        Assert.assertTrue(
                actualProductsInCart.containsAll(selectedProducts),
                "Cart does not contain expected remaining products after removal"
        );
    }

    @And("user clicks continue shopping from cart")
    public void user_clicks_continue_shopping_from_cart() {
        cartPage.continueShopping();
    }

    @Then("user should return to inventory page")
    public void user_should_return_to_inventory_page() {
        Assert.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "Expected inventory page after clicking Continue Shopping"
        );
    }

    @And("user completes checkout with valid information")
    public void user_completes_checkout_with_valid_information() {
        cartPage.proceedToCheckout();
        checkoutPage.enterCheckoutInformation(
                JsonReader.getData("checkoutUser.firstName"),
                JsonReader.getData("checkoutUser.lastName"),
                JsonReader.getData("checkoutUser.postalCode")
        );

        checkoutPage.finishCheckout();
    }

    @Then("user should see the order confirmation message")
    public void user_should_see_order_confirmation_message() {

        // Step 1: Check if confirmation message is visible
        Assert.assertTrue(
                checkoutPage.isConfirmationMessageDisplayed(),
                "Expected order confirmation message to be displayed"
        );

        // Step 2: Validate exact confirmation text from JSON
        Assert.assertEquals(
                checkoutPage.getConfirmationMessageText(),
                JsonReader.getData("expectedMessages.checkoutSuccess"),
                "Order confirmation text mismatch – checkout flow may have failed"
        );
    }

    @And("user navigates back to inventory page")
    public void user_navigates_back_to_inventory_page() {
        checkoutPage.clickBackHome();

        Assert.assertTrue(
                inventoryPage.isInventoryPageDisplayed(),
                "Expected inventory page to be displayed after clicking Back Home"
        );
    }
}