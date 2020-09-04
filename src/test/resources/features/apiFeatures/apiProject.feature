Feature: Working with project through API

  Background:
    Given login info from db where user id = 1
    And use this information to login

  Scenario: Create project with API
    Given project info from db where project id = 4
    When create project
    And delete project
