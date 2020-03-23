package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_Header;
import actions.Actions_InidividualRxWrapPage;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class IndividualRxWrap_TestCases extends BeforeAndAfter {

	Workbook inWorkbook = null;

	@Test
	public void TC_IndividualRxWrap_Search()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualRxWrap_Search");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualRxWrap_Search").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			FileInputStream input_Excel = new FileInputStream("./src/test/java/testData/IndividualRxWrap_Search.xlsx");
			inWorkbook = new XSSFWorkbook(input_Excel);
			Sheet inSheet = inWorkbook.getSheet("Sheet1");

			// UI operations
			Actions_Header.clickOnIndividualRxWrapLink();
			Actions_InidividualRxWrapPage.select_planYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_InidividualRxWrapPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_IndividualRxWrap_Search_Edit.generateCompareReport(
					"./src/test/java/testData/IndividualRxWrap_Search.xlsx",
					"./Excel_Comparision_Report/TC_IndividualRxWrap_Search_" + Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_IndividualRxWrap_Edit()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualRxWrap_Edit");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualRxWrap_Edit").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			FileInputStream input_Excel = new FileInputStream("./src/test/java/testData/IndividualRxWrap_Edit.xlsx");
			inWorkbook = new XSSFWorkbook(input_Excel);
			Sheet inSheet = inWorkbook.getSheet("Sheet1");

			// Home page operations
			Actions_Header.clickOnIndividualRxWrapLink();
			Actions_InidividualRxWrapPage.select_planYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_InidividualRxWrapPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(3000);
			Actions_InidividualRxWrapPage.clickOnEditLink();
			Thread.sleep(5000);

			// Edit Screen
			Actions_InidividualRxWrapPage.edit_supplementTypeCode_checkbox();
			Actions_InidividualRxWrapPage
					.edit_select_supplementTypeCode(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_DURKey_checkbox();
			Actions_InidividualRxWrapPage.edit_DURKey(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalBIN_checkbox();
			Actions_InidividualRxWrapPage.edit_internalBIN(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalPCN_checkbox();
			Actions_InidividualRxWrapPage.edit_internalPCN(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalRxGroup_checkbox();
			Actions_InidividualRxWrapPage.edit_internalRxGroup(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnEditUpdateButton();

			// Click on Alert box
			Actions_InidividualRxWrapPage.clickOnAlertOK();

			// Re-searching the same group and comparing data between Search
			// results and DB Values
			Actions_InidividualRxWrapPage.select_planYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_InidividualRxWrapPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_IndividualRxWrap_Search_Edit.generateCompareReport(
					"./src/test/java/testData/IndividualRxWrap_Edit.xlsx",
					"./Excel_Comparision_Report/TC_IndividualRxWrap_Edit_" + Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_IndividualRxWrap_Cancel()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualRxWrap_Cancel");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualRxWrap_Cancel").equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			FileInputStream input_Excel = new FileInputStream("./src/test/java/testData/IndividualRxWrap_Cancel.xlsx");
			inWorkbook = new XSSFWorkbook(input_Excel);
			Sheet inSheet = inWorkbook.getSheet("Sheet1");

			// Home page operations
			Actions_Header.clickOnIndividualRxWrapLink();
			Actions_InidividualRxWrapPage.select_planYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_InidividualRxWrapPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(3000);
			Actions_InidividualRxWrapPage.clickOnEditLink();
			Thread.sleep(5000);

			// Edit Screen
			Actions_InidividualRxWrapPage.edit_supplementTypeCode_checkbox();
			Actions_InidividualRxWrapPage
					.edit_select_supplementTypeCode(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_DURKey_checkbox();
			Actions_InidividualRxWrapPage.edit_DURKey(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalBIN_checkbox();
			Actions_InidividualRxWrapPage.edit_internalBIN(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalPCN_checkbox();
			Actions_InidividualRxWrapPage.edit_internalPCN(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_InidividualRxWrapPage.edit_internalRxGroup_checkbox();
			Actions_InidividualRxWrapPage.edit_internalRxGroup(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnEditUpdateButton();

			// Click on Alert box
			Actions_InidividualRxWrapPage.clickOnAlertCancel();
			Actions_InidividualRxWrapPage.clickOnEditCancelLink();

			Thread.sleep(2000);

			// Re-searching the same group and comparing data between Search
			// results and DB Values
			Actions_InidividualRxWrapPage.select_planYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_InidividualRxWrapPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_IndividualRxWrap_Cancel.generateCompareReport(
					"./src/test/java/testData/IndividualRxWrap_Cancel.xlsx",
					"./Excel_Comparision_Report/TC_IndividualRxWrap_Cancel_" + Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_IndividualRxWrap_recordsCount()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_IndividualRxWrap_recordsCount");
		if (Utils.getTestCasePreferenceFromInfobank("TC_IndividualRxWrap_recordsCount").equalsIgnoreCase("Y")) {
			initiateBrowser();

			// UI operations
			Actions_Header.clickOnIndividualRxWrapLink();
			Actions_InidividualRxWrapPage.select_planYear("2017");
			Actions_InidividualRxWrapPage.enter_contractNumber("H0543");
			Actions_InidividualRxWrapPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_InidividualRxWrapPage.compareDBrecordsCountWithUIsearchResultsCount();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

}