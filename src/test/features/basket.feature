Feature: Verify basket feature

  Background:
    Given I am on home page "http://www.saucedemo.com" with title "Swag Labs"
    When I enter username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should get re-directed to products page with Heading "PRODUCTS"

  @bag
  Scenario: Verify add a product to bag

    When I add product "Sauce Labs Backpack" to cart
    Then I should see "Sauce Labs Backpack" in the bag with heading "Your Cart"

  @bag
  Scenario: Verify adding multiple items to basket

    When I add product "Sauce Labs Backpack" to cart
    And I click back to products button
    And I add product "Sauce Labs Bike Light" to cart
    Then I should see "Sauce Labs Backpack" and  "Sauce Labs Bike Light" in the bag

    @removeItem @bag
    Scenario: Verify remove an item from bag

      When I add product "Sauce Labs Backpack" to cart
      And I click bag icon
      And I click remove button from the bag
      Then the product "Sauce Labs Backpack" should not exist in the bag
