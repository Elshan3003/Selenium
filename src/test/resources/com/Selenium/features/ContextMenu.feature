Feature:  Test Context Menu (right click)
Background: 
	Given Navigate to "http://bit.ly/1CAV05I" page
	

Scenario:
	Then Verify if "Example code" and "Example HTML" links are displayed

Scenario Outline:
	Then Verify if the following link "<link>" are displayed
	Examples: 
	|link						 |
	|Simple Context Menu		 |
	|Input Commands				 |
	|Hover Activated Context Menu|
	

Scenario:
	And Right Click on Right Click Me element
	Then Verify that there are six elements on menu
	Then Verify that all elements are displayed
	 	|edit	|
	 	|cut 	|
	 	|copy	|
	 	|paste 	|
	 	|delete	|
	 	|quit  	|
	

Scenario:	
	And Right Click on Right Click Me element
	Then Click on EDIT menu option
	And Verify that if alert is present Then Accept alert
	

	 
Scenario: Right click with shortcut keys 
		Then Click on Edit by Alt+e
		And Verify that if Alert text is "clicked: edit"


Scenario Outline: All alert text verification
	And Right Click on Right Click Me element
	Then Click on "<link>" element
	And Verify that if Alert text is "<alertText>"

	Examples:
		|link	|alertText		|
		|edit	|clicked: edit	|
	 	|cut 	|clicked: cut	|
	 	|copy	|clicked: copy	|
	 	|paste 	|clicked: paste	|
	 	|delete	|clicked: delete|
	 	|quit  	|clicked: quit	|
	 	
	
	
	
	 	
	 	
	 	
	