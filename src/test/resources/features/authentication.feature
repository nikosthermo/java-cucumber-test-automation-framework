Feature: Authentication

  Scenario: Successful login
    Given the user is on the login page
    When the user enters username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the products page
