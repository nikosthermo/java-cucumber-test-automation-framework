Feature: Checkout

  Scenario: Enter checkout information
    Given the user is on the checkout page
    When the user enters checkout information "John", "Doe", "12345"
    Then the user should be able to continue to the next step
