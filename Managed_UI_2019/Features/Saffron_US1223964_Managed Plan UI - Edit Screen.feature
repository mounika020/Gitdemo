#Author: Mounika sengaran
#Feature Scenarios:To verify the Mass Update Screen

Feature: Test case is used to validate the Edit screen UI.

  Background: 
    Given Login to the Maps UI and click on Managed plan setup link

  @tag1
  Scenario Outline: Test case is used to verify Managed edit screen fields.
    When Managed plan search screen is be displayed
    And Select Year <Year> from the dropdown
    And Select producttype <ProductType> from the dropdown
    And Enter Contract number <Contract> in the textfield
    And Enter PBP Number as <Pbp> in the textfield for edit scenario
    And Click on Search Plans button
    And Records will be displayed in the search grid then click on edit link for the provided plan in the above step
    Then verify user is navagated to edit screen <ManagedPlanEditscreen>
    And verify that Contract / PBP / Year and Product Type and Drug Coverage Type  and State fields are displayed in disable mode
    And Verify the below buttons are displayed
      | Update |
      | Cancel |
    And uncheck the checkbox and provide the data for the <Fields> and <MarketProductName> and <BusinessSegment> and <SNPFlag> and <SNPType> and <EnrolleeType> displayed in the edit screen
    When After clicking on <Transaction> button the <popupmessage> will be diplayed then click on the popmessage and then verify the <ExceptedResults> screen is displayed
    And Verify that <NumberOfRecords> are updated for the <Fields> <MarketProductName> and <BusinessSegment> and <SNPFlag> and <SNPType> and <EnrolleeType> in search results and also compare search results with database results

    Examples: 
      | Year   | ProductType                  | NumberOfRecords | Contract | Pbp   | record | ManagedPlanEditscreen | Fields                           | MarketProductName                                 | BusinessSegment     | SNPFlag | SNPType                          | EnrolleeType | Transaction | popupmessage                                              | ExceptedResults       |  
      | "2019" | "1 - HMO"                    |               1 | "H0755"  | "855" |      1 | "Managed Plan Edit"   | "ALL"                            | "UnitedHealthcare Group Medicare Advantage (HMO)" | "Medica"            | "Y"     | "Dual - Eligible"                | "A/B"        | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "2 - HMOPOS"                 |               1 | "H1286"  | "801" |      1 | "Managed Plan Edit"   | "MarketProductName"              | "MedicareComplete Retiree Plan (HMO-POS)"         | ""                  | ""      | ""                               | ""           | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "4 - LPPO"                   |               1 | "H3921"  | "801" |      1 | "Managed Plan Edit"   | "SNPFlag and SNPType"            | ""                                                | ""                  | "Y"     | "Chronic or Disabling Condition" | ""           | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "12 - 1876 Cost"             |               1 | "H2450"  | "803" |      1 | "Managed Plan Edit"   | "BusinessSegmentandEnrolleeType" | ""                                                | "Medica"            | ""      | ""                               | "A/B"        | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "29 - Senior Supplemental"   |               1 | "SRSUP"  | "902" |      1 | "Managed Plan Edit"   | "BusinessSegmentandEnrolleeType" | ""                                                | "Senior Supplement" | ""      | ""                               | ""           | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "29 - Senior Supplemental"   |               1 | "SRSUP"  | "908" |      1 | "Managed Plan Edit"   | "SNPFlag and SNPType"            | ""                                                | ""                  | "N"     | ""                               | ""           | "Update"    | "Are you sure you want to process these records?"         | "Managed Plan Search" |
      | "2019" | "32 - Select Solutions"      |               1 | "MDSUP"  | "S19" |      1 | "Managed Plan Edit"   | "onlyEnrolleeType"               | ""                                                | ""                  | ""      | ""                               | "Part B Only"           | "Update"    | "Are you sure you want to process these records?" | "Managed Plan Search"   |
      | "2019" | "30 - Medicaid"              |               1 | "MCAID"  | "M51" |      1 | "Managed Plan Edit"   | "MarketProductName"              | ""                                                | ""                  | ""      | ""                               | ""           | "Update"    | "Please enter Market Product Name"                        | "Managed Plan Edit"   |
      | "2019" | "31 - Dental"                |               1 | "DENTL"  | "D11" |      1 | "Managed Plan Edit"   | "SNP Flag"                       | ""                                                | ""                  | ""      | ""                               | ""           | "Update"    | "Please select SNP Flag"                                  | "Managed Plan Edit"   |
      | "2019" | "32 - Select Solutions"      |               1 | "MDSUP"  | "S20" |      1 | "Managed Plan Edit"   | "SNPType"                        | ""                                                | ""                  | "Y"      | ""                               | ""           | "Update"    | "Please select SNP Type along with SNP Flag"              | "Managed Plan Edit"   |
      | "2019" | "31 - Dental"                |               1 | "DENTL"  | "D31" |      1 | "Managed Plan Edit"   | "BusinessSegment"                | ""                                                | ""                  | ""      | ""                               | ""           | "Update"    | "Please select Business Segment"                          | "Managed Plan Edit"   |
      | "2019" | "32 - Select Solutions"      |               1 | "MDSUP"  | "S19" |      1 | "Managed Plan Edit"   | "EnrolleeType"                   | ""                                                | ""                  | ""      | ""                               | ""           | "Update"    | "Please select Enrollee Type along with Business Segment" | "Managed Plan Edit"   |
      | "2019" | "32 - Select Solutions"      |               1 | "MDSUP"  | "S20" |      1 | "Managed Plan Edit"   | "onlySNPType"                    | ""                                                | ""                  | ""      | "Chronic or Disabling Condition"                               | ""           | "Update"    | "Are you sure you want to process these records?"              | "Managed Plan Search"   |
      | "2019" | "28 - Medicare Supplemental" |               1 | "MDSUP"  | "S09" |      1 | "Managed Plan Edit"   | "null"                           | ""                                                | ""                  | ""      | ""                               | ""           | "Update"    | "You must select at least one value to edit"              | "Managed Plan Edit"   |
  
   @tag2   
   Scenario Outline: Test case is used check the selected plan county validations
    When Managed plan search screen is be displayed
    And Select Year <Year> from the dropdown
    And Select producttype <ProductType> from the dropdown
    And Click on Search Plans button
    And Records will be displayed in search grid  
    And select one record from the result list and get its county count and click on Edit link
    Then manage plan edit page should display for the selected record 
    And verify the selected county count in county field is equal to searched record and if selected record have less than 4 counties names should be dispayed
    And verify after clicking county checbox the county values are editable 
    And select and update county
    Then The updated vaues should reflect in UI and DB for county on Edit screen
     Examples:
      | Year   | ProductType   |
      | "2019" | "2 - HMOPOS"  |

   @tag3 
   Scenario Outline: Test case is used check the selected plan blank county pop up validation
    When Managed plan search screen is be displayed
    And Select Year <Year> from the dropdown
    And Select producttype <ProductType> from the dropdown
    And Click on Search Plans button
    And Records will be displayed in search grid  
    And select one record from the result list and get its county count and click on Edit link
    Then manage plan edit page should display for the selected record 
    And verify if no county is selected and clicked on update button pop up validation should appear
     Examples:
      | Year   | ProductType   |
      | "2019" | "2 - HMOPOS"  |
  