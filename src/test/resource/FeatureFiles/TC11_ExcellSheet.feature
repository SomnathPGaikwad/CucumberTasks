@tag11
Feature: TC11_ExcellSheet

  Scenario: To get URL and Browser Value from ExcellSheet
    Given User create ExcellSheet
    When He write URL and BrowserValue into the ExcellSheet
    Then Should read URL from ExcellSheet to open the given URL into the Browser
