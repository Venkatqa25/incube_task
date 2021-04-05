Feature: UserA Login into the Gmail and Composing the Mail to UserB
  @scenario1
  Scenario Outline: Login into the Gmail
    Given I'm on the Gmail Login Page
    Then Should be navigated to "<signin>" page
    When Enter a Email as "<emailid>"
    And Click on Next button
    And Enter a Password as "<password>"
    And Click on Next button
    Then It should be navigated to Inbox page

    Examples:
      |signin|emailid|password|
      |Continue to Gmail|velusubu09@gmail.com|velumani09|
  @scenario2
  Scenario: UserA Clicks the compose button and enter the mail id then subject of the mail
    When Click on compose button
    And Enter a Email id "velusubu09@gmail.com" in to address bar
    And Enter the mail Subject "Incubyte-Assignment" in subject field

  @scenario3
  Scenario Outline: UserA Enter the body of the mail
    When Enter the content "<content>" of the mail

    Examples:
      |content|
      |Hello Sir,|
  | \n \n Did a Google search, but couldn't find out how to escape the period before tex.|
  | \n \n Regards,                                                                           |
  | \n Venkatesh S                                                                       |

    @scenario4
    Scenario: Click on send button and verify that mail sent to sender then logout the GMail
    When Click on Send button
    And Go to Sent section
    Then Verify mail subject "Incubyte-Assignment" which sent to UserB displayed in sent mail
    When Click on User Account to Signout
    And Click on Sign out the GMail
