package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_ContactPage;
import actions.Actions_ContactPage_EG;
import ch.lambdaj.function.convert.ConstructorArgumentConverter;
import miscellaneous.BeforeAndAfter;
import pageObjects.ContactPage;
import pageObjects.ContactPage_EG;
import pageObjects.Header;
import utilities.Constants;
import utilities.Utils;

public class Contact_Page_EG_testCases extends BeforeAndAfter {
	Workbook inWorkbook = null;
public static String filepath =".\\src\\test\\java\\testData\\Contact\\Contact_EG.xlsx";
JobSubmission_TestCases  JubRun = new JobSubmission_TestCases();


	@Test
	// 1
	public void EG_Contact_WebApp_Parameters() throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EG_Contact_Web_App_Parameters");

		if (Utils.getTestCasePreferenceFromInfobank("TC_EG_Contact_Web_App_Parameters").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
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
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectallIncludeIndicator();
			Actions_ContactPage_EG.compareIncludeIndicatorWithDatabase(
					Constants.Input_SQLS.getRow(24).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 6);
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue()); // All

			Actions_ContactPage_EG.compareContactTypeWithDatabase(
					Constants.Input_SQLS.getRow(25).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 0, "G");

			Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.compareRuleTypeWithDatabase(
					Constants.Input_SQLS.getRow(26).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 1, 0, 3, 3);
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue()); // MAMAPDSSUP

			Actions_ContactPage_EG.compareContactTypeWithDatabase(
					Constants.Input_SQLS.getRow(25).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 1, "G");

			Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.compareRuleTypeWithDatabase(
					Constants.Input_SQLS.getRow(26).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 1, 1, 1, 3);
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(2).getStringCellValue()); // PDP

			Actions_ContactPage_EG.compareContactTypeWithDatabase(
					Constants.Input_SQLS.getRow(25).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 2, "G");

			Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.compareRuleTypeWithDatabase(
					Constants.Input_SQLS.getRow(26).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 1, 2, 3, 3);
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_ContactPage_EG
					.compareBrandWithDatabase(Constants.Input_SQLS.getRow(27).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.selectContractRule(inSheet.getRow(3).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.compareBusinessSegmentWithDatabase(
					Constants.Input_SQLS.getRow(28).getCell(1).getStringCellValue());

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 2
	public void TC_EG_Contact_CreateCancel() throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_EmployerGroupContact_Web_Create-Cancel_ContactRuleData_MaxSize");

		if (Utils.getTestCasePreferenceFromInfobank("TC_EmployerGroupContact_Web_Create-Cancel_ContactRuleData_MaxSize")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
			Sheet inSheetAdd = inWorkbook.getSheet("Address");
			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectPlanYear(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(17).getCell(4).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Thread.sleep(3000);
			// Actions_ContactPage_EG.enterContractNumber(inSheet.getRow(17).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Actions_ContactPage_EG.ResultNotfoungMessage();
			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(17).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectPlanNameRule(inSheet.getRow(17).getCell(2).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchPlans();
			Actions_ContactPage_EG.selectPlanCheckBox();
			Actions_ContactPage_EG.enterAddress1(inSheetAdd.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAdd.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAdd.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAdd.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAdd.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.enterPhone(inSheetAdd.getRow(1).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.enterTTY(inSheetAdd.getRow(1).getCell(11).getStringCellValue());
			Actions_ContactPage_EG.enterFax(inSheetAdd.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage_EG.enterEmail(inSheetAdd.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage_EG.enterWebSite(inSheetAdd.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage_EG.enterHours(inSheetAdd.getRow(1).getCell(15).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.Alert_Reject();
			Utils.click(Header.contact_link());
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Actions_ContactPage_EG.selectPlanYear(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(17).getCell(4).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			// Actions_ContactPage_EG.enterContractNumber(inSheet.getRow(17).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Thread.sleep(3000);
			Actions_ContactPage_EG.ResultNotfoungMessage();
			Actions_ContactPage_EG.compareContractNumWithDatabase_Notsaved(
					Constants.Input_SQLS.getRow(29).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 17, 1, 17, 3);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 3
	public void TC_EG_Contact_Error_Invalidinputcombination()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_EmployerGroupContact_Error_Insertwithnodata_AddressStateValidation");

		if (Utils
				.getTestCasePreferenceFromInfobank(
						"TC_EmployerGroupContact_Error_Insertwithnodata_AddressStateValidation")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
			Sheet inSheetAdd = inWorkbook.getSheet("Address");
			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectPlanYear(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(18).getCell(4).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(3).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.enterContractNumber(inSheet.getRow(21).getCell(1).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.enterPBPtext(inSheet.getRow(21).getCell(3).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectBrandType(inSheet.getRow(17).getCell(5).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Thread.sleep(3000);
			Actions_ContactPage_EG.ResultNotfoungMessage();
			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(3).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(2).getCell(5).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(21).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectPBPnum(inSheet.getRow(21).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.selectPlanNameRule(inSheet.getRow(21).getCell(2).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectBrandType(inSheet.getRow(17).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchPlans();
			Actions_ContactPage_EG.selectPlanCheckBox();
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();

			// --Error Validation Need to check actual message (Below Error is
			// to check for with out entering data in the fields)
			Actions_ContactPage_EG.Alert_textval();

			Actions_ContactPage_EG.enterAddress1(inSheetAdd.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAdd.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAdd.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAdd.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();

			// Error Message need to correct
			Actions_ContactPage_EG.errorMessage_stateBlank();

			// After saving the data
			Actions_ContactPage_EG.enterAddress1(inSheetAdd.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAdd.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAdd.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAdd.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAdd.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.compareContractNumWithDatabase_Saved(
					Constants.Input_SQLS.getRow(29).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 1, 3);

			Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(3).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.enterContractNumber(inSheet.getRow(21).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectBrandType(inSheet.getRow(17).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.ClicktoEditcontactnum_Grid(inSheet.getRow(21).getCell(1).getStringCellValue());
			// Saving with No data
			Actions_ContactPage_EG.enterAddress1("");
			Actions_ContactPage_EG.enterAddress2("");
			Actions_ContactPage_EG.enterCity("");
			Actions_ContactPage_EG.selectState("");
			Actions_ContactPage_EG.enterZipCode("");
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.Alert_Accept();

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 4
	public void TC_EG_Contact_Error_Fax_City_Zipcombination()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("TC_Employer_Contact_Web_Validation_City_FaxNumber_PhoneNumber_Zip");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Employer_Contact_Web_Validation_City_FaxNumber_PhoneNumber_Zip")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
			Sheet inSheetAdd = inWorkbook.getSheet("Address");
			// test steps
			// Checking
			Actions_ContactPage_EG.compareContractNumWithDatabase_Notsaved(
					Constants.Input_SQLS.getRow(29).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 25, 1, 25, 3);
			Utils.click(Header.contact_link());
			Thread.sleep(3000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(3000);
			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(25).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectPBPnum(inSheet.getRow(25).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchPlans();
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectPlanCheckBox();
			Actions_ContactPage_EG.enterAddress1(inSheetAdd.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAdd.getRow(1).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAdd.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAdd.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.Alert_Reject();
			// Actions_ContactPage_EG.errorMessage_CityBlank();
			Actions_ContactPage_EG.enterAddress2("");
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			// Actions_ContactPage_EG.errorMessage_CityBlank();
			Thread.sleep(2000);
			Actions_ContactPage_EG.enterAddress1("");
			Actions_ContactPage_EG.enterAddress2(inSheetAdd.getRow(1).getCell(6).getStringCellValue());
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			// Actions_ContactPage_EG.errorMessage_CityBlank();
			Actions_ContactPage_EG.enterAddress1(inSheetAdd.getRow(1).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAdd.getRow(1).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAdd.getRow(1).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode("");
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.errorMessage_ZipCode();
			Actions_ContactPage_EG.enterZipCode(inSheetAdd.getRow(1).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.enterFax(inSheetAdd.getRow(2).getCell(12).getStringCellValue());
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.errorMessage_FaxNum();
			Actions_ContactPage_EG.enterFax(inSheetAdd.getRow(3).getCell(12).getStringCellValue());
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.errorMessage_FaxNum();
			Actions_ContactPage_EG.enterFax(inSheetAdd.getRow(4).getCell(12).getStringCellValue());
			// Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.errorMessage_FaxNum();
			Actions_ContactPage_EG.enterFax(inSheetAdd.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage_EG.enterPhone(inSheetAdd.getRow(2).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.errorMessage_PhoneNum();
			Actions_ContactPage_EG.enterPhone(inSheetAdd.getRow(3).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.errorMessage_PhoneNum();
			Actions_ContactPage_EG.enterPhone(inSheetAdd.getRow(4).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.errorMessage_PhoneNum();

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 5
	public void TC_EG_Contact_Max_Size_Insert() throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EmployerGroupContact_Web_Validation_Max_Size_MassInsert_Edit");

		if (Utils.getTestCasePreferenceFromInfobank("TC_EmployerGroupContact_Web_Validation_Max_Size_MassInsert_Edit")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
			Sheet inSheetAddress = inWorkbook.getSheet("Address");
			// test steps
			// Checking
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());

			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectIncludeIndicator(inSheetAddress.getRow(9).getCell(0).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheetAddress.getRow(9).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.selectRuleType(inSheetAddress.getRow(9).getCell(2).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchPlans();
			Actions_ContactPage_EG.selectPlanCheckBox();
			String Contractnum = Actions_ContactPage_EG.storecheckedContractnum();
			Actions_ContactPage_EG.enterAddress1(inSheetAddress.getRow(9).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAddress.getRow(9).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAddress.getRow(9).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAddress.getRow(9).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAddress.getRow(9).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.enterPhone(inSheetAddress.getRow(9).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.enterTTY(inSheetAddress.getRow(9).getCell(11).getStringCellValue());
			Actions_ContactPage_EG.enterFax(inSheetAddress.getRow(9).getCell(12).getStringCellValue());
			Actions_ContactPage_EG.enterEmail(inSheetAddress.getRow(9).getCell(13).getStringCellValue());
			Actions_ContactPage_EG.enterWebSite(inSheetAddress.getRow(9).getCell(14).getStringCellValue());
			Actions_ContactPage_EG.enterHours(inSheetAddress.getRow(9).getCell(15).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.Alert_Reject();
			Actions_ContactPage_EG.errorMessages_MassAddress();
			// Saving the data correct data
			Actions_ContactPage_EG.enterAddress1(inSheetAddress.getRow(16).getCell(5).getStringCellValue());
			Actions_ContactPage_EG.enterAddress2(inSheetAddress.getRow(16).getCell(6).getStringCellValue());
			Actions_ContactPage_EG.enterCity(inSheetAddress.getRow(16).getCell(7).getStringCellValue());
			Actions_ContactPage_EG.selectState(inSheetAddress.getRow(16).getCell(8).getStringCellValue());
			Actions_ContactPage_EG.enterZipCode(inSheetAddress.getRow(16).getCell(9).getStringCellValue());
			Actions_ContactPage_EG.enterPhone(inSheetAddress.getRow(16).getCell(10).getStringCellValue());
			Actions_ContactPage_EG.enterTTY(inSheetAddress.getRow(16).getCell(11).getStringCellValue());
			Actions_ContactPage_EG.enterFax(inSheetAddress.getRow(16).getCell(12).getStringCellValue());
			Actions_ContactPage_EG.enterEmail(inSheetAddress.getRow(16).getCell(13).getStringCellValue());
			Actions_ContactPage_EG.enterWebSite(inSheetAddress.getRow(16).getCell(14).getStringCellValue());
			Actions_ContactPage_EG.enterHours(inSheetAddress.getRow(16).getCell(15).getStringCellValue());
			Actions_ContactPage_EG.clickOnCreateNewRuleButton();
			Actions_ContactPage_EG.Alert_Accept();
			Actions_ContactPage_EG.compareAddressWithDatabase(
					Constants.Input_SQLS.getRow(30).getCell(1).getStringCellValue(),
					filepath, "Address", Contractnum);
			Actions_ContactPage_EG.Page_Conformation();
			// validating in UI after saved
			// String Contractnum = "H5596";
			Actions_ContactPage_EG.selectContactType(inSheetAddress.getRow(9).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Actions_ContactPage_EG.ClicktoEditcontactnum_Grid(Contractnum);
			Actions_ContactPage_EG.KeyedAddressValidation_EditedPage(filepath,
					"Address");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 6
	public void TC_Contact_Web_Update_ContactRuleData()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Contact_Web_Update_ContactRuleData");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Contact_Web_Update_ContactRuleData").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}

			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
			Sheet inSheetAddress = inWorkbook.getSheet("Address");
			// test steps
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectContactType(inSheetAddress.getRow(9).getCell(1).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			String ContractNum = Actions_ContactPage_EG
					.ClicktoEditcontactnum_Grid(filepath, "Address");
			Thread.sleep(2000);
			Actions_ContactPage_EG.UpdatedAdddress_DBCheck(Constants.Input_SQLS.getRow(31).getCell(1).getStringCellValue(), ContractNum);
			Actions_ContactPage_EG.selectContactType(inSheetAddress.getRow(9).getCell(1).getStringCellValue());
			Actions_ContactPage_EG.enterContractNumber(ContractNum);
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Actions_ContactPage_EG.SavedUpdatedAdddress_Val(inSheetAddress.getRow(16).getCell(5).getStringCellValue());

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 7
	public void TC_Contact_Web_Delete_Cancel_Delete_Single_ContactRuleData()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Contact_Web_Delete_Cancel_Delete_Single_ContactRuleData");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Contact_Web_Delete_Cancel_Delete_Single_ContactRuleData")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}

			catch (FileNotFoundException e) {
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
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(5).getCell(3).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Thread.sleep(1000);
			Actions_ContactPage_EG.SelectedrecordDelete_Cancel(1);
			Actions_ContactPage_EG.SelectedrecordDeleted_DBcheck(1, inSheet.getRow(5).getCell(3).getStringCellValue());

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	// 8
	public void TC_Contact_Web_Delete_Cancel_Delete_Multiple_ContactRuleData()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Contact_Web_Delete_Cancel_Delete_Multiple_ContactRuleData");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Contact_Web_Delete_Cancel_Delete_Multiple_ContactRuleData")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
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
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(18).getCell(0).getStringCellValue());
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(5).getCell(3).getStringCellValue());
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Thread.sleep(1000);
			Actions_ContactPage_EG.SelectedrecordDelete_Cancel(2);
			Actions_ContactPage_EG.SelectedrecordDeleted_DBcheck(2, inSheet.getRow(5).getCell(3).getStringCellValue());

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	// -------------------------------------------Global Contact Type--------------------------------------------------------------//

	@Test
	// 9
	public void TC_Global_Contact_Web_App_Parameters()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Contact_Web_App_Parameters_Global");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Contact_Web_App_Parameters_Global").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}

			catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("WebAppParameters");

			// test steps
			Thread.sleep(1000);
			Utils.click(Header.contact_link());
			Thread.sleep(2000);
			Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
			Thread.sleep(2000);
			Actions_ContactPage_EG.clickOnCreateRuleButton();
			Thread.sleep(1000);
			Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
			Thread.sleep(3000);

			Actions_ContactPage_EG.compareGLContactTypeWithDB(Constants.Input_SQLS.getRow(22).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", 0, "GL");
			Actions_ContactPage_EG.selectContactType(inSheet.getRow(31).getCell(2).getStringCellValue());
			Actions_ContactPage_EG.selectRuleType(inSheet.getRow(4).getCell(5).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage_EG
					.StateCodesWithDatabase(Constants.Input_SQLS.getRow(32).getCell(1).getStringCellValue());

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");

		}
	}

	@Test
	//10
	public void TC_Global_Contact_Insert_SingleContact()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Create_Insert_Single_ContactInfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Create_Insert_Single_ContactInfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
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
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.clickOnCreateRuleButton();
					Thread.sleep(1000);
					Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
					Thread.sleep(3000);					
					Actions_ContactPage_EG.selectContactType(inSheet.getRow(31).getCell(2).getStringCellValue());
					Thread.sleep(1000);
					Actions_ContactPage_EG.selectRuleType(inSheet.getRow(4).getCell(5).getStringCellValue());
					Thread.sleep(1000);			
					String State = Actions_ContactPage_EG.save_GLSingleContactInfo(filepath, "Address");
					Actions_ContactPage_EG.compareGLinsertstatusWithDB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", inSheet.getRow(31).getCell(2).getStringCellValue());
					
					JubRun.JobSubmission();
					
					//------------uncomment the below 4 lines of code after including the Load run process code-------------
					/*String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", State); //AK==  State 
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", State);
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue(), 
							GroupID, State, inSheet.getRow(31).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(37).getCell(1).getStringCellValue(), 
							PlanID, State, inSheet.getRow(31).getCell(3).getStringCellValue());*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	@Test
	//11 
	public void TC_Global_Create_Insert_Multiple_ContactInfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Create_Insert_Multiple_ContactInfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Create_Insert_Multiple_ContactInfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
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
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.clickOnCreateRuleButton();
					Thread.sleep(1000);
					Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
					Thread.sleep(3000);
					Actions_ContactPage_EG.selectContactType_byValue(inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.selectRuleType(inSheet.getRow(4).getCell(5).getStringCellValue());
					String State = Actions_ContactPage_EG.save_GLMultiContactInfo(filepath, "Address", 1);					
					String ContactTypeID = Actions_ContactPage_EG.ContactDB_ContractRuletypeID(Constants.Input_SQLS.getRow(38).getCell(1).getStringCellValue(), 
							filepath,	"WebAppParameters");
					Actions_ContactPage_EG.compareMultiAddress_GL(Constants.Input_SQLS.getRow(39).getCell(1).getStringCellValue(), filepath,	
							"WebAppParameters", ContactTypeID, State);
					
					JubRun.JobSubmission();
					//------------uncomment the below 4 lines of code after including the Load run process code-------------
				
					/*String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", State); //AK==  State
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", State);		
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue(), 
							GroupID, State, inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(37).getCell(1).getStringCellValue(), 
							PlanID, State, inSheet.getRow(37).getCell(3).getStringCellValue());*/
		
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	@Test
	//12 
	public void TC_Global_Create_Logically_Deleted_Group()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Create_Logically_Deleted_Group");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Create_Logically_Deleted_Group").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
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
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.selectRuleType("STATE");
					Actions_ContactPage_EG.selectContactType("State Medicaid Office");
					Actions_ContactPage_EG.clickOnSearchContactsButton();
					String State = ContactPage_EG.state_InGrid(ContactPage_EG.rowCount_EditPage()).getText();
					Actions_ContactPage_EG.clickOnCreateRuleButton();
					Thread.sleep(1000);
					String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", State);
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
					filepath, "WebAppParameters", State);	
					
					JubRun.JobSubmission();
					
					
									//=------------------ uncomment below code While test run---------------
					
					/*Actions_ContactPage_EG.Logically_deletedGroup(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(), 
							Constants.Input_SQLS.getRow(40).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", inSheet.getRow(1).getCell(6).getStringCellValue(), State);
					
					//-------------------------------Load Run---------------------------------------------
			
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							GroupID, State, inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupID_PlanIDAfterLogicallyDel(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
							PlanID, State, inSheet.getRow(37).getCell(3).getStringCellValue());*/
		
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//13
	public void TC_Global_Create_StateMedicaidOffice_Staterule()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Create_StateMedicaidOffice_Staterule");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Create_StateMedicaidOffice_Staterule").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
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
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.clickOnCreateRuleButton();
					Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.selectContactType_byValue(inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.selectRuleType(inSheet.getRow(4).getCell(5).getStringCellValue());
					Actions_ContactPage_EG.selectGLState(inSheet.getRow(31).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(31).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.compareGLinsertstatusWithDB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", inSheet.getRow(37).getCell(2).getStringCellValue());
					
					JubRun.JobSubmission();
					
					//---------------------------uncomment--after--Load Run---------------------------------------------
					
					/*String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
								filepath, "WebAppParameters", inSheet.getRow(31).getCell(4).getStringCellValue());
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
								filepath, "WebAppParameters", inSheet.getRow(31).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							GroupID, inSheet.getRow(31).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							PlanID, inSheet.getRow(31).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//14 
	public void TC_Global_Update_StateMedicaidOffice_Add_DeleteContactInfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Update_StateMedicaidOffice_Add_DeleteContactInfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Update_StateMedicaidOffice_Add_DeleteContactInfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
					Utils.click(Header.contact_link());
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.selectRuleType("STATE");
					Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(2).getStringCellValue());
					Actions_ContactPage_EG.clickOnSearchContactsButton();
					String StateCode = Actions_ContactPage_EG.deleteandAddContactData(filepath, "Address");
					Actions_ContactPage_EG.UpdateDelInsert_DBCheck(Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue(), StateCode);
					
					JubRun.JobSubmission();
					
					//---------------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------------------------
			
					
					String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
								filepath, "WebAppParameters", StateCode);
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
								filepath, "WebAppParameters", StateCode);
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							GroupID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							PlanID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	@Test
	//15
	public void TC_Global_Update_StateMedicaidOffice_Delete_RuleState()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Update_StateMedicaidOffice_Delete_RuleState");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Update_StateMedicaidOffice_Delete_RuleState").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
					String StateCode = inSheet.getRow(32).getCell(4).getStringCellValue();
					Utils.click(Header.contact_link());
					Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.clickOnCreateRuleButton();
					Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
					Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(2).getStringCellValue());
					Actions_ContactPage_EG.selectRuleType(inSheet.getRow(4).getCell(5).getStringCellValue());
					Actions_ContactPage_EG.selectGLState(StateCode);
					Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(32).getCell(4).getStringCellValue());
					JubRun.JobSubmission();
					String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", StateCode);
					String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
							filepath, "WebAppParameters", StateCode);
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							PlanID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
							GroupID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					JubRun.JobSubmission();
					Actions_ContactPage_EG.DeletePlan_GroupIDinDB(Constants.Input_SQLS.getRow(44).getCell(1).getStringCellValue(), PlanID, StateCode);
					Actions_ContactPage_EG.DeletePlan_GroupIDinDB(Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue(), GroupID, StateCode);
					JubRun.JobSubmission();
					Actions_ContactPage_EG.GroupID_PlanIDAfterLogicallyDel(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							PlanID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					Actions_ContactPage_EG.GroupID_PlanIDAfterLogicallyDel(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
							GroupID, StateCode, inSheet.getRow(37).getCell(3).getStringCellValue());
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//16
	public void TC_Global_Update_StateMedicaidOffice_Add_RuleState()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Update_StateMedicaidOffice_Add_RuleState");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Update_StateMedicaidOffice_Add_RuleState").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
					Utils.click(Header.contact_link());
					String PlanID = Actions_ContactPage_EG.plan_group_NoStates_DB(Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue(), 
										inSheet.getRow(1).getCell(6).getStringCellValue());
					String CountyID1 = Actions_ContactPage_EG.CountyID_DB(Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue(), 
							Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue(), inSheet.getRow(33).getCell(4).getStringCellValue());
					System.out.println(CountyID1);
					Actions_ContactPage_EG.InsertCounty(Constants.Input_SQLS.getRow(49).getCell(1).getStringCellValue(), CountyID1, PlanID);
					String GroupID = Actions_ContactPage_EG.plan_group_NoStates_DB(Constants.Input_SQLS.getRow(50).getCell(1).getStringCellValue(), 
							inSheet.getRow(1).getCell(6).getStringCellValue());
					String CountyID2 = Actions_ContactPage_EG.CountyID_DB(Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue(), 
							Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue(), inSheet.getRow(33).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.InsertCounty(Constants.Input_SQLS.getRow(51).getCell(1).getStringCellValue(), CountyID2, GroupID);
					JubRun.JobSubmission();
					//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
					
					String CountyID_GA = Actions_ContactPage_EG.CountyID_DB(Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue(), 
							Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue(), inSheet.getRow(34).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.InsertCounty(Constants.Input_SQLS.getRow(49).getCell(1).getStringCellValue(), CountyID_GA, PlanID);
					String CountyID_TX = Actions_ContactPage_EG.CountyID_DB(Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue(), 
							Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue(), inSheet.getRow(32).getCell(4).getStringCellValue());
					Actions_ContactPage_EG.InsertCounty(Constants.Input_SQLS.getRow(51).getCell(1).getStringCellValue(), CountyID_TX, GroupID);
					JubRun.JobSubmission();
					//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
					
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
							PlanID, inSheet.getRow(34).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());				
					Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
							GroupID, inSheet.getRow(32).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());				
											
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//17
	public void TC_Global_Update_StateMedicaidOffice_Single_Contactinfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Update_StateMedicaidOffice_Single_Contactinfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Update_StateMedicaidOffice_Single_Contactinfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(3).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				Actions_ContactPage_EG.ClicktoEditAddress_Grid();
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(35).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_AddressScreen();
				//Actions_ContactPage_EG.Alert_Accept();
				Actions_ContactPage_EG.compareGLUpdatestatusWithDB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(37).getCell(2).getStringCellValue());
				
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				/*Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(37).getCell(2).getStringCellValue());
				
				String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
						filepath, "WebAppParameters", inSheet.getRow(35).getCell(4).getStringCellValue());
				String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
						filepath, "WebAppParameters", inSheet.getRow(35).getCell(4).getStringCellValue());
				
				
				
				Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						PlanID, inSheet.getRow(35).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						GroupID, inSheet.getRow(35).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	@Test
	//18
	public void TC_Global_Update_StateMedicaidOffice_Multiple_Contactinfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Update_StateMedicaidOffice_Multiple_Contactinfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Update_StateMedicaidOffice_Multiple_Contactinfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(3).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				
				Actions_ContactPage_EG.MultiAddressUpdation(filepath, "Address", inSheet.getRow(36).getCell(4).getStringCellValue());
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				/*Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(37).getCell(2).getStringCellValue());
				
				String GroupID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue(),
						filepath, "WebAppParameters", inSheet.getRow(36).getCell(4).getStringCellValue());
				String PlanID = Actions_ContactPage_EG.StoringG_IDandP_IDAfterLoadWithDB(Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue(),
						filepath, "WebAppParameters", inSheet.getRow(36).getCell(4).getStringCellValue());
				
				
				Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						PlanID, inSheet.getRow(36).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.GroupIDorPlanIDAfterLoadWithDB(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						GroupID, inSheet.getRow(36).getCell(4).getStringCellValue(), inSheet.getRow(37).getCell(3).getStringCellValue());*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//19 Working
	public void TC_Global_Delete_StateMedicaidOffice_Single_ContactRule_info()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Delete_StateMedicaidOffice_Single_ContactRule_info");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Delete_StateMedicaidOffice_Single_ContactRule_info").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(3).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				List<String> StateCodes = Actions_ContactPage_EG.DeleterecordsGL(1);
				
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				/*Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//20
	public void TC_Global_Delete_StateMedicaidOffice_Multiple_ContactRules()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Delete_StateMedicaidOffice_Multiple_ContactRules");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Delete_StateMedicaidOffice_Multiple_ContactRules").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(3).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				List<String> StateCodes = Actions_ContactPage_EG.DeleterecordsGL(2);
				
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				/*Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);*/
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//21
	public void TC_Global_Delete_StateMedicaidOffice_Single_Contactinfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Delete_StateMedicaidOffice_Single_Contactinfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Delete_StateMedicaidOffice_Single_Contactinfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(37).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				List<String>StateCodes = Actions_ContactPage_EG.deleteContactData_Single_Multiple(1);
				Actions_ContactPage_EG.Deletedcontact_DBCheck(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters");
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(),
						 filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue());
				
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");
			}
		}
	
	@Test
	//22
	public void TC_Global_Delete_StateMedicaidOffice_Multiple_Contactinfo()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_Global_Delete_StateMedicaidOffice_Multiple_Contactinfo");

		if (Utils.getTestCasePreferenceFromInfobank("TC_Global_Delete_StateMedicaidOffice_Multiple_Contactinfo").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectGroupType(inSheet.getRow(19).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType("State Medicaid Office");
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				List<String>StateCodes = Actions_ContactPage_EG.deleteContactData_Single_Multiple(2);
				Actions_ContactPage_EG.Deletedcontact_DBCheck(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters");
				
				
				JubRun.JobSubmission();
				//------------------uncomment--after--Load Run------(Job_IndividualGLContactRuleDataLoad)---------------------
				
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(),
						 filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
				Actions_ContactPage_EG.DelRecords_IndEmpDBCheck(Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(37).getCell(3).getStringCellValue(), StateCodes);
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	
	
	@Test
	//23 
	public void TC_IndividualPlanContactLoad_Delete()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Delete");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Delete").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(4).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.clickOnSearchContactsButton();				
				Actions_ContactPage_EG.DeleteIndividualCheck_DB(Constants.Input_SQLS.getRow(52).getCell(1).getStringCellValue(), 
						Constants.Input_SQLS.getRow(53).getCell(1).getStringCellValue(), filepath, "WebAppParameters");
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//24 
	public void TC_IndividualPlanContactLoad_Public()	throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Public");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Public").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());				
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(5).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.CreateIndruleandDB_Val(Constants.Input_SQLS.getRow(52).getCell(1).getStringCellValue(), 
						Constants.Input_SQLS.getRow(53).getCell(1).getStringCellValue(), filepath, "WebAppParameters");
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//25 
	public void TC_IndividualPlanContactLoad_Existing_NewContactTypes() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Existing&NewContactTypes");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Existing&NewContactTypes").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				JubRun.JobSubmission();
				int Beforeinsert = Actions_ContactPage_EG.planid_addressrowcount(Constants.Input_SQLS.getRow(54).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters");
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(6).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(5).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(43).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBoxCreateNewRule();				
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(33).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				JubRun.JobSubmission();
				int Afterinsert = Actions_ContactPage_EG.planid_addressrowcount(Constants.Input_SQLS.getRow(54).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters");
				Actions_ContactPage_EG.Addressinsertcount(Beforeinsert, Afterinsert);
					
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	@Test
	//25 
	public void TC_IndividualPlanContactLoad_Insert_MAPD() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Insert_MAPD");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Insert_MAPD").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(6).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(45).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBoxCreateNewRule();
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(33).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters", 
						inSheet.getRow(45).getCell(1).getStringCellValue(), "10", 52);
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(3).getCell(4).getStringCellValue());
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//26
	public void TC_IndividualPlanContactLoad_Insert_MA() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Insert_MA");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Insert_MA").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(6).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(44).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBoxCreateNewRule();
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(33).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters",
						inSheet.getRow(44).getCell(1).getStringCellValue(), "5", 63);
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(3).getCell(4).getStringCellValue());
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	@Test
	//27
	public void TC_IndividualPlanContactLoad_Insert_PDP() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Insert_PDP");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Insert_PDP").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(6).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(43).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBoxCreateNewRule();
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(33).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters",
						inSheet.getRow(43).getCell(1).getStringCellValue(), "5", 69);
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(3).getCell(4).getStringCellValue());
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	@Test
	//27 
	public void TC_IndividualPlanContactLoad_Secure() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Secure");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Secure").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(5).getCell(5).getStringCellValue());
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(46).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBoxCreateNewRule();
				Actions_ContactPage_EG.savingAddress(filepath, "Address", inSheet.getRow(33).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.compareGLinsertstatusWithDB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters", inSheet.getRow(2).getCell(4).getStringCellValue());
				
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	@Test
	//28 
	public void TC_IndividualPlanContactLoad_Update() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Update");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Update").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
	
				// test steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.selectPlanYear(inSheet.getRow(2).getCell(6).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.enterContractNumber(inSheet.getRow(45).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchContactsButton();
				Actions_ContactPage_EG.selectPlanCheckBox_resultGrid();
				Actions_ContactPage_EG.ClicktoEditAddress_Grid();
				Actions_ContactPage_EG.UpdateAdddress(filepath, "Address");
				Actions_ContactPage_EG.clickOnsaveButton_AddressScreen();
				Actions_ContactPage_EG.Alert_Accept();
				//-----run the job----------Job_IndividualPlanContactRuleDataLoad_Main.dtsx------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters",
						inSheet.getRow(45).getCell(1).getStringCellValue(), "10", 52);
				Actions_ContactPage_EG.compareIndAddressUpdate_Load_DB(Constants.Input_SQLS.getRow(57).getCell(1).getStringCellValue(), 
						filepath, "WebAppParameters");
			
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//29
	public void TC_IndividualPlanContactLoad_Update_Drugcoveragetype_CustomerService() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Update_Drugcoveragetype_CustomerService");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Update_Drugcoveragetype_CustomerService").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
				
				//steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(6).getCell(5).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(47).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBox_MA_Plan();
				Actions_ContactPage_EG.savingIndividualAddress(filepath, "Address", inSheet.getRow(36).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				Actions_ContactPage_EG.Alert_Accept();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters",
						inSheet.getRow(47).getCell(1).getStringCellValue(), "5", 63);
				Actions_ContactPage_EG.updateDrugCovType(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(),
						inSheet.getRow(45).getCell(2).getStringCellValue(), inSheet.getRow(47).getCell(0).getStringCellValue());
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters", 
						inSheet.getRow(47).getCell(1).getStringCellValue(), "10", 52);
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(3).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.updateDrugCovType(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(),
						 inSheet.getRow(44).getCell(2).getStringCellValue(), inSheet.getRow(47).getCell(0).getStringCellValue());
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				
				Actions_ContactPage_EG.LoadedContactTypes_DBCheck(Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue(),
						Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue(), filepath, "WebAppParameters", 
						inSheet.getRow(47).getCell(1).getStringCellValue(), "10", 52);
				Actions_ContactPage_EG.compareGLUpdate_Load_DB(Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue(), 
						filepath, "Address", inSheet.getRow(3).getCell(4).getStringCellValue());
			
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	@Test
	//30 
	public void TC_IndividualPlanContactLoad_Update_Drugcoveragetype() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Update_Drugcoveragetype");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Update_Drugcoveragetype").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
				
				//steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(2).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(5).getCell(5).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(48).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBox_MA_Plan();
				Actions_ContactPage_EG.savingIndividualAddress(filepath, "Address", inSheet.getRow(36).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				Actions_ContactPage_EG.Alert_Accept();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				
				Actions_ContactPage_EG.compareIndInsert_DB(Constants.Input_SQLS.getRow(53).getCell(1).getStringCellValue(),
							 filepath, "WebAppParameters");
				Actions_ContactPage_EG.UpdatedAdddress_DBCheck(Constants.Input_SQLS.getRow(31).getCell(1).getStringCellValue(), 
						inSheet.getRow(48).getCell(1).getStringCellValue());				
				Actions_ContactPage_EG.updateDrugCovType(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(),
						 inSheet.getRow(43).getCell(2).getStringCellValue(), inSheet.getRow(48).getCell(0).getStringCellValue());				
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(1).getCell(2).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(2).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(5).getCell(5).getStringCellValue());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(48).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBox_PDP_Plan();
				Actions_ContactPage_EG.savingIndividualAddress(filepath, "Address", inSheet.getRow(36).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				Actions_ContactPage_EG.Alert_Accept();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();	
				Actions_ContactPage_EG.compareIndInsert_DB(Constants.Input_SQLS.getRow(53).getCell(1).getStringCellValue(),
						 filepath, "WebAppParameters");
				
			
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	@Test
	//31
	public void TC_IndividualPlanContactLoad_Update_Drugcoveragetype_PCCDExpeditedWriteIn() 
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualPlanContactLoad_Update_Drugcoveragetype_PCCDExpeditedWriteIn");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualPlanContactLoad_Update_Drugcoveragetype_PCCDExpeditedWriteIn").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream(filepath);
				inWorkbook = new XSSFWorkbook(input_Excel);
			}
			
			 catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
				Sheet inSheet = inWorkbook.getSheet("WebAppParameters");
				
				//steps
				Utils.click(Header.contact_link());
				Actions_ContactPage_EG.clickOnCreateRuleButton();
				Actions_ContactPage_EG.selectIncludeIndicator(inSheet.getRow(2).getCell(1).getStringCellValue());
				Actions_ContactPage_EG.selectContactType(inSheet.getRow(54).getCell(0).getStringCellValue());
				Actions_ContactPage_EG.selectRuleType(inSheet.getRow(6).getCell(5).getStringCellValue());				
				Actions_ContactPage_EG.selectContractDropdown(inSheet.getRow(45).getCell(3).getStringCellValue());
				Actions_ContactPage_EG.clickOnSearchPlans();
				Actions_ContactPage_EG.selectCheckBox_MAPD_Plan();
				Actions_ContactPage_EG.savingIndividualAddress(filepath, "Address", inSheet.getRow(36).getCell(4).getStringCellValue());
				Actions_ContactPage_EG.clickOnsaveButton_CreateScreen();
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.recordWithPart_C_MAPD(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(), filepath, "WebAppParameters");
				Actions_ContactPage_EG.updateDrugCovType(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(),
						inSheet.getRow(43).getCell(2).getStringCellValue(), inSheet.getRow(45).getCell(4).getStringCellValue());
				//----------------Job Run------Job_IndividualContactRuleDataLoad_Main.dtsx------------------------------------
				JubRun.JobSubmission();
				Actions_ContactPage_EG.recordWithPart_C_PDP(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(), filepath, "WebAppParameters");
				Actions_ContactPage_EG.updateDrugCovType(Constants.Input_SQLS.getRow(58).getCell(1).getStringCellValue(),
						inSheet.getRow(45).getCell(2).getStringCellValue(), inSheet.getRow(45).getCell(4).getStringCellValue());
				
			
			} else {
				Constants.test.log(Status.SKIP, "Test Case has been skipped");
				throw new SkipException("Skipping this test case");

			}
		}
	
	
	
	
}