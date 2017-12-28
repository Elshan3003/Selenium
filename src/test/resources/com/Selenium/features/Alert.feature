Feature: Alert Test


Background:
 Given navigate to Selenium Academy homepage
 Then Click on "Alerts Example" link
 
 Scenario: Accept Alert
 Then Click on "Show alert box" button
 And  If alert is appeared, accept it
 
 Scenario: Dismiss Alert
 Then Click on  first Try it button
 And if Alert is present , dismiss it
 Then Verify if "You Dismissed Alert!" text is displayed

 Scenario: Send text to Alert box
 Then Click on  second Try it button
 And if Alert is present , Send "Elshan" to alertbox
  Then Verify if "Hello Elshan! How are you today?" text is displayed
