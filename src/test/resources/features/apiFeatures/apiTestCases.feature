Feature: Working with test-cases through API

  Background:
    Given login info from db where user id = 1
    And use this information to login
    And testCase info from db where id = 1
    And project info from db where project id = 4
    And create project
    And create new section

  Scenario: Create test case through API
    Given create testCase
    When get testCase
    Then delete case
    And delete project