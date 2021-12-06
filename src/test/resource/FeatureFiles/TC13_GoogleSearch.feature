@tag13
Feature: TC13_GoogleSearch

  Scenario: Verify Title of Result Page
    Given User is on google search Page
    When He searches for text as "cucumber"
    Then He should be verify title of result page
