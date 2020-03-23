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
import pageObjects.GroupInstall_pageObjects;
import pageObjects.IndividualRxWrapPage;
import utilities.Constants;
import utilities.Utils;

public class Actions_GroupInstall_IndividualRxPage extends BaseClass {

	public Actions_GroupInstall_IndividualRxPage(WebDriver driver) {
		super(driver);
	}

	public static void clickOnInputRxLink() {
		try {
			Thread.sleep(3000);
			Utils.click(GroupInstall_pageObjects.inputRxData_link());
			Constants.test.log(Status.PASS, "Click on InputRx link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on InputRx button");
			Assert.fail("unable to click on InputRx button");
		}
	}
	
	public static void select_contractYear(String option) {
		try {
			GroupInstall_pageObjects.contractYear_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from contract year drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from contract year drop down");
			Assert.fail("failed to select an option from contract year drop down");
		}
	}

	public static void enter_groupNumber(String groupNumber) {
		try {
			GroupInstall_pageObjects.groupNumber_textField().sendKeys(groupNumber);
			Constants.test.log(Status.PASS, "Entering groupNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering groupNumber");
			Assert.fail("failed to enter groupNumber");
		}
	}

	public static void enter_groupName(String groupName) {
		try {
			GroupInstall_pageObjects.groupName_textField().sendKeys(groupName);
			Constants.test.log(Status.PASS, "Entering groupName");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering groupName");
			Assert.fail("failed to Enter groupName");
		}
	}
	
	public static void select_claimsSystem(String option) {
		try {
			GroupInstall_pageObjects.claimsSystem_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from ClaimsSystem drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from ClaimsSystem drop down");
			Assert.fail("failed to select an option from ClaimsSystem drop down");
		}
	}
	
	public static void select_contractNumber(String option) {
		try {
			GroupInstall_pageObjects.contractNumber_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from contractNumber drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from contractNumber drop down");
			Assert.fail("failed to select an option from contractNumber drop down");
		}
	}
	
	public static void select_site(String option) {
		try {
			GroupInstall_pageObjects.site_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from site drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from site drop down");
			Assert.fail("failed to select an option from site drop down");
		}
	}
	
	public static void select_drugCoverageType(String option) {
		try {
			GroupInstall_pageObjects.drugCoverageType_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from drugCoverageType drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from drugCoverageType drop down");
			Assert.fail("failed to select an option from drugCoverageType drop down");
		}
	}
	
	public static void select_effectiveMonth(String option) {
		try {
			GroupInstall_pageObjects.effectiveMonth_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from effectiveMonth drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from effectiveMonth drop down");
			Assert.fail("failed to select an option from effectiveMonth drop down");
		}
	}
	
	public static void select_groupClassification(String option) {
		try {
			GroupInstall_pageObjects.groupClassification_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from groupClassification drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from groupClassification drop down");
			Assert.fail("failed to select an option from groupClassification drop down");
		}
	}
	
	public static void select_groupStatus(String option) {
		try {
			GroupInstall_pageObjects.groupStatus_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from groupStatus drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from groupStatus drop down");
			Assert.fail("failed to select an option from groupStatus drop down");
		}
	}

	public static void enter_PBP(String PBP) {
		try {
			GroupInstall_pageObjects.PBP_textField().sendKeys(PBP);
			Constants.test.log(Status.PASS, "Entering PBP");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering PBP");
			Assert.fail("fail to Enter PBP");
		}
	}

	

	public static void clickOnInputRxDataLink() {
		try {
			Thread.sleep(3000);
			Utils.click(GroupInstall_pageObjects.inputRxData_link());
			Constants.test.log(Status.PASS, "Click on Input Rx Data link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Input Rx Data link");
			Assert.fail("unable to edit on Input Rx Data link");
		}
	}
	
	public static void clickOnInputGroupDataLink() {
		try {
			Thread.sleep(3000);
			Utils.click(GroupInstall_pageObjects.inputGroupData_link());
			Constants.test.log(Status.PASS, "Click on Input Group Data link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Input Group Data link");
			Assert.fail("unable to edit on Input Group Data link");
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
