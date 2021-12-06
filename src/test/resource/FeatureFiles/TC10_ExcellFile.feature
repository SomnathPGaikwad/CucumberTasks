@tag10
Feature: TC10_ExcellFile

  Scenario: Read and Write ExcellFile
    Given User create ExcellFile
    When He enter credentials into the ExcellFile
    Then Should read credentials from ExcellFile to see the result in console
