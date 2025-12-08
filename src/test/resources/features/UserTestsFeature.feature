Feature: User tests
  In order to ensure user functionalities work correctly

#  @API
#  Scenario: Create and retrieve user
#    When I create a new account from back-end
#    And I login with the new account
#    Then I retrieve the user details

  @UI
  Scenario: Register user and login
    Given I register new user from ui
#    Then I can login with the new user