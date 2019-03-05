Feature: Create event as a Manager

  Background:

    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
  @wip
    Scenario: Create event with multiple data
      Then Create event with external data and verify event created
