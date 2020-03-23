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

import actions.Actions_PlanPage;
import miscellaneous.BeforeAndAfter;
import pageObjects.Header;
import utilities.Constants;
import utilities.QueryBank;
import utilities.Utils;

public class Plan_Page_TestCases extends BeforeAndAfter {
	Workbook inWorkbook = null;

	@Test
	public void Plan_SearchTab_AllFields_IndividualPlans()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_SearchTab_AllFields_IndividualPlans");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_SearchTab_AllFields_IndividualPlans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Individual");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.selectStatus(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_PlanPage.enterPlanName(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_PlanPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_PlanPage.selectPlanType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_PlanPage.selectBusinessSegment(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_PlanPage.enterPlanLongName(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_PlanPage.enterPBP(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_PlanPage.selectSNPtype(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_PlanPage.selectBrand(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_PlanPage.selectSplitDelegationIndicator(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_PlanPage.selectClaimsSystems(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_PlanPage.selectAARP(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_PlanPage.selectPlanPCPrequired(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.compareUIsearchResutlsWithDatabase(
					Constants.Input_SQLS.getRow(4).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Plan/Plan_SearchTab_AllFields.xlsx", "Individual");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_SearchTab_AllFields_EmployerGroupPlans()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_SearchTab_AllFields_EmployerGroupPlans");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("Plan_SearchTab_AllFields_EmployerGroupPlans")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Employer");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.selectStatus(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_PlanPage.enterPlanName(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_PlanPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_PlanPage.selectPlanType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_PlanPage.selectBusinessSegment(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_PlanPage.enterPlanLongName(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_PlanPage.enterPBP(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_PlanPage.selectSNPtype(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_PlanPage.selectBrand(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_PlanPage.selectSplitDelegationIndicator(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_PlanPage.selectClaimsSystems(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_PlanPage.selectAARP(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_PlanPage.selectPlanPCPrequired(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.compareUIsearchResutlsWithDatabase(
					Constants.Input_SQLS.getRow(4).getCell(1).getStringCellValue(),
					"./src/test/java/testData/Plan/Plan_SearchTab_AllFields.xlsx", "Employer");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_SearchTab_AllFields_ManagedPlans() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_SearchTab_AllFields_ManagedPlans");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_SearchTab_AllFields_ManagedPlans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Managed");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.selectStatus(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_PlanPage.enterPlanName(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_PlanPage.enterContract(inSheet.getRow(1).getCell(4).getStringCellValue());
			Actions_PlanPage.selectPlanType(inSheet.getRow(1).getCell(5).getStringCellValue());
			Actions_PlanPage.selectBusinessSegment(inSheet.getRow(1).getCell(6).getStringCellValue());
			Actions_PlanPage.enterPlanLongName(inSheet.getRow(1).getCell(7).getStringCellValue());
			Actions_PlanPage.enterPBP(inSheet.getRow(1).getCell(8).getStringCellValue());
			Actions_PlanPage.selectSNPtype(inSheet.getRow(1).getCell(9).getStringCellValue());
			Actions_PlanPage.selectBrand(inSheet.getRow(1).getCell(10).getStringCellValue());
			Actions_PlanPage.selectSplitDelegationIndicator(inSheet.getRow(1).getCell(11).getStringCellValue());
			Actions_PlanPage.selectClaimsSystems(inSheet.getRow(1).getCell(12).getStringCellValue());
			Actions_PlanPage.selectAARP(inSheet.getRow(1).getCell(13).getStringCellValue());
			Actions_PlanPage.selectPlanPCPrequired(inSheet.getRow(1).getCell(14).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Update_Multiple_Individual_Plans() throws InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_Multiple_Individual_Plans");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_Multiple_Individual_Plans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Multiple_Individual");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.select_checkbox(inSheet.getRow(1).getCell(0).getStringCellValue(),
					inSheet.getRow(1).getCell(2).getStringCellValue(),
					inSheet.getRow(1).getCell(3).getStringCellValue());
			Thread.sleep(2000);
			Actions_PlanPage.select_checkbox(inSheet.getRow(2).getCell(0).getStringCellValue(),
					inSheet.getRow(2).getCell(2).getStringCellValue(),
					inSheet.getRow(2).getCell(3).getStringCellValue());
			Actions_PlanPage.clickOnMassDataUpdateButton();
			Assert.fail("Update fields coding part is pending");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipped test case");
		}
	}

	@Test
	public void Plan_Update_Multiple_EG_Plans() throws InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_Multiple_EG_Plans");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_Multiple_EG_Plans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Multiple_Employer");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.select_checkbox(inSheet.getRow(1).getCell(0).getStringCellValue(),
					inSheet.getRow(1).getCell(2).getStringCellValue(),
					inSheet.getRow(1).getCell(3).getStringCellValue());
			Thread.sleep(2000);
			Actions_PlanPage.select_checkbox(inSheet.getRow(2).getCell(0).getStringCellValue(),
					inSheet.getRow(2).getCell(2).getStringCellValue(),
					inSheet.getRow(2).getCell(3).getStringCellValue());
			Actions_PlanPage.clickOnMassDataUpdateButton();
			Assert.fail("Update fields coding part is pending");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipped this test case");
		}
	}

	@Test
	public void Plan_Update_Single_Individual_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_Single_Individual_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_Single_Individual_Plan").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.enterContract(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_PlanPage.enterPBP(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.clickOnEditRecordLink(inSheet.getRow(1).getCell(0).getStringCellValue(),
					inSheet.getRow(1).getCell(2).getStringCellValue(),
					inSheet.getRow(1).getCell(3).getStringCellValue());
			Assert.fail("Update fields coding part is pending");
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Update_Single_EG_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_Single_EG_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_Single_EG_Plan").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("./src/test/java/testData/plan/Plan_SearchTab_AllFields.xlsx");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Employer");

			// test steps
			Utils.click(Header.plan_link());
			Actions_PlanPage.selectPlanYear(inSheet.getRow(1).getCell(0).getStringCellValue());
			Actions_PlanPage.selectCategory(inSheet.getRow(1).getCell(1).getStringCellValue());
			Actions_PlanPage.enterContract(inSheet.getRow(1).getCell(2).getStringCellValue());
			Actions_PlanPage.enterPBP(inSheet.getRow(1).getCell(3).getStringCellValue());
			Actions_PlanPage.clickOnSearchPlansButton();
			Actions_PlanPage.clickOnEditRecordLink(inSheet.getRow(1).getCell(0).getStringCellValue(),
					inSheet.getRow(1).getCell(2).getStringCellValue(),
					inSheet.getRow(1).getCell(3).getStringCellValue());
			Assert.fail("Update fields coding part is pending");

		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Update_MakeSelectedItemsPublic_Individual_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_MakeSelectedItemsPublic_Individual_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_MakeSelectedItemsPublic_Individual_Plan")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Update_MakeSelectedItemsSecure_EG_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Update_MakeSelectedItemsPublic_EG_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Update_MakeSelectedItemsPublic_EG_Plan")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Delete_Individual_Plans() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Delete_Individual_Plans");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Delete_Individual_Plans").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Delete_EG_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Delete_EG_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Delete_EG_Plan").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

	@Test
	public void Plan_Delete_Managed_Plan() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("Plan_Delete_Managed_Plan");

		if (Utils.getTestCasePreferenceFromInfobank("Plan_Delete_Managed_Plan").equalsIgnoreCase("Y")) {
			initiateBrowser();
			FileInputStream input_Excel;
			try {
				input_Excel = new FileInputStream("");
				inWorkbook = new XSSFWorkbook(input_Excel);
			} catch (FileNotFoundException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			} catch (IOException e) {
				Constants.test.log(Status.FAIL, "Input/test file not found");
				Assert.fail();
			}
			Sheet inSheet = inWorkbook.getSheet("Update_Single_Individual");

			// test steps
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}

}
