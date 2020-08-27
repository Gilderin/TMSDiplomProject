Feature: Login to the Site

Background:
     Given  Browser is open
       And  Open login page

  Scenario: Success login to TestRail
    Given Get User Info to login from DB. User id = 1
    When Login to Site
