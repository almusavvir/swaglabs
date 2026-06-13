Feature: Login Page Automation of SwagLabs App
  Scenario: Check login is successful with valid credentials
    Given User is on the login page
    When  User enters valid username and password
    And   Clicks on login button
    Then  User should be landed on the homepage
#    Then  User takes screenshot of the page


  Scenario: Check login is unsuccessful with incorrect password
    Given User is on the login page
    When  User enters invalid username and password
    And   Clicks on login button
    Then  User should get incorrect password error
#    Then  User takes screenshot of the page

  Scenario: Check login is unsuccessful with incorrect email
    Given User is on the login page
    When  User enters invalid email but valid password
    And   Clicks on login button
    Then  User should get incorrect password error
#    Then  User takes screenshot of the page