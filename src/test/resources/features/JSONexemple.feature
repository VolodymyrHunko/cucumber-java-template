@JSON
Feature: Demonstrate the json data formats

  @noweb
  Scenario: Serialization , convert object to json and print its string value
    When I create json string from object and write to file
    Then I print it as a string

  @noweb
  Scenario: Deserialization, Access a json string in a file
    When I read json string from a file
    Then I parse the string and print keys and values


  Scenario: Accessing a json data file and filling the web form
    When I open practice website
    And I read the json data file "practiceform.json"
    And I fill the form with data from json and submit