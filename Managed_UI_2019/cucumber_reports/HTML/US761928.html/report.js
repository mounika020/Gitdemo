$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/Saffron_US1223964_Managed Plan UI - Edit Screen.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Mounika sengaran"
    },
    {
      "line": 2,
      "value": "#Feature Scenarios:To verify the Mass Update Screen"
    }
  ],
  "line": 4,
  "name": "Test case is used to validate the Edit screen UI.",
  "description": "",
  "id": "test-case-is-used-to-validate-the-edit-screen-ui.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 10,
  "name": "Test case is used to verify Managed edit screen fields.",
  "description": "",
  "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 9,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Managed plan search screen is be displayed",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Select Year \u003cYear\u003e from the dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Select producttype \u003cProductType\u003e from the dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Enter Contract number \u003cContract\u003e in the textfield",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Enter PBP Number as \u003cPbp\u003e in the textfield for edit scenario",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Click on Search Plans button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Records will be displayed in the search grid then click on edit link for the provided plan in the above step",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "verify user is navagated to edit screen \u003cManagedPlanEditscreen\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "verify that Contract / PBP / Year and Product Type and Drug Coverage Type  and State fields are displayed in disable mode",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Verify the below buttons are displayed",
  "rows": [
    {
      "cells": [
        "Update"
      ],
      "line": 21
    },
    {
      "cells": [
        "Cancel"
      ],
      "line": 22
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "uncheck the checkbox and provide the data for the \u003cFields\u003e and \u003cMarketProductName\u003e and \u003cBusinessSegment\u003e and \u003cSNPFlag\u003e and \u003cSNPType\u003e and \u003cEnrolleeType\u003e displayed in the edit screen",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "After clicking on \u003cTransaction\u003e button the \u003cpopupmessage\u003e will be diplayed then click on the popmessage and then verify the \u003cExceptedResults\u003e screen is displayed",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Verify that \u003cNumberOfRecords\u003e are updated for the \u003cFields\u003e \u003cMarketProductName\u003e and \u003cBusinessSegment\u003e and \u003cSNPFlag\u003e and \u003cSNPType\u003e and \u003cEnrolleeType\u003e in search results and also compare search results with database results",
  "keyword": "And "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;",
  "rows": [
    {
      "cells": [
        "Year",
        "ProductType",
        "NumberOfRecords",
        "Contract",
        "Pbp",
        "record",
        "ManagedPlanEditscreen",
        "Fields",
        "MarketProductName",
        "BusinessSegment",
        "SNPFlag",
        "SNPType",
        "EnrolleeType",
        "Transaction",
        "popupmessage",
        "ExceptedResults"
      ],
      "line": 28,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;1"
    },
    {
      "cells": [
        "\"2019\"",
        "\"1 - HMO\"",
        "1",
        "\"H0755\"",
        "\"855\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"ALL\"",
        "\"UnitedHealthcare Group Medicare Advantage (HMO)\"",
        "\"Medica\"",
        "\"Y\"",
        "\"Dual - Eligible\"",
        "\"A/B\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 29,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;2"
    },
    {
      "cells": [
        "\"2019\"",
        "\"2 - HMOPOS\"",
        "1",
        "\"H1286\"",
        "\"801\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"MarketProductName\"",
        "\"MedicareComplete Retiree Plan (HMO-POS)\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 30,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;3"
    },
    {
      "cells": [
        "\"2019\"",
        "\"4 - LPPO\"",
        "1",
        "\"H3921\"",
        "\"801\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"SNPFlag and SNPType\"",
        "\"\"",
        "\"\"",
        "\"Y\"",
        "\"Chronic or Disabling Condition\"",
        "\"\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 31,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;4"
    },
    {
      "cells": [
        "\"2019\"",
        "\"12 - 1876 Cost\"",
        "1",
        "\"H2450\"",
        "\"803\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"BusinessSegmentandEnrolleeType\"",
        "\"\"",
        "\"Medica\"",
        "\"\"",
        "\"\"",
        "\"A/B\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 32,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;5"
    },
    {
      "cells": [
        "\"2019\"",
        "\"29 - Senior Supplemental\"",
        "1",
        "\"SRSUP\"",
        "\"902\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"BusinessSegmentandEnrolleeType\"",
        "\"\"",
        "\"Senior Supplement\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 33,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;6"
    },
    {
      "cells": [
        "\"2019\"",
        "\"29 - Senior Supplemental\"",
        "1",
        "\"SRSUP\"",
        "\"908\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"SNPFlag and SNPType\"",
        "\"\"",
        "\"\"",
        "\"N\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 34,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;7"
    },
    {
      "cells": [
        "\"2019\"",
        "\"32 - Select Solutions\"",
        "1",
        "\"MDSUP\"",
        "\"S19\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"onlyEnrolleeType\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Part B Only\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 35,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;8"
    },
    {
      "cells": [
        "\"2019\"",
        "\"30 - Medicaid\"",
        "1",
        "\"MCAID\"",
        "\"M51\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"MarketProductName\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Please enter Market Product Name\"",
        "\"Managed Plan Edit\""
      ],
      "line": 36,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;9"
    },
    {
      "cells": [
        "\"2019\"",
        "\"31 - Dental\"",
        "1",
        "\"DENTL\"",
        "\"D11\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"SNP Flag\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Please select SNP Flag\"",
        "\"Managed Plan Edit\""
      ],
      "line": 37,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;10"
    },
    {
      "cells": [
        "\"2019\"",
        "\"32 - Select Solutions\"",
        "1",
        "\"MDSUP\"",
        "\"S20\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"SNPType\"",
        "\"\"",
        "\"\"",
        "\"Y\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Please select SNP Type along with SNP Flag\"",
        "\"Managed Plan Edit\""
      ],
      "line": 38,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;11"
    },
    {
      "cells": [
        "\"2019\"",
        "\"31 - Dental\"",
        "1",
        "\"DENTL\"",
        "\"D31\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"BusinessSegment\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Please select Business Segment\"",
        "\"Managed Plan Edit\""
      ],
      "line": 39,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;12"
    },
    {
      "cells": [
        "\"2019\"",
        "\"32 - Select Solutions\"",
        "1",
        "\"MDSUP\"",
        "\"S19\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"EnrolleeType\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"Please select Enrollee Type along with Business Segment\"",
        "\"Managed Plan Edit\""
      ],
      "line": 40,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;13"
    },
    {
      "cells": [
        "\"2019\"",
        "\"32 - Select Solutions\"",
        "1",
        "\"MDSUP\"",
        "\"S20\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"onlySNPType\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Chronic or Disabling Condition\"",
        "\"\"",
        "\"Update\"",
        "\"Are you sure you want to process these records?\"",
        "\"Managed Plan Search\""
      ],
      "line": 41,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;14"
    },
    {
      "cells": [
        "\"2019\"",
        "\"28 - Medicare Supplemental\"",
        "1",
        "\"MDSUP\"",
        "\"S09\"",
        "1",
        "\"Managed Plan Edit\"",
        "\"null\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"\"",
        "\"Update\"",
        "\"You must select at least one value to edit\"",
        "\"Managed Plan Edit\""
      ],
      "line": 42,
      "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;15"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11818380700,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Login to the Maps UI and click on Managed plan setup link",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.login_to_the_Maps_UI_and_click_on_Managed_plan_setup_link()"
});
formatter.result({
  "duration": 30352835400,
  "error_message": "java.lang.AssertionError: Failed to click on Managed Plan setup link\r\n\tat org.testng.Assert.fail(Assert.java:93)\r\n\tat stepDefinitions.Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.login_to_the_Maps_UI_and_click_on_Managed_plan_setup_link(Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.java:92)\r\n\tat ✽.Given Login to the Maps UI and click on Managed plan setup link(./Features/Saffron_US1223964_Managed Plan UI - Edit Screen.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 29,
  "name": "Test case is used to verify Managed edit screen fields.",
  "description": "",
  "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 9,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Managed plan search screen is be displayed",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Select Year \"2019\" from the dropdown",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Select producttype \"1 - HMO\" from the dropdown",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Enter Contract number \"H0755\" in the textfield",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Enter PBP Number as \"855\" in the textfield for edit scenario",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Click on Search Plans button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Records will be displayed in the search grid then click on edit link for the provided plan in the above step",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "verify user is navagated to edit screen \"Managed Plan Edit\"",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "verify that Contract / PBP / Year and Product Type and Drug Coverage Type  and State fields are displayed in disable mode",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Verify the below buttons are displayed",
  "rows": [
    {
      "cells": [
        "Update"
      ],
      "line": 21
    },
    {
      "cells": [
        "Cancel"
      ],
      "line": 22
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "uncheck the checkbox and provide the data for the \"ALL\" and \"UnitedHealthcare Group Medicare Advantage (HMO)\" and \"Medica\" and \"Y\" and \"Dual - Eligible\" and \"A/B\" displayed in the edit screen",
  "matchedColumns": [
    7,
    8,
    9,
    10,
    11,
    12
  ],
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "After clicking on \"Update\" button the \"Are you sure you want to process these records?\" will be diplayed then click on the popmessage and then verify the \"Managed Plan Search\" screen is displayed",
  "matchedColumns": [
    13,
    14,
    15
  ],
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Verify that 1 are updated for the \"ALL\" \"UnitedHealthcare Group Medicare Advantage (HMO)\" and \"Medica\" and \"Y\" and \"Dual - Eligible\" and \"A/B\" in search results and also compare search results with database results",
  "matchedColumns": [
    2,
    7,
    8,
    9,
    10,
    11,
    12
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Steps_Configuration_ManagedUI_ManagedPlanUI_Export.managed_plan_search_screen_is_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2019",
      "offset": 13
    }
  ],
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.select_Year_from_the_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1 - HMO",
      "offset": 20
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.select_producttype_from_the_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "H0755",
      "offset": 23
    }
  ],
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.enter_Contract_number_in_the_textfield(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "855",
      "offset": 21
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.enter_PBP_Number_as_in_the_textfield(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_Configuration_ManagedUI_SearchScreen_PublicAndSecure.click_on_Search_Plans_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.records_will_be_displayed_in_the_search_grid_then_click_on_edit_link_for_the_provided_plan_in_the_above_step()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Managed Plan Edit",
      "offset": 41
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.verify_user_is_navagated_to_edit_screen(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.verify_that_Contract_PBP_Year_and_Product_Type_and_Drug_Coverage_Type_and_State_fields_are_displayed_in_disable_mode()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.verify_the_below_buttons_are_displayed(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "ALL",
      "offset": 51
    },
    {
      "val": "UnitedHealthcare Group Medicare Advantage (HMO)",
      "offset": 61
    },
    {
      "val": "Medica",
      "offset": 115
    },
    {
      "val": "Y",
      "offset": 128
    },
    {
      "val": "Dual - Eligible",
      "offset": 136
    },
    {
      "val": "A/B",
      "offset": 158
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.uncheck_the_checkbox_and_provide_the_data_for_the_and_and_and_and_and_displayed_in_the_edit_screen(String,String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Update",
      "offset": 19
    },
    {
      "val": "Are you sure you want to process these records?",
      "offset": 39
    },
    {
      "val": "Managed Plan Search",
      "offset": 155
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.after_clicking_on_button_the_will_be_diplayed_then_click_on_the_popmessage_and_then_verify_the_screen_is_displayed(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    },
    {
      "val": "ALL",
      "offset": 35
    },
    {
      "val": "UnitedHealthcare Group Medicare Advantage (HMO)",
      "offset": 41
    },
    {
      "val": "Medica",
      "offset": 95
    },
    {
      "val": "Y",
      "offset": 108
    },
    {
      "val": "Dual - Eligible",
      "offset": 116
    },
    {
      "val": "A/B",
      "offset": 138
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.verify_that_are_updated_for_the_and_and_and_and_in_search_results_and_also_compare_search_results_with_database_results(int,String,String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1595351100,
  "status": "passed"
});
formatter.before({
  "duration": 4914280600,
  "status": "passed"
});
formatter.background({
  "line": 6,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Login to the Maps UI and click on Managed plan setup link",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.login_to_the_Maps_UI_and_click_on_Managed_plan_setup_link()"
});
formatter.result({
  "duration": 33649800,
  "error_message": "java.lang.AssertionError: Failed to click on Managed Plan setup link\r\n\tat org.testng.Assert.fail(Assert.java:93)\r\n\tat stepDefinitions.Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.login_to_the_Maps_UI_and_click_on_Managed_plan_setup_link(Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.java:92)\r\n\tat ✽.Given Login to the Maps UI and click on Managed plan setup link(./Features/Saffron_US1223964_Managed Plan UI - Edit Screen.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 30,
  "name": "Test case is used to verify Managed edit screen fields.",
  "description": "",
  "id": "test-case-is-used-to-validate-the-edit-screen-ui.;test-case-is-used-to-verify-managed-edit-screen-fields.;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 9,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "Managed plan search screen is be displayed",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "Select Year \"2019\" from the dropdown",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Select producttype \"2 - HMOPOS\" from the dropdown",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Enter Contract number \"H1286\" in the textfield",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Enter PBP Number as \"801\" in the textfield for edit scenario",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Click on Search Plans button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Records will be displayed in the search grid then click on edit link for the provided plan in the above step",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "verify user is navagated to edit screen \"Managed Plan Edit\"",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "verify that Contract / PBP / Year and Product Type and Drug Coverage Type  and State fields are displayed in disable mode",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Verify the below buttons are displayed",
  "rows": [
    {
      "cells": [
        "Update"
      ],
      "line": 21
    },
    {
      "cells": [
        "Cancel"
      ],
      "line": 22
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "uncheck the checkbox and provide the data for the \"MarketProductName\" and \"MedicareComplete Retiree Plan (HMO-POS)\" and \"\" and \"\" and \"\" and \"\" displayed in the edit screen",
  "matchedColumns": [
    7,
    8,
    9,
    10,
    11,
    12
  ],
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "After clicking on \"Update\" button the \"Are you sure you want to process these records?\" will be diplayed then click on the popmessage and then verify the \"Managed Plan Search\" screen is displayed",
  "matchedColumns": [
    13,
    14,
    15
  ],
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "Verify that 1 are updated for the \"MarketProductName\" \"MedicareComplete Retiree Plan (HMO-POS)\" and \"\" and \"\" and \"\" and \"\" in search results and also compare search results with database results",
  "matchedColumns": [
    2,
    7,
    8,
    9,
    10,
    11,
    12
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Steps_Configuration_ManagedUI_ManagedPlanUI_Export.managed_plan_search_screen_is_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2019",
      "offset": 13
    }
  ],
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.select_Year_from_the_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2 - HMOPOS",
      "offset": 20
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.select_producttype_from_the_dropdown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "H1286",
      "offset": 23
    }
  ],
  "location": "Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties.enter_Contract_number_in_the_textfield(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "801",
      "offset": 21
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.enter_PBP_Number_as_in_the_textfield(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_Configuration_ManagedUI_SearchScreen_PublicAndSecure.click_on_Search_Plans_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.records_will_be_displayed_in_the_search_grid_then_click_on_edit_link_for_the_provided_plan_in_the_above_step()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Managed Plan Edit",
      "offset": 41
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.verify_user_is_navagated_to_edit_screen(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.verify_that_Contract_PBP_Year_and_Product_Type_and_Drug_Coverage_Type_and_State_fields_are_displayed_in_disable_mode()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps_validation_of_Managed_Create_screen.verify_the_below_buttons_are_displayed(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "MarketProductName",
      "offset": 51
    },
    {
      "val": "MedicareComplete Retiree Plan (HMO-POS)",
      "offset": 75
    },
    {
      "val": "",
      "offset": 121
    },
    {
      "val": "",
      "offset": 128
    },
    {
      "val": "",
      "offset": 135
    },
    {
      "val": "",
      "offset": 142
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.uncheck_the_checkbox_and_provide_the_data_for_the_and_and_and_and_and_displayed_in_the_edit_screen(String,String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Update",
      "offset": 19
    },
    {
      "val": "Are you sure you want to process these records?",
      "offset": 39
    },
    {
      "val": "Managed Plan Search",
      "offset": 155
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.after_clicking_on_button_the_will_be_diplayed_then_click_on_the_popmessage_and_then_verify_the_screen_is_displayed(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 12
    },
    {
      "val": "MarketProductName",
      "offset": 35
    },
    {
      "val": "MedicareComplete Retiree Plan (HMO-POS)",
      "offset": 55
    },
    {
      "val": "",
      "offset": 101
    },
    {
      "val": "",
      "offset": 108
    },
    {
      "val": "",
      "offset": 115
    },
    {
      "val": "",
      "offset": 122
    }
  ],
  "location": "Steps_validation_of_Managed_Create_screen.verify_that_are_updated_for_the_and_and_and_and_in_search_results_and_also_compare_search_results_with_database_results(int,String,String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1864656600,
  "status": "passed"
});
