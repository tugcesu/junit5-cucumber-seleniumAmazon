@checkout
Feature: Amazon checkout

	Background:
		Given I should see sign in tool bar on the web app
		When  I click to Sign In button on the home page
		Then  I should see the Sign In page

	@case:checkoutAmazon01
	Scenario: Check sign in works properly
		When  I enter "tugce.suberk@gmail.com" as email
		When  I click to continue button
		Then  I should see "tugce.suberk@gmail.com" as email on the password entering page
		When  I enter "Blue2020" as a password
		When  I click to Sign In submit button
		Then  I should see 'Hello, tugce' on the home page
		When  I enter "computer" to find the product in the search box
		When  I click to search button
    Then  I should see search results page
		When  I click to "2"th product on the search result page
		Then  I should see product detail page
		When  I click to add to cart button
		Then  I should see confirmation page
		When  I click to Proceed to checkout button
		Then  I should see payment-checkout page













