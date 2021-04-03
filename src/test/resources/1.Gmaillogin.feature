Feature: UserA Login into the Gmail and Composing the Mail to UserB
  @scenario1
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
      |Continue to Gmail|velusubu09@gmail.com|velumani09|
  @scenario2
  Scenario: UserA Clicks the compose button and enter the mail id then subject of the mail
    When Click compose button
    And Enter Email id "velusubu09@gmail.com" in to address bar
    And Enter the mail Subjet "Second Assignment" in subject field

  @scenario3
  Scenario Outline: UserA Enter the body of the mail
    When Enter the content "<body1>" of the mail

    Examples:
      |body1|
      |Hello Sir,|
  | did a Google search, but couldn't find out how to escape the period before tex.|

