Feature: Frame_Test

Background:
		Given navigate to Selenium Academy homepage
		Then Click on "Frames Example" link

	@s
	 Scenario: Frame Title Verification by name or ID
	 Then verify if number if iframes are three
	 And verify that "This is Left Frame" text is displayed in left frame
	 Then verify that "This is Right Frame" text is displayed in right frame
	@s
	 Scenario: Frame Test Verification by index
	 Then verify that "This Frame doesn't have id or name" text is displayed in middle frame
	 Then verify if the title of middle frame is like "Frame B"
	 
	@s
	  Scenario Outline: Title verification of frames
	  And verify if title is "<title>" in frame with index number "<index>" and has a message like "<message>"
	    #In this senario I could not get title
		  Examples: 
	  	|index	|title		|message							|
	  	|0		|Frame A	|This is Left Frame					|
	  	|1		|Frame B	|This Frame doesn't have id or name	|
	  	|2		|Frame C	|This is Right Frame				|
  
  

	   
   
@s
	   Scenario: Go to twitter link from
	   And click on Follow Twitter link
	   Then verify that title of new Window is "Unmesh Gundecha (@upgundecha) on Twitter"
	   And verify that this twitter account belongs to "Unmesh Gundecha"
 
 
 
 
  
  
  