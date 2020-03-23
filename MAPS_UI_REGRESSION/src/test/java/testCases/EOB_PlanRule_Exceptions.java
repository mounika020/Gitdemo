package testCases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Action_EOB_Page;
import actions.Action_EOB_Planrule;
import miscellaneous.BaseClass;
import miscellaneous.BeforeAndAfter;
import pageObjects.EOBGroupException;
import utilities.Constants;
import utilities.Utils;

public class EOB_PlanRule_Exceptions extends BeforeAndAfter {
	// TC_EOB Group Exceptions_Create Exception_Cancel_EOB_N
	@Test(priority=0)
	void TC_EOBPlanRule_CreateNewEOBPlanRule_Searchparameters()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBPlanRule_CreateNewEOBPlanRule_Searchparameters");

		// checking the execution flag in Maps_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBPlanRule_CreateNewEOBPlanRule_Searchparameters")
  				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOBPlanRule_CreateNewEOBPlanRule_Searchparameters_N_Y.xlsx", "Sheet1");

			Action_EOB_Planrule.clickOnCreateEobPlanRule();
	         Action_EOB_Planrule.verify_planyear();
			Action_EOB_Planrule.verify_Category();
			Action_EOB_Planrule.verify_Contract();
			Action_EOB_Planrule.verify_DrugCoverageType();
			Action_EOB_Planrule.verify_ClaimsSystem();
			Action_EOB_Planrule.verify_BusinessSegment();
			Action_EOB_Planrule.verify_PBP();
			

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	
	
	// TC_EOBPlanRule_CreateNewRule_Cancel
	@Test(priority=1)
	void TC_EOBPlanRule_CreateNewRule_Cancel() throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBPlanRule_CreateNewRule_Cancel");

		// checking the execution flag in Maps_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBPlanRule_CreateNewRule_Cancel").equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
			Action_EOB_Planrule.clickOnCreateEobPlanRule();
			Action_EOB_Planrule.waitForPageToLoad(driver);
			Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(1).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			Action_EOB_Planrule.clickOnSearch();
			Action_EOB_Planrule.selectEmployergroup_Checkbox();
			Action_EOB_Planrule.clickOnCancel();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}

	}

	// TC_EOBPlanRule_CreateNewRule_DeleteRules
	@Test(priority=2)
	void TC_EOBPlanRule_CreateNewRule_DeleteRules() throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBPlanRule_CreateNewRule_DeleteRules");
		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBPlanRule_CreateNewRule_DeleteRules").equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
			Action_EOB_Planrule.clickOnCreateEobPlanRule();
			Action_EOB_Planrule.waitForPageToLoad(driver);
			Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(2).getCell(0).getStringCellValue());
			Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(2).getCell(1).getStringCellValue());
			Action_EOB_Planrule.selectcontract_dropdown(inSheet.getRow(2).getCell(2).getStringCellValue());
			Action_EOB_Planrule.selectPBP_dropdown(inSheet.getRow(2).getCell(3).getStringCellValue());
			Thread.sleep(2000);
			Action_EOB_Planrule.clickOnSearch();
		}
	}
	// TC_EOB Plan Rule_Create New Rule_EOB Yes_OneLanguage_AlternatePlans
	@Test(priority=3)
	void TC_EOBPlanRule_CreateNewRule_EOBYes_OneLanguage_AlternatePlans()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_EOBPlanRule_CreateNewRule_EOBYes_OneLanguage_AlternatePlans");

		// checking the execution flag in Maps_Infobank
		if (Utils.getTestCasePreferenceFromInfobank(
				"TC_EOBPlanRule_CreateNewRule_EOBYes_OneLanguage_AlternatePlans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
			Action_EOB_Planrule.clickOnCreateEobPlanRule();
			Action_EOB_Planrule.waitForPageToLoad(driver);
			Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(3).getCell(0).getStringCellValue());
			Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(3).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			Action_EOB_Planrule.clickOnSearch();
			System.out.println(inSheet.getRow(3).getCell(2).getStringCellValue());
			System.out.println(inSheet.getRow(3).getCell(3).getStringCellValue());
		
			
			Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(3).getCell(2).getStringCellValue(),
					inSheet.getRow(3).getCell(3).getStringCellValue());
			Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(3).getCell(4).getStringCellValue());
			Action_EOB_Planrule.select_RussianCheckbox();
			Action_EOB_Planrule.select_SpanishCheckbox();
			Action_EOB_Planrule.select_VietnameseCheckbox();
			Action_EOB_Planrule.clickOnSave();
			
		}
	}
// TC_EOB Plan Rule_Create New Rule_EOB_Yes_MultipleLanguages_AllPlans
@Test(priority=4)
void TC_EOBPlanRule_CreateNewRule_EOB_Yes_MultipleLanguages_AllPlans()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRultlle_CreateNewRule_EOB_Yes_MultipleLanguages_AllPlans");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_EOB_Yes_MultipleLanguages_AllPlans").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(3).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		Action_EOB_Planrule.clickOnSearch();
		System.out.println(inSheet.getRow(3).getCell(2).getStringCellValue());
		System.out.println(inSheet.getRow(3).getCell(3).getStringCellValue());
		Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(3).getCell(2).getStringCellValue(),
				inSheet.getRow(3).getCell(3).getStringCellValue());
		Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(3).getCell(4).getStringCellValue());
		Action_EOB_Planrule.select_RussianCheckbox();
		Action_EOB_Planrule.select_SpanishCheckbox();
		Action_EOB_Planrule.select_VietnameseCheckbox();
		Action_EOB_Planrule.clickOnSave();
	}
}
//TC_EOB Plan Rule_Create New Rule_EOBDropDown_NO_Languages
@Test(priority=5)
void TC_EOBPlanRule_CreateNewRule_EOBDropDown_NO_Languages()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_CreateNewRule_EOBDropDown_NO_Languages");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_EOBDropDown_NO_Languages").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(4).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(4).getCell(1).getStringCellValue());
		Action_EOB_Planrule.clickOnSearch();
		Action_EOB_Planrule.selectPlan_Checkbox();
		Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(4).getCell(4).getStringCellValue());
		Action_EOB_Planrule.clickOnSave();	
		Action_EOB_Planrule.alert();
	}
}

//TC_EOB Plan Rule_Create New Rule_EOBDropDown_YES_Languages

@Test(priority=6)
void TC_EOBPlanRule_CreateNewRule_EOBDropDown_YES_Languages()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_CreateNewRule_EOBDropDown_YES_Languages");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_EOBDropDown_YES_Languages").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(5).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(5).getCell(1).getStringCellValue());
		Action_EOB_Planrule.clickOnSearch();
		Action_EOB_Planrule.selectPlan_Checkbox();
		Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(5).getCell(4).getStringCellValue());
	    Action_EOB_Planrule.clickOnSave();	
	    Action_EOB_Planrule.alert();
	}
}

//TC_EOB Plan Rule_Create New Rule_Languages_Dropdown------
@Test(priority=7)
void TC_EOBPlanRule_CreateNewRule_Languages_Dropdown()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_CreateNewRule_Languages_Dropdown");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_Languages_Dropdown").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(5).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(5).getCell(1).getStringCellValue());
		Action_EOB_Planrule.clickOnSearch();
	}
}



//TC_EOB Plan Rule_Create New Rule_No Plan Selected_Error-----

@Test(priority=8)
void TC_EOBPlanRule_CreateNewRule_NoPlanSelected_Error()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_CreateNewRule_NoPlanSelected_Error");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_NoPlanSelected_Error").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(3).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(3).getCell(1).getStringCellValue());
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.clickOnSearch();
		Thread.sleep(3000);
		Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(3).getCell(4).getStringCellValue());
		Action_EOB_Planrule.select_RussianCheckbox();
		Action_EOB_Planrule.select_SpanishCheckbox();
		Action_EOB_Planrule.select_VietnameseCheckbox();
		Action_EOB_Planrule.clickOnSave();
	}
}

//TC_EOB Plan Rule_Create New Rule_Yes_AllLanguages_MultiplePlans------
@Test(priority=9)
void TC_EOBPlanRule_CreateNewRule_Yes_AllLanguages_MultiplePlans()
		throws ClassNotFoundException, SQLException, InterruptedException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_CreateNewRule_Yes_AllLanguages_MultiplePlans");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_CreateNewRule_Yes_AllLanguages_MultiplePlans").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.clickOnCreateEobPlanRule();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(3).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcategory_dropdown(inSheet.getRow(3).getCell(1).getStringCellValue());
		Thread.sleep(2000);
		Action_EOB_Planrule.clickOnSearch();
		System.out.println(inSheet.getRow(3).getCell(2).getStringCellValue());
		System.out.println(inSheet.getRow(3).getCell(3).getStringCellValue());
		Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(3).getCell(2).getStringCellValue(),
				inSheet.getRow(3).getCell(3).getStringCellValue());
		Action_EOB_Planrule.selectEOBIndicator_dropdown(inSheet.getRow(3).getCell(4).getStringCellValue());
		Action_EOB_Planrule.select_RussianCheckbox();
		Action_EOB_Planrule.select_SpanishCheckbox();
		Action_EOB_Planrule.select_VietnameseCheckbox();
		Action_EOB_Planrule.clickOnSave();
	}
}

//TC_EOB Plan Rule_Delete_Cancel--------D
@Test(priority=10)
void TC_EOBPlanRule_Delete_Cancel()
		throws ClassNotFoundException, SQLException, InterruptedException, IOException {
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_Delete_Cancel");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_Delete_Cancel").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.verify_EOBPlanRuleList();
		Action_EOB_Planrule.waitForPageToLoad(driver);
	
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(6).getCell(0).getStringCellValue());
		
		Action_EOB_Planrule.selectcontract_dropdown(inSheet.getRow(6).getCell(2).getStringCellValue());
		Action_EOB_Planrule.selectPBP_dropdown(inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOn_Search();
		Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(6).getCell(2).getStringCellValue(),
				inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOndeleteplanrule();
		Action_EOB_Planrule.alertdismiss();
		Action_EOB_Planrule.verifyUiresults_cancel();
		Action_EOB_Planrule.compareSearchResultWithDBvalues();
	}
} 


//TC_EOBPlanRule_Delete_Having Exceptions_StatusI,U
@Test(priority=11)
void TC_EOBPlanRule_DeleteHavingExceptions_StatusIU()
		throws ClassNotFoundException, SQLException, InterruptedException{
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_DeleteHavingExceptions_StatusIU");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_DeleteHavingExceptions_StatusIU").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.verify_EOBPlanRuleList();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(6).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcontract_dropdown(inSheet.getRow(6).getCell(2).getStringCellValue());
		Action_EOB_Planrule.selectPBP_dropdown(inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOn_Search();
		Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(6).getCell(2).getStringCellValue(),
				inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOndeleteplanrule();
		Action_EOB_Planrule.alertdismiss();
		Action_EOB_Planrule.verifyUiresults_cancel();
	}
} 


//TC_EOB Plan Rule_EOBFlag_WithoutGroupException--------
@Test(priority=12)
void TC_EOBPlanRule_EOBFlag_WithoutGroupException()
		throws ClassNotFoundException, SQLException, InterruptedException{
	// starting extent HTML report
	Constants.test = Constants.extent
			.createTest("TC_EOBPlanRule_EOBFlag_WithoutGroupException");

	// checking the execution flag in Maps_Infobank
	if (Utils.getTestCasePreferenceFromInfobank(
			"TC_EOBPlanRule_EOBFlag_WithoutGroupException").equalsIgnoreCase("Y")) {
		initiateBrowser();
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx", "Sheet1");
		Action_EOB_Planrule.verify_EOBPlanRuleList();
		Action_EOB_Planrule.waitForPageToLoad(driver);
		Action_EOB_Planrule.selectPlanYear_dropdown(inSheet.getRow(6).getCell(0).getStringCellValue());
		Action_EOB_Planrule.selectcontract_dropdown(inSheet.getRow(6).getCell(2).getStringCellValue());
		Action_EOB_Planrule.selectPBP_dropdown(inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOn_Search();
		Action_EOB_Planrule.select_mutipleplans_Checkbox(inSheet.getRow(6).getCell(2).getStringCellValue(),
				inSheet.getRow(6).getCell(3).getStringCellValue());
		Action_EOB_Planrule.clickOndeleteplanrule();
		Action_EOB_Planrule.alertdismiss();
		Action_EOB_Planrule.verifyUiresults_cancel();
	}
} 

}





