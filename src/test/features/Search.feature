Feature: Search Test

  @search
  Scenario: Verify relevance of search

    Given I am on Next Home Page "https://www.next.co.uk"
    When I enter search term "Jeans"
    Then I should be provided with products relevant to keywords "Jeans" or "Leggings"