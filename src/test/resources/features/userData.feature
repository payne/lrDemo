 @foo
Feature: show user data by name

  Background: user data
   Given t
  he userdata page is shown

    Scenario: show userData by name
      When i provide a name
      Then the userData for this name is shown
