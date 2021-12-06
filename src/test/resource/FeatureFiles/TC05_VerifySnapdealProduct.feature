@tag5
Feature: TC05_VerifySnapdealProduct

Scenario: Verify Prouct falls between given range
Given User visits "https://www.snapdeal.com" to search for "apple"
When He should change the slider between 1K to 5K to check products 
Then Should be verify that product falls between the range