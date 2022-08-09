@registration
Feature: Verify if user can make registration with correct data

  @successfulRegistration
  Scenario: Successful registration with valid credentials
    Given User navigate to Registration form of Shopizer
    When I submit the registration form with valid credentials
    Then I verify the value of User Name field on my account page
    And I Verify the value of Email Address field on my account page



