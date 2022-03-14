@Run
Feature: Secure logins for the edgewords site


  Scenario: Login with valid username and password
    Given I am on the login page
    When I use the username "edgewords" and password "edgewords123"
    Then I am logged in

  @Ignore
  Scenario Outline: Check multiple login values
    Given I am on the login page
    When I use the username "<username>" and password "<password>"
    Then I am logged in
    Examples:
      | username  | password     |
      | edgewords | edgewords123 |
      | webdriver | edgewords123 |

  Scenario: Inline table
    Given I am on the login page
    When I use the valid login credentials
      | username | password |
      | edgew    | edgew    |
      | ords     | ords123  |
    Then I am logged in

