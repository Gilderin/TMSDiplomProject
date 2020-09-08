Feature: Connect to API with basic auth

  Scenario: Login with information from DB
    Given login info from db where user id = 1
    When use this information to login
