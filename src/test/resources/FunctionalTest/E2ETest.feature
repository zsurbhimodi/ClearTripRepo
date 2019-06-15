
Feature: TripSearch Action

  Scenario Outline: Successful Search with Valid Credentials
    Given User is on Home Page
    When User select "<triptype>" trip and enter the required details and click on search
    Then Message displayed Login Successfully
    Examples:
      | triptype   |
      |   OneWay  |
      |  RoundTrip |
      |  Multicity |


