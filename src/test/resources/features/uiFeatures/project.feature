Feature:

  Background:
    Given browser is open
    And open login page
    And login info from db where user id = 1
    And login to website

  Scenario:
    Given project info from db where project id = 3
    When add project button click
    Then create project on UI