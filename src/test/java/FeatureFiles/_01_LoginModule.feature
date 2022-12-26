# Scenario: Login Module
# Test Case 1 - User should see login form if not authenticated. Login Form
#               should contain username password and login button
# Test Case 2 – User should see validation errors if click the login button without
#               fill the login form
# Test Case 3 – User should navigate to the dashboard and see welcome
#               message if authenticate successfully

Feature: Login Functionality
  @RegressionTest @UnitTest
  Scenario: Test Case 1 - Login form elements control
    Given Navigate to Piton
    When The login form should appear
    Then Contains username password and login button
  @RegressionTest @UnitTest
  Scenario: Test Case 2 - Validation errors should be displayed
    Given Navigate to Piton
    When Click the login button
    And Validation errors should be displayed
  @RegressionTest @UnitTest
  Scenario: Test Case 3 - Control panel login must be made and verified
    Given Navigate to Piton
    When Enter the username "automationtest" and password "123456789" then click the login button
    And Welcome message should be displayed


