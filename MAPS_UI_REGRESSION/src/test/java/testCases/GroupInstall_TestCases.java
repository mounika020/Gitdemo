package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Action;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_GroupInstallPage;
import actions.Actions_GroupInstall_IndividualRxPage;
import actions.Actions_Header;
import actions.Actions_InidividualRxWrapPage;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class GroupInstall_TestCases extends BeforeAndAfter {

	String testData_Path = "./src/test/java/testData/GroupInstall.xlsx";

	@Test
	public void TC_GroupInstall_EmployerGroupMAPD_RxWrap_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_EmployerGroupMAPD_RxWrap_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_EmployerGroupMAPD_RxWrap_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "EGMAPD_RxWrap_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();

			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"EGMAPD_RxWrap_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_EmployerGroupMAPD_RxWrap_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_GroupInstall_EmployerGroupPDP_RxWrap_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_EmployerGroupPDP_RxWrap_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_EmployerGroupPDP_RxWrap_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "EGPDP_RxWrap_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();

			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"EGPDP_RxWrap_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_EmployerGroupPDP_RxWrap_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_GroupInstall_EmployerGroupMAPD_NonRxWrap_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_EmployerGroupMAPD_NonRxWrap_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_EmployerGroupMAPD_NonRxWrap_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "EGMAPD_NonRxWrap_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();

			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"EGMAPD_NonRxWrap_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_EmployerGroupMAPD_NonRxWrap_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_GroupInstall_EmployerGroupPDP_NonRxWrap_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_EmployerGroupPDP_NonRxWrap_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_EmployerGroupPDP_NonRxWrap_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "EGPDP_NonRxWrap_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();
			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"EGPDP_NonRxWrap_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_EmployerGroupPDP_NonRxWrap_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_GroupInstall_EmployerGroupMA_NonRxWrap_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_EmployerGroupMA_NonRxWrap_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_EmployerGroupMA_NonRxWrap_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "EGMA_NonRxWrap_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();
			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"EGMA_NonRxWrap_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_EmployerGroupMA_NonRxWrap_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test
	//This test case has test data setup in TST1
	public void TC_GroupInstall_SSRD_Rx_DefaultValues()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_GroupInstall_SSRD_Rx_DefaultValues");
		if (Utils.getTestCasePreferenceFromInfobank("TC_GroupInstall_SSRD_Rx_DefaultValues")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "SSRD_Default");

			// UI operations
			Actions_Header.clickOnGroupInstallLink();
			Actions_GroupInstallPage.select_contractYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_GroupInstallPage.enter_groupNumber(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_GroupInstallPage.clickOnSearchButton();
			Thread.sleep(5000);
			Actions_GroupInstall_IndividualRxPage.clickOnInputRxDataLink();
			Thread.sleep(5000);

			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_GroupInstall_InputRx_DefaultValues.generateCompareReport(testData_Path,
					"SSRD_Default",
					"./Excel_Comparision_Report/TC_GroupInstall_SSRD_Rx_DefaultValues_"
							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

}