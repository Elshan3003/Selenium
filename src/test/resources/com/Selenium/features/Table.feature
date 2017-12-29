Feature: WebTable
Background:
		Given Navigate to "https://the-internet.herokuapp.com/" page
		Then Click on "Challenging DOM" link in herohuapp.com page.
@a
Scenario:
		And Print all elements in the table
		Then Print table body
		
@a
Scenario: Verify table content with excel file
		And Verify headers with table headers in excel file
		Then Verify body with table body in excel file
		
	
	
	
	
	
	
		
		

		