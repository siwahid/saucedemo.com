Feature: Checkout Page saucedemo application

  @Test @Checkout @Positive @SuccessCheckout
  Scenario: Success Checkout
    Given Open checkout-information page saucedemo
    When User input first name
    And User input last name
    And User input postal code
    And User cLick continue button
    Then User in checkout-overview page

  @Test @Checkout @Negative @FailedCheckout
  Scenario: Failed Checkout
    Given Open checkout-information page saucedemo
    When User input first name
    And User input last name
    And User leave postal code blank
    And User cLick continue button
    Then User get error postal code message