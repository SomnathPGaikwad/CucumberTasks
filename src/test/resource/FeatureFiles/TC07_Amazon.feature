@tag7
Feature: TC07_Amazon

  Scenario: To get star rating of first product
    Given User visits "https://www.amazon.in/"
    When User search product as "Mobile"
    Then He should sort the result according to price-Low To High
    And Should select first rating product to get star ratings of that product
