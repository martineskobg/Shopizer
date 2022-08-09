@login @negativeLogin
Feature: Login Application as a user I cannot login to the application with wrong credentials

  Background: Nav to login page
    Given I'm on the login page

  @emailTerms
  Scenario Outline: Test the email terms for email field
    When I enter "<email>"
    Then I should see error message for invalid email

    Examples:
      | email                   |
      | invalidEmail@abv        |
      | invalidEmail@.bg        |
      | invalidEmail.abv.bg     |
      | @abv.bg                 |
      | mm invalidEmail@abv.bg  |
      | !@#$invalidEmail@abv.bg |

  @wrongCredentials
  Scenario Outline: This will test if user is able to login with wrong credentials
    When I submit the login form with incorrect "<email>" and "<password>"
    Then I should be on the same page
    Examples:
      | email                 | password         |
      | validTestEmail@abv.bg | invalidPass      |
      | invalidEmail@abv.bg   | invalidPasssss1! |
      | validTestEmail@abv.bg |                  |
      |                       | validPass1!      |
      |                       |                  |