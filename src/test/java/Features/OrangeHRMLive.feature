@OrangeHRM
  Feature: OrangeHRM check test cases

  @AllEmpty
  Scenario Outline:Empty username & Empty password
    Given User at home page
    When Click login button
    Then Check "<error>" message about username and "<error>" message about password
    Examples:
    |error     ||error     |
    |Required  ||Required  |
