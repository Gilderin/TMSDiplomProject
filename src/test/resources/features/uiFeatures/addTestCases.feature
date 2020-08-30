Feature: Add projects to account

  Background:
    Given browser is open
    And open login page
    And login info from db where user id = 1
    And login to website

  Scenario: 
    Given project info from db where project id = 3
    When go to add test case page