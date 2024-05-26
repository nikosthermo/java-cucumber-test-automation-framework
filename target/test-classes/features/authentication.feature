Feature: Authentication

  Scenario: Successful login
    Given the user is on the login page
    When the user logs in as "standard_user"
    Then the user should be redirected to the products page
