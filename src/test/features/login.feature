Feature: Verify login feature

  @login @smoke @regression
  Scenario: Verify login with valid username and password

    Given I am on home page "http://www.saucedemo.com" with title "Swag Labs"
    When I enter username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should get re-directed to products page with Heading "PRODUCTS"

  @login @regression
  Scenario: Verify login with invalid username and password

    Given I am on home page "http://www.saucedemo.com" with title "Swag Labs"
    When I enter username "standard_user_inv" and password "secret_sauce_inv"
    And I click login button
    Then I should not be allowed login instead "Epic Sadface: Username or password incorrect"

  @login @regression
  Scenario: Verify login with no username and password

    Given I am on home page "http://www.saucedemo.com" with title "Swag Labs"
    When I click login button
    Then I should not be allowed login instead "Epic Sadface: Username is required"