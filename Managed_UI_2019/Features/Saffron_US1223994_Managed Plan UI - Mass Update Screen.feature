#Author: Mounika sengaran
#Feature Scenarios:To verify the Mass Update Screen
@browser
Feature: To verify the Mass Update Screen

  Background: 
    Given Login to the Maps UI and click on Managed plan UI link

  @tag1
  Scenario Outline: Test case is used to verify the Mass Update Screen
    When Managed plan search screen will be displayed
    And Select Year <Year> from the dropdown
    And Select producttype <ProductType> from the dropdown
    And Click on Search Plans button
    And Records will be displayed in search grid  and verify Mass Data Update button is displayed
    And select <NumberOfRecords>from the search results grid and click on Mass Data Update button and verify the <message>
    And verify <NumberOfRecords> and Market Product Name and Business Segment and  SNP Flag and SNP Type and Enrollee Type  is displayed with below fields in disable mode with checkbox 
    And Verify the below buttons are displayed
      | Update |
      | Cancel |
    And uncheck the checkbox and provide the data for the <Fields> and <MarketProductName> and <BusinessSegment> and <SNPFlag> and <SNPType> and <EnrolleeType>
    And After clicking on the <Transaction> button the <popupmessage> will be diplayed then click on the popmessage and then verify the <Expectedresults> screen is displayed
    And Verify that <NumberOfRecords> are updated for the <Fields> <MarketProductName> and <BusinessSegment> and <SNPFlag> and <SNPType> and <EnrolleeType> in search results and also compare search results with database results


    Examples: 
      | Year   | ProductType                  | NumberOfRecords | message                                | Fields                             | MarketProductName                                 | BusinessSegment | SNPFlag | SNPType           | EnrolleeType  | Transaction | popupmessage                                                 | Expectedresults            |
      | "2019" | "1 - HMO"                    |               2 | "Managed Plan Mass Update"             | "ALL"                              | "UnitedHealthcare Group Medicare Advantage (HMO)" | "Medica"        | "Y"     | "Dual - Eligible" | "Part B Only" | "Update"    | "Are you sure you want to save this record to the database?" | "Managed Plan Search"      |
      | "2019" | "2 - HMOPOS"                 |               1 | "Managed Plan Mass Update"             | "MarketProductName"                | "MedicareComplete Retiree Plan (HMO-POS)"         | ""              | ""      | ""                | ""            | "Update"    | "Are you sure you want to save this record to the database?" | "Managed Plan Search"      |
      | "2019" | "4 - LPPO"                   |               2 | "Managed Plan Mass Update"             | "SNPFlag and SNPType"              | ""                                                | ""              | "Y"     | "Institutional"   | ""            | "Update"    | "Are you sure you want to save this record to the database?" | "Managed Plan Search"      |
      | "2019" | "12 - 1876 Cost"             |               2 | "Managed Plan Mass Update"             | "BusinessSegment and EnrolleeType" | ""                                                | "Medica"        | ""      | ""                | "Part B Only" | "Update"    | "Are you sure you want to save this record to the database?" | "Managed Plan Search"      |
      | "2018" | "28 - Medicare Supplemental" |               2 | "Managed Plan Mass Update"             | "Marketproductname"                | ""                                                | ""              | ""      | ""                | ""            | "Update"    | "Please enter Market Product Name."                          | "Managed Plan Mass Update" |
      | "2019" | "29 - Senior Supplemental"   |               2 | "Managed Plan Mass Update"             | "BusinessSegment"                  | ""                                                | ""              | ""      | ""                | ""            | "Update"    | "Please select Business Segment"                             | "Managed Plan Mass Update" |
      | "2019" | "30 - Medicaid"              |               2 | "Managed Plan Mass Update"             | "SNP Flag"                         | ""                                                | ""              | ""      | ""                | ""            | "Update"    | "Please select SNP Flag"                                     | "Managed Plan Mass Update" |
      | "2019" | "31 - Dental"                |               2 | "Managed Plan Mass Update"             | "SNPType"                          | ""                                                | ""              | "Y"     | ""                | ""            | "Update"    | "Please select SNP Type along with SNP Flag"                 | "Managed Plan Mass Update" |
      | "2019" | "31 - Dental"                |               2 | "Managed Plan Mass Update"             | "EnrolleeType"                     | ""                                                | "Medica"        | ""      | ""                | ""            | "Update"    | "Please select Enrollee Type along with Business Segment"    | "Managed Plan Mass Update" |
      | "2019" | "32 - Select Solutions"      |               2 | "Managed Plan Mass Update"             | "null"                             | ""                                                | "Medica"        | ""      | ""                | ""            | "Update"    | "You must select at least one value to edit"                 | "Managed Plan Mass Update" |
      | "2019" | "32 - Select Solutions"      |               0 | "You must select at least one record." | ""                                 | ""                                                | ""              | ""      | ""                | ""            | ""          | "You must select at least one value to edit"                 | "Managed Plan Mass Update" |
      | "2019" | "1 - HMO"                    |               2 | "Managed Plan Mass Update"             | "ALL"                              | "UnitedHealthcare Group Medicare Advantage (HMO)" | "Medica"        | "Y"     | "Dual - Eligible" | "Part B Only" | "Cancel"    | "Are you sure you want to save this record to the database?" | "Managed Plan Search"      |
     