package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Action;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_ContactPage;
import actions.Actions_GroupInstallPage;
import actions.Actions_GroupInstall_IndividualRxPage;
import actions.Actions_Header;
import actions.Actions_InidividualRxWrapPage;
import actions.Actions_ListMaintenance;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class ListMaintenance_TestCases extends BeforeAndAfter {

	String testData_Path = "./src/test/java/testData/ListMaintenance.xlsx";

	@Test
	public void TC_ListMaintenance_Create_New_BrandType()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_ListMaintenance_Create_New_BrandType");
		if (Utils.getTestCasePreferenceFromInfobank("TC_ListMaintenance_Create_New_BrandType").equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			XSSFSheet inSheet = Utils.excel_sheet(testData_Path, "BrandType");
			String name = inSheet.getRow(1).getCell(0).getStringCellValue();

			// UI operations
			Actions_Header.clickOnListMaintenanceLink();
			Actions_ListMaintenance.clickOnBrandTypeLink();
			Actions_ListMaintenance.clickOnCreateNewBrandButton();
			Actions_ListMaintenance.enterName(name);
			Actions_ListMaintenance.clickOnCreateBrandButton();
			Actions_ListMaintenance.Alert_Accept();
			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_ListMaintenance_BrandType.generateCompareReport(testData_Path,
					"./Excel_Comparision_Report/TC_ListMaintenance_Create_New_BrandType" + Constants.timeStamp
							+ ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_ListMaintenance_Create_New_EOBLanguageType()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_ListMaintenance_Create_New_EOBLanguageType");
		if (Utils.getTestCasePreferenceFromInfobank("TC_ListMaintenance_Create_New_EOBLanguageType").equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			XSSFSheet inSheet = Utils.excel_sheet(testData_Path, "BrandType");
			String name = inSheet.getRow(1).getCell(0).getStringCellValue();

			// UI operations
			Actions_Header.clickOnListMaintenanceLink();
			Actions_ListMaintenance.clickOnBrandTypeLink();
			Actions_ListMaintenance.clickOnCreateNewBrandButton();
			Actions_ListMaintenance.enterName(name);
			Actions_ListMaintenance.clickOnCreateBrandButton();
			Actions_ListMaintenance.Alert_Accept();
			
			// Comparison between DB and Search results
			miscellaneous.Excel_Compare_ListMaintenance_BrandType.generateCompareReport(testData_Path,
					"./Excel_Comparision_Report/TC_ListMaintenance_Create_New_BrandType" + Constants.timeStamp
							+ ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

}