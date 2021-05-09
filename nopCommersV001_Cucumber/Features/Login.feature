Feature:Login

@sanity
Scenario: Successful Login with valid Credentials
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	And close browser
	
@regression
Scenario Outline:Login Data Driven
      
    Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	And close browser
	
	Examples:
 |	email	| |	password	|
 |	admin@yourstore.com	| |	admin	|
 |	admin@yourstore.com	| |	admin123	|