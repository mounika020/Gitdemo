package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_ComponentCodePage;
import actions.Actions_Header;
import miscellaneous.BeforeAndAfter;
import miscellaneous.Excel_Compare_ComponentCode_Employer;
import miscellaneous.Excel_Compare_ComponentCode_Employer_DeleteOperation;
import utilities.Constants;
import utilities.Utils;

public class ComponentCode_Employer_TestCases extends BeforeAndAfter {

	Workbook inWorkbook = null;

	@Test(priority = 0)
	public void TC_EMP_Insert_Chart_ANOC()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException, ParseException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EMP_Insert_Chart_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_Insert_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// below are test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\EmployerGroup_Componentcodes_Insert.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			Actions_ComponentCodePage.compareUploadedFileDetailsWithDB_Employee(
					"\\src\\test\\java\\testData\\EmployerGroup_Componentcodes_Insert.xlsx");

			// generate excel comparision report
			Excel_Compare_ComponentCode_Employer.generateCompareReport(
					"./src/test/java/testData/EmployerGroup_Component codes_Insert.xlsx",
					"./Excel_Comparision_Report/TC_EMP_Insert_Chart_ANOC.xlsx" + "_" + Constants.timeStamp);
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}

	}

	@Test(priority = 1)
	public void TC_EMP_Update_Chart_ANOC()
			throws InterruptedException, ClassNotFoundException, IOException, SQLException, ParseException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EMP_Update_Chart_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_Update_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// below are test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\EmployerGroup_Component codes_Update.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			Actions_ComponentCodePage.compareUploadedFileDetailsWithDB_Employee(
					"\\src\\test\\java\\testData\\EmployerGroup_Component codes_Update.xlsx");

			// generate excel comparision report
			Excel_Compare_ComponentCode_Employer.generateCompareReport(
					"./src/test/java/testData/EmployerGroup_Component codes_Update.xlsx",
					"./Excel_Comparision_Report/TC_EMP_Update_Chart_ANOC.xlsx" + "_" + Constants.timeStamp);
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 2)
	public void TC_EMP_Delete_Chart_ANOC()
			throws ClassNotFoundException, InterruptedException, IOException, SQLException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EMP_Delete_Chart_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_Delete_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\EmployerGroup_Component codes_Delete.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			Actions_ComponentCodePage.compareUploadedFileDetailsWithDB_Delete(
					"\\src\\test\\java\\testData\\EmployerGroup_Componentcodes_Delete.xlsx");

			// generate excel report
			Excel_Compare_ComponentCode_Employer_DeleteOperation.generateCompareReport(
					"./src/test/java/testData/EmployerGroup_Component codes_Delete.xlsx",
					"./Excel_Comparision_Report/TC_EMP_Delete_Chart_ANOC.xlsx" + "_" + Constants.timeStamp);
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 3)
	public void TC_EMP_Search_Anoc() throws IOException {
		FileInputStream input_Excel = new FileInputStream(
				"./src/test/java/testData/EmployerGroup_Component codes_Search_Anoc.xlsx");
		inWorkbook = new XSSFWorkbook(input_Excel);
		Sheet inSheet = inWorkbook.getSheet("Sheet1");

		// HTML report
		Constants.test = Constants.extent.createTest("TC_EMP_Search_Anoc");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_Search_Anoc").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.select_DataType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ComponentCodePage.select_RecordType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ComponentCodePage.enter_ComponentCode(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ComponentCodePage.select_effectiveDatee(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ComponentCodePage.select_ContractNumber_employer(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ComponentCodePage.select_PBPNumber_employer(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ComponentCodePage.select_groupNumber(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ComponentCodePage.select_masterGroup(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ComponentCodePage.select_division(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ComponentCodePage.select_compareEffectiveDate(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ComponentCodePage
					.select_compareContractNumber_employer(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ComponentCodePage.select_comparePBPNumber(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ComponentCodePage.select_compareGroupNumber(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ComponentCodePage.select_compareMasterGroup(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ComponentCodePage.select_compareDivision(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ComponentCodePage.clickOnSearchButton();

			// compare search results with Database
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}

	}

	@Test(priority = 4)
	public void TC_EMP_Search_Chart() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		FileInputStream input_Excel = new FileInputStream(
				"./src/test/java/testData/EmployerGroup_Component codes_Search_Chart.xlsx");
		inWorkbook = new XSSFWorkbook(input_Excel);
		Sheet inSheet = inWorkbook.getSheet("Sheet1");

		// HTML report
		Constants.test = Constants.extent.createTest("TC_EMP_Search_Chart");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_Search_Chart").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.select_DataType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ComponentCodePage.select_RecordType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ComponentCodePage.enter_ComponentCode(inSheet.getRow(1).getCell(2).getStringCellValue().toString());
			Actions_ComponentCodePage.select_effectiveDatee(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ComponentCodePage.select_ContractNumber_employer(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ComponentCodePage.select_PBPNumber_employer(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ComponentCodePage.select_groupNumber(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ComponentCodePage.select_masterGroup(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ComponentCodePage.select_division(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_ComponentCodePage.select_compareEffectiveDate(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_ComponentCodePage
					.select_compareContractNumber_employer(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_ComponentCodePage.select_comparePBPNumber(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_ComponentCodePage.select_compareGroupNumber(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ComponentCodePage.select_compareMasterGroup(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ComponentCodePage.select_compareDivision(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ComponentCodePage.clickOnSearchButton();
			Actions_ComponentCodePage.compareSearchResultWithDBvalues_individual();

			// compare search results with Database
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 5)
	public void TC_EMP_ErrorMessage_InvalidPlanData() throws InterruptedException {

		// HTML Report
		Constants.test = Constants.extent.createTest("TC_EMP_ErrorMessage_InvalidPlanData");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_ErrorMessage_InvalidPlanData").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp(
					"\\src\\test\\java\\testData\\EmployerGroup_Component codes_ErrorMessage_InvalidPlanData.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_invalidPlanData();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 6)
	public void TC_EMP_ErrorMessage_InvalidPlanYear() throws InterruptedException {

		// HTML Reporting
		Constants.test = Constants.extent.createTest("TC_EMP_ErrorMessage_InvalidPlanYear");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_ErrorMessage_InvalidPlanYear").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp(
					"\\src\\test\\java\\testData\\EmployerGroup_Component codes_ErrorMessage_InvalidYear.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_invalidPlanYear_employer();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 7)
	public void TC_EMP_ErrorMessage_Max30Chars() throws InterruptedException {
		// HTML reporting
		Constants.test = Constants.extent.createTest("TC_EMP_ErrorMessage_Max30Chars");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_ErrorMessage_Max30Chars").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp(
					"\\src\\test\\java\\testData\\EmployerGroup_Component codes_ErrorMessage_Max30Chars.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_max30Chars_employer();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 8)
	public void TC_EMP_ErrorMessage_Min4Chars() throws InterruptedException {
		// HTML reporting
		Constants.test = Constants.extent.createTest("TC_EMP_ErrorMessage_Min4Chars");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EMP_ErrorMessage_Min4Chars").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp(
					"\\src\\test\\java\\testData\\EmployerGroup_Component codes_ErrorMessage_Min4Char.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_min4Chars_employer();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
}
