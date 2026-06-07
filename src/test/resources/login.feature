Feature: Login Page Automation of SwagLabs App
  Scenario: Check login is successful with valid creation
    Given User is on the login page
    When User enters valid username and password
    And Clicks on login button
    Then User should be landed on the homepage