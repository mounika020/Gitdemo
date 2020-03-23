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

import actions.Actions_ContactPage;
import actions.Actions_GroupInstallPage;
import actions.Actions_GroupInstall_IndividualRxPage;
import actions.Actions_Header;
import actions.Actions_InidividualRxWrapPage;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class ContactUI_Utility extends BeforeAndAfter {

	 String testData_Path = "./src/test/java/testData/ContactTypes.xlsx";

	@Test
	public void Create_Individual_Claims_ContactType()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("Create_Individual_Claims_ContactType");
		if (Utils.getTestCasePreferenceFromInfobank("Create_Individual_Claims_ContactType")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Accessing Test Data sheet
			Sheet inSheet = Utils.excel_sheet(testData_Path, "Ind_Claims");
			String contract = inSheet.getRow(1).getCell(5).getStringCellValue();
			String PBP = inSheet.getRow(1).getCell(6).getStringCellValue();

			// UI operations
			Actions_Header.clickOnContactLink();
			
			Actions_ContactPage.selectGroupType(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_ContactPage.clickOnCreateRule();
			Thread.sleep(5000);
			Actions_ContactPage.selectIncludeIndicator(inSheet.getRow(1).getCell(2).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.selectContactType(inSheet.getRow(1).getCell(3).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.selectRule(inSheet.getRow(1).getCell(4).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.selectContract(inSheet.getRow(1).getCell(5).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.selectPBP(inSheet.getRow(1).getCell(6).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.clickOnSearchPlan();
			Thread.sleep(1000);
			Actions_ContactPage.checkPlanCheckbox(contract,PBP);
			Actions_ContactPage.enterAddress1(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_ContactPage.enterAddress2(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_ContactPage.enterCity(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_ContactPage.selectRuleState(inSheet.getRow(1).getCell(15).getStringCellValue());
			Thread.sleep(1000);
			Actions_ContactPage.enterZip(inSheet.getRow(1).getCell(16).getStringCellValue());
			Actions_ContactPage.enterPhoneNumber(inSheet.getRow(1).getCell(17).getStringCellValue());
			Actions_ContactPage.enterTTY(inSheet.getRow(1).getCell(18).getStringCellValue());
			Actions_ContactPage.enterFax(inSheet.getRow(1).getCell(19).getStringCellValue());
			Actions_ContactPage.enterEmail(inSheet.getRow(1).getCell(20).getStringCellValue());
			Actions_ContactPage.enterWebsite(inSheet.getRow(1).getCell(21).getStringCellValue());
			Actions_ContactPage.enterHours(inSheet.getRow(1).getCell(22).getStringCellValue());
			
//			// Comparison between DB and Search results
//			miscellaneous.Excel_Compare_GroupInstall_DefaultValues.generateCompareReport(
//					testData_Path, "Ind_Claims",
//					"./Excel_Comparision_Report/Create_Individual_Claims_ContactType"
//							+ Constants.timeStamp + ".xlsx");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}


}