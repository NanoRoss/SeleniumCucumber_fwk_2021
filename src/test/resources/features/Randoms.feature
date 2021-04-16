@Test
Feature: Feature: Test randoms things.

  @Smoke
  Scenario: As a user i do an accion to validate Dropdowns.
    Given Navigate To web with Dropdown
    When select a specific value on Dropdown
    Then The selected value is the expected value

  @Regression
  Scenario Outline: I want to validate that a city is present inside the list
    Given i navigate to the list page
    When i search <state> in the list
    Then i can find <city> in the resoult list

    Examples:
  |   state   |      city           |
  |chicago    | Chicago, Illinois   |
  |New York   | Syracuse, New York  |
  |New York   | New York, New York  |
  |Washington | Seattle, Washington |
  |Washington |  Spokane, Washington|







