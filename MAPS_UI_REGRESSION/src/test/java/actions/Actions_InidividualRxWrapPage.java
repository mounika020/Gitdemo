package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.IndividualRxWrapPage;
import utilities.Constants;
import utilities.Utils;

public class Actions_InidividualRxWrapPage extends BaseClass {

	public Actions_InidividualRxWrapPage(WebDriver driver) {
		super(driver);
	}

	public static void select_planYear(String option) {
		try {
			IndividualRxWrapPage.planYear_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from plan year drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from plan year drop down");
			Assert.fail("failed to select an option from plan year drop down");
		}
	}

	public static void enter_groupNumber(String groupNumber) {
		try {
			IndividualRxWrapPage.groupNumber_textField().sendKeys(groupNumber);
			Constants.test.log(Status.PASS, "Entering groupNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering groupNumber");
			Assert.fail("failed to enter groupNumber");
		}
	}

	public static void enter_DURKey(String DURKey) {
		try {
			IndividualRxWrapPage.DURKey_textField().sendKeys(DURKey);
			Constants.test.log(Status.PASS, "Entering DURKey");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering DURKey");
			Assert.fail("failed to Enter DURKey");
		}
	}

	public static void enter_contractNumber(String contractNumber) {
		try {
			IndividualRxWrapPage.contractNumber_textField().sendKeys(contractNumber);
			Constants.test.log(Status.PASS, "Entering contractNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering contractNumber");
			Assert.fail("fail to Enter contractNumber");
		}
	}

	public static void enter_groupEffectiveDate(String groupEffectiveDate) {
		try {
			IndividualRxWrapPage.groupEffectiveDate_textField().sendKeys(groupEffectiveDate);
			Constants.test.log(Status.PASS, "Entering groupEffectiveDate");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering groupEffectiveDate");
			Assert.fail("fail to Enter groupEffectiveDate");
		}
	}

	public static void enter_internalBIN(String internalBIN) {
		try {
			IndividualRxWrapPage.internalBIN_textField().sendKeys(internalBIN);
			Constants.test.log(Status.PASS, "Entering internalBIN");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalBIN");
			Assert.fail("fail to Enter internalBIN");
		}
	}

	public static void enter_PBPNumber(String PBPNumber) {
		try {
			IndividualRxWrapPage.PBPNumber_textField().sendKeys(PBPNumber);
			Constants.test.log(Status.PASS, "Entering PBPNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering PBPNumber");
			Assert.fail("fail to Enter PBPNumber");
		}
	}

	public static void enter_groupTerminationDate(String groupTerminationDate) {
		try {
			IndividualRxWrapPage.groupTerminationDate_textField().sendKeys(groupTerminationDate);
			Constants.test.log(Status.PASS, "Entering groupTerminationDate");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering groupTerminationDate");
			Assert.fail("fail to Enter groupTerminationDate");
		}
	}

	public static void enter_internalPCN(String internalPCN) {
		try {
			IndividualRxWrapPage.internalPCN_textField().sendKeys(internalPCN);
			Constants.test.log(Status.PASS, "Entering internalPCN");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalPCN");
			Assert.fail("fail to Enter internalPCN");
		}
	}

	public static void enter_masterGroupNumber(String masterGroupNumber) {
		try {
			IndividualRxWrapPage.masterGroupNumber_textField().sendKeys(masterGroupNumber);
			Constants.test.log(Status.PASS, "Entering masterGroupNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering masterGroupNumber");
			Assert.fail("fail to Enter masterGroupNumber");
		}
	}

	public static void select_supplementTypeCode(String option) {
		try {
			IndividualRxWrapPage.supplementTypeCode_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from supplementTypeCode drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from supplementTypeCode drop down");
			Assert.fail("failed to select an option from supplementTypeCode drop down");
		}
	}

	public static void enter_individualRxGroup(String internalRxGroup) {
		try {
			IndividualRxWrapPage.internalRxGroup_textField().sendKeys(internalRxGroup);
			Constants.test.log(Status.PASS, "Entering internalRxGroup");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalRxGroup");
			Assert.fail("fail to Enter internalRxGroup");
		}
	}

	public static void clickOnSearchButton() {
		try {
			Thread.sleep(3000);
			Utils.click(IndividualRxWrapPage.search_button());
			Constants.test.log(Status.PASS, "Click on search button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on search button");
			Assert.fail("unable to click on search button");
		}
	}

	public static void clickOnEditLink() {
		try {
			Thread.sleep(3000);
			Utils.click(IndividualRxWrapPage.edit_link());
			Constants.test.log(Status.PASS, "Click on edit button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on edit button");
			Assert.fail("unable to edit on search button");
		}
	}

	public static void edit_supplementTypeCode_checkbox() {
		try {
			Thread.sleep(3000);
			Utils.click(IndividualRxWrapPage.edit_supplementTypeCode_checkbox());
			Constants.test.log(Status.PASS, "Click on supplementTypeCode checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on supplementTypeCode checkbox");
			Assert.fail("unable to click on supplementTypeCode checkbox");
		}
	}

	public static void edit_select_supplementTypeCode(String option) {
		try {
			IndividualRxWrapPage.edit_supplementTypeCode_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from supplementTypeCode drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from supplementTypeCode drop down");
			Assert.fail("failed to select an option from supplementTypeCode drop down");
		}
	}

	public static void edit_DURKey_checkbox() {
		try {
			Utils.click(IndividualRxWrapPage.edit_DURKey_checkbox());
			Constants.test.log(Status.PASS, "Click on DURKey checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on DURKey checkbox");
			Assert.fail("unable to click on DURKey checkbox");
		}
	}

	public static void edit_DURKey(String DURKey) {
		try {
			IndividualRxWrapPage.edit_DURKey_textField().clear();
			IndividualRxWrapPage.edit_DURKey_textField().sendKeys(DURKey);
			Constants.test.log(Status.PASS, "Entering DURKey");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering DURKey");
			Assert.fail("failed to Enter DURKey");
		}
	}

	public static void edit_internalBIN_checkbox() {
		try {
			Utils.click(IndividualRxWrapPage.edit_internalBIN_checkbox());
			Constants.test.log(Status.PASS, "Click on internalBIN checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on internalBIN checkbox");
			Assert.fail("unable to click on internalBIN checkbox");
		}
	}

	public static void edit_internalBIN(String internalBIN) {
		try {
			IndividualRxWrapPage.edit_internalBIN_textField().clear();
			IndividualRxWrapPage.edit_internalBIN_textField().sendKeys(internalBIN);
			Constants.test.log(Status.PASS, "Entering internalBIN");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalBIN");
			Assert.fail("fail to Enter internalBIN");
		}
	}

	public static void edit_internalPCN_checkbox() {
		try {
			Utils.click(IndividualRxWrapPage.edit_internalPCN_checkbox());
			Constants.test.log(Status.PASS, "Click on internalPCN checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on internalPCN checkbox");
			Assert.fail("unable to click on internalPCN checkbox");
		}
	}

	public static void edit_internalPCN(String internalPCN) {
		try {
			IndividualRxWrapPage.edit_internalPCN_textField().clear();
			IndividualRxWrapPage.edit_internalPCN_textField().sendKeys(internalPCN);
			Constants.test.log(Status.PASS, "Entering internalPCN");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalPCN");
			Assert.fail("fail to Enter internalPCN");
		}
	}

	public static void edit_internalRxGroup_checkbox() {
		try {
			Utils.click(IndividualRxWrapPage.edit_internalRxGroup_checkbox());
			Constants.test.log(Status.PASS, "Click on internalRxGroup checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on internalRxGroup checkbox");
			Assert.fail("unable to click on internalRxGroup checkbox");
		}
	}

	public static void edit_internalRxGroup(String internalRxGroup) {
		try {
			IndividualRxWrapPage.edit_internalRxGroup_textField().clear();
			IndividualRxWrapPage.edit_internalRxGroup_textField().sendKeys(internalRxGroup);
			Constants.test.log(Status.PASS, "Entering internalRxGroup");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering internalRxGroup");
			Assert.fail("fail to Enter internalRxGroup");
		}
	}

	public static void clickOnEditUpdateButton() {
		try {
			IndividualRxWrapPage.edit_update_button().click();
			Constants.test.log(Status.PASS, "Click on search button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on search button");
			Assert.fail("unable to click on search button");
		}
	}

	public static void clickOnAlertOK() {
		try {
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Constants.test.log(Status.PASS, "Click on OK");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on OK");
			Assert.fail("unable to click on OK");
		}
	}

	public static void clickOnAlertCancel() {
		try {
			Thread.sleep(1000);
			driver.switchTo().alert().dismiss();
			Constants.test.log(Status.PASS, "Click on Cancel");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Cancel");
			Assert.fail("unable to click on Cancel");
		}
	}

	public static void clickOnEditCancelLink() {
		try {
			Thread.sleep(3000);
			Utils.click(IndividualRxWrapPage.edit_Cancel_link());
			Constants.test.log(Status.PASS, "Click on edit_Cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on edit_Cancel button");
			Assert.fail("unable to edit_Cancel button");
		}
	}

	public static String getRecordCount() {
		String count = null;
		try {
			count = IndividualRxWrapPage.records_Count().getText();
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Reading Records Count");
			Assert.fail("Unable to count the UI search results rows");
		}
		return count;
	}

	public static void compareSearchResultWithDBvalues()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// try {
		Thread.sleep(3000);

		// Accessing Input data file
		File file = new File((String) "./src/test/java/testData/IndividualRxWrap_Search.xlsx");
		FileInputStream input_Excel = new FileInputStream(file);
		XSSFWorkbook input_Workbook = new XSSFWorkbook(input_Excel);
		XSSFSheet input_Sheet = input_Workbook.getSheet("Sheet1");

		// passing arguments from input data sheet to query
		String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", input_Sheet.getRow(1).getCell(0).getStringCellValue());
		QEREY = QEREY.replace("parameter2", input_Sheet.getRow(1).getCell(1).getStringCellValue());

		// Connecting to Database using method created in Utils package
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBresult = new LinkedHashMap<String, String>();

		// Iterating loop to store DB results in DBresult
		for (int i = 0; Constants.resultset.next(); i++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresult.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}

		// Comparing DB values with UI values
		List<String> DB_results = new ArrayList<String>(DBresult.values());
		for (int i = 0; i < DB_results.size(); i++) {
			String UI_results = driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr/td")).get(i).getText();
			if (DB_results.get(i) == null) {
				DB_results.set(i, "null");
			}
			if (driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr/td")).get(i).getText().isEmpty()) {
				UI_results = "null";
			}
			if (UI_results.toString().trim().toUpperCase().equals(DB_results.get(i).toUpperCase().trim().toString())) {
				System.out.println(UI_results.toString());
				System.out.println(DB_results.get(i));
				Constants.test.log(Status.PASS, "compare search results with DB values");
				Assert.assertTrue(true);
			} else {
				Constants.test.log(Status.FAIL, "compare search results with DB values");
				Assert.assertTrue(false);
			}
		}
		input_Workbook.close();
		// } catch (Exception e) {
		// Constants.test.log(Status.FAIL, "compare search results with DB
		// values");
		// Assert.fail("failed to compare search results with DB values");
		// }
	}

	public static void compareDBrecordsCountWithUIsearchResultsCount() throws SQLException {
		String count = null;
		try {
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(Constants.Input_SQLS.getRow(6).getCell(1)
					.getStringCellValue().replace("parameter1", "2017").replace("parameter2", "H0543"));
			if (Constants.resultset.next()) {
				count = Constants.resultset.getString(1);
			}
			Assert.assertTrue(count.equalsIgnoreCase(getRecordCount()));
			Constants.test.log(Status.PASS, "Compare DB records count with UI search results rows count"
					+ "</br> DB Records Count: " + count + "</br> UI Search results count: " + getRecordCount());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Compare DB records count with UI search results rows count"
					+ "</br> DB Records Count: " + count + "</br> UI Search results count: " + getRecordCount());
		}
	}
}
