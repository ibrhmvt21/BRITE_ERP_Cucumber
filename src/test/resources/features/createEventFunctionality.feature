@wip
Feature: Create event as a Manager

  Background:

    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
  @BRIT-4405
    Scenario: Create event with multiple data
      Then Create event with external data and verify event created

  @BRIT-4406
  Scenario: Create event with multiple data
    Then Create event with only required field data

  @BRIT-4407
  Scenario: Create event with multiple data
    Then Create event with limited attendees

  @BRIT-4408
  Scenario: Create event with multiple data
    Then Create event with missing data

  @BRIT-4409
  Scenario: Create event with multiple data
    Then Create event with conflicting time frame