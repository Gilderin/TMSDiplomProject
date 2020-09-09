Feature: Connect to API with basic auth

  Scenario: Login with information from DB
    Given API is start
    When login info from db where user id = 1
    Then use this information to login
