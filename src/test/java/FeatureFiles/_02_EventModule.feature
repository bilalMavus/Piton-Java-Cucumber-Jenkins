# Scenario: Event Module
# Test Case 1 - User should view create event form if click the Create Event
#               button on dashboard
# Test Case 2 – User should view validation errors if click the Create Event button
#               without fill the event form
# Test Case 3 – User should be able to add new participant when click the Add
#               Participant button
# Test Case 4 – User should view error message if removes all participants
# Test Case 5 – User should be able to create new event if fills all required fields
#               and redirect to dashboard page with create successful message
# Test Case 6 – User should be able to edit event. When user click the edit
#               button all event fields must be filled according to editing event
# Test Case 7 – User should be able to update event if required fields filled and
#               redirect to dashboard page with update successful message

Feature: Event Module Functionality

  Background:
    Given Navigate to Piton
    When Enter the username "automationtest" and password "123456789" then click the login button
    Then Welcome message should be displayed

  @UnitTest
  Scenario: Test Case 1 - The event creation form should appear
    And Click on the element
      | createEvent |
    And Does it contain elements
      | eventButton |

  @UnitTest
  Scenario: Test Case 2 - Validation errors should be displayed
    And Click on the element
      | createEvent |
      | eventButton |
    And Are validation errors displayed
      | eventNameError | Event name field is required       |
      | eventDateError | Please choose a valid date         |
      | firstNameError | Participant name is required       |
      | lastNameError  | Participant last name is required  |
      | contactError   | Please enter email or phone number |

  @UnitTest
  Scenario: Test Case 3 - Should be able to add new participant when click the Add
    And Click on the element
      | createEvent    |
      | addParticipant |
    And Successful verification displayed
      | content2ndRow | 2 | # ---> Add Participant butonuna tıklatınca 2. sıradaki ekleme listesinin numarasının doğruluğu

  @UnitTest
  Scenario: Test Case 4 - Should view error message if removes all participants
    And Click on the element
      | createEvent  |
      | deleteButton |
    And Are validation errors displayed
      | participantErrorMessage | Please add participant! |

  @UnitTest
  Scenario: Test Case 5 - Should view error message if removes all participants
    And Click on the element
      | createEvent |
    And Sending the keys in Event content
      | eventName        | Birthday Party              |
      | eventDescription | PITON Technology 17 yaşında |
    And Click on the element
      | dateClick      |
      | nextMonthClick |
      | dayClick       |
    And Sending the keys in Event content
      | firstName | Bilal                 |
      | lastName  | Mavus                 |
      | contact   | bilalmavuss@gmail.com |
    And Click on the element
      | eventButton |
    And Successful verification displayed
      | successfulMessage | Event created successfully |

  @UnitTest
  Scenario: Test Case 6 - Should be able to edit event
    And Click on the element
      | createEvent |
    And Sending the keys in Event content
      | eventName        | Walk         |
      | eventDescription | coastal walk |
    And Click on the element
      | dateClick      |
      | nextMonthClick |
      | dayClick       |
    And Sending the keys in Event content
      | firstName | Kuzey           |
      | lastName  | Mavus           |
      | contact   | kuzey@gmail.com |
    And Click on the element
      | eventButton |
    And Click on the element
      | editButton |
    And Does it contain elements
      | updateEventButton |

  @UnitTest
  Scenario: Test Case 7 - Should be able to update the Event
    And Click on the element
      | createEvent |
    And Sending the keys in Event content
      | eventName        | Walk         |
      | eventDescription | coastal walk |
    And Click on the element
      | dateClick      |
      | nextMonthClick |
      | dayClick       |
    And Sending the keys in Event content
      | firstName | Kuzey           |
      | lastName  | Mavus           |
      | contact   | kuzey@gmail.com |
    And Click on the element
      | eventButton |
    And Click on the element
      | editButton |
    And Sending the keys in Event content
      | eventName        | Hiking                   |
      | eventDescription | Atatürk Forest Farm walk |
    And Click on the element
      | dateClick      |
      | nextMonthClick |
      | dayClick       |
    And Sending the keys in Event content
      | firstName | Eva           |
      | lastName  | Mavus         |
      | contact   | eva@gmail.com |
    And Click on the element
      | updateEventButton |
    And Successful verification displayed
      | successfulMessage | Event created successfully |
