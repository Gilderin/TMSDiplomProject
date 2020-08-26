Feature: Login to the Site

  Scenario: Login to admin
    Given Browser is open
    When Open login page
    Then Get User Info to login from DB. User id = 1
    And Login to Site