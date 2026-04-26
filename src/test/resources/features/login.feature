# Note:
# Test case IDs can be added as tags (e.g., @TC_LOGIN_001) for traceability
# in integrated environments. Not included here due to assignment scope.

@LOGIN
Feature: SauceDemo login validation

  Scenario: Valid user should login successfully
    Given user is on the SauceDemo login page
    When user logs in with valid credentials
    Then user should be on the inventory home page

  Scenario: User should not login with invalid credentials
    Given user is on the SauceDemo login page
    When user logs in with invalid credentials
    Then user should see invalid login error message

  Scenario: Locked user should not login
    Given user is on the SauceDemo login page
    When user logs in with locked user credentials
    Then user should see locked user error message