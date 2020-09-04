Feature: Working with test-cases through API

  Background:
    Given login info from db where user id = 1
    And use this information to login
    And testCase info from db where id = 1
    And project info from db where project id = 4
    And create project

  Scenario: Тест создания Тест Кейса с помощью API
    Given create new section
    When create testCase
    And delete case
    And delete project