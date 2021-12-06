@tag9
Feature: TC09_OpenNewWindow

  Scenario: Open result link in new window
    Given Open google search and perform a search.
    When Open the first search link in new windows.
    Then Close the current window to move the focus back to result tab.
