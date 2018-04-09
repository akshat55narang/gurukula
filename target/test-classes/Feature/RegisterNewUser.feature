Feature: Register a New User

@Login
Scenario: Verify whether a new user is able to Register for gurukula
Given User opens Application in Browser
And User clicks on Register in Accounts Menu
When User enters the Registration details
And clicks on Register
Then User should register his/her account successfully


Scenario: Verify whether the Register is deactivated by default
Given User opens Application in Browser
And User clicks on Register in Accounts Menu
Then Register button should be disabled


Scenario: Verify whether the Register is deactivated until all the mandatory checks on fields are met
Given User opens Application in Browser
And User clicks on Register in Accounts Menu
Then Register button should be disabled



