@tag2
Feature: TC02_PostImage 

  Scenario: Image Uploading
    Given User visits link "http://postimage.org/"
    When He should upload a photo (browse photo, select type of image content, click upload it! button)
    Then Should be verify image has uploaded successfully
