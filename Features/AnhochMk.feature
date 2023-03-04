Feature: Anhoch Homepage

  Scenario: Order review on Anhoch.com
    Given I launch chrome browser
    When I open Anhoch homapage
    Then I verify that logo is displayed on page
    And I click login button
    When I enter valid email and password
    Then I click ok button
    When I click on dropdown button
    And I click on review of orders
    And I checked current URL
    And close browser
