Feature: Login into Account

Scenario: Log into account with incorrect credentials

Given user navigates on website2 
And User clicks on the login button on homepage2
And User enters a valid username2
And User enters a valid password2
When user clicks on the login button2
Then User should not be taken to the successful login page2 