Feature: Search Product

  @RegressionTest
  Scenario: Search some products on Anhoch.mk
    Given I navigate to home page
    When I click on search field, for research products
    Then I enter product name
    And Click on the requested product
    Then Add product to shopping cart


  @SanityTest
  Scenario: Shopping Cart
    Given I am in shopping cart
    When I check the name of heading
    Then I check the price of the product
    And I increase the quantity of the product
    Then I check the price after increasing


