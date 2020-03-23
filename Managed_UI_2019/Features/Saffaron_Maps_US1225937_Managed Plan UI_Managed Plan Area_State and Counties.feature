#Author: Priyal Agarwal

#Feature Scenarios: 1)To verify Manage Plan Area screen,copy from previous year,verify state and county of both year in DB

	Feature: To verify copied state and county for Managed Plan Area screen
   
    Background: 
    Given Login to the Maps UI and click on Managed plan setup link
     
   @tag1
	 Scenario Outline: Test case is used To verify state and county added for Managed Plan Area screen
	    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  verify create managed plan screen is displayed
	    And  Select Year <Year> from the dropdown
	    And  Enter Contract number <Contract> in the textfield
	    And  Enter PBP Number as <Pbp> in the textfield
	    And  Enter Market Product Name <Marketproductname> in the textfield
	    And  Select Producttype <Producttype> from the dropdown
	    And  Drug Coverage Type <Drugcoveragetype> from the dropdown
	    And  Select Bussiness Segment <BussinessSegment> from the dropdown 
	    And  Enrolle Type<Enrolletype> from the dropdown
	    And  Select SNP Flag <Snpflag> from the dropdown
	    And  SNP Type <Snptype> from the dropdown
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then  Verify the Manged area and page loading is displayed
	    And  Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data
	    And  Verify that Plan Name textfield data is same as the previous screen selected data
  		When click on Add state and provide value to state <State> dropdown and select all counties from county dropdowns
  		And click on create button
    	Then verify UI and DB values are matching     
    	 Examples: 
	      | Year  | Contract | Pbp     |Marketproductname                 				  			|Producttype  |BussinessSegment |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|  State   																																																																																				|
	      | "2019"| "H0755"  | "898"   |"UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO" 	|"Medica"					|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | "AK,AL,AR,AS,AZ,CA,CO,CT,DC,DE,FL,GA,GU,HI,IA,ID,IL,IN,KS,KY,LA,MA,MD,ME,MI,MN,MO,MP,MS,MT,NC,ND,NE,NH,NJ,NM,NV,NY,OH,OK,OR,PA,PR,RI,SC,SD,TN,TX,UT,VA,VI,VT,WA,WI,WV,WY"				|	
 
 
	 @tag2
	 Scenario Outline: Test case is used to verify delete functionality on service area screen
	    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  verify create managed plan screen is displayed
	    And  Select Year <Year> from the dropdown
	    And  Enter Contract number <Contract> in the textfield
	    And  Enter PBP Number as <Pbp> in the textfield
	    And  Enter Market Product Name <Marketproductname> in the textfield
	    And  Select Producttype <Producttype> from the dropdown
	    And  Drug Coverage Type <Drugcoveragetype> from the dropdown
	    And  Select Bussiness Segment <BussinessSegment> from the dropdown 
	    And  Enrolle Type<Enrolletype> from the dropdown
	    And  Select SNP Flag <Snpflag> from the dropdown
	    And  SNP Type <Snptype> from the dropdown
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then  Verify the Manged area and page loading is displayed
	    And  Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data
	    And  Verify that Plan Name textfield data is same as the previous screen selected data
	    When click on Add state and provide value to state <State> and <County> dropdown and click on delete link for some state
	    Then Validate selected state got deleted
	    Examples: 
	      | Year  | Contract | Pbp     |    Marketproductname                 						|Producttype  |BussinessSegment |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|State		|County      |
        | "2019"| "H0755"  | "897"   |"UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO" 	|"Medica"					|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | "AK,AL"	|"Select All"|
   
   
   @tag3
   Scenario Outline: Test case is used to verify duplicate state error message on service area screen 
    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  verify create managed plan screen is displayed
	    And  Select Year <Year> from the dropdown
	    And  Enter Contract number <Contract> in the textfield
	    And  Enter PBP Number as <Pbp> in the textfield
	    And  Enter Market Product Name <Marketproductname> in the textfield
	    And  Select Producttype <Producttype> from the dropdown
	    And  Drug Coverage Type <Drugcoveragetype> from the dropdown
	    And  Select Bussiness Segment <BussinessSegment> from the dropdown 
	    And  Enrolle Type<Enrolletype> from the dropdown
	    And  Select SNP Flag <Snpflag> from the dropdown
	    And  SNP Type <Snptype> from the dropdown
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then  Verify the Manged area and page loading is displayed
	    And  Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data
	    And Verify that Plan Name textfield data is same as the previous screen selected data
	    When click on Add state and provide value to state <State> and <County> dropdown and Add another state<State> and <County>
	    And  click on create button
	    Then verify pop up error message to check duplicate state exist
	    Examples: 
	     | Year  | Contract | Pbp     |    Marketproductname                 					 	 |Producttype  |BussinessSegment  |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|State		|County      |
       | "2019"| "H0755"  | "896"   |"UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO" 	 |"Medica"					|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | "KY"		|"Select All"|
       
	   
  @tag4
	  Scenario Outline: Test case is used to verify Managed screen copied state and county fields
	    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  Select Year <Year> from the dropdown
	    Then validate checkbox copy from 2018 is unchecked and dropdown is disabled
	    When  Select checkbox copy from 2018
	    And select <Plan> from copy from 2018 dropdown
	    And Enter Contract number <Contract> if enabled and not prefilled
	    And  Enter PBP Number as <Pbp> if enabled and not prefilled
	    And  Enter Market Product Name <Marketproductname> if enabled and not prefilled
	    And  Select Producttype <Producttype> if enabled and not prefilled
	    And  Select Bussiness Segment <BussinessSegment> if enabled and not prefilled
	    And  Select Enrolle Type<Enrolletype> if enabled and not prefilled
	    And  Select SNP Flag <Snpflag> if enabled and not prefilled
	    And  Select SNP Type <Snptype> if enabled and not prefilled
	    And  Select Drug Coverage Type <Drugcoveragetype> if enabled and not prefilled
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then verify total number of states and their counties count on service area screen is equal to 2018 values
	    And verify the county names of one state is equal to that in 2018 values for same state
	    And  click on create button
	    And both year values in DB for state and county are same
	    Examples: 
	      | Year  | Plan				|Contract | Pbp      |    Marketproductname                 							|Producttype               |BussinessSegment    |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|
	      | "2019"|	"H0755-802"	| "H0755" | "895"    |  "UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO"								 |"Medica"						|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  |
#	      | "2019"|	"DENTL-DNT"	| "SRSUP" | "938"    |  "UnitedHealthcare Senior Supplement"| "29-Senior Supplemental" |"Senior Supplement"|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | 

	@tag5
	 Scenario Outline: Test case is used To verify state and selected counties added for Managed Plan Area screen
	    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  verify create managed plan screen is displayed
	    And  Select Year <Year> from the dropdown
	    And  Enter Contract number <Contract> in the textfield
	    And  Enter PBP Number as <Pbp> in the textfield
	    And  Enter Market Product Name <Marketproductname> in the textfield
	    And  Select Producttype <Producttype> from the dropdown
	    And  Drug Coverage Type <Drugcoveragetype> from the dropdown
	    And  Select Bussiness Segment <BussinessSegment> from the dropdown 
	    And  Enrolle Type<Enrolletype> from the dropdown
	    And  Select SNP Flag <Snpflag> from the dropdown
	    And  SNP Type <Snptype> from the dropdown
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then  Verify the Manged area and page loading is displayed
	    And  Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data
	    And  Verify that Plan Name textfield data is same as the previous screen selected data
  		When click on Add state and provide value to state <State> dropdown and <Counties> from county dropdowns
  		And click on create button
    	Then verify UI and DB values are matching for counties    
    	 Examples: 
	      | Year  | Contract | Pbp     |Marketproductname                 				  			|Producttype  |BussinessSegment |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|State   |Counties			 										  |
	      | "2019"| "H0755"  | "894"   |"UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO" 	|"Medica"					|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | "NJ,AK"	 |	"Atlantic,Hudson_Bethel,Denali"|

	   
	  @tag6
   Scenario Outline: Test case is used to verify state error message on service area screen 
    When Managed plan search and Create New Managed Plan button screen will be displayed
	    And  click on Create New Managed Plan button
	    And  verify create managed plan screen is displayed
	    And  Select Year <Year> from the dropdown
	    And  Enter Contract number <Contract> in the textfield
	    And  Enter PBP Number as <Pbp> in the textfield
	    And  Enter Market Product Name <Marketproductname> in the textfield
	    And  Select Producttype <Producttype> from the dropdown
	    And  Drug Coverage Type <Drugcoveragetype> from the dropdown
	    And  Select Bussiness Segment <BussinessSegment> from the dropdown 
	    And  Enrolle Type<Enrolletype> from the dropdown
	    And  Select SNP Flag <Snpflag> from the dropdown
	    And  SNP Type <Snptype> from the dropdown
	    And  Store <Year> and <Contract> and <Pbp> and <Marketproductname>  values to compare the data with next screen
	    And  Click on Next button
	    Then  Verify the Manged area and page loading is displayed
	    And  Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data
	    And Verify that Plan Name textfield data is same as the previous screen selected data
	    When  click on create button without adding any state and county
	    Then Pop up validation with message to add atleast one state and county should appear
	    When click on create button by adding data row without selecting a state and county
	    Then Pop up validation with message to select state should appear
	    When click on create button by selecting any state and without any county
	    Then Pop up validation with message to select atleast one county should appear
	    When click on create button by selecting a state with county and add another data without any state and county values
	    Then Pop up validation with message to select state should appear
	    Examples: 
	     | Year  | Contract | Pbp     |    Marketproductname                 					 	 |Producttype  |BussinessSegment  |Snpflag|  Snptype         |Drugcoveragetype|Enrolletype|State		|County      |
       | "2019"| "H0755"  | "893"   |"UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO" 	 |"Medica"					|   "Y" |"Dual - Eligible" |      "MAPD"    |    "A/B"  | "KY"		|"Select All"|
      