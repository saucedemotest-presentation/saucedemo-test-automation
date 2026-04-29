# SauceDemo Automation Framework

## Overview
This project is a Selenium-based automation framework designed to validate key user flows of the SauceDemo application.

It is built using **Java, Selenium WebDriver, Cucumber (BDD), TestNG, and Maven**, following the **Page Object Model (POM)** design pattern for maintainability and scalability.

The framework focuses on validating critical business flows such as:
- Login
- Cart operations
- Checkout

---

## Tech Stack
- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven

---

## Framework Architecture Design

The automation framework follows a **layered Page Object Model (POM)** architecture to ensure scalability, maintainability, and separation of concerns.

Feature Files → Step Definitions → Page Classes → BasePage → Core → WebDriver

---

## Project Structure

```md
src/test/java/
|-- core/ # Driver, config, JSON reader
|-- pages/ # Page Object Model classes
|-- stepdefinitions/ # Cucumber step definitions
|-- hooks/ # Test setup and teardown
|__ runners/ # Test runners

src/test/resources/
|-- features/ # Feature files (BDD scenarios)
|-- testdata/ # JSON test data
|__ config.properties # Configuration

pom.xml
```

---

## Setup Instructions

### 1. Clone the Repository
git clone https://github.com/saucedemotest-presentation/saucedemo-test-automation
cd saucedemo-test-automation

### 2. Install Dependencies

Ensure the following are installed:
Java (JDK 11 or higher)
Maven
Git

Run all tests via testng.xml file:
You can either run all tests or specific tests you wanted to run just by commenting out the unwanted.






## Test Strategy & AI Usage Summary

### 1. Objective
The goal of this test strategy is to validate the core user journey of the SauceDemo application by focusing on high-impact functional flows. The approach prioritizes critical business scenarios, ensuring essential user actions work reliably while maintaining a balance between coverage and efficiency.

---

### 2. Scope and Focus Areas
The testing effort focuses on a core end-to-end user journey representing the primary user path:

- User authentication (Login)
- Product inventory browsing
- Add to cart / remove from cart
- Cart validation
- Checkout flow

In addition to the primary flow, negative and edge case scenarios are included to validate robustness and error handling.

---

### 3. Prioritization Approach
A risk-based testing approach was used, focusing on areas with the highest business impact:

- **Authentication** → Entry point; failure blocks all flows
- **Product Inventory** → Ensures accurate product display
- **Cart Functionality** → Critical for maintaining state and user trust
- **Checkout Flow** → Directly tied to user completion and conversion

These areas were prioritized because defects here significantly impact user experience.

---

### 4. Test Coverage (High-Level)

#### Positive Scenarios
- Successful login with valid credentials
- Viewing product inventory
- Adding and removing items from the cart
- Completing checkout with valid user information

#### Negative and Edge Case Scenarios
- Invalid or locked user login attempts
- Empty or incorrect input fields during login and checkout
- Cart inconsistencies (e.g., incorrect item count after add/remove)
- Attempting checkout with missing required information

---

### 5. Out of Scope
Due to assignment scope and time constraints, the following areas were not covered:

- Cross-browser and cross-device testing
- Performance and load testing
- Visual/UI regression testing
- Backend/database validation

These would be included in a full-scale testing strategy.

---

### 6. Risks Considered
Key risks identified:

- Login failures preventing access
- Incorrect product display
- Cart inconsistencies affecting order accuracy
- Checkout failures impacting completion

Test scenarios were designed to mitigate these risks.

---

### 7. Automation vs Other Testing Types

#### Suitable for Automation
- End-to-end user flow (login → cart → checkout)
- Regression scenarios (login validation, cart updates)
- Form validation and error handling

These are stable, repeatable, and high-value scenarios.

---

#### Suitable for Manual / Exploratory Testing
- UI/UX behavior and visual validation
- Dynamic edge cases and unusual user interactions
- Additional scenarios outside primary flow

Manual testing was used to quickly explore and validate behavior.

---

#### Backend / Data Validation Considerations
Direct backend validation was not performed due to lack of access.

Instead:
- Data integrity validated through UI behavior
- API responses observed via browser network tools

With backend access, further validation would include:
- Database verification
- API response validation

---

### 8. Future Improvements
With more time, the following enhancements would be implemented:

- CI/CD integration (Jenkins, GitHub Actions)
- Cross-browser execution (Sauce Labs)
- Parallel execution
- Advanced reporting (Allure, Extent Reports)
- Expanded coverage (sorting, filtering, edge scenarios)

---

## AI Usage Summary

AI tools like ChatGPT were used to accelerate framework setup, suggest reusable code structures, and improve documentation. This helped reduce effort on boilerplate code and speed up initial development.

However, all key design decisions, test coverage, and validation logic were implemented independently based on QA experience.

AI outputs required refinement, especially for:
- Locator strategies
- Validation depth
- Edge cases such as cart state and multi-product scenarios

All AI-generated code was manually reviewed, executed, and validated using strong assertions and iterative testing to ensure accuracy and reliability.



