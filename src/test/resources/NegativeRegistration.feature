@registration @negativeRegistration
Feature: This feature file is to check if it is possible to make registration with  one missing required field

  @missingField
  Scenario Outline:
    Given User is on the registration page
    When I submit registration form with one missing field "<email>", "<password>", "<repeatPassword>", "<firstName>", "<lastName>", "<country>" , "<state>"
    Then I should see error the message "<errorMessage>"
    Examples:
      | email             | password    | repeatPassword | firstName | lastName | country | state   | errorMessage                |
      |                   | testPass11! | testPass11!    | Martin    | Bachev   | Canada  | Alberta | Email is required           |
      | testEmail@abv.com |             | testPass11!    | Martin    | Bachev   | Canada  | Alberta | Password is required        |
      | testEmail@abv.com | testPass11! |                | Martin    | Bachev   | Canada  | Alberta | Repeat Password is required |
      | testEmail@abv.com | testPass11! | testPass11!    |           | Bachev   | Canada  | Alberta | Firstname is required       |
      | testEmail@abv.com | testPass11! | testPass11!    | Martin    |          | Canada  | Alberta | Lastname is required        |
      | testEmail@abv.com | testPass11! | testPass11!    | Martin    | Bachev   |         | Alberta | Country is required         |
      | testEmail@abv.com | testPass11! | testPass11!    | Martin    | Bachev   | Canada  |         | State is required           |
