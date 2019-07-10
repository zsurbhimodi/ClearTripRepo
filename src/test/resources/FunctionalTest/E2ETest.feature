
Feature:TripSearch Action

  Scenario Outline:Successful Search with Valid Credentials
    Given User is on Home Page
    When User select "<Triptype>" trip and enter the required details and click on search
    Then Message displayed Login Successfully
    Examples:
      | Triptype   |
      |  OneWay    |
      | RoundTrip  |
      | Multicity  |






