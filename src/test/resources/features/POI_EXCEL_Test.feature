# new feature
# Tags: optional
@excel

Feature: A description


  Scenario: create, update excel workbook, add data and delete data
    When I create the excel worbook "Random.xlsx"
    Then I print the data inside the workbook
    And I perform delete operations on a workbook

  Scenario: read the file “Sample.xlsx” and print values
    When I read the excel file "Random.xlsx"
    Then I access a worksheet
    Then I access the rows and cells
    Then I print the data inside the workbook

  Scenario: convert the rows into HashMaps
    When I read the excel file "Random.xlsx"
    Then I convert the sheet data into hash with keys as column headers


  Scenario: uses the data from excel and fills it on a web form using Selenium webdriver
    When I open website
    When I fill the form with data from excel
    When I hit a submit button
    Then I go back to Welcome and verify title
