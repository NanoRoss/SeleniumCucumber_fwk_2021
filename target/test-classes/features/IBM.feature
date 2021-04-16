@Test
Feature: Tests for IBM Automation Exercise.

  Scenario: Add a pet using POST Request.
    Given Prepare the Request.
    When Run the Request
    Then The status Code and Schema are right

