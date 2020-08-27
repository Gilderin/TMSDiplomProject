Feature:

  Background:
    Given login info from db where user id = 1
    And Use this information to login

  Scenario: Тест создания проэкта с помощью API
    Given Project info from db where project id = 5
    When Create project