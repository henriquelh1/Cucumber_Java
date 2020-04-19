Feature: Login into account

Scenario: Log into account with correct credentials

Given user navigates on website 
And User clicks on the login button on homepage
And User enters a valid username
And User enters a valid password
When user clicks on the login button
Then User should be taken to the successful login page