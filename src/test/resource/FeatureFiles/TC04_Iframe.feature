@tag4
Feature: TC04_Iframe

  Scenario: Get text from iframe
    Given User is redirect on given URL as "https://www.w3schools.com/js/tryit.asp?filename=tryjs_myfirst"
    When He should switch to text area to get text
    Then Should be get text of first line
