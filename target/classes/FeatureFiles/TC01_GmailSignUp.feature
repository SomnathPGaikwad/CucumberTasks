@tag1
Feature: TC01_GmailSignUp

  Background: Gmail signUp page Initialization
    Given User is on "https://accounts.google.com/signup"

  Scenario Outline: Gmail SignUp-Possible Combinations
    When He enters "<FirstName>" in firstname field, "<LastName>" in lastname field
    And He enters "<UserName>" in username field
    Then Should enters "<Password>" in password field
    And clicks next button
    Then Should gets output message to verify user is successfully Logged in or not

    Examples: 
      | FirstName | LastName | UserName      | Password    |
      | Somnaath  |          | spgaykwad57   | Somnath@123 |
      |           | Gaykwad  | spgaikwad1166 | abcd@1166   |
      | Somnath   | Gaikwad  | spgaikwad1166 |             |
      | Somnath   | Gaikwad  |               |    12345678 |
