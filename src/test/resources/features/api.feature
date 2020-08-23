Feature:
  Scenario: Тест логина с помощью API
    Given Get User Info to login from DB. User id = 1
    When Use this information to login