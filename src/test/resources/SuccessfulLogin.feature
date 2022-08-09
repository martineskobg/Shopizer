@login
Feature: Login Application. As a user I want to login to the application

  @successfulLogin
  Scenario: Successful login with valid username and password
    Given User navigate to Login form of Shopizer
    When I submit the login form with valid credentials
    Then Verify I'm on My account page
