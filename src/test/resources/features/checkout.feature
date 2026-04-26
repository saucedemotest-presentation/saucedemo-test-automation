# Note:
# In real-world frameworks, scenario tags like @TC_CHECKOUT_001 are used
# to map automated tests with test management tools (e.g., TestRail, Jira)
# for traceability and reporting. This is omitted here as integration is
# not part of the assignment scope.

@CHECKOUT
Feature: SauceDemo checkout flow

  Scenario: Valid user completes checkout successfully
    Given user is on the SauceDemo login page
    When user logs in with valid credentials
    And user adds "Sauce Labs Backpack" product to the cart
    And user adds "Sauce Labs Fleece Jacket" product to the cart
    And user navigates to the cart
    And user completes checkout with valid information
    Then user should see the order confirmation message
    And user navigates back to inventory page

  Scenario: Performance glitch user completes checkout successfully
    Given user is on the SauceDemo login page
    When user logs in with performance glitch user credentials
    And user adds "Sauce Labs Fleece Jacket" product to the cart
    And user navigates to the cart
    And user completes checkout with valid information
    Then user should see the order confirmation message
    And user navigates back to inventory page