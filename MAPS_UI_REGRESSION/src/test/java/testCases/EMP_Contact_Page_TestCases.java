package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_ContactPage;
import miscellaneous.BeforeAndAfter;
import pageObjects.Header;
import utilities.Constants;
import utilities.QueryBank;
import utilities.Utils;

public class EMP_Contact_Page_TestCases extends BeforeAndAfter {
	Workbook inWorkbook = null;

	@Test
	public void EMP_Contact_Search_Rule_List()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Search_Rule_List");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Search_Rule_List").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/EMP_Contact/EMP_Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("SearchContact");
		
			
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectRuleType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.clickOnSearchContactsButton();
			Thread.sleep(3000);
			
			//Verify Paging
			Actions_ContactPage.VerifyRecordsCount(inSheet.getRow(1).getCell(14).getStringCellValue());
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Cancel_Delete_Rule()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Cancel_Delete_Rule");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Cancel_Delete_Rule").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/EMP_Contact/EMP_Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("CancelDeleteRule");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectRuleType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.clickOnSearchContactsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnFirstEditCheckbox();
			Actions_ContactPage.clickOnDeleteContactButton();
			Thread.sleep(3000);
			Actions_ContactPage.Alert_Reject();
			Actions_ContactPage.VerifyContactRuleDataStatus(Constants.Input_SQLS.getRow(7).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "CancelDeleteRule",1);
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Contact_Update_No_Data()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Update_No_Data");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Update_No_Data").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("UpdateNoData");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.selectRuleType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.clickOnSearchContactsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnEditRuleLink();
			Thread.sleep(3000);
			//Clear all fields
			Actions_ContactPage.clearAddress1();
			Actions_ContactPage.clearAddress2();
			Actions_ContactPage.clearCity();
			Actions_ContactPage.clearEmail();
			Actions_ContactPage.clearFax();
			Actions_ContactPage.clearHoursOfOperation();
			Actions_ContactPage.clearPhone();
			Actions_ContactPage.clearTTY();
			Actions_ContactPage.clearWebsite();
			Actions_ContactPage.clearZip();
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveEditButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			
			//Set Spaces
			Actions_ContactPage.enterEditAddress1(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.enterEditAddress2(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.enterEditCity(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterEditZip(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterEditPhone(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.enterEditTTY(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.enterEditFax(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterEditEmail(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterEditWebsite(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.enterEditHours(inSheet.getRow(1).getCell(15).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveEditButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Delete_Rule()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Delete_Rule");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Delete_Rule").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("DeleteRule");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(4000);
			Actions_ContactPage.selectCreateRuleType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.selectPBPRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectRulePlanName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(2000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(5000);
			Actions_ContactPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.selectRuleType(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.clickOnSearchContactsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnFirstEditCheckbox();
			Actions_ContactPage.clickOnDeleteContactButton();
			Thread.sleep(3000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.clickOnSubmitRecordButton();
			Thread.sleep(5000);
			Actions_ContactPage.VerifyContactDeletedRuleDataStatus(Constants.Input_SQLS.getRow(7).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "DeleteRule",1);		
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Max_Characters_Rule()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Max_Characters_Rule");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Max_Characters_Rule").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("MaxCharacter");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(4000);
			Actions_ContactPage.selectCreateRuleType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.selectPBPRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(2000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterEditEmail(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.enterEditTTY(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterEditWebsite(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterEditHours(inSheet.getRow(1).getCell(14).getStringCellValue());
			Thread.sleep(1000);
			//Verify characters entered on all fields
			Actions_ContactPage.ValidateEditEmailCharLen(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.ValidateEditAddress1CharLen(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.ValidateEditAddress2CharLen(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.ValidateEditCityCharLen(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.ValidateEditZipCharLen(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.ValidateEditTTYCharLen(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.ValidateEditWebsiteCharLen(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.ValidateEditHoursCharLen(inSheet.getRow(1).getCell(14).getStringCellValue());	
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Error_Invalid_Inputs()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Error_Invalid_Inputs");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Error_Invalid_Inputs").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("InvalidInputs");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Thread.sleep(4000);
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.selectPBPRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectRulePlanName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			
			Actions_ContactPage.selectRulePlanName(inSheet.getRow(1).getCell(7).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Actions_ContactPage.VerifyStateError(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Contact_Create_Rule_State_Validation()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Create_Rule_State_Validation");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Create_Rule_State_Validation").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("StateValidation");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(7).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyStateError(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);	
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	@Test
	public void Contact_Create_Rule_City_Validation()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Create_Rule_City_Validation");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Create_Rule_City_Validation").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("CityValidation");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(7).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyStateError(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyStateError(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);	
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Create_Rule_Fax_Validation()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Create_Rule_Fax_Validation");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Create_Rule_Fax_Validation").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("FaxValidation");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(2000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(4).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyFaxError(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyFaxError(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);	
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyFaxError(inSheet.getRow(1).getCell(7).getStringCellValue());
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Create_Cancel_ContactRuleData()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Create_Cancel_ContactRuleData");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Create_Cancel_ContactRuleData").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("CancelRuleData");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyNoRecordsinDatabase(Constants.Input_SQLS.getRow(6).getCell(1).getStringCellValue(),
			"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "CancelRuleData",1);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectPBPRule(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchPlans();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.enterPhone(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterTTY(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(15).getStringCellValue());
			Actions_ContactPage.enterEmail(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.enterWebsite(inSheet.getRow(1).getCell(16).getStringCellValue());
			Actions_ContactPage.enterHours(inSheet.getRow(1).getCell(17).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnruleSaveButton();
			Thread.sleep(2000);
			Actions_ContactPage.Alert_Reject();
			Thread.sleep(2000);
			Actions_ContactPage.VerifyNoRecordsinDatabase(Constants.Input_SQLS.getRow(6).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "CancelRuleData",1);
			Actions_ContactPage.VerifyUserIsOnSamePage();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_WebApp_Parameters()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_WebApp_Parameters");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_WebApp_Parameters").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage.clickOnCreateRuleButton();
			Thread.sleep(2000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.selectAllContactType();
			Actions_ContactPage.compareContactTypeWithDatabase(Constants.Input_SQLS.getRow(8).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",0);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.compareContactContractWithDatabase(Constants.Input_SQLS.getRow(12).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactPBPWithDatabase(Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactPlanNameWithDatabase(Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactBrandWithDatabase(Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactBusinessWithDatabase(Constants.Input_SQLS.getRow(16).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);	
			Actions_ContactPage.selectAllContactType();
			Actions_ContactPage.compareContactTypeWithDatabase(Constants.Input_SQLS.getRow(8).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",1);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.compareContactContractWithDatabase(Constants.Input_SQLS.getRow(12).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactPBPWithDatabase(Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactPlanNameWithDatabase(Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactBrandWithDatabase(Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);
			Actions_ContactPage.compareContactBusinessWithDatabase(Constants.Input_SQLS.getRow(16).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",6);	
			Actions_ContactPage.selectAllContactType();
			Actions_ContactPage.compareContactTypeWithDatabase(Constants.Input_SQLS.getRow(8).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "WebAppParameters",2);
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_GroupException_SearchResults()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_GroupException_SearchResults");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_GroupException_SearchResults").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("SearchGroupException");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.clickOnSearchIndExceptionsButton();
			Thread.sleep(2000);
			Actions_ContactPage.enterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			//Compare DB results
			Actions_ContactPage.VerifyGroupSearchResults(Constants.Input_SQLS.getRow(9).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "SearchGroupException",1);
			Actions_ContactPage.enterGroupNumber(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			
			//Verify error message
			Actions_ContactPage.VerifyNoSearchRecords();			
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Create_GroupException()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Create_GroupException");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Create_GroupException").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("CreateGroupExceptions");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.clickOnSearchIndExceptionsButton();
			Thread.sleep(2000);
			Actions_ContactPage.enterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.enterMasterGroupNumber(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterEffectiveDate(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectSiteName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.selectContactTypeException(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnCheckAllCheckbox();
			Actions_ContactPage.clickOnDeleteExceptionButton();
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(2000);
			
			//Verify no record deleted from database
			Actions_ContactPage.VerifyNoRecordsinIndividualTable(Constants.Input_SQLS.getRow(9).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "SearchGroupException",1);
			Actions_ContactPage.clickOnCreateExceptionButton();
			Thread.sleep(6000);
			Actions_ContactPage.enterMasterGroupNumber(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterCreateGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.enterEffectiveDate(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectSiteName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.selectContactTypeException(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.selectExceptionsState(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.enterExceptionsZip(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterPhone(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterTTY(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(15).getStringCellValue());
			Actions_ContactPage.enterEmail(inSheet.getRow(1).getCell(16).getStringCellValue());
			Actions_ContactPage.enterExceptionsWebsite(inSheet.getRow(1).getCell(17).getStringCellValue());
			Actions_ContactPage.enterHours(inSheet.getRow(1).getCell(18).getStringCellValue());
			Actions_ContactPage.clickOnSaveExceptionButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			//Compare DB results
			Actions_ContactPage.VerifyGroupSearchResults(Constants.Input_SQLS.getRow(9).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "SearchGroupException",1);			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Update_GroupException()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Update_GroupException");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Update_GroupException").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("UpdateGroupExceptions");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.clickOnSearchIndExceptionsButton();
			Thread.sleep(2000);
			Actions_ContactPage.enterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.enterMasterGroupNumber(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterEffectiveDate(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectSiteName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.selectContactTypeException(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnCheckAllCheckbox();
			Actions_ContactPage.clickOnUpdateExceptionButton();
			Thread.sleep(2000);
			Actions_ContactPage.clickOnAddress1Checkbox();
			Actions_ContactPage.clickOnAddress2Checkbox();
			Actions_ContactPage.clickOnCityCheckbox();
			Actions_ContactPage.clickOnEmailCheckbox();
			Actions_ContactPage.clickOnFaxCheckbox();
			Actions_ContactPage.clickOnHoursCheckbox();
			Actions_ContactPage.clickOnPhoneCheckbox();
			Actions_ContactPage.clickOnWebsiteCheckbox();
			Actions_ContactPage.clickOnTTYCheckbox();
			Actions_ContactPage.clickOnStateCheckbox();
			Actions_ContactPage.clickOnZipCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(19).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(20).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(21).getStringCellValue());
			Actions_ContactPage.selectExceptionsState(inSheet.getRow(1).getCell(22).getStringCellValue());
			Actions_ContactPage.enterExceptionsZip(inSheet.getRow(1).getCell(23).getStringCellValue());
			Actions_ContactPage.enterPhone(inSheet.getRow(1).getCell(24).getStringCellValue());
			Actions_ContactPage.enterTTY(inSheet.getRow(1).getCell(25).getStringCellValue());
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(26).getStringCellValue());
			Actions_ContactPage.enterEmail(inSheet.getRow(1).getCell(27).getStringCellValue());
			Actions_ContactPage.enterExceptionsWebsite(inSheet.getRow(1).getCell(28).getStringCellValue());
			Actions_ContactPage.enterHours(inSheet.getRow(1).getCell(29).getStringCellValue());
			Actions_ContactPage.clickOnUpdateButton();
			Thread.sleep(3000);
			//Compare DB results
			Actions_ContactPage.VerifyExceptionUpdateResults(Constants.Input_SQLS.getRow(10).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "UpdateGroupExceptions",1);	
			
			//Reset values to default
			Thread.sleep(2000);
			Actions_ContactPage.enterGroupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.enterMasterGroupNumber(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage.enterEffectiveDate(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ContactPage.enterPBP(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectSiteName(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage.selectContactTypeException(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage.clickOnSearchGroupExceptionsButton();
			Thread.sleep(3000);
			Actions_ContactPage.clickOnCheckAllCheckbox();
			Actions_ContactPage.clickOnUpdateExceptionButton();
			Thread.sleep(2000);
			Actions_ContactPage.clickOnAddress1Checkbox();
			Actions_ContactPage.clickOnAddress2Checkbox();
			Actions_ContactPage.clickOnCityCheckbox();
			Actions_ContactPage.clickOnEmailCheckbox();
			Actions_ContactPage.clickOnFaxCheckbox();
			Actions_ContactPage.clickOnHoursCheckbox();
			Actions_ContactPage.clickOnPhoneCheckbox();
			Actions_ContactPage.clickOnWebsiteCheckbox();
			Actions_ContactPage.clickOnTTYCheckbox();
			Actions_ContactPage.clickOnStateCheckbox();
			Actions_ContactPage.clickOnZipCheckbox();
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage.selectExceptionsState(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage.enterExceptionsZip(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterPhone(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterTTY(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(15).getStringCellValue());
			Actions_ContactPage.enterEmail(inSheet.getRow(1).getCell(16).getStringCellValue());
			Actions_ContactPage.enterExceptionsWebsite(inSheet.getRow(1).getCell(17).getStringCellValue());
			Actions_ContactPage.enterHours(inSheet.getRow(1).getCell(18).getStringCellValue());
			Actions_ContactPage.clickOnUpdateButton();
			Thread.sleep(3000);
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	public void Contact_Mass_Update_Plan()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Contact_Mass_Update_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Contact_Mass_Update_Plan").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/Contact/Contact_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("MassUpdateContact");

			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(5000);
			Actions_ContactPage.clickOnMassUpdateButton();
			Thread.sleep(2000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.selectContractRule(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage.selectPBPRule(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchMassEdit();
			Thread.sleep(1000);
			Actions_ContactPage.clickOnDefaultPlanCheckbox();			
			Actions_ContactPage.clickOnMassddress1Checkbox();
			Actions_ContactPage.clickOnMassAddress2Checkbox();
			Actions_ContactPage.clickOnMassCityCheckbox();
			Actions_ContactPage.clickOnMassStateCheckbox();
			Actions_ContactPage.clickOnMassZipCheckbox();
			Actions_ContactPage.enterMassAddress1(inSheet.getRow(1).getCell(19).getStringCellValue());
			Actions_ContactPage.enterMassAddress2(inSheet.getRow(1).getCell(20).getStringCellValue());
			Actions_ContactPage.enterMassCity(inSheet.getRow(1).getCell(21).getStringCellValue());
			Actions_ContactPage.selectMassState(inSheet.getRow(1).getCell(22).getStringCellValue());
			Actions_ContactPage.enterMassZip(inSheet.getRow(1).getCell(23).getStringCellValue());
			Actions_ContactPage.clickOnUpdateButton();
			Thread.sleep(1000);
			Actions_ContactPage.Alert_Accept();
			Thread.sleep(3000);
			Actions_ContactPage.VerifyContactRuleDataStatusUpdate(Constants.Input_SQLS.getRow(7).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Contact/Contact_AllFields.xlsx", "MassUpdateContact",1);
			
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
}









