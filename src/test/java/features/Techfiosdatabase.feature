
Feature: Techfios login functionality validation


Background: 
Given user should land on techfios page

@DBScenario1
Scenario: Login with following info
When user should enter "username" from september2021 database
When user should enter "password" from september2021 database
When user should click signin button
Then user should land on dashboard page