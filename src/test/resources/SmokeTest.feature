
Feature: Test register function
  Scenario: 1. The home page is loaded and registration can be completed
    Given the Site is opened
    Then the cleango logo is visible
    And the email input field is visible
    And the phone number input field is visible
    And the register button is visible

  Scenario Outline: 2. The search for car brand and model gives back the correct result
    Given the Site is opened
    And The user is navigated to Prices page
    When the <brand> brand is selected
    And the <model> model is selected
    And the Go Search button is clicked
    Then the <result> card with details is displayed

    Examples:
      | brand      | model   |  result        |
      | Peugeot    | 206     |  Small car     |
      | Ford       | Mustang |  Medium car    |
      | Ford       | Kuga    |  Large car     |