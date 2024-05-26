Feature: Products Page

  Scenario: Add first product to cart
    Given the user is logged in
    When the user adds the first product to the cart
    Then the cart should contain one item
