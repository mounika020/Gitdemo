#Author: Mounika sengaran
Feature: Test case is used to validate the Managed screen UI.

  Background: 
    Given Login to the Maps UI and click on Managed plan setup link


  @tag1
  Scenario Outline: Test case is used to verify Managed screen fields.
    When Managed plan search and Create New Managed Plan button screen will be displayed
    And click on Create New Managed Plan button
    And verify create managed plan screen is displayed
    And Select Year <Year> from the dropdown
    And Enter Contract number <Contract> in the textfield
    And Enter PBP Number as <Pbp> in the textfield for edit scenario
    And Enter Market Product Name <Marketproductname> in the textfield
    And Select Producttype <Producttype> and Drug Coverage Type <Drugcoveragetype> from the dropdown
    And Select Bussiness Segment <BussinessSegment> and  Enrolle Type<Enrolletype> from the dropdown
    And Select SNP Flag <Snpflag> and SNP Type <Snptype> from the dropdown
    And Store field <Year> and <Contract> and <Pbp> and <Marketproductname> and <Producttype> and <BussinessSegment> and <Snpflag> and <Snptype> and <Drugcoveragetype> and <Enrolletype>values values to compare the data with next screen and database.
    And Click on Next button
    Then  Verify the Manged area and page loading is displayed
    And Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data.
    And Verify that Plan Name textfield data is same as the previous screen selected data.
    When click on Add state.
    Then check state and county dropdowns are displayed.
    When provide value to state <State> dropdown
    And click on county textfield and then select county
    And click on create button.
    And Select <Year> and enter <Contract> and <Pbp> then click on search plans in the search screen
    Then compare UI and DB values

    Examples: 
      | Year   | Contract | Pbp   | Marketproductname                                 | Producttype                  | BussinessSegment    | Snpflag | Snptype                          | Drugcoveragetype | Enrolletype   | State | 
      | "2019" | "MDSUP"  | "S26" | "Medicare Supplement"                             | "32 - Select Solutions"      | "Medica"            | "Y"     | "Chronic or Disabling Condition" | ""               | "Part B Only" | "DC"  |
      | "2019" | "H0755"  | "832" | "UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO"                    | "Medica"            | "Y"     | "Dual - Eligible"                | "MAPD"           | "A/B"         | "AK"  |   
      | "2019" | "H0755"  | "833" | "UnitedHealthcare Group Medicare Advantage (HMO)" | "1 - HMO"                    | "Medica"            | "N"     | ""                								| "MAPD"           | "A/B"         | "AK"  | 
      | "2019" | "H1286"  | "834" | "MedicareComplete Retiree Plan (HMO-POS)"         | "2 - HMOPOS"                 | "Medica"            | "Y"     | "Chronic or Disabling Condition" | "MA"             | "Part B Only" | "AL"  |   
      | "2019" | "H3921"  | "835" | "UnitedHealthcare Group Medicare Advantage (PPO)" | "4 - LPPO"                   | "Medica"            | "Y"     | "Institutional"                  | "MAPD"           | "A/B"         | "AR"  |          
      | "2019" | "H2450"  | "836" | "Employer Group"                                  | "12 - 1876 Cost"             | "Medica"            | "Y"     | "Dual - Eligible"                | "MAPD"           | "Part B Only" | "AS"  |           
      | "2019" | "MDSUP"  | "S13" | "MedicareSupplement"                              | "28 - Medicare Supplemental" | "Medica"            | "Y"     | "Chronic or Disabling Condition" | "MA"             | "A/B"         | "AZ"  |             
      | "2019" | "SRSUP"  | "915" | "UnitedHealthcare Senior Supplement"              | "29 - Senior Supplemental"   | "Senior Supplement" | "Y"     | "Dual - Eligible"                | "SSUP"           | ""            | "CA"  |              
      | "2019" | "MCAID"  | "M13" | "Florida Medicaid"                                | "30 - Medicaid"              | "Medica"            | "Y"     | "Institutional"                  | ""               | "A/B"         | "CO"  |               
      | "2019" | "DENTL"  | "D11" | "Dental"                                          | "31 - Dental"                | "Medica"            | "Y"     | "Dual - Eligible"                | ""               | "Part B Only" | "CT"  |              
              
