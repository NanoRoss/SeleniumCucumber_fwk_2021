
Feature: Feature: Test randoms things.

  @Smoke
  Scenario: As a user i do an accion to validate Dropdowns.
    Given Navigate To web with Dropdown
    When select a specific value on Dropdown
    Then The selected value is the expected value

  @Regression
  Scenario: I want to validate that a text is present inside the list
    Given i navigate to the list page
    When i search the list
    Then i can find the text in the list


