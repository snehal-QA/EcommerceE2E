@E2ETest
Feature: E2E tests for Signup Page

  Background: Otrium.com page is open
    Given unauthenticated user navigates to Otrium.com page

  Scenario Outline: User shops for <brand> in <category>
    When user clicks on "All brands" option
    And user selects gender "<gender>"
    And user selects brand "<brand>"
    Then user is redirected to page having brand "<brand>" image to continue shopping
    When user clicks on "ShopNow"
    And user finish registration page
    And selects "<category>" option
    And user sends shoe with related size for checkout
    Then user enters the checkout details for payment
    And page is moved to payment page

    Examples: 
      | brand  | gender | category |
      | adidas | men    | Shoes    |
      | adidas | Women  | clothing |
