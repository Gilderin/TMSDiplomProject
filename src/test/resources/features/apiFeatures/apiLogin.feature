Feature:
  Scenario: Тест логина с помощью API
    Given login info from db where user id = 1
    When use this information to login
