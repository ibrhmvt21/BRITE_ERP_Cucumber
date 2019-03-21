@
Feature: Test Import functionality as a user



  @BRIT-1570
  Scenario: User should NOT be able to import event
    Given User is on the login page as a user with "EventsCRM_User6@info.com" and "opJu56KKL44" credentials
    And Navigates to events module
    Then User should not see import button

  @BRIT-1561
  Scenario: User should NOT be able to create an event
    Given User is on the login page as a user with "EventsCRM_User6@info.com" and "opJu56KKL44" credentials
    And Navigates to events module
    Then Create event button should not be visible

  @BRIT-1568
  Scenario: Manager should be able to create an event
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Create event as a manager

  @BRIT-1573
  Scenario: Create event Negative Test
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Create event without name date time and verify error message

  @BRIT-1577
  Scenario: Edit Existing Event
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Edit created event by manager

  @BRIT-1582
  Scenario: Verify Maximum Attendees option is available Test
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Verify Maximum Attendees option is available

  @BRIT-1587
  Scenario: Verify Upcoming Events Test
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Verify Upcoming Events dates

  @BRIT-1592
  Scenario: Verify Number of Attendees is visible Test
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Verify text contains expected attendees

  @BRIT-1595
  Scenario: Verify Manager has Ability to Cancel an Event
    Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
    And Navigates to events module
    Then Verify Cancel Event button is displayed

  @BRIT-1600
  Scenario: Verify User does not have Ability to Cancel an Event
    Given User is on the login page as a user with "EventsCRM_User6@info.com" and "opJu56KKL44" credentials
    And Navigates to events module
    Then Verify Error message is displayed when user tries to cancel an event
