@tag3
Feature: TC03_VerifySnapdealCategories

  Scenario: Verify the List Of Categories 
    Given User visits to "https://www.snapdeal.com"
    When He store all the categories of product
    Then He should navigate to some different page in snapdeal
    And Should be verify that the list of categories did not change
