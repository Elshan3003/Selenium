Feature: Nested frame
Background:
		Given Navigate to "https://the-internet.herokuapp.com/" page
		Then Click on "Nested Frames" link in herohuapp.com page.
		
		
Scenario: Test Nested frames
	And verify that there is three nested frame in top frame
	Then go into Middle frame the return Bottom frame
	And From buttom frame go right frame

		
Scenario: Test Nested frames
	Then go into Right frame then go to the left frame
	And go into the buttom frame the return Right frame

	
		
