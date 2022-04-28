Feature: Cart requirements
  As a user
  I want to access to app
  so to do my online fashion shopping


#  @wip
  Scenario: Adding summer dress to cart
    Given I am on website
    When  I search for Summer dress and add item to cart
    And  I should see summer dress in the cart
    And I click the proceed to checkout button on the modal pop up
    And i click the proceed to checkout button on the cart summary page
    And i verify that i am on the sign in page and page title is "Login - My Store"


  

