Feature: Working with alert

  Scenario: Check alert and close it
    Given  browser is open
    When open login page with Alert
    And get text from Alert
    Then close the Alert
