Feature: Login to the Site

Background:
     Given  Browser is open
       And  Open login page

  Scenario: Success login to TestRail
    Given login info from db where user id = 1
    When login to website
    Then dashboard page is opened
    And user data shoud be from user with id = 1
