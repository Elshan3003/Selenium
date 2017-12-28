Feature: Test Drag and Drop function

Background:
Given navigate to Selenium Academy homepage
 Then Click on "Drag & Drop Example" link
@s
Scenario: Drag and Drop
And verify if "Drag me to my target" is displayed
And verify if "Drop here" is displayed
Then drag source element to target
And verify if "Dropped!" is displayed, after the element dropped




 
 
 