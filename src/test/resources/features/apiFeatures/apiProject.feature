Feature:

  Background:
    Given login info from db where user id = 1
    And use this information to login

  Scenario: Тест создания проэкта с помощью API
    Given project info from db where project id = 4
    When create project
    And create new section
    And testCase info from db where id = 1
    And create testCase
    And delete case
    And delete project
