Feature: Cart

  Scenario: Proceed to checkout
    Given the user has added a product to the cart
    When the user goes to the cart
    Then the user should be able to proceed to checkout
