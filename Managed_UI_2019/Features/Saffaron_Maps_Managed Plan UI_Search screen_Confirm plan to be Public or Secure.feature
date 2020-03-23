#Author: Mounika sengaran

#Feature Scenarios: 1)To verify the plans being made Public or Secure on UI and DB


	Feature: To verify plans being made Public or Secure for Search screen
   
    Background: 
    Given Login to the Maps UI and click on Managed plan UI link
		    	
	@tag1
    Scenario Outline: Test case is used to submit/cancel plans to make them Public/Secure 
    When Managed plan search screen will be displayed
    And Select Year <Year> from the dropdown and Contract number as <Contract>
    And Click on Search Plans button
    Then data is displayed in result table and make selected item secure button and make selected item public button are displayed
    And select <NumberOfRecords> where status is <Current Status>
    And click on <Conversion Type> button
    Then verify confirmation pop up window to mark plan as <Expected Status> is displayed
    And click on ok button
    Then The following plans will be Marked <Expected Status> screen is displayed
    And verify both plans selected are present on the page
    And click on <Transaction>
    Then verify Managed plan search screen is displayed
    And  Select Year <Year> from the dropdown and Contract number as <Contract>  
    And  Click on Search Plans button
    Then the status of above plans should be <Actual Status> in UI
    And validate the DB value for isActive flag is <Flag> 
    Examples: 
   	  |  Year	|Contract|Current Status|       Conversion Type				|Expected Status|Transaction			|Actual Status|NumberOfRecords|Flag| 
   	  |"2019"	|	"H9952"| "Secure"			|	"make selected item Public"	|"Public"				|"Cancel"					|"Secure"			|		2						|	 0 | 	 
 			|"2019"	|	"H9952"| "Secure"			|	"make selected item Public"	|"Public"				|"Submit Records"	|"Public"			|		2						|	 1 |   
 			|"2019"	|	"H9952"| "Public"			|	"make selected item Secure"	|"Secure"				|"Cancel"					|"Public"			|		2						|	 1 |
   	  |"2019"	|	"H9952"| "Public"			|	"make selected item Secure"	|"Secure"				|"Submit Records"	|"Secure"			|		2						|	 0 |		
   	  |"2018"	|	"H0432"| "Secure"			|	"make selected item Public"	|"Public"				|"Cancel"					|"Secure"			|		1						|	 0 |	
			|"2018"	|	"H0432"| "Secure"			|	"make selected item Public"	|"Public"				|"Submit Records"	|"Public"			|		1						|	 1 |
			|"2018"	|	"H0432"| "Public"			|	"make selected item Secure"	|"Secure"				|"Cancel"					|"Public"			|		1						|	 1 | 
  		|"2018"	|	"H0432"| "Public"			|	"make selected item Secure"	|"Secure"				|"Submit Records"	|"Secure"			|		1						|	 0 |		




			
						    	