Feature: Search for products and check if they present in TopDeals page
	
	@Search
  Scenario Outline: Search expirience for product search in both Home and TopDeals pages
    Given User in on the GreenKart Landing page
    When User searches with <shortName> and extracts actual name of product
    Then User searches for the same Shortname <shortName> in TopDeals page to check if product exists
    Then Validate that product names in TopDeals page and Landing page are equals

	Examples:
	| shortName 		|
	| Tom 					|
	| Beet 				|