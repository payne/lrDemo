@improove
Feature: user data management
    As a user,
    i want to see a list of user data,
    see a special user data by user name
    or add a new user data to be able to manage my user data.


  Scenario: See a list of user data.
     Given I am on the user data page
     When I do nothing else
     Then a list of all demo user data is shown

  @improove
  Scenario: See a special user data
     Given I am on the user data page
     When I search for user data by name = "name_1"
     Then the user data containing "name_1" is shown below the search form


  Scenario: Add a new user data
     Given I am on the user data page
     When I fill out the user data form with name: "Rolf" , surname: "Roessing" and age: "22
     Then I am at the save results page



