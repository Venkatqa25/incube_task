Feature: Login into the Gmail and Composing the Mail
  Scenario Outline: Login into the Gmail
    Given I'm on the Gmail Login Page
    Then Should be navigated to "<signin>" page
    When Enter Email as "<emailid>"
    And Click Next button
    And Enter Password as "<password>"
    And Click Next button
    Then It should be navigated to Inbox page

    Examples:
      |signin|emailid|password|
      |Continue to Gmail|dwh.venkey@gmail.com|rani1501|
