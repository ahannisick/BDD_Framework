@FBTestSuite
Feature: Facebook

  @FacebookLogin
  Scenario: Login Process
    Given user is on the login page
    When user enters a valid username
    And user enters a valid password
    And user clicks the sign in button
    Then user sign in is complete

#  @EmptyFields @LoginFailingExceptions
#  Scenario: Empty Fields Test
#    Given user is on the login page
#    When user clicks the sign in button
#    Then user gets alert message
#
#  @EmptyPassword @LoginFailingExceptions
#  Scenario: Empty Password Test
#    Given user is on the login page
#    When user enters a valid username
#    And user clicks the sign in button
#    Then user gets alert message
#
#  @EmptyUsername @LoginFailingExceptions
#  Scenario: Empty Username Test
#    Given user is on the login page
#    When user enters a valid password
#    And user clicks the sign in button
#    Then user gets alert message
#
#
#  @InvalidCredentials @LoginFailingExceptions
#  Scenario: Invalid Credentials Test
#    Given user is on the login page
#    When user enters a valid username
#    And user enters an invalid password
#    And user clicks the sign in button
#    Then user gets error message