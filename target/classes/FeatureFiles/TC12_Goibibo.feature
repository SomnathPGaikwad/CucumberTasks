@tag12
Feature: TC12_Goibibo

  Scenario: booking of most cheapest flight
    Given User visits link as "http://www.goibibo.com/"
    When He selects Origin as "Delhi (DEL)" Destination as "Bengaluru (BLR)"
    Then Should be redirect to the next page to click on the most cheapest flight
