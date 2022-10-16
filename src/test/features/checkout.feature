Feature: Checkout test

  @checkout
  Scenario: Verify checkout

    Given I am on home page
    When I click checkout link
    Then I should be on checkout