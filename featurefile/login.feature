Feature: Login Functionality 
@data-driven 
Scenario: Login with valid credentials 
	Given Navigate to Home page 
	When user enters username and password 
	Then user logged in successfully 
	@user-specific
	Scenario Outline: Login with valid credentials 
	Given Navigate to Home page 
	When user enters "<username>" and "<password>" 
	Then user logged in successfully 
	
	Examples: 
		|username|password|
		|lalitha|Password123|
		|ABC|XYZ|
	
@data-driven 
Scenario:
The one where user picks different products through search functionality 
	When Larry searches below products in the search box: 
		|Headphones|
		|Carpet|
	Then product should be added in the cart if available 
	
	

