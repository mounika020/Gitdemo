package actions;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.PlanPage;
import utilities.Constants;
import utilities.Utils;

public class Actions_PlanPage extends BaseClass {

	public Actions_PlanPage(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void selectPlanYear(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanYear').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				PlanPage.year_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select plan year");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select plan year");
			Assert.fail("failed to select an option from plan year dropdown");
		}
	}

	public static void selectCategory(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Category').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select category");
			} else {
				PlanPage.category_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select category");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select category");
			Assert.fail("failed to select an optoin from category dropdown");
		}
	}

	public static void selectStatus(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				PlanPage.status_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void enterPlanName(String planName) {
		try {
			if (planName.equalsIgnoreCase("null")) {
				PlanPage.planName_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter plan name");
			} else {
				PlanPage.planName_textField().sendKeys(planName);
				Constants.test.log(Status.PASS, "enter plan name");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter plan name");
			Assert.fail("failed to enter value in plan name text field");
		}
	}

	public static void enterContract(String cntract) {
		try {
			if (cntract.equalsIgnoreCase("null")) {
				PlanPage.planName_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter contract");
			} else {
				PlanPage.contract_textField().sendKeys(cntract);
				Constants.test.log(Status.PASS, "enter contract");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter contract");
			Assert.fail("failed to enter value in contract text field");
		}
	}

	public static void selectPlanType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan type");
			} else {
				PlanPage.planType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select plan type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select plan type");
			Assert.fail("failed to select an optoin from plan type dropdown");
		}
	}

	public static void selectBusinessSegment(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('BusinessSegment').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select bus segment");
			} else {
				PlanPage.businessSegment_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select bus segment");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select bus segment");
			Assert.fail("failed to select an optoin from business segment dropdown");
		}
	}

	public static void enterPlanLongName(String planLongName) {
		try {
			if (planLongName.equalsIgnoreCase("null")) {
				PlanPage.planName_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter plan long name");
			} else {
				PlanPage.planLongName_textField().sendKeys(planLongName);
				Constants.test.log(Status.PASS, "enter plan long name");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter plan long name");
			Assert.fail("failed to enter value in plan long name text field");
		}
	}

	public static void enterPBP(String planLongName) {
		try {
			if (planLongName.equalsIgnoreCase("null")) {
				PlanPage.planName_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter PBP number");
			} else {
				PlanPage.PBP_textField().sendKeys(planLongName);
				Constants.test.log(Status.PASS, "enter PBP number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter PBP number");
			Assert.fail("failed to enter value in PBP text field");
		}
	}

	public static void selectSNPtype(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SNPType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select SNP type");
			} else {
				PlanPage.SNPtype_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select SNP type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select SNP type");
			Assert.fail("failed to select an optoin from SNP type dropdown");
		}
	}

	public static void selectBrand(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Brand').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select brand");
			} else {
				PlanPage.brand_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select brand");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select brand");
			Assert.fail("failed to select an optoin from brand dropdown");
		}
	}

	public static void selectSplitDelegationIndicator(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('SplitDelegationValue').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select split delegation indicator");
			} else {
				PlanPage.splitDelegationIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select split delegation indicator");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select split delegation indicator");
			Assert.fail("failed to select an optoin from split delegation indicator dropdown");
		}
	}

	public static void selectClaimsSystems(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SourceSystem').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select claims system");
			} else {
				PlanPage.claimSystems_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select claims system");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select claims system");
			Assert.fail("failed to select an optoin from claims system dropdown");
		}
	}

	public static void selectAARP(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('AARPValue').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select AARP");
			} else {
				PlanPage.AARP_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select AARP");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select AARP");
			Assert.fail("failed to select an optoin from AARP dropdown");
		}
	}

	public static void selectPlanPCPrequired(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('PlanPCPRequiredValue').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan PCP required");
			} else {
				PlanPage.planPCPrequired_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select plan PCP required");
			}
			PlanPage.planPCPrequired_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select plan PCP required");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select plan PCP required");
			Assert.fail("failed to select an optoin from plan PCP required dropdown");
		}
	}

	public static void clickOnSearchPlansButton() {
		try {
			Utils.click(PlanPage.searchPlans_button());
			Constants.test.log(Status.PASS, "click on search plans button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search plans button");
			Assert.fail("failed to click on search plans button");
		}
	}

	public static void clickOnDeleteSelectedItemsButton(String option) {
		try {
			Utils.click(PlanPage.deleteSelectedItems_button());
			Constants.test.log(Status.PASS, "click on delete selected items button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on delete selected items button");
			Assert.fail("failed to click on delete selected items button");
		}
	}

	public static void clickOnMakeSelectedItemsPublicButton(String option) {
		try {
			Utils.click(PlanPage.makeSelectedItemPublic_button());
			Constants.test.log(Status.PASS, "click on make selected items public button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on make selected items public button");
			Assert.fail("failed to click on make selected items public button");
		}
	}

	public static void clickOnMakeSelectedItemsSecureButton(String option) {
		try {
			Utils.click(PlanPage.makeSelectedItemSecure_button());
			Constants.test.log(Status.PASS, "click on make selected items secure button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on make selected items secure button");
			Assert.fail("failed to click on make selected items secure button");
		}
	}

	public static void clickOnMassDataUpdateButton() {
		try {
			Utils.click(PlanPage.massDetaUpdate_button());
			Constants.test.log(Status.PASS, "click on mass data update button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on mass data update button");
			Assert.fail("failed to click on mass data update button");
		}
	}

	public static void clickOnEditRecordLink(String year, String contract, String PBP) {
		try {
			Utils.click(PlanPage.EditRecord_forSelectedPlan_link(year, contract, PBP));
			Constants.test.log(Status.PASS, "click on edit link for selected plan");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on edit link for selected plan");
			Assert.fail("failed to click on edit link for selected plan");
		}
	}

	public static void select_checkbox(String year, String contract, String PBP) {
		try {
			System.out.println("//td[contains(.,'Year/Contract/PBP: " + year + " - " + contract + " - " + PBP
					+ "')]/preceding-sibling::td/input[@type='checkbox']");
			Utils.click(PlanPage.checkbox_forSelectedPlan(year, contract, PBP));
			// PlanPage.checkbox_forSelectedPlan(year, contract, PBP).click();
			System.out.println("success");
			Constants.test.log(Status.PASS, "selecting checkbox for selected plan");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting checkbox for selected plan");
			Assert.fail("failed to select checkbox for selected plan");
		}
	}

	public static void clickOnSubmitRecordsButton_makePublic() {
		try {
			Utils.click(PlanPage.submitRecords_makePublic_button());
			Constants.test.log(Status.PASS, "click on submit records button to make public");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on submit records button to make public");
			Assert.fail("failed to click on submit records button to make public");
		}
	}

	public static void compareUIsearchResutlsWithDatabase_employer() {
		try {
			XSSFSheet sheet = Utils.excel_sheet("./src/test/java/testData/Plan/Plan_SearchTab_AllFields.xlsx",
					"Individual");
			String QEREY = Constants.Input_SQLS.getRow(4).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(1).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(1).getCell(0).getStringCellValue());
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int i = 0; i < Constants.resultsetMetadata.getColumnCount(); i++) {
				DBresults.put(Constants.resultsetMetadata.getColumnName(i), Constants.resultset.getString(i));
			}
			System.out.println(Constants.resultset);
			Assert.assertTrue(PlanPage.serchResult_noOf_rows() == 1);
			Assert.assertTrue(driver.getPageSource().contains("2017 - H0251 - 002"));
			Assert.assertTrue(driver.getPageSource().contains("UnitedHealthcare Dual Complete (HMO SNP)"));
			Constants.test.log(Status.PASS, "compare UI search results with database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareUIsearchResutlsWithDatabase(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(1).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(1).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				Assert.assertTrue(PlanPage.serchResult_noOf_rows() == 1);
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(driver.getPageSource().contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
}
