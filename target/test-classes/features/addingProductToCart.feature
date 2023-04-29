Feature: Search and place the order for products

	@PlaceOrder
  Scenario Outline: User can search for product, add product to cart, and be able to place order
    Given User in on the GreenKart Landing page
    When User searches with <shortName> and extracts actual name of product
    Then User changes amount of the product to <number>
    And Adds product to cart
    Then User proceeds to the Cart page
    And Validates that product names in Cart page and Landing page are equals
    And Apply button and Place Order button are visible

	Examples:
	| shortName 	| number |
	| Tom 				| 3			 |