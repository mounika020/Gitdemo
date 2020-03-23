#Author: Mounika sengaran
#Feature Scenarios: 1)To verify Export Results Functionality


	Feature: To verify Export Results Functionality
   
    Background: 
    Given Login the Maps UI and click on Managed plan UI link
    Then Managed plan search screen is displayed
    And Select current Year from the dropdown
    And Click Search Plans button
    Then data is displayed in result table and Export Results button is displayed
		    	
		@tag1
    Scenario: To verify popup is displayed when Export Results button is selected without checking any Plan
    When data is displayed in result table 
    And Click on Export Results button
    Then verify confirmation pop up window with message "You must select at least one record." is displayed
    And click ok button
    Then Managed plan search screen is be displayed
    
    @tag2
    Scenario: To verify Excel report is generated with correct name and in correct order
    When data is displayed in result table 
    And Select any record from the table
    And Click on Export Results button and save the Excel file 
    Then the file with name Managed Plan UI Export should get downloaded
    And Open the file
    Then verify the order and names of columns in excel file
    
    @tag3
    Scenario: To verify data in Excel report is same as in UI
    When data is displayed in result table 
    And Select multiple records from the table 
    And Click on Export Results button and save the Excel file 
    Then verify number of Records are same as in UI
    Then verify the data for rows in Excel file match with UI
    
   	@tag4
    Scenario Outline: To verify	Order of selected Plan in Excel file is same as that in the Search Results
    When data is displayed in result table 
    And Select Order by dropdown value as <OrderBy Type>
    Then verify data is sorted as per order selected
    When Select all records from the table
    And Click on Export Results button and save the Excel file  
    Then verify number of Records should be same as UI
    And All values of <OrderBy ColumnName> feild must be in same order as UI
     Examples: 
   	  | OrderBy Type	 		|  OrderBy ColumnName	 |
   	  |"Contract Number"	|"Contract Number"		 |
   	  |"State Code"		 		|"State Code"			 		 |
   	  |"Product Type"	 		|"Product Type"		 		 |
   	  |"Business Segment" |"Business Segment" 	 |
  