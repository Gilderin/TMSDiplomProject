Feature: Working with alert

  Scenario: Check alert and close it
    Given  browser is open
    And  open login page with Alert
    And get text from Alert
    And close the Alert
