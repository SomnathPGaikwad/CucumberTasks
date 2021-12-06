@tag8
Feature: TC08_OpenNewTab

  Scenario: Open result link in new tab
    Given User initialise browser to search link as "https://www.google.com/"
    When He search product as "headphone"
    Then Result link open in new tab
    And Should close current tab to move the focus back to result tab.
