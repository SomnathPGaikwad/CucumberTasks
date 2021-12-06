@tag6
Feature: TC06_Flipkart

  Scenario: To get star rating of product
    Given User visits page "https://www.flipkart.com/"
    When He search product "televsion"
    Then He should print product name with highest ratings
    And should click on customer review link to get star rating of that product