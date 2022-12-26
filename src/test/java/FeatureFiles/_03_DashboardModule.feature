# Scenario: Dashboard Module
# Test Case 1 – User should view dashboard if authenticated
# Test Case 2 – User should redirect to login page if not authenticated
# Test Case 3 – User should view list of events if any event created otherwise
#               user should view notification message states no registered event found
# Test Case 4 – User should be able navigate edit event when click the editevent button
# Test Case 5 – User should be able to delete event when click the delete button
# Test Case 6 – User should be able to view event participants

Feature: Dashboard Module Functionality
  @UnitTest
  Scenario: Test Case 1 - Should view dashboard if authenticated
    Given Navigate to url "https://e2e-assessment.piton.com.tr"
    When Enter the username "automationtest" and password "123456789" then click the login button
    Then View dashboard if url is correct "https://e2e-assessment.piton.com.tr/dashboard"
  @UnitTest
  Scenario: Test Case 2 - Should redirect to login page if not authenticated
    Given Navigate to url "https://e2e-assessment.piton.com.tr/dashboard"
    Then View login if url is correct "https://e2e-assessment.piton.com.tr/login"
  @UnitTest
  Scenario: Test Case 3 - Event list status should be checked
    Given Navigate to url "https://e2e-assessment.piton.com.tr"
    When Enter the username "automationtest" and password "123456789" then click the login button
    Then No registered event found message
  @UnitTest
  Scenario: Test Case 4 - Navigating event items
    Given Logging in and creating event and edit
    When TAB the edit elements
  @UnitTest
  Scenario: Test Case 5 - Should be able to delete event when click the delete button
    Given Logging in and creating event
    When Click the delete button and delete it
  @UnitTest
  Scenario Outline: Test Case 6 - Event attendees must be viewable
    Given Navigate to urls
      | <Url> |
    And Signing in
      | <UserName> | <LoginName>     |
      | <Password> | <LoginPassword> |
    And  Click on the button
      | <ClickButton> |
      | <ClickEvent>  |
    When Creating event and entering participants
    Then Random generating 10 participants
    And The event participant list visible
    And Is the event participant list visible

    Examples:
      | UserName | LoginName      | Password | LoginPassword | ClickButton | ClickEvent  | Url                                 |
      | userName | automationtest | password | 123456789     | loginButton | createEvent | https://e2e-assessment.piton.com.tr |