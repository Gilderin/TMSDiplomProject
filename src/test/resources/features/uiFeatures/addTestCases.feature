Feature: Add projects to account

  Background:
    Given browser is open
    And open login page
    And login info from db where user id = 1
    And login to website

  Scenario: Create test case
    Given project info from db where project id = 3
    And testCase info from db where id = 2
    When go to add test case page
    Then create testcase onUI

  Scenario: Create test case
    Given project info from db where project id = 3
    And testCase info from db where id = 2
    When go to add test case page
    Then create testcase onUI with Upload
