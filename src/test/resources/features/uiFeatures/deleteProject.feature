Feature: Delete projects from account

  Background:
    Given browser is open
    And open login page
    And login info from db where user id = 1
    And login to website

  Scenario: delete project
    Given project info from db where project id = 3
    And adnimistration project page opened
    When delete project with name from db