@wip
Feature: Login Functionality

@user
Scenario: User should login as a user
    Given User is on the login page as a user with "EventsCRM_User6@info.com" and "opJu56KKL44" credentials
    And Navigates to events module


@manager
Scenario: User should login as a manager
        Given User is on the login page as a manager with "EventsCRM_Manager6@info.com" and "Ugh45wQ17" credentials
        And Navigates to events module