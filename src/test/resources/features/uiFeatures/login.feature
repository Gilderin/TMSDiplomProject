Feature: Login to the Site

  Background:
    Given  browser is open
    And  open login page

  Scenario: Success login to TestRail
    Given login info from db where user id = 1
    When login to website
    And dashboard page is opened
    Then information about the user should be coincident with the data from the database

  Scenario: Failed login to TestRail
    Given login info from db where user id = 2
    When login to website
    And error message should be displayed
    Then error message text is "Email/Login or Password is incorrect. Please try again."

  Scenario: Logout
    Given login info from db where user id = 1
    When login to website
    And dashboard page is opened
    Then logout from site
