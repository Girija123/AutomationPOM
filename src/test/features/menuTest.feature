Feature: Verify menu

  @menu
  Scenario Outline: Verify menu option re-direction

    Given I am on home page "https://www.johnlewis.com/"
    When I click on Menu option "<menuOption>"
    Then I should get re-directed appropriately with page heading "<ExpectedPageHeading>"

    Examples:

      | menuOption         | ExpectedPageHeading |
      | Home & Garden      | Home & Garden       |
      | Furniture & Lights | Furniture & Lights  |
      | Electricals        | Electricals         |