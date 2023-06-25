Feature: SearchProduct

  @RegressionTest
  Scenario: Search some products on Anhoch.mk
    Given I navigate to home page
    When I click on search field, for research products
    Then I enter product name
    And Verify that search button is displayed
    And Click search button

