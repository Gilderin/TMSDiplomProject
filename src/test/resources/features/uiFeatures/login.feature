Feature: Login to the Site

  Background:
    Given  Browser is open
    And  Open login page

  Scenario: Success login to TestRail
    Given login info from db where user id = 1
    When login to website
    Then dashboard page is opened
    And information about the user should be coincident with the data from the database

  Scenario: Failed login to TestRail
    Given login info from db where user id = 2
    When login to website
    Then error message should be displayed
    And error message text is "Email/Login or Password is incorrect. Please try again."
