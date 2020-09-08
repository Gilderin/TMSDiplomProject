Feature: Add projects to account

  Background:
    Given browser is open
    And open login page
    And login info from db where user id = 1
    And login to website
    And project info from db where project id = 3

  Scenario: Create test case
    Given testCase info from db where id = 2
    When go to add test case page
    Then create testcase onUI

  Scenario: Create test case with upload
    Given testCase info from db where id = 2
    When go to add test case page
    Then create testcase onUI with Upload

  Scenario: Over maximum value test
    Given testCase info from db where id = 4
    When go to add test case page
    Then create testcase onUI
    And test case name length is greater than maximum

  Scenario: Maximum value test
    Given testCase info from db where id = 5
    When go to add test case page
    Then create testcase onUI
    And test case name length is maximum

  Scenario: Minimum value test
    Given testCase info from db where id = 6
    When go to add test case page
    Then create testcase onUI
    And test case name length is minimum

  Scenario: Without title test
    Given testCase info from db where id = 7
    When go to add test case page
    Then create testcase onUI
    And test case not created with error "Field Title is a required field."
