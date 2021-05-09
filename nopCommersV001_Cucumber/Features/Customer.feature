Feature: Customer
  
 Background: This steps are common
  	Given User Launch Chrome browser
		When User opens URL "http://admin-demo.nopcommerce.com/login"
		And User enters Email as "admin@yourstore.com" and password as "admin"
		And Click on Login
		Then User can view Dashboard
  @sanity
  Scenario: Add a new Customer
    
		When User click on Customer Menu
		And User click on Customer Menu Item
		And User clikc on Add new button
		Then User can view Add new Customer page
		When User enter Customer info
		And Click on save button
		Then User cna view confirmation message "The new customer has been added successfully"
		And close browser
		@regression
	 Scenario: Search Customer by Email
	 	When User click on Customer Menu
	 	And  User click on Customer Menu Item
	 	And Enter Customer Emailid 
	 	When User click on search button
	 	Then User should found Email in the Search Table
	 	And close browser
	  @regression
		Scenario: Search Customer by Name
	  When User click on Customer Menu
	 	And  User click on Customer Menu Item
	 	And Enter Customer FirstName
	 	And Enter Customer LastName
	 	When User click on search button
	 	Then User should found Name in the Search Table
	 	And close browser
		
  
