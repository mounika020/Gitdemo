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
import miscellaneous.BaseClass;
import miscellaneous.BeforeAndAfter;
import pageObjects.EOBGroupException;
import utilities.Constants;
import utilities.Utils;

public class EOB_Group_Exceptions_TestCases extends BeforeAndAfter {
	// TC_EOB Group Exceptions_Create Exception_Cancel_EOB_Na
	@Test(priority = 0)
	void TC_EOBGroupExceptions_CreateException_InMAPS_EG_EOB_YES_NoLanguages()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_EOBGroupExceptions_CreateException_InMAPS_EG_EOB_YES_NoLanguages");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank(
				"TC_EOBGroupExceptions_CreateException_InMAPS_EG_EOB_YES_NoLanguages").equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			if (Action_EOB_Page.Employergroup_DB() == true) {

				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.clickOnSearch_button();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
				Action_EOB_Page.clickOnDeleteGroupExceptions();
				Action_EOB_Page.Alert_Accept();
				Action_EOB_Page.Employergroup_DB();
				Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
				Action_EOB_Page.storeprocedure();
			} else {
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
			}
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.IdentifyEmployerGroupParametersinDB_employer();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.parameters.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.parameters.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.parameters.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.parameters.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.parameters.get("EOBIndicator"));
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.compareUIvalueswithDBvalues();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	// TC_EOB Group Exceptions_Create Exception_DuplicateRecord_EOB_N
			@Test(priority = 1)
			void TC_EOB_GroupExceptions_CreateException_DuplicateRecord_EOB_N()
					throws ClassNotFoundException, SQLException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent.createTest("TC_EOB Group Exceptions_CreateException_DuplicateRecord_EOB_N");

				// checking the execution flag in Mapa_Infobank
				if (Utils.getTestCasePreferenceFromInfobank("TC_EOB Group Exceptions_CreateException_DuplicateRecord_EOB_N")
						.equalsIgnoreCase("Y")) {
					initiateBrowser();
					XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
					Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
					Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
					Action_EOB_Page.InputParameters();
					Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
					Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
					Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
					Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
					Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
					Action_EOB_Page.clickOnSave();
					Action_EOB_Page.VerifySuccesfulllMessage_EOBGroupException();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
					Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
					Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
					Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
					Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
					Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
					Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
					Action_EOB_Page.select_ArabicCheckbox();
					Action_EOB_Page.select_HindiCheckbox();
					Action_EOB_Page.select_RussianCheckbox();
					Action_EOB_Page.clickOnSave();
					Action_EOB_Page.checkErrorMessage_DuplicateRecord_EOBGroupException();

				} else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
			}

	@Test(priority = 2)
	void TC_EOBGroupExceptions_CreateException_Cancel_EOB_N()
			throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_Cancel_EOB_N");
		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_Cancel_EOB_N")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.InputParameters();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnCancel();
			Action_EOB_Page.VerifyEOBPlanRuleListScreen();
			Action_EOB_Page.VerifyRecordsinDB();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	// TC_EOB Group Exceptions_Create Exception_Cancel_EOB_Y
	@Test(priority = 3)
	void TC_EOBGroupExceptions_CreateException_Cancel_EOB_Y()
			throws ClassNotFoundException, SQLException, InterruptedException {
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_Cancel_EOB_Y");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_Cancel_EOB_Y")
				.equalsIgnoreCase("Y")) {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
			initiateBrowser();
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.InputParameters();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnCancel();
			Action_EOB_Page.VerifyEOBPlanRuleListScreen();
			Action_EOB_Page.VerifyRecordsinDB();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	

	// TC_EOB Group Exceptions_Create Exception_DuplicateRecord_EOB_Y
	@Test(priority = 4)
	void TC_EOBGroupExceptions_CreateException_DuplicateRecord_EOB_Y()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_DuplicateRecord_EOB_Y");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_DuplicateRecord_EOB_Y")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.InputParameters();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.VerifySuccesfulllMessage_EOBGroupException();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Inputvalues.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Inputvalues.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Inputvalues.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.Inputvalues.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrorMessage_DuplicateRecord_EOBGroupException();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	// TC_EOBGroupExceptions_CreateException_GroupEffectiveDate

	@Test(priority = 5)
	void TC_EOBGroupExceptions_CreateException_GroupEffectiveDate()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_GroupEffectiveDate");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_GroupEffectiveDate")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(1).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupEffectiveDate(inSheet.getRow(1).getCell(2).getStringCellValue());

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(2).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupEffectiveDate(inSheet.getRow(2).getCell(2).getStringCellValue());

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(3).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupEffectiveDate(inSheet.getRow(3).getCell(2).getStringCellValue());

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(4).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_Datewithnoslashes_GroupEffectiveDate();

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(5).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupEffectiveDate(inSheet.getRow(5).getCell(2).getStringCellValue());

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(6).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupNumberisrequired();
			Action_EOB_Page.checkErrormessage_MastergroupNumberisrequired();

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(7).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupNumberisrequired();
			Action_EOB_Page.checkErrormessage_MastergroupNumberisrequired();

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(8).getCell(2).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupNumberisrequired();
			Action_EOB_Page.checkErrormessage_MastergroupNumberisrequired();

			Action_EOB_Page.Clear_Groupeffectivedate_Textfield();
			Action_EOB_Page.EnterGroupEffectiveDate(inSheet.getRow(9).getCell(2).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_GroupNumberisrequired();
			Action_EOB_Page.checkErrormessage_MastergroupNumberisrequired();
		}
	}

	// TC_EOB Group Exceptions_Create Exception_GroupNumber
	@Test(priority = 6)
	void TC_EOBGroupExceptions_CreateException_GroupNumber() throws ClassNotFoundException, SQLException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_GroupNumber");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_GroupNumber")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
			Action_EOB_Page.EnterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Action_EOB_Page.Clear_Groupnumber_Textfield();
			Action_EOB_Page.EnterGroupNumber(inSheet.getRow(2).getCell(1).getStringCellValue());
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.checkErrormessage_MastergroupNumberisrequired();
			Action_EOB_Page.checkErrormessage_GroupEffectivedateisrequired();
		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	// TC_EOBGroupExceptions_CreateException_InMAPS_Individual_EOB_YES_MultipleLanguages
		@Test(priority = 7)
		void TC_EOBGroupExceptions_CreateException_InMAPS_Individual_EOB_YES_MultipleLanguages()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {
			// starting extent HTML report
			Constants.test = Constants.extent
					.createTest("TC_EOBGroupExceptions_CreateException_InMAPS_Individual_EOB_YES_MultipleLanguages");

			// checking the execution flag in Mapa_Infobank
			if (Utils
					.getTestCasePreferenceFromInfobank(
							"TC_EOBGroupExceptions_CreateException_InMAPS_Individual_EOB_YES_MultipleLanguages")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
						"Individual_Groups");
				if (Action_EOB_Page.VerfiyingIndivualGroupgroup_DB() == true) {
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnDeleteGroupExceptions();
					Action_EOB_Page.Alert_Accept();
					Action_EOB_Page.VerfiyingIndivualGroupgroup_DB();
					Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
					Action_EOB_Page.storeprocedure();
				} else {
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
				}
				Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.IdentifyIndivualGroupParametersinDB();
				Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.indiviualparameters.get("MasterGroupNumber"));
				Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.indiviualparameters.get("GroupNumber"));
				System.out.println(Action_EOB_Page.indiviualparameters.get("EffectiveDate"));
				Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.indiviualparameters.get("EffectiveDate"));
				Action_EOB_Page.selectSiteName(Action_EOB_Page.indiviualparameters.get("SiteName"));
				Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
				Action_EOB_Page.select_ArabicCheckbox();
				Action_EOB_Page.select_HindiCheckbox();
				Action_EOB_Page.select_RussianCheckbox();
				Action_EOB_Page.clickOnSave();
				Action_EOB_Page.CompareIndivualGroupParametersinDB();
				Action_EOB_Page.storeprocedure();
				Action_EOB_Page.CompareIndivualGroupParametersinDB_afterstoreprocedure();

			}

			else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}
		@Test(priority = 9)
		void TC_EGroupExceptions_CreateException_InMAPS_IogicallyDeleted_EOB_YES_AlternateLanguages()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {
			// starting extent HTML report
			Constants.test = Constants.extent
					.createTest("TC_EGroupExceptions_Creat eException_InMAPS_IogicallyDeleted_EOB_YES_AlternateLanguages");

			// checking the execution flag in Mapa_Infobank
			if (Utils
					.getTestCasePreferenceFromInfobank(
							"TC_EGroupExceptions_CreateException_InMAPS_IogicallyDeleted_EOB_YES_AlternateLanguages")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
						"Logicaldelete_Group");
				if (Action_EOB_Page.VerfiyingLogicaldeletegroup_DB() == true) {

					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnDeleteGroupExceptions();
					Action_EOB_Page.Alert_Accept();
					Action_EOB_Page.VerfiyingLogicaldeletegroup_DB();
					Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
					Action_EOB_Page.storeprocedure();
				} else {
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
				}
				Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.IdentifylogicaldeletegroupGroupParametersinDB();
				Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.logicaldeleteGroup.get("MasterGroupNumber"));
				Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.logicaldeleteGroup.get("GroupNumber"));
				System.out.println(Action_EOB_Page.logicaldeleteGroup.get("EffectiveDate"));
				Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.logicaldeleteGroup.get("EffectiveDate"));
				Action_EOB_Page.selectSiteName(Action_EOB_Page.logicaldeleteGroup.get("SiteName"));
				Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
				Action_EOB_Page.select_ArabicCheckbox();
				Action_EOB_Page.select_ChineseMandarin_checkbox();
				Action_EOB_Page.select_French_checkbox();
				Action_EOB_Page.select_HindiCheckbox();
				Action_EOB_Page.select_Korean_checkbox();
				Action_EOB_Page.select_PolishCheckbox();
				Action_EOB_Page.select_SpanishCheckbox();
				Action_EOB_Page.clickOnSave();
				Action_EOB_Page.ComparelogicaldeleteGroupParametersinDB();
				Action_EOB_Page.storeprocedure();
				Action_EOB_Page.ComparelogicaldeletegroupinDB_afterstoreprocedure();

			}

			else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}
		
		@Test(priority = 10)
		void TC_EOBGroupExceptions_CreateException_InMAPS_Managed_EOB_NO()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {
			// starting extent HTML report
			Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_InMAPS_Managed_EOB_NO");

			// checking the execution flag in Mapa_Infobank
			if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_InMAPS_Managed_EOB_NO")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
				if (Action_EOB_Page.Managedgroup_DB() == true) {
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnDeleteGroupExceptions();
					Action_EOB_Page.Alert_Accept();
					Action_EOB_Page.Managedgroup_DB();
					Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
					Action_EOB_Page.storeprocedure();
				} else {
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
				}
				Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.Identify_ManagedGroup_Parameters_inDB();
				Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.ManagedGroup.get("MasterGroupNumber"));
				Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.ManagedGroup.get("GroupNumber"));
				System.out.println(Action_EOB_Page.ManagedGroup.get("EffectiveDate"));
				Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.ManagedGroup.get("EffectiveDate"));
				Action_EOB_Page.selectSiteName(Action_EOB_Page.ManagedGroup.get("SiteName"));
				Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Action_EOB_Page.clickOnSave();
				Action_EOB_Page.compareMangedgroupexcelvalueswithDBvalues();
				Action_EOB_Page.compareMangedgrouplanguageswithDBlanguages();
				Action_EOB_Page.storeprocedure();
				Action_EOB_Page.CompareManagedGroupParametersinDB_afterstoreprocedure();

			}

			else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}	
		
		@Test(priority =11)
		void TC_EOBGroupExceptions_CreateException_Languages()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {
			// starting extent HTML report
			Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_Languages");

			// checking the execution flag in Mapa_Infobank
			if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_Languages")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
				Action_EOB_Page.compareEoblanguageswithDBlanguages_EOBGroupException();

			}

			else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}
		// TC_EOBGroupExceptions_CreateException_MasterGroupNumber
		@Test(priority = 12)
		void TC_EOBGroupExceptions_CreateException_MasterGroupNumber() throws ClassNotFoundException, SQLException {
			// starting extent HTML report
			Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_MasterGroupNumber");

			// checking the execution flag in Mapa_Infobank
			if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_MasterGroupNumber")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
				Action_EOB_Page.EnterMasterGroupNumber(inSheet.getRow(1).getCell(4).getStringCellValue());
				Action_EOB_Page.Clear_Mastergroupnumber_Textfield();
				Action_EOB_Page.EnterMasterGroupNumber(inSheet.getRow(2).getCell(4).getStringCellValue());
				Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Action_EOB_Page.clickOnSave();
				Action_EOB_Page.checkErrormessage_GroupNumberisrequired();
				Action_EOB_Page.checkErrormessage_GroupEffectivedateisrequired();
			} else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}

		// TC_EOBGroupExceptions_CreateException_NotInMAPS_EOB_YES_ALLLanguages
				@Test(priority = 13)
				void TC_EOBGroupExceptions_CreateException_NotInMAPS_EOB_YES_ALLLanguages()
						throws ClassNotFoundException, SQLException, IOException, InterruptedException {
					// starting extent HTML report
					Constants.test = Constants.extent
							.createTest("TC_EOBGroupExceptions_CreateException_NotInMAPS_EOB_YES_ALLLanguages");

					// checking the execution flag in Mapa_Infobank
					if (Utils.getTestCasePreferenceFromInfobank(
							"TC_EOBGroupExceptions_CreateException_NotInMAPS_EOB_YES_ALLLanguages").equalsIgnoreCase("Y")) {
						initiateBrowser();
						// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
						XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
								"All_languages_group");
						if (Action_EOB_Page.VerfiyingAllLanguagesgroup_DB() == true) {

							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
							Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.clickOnSearch_button();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
							Action_EOB_Page.clickOnDeleteGroupExceptions();
							Action_EOB_Page.Alert_Accept();
							Action_EOB_Page.VerfiyingAllLanguagesgroup_DB();
							Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
							Action_EOB_Page.storeprocedure();
						} else {
							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
						}
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyAlllanguagesGroupParametersinDB_EmployerGroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.Alllanguages.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.Alllanguages.get("GroupNumber"));
						System.out.println(Action_EOB_Page.Alllanguages.get("EffectiveDate"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.Alllanguages.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.Alllanguages.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_ChineseCantonese_checkbox();
						Action_EOB_Page.select_ChineseMandarin_checkbox();
						Action_EOB_Page.select_Creole_checkbox();
						Action_EOB_Page.select_French_checkbox();
						Action_EOB_Page.select_HawaiianPidgin_checkbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_Italian_checkbox();
						Action_EOB_Page.select_Korean_checkbox();
						Action_EOB_Page.select_PhilippineCheckbox();
						Action_EOB_Page.select_PolishCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
						Action_EOB_Page.select_SpanishCheckbox();
						Action_EOB_Page.select_VietnameseCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.CompareAlllanguagesGroupParametersinDB();

					}

					else

					{
						Constants.test.log(Status.SKIP, "Test Case has been skipped");
						throw new SkipException("Skipping this test case");
					}
				}

				@Test(priority = 14)
				void TC_EOBGroupExceptions_CreateException_SiteName_dropdown()
						throws ClassNotFoundException, SQLException, IOException, InterruptedException {
					// starting extent HTML report
					Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_SiteName_dropdown");

					// checking the execution flag in Mapa_Infobank
					if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_SiteName_dropdown")
							.equalsIgnoreCase("Y")) {
						initiateBrowser();
						XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
						Action_EOB_Page.compareSiteNamedropdownvalueswithDBvalues_EOBGroupException();
					}

					else

					{
						Constants.test.log(Status.SKIP, "Test Case has been skipped");
						throw new SkipException("Skipping this test case");
					}
				}
				// TC_EOBGroupExceptions_CreateException_UIValidation
				@Test(priority = 15)
				void TC_EOBGroupExceptions_CreateException_UIValidation() throws ClassNotFoundException, SQLException {
					// starting extent HTML report
					Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_CreateException_UIValidation");

					// checking the execution flag in Mapa_Infobank
					if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_CreateException_UIValidation")
							.equalsIgnoreCase("Y")) {
						initiateBrowser();
						XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Action_EOB_Page.VerifyCreateNewEOBGroupExceptionScreen();
						Action_EOB_Page.verifyMastergroupnumberinEobgroupException();
						Action_EOB_Page.verifygroupnumberinEobgroupException();
						Action_EOB_Page.verifygroupEffectivedateinEobgroupException();
						Action_EOB_Page.verifySiteNameinEobgroupException();
						Action_EOB_Page.verifyEOBIndicatorinEobgroupException();
						Action_EOB_Page.verifySaveButtonEobgroupException();
						Action_EOB_Page.verifyCancelButtonEobgroupException();

					} else

					{
						Constants.test.log(Status.SKIP, "Test Case has been skipped");
						throw new SkipException("Skipping this test case");
					}
				}
				
				

				//TC_EOBGroupExceptions_GroupExceptiontiedtoaPlanRule
				@Test(priority = 16)
				void TC_EOBGroupExceptions_GroupExceptiontiedtoaPlanRule()
						throws ClassNotFoundException, SQLException, IOException, InterruptedException {
					// starting extent HTML report
					Constants.test = Constants.extent
							.createTest("TC_EOBGroupExceptions_GroupExceptiontiedtoaPlanRule");

					// checking the execution flag in Mapa_Infobank
					if (Utils.getTestCasePreferenceFromInfobank(
							"TC_EOBGroupExceptions_GroupExceptiontiedtoaPlanRule").equalsIgnoreCase("Y")) {
						initiateBrowser();
						XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
						if (Action_EOB_Page.DB_planruleRecord_Employergroup() == true) {
							
							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
							Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
							Utils.waitForPageToLoad(driver);
						    Action_EOB_Page.clickOnSearch_button();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(5).getCell(1).getStringCellValue());
							Action_EOB_Page.clickOnDeleteGroupExceptions();
							Action_EOB_Page.Alert_Accept();
							Action_EOB_Page.storeprocedure();
						
						} else {
							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
							
						}
						    Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						    Utils.waitForPageToLoad(driver);
						    Action_EOB_Page.IdentifyparametersinDB_individualGroup();
						    Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individualvalues_DB.get("MasterGroupNumber"));
						    Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individualvalues_DB.get("GroupNumber"));
						    Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individualvalues_DB.get("EffectiveDate"));
						    Action_EOB_Page.selectSiteName(Action_EOB_Page.individualvalues_DB.get("SiteName"));
						    Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.individualvalues_DB.get("IsEOB"));
				     	    Action_EOB_Page.clickOnSave();
					     	Action_EOB_Page.CompareIndivualGroupParameters_inDB();
					     	Action_EOB_Page.storeprocedure();
					        Action_EOB_Page.verifyiseobdbexcelvalues_withdbvalues();
					        Action_EOB_Page.verifyGroupEOBLanguageTypevaluesintable();
					        Action_EOB_Page.storeprocedure();
					     	Action_EOB_Page.Verifystatus_EOBPlanRuleException_inDB();
					     
					     	
					          	
						}
						
					else

					{
						Constants.test.log(Status.SKIP, "Test Case has been skipped");
						throw new SkipException("Skipping this test case");
					}
				}	

				// TC_EOBGroupExceptions_Groupswithdifferenteffectivedate
				@Test(priority =17)
				void TC_EOBGroupExceptions_Groupswithdifferenteffectivedate()
						throws ClassNotFoundException, SQLException, IOException, InterruptedException {
					// starting extent HTML report
					Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_Groupswithdifferenteffectivedate");

					// checking the execution flag in Mapa_Infobank
					if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_Groupswithdifferenteffectivedate")
							.equalsIgnoreCase("Y")) {
						initiateBrowser();
						// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
						XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
								"differenteffectivedate");
						if (Action_EOB_Page.Verifydifferenteffectivedate() == true) {

							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
							Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.clickOnSearch_button();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue());
							Action_EOB_Page.clickOnDeleteGroupExceptions();
							Action_EOB_Page.Alert_Accept();
							Action_EOB_Page.Verifydifferenteffectivedate();
							Action_EOB_Page.Verifymessage_GroupException_weresuccessfullydeleted();
							Action_EOB_Page.storeprocedure();
						} else {
							Action_EOB_Page.clickOnMaterials();
							Action_EOB_Page.clickOnEOB_Link();
						}
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyDifferentEffectiveDateGroupParametersinDB_EmployerGroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.DifferentEffectivedate.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.DifferentEffectivedate.get("GroupNumber"));
						System.out.println(Action_EOB_Page.DifferentEffectivedate.get("EffectiveDate"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.DifferentEffectivedate.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.DifferentEffectivedate.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.DifferentEffectivedate.get("EOBIndicator"));
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_Italian_checkbox();
						Action_EOB_Page.select_Korean_checkbox();
						Action_EOB_Page.select_PhilippineCheckbox();
						Action_EOB_Page.select_PolishCheckbox();
						Action_EOB_Page.select_VietnameseCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.compareDifferentEffectiveDateGroupParametersinDBwithDBvalues();
						Action_EOB_Page.storeprocedure();
						Action_EOB_Page.compareDifferentEffectiveDateGroupParametersinDBwithDBvalues_afterstoreprocedure();

					}

					else

					{
						Constants.test.log(Status.SKIP, "Test Case has been skipped");
						throw new SkipException("Skipping this test case");
					}
				}



		// TC_EOB Group Exceptions_Search Screen_All Exceptions
		@Test(priority = 18)
		void TC_EOBGroupExceptions_SearchScreen_AllExceptions()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {
			// starting extent HTML report
			Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_SearchScreen_AllExceptions");

			// checking the execution flag in Mapa_Infobank
			if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_SearchScreen_AllExceptions")
					.equalsIgnoreCase("Y")) {
				initiateBrowser();
				XSSFSheet inSheet = Utils.excel_sheet(
						"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.clickOnSearch_button();
				Action_EOB_Page.compareSearchResultcountWithDBvaluescount_EOBGroupException();
				// Action_EOB_Page.verifyhighlightedrecord();

			}

			else

			{
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}




	
	// TC_EOB Group Exceptions_Search Screen_All Exceptions

	@Test(priority = 19)
	void TC_EOBGroupExceptions_SearchScreen_Clear_AllValues()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_SearchScreen_Clear_AllValues");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_SearchScreen_Clear_AllValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.EnterMasterGroupNumber(inSheet.getRow(2).getCell(4).getStringCellValue());
			Action_EOB_Page.EnterGroupNumber(inSheet.getRow(2).getCell(1).getStringCellValue());
			Action_EOB_Page
					.EOBGroupExceptiongroupeffectivedate_textfield(inSheet.getRow(2).getCell(15).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionSiteName_Dropdown(inSheet.getRow(2).getCell(3).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionsEOBIndicator_dropdown(inSheet.getRow(2).getCell(6).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionslanguages_dropdown(inSheet.getRow(2).getCell(12).getStringCellValue());
			Action_EOB_Page.clickOnSearch_button();
			Action_EOB_Page.Clear_button();
			Action_EOB_Page.VerifyEOBGroupExceptionGroupnumber_IsEmpty();
			Action_EOB_Page.VerifyEOBGroupExceptionMastergroupnumber_IsEmpty();
			Action_EOB_Page.VerifyEOBGroupExceptionGroupEffectiveDate_IsEmpty();
			Action_EOB_Page.VerifyEOBGroupExceptionSiteName_Dropdown_isempty();
			Action_EOB_Page.VerifyEOBGroupExceptionsEOBIndicator_dropdown_isempty();
			Action_EOB_Page.VerifyEOBGroupExceptionslanguages_dropdown_isempty();
			Action_EOB_Page.VerifyEOBGroupExceptionSearchgrid();
			Action_EOB_Page.refresh();
			Action_EOB_Page.VerifyEOBGroupExceptionSearchgrid_isempty();
		}

		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	// TC_EOB Group Exceptions_Search Screen_All Exceptions
	@Test(priority = 20)
	void TC_EOBGroupExceptions_SearchScreen_DataMapping()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_SearchScreen_DataMapping");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_SearchScreen_DataMapping")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
					"Individual_Groups");
			//Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			if (Action_EOB_Page.VerfiyingIndivualGroupgroup_DB() == true){
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
			
			}
			else{
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.IdentifyIndivualGroupParametersinDB();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.indiviualparameters.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.indiviualparameters.get("GroupNumber"));
			System.out.println(Action_EOB_Page.indiviualparameters.get("EffectiveDate"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.indiviualparameters.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.indiviualparameters.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			}
			Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.EnterMasterGroupNumber(inSheet.getRow(1).getCell(4).getStringCellValue());
			Action_EOB_Page.EnterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Action_EOB_Page
					.EOBGroupExceptiongroupeffectivedate_textfield(inSheet.getRow(1).getCell(11).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionSiteName_Dropdown(inSheet.getRow(1).getCell(3).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionsEOBIndicator_dropdown(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.EOBGroupExceptionslanguages_dropdown(inSheet.getRow(1).getCell(13).getStringCellValue());
			Action_EOB_Page.clickOnSearch_button();
			Thread.sleep(3000);
			Action_EOB_Page.comparesearchuiresultscountwithdbcount();
		   Action_EOB_Page.compareSearchResultWithDBvalues();

		}

		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}


	@Test(priority = 21)
	void TC_EOBGroupExceptions_SearchScreen_ListOrder()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_SearchScreen_AllExceptions");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_SearchScreen_AllExceptions")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.clickOnSearch_button();
			Action_EOB_Page.compareSearchResultcountWithDBvaluescount_EOBGroupException();
			Action_EOB_Page.verifyhighlightedrecord();

		}

		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	@Test(priority = 22)
	void TC_EOBGroupExceptions_SearchScreen_UIValidation() throws ClassNotFoundException, SQLException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOBGroupExceptions_SearchScreen_UIValidation");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOBGroupExceptions_SearchScreen_UIValidation")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			Action_EOB_Page.VerifyEOBPlanRuleListScreen();
			Action_EOB_Page.VerifyCreateNewEOBPlanRule_Button();
			Action_EOB_Page.VerifySearchEOBGroupExceptions_Button();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptions_Button();
			Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			Action_EOB_Page.VerifyEOBGroupExceptionsScreen();
			Action_EOB_Page.VerifyCreateNewEOBGroupExceptions_Button();
			Action_EOB_Page.verifyMasterGroupNumber_label();
			Action_EOB_Page.verifyGroupNumber_label();
			Action_EOB_Page.verifyGroupEffectiveDate_label();
			Action_EOB_Page.verifySiteName_label();
			Action_EOB_Page.verifyEOBIndicator_label();
			Action_EOB_Page.verifyLanguage_label();
			Action_EOB_Page.clickOnSearch_button();
			Action_EOB_Page.verifyMasterGroupNumber_Result_grid();
			Action_EOB_Page.verifyGroupNumber__Result_grid();
			Action_EOB_Page.verifyGroupName__Result_grid();
			Action_EOB_Page.verifyGroupEffectiveDate_Result_grid();
			Action_EOB_Page.verifySiteName_Result_grid();
			Action_EOB_Page.verifyEOBIndicator_Result_grid();
			Action_EOB_Page.verifyLanguage_Result_grid();
			//Action_EOB_Page.HighlightedGroups();

		} else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	
	
		
		
	

	// TC_EOBGroupExceptions_Update_CancelbuttononPlanRuleExceptionupdatescreen
	@Test(priority = 23)
	void TC_EOBGroupExceptions_Update_CancelbuttononPlanRuleExceptionupdatescreen()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_EOBGroupExceptions_Update_CancelbuttononPlanRuleExceptionupdatescreen");
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		XSSFSheet managedSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
				
		// checking the execution flag in Mapa_Infobank
		if (Utils
				.getTestCasePreferenceFromInfobank(
						"TC_EOBGroupExceptions_Update_CancelbuttononPlanRuleExceptionupdatescreen")
				.equalsIgnoreCase("Y")) {
			     initiateBrowser();
              if (Action_EOB_Page.Employergroups_DB() == true) {
                  Action_EOB_Page.clickOnMaterials();
				  Action_EOB_Page.clickOnEOB_Link();
				} 
              else {
            Action_EOB_Page.clickOnMaterials();
		    Action_EOB_Page.clickOnEOB_Link();
            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.Identify_EmployerGroupParametersin_DB();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("EOBIndicator"));
			Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.storeprocedure();
             Action_EOB_Page.clickOnMaterials();
		    Action_EOB_Page.clickOnEOB_Link();
            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
            Action_EOB_Page.Identify_employergroupvalues_updated_DB();
            Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DB.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DB.get("GroupNumber"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupvalues_updated_DB.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupvalues_updated_DB.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupvalues_updated_DB.get("EOBIndicator"));
			Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.storeprocedure();
             Action_EOB_Page.clickOnMaterials();
			    Action_EOB_Page.clickOnEOB_Link();
	            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
            Action_EOB_Page.Identify_ManagedGroup_Parameters_inDB();
			Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.ManagedGroup.get("MasterGroupNumber"));
			Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.ManagedGroup.get("GroupNumber"));
			System.out.println(Action_EOB_Page.ManagedGroup.get("EffectiveDate"));
			Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.ManagedGroup.get("EffectiveDate"));
			Action_EOB_Page.selectSiteName(Action_EOB_Page.ManagedGroup.get("SiteName"));
			Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
            Action_EOB_Page.select_ArabicCheckbox();
			Action_EOB_Page.select_HindiCheckbox();
			Action_EOB_Page.select_RussianCheckbox();
			Action_EOB_Page.clickOnSave();
			Action_EOB_Page.storeprocedure();
             Action_EOB_Page.clickOnMaterials();
		    Action_EOB_Page.clickOnEOB_Link();

               }	
			Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.EOBGroupExceptionsEOBIndicator_dropdown(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.clickOnSearch_button();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.select_Multiplerecords_Checkbox(inSheet.getRow(16).getCell(1).getStringCellValue(),inSheet.getRow(17).getCell(1).getStringCellValue(),managedSheet.getRow(1).getCell(1).getStringCellValue());
			Action_EOB_Page.clickOnUpdatebutton();
			Utils.waitForPageToLoad(driver);
			Action_EOB_Page.EOBGroupExceptionsupdateEOBIndicator_dropdown(inSheet.getRow(1).getCell(6).getStringCellValue());
			Action_EOB_Page.verify_Multiplerecords_searchresults_withdbresults(inSheet.getRow(17).getCell(1).getStringCellValue(),inSheet.getRow(16).getCell(1).getStringCellValue(),managedSheet.getRow(1).getCell(1).getStringCellValue());
			Action_EOB_Page.storingupdatedrecords(managedSheet.getRow(1).getCell(1).getStringCellValue(),inSheet.getRow(17).getCell(1).getStringCellValue(),inSheet.getRow(16).getCell(1).getStringCellValue());
			Action_EOB_Page.clickOnCancel_button();
			Action_EOB_Page.VerifyEOBGroupExceptionsScreen();
			Action_EOB_Page.comparingupdatedresultswithdbresults();
			
			}
		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
		
			
		}

	
	
			
//TC_EOBGroupExceptions_Update_ExceptedEOBFlag&Language_Withoutplanrule_Massupdate
			
			@Test(priority = 24)
			void TC_EOBGroupExceptions_Update_ExceptedEOBFlagLanguage_Withoutplanrule_Massupdate()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Update_ExceptedEOBFlagLanguage_Withoutplanrule_Massupdate");
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
				
						
				// checking the execution flag in Mapa_Infobank
				if (Utils
						.getTestCasePreferenceFromInfobank(
								"TC_EOBGroupExceptions_Update_CancelbuttononPlanRuleExceptionupdatescreen")
						.equalsIgnoreCase("Y")) {
					     initiateBrowser();
		              if (Action_EOB_Page.Employergroups_update_DB() == true) {
		                     Action_EOB_Page.clickOnMaterials();
						     Action_EOB_Page.clickOnEOB_Link();
						     Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.clickOnSearch_button();
							Utils.waitForPageToLoad(driver);
							Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(16).getCell(1).getStringCellValue(),inSheet.getRow(17).getCell(1).getStringCellValue());
							Action_EOB_Page.clickOnDeleteGroupExceptions();
							Action_EOB_Page.Alert_Accept();
							Action_EOB_Page.storeprocedure();
							Thread.sleep(3000);
		
						} 
		              else {
		           
		            	  Action_EOB_Page.clickOnMaterials();
						    Action_EOB_Page.clickOnEOB_Link();
		               }
		             
			            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
			            Action_EOB_Page.Identify_EmployerGroupParametersin_DB();
			        	Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("GroupNumber"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupvalues_updated_DBvalue.get("EOBIndicator"));
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.storeprocedure();
		                 Action_EOB_Page.clickOnMaterials();
					    Action_EOB_Page.clickOnEOB_Link();
			            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.Identify_employergroupvalues_updated_DB();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DB.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupvalues_updated_DB.get("GroupNumber"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupvalues_updated_DB.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupvalues_updated_DB.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupvalues_updated_DB.get("EOBIndicator"));
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.storeprocedure();
			          
		      		Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link(); 
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.EOBGroupExceptionsEOBIndicator_dropdown(inSheet.getRow(1).getCell(6).getStringCellValue());
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_Multiplerecordscheckbox(inSheet.getRow(16).getCell(1).getStringCellValue(),inSheet.getRow(17).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnUpdatebutton();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.EOBGroupExceptionsupdateEOBIndicator_dropdown(inSheet.getRow(16).getCell(0).getStringCellValue());
					Action_EOB_Page.verifylanguagesinupdatedscreen();
					Action_EOB_Page.verify_Multiplerecords_searchresults_withupdatedscreenresultsresults(inSheet.getRow(16).getCell(1).getStringCellValue(),inSheet.getRow(17).getCell(1).getStringCellValue());
				    Action_EOB_Page.clickOnUpdate_button();
				    Action_EOB_Page.compareupdatedstatusdbvalueswithexcelvalues();
				    Action_EOB_Page.compareiseobdbvalueswithexcelvalues();
				    Action_EOB_Page.Verifyupdatedgroupsin_EOBPlanRuleExceptionlanguagetype();
				    Action_EOB_Page.storeprocedure();
				    Action_EOB_Page.verifygroupiseobdbexcelvaluewithdbvalue();
				    Action_EOB_Page.Verifyupdatedgroupsin_GroupEOBLanguageTypetableindb();
				   
				  
			
					
					}
				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
				
					
				}

			
			@Test(priority = 25)
			void TC_EOBGroupExceptions_Delete_ExceptionGroup_TiedtoPlanRule()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Delete_ExceptionGroup_TiedtoPlanRule");
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
						
				// checking the execution flag in Mapa_Infobank
				if (Utils
						.getTestCasePreferenceFromInfobank(
								"TC_EOBGroupExceptions_Delete_ExceptionGroup_TiedtoPlanRule")
						.equalsIgnoreCase("Y")) {
					     initiateBrowser();
		             if (Action_EOB_Page.verify_Individual_Groups_inDB() == true) {
		                  Action_EOB_Page.clickOnMaterials();
						  Action_EOB_Page.clickOnEOB_Link();
						} 
		              else {
		            	  Action_EOB_Page.clickOnMaterials();
						  Action_EOB_Page.clickOnEOB_Link();
		            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.IdentifyindividualgroupParametersinDB();
				Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individualgroupparameters_DB.get("MasterGroupNumber"));
				Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individualgroupparameters_DB.get("GroupNumber"));
				Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individualgroupparameters_DB.get("EffectiveDate"));
				Action_EOB_Page.selectSiteName(Action_EOB_Page.individualgroupparameters_DB.get("SiteName"));
				Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.individualgroupparameters_DB.get("EOBIndicator"));
				Action_EOB_Page.select_ArabicCheckbox();
				Action_EOB_Page.select_HindiCheckbox();
				Action_EOB_Page.select_RussianCheckbox();
				Action_EOB_Page.clickOnSave();
		               }	
		 
				Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
				Utils.waitForPageToLoad(driver);
			    Action_EOB_Page.clickOnSearch_button();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(3).getCell(1).getStringCellValue());
				Action_EOB_Page.clickOnDeleteGroupExceptions();
				Action_EOB_Page.Alert_Accept();
				Action_EOB_Page.Verifystatus_DB();
				Action_EOB_Page.Verifystatus_EOBPlanRuleExceptioninDB();
				Action_EOB_Page.VerifyDeletedgroupRecord_DB();
			    Action_EOB_Page.storeprocedure();
			    Action_EOB_Page.Verifystatus_DB();
			    Action_EOB_Page.verifylanguagesinEOBPlanRuleLanguageType();
			    Action_EOB_Page.VerifyDeletedgroupsin_auditEOBPlanRuleLanguage_indb();
			    Action_EOB_Page.VerifyEOBPlanRuleException_Record();
			    Action_EOB_Page.Verifyiseob_group_multiplegroups_indb();
			    Action_EOB_Page.Verifymultiplegroupsin_dboGroupEOBLanguageType_indb();
			    Action_EOB_Page.VerifyDeletedgroupsin_auditGroupEOBLanguageType_indb();
		
				
					
					}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
		
			}	
			//TC_EOBGroupExceptions_Delete_Exception_AllGroups_HavingLanguages
			@Test(priority = 26)
			void TC_EOBGroupExceptions_Delete_Exception_AllGroups_HavingLanguages()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Delete_Exception_AllGroups_HavingLanguages");

				// checking the execution flag in Mapa_Infobank
				if (Utils
						.getTestCasePreferenceFromInfobank(
								"TC_EOBGroupExceptions_Delete_Exception_AllGroups_HavingLanguages")
						.equalsIgnoreCase("Y")) {
					initiateBrowser();
					// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
					XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
							"Mastergroup");
					if (Action_EOB_Page.DB_Record_individual() == true) {
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
					} else {
						 Action_EOB_Page.clickOnMaterials();
						    Action_EOB_Page.clickOnEOB_Link();
				            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyIndivualGroupsParametersinDB();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individualgroup_DB.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individualgroup_DB.get("GroupNumber"));
						System.out.println(Action_EOB_Page.individualgroup_DB.get("EffectiveDate"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individualgroup_DB.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.individualgroup_DB.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.storeprocedure();
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyIndivualGroupParametersinDB_SameMastergroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individualgroupvalues.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individualgroupvalues.get("GroupNumber"));
						System.out.println(Action_EOB_Page.individualgroupvalues.get("EffectiveDate"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individualgroupvalues.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.individualgroupvalues.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(inSheet.getRow(1).getCell(6).getStringCellValue());
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
						Action_EOB_Page.clickOnSave();
						Action_EOB_Page.storeprocedure();
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						
					}
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.EnterMasterGroupNumber(inSheet.getRow(1).getCell(4).getStringCellValue());
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(1).getCell(1).getStringCellValue(),inSheet.getRow(2).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnDeleteGroupExceptions();
					Action_EOB_Page.Alert_Accept();
					Action_EOB_Page.comparedeletedrecordstatusin_withdbvalues();
					Action_EOB_Page.storeprocedure();
				   Action_EOB_Page.Verifrecordsaredeleted_samemastergroup();
				   Action_EOB_Page.compareactiontypeidinauditEOBPlanRuleException_db();
				    Action_EOB_Page.VerifyDeletedgroupsin_EOBPlanRuleExceptionLanguageTypetable_indb();
				    Action_EOB_Page.verifyiseobdbexcelvalueswithdbvalues();
				    Action_EOB_Page.VerifyDeletedgroupsin_auditGroupEOBLanguageTypetable_indb();
				}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
			}
			// TC_EOBGroupExceptions_SearchScreen_UI Validation
			@Test(priority = 27)
			void TC_EOBGroupExceptions_Delete_Exception_Cancel()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Delete_Exception_Cancel");

				// checking the execution flag in Mapa_Infobank
				if (Utils.getTestCasePreferenceFromInfobank(
						"TC_EOBGroupExceptions_Delete_Exception_Cancel").equalsIgnoreCase("Y")) {
					initiateBrowser();
					XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
					if (Action_EOB_Page.Employergroup_DB_update() == true) {
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.clickOnSearch_button();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(3).getCell(1).getStringCellValue());
						Action_EOB_Page.clickOnDeleteGroupExceptions();
						Action_EOB_Page.Alert_Dismiss();
						
					} else {
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyEmployerGroupParametersinDB_EmployerGroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.inputparameters.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.inputparameters.get("GroupNumber"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.inputparameters.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.inputparameters.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.inputparameters.get("EOBIndicator"));
						Action_EOB_Page.clickOnSave();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.clickOnSearch_button();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(3).getCell(1).getStringCellValue());
						Action_EOB_Page.clickOnDeleteGroupExceptions();
						Action_EOB_Page.Alert_Dismiss();
						Action_EOB_Page.CompareDelete_Exception_Cancel_withDbValus();
						
					}
					
				}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
			}
			@Test(priority = 28)
			void TC_EOBGroupExceptions_Delete_Exception_GroupNotInMAPS()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Delete_Exception_GroupNotInMAPS");
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
				XSSFSheet managedSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
						
				// checking the execution flag in Mapa_Infobank
				if (Utils
						.getTestCasePreferenceFromInfobank(
								"TC_EOBGroupExceptions_Delete_Exception_GroupNotInMAPS")
						.equalsIgnoreCase("Y")) {
					     initiateBrowser();
		             if (Action_EOB_Page.verify_Employergroup_inDB() == true) {
		                  Action_EOB_Page.clickOnMaterials();
						  Action_EOB_Page.clickOnEOB_Link();
						} 
		              else {
		            	   Action_EOB_Page.clickOnMaterials();
							  Action_EOB_Page.clickOnEOB_Link();
		            Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.Identify_EmployerGroupParametersinDB();
				Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.parametervalues.get("MasterGroupNumber"));
				Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.parametervalues.get("GroupNumber"));
				Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.parametervalues.get("EffectiveDate"));
				Action_EOB_Page.selectSiteName(Action_EOB_Page.parametervalues.get("SiteName"));
				Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.parametervalues.get("EOBIndicator"));
				Action_EOB_Page.select_ArabicCheckbox();
				Action_EOB_Page.select_HindiCheckbox();
				Action_EOB_Page.select_RussianCheckbox();
				Action_EOB_Page.clickOnSave();
				Thread.sleep(3000);
		               }	
		 
			Action_EOB_Page.clickOnMaterials();
				Action_EOB_Page.clickOnEOB_Link();
				Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.clickOnSearch_button();
				Utils.waitForPageToLoad(driver);
				Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(5).getCell(1).getStringCellValue());
				Action_EOB_Page.clickOnDeleteGroupExceptions();
				Action_EOB_Page.Alert_Accept();
			Action_EOB_Page.Verifystatus_EOBPlanRuleExceptionDB_employergroup();
				Action_EOB_Page.storeprocedure();
				Action_EOB_Page.VerifyDeletedgroup_Record();
				Action_EOB_Page.ComparingDeteletedgroupparameters_inauditEOBPlanRuleException();
				Action_EOB_Page.CompareauditEOBPlanRuleExceptionLanguageinDB();
				Action_EOB_Page.verifynorecordGrouptable();
			
		
				
					
					}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
		
			}	
			//TC_EOBGroupExceptions_Delete_Exception_MultipleGroups_NoLanguages

			@Test(priority = 29)
			void TC_EOBGroupExceptions_Delete_Exception_MultipleGroups_NoLanguages()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Delete_Exception_MultipleGroups_NoLanguages");

				// checking the execution flag in Mapa_Infobank
				if (Utils.getTestCasePreferenceFromInfobank(
						"TC_EOBGroupExceptions_Delete_Exception_MultipleGroups_NoLanguages").equalsIgnoreCase("Y")) {
					initiateBrowser();
					XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
					if (Action_EOB_Page.DB_Record_Employergroup() == true) {
						
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
					} else {
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.Identify_parametersinDB_EmployerGroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupparameters.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupparameters.get("GroupNumber"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupparameters.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupparameters.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupparameters.get("EOBIndicator"));
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
				     	Action_EOB_Page.clickOnSave();
				     	Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
						Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.IdentifyinDB_EmployerGroup();
						Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.employergroupvalues.get("MasterGroupNumber"));
						Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.employergroupvalues.get("GroupNumber"));
						Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.employergroupvalues.get("EffectiveDate"));
						Action_EOB_Page.selectSiteName(Action_EOB_Page.employergroupvalues.get("SiteName"));
						Action_EOB_Page.selectEOBIndicator(Action_EOB_Page.employergroupvalues.get("EOBIndicator"));
						Action_EOB_Page.select_ArabicCheckbox();
						Action_EOB_Page.select_HindiCheckbox();
						Action_EOB_Page.select_RussianCheckbox();
				     	Action_EOB_Page.clickOnSave();
				    	Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
					}
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_Multiplerecords_Checkbox(inSheet.getRow(6).getCell(1).getStringCellValue(),inSheet.getRow(9).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnDeleteGroupExceptions();
					Action_EOB_Page.Alert_Accept();
					Action_EOB_Page.comparedeletedrecordstatusindbvalues();
					Action_EOB_Page.storeprocedure();
					Action_EOB_Page.Verifrecordsaredeleted();
					Action_EOB_Page.compareactiontypeidinauditEOBPlanRuleExceptiondbvalues();
				    Action_EOB_Page.VerifyDeletedgroupsin_EOBPlanRuleExceptionLanguageTypetableindb();
				    Action_EOB_Page.VerifyDeletedgroupsin_GroupEOBLanguageTypetableindb();
				  //  Action_EOB_Page.verifyiseobdbexcelvaluewithdbvalue();
					
					 Action_EOB_Page.Compare_multiplerecord_Status_withDbValus();
					
				}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
			}

			
			@Test(priority = 30)
			void TC_EOBGroupExceptions_Update_ExceptedEOBFlagLanguage_Withplanrule()
					throws ClassNotFoundException, SQLException, IOException, InterruptedException {
				// starting extent HTML report
				Constants.test = Constants.extent
						.createTest("TC_EOBGroupExceptions_Update_ExceptedEOBFlagLanguage_Withplanrule");

				// checking the execution flag in Mapa_Infobank
				if (Utils
						.getTestCasePreferenceFromInfobank(
								"TC_EOBGroupExceptions_Update_ExceptedEOBFlagLanguage_Withplanrule")
						.equalsIgnoreCase("Y")) {
					initiateBrowser();
					// Action_EOB_Page.IdentifyRequiredParameters_EmployerGroup();
					XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
							"Individual_Groups");
				
					if (Action_EOB_Page.Verfiying_Indivual_Groupgroup_DB() == true) {
						Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.clickOnSearch_button();
						Utils.waitForPageToLoad(driver);
						Action_EOB_Page.select_DeleteRequiredrecord_Checkbox(inSheet.getRow(7).getCell(1).getStringCellValue(),inSheet.getRow(8).getCell(1).getStringCellValue());
						Action_EOB_Page.clickOnDeleteGroupExceptions();
						Action_EOB_Page.Alert_Accept();
						Action_EOB_Page.storeprocedure();
					} else {
						Action_EOB_Page.clickOnMaterials();
						Action_EOB_Page.clickOnEOB_Link();
					}
					Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
					Utils.waitForPageToLoad(driver);
			
					Action_EOB_Page.Identify_individualgroupvalues_DBvalues();
					Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individualgroupvaluesDBvalues.get("MasterGroupNumber"));
					Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individualgroupvaluesDBvalues.get("GroupNumber"));
					System.out.println(Action_EOB_Page.individualgroupvaluesDBvalues.get("EffectiveDate"));
					Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individualgroupvaluesDBvalues.get("EffectiveDate"));
					Action_EOB_Page.selectSiteName(Action_EOB_Page.individualgroupvaluesDBvalues.get("SiteName"));
					Action_EOB_Page.selectEOBIndicator(inSheet.getRow(7).getCell(0).getStringCellValue());
					Action_EOB_Page.clickOnSave();
					Action_EOB_Page.storeprocedure();
					Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link();
					Action_EOB_Page.clickOnCreateNewEOBGroupException_Link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.Identify_individual_groups_DB_DBvalues();
					Action_EOB_Page.EnterMasterGroupNumber(Action_EOB_Page.individual_groups_DB.get("MasterGroupNumber"));
					Action_EOB_Page.EnterGroupNumber(Action_EOB_Page.individual_groups_DB.get("GroupNumber"));
					System.out.println(Action_EOB_Page.individual_groups_DB.get("EffectiveDate"));
					Action_EOB_Page.EnterGroupEffectiveDate(Action_EOB_Page.individual_groups_DB.get("EffectiveDate"));
					Action_EOB_Page.selectSiteName(Action_EOB_Page.individual_groups_DB.get("SiteName"));
					Action_EOB_Page.selectEOBIndicator(inSheet.getRow(8).getCell(0).getStringCellValue());
					Action_EOB_Page.clickOnSave();
					Action_EOB_Page.storeprocedure();
		      		Action_EOB_Page.clickOnMaterials();
					Action_EOB_Page.clickOnEOB_Link(); 
					Action_EOB_Page.clickOnSearchEOBGroupExceptions_link();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.EOBGroupExceptionsEOBIndicator_dropdown(inSheet.getRow(7).getCell(0).getStringCellValue());
					Action_EOB_Page.clickOnSearch_button();
					Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_Multiplerecordscheckbox(inSheet.getRow(7).getCell(1).getStringCellValue(),inSheet.getRow(8).getCell(1).getStringCellValue());
      				Action_EOB_Page.clickOnUpdatebutton();
     				Utils.waitForPageToLoad(driver);
					Action_EOB_Page.EOBGroupExceptionsupdateEOBIndicator_dropdown(inSheet.getRow(7).getCell(6).getStringCellValue());
				     Utils.waitForPageToLoad(driver);
					Action_EOB_Page.select_ArabicCheckbox();
					Action_EOB_Page.select_HindiCheckbox();
					Action_EOB_Page.select_RussianCheckbox();
					Action_EOB_Page.verify_Multiplerecords_searchresults_withupdatedscreenresultsresults(inSheet.getRow(7).getCell(1).getStringCellValue(),inSheet.getRow(8).getCell(1).getStringCellValue());
					Action_EOB_Page.clickOnUpdate_button();
					Action_EOB_Page.compareupdatediseobdbvalueswithexcelvalues();
					Action_EOB_Page.compareupdatedrecordstatusindbvalues();
					Action_EOB_Page.verifyinsertedrecordindb();
		         	Utils.waitForPageToLoad(driver);
		         	Action_EOB_Page.storeprocedure();
		         	Action_EOB_Page.verifyupdatediseobdbexcelvaluewithdbvalue();

                	Action_EOB_Page.verify_GroupEOBLanguageTypevaluesintable();
              	   Action_EOB_Page.Verify_status_EOBPlanRuleExceptioninDB();

				}

				else

				{
					Constants.test.log(Status.SKIP, "Test Case has been skipped");
					throw new SkipException("Skipping this test case");
				}
			}
			

}