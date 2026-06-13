Feature: Add to cart and checkout
  Scenario Outline: Add to cart and checkout
    Given User is on the login page
    When  User enters valid username and password
    And   Clicks on login button
    And   User selects product and adds to cart
#   And   User opens cart and verifies added item <"product"> in cart
    And   User clicks on checkout
    And   User enters buyer information and clicks on continue
    And   User clicks on finish button
    Then  User should get the order confirmation message

    Examples:
      | product             |
      | Sauce Labs Backpack |