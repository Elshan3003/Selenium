Feature: Test Double Click 
 
 Background:
 Given navigate to Selenium Academy homepage
 Then Click on "Double Click Example" link

@s
 Scenario: Verify texts on Double click page
 Then Verify if the text in colored box is "Click on me and my color will change".
 And Verify if grey box contains "Div's Text".
@s
 Scenario: Color verification
 Then Verify if color of element is different before and after double click.
 	
@s
 Scenario: Test color verification
 And Verify that color of text "Span's Text" is red.
 
 
 