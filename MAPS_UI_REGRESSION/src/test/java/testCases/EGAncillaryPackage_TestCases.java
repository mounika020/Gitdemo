package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_EGAncillaryPackagePage;
import actions.Actions_Header;
import miscellaneous.BeforeAndAfter;
import miscellaneous.Excel_Compare_EGAncillaryPackage;
import utilities.Constants;
import utilities.Utils;

public class EGAncillaryPackage_TestCases extends BeforeAndAfter {

	Workbook inWorkbook = null;

	@Test
	public void TC_EGAncillaryPackage_createNewChiroStandardCopay()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewChiroStandardCopay");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewChiroStandardCopay")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"ChiroStandard_Copay");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage.enter_inNetwork_costShare(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_inNetwork_visits(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_inNetwork_vendor(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_chiroAndAcupunctureCombined_dropdown(
					inSheet.getRow(1).getCell(11).getStringCellValue());
			// Actions_EGAncillaryPackagePage.select_outOfNetwork_dropdown(inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_outOfNetwork_visits(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_chiroAndAcupunctureCombined_dropdown(
					inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_CreateNewChiroStandard_Copay_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewChiroStandardCoins()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewChiroStandardCoins");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewChiroStandardCoins")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"ChiroStandard_Coins");
			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage.enter_inNetwork_costShare(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit(inSheet.getRow(1).getCell(6).getStringCellValue());
			// Actions_EGAncillaryPackagePage.enter_inNetwork_visits(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_visits_checkBox();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown(inSheet.getRow(1).getCell(8).getStringCellValue());
			// Actions_EGAncillaryPackagePage.select_outOfNetwork_dropdown(inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_visits_checkBox();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_CreateNewChiroStandard_Coins_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewChiroCustomCopay()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewChiroCustomCopay");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewChiroCustomCopay")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"ChiroCustom_Copay");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage.enter_inNetwork_costShare(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_inNetwork_visits(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_inNetwork_vendor(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_chiroAndAcupunctureCombined_dropdown(
					inSheet.getRow(1).getCell(11).getStringCellValue());
			// Actions_EGAncillaryPackagePage.select_outOfNetwork_dropdown(inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.enter_outOfNetwork_visits(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_chiroAndAcupunctureCombined_dropdown(
					inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewChiroCustom_Copay_" + Constants.timeStamp
							+ ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewChiroCustomCoins()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewChiroCustomCoins");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewChiroCustomCoins")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();

			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"ChiroCustom_Coins");
			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage.enter_inNetwork_costShare(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit(inSheet.getRow(1).getCell(6).getStringCellValue());
			// Actions_EGAncillaryPackagePage.enter_inNetwork_visits(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_visits_checkBox();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown(inSheet.getRow(1).getCell(8).getStringCellValue());
			// Actions_EGAncillaryPackagePage.select_outOfNetwork_dropdown(inSheet.getRow(2).getCell(11).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_visits_checkBox();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewChiroCustom_Coins_" + Constants.timeStamp
							+ ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingStandardCopay_18a1()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingStandardCopay_18a1");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingStandardCopay_18a1")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingStandardCopay_18a1");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a1(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a1(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit_18a1(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_visits_18a1(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a1(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a1(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton_18a1();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a1(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit_18a1(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_visits_18a1(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a1(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a4("Not Included");
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingStandardCopay_18a1_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingStandardCoins_18a1()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingStandardCoins_18a1");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingStandardCoins_18a1")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingStandardCoins_18a1");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a1(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a1(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit_18a1(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_visits_checkBox_18a1();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a1(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a1(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton_18a1();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a1(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit_18a1(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_visits_checkBox_18a1();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a1(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a4("Not Included");
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingStandardCoins_18a1_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingCustomCopay_18a1()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingCustomCopay_18a1");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingCustomCopay_18a1")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingCustomCopay_18a1");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a1(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a1(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit_18a1(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_visits_18a1(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a1(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a1(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton_18a1();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a1(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit_18a1(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_visits_18a1(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a1(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a4("Not Included");
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingCustomCopay_18a1_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingCustomCoins_18a1()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingCustomCoins_18a1");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingCustomCoins_18a1")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingCustomCoins_18a1");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a1(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a1(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxAllowPerVisit_18a1(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_visits_checkBox_18a1();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a1(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a1(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a1(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton_18a1();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a1(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxAllowPerVisit_18a1(inSheet.getRow(2).getCell(6).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_visits_checkBox_18a1();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a1(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a4("Not Included");
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingCustomCoins_18a1_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingStandardCopay_18a4()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingStandardCopay_18a4");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingStandardCopay_18a4")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingStandardCopay_18a4");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a1("Not Included");
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a4(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a4(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxBenAllow_18a4(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_ear_dropdown_18a4(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_devices_18a4(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a4(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a4(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a4(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a4(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxBenAllow_18a4(inSheet.getRow(2).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_ear_dropdown_18a4(inSheet.getRow(2).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_devices_18a4(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a4(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingStandardCopay_18a4_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingStandardCoins_18a4()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingStandardCoins_18a4");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingStandardCoins_18a4")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingStandardCoins_18a4");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a1("Not Included");
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a4(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a4(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxBenAllow_18a4(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_ear_dropdown_18a4(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_devices_checkBox_18a4();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a4(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a4(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a4(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a4(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxBenAllow_18a4(inSheet.getRow(2).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_ear_dropdown_18a4(inSheet.getRow(2).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_devices_checkBox_18a4();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a4(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingStandardCoins_18a4_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingCustomCopay_18a4()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingCustomCopay_18a4");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingCustomCopay_18a4")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingCustomCopay_18a4");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a1("Not Included");
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a4(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCopay_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a4(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxBenAllow_18a4(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_ear_dropdown_18a4(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_devices_18a4(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a4(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a4(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a4(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCopay_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a4(inSheet.getRow(2).getCell(4).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxBenAllow_18a4(inSheet.getRow(2).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_ear_dropdown_18a4(inSheet.getRow(2).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_devices_18a4(inSheet.getRow(2).getCell(7).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a4(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingCustomCopay_18a4_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void TC_EGAncillaryPackage_createNewHearingCustomCoins_18a4()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		// HTML report
		Constants.test = Constants.extent.createTest("TC_EGAncillaryPackage_createNewHearingCustomCoins_18a4");
		if (Utils.getTestCasePreferenceFromInfobank("TC_EGAncillaryPackage_createNewHearingCustomCoins_18a4")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			// Getting input values from IndividualRxWrap_Search
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EGAncillaryPackage.xlsx",
					"HearingCustomCoins_18a4");

			// UI operations
			Actions_Header.clickOnEGAncillaryPackageLink();
			Actions_EGAncillaryPackagePage
					.select_packageType_dropdown(inSheet.getRow(1).getCell(0).getStringCellValue());

			// waiting for Hearing Package UI to load
			Utils.waitForPageToLoad();

			Actions_EGAncillaryPackagePage.clickOnCreateNewPackageButton();
			Actions_EGAncillaryPackagePage.enter_packageNumber(Excel_Compare_EGAncillaryPackage.packageNumber);
			Actions_EGAncillaryPackagePage.clickOnNextButton();
			Actions_EGAncillaryPackagePage.select_benefitOption_dropdown_18a1("Not Included");
			Actions_EGAncillaryPackagePage
					.select_benefitOption_dropdown_18a4(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetworkCoins_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_costShare_18a4(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_maxBenAllow_18a4(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_inNetwork_ear_dropdown_18a4(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_inNetwork_devices_checkBox_18a4();
			Actions_EGAncillaryPackagePage
					.select_inNetwork_periodicity_dropdown_18a4(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_vendor_18a4(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_inNetwork_additionalVendor_18a4(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetworkCoins_radioButton_18a4();
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_costShare_18a4(inSheet.getRow(2).getCell(5).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.enter_outOfNetwork_maxBenAllow_18a4(inSheet.getRow(2).getCell(13).getStringCellValue());
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_ear_dropdown_18a4(inSheet.getRow(2).getCell(12).getStringCellValue());
			Actions_EGAncillaryPackagePage.select_outOfNetwork_devices_checkBox_18a4();
			Actions_EGAncillaryPackagePage
					.select_outOfNetwork_periodicity_dropdown_18a4(inSheet.getRow(2).getCell(8).getStringCellValue());
			Actions_EGAncillaryPackagePage.clickOnCreateButton();
			Thread.sleep(3000);
			Actions_EGAncillaryPackagePage.clickOnAlertOK();

			miscellaneous.Excel_Compare_EGAncillaryPackage.generateCompareReport(
					"./src/test/java/testData/EGAncillaryPackage.xlsx",
					"./Excel_Comparision_Report/TC_EGAncillaryPackage_createNewHearingCustomCoins_18a4_"
							+ Constants.timeStamp + ".xlsx",
					inSheet);

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

}