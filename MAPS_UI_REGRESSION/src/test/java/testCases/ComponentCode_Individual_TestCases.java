package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_ComponentCodePage;
import actions.Actions_Header;
import miscellaneous.BeforeAndAfter;
import miscellaneous.Excel_Compare_ComponentCode;
import miscellaneous.Excel_Compare_ComponentCode_DeleteOperation;
import utilities.Constants;
import utilities.Utils;

public class ComponentCode_Individual_TestCases extends BeforeAndAfter {

	Workbook inWorkbook = null;

	@Test(priority = 0)
	public void TC_IND_Insert_Chart_ANOC()
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {

		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IND_Insert_Chart_ANOC");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Insert_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// below are test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_Insert_Chart_ANOC.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			// generate excel Comparison report
			miscellaneous.Excel_Compare_ComponentCode.generateCompareReport(
					"./src/test/java/testData/TC_IND_Insert_Chart_ANOC.xlsx",
					"./Excel_Comparision_Report/TC_IND_Insert_Chart_ANOC" + "_" + Constants.timeStamp + ".xlsx");
			// Comparison
			Actions_ComponentCodePage
					.compareUploadedFileDetailsWithDB("\\src\\test\\java\\testData\\TC_IND_Insert_Chart_ANOC.xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 1)
	public void TC_IND_Update_Chart_ANOC()
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IND_Update_Chart_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Update_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_Update_Chart_ANOC.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			// generate excel report
			Excel_Compare_ComponentCode.generateCompareReport("./src/test/java/testData/TC_IND_Update_Chart_ANOC.xlsx",
					"./Excel_Comparision_Report/TC_IND_Update_Chart_ANOC.xlsx" + "_" + Constants.timeStamp);
			// Comparison
			Actions_ComponentCodePage
			.compareUploadedFileDetailsWithDB("\\src\\test\\java\\testData\\TC_IND_Update_Chart_ANOC.xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 2)
	public void TC_IND_Delete_Chart_ANOC()
			throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_IND_Delete_Chart_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Delete_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_Delete_Chart_ANOC.xlsx");
			Actions_ComponentCodePage.clickOnProcessRecordsButton();
			// generate excel report
			Excel_Compare_ComponentCode_DeleteOperation.generateCompareReport(
					"./src/test/java/testData/TC_IND_Delete_Chart_ANOC.xlsx",
					"./Excel_Comparision_Report/TC_IND_Delete_Chart_ANOC.xlsx" + "_" + Constants.timeStamp);
			// Comparison
			Actions_ComponentCodePage.compareUploadedFileDetailsWithDB_Delete(
					"\\src\\test\\java\\testData\\TC_IND_Delete_Chart_ANOC.xlsx");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 3)
	public void TC_IND_ErrorMessage_InvalidPlanData() throws InterruptedException {

		// HTML Report
		Constants.test = Constants.extent.createTest("TC_IND_ErrorMessage_InvalidPlanData");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_ErrorMessage_InvalidPlanData").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_ErrorMessage_InvalidPlanData.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_invalidPlanData();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 4)
	public void TC_IND_ErrorMessage_InvalidPlanYear() throws InterruptedException {

		// HTML Reporting
		Constants.test = Constants.extent.createTest("TC_IND_ErrorMessage_InvalidPlanYear");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_ErrorMessage_InvalidPlanYear").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_ErrorMessage_InvalidPlaYear.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_invalidPlanYear_individual();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 5)
	public void TC_IND_ErrorMessage_Max30Chars() throws InterruptedException {

		// HTML Report
		Constants.test = Constants.extent.createTest("TC_IND_ErrorMessage_Max30Chars");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_ErrorMessage_Max30Chars").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_ErrorMessage_Max30Chars.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_max30Chars_individual();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 6)
	public void TC_IND_ErrorMessage_Min4Chars() throws InterruptedException {
		// HTML reporting
		Constants.test = Constants.extent.createTest("TC_IND_ErrorMessage_Min4Chars");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_ErrorMessage_Min4Chars").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// test steps
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.clickOnUploadFileTemplateButton();
			Actions_ComponentCodePage
					.uploadFile_inPopUp("\\src\\test\\java\\testData\\TC_IND_ErrorMessage_Min4Chars.xlsx");
			Actions_ComponentCodePage.checkErrorMessage_min4Chars_individual();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 7)
	public void individual_serach_chart()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		FileInputStream input_Excel = new FileInputStream("./src/test/java/testData/Individual_Search_ANOC.xlsx");
		inWorkbook = new XSSFWorkbook(input_Excel);
		Sheet inSheet = inWorkbook.getSheet("Sheet1");

		Constants.test = Constants.extent.createTest("TC_IND_Search_ANOC");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Search_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.select_DataType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ComponentCodePage.select_RecordType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ComponentCodePage.enter_ComponentCode(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_ComponentCodePage.select_PlanYear(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ComponentCodePage
					.select_ContractNumber_individual(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ComponentCodePage.select_PBPNumber_individual(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ComponentCodePage
					.select_compareContractNumber_individual(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ComponentCodePage.select_comparePBPNumber(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ComponentCodePage.clickOnSearchButton();
			Actions_ComponentCodePage.compareSearchResultWithDBvalues_individual();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test(priority = 8)
	public void TC_IND_Search_Chart() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		FileInputStream input_Excel = new FileInputStream("./src/test/java/testData/Individual_Search_Chart.xlsx");
		inWorkbook = new XSSFWorkbook(input_Excel);
		Sheet inSheet = inWorkbook.getSheet("Sheet1");

		Constants.test = Constants.extent.createTest("TC_IND_Search_Chart");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Search_Chart").equalsIgnoreCase("Y")) {
			initiateBrowser();
			Actions_Header.clickOnComponentCodeLink();
			Actions_ComponentCodePage.select_DataType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ComponentCodePage.select_RecordType(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_ComponentCodePage.select_PlanYear(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_ComponentCodePage
					.select_ContractNumber_individual(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_ComponentCodePage.select_PBPNumber_individual(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_ComponentCodePage
					.select_compareContractNumber_individual(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_ComponentCodePage.select_comparePBPNumber(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_ComponentCodePage.clickOnSearchButton();
			Actions_ComponentCodePage.compareSearchResultWithDBvalues_employer();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
}
