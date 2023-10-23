Feature: Add to chart saucedemo application

  @Test @Chart @Positive
  Scenario: Add Sauce Labs Backpack to chart
    Given Open Sauce Labs Backpack page
    When User cLick Add to chart button
    And User cLick chart button
    Then User have Sauce Labs Backpack in chart page