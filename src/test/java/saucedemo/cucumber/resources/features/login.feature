Feature: Login Page saucedemo application

  @Test @Login @Positive @SuccessLogin
  Scenario: Success Login
    Given Launch the login page saucedemo
    When User input a registered username
    And User input registered password
    And User cLick login button
    Then User in dashboard page

  @Test @Login  @Negative @FailedLogin
  Scenario: Failed Login
    Given Launch the login page saucedemo
    When User input a registered username
    And User input invalid password
    And User cLick login button
    Then User get error message