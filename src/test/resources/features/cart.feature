@CART
Feature: SauceDemo cart validation

  Scenario: User removes one product from cart and continues shopping
    Given user is on the SauceDemo login page
    When user logs in with valid credentials
    And user adds "Sauce Labs Backpack" product to the cart
    And user adds "Sauce Labs Bike Light" product to the cart
    And user navigates to the cart
    And user removes "Sauce Labs Backpack" product from the cart
    Then cart should contain only selected remaining products
    And user clicks continue shopping from cart
    Then user should return to inventory page