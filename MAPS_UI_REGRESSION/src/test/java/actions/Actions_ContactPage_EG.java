package actions;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.omg.CORBA.BooleanSeqHolder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import ch.lambdaj.function.convert.ConstructorArgumentConverter;
import freemarker.core.CollectionAndSequence;
import miscellaneous.BaseClass;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;
import pageObjects.ContactPage;
import pageObjects.ContactPage_EG;
import testCases.Contact_Page_EG_testCases;
import utilities.Constants;
import utilities.Utils;

public class Actions_ContactPage_EG extends BaseClass {
public static ArrayList<String> arrList = new ArrayList<String>();
	
	public Actions_ContactPage_EG(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void selectGroupType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('GroupType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Group Type");
			} else {
				ContactPage_EG.GroupType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Group Type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select category");
			Assert.fail("failed to select an optoin from Group Type dropdown");
		}
	}

	public static void clickOnCreateRuleButton() {
		try {
			ContactPage.createRule_button().click();
			Constants.test.log(Status.PASS, "click on Create Rule button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Create Rule button");
			Assert.fail("failed to click on Create Rule button");
		}
	}
	
	public static void clickOnsaveButton_AddressScreen() {
		try {
			ContactPage_EG.SaveButton_UpdateScreen().click();
			Constants.test.log(Status.PASS, "click on save button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on save button");
			Assert.fail("failed to click save button");
		}
	}
	public static void clickOnsaveButton_CreateScreen() {
		try {
			ContactPage_EG.SaveButton_CreateNewGL().click();
			Constants.test.log(Status.PASS, "click on save button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on save button");
			Assert.fail("failed to click save button");
		}
	}
	
	public static void selectallIncludeIndicator() {
		try {
			Constants.test.log(Status.PASS, "select Contact Type");
			List<WebElement> contactTypeOptions = ContactPage_EG.IncludeIndicator_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				ContactPage_EG.IncludeIndicator_dropdown().selectByVisibleText(item.getText());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectallIncludeIndicator();
			}
			Constants.test.log(Status.PASS, "All values selected for Contact Type Dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void selectAllContactType() {
		try {
			Constants.test.log(Status.PASS, "select Contact Type");
			List<WebElement> contactTypeOptions = ContactPage_EG.ContactType_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				ContactPage_EG.ContactType_dropdown().selectByVisibleText(item.getText());
				Thread.sleep(2000);
				Actions_ContactPage_EG.selectAllContactType();
			}
			Constants.test.log(Status.PASS, "All values selected for Contact Type Dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void selectAllRuleType() {
		try {
			Constants.test.log(Status.PASS, "select status");
			List<WebElement> ruleTypeOptions = ContactPage_EG.RuleType_dropdown().getOptions();
			for (WebElement rule : ruleTypeOptions) {
				ContactPage_EG.RuleType_dropdown().selectByVisibleText(rule.getText());
			}
			Constants.test.log(Status.PASS, "All values selected for Rule Type Dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an option from Rule dropdown");
		}
	}

	public static void compareContactTypeWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol, String GroupType)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue())
					.replace("parameter2", GroupType);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.ContactType_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}

			}
			Constants.test.log(Status.PASS, "compare UI search results with database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void selectIncludeIndicator(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('IncludeIndicator').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				ContactPage_EG.IncludeIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Include Indicator");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Include Indicator");
			Assert.fail("failed to select an option from Include Indicator dropdown");
		}
	}

	public static void selectContactType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				//WebDriverWait wait=new WebDriverWait(driver, 20);
				//ContactPage_EG.ContactType_dropdown().deselectAll();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				ContactPage_EG.ContactType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from Contact Type dropdown");
		}
	}	
	public static void selectContactType_byValue(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				ContactPage_EG.ContactType_dropdown().selectByValue(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from Contact Type dropdown");
		}
	}
	
	public static void compareContactContractWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.ContractRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareContactPBPWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.PBPRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareContactPlanNameWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.PlanNameRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareContactBrandWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.BrandRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void selectContractDropdown(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('ContractNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Contract Number");
			} else {
				ContactPage_EG.Contract_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Contract Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Contract Number");
			Assert.fail("failed to select an option from Contract Number dropdown");
		}
	}

	public static void selectPlanNameRule(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Plan Name').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan Name");
			} else {
				ContactPage_EG.PlanNameRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Plan Name");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Plan Name");
			Assert.fail("failed to select an option from Plan Name dropdown");
		}
	}

	public static void selectPlanYear(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanYear').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				ContactPage_EG.year_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select plan year");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select plan year");
			Assert.fail("failed to select an option from plan year dropdown");
		}
	}

	public static void selectRuleType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('ContactRuleType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				ContactPage_EG.RuleType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from Rule Type dropdown");
		}
	}

	public static void selectContractRule(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('ContractNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Contract Number year");
			} else {
				ContactPage_EG.ContractRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Contract Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Contract Number");
			Assert.fail("failed to select an option from Contract Number dropdown");
		}
	}

	public static void enterContractNumber(String cntract) {
		try {
			if (cntract.equalsIgnoreCase("null")) {
				ContactPage_EG.contract_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter contract");
			} else {
				ContactPage_EG.contract_textField().sendKeys(cntract);
				Constants.test.log(Status.PASS, "enter contract");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter contract");
			Assert.fail("failed to enter value in contract text field");
		}
	}

	public static void clickOnSearchContactsButton() {
		try {
			ContactPage_EG.searchContact_button().click();
			Constants.test.log(Status.PASS, "click on search Contact button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search Contact button");
			Assert.fail("failed to click on search Contact button");
		}
	}

	public static void ResultNotfoungMessage() {
		try {
			if (ContactPage_EG.ResultNotFound().getText().equalsIgnoreCase("There is no data available.")) {
				Constants.test.log(Status.PASS, "Result Text is valid");
			} else {
				Assert.fail("Result text is not valid");
				Constants.test.log(Status.PASS, "Result is not as expected");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Result Text is not valid");
			Assert.fail("failed to validate the Result Text Expected");
		}
	}

	public static void compareContactbase(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(17).getCell(4).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter3", sheet.getRow(1).getCell(3).getStringCellValue());
			QEREY = QEREY.replace("parameter4", sheet.getRow(17).getCell(1).getStringCellValue());

			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			if (Constants.resultset.equals(null)) {

			}
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.ContactType_dropdown().getOptions();

			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareIncludeIndicatorWithDatabase(String Query, String inputFileName, String sheetName,
			Integer parameterCol) throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.IncludeIndicator_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareRuleTypeWithDatabase(String Query, String inputFileName, String sheetName,
			Integer rowNum1, Integer parameterCol1, Integer rowNum2, Integer parameterCol2)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(rowNum1).getCell(parameterCol1).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(rowNum2).getCell(parameterCol2).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.RuleType_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareBrandWithDatabase(String Query)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {

			String QEREY = Query;
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.BrandRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare BrandUI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare BrandUI search results with database");
			Assert.fail("failed to compare BrandUI results with database");
		}
	}

	public static void compareBusinessSegmentWithDatabase(String Query)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {

			String QEREY = Query;
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.BusinessSegmentRule_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare Business Segment UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare Business Segment UI search results with database");
			Assert.fail("failed to compare Business Segment UI results with database");
		}
	}

	public static void clickOnSearchPlans() {
		try {
			ContactPage_EG.SearchPlans_button().click();
			Constants.test.log(Status.PASS, "click on Search Plans button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Plans button");
			Assert.fail("failed to click on Search Plans button");
		}
	}

	public static void selectPlanCheckBox() {
		try {
			Utils.click(ContactPage_EG.selectPlanCheckBox());
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	}
	public static void selectPlanCheckBox_resultGrid() {
		try {
			Utils.click(ContactPage_EG.CheckBox_ResultGrid(1));
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	}
	
	public static void selectCheckBoxCreateNewRule() {
		try {
			Utils.click(ContactPage_EG.CheckBox_CreateNewresultpage(1));
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	} 
	public static void enterContactTypeLabel(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.enterContactTypeLabel_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Email");
			} else {
				ContactPage_EG.enterContactTypeLabel_textField().clear();
				ContactPage_EG.enterContactTypeLabel_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Email");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Contact Type Label");
			Assert.fail("failed to enter value in Contact Type Label text field");
		}
	}

	public static void enterAddress1(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.Address1_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address1");
			} else {
				ContactPage_EG.Address1_textField().clear();
				ContactPage_EG.Address1_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Address1");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address1");
			Assert.fail("failed to enter value in Address1 text field");
		}
	}

	public static void enterAddress2(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {

				ContactPage_EG.Address2_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address2");
			} else {
				ContactPage_EG.Address2_textField().clear();
				ContactPage_EG.Address2_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Address2");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address2");
			Assert.fail("failed to enter value in Address2 text field");
		}
	}

	public static void enterCity(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.City_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter City");
			} else {
				ContactPage_EG.City_textField().clear();
				ContactPage_EG.City_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter city");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter city");
			Assert.fail("failed to enter value in city text field");
		}
	}

	public static void selectState(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('GroupType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select State");
			} else {
				
				//ContactPage_EG.State_dropdown().deselectAll();
				ContactPage_EG.State_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select State");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select State");
			Assert.fail("failed to select an optoin from State dropdown");
		}
	}

	public static void enterZipCode(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.ZipCode_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Zipcode");
			} else {
				ContactPage_EG.ZipCode_textField().clear();
				ContactPage_EG.ZipCode_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Zipcode");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter ZipCode");
			Assert.fail("failed to enter value in Zipcode text field");
		}
	}

	public static void enterPhone(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.Phone_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter phone");
			} else {
				ContactPage_EG.Phone_textField().clear();
				ContactPage_EG.Phone_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Phone");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Phone");
			Assert.fail("failed to enter value in Phone text field");
		}
	}

	public static void enterTTY(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.TTY_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter TTY");
			} else {
				ContactPage_EG.TTY_textField().clear();
				ContactPage_EG.TTY_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter TTY");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter TTY");
			Assert.fail("failed to enter value in TTY text field");
		}
	}

	public static void enterFax(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.Fax_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Fax");
			} else {
				ContactPage_EG.Fax_textField().clear();
				ContactPage_EG.Fax_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Fax");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Fax");
			Assert.fail("failed to enter value in Fax text field");
		}
	}

	public static void enterEmail(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.Email_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Email");
			} else {
				ContactPage_EG.Email_textField().clear();
				ContactPage_EG.Email_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Email");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Email");
			Assert.fail("failed to enter value in Email text field");
		}
	}

	public static void enterWebSite(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.WebSite_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter WebSite");
			} else {
				ContactPage_EG.WebSite_textField().clear();
				ContactPage_EG.WebSite_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter WebSite");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter WebSite");
			Assert.fail("failed to enter value in WebSite text field");
		}
	}

	public static void enterHours(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.Hours_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Hours");
			} else {
				ContactPage_EG.Hours_textField().clear();
				ContactPage_EG.Hours_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter Hours");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Hours");
			Assert.fail("failed to enter value in Hours text field");
		}
	}

	public static void clickOnCreateNewRuleButton() {
		try {
			ContactPage_EG.CreateNewRulesButton().click();
			Constants.test.log(Status.PASS, "click on Create new Rule button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Create new Rule button");
			Assert.fail("failed to click on Create New Rule button");
		}
	}

	public static void Alert_Reject() throws InterruptedException {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(8000);
			alert.dismiss();
			Constants.test.log(Status.PASS, "check Alert is displayed");
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Alert is displayed");
			Assert.fail("failed to check Alert is displayed");
		}
	}

	public static void compareContractNumWithDatabase_Notsaved(String Query, String inputFileName, String sheetName,
			Integer rowNum1, Integer parameterCol1, Integer rowNum2, Integer parameterCol2)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(rowNum1).getCell(parameterCol1).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(rowNum2).getCell(parameterCol2).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			String Contractnumber = sheet.getRow(17).getCell(1).getStringCellValue();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			if (!(DBresults.containsValue(Contractnumber))) {
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}else{
				Assert.fail();
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void enterPBPtext(String string) {
		try {
			if (string.equalsIgnoreCase("null")) {
				ContactPage_EG.PBP_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter PBP Number");
			} else {
				ContactPage_EG.PBP_textField().sendKeys(string);
				Constants.test.log(Status.PASS, "enter PBP Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter PBP Number");
			Assert.fail("failed to enter value in PBP Number text field");
		}
	}

	public static void selectPBPnum(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PBP').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select PBP");
			} else {
				ContactPage_EG.PBPRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select PBP");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select PBP");
			Assert.fail("failed to select an optoin from PBP dropdown");
		}
	}

	public static void selectBrandType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Brand').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Brand");
			} else {
				ContactPage_EG.BrandRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Brand");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Brand");
			Assert.fail("failed to select an optoin from Brand dropdown");
		}
	}

	public static void Alert_textval() throws InterruptedException {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(8000);
			if (alert.getText().equalsIgnoreCase("Actual Message here")) {
				Constants.test.log(Status.PASS, "check Alert message is displayed");
				alert.dismiss();
			} else {

				Assert.fail("failed to check Alert message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Alert is displayed");
			Assert.fail("failed to check Alert is displayed");
		}
	}

	public static void compareContractNumWithDatabase_Saved(String Query, String inputFileName, String sheetName,
			Integer parameterCol1, Integer parameterCol2)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(21).getCell(parameterCol1).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(21).getCell(parameterCol2).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();

			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			String Contractnumber = sheet.getRow(21).getCell(1).getStringCellValue();

			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			if (DBresults.containsValue(Contractnumber)) {
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void errorMessage_stateBlank() throws InterruptedException {
		try {
			if (ContactPage_EG.ErrorMessage_stateBlank().getText()
					.equalsIgnoreCase("Actual state missing Message here")) {
				Constants.test.log(Status.PASS, "check state message is displayed");
			} else {

				Assert.fail("failed to check state message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check state error message");
			Assert.fail("failed to check state error message");
		}
	}

	public static void errorMessage_CityBlank() throws InterruptedException {
		try {
			if (ContactPage_EG.ErrorMessage_CityBlank().getText()
					.equalsIgnoreCase("Actual City missing Message here")) {
				Constants.test.log(Status.PASS, "check state message is displayed");
			} else {

				Assert.fail("failed to check City message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check City error message");
			Assert.fail("failed to check City error message");
		}
	}

	public static void errorMessage_ZipCode() throws InterruptedException {
		try {
			if (ContactPage_EG.ErrorMessage_ZipCodeBlank().getText()
					.equalsIgnoreCase("Zipcode is required if valid State is supplied")) {
				Constants.test.log(Status.PASS, "check Zip Code message is displayed");
			} else {

				Assert.fail("failed to check Zip Code message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Zip code error message");
			Assert.fail("failed to check Zip Code error message");
		}
	}

	public static void errorMessage_FaxNum() throws InterruptedException {
		try {
			if (ContactPage_EG.ErrorMessage_FaxNum().getText()
					.equalsIgnoreCase("Please enter a valid Fax Number matching: 1-XXX-XXX-XXXX")) {
				Constants.test.log(Status.PASS, "check Fax number message is displayed");
			} else if (ContactPage_EG.ErrorMessage_FaxNum().getText()
					.equalsIgnoreCase("Maximum length for Fax Number is 14")) {
				Constants.test.log(Status.PASS, "check Fax number message is displayed");
			} else {
				Assert.fail("failed to check Fax number message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Fax number error message");
			Assert.fail("failed to check Fax number error message");
		}
	}

	public static void errorMessage_PhoneNum() throws InterruptedException {
		try {
			if (ContactPage_EG.ErrorMessage_PhoneNum().getText()
					.equalsIgnoreCase("Please enter a valid Phone Number matching: 1-XXX-XXX-XXXX")) {
				Constants.test.log(Status.PASS, "check Phone number message is displayed");
			} else if (ContactPage_EG.ErrorMessage_PhoneNum().getText()
					.equalsIgnoreCase("Maximum length for Phone Number is 14")) {
				Constants.test.log(Status.PASS, "check Phone number message is displayed");
			} else {
				Assert.fail("failed to check Phone number message displayed");
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Phone number error message");
			Assert.fail("failed to check Phone number error message");
		}
	}

	public static void Alert_Accept() throws InterruptedException {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(1000);
			alert.accept();
			Constants.test.log(Status.PASS, "check Alert is displayed");
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Alert is displayed");
			Assert.fail("failed to check Alert is displayed");
		}
	}

	public static void errorMessages_MassAddress() throws InterruptedException {
		try {

			List<String> arrList = new ArrayList<String>();
			List<WebElement> ErrorTypeOptions = driver.findElements(By.xpath(".//*[@id='error-container']/li"));
			for (WebElement item : ErrorTypeOptions) {
				arrList.add(item.getText());
			}
			List<String> Actualerrors = new ArrayList<String>();
			Actualerrors.add("Maximum length for Address1 is 200");
			Actualerrors.add("Maximum length for Address2 is 200");
			Actualerrors.add("Maximum length for City is 50");
			Actualerrors.add("Maximum length for Zipcode is 15");
			Actualerrors.add("Please enter a valid TTY Number matching: XXX or 1-XXX-XXX-XXXX");
			Actualerrors.add("Maximum length for Email is 250");
			Actualerrors.add("Maximum length for Website is 250");
			Actualerrors.add("Maximum length for Hours of Operation is 200");

			for (String we : Actualerrors) {
				System.out.println(we);

			}
			for (String value : arrList) {
				if (value != null) {
					Assert.assertTrue(Actualerrors.contains(value));
				}
			}
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Phone number error message");
			Assert.fail("failed to check Phone number error message");
		}
	}

	public static void Page_Conformation() throws InterruptedException {
		try {
			if (ContactPage_EG.EmployerGroup_text() != null) {
				Constants.test.log(Status.PASS, "check Page name is displayed");
			} else {
				Constants.test.log(Status.FAIL, "check page name is displayed");
				Assert.fail("failed to check page name is displayed");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check page name is displayed");
			Assert.fail("failed to check page name is displayed");
		}
	}

	public static String storecheckedContractnum() {
		String ContractNum=null;
		try {
			ContractNum = ContactPage_EG.ContractNumer_checked().getText();
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Stored the  contract number");
			Assert.fail("failed to Stored the  contract number");
		}
		return ContractNum;
	}

	public static void compareAddressWithDatabase(String Query, String inputFileName, String sheetName,
			String Contractnum) throws ClassNotFoundException, SQLException, InterruptedException {
		try {

			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", Contractnum);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			List<String> Addressinsheet = new ArrayList<String>();
			Addressinsheet.add(sheet.getRow(16).getCell(5).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(6).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(7).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(8).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(9).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(10).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(11).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(12).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(13).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(14).getStringCellValue());
			Addressinsheet.add(sheet.getRow(16).getCell(15).getStringCellValue());

			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(Addressinsheet.contains(value));
				}
				Constants.test.log(Status.PASS, "compare Address UI Loaded with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare Address UI Loaded with database");
			Assert.fail("failed to compare Address UI Loaded with database");
		}
	}

	public static void ClicktoEditcontactnum_Grid(String Contractnum)
			throws ClassNotFoundException, InterruptedException {
		try {
			for (int i = 1; i <= ContactPage_EG.rowCount_ResultPage(); i++) {
				if (ContactPage_EG.contactnum_InGrid(i).getText().equals(Contractnum)) {
					ContactPage_EG.Editlink_InGrid(i).click();
				}
				break;
			}
			Thread.sleep(2000);
			Constants.test.log(Status.PASS, "Contract Number is found in grid and clicked edit link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Contract Number is not found in grid so not clicked edit link");
			Assert.fail("failed to Click the Contract Number edit link in the grid");
		}
	}
	

	public static void KeyedAddressValidation_EditedPage(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		try {

			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			LinkedHashMap<Integer, String> savedaddress = new LinkedHashMap<Integer, String>();
			ArrayList<String> address = new ArrayList<String>();
			ArrayList<String> insheetaddress = new ArrayList<String>();

			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (i == 5) {
					savedaddress.put(i, ContactPage_EG.Edit_AddressState(i).getAttribute("value"));
				} else {
					savedaddress.put(i, ContactPage_EG.Edit_Addresses(i).getAttribute("value"));
				}
			}
			for (String we : savedaddress.values()) {
				address.add(we);
			}
			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				insheetaddress.add(sheet.getRow(16).getCell(i + 3).getStringCellValue());
			}
			Assert.assertEquals(insheetaddress, address);
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}

	public static void UpdateAdddress_EditedPage(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		try {

			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			LinkedHashMap<Integer, String> savedaddress = new LinkedHashMap<Integer, String>();
			ArrayList<String> address = new ArrayList<String>();
			ArrayList<String> insheetaddress = new ArrayList<String>();

			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (i == 5) {
					savedaddress.put(i, ContactPage_EG.Edit_AddressState(i).getAttribute("value"));
				} else {
					savedaddress.put(i, ContactPage_EG.Edit_Addresses(i).getAttribute("value"));
				}
			}
			for (String we : savedaddress.values()) {
				address.add(we);
			}
			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				insheetaddress.add(sheet.getRow(16).getCell(i + 3).getStringCellValue());
			}
			Assert.assertEquals(insheetaddress, address);
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}

	public static String ClicktoEditcontactnum_Grid(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		String num = null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);

			for (int i = 1; i <= ContactPage_EG.rowCount_ResultPage(); i++) {

				num = ContactPage_EG.contactnum_InGrid(i).getText();
				ContactPage_EG.Editlink_InGrid(i).click();

				if (!(ContactPage_EG.Edit_Addresses1().getAttribute("value").equalsIgnoreCase("hyd1"))) {
					ContactPage_EG.Edit_Addresses1().clear();
					ContactPage_EG.Edit_Addresses1().sendKeys(sheet.getRow(16).getCell(5).getStringCellValue());
					//Actions_ContactPage_EG.clickOnsaveButton_AddressScreen();
					ContactPage_EG.SaveButton_UpdateScreen().click();
					Actions_ContactPage_EG.Alert_Accept();
					break;
				} else {
					driver.navigate().back();
				}
			}
			Constants.test.log(Status.PASS, "Edited Address is successfully Saved");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save Edited Address");
			Assert.fail("failed to save Edited Address");
		}
		return num;
	}

	public static void UpdatedAdddress_DBCheck(String Query, String Contractnum)
			throws ClassNotFoundException, InterruptedException {
		try {
			String QEREY = Query;
			QEREY = Query.replace("parameter", Contractnum);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Integer Dbval = Integer.parseInt(value);
					Assert.assertTrue(Dbval == 2);
				}
				Constants.test.log(Status.PASS, "compare Address UI Loaded with database");
			}
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}

	public static void SavedUpdatedAdddress_Val(String insheetAd1) throws ClassNotFoundException, InterruptedException {
		try {
			ContactPage_EG.Editlink_InGrid(1).click();
			Assert.assertTrue(ContactPage_EG.Edit_Addresses1().getAttribute("value").equalsIgnoreCase(insheetAd1));
			Constants.test.log(Status.PASS, "compared Address UI Loaded with input Excel");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}

	public static ArrayList<String> SelectCheckBoxs_ResultGrid(int i)
			throws ClassNotFoundException, InterruptedException {
		ArrayList<String> SelConNum = null;
		try {
			LinkedHashMap<Integer, String> SelectedContractNumbers = new LinkedHashMap<Integer, String>();
			SelConNum = new ArrayList<String>();
			for (int k = 1; k <= i; k++) {
				ContactPage_EG.CheckBox_ResultGrid(k).click();
				String Text = ContactPage_EG.ContractNumber_ResultGrid(k).getText();
				SelectedContractNumbers.put(k, Text);
			}
			for (String we : SelectedContractNumbers.values()) {
				SelConNum.add(we);
				System.out.println(we);
			}
			Constants.test.log(Status.PASS, "Selected Contract numbers from result grid");
			return SelConNum;
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Falied to select Contract Numbers");
			Assert.fail("failed to select Contract Numbers");
			return null;
		}

	}

	public static void DeletedContract_DBCheck(String Query, String Contractnum)
			throws ClassNotFoundException, InterruptedException {
		try {

			String QEREY = Query;
			QEREY = Query.replace("parameter", Contractnum);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Integer Dbval = Integer.parseInt(value);
					Assert.assertTrue(Dbval == 3);

				}

			}
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}

	public static void SelectedrecordDelete_Cancel(int m) throws ClassNotFoundException, InterruptedException {
		try {
			int beforeaction = ContactPage_EG.rowCount_ResultPage();
			ArrayList<String> al = Actions_ContactPage_EG.SelectCheckBoxs_ResultGrid(m);
			ContactPage_EG.DeleteSelectedButton().click();
			Actions_ContactPage_EG.Alert_Reject();
			int afteraction = ContactPage_EG.rowCount_ResultPage();
			if (beforeaction == afteraction) {
				System.out.println("Results not deleted");
				Constants.test.log(Status.PASS, "Slected which is not deleted expected");
			} else {
				System.out.println("deleted the record after Alert is Rejected");
				Assert.fail();
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Record is deleted");
			Assert.fail("Failed to find the records in result grid");
		}
	}

	public static void SelectedrecordDeleted_DBcheck(int n, String ContactType)
			throws ClassNotFoundException, InterruptedException {
		try {

			Actions_ContactPage_EG.clickOnSearchContactsButton();
			int beforeaction = ContactPage_EG.rowCount_ResultPage();

			ArrayList<String> al = Actions_ContactPage_EG.SelectCheckBoxs_ResultGrid(n);
			ContactPage_EG.DeleteSelectedButton().click();
			Thread.sleep(1000);
			Actions_ContactPage_EG.Alert_Accept();
			Thread.sleep(2000);
			ContactPage_EG.submitRecord_Deletion().click();
			Thread.sleep(1000);
			Actions_ContactPage_EG.selectContactType(ContactType);
			Actions_ContactPage_EG.clickOnSearchContactsButton();
			Thread.sleep(1000);
			System.out.println("satish1");
			int afterdelaction = ContactPage_EG.rowCount_ResultPage();
			if ((beforeaction - afterdelaction) == n) {
				for (int i = 0; i < al.size(); i++) {
					System.out.println(al.get(i) + " Status ID Should be 3 for successful Delete Action");
					Actions_ContactPage_EG.DeletedContract_DBCheck(Constants.Input_SQLS.getRow(31).getCell(1).getStringCellValue(), al.get(i));
				}
				Constants.test.log(Status.PASS, "Slected Records are deleted");
			} else {
				System.out.println("deleted the record after Alert is Rejected");
				Assert.fail();
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Record is Not deleted");
			Assert.fail("Failed to find the deleted records in DB");
		}
	}

	public static void StateCodesWithDatabase(String Query)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {

			String QEREY = Query;

			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> stateCodeOptions = ContactPage_EG.GLState_dropdown().getOptions();
			for (WebElement item : stateCodeOptions) {
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Assert.assertTrue(arrList.contains(value));
				}

			}
			Constants.test.log(Status.PASS, "compare UI search results with database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void selectGLState(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('GroupType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select State");
			} else {
				// ContactPage_EG.State_dropdown().deselectAll();
				ContactPage_EG.GLState_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select State");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select State");
			Assert.fail("failed to select an optoin from State dropdown");
		}
	}

	public static void compareGLContactTypeWithDB(String Query, String inputFileName, String sheetName,
			Integer parameterCol, String GroupType)

			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			QEREY = QEREY.replace("parameter2", GroupType);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage_EG.ContactType_dropdown().getOptions();
			for (WebElement item : contactTypeOptions) {
				arrList.add(item.getText());
			}

			arrList.remove(0);

			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					System.out.println(arrList);
					Assert.assertTrue(arrList.contains(value));
				}

			}
			Constants.test.log(Status.PASS, "compare UI search results with database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static String save_GLSingleContactInfo(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		String selectState = null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			ArrayList<String> array = new ArrayList<String>();
			List<WebElement> stateCodeOptions = ContactPage_EG.GLState_dropdown().getOptions();
			for (WebElement we : stateCodeOptions) {
				array.add(we.getText());
			}
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i));
			}
			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (!(i == 5)) {
					ContactPage_EG.Edit_Addresses(i).sendKeys(sheet.getRow(16).getCell(i + 3).getStringCellValue());
				}
			}
			String state = ContactPage_EG.GLState_dropdown().getFirstSelectedOption().getText();
			Thread.sleep(1000);
			ContactPage_EG.Edit_StateInAddress().selectByVisibleText(state);
			ContactPage_EG.SaveButton_CreateNewGL().click();
			for (int i = 1; i < array.size(); i++) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alerttext = alert.getText();
				if (alerttext.equalsIgnoreCase("This rule combination is a duplicate in the system.  Please change rule and resubmit.")) {
					Thread.sleep(3000);
					Actions_ContactPage_EG.Alert_Accept();
					Thread.sleep(1000);
					ContactPage_EG.GLState_dropdown().selectByIndex(i);
					Thread.sleep(1000);
					ContactPage_EG.Edit_StateInAddress().selectByIndex(i + 1);
					Thread.sleep(1000);
					selectState = ContactPage_EG.Edit_StateInAddress().getOptions().get(i).getText();
					ContactPage_EG.SaveButton_CreateNewGL().click();
				} else if (alerttext.equalsIgnoreCase("Are you Sure you want to create this rule?")) {
					Actions_ContactPage_EG.Alert_Accept();
					break;
				} else {
					Actions_ContactPage_EG.Alert_Accept();
					Assert.fail("Failed to add the address as it deleted. Run the job and try again");
				}
			}
			Constants.test.log(Status.PASS, "Address is successfully Saved");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save  Address");
			Assert.fail("failed to save  Address");
			return null;
		}
		return selectState;
	}

	public static void compareGLinsertstatusWithDB(String Query, String inputFileName, String sheetName, String Contacttype)
			throws ClassNotFoundException, InterruptedException, SQLException {

		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", Contacttype);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Integer Dbval = Integer.parseInt(value);
					Assert.assertTrue(Dbval == 1);
				}
				Constants.test.log(Status.PASS, "compare Global record insert status Loaded with database");
			}
			Constants.test.log(Status.PASS, "Global record insert status which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
	}
	public static void compareGLUpdatestatusWithDB(String Query, String inputFileName, String sheetName, String Contacttype)
			throws ClassNotFoundException, InterruptedException, SQLException {

		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", Contacttype);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					Integer Dbval = Integer.parseInt(value);
					Assert.assertTrue(Dbval == 2);
				}
				Constants.test.log(Status.PASS, "compare Global record insert status Loaded with database");
			}
			Constants.test.log(Status.PASS, "Global record insert status which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
	}
	
	
	public static void compareGLUpdate_Load_DB(String Query, String inputFileName, String sheetName, String Contacttype)
			throws ClassNotFoundException, InterruptedException, SQLException {

		try {
			String Statusid = "4";
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", Contacttype);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					DBvalStoring.add(value);				
				}
			}
			for(String str : DBvalStoring){
				Assert.assertTrue(str == Statusid);
			}	
			Constants.test.log(Status.PASS, "Global record updated through Contact rule data load");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to record updated through Contact rule data load");
		}
	}
	
	public static String StoringG_IDandP_IDAfterLoadWithDB(String Query, String inputFileName, String sheetName, String StateCode)
			throws ClassNotFoundException, InterruptedException, SQLException {
		String group_planid = null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", StateCode);
			Utils.connectToSqlserverDB();
			System.out.println(QEREY);
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("data result");
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null) {
						group_planid = value;
					}
				}
			}
			Constants.test.log(Status.PASS, "compare Global record insert status Loaded in database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
		return group_planid;
	}
	
	public static void GroupIDorPlanIDAfterLoadWithDB(String Query, String Id, String StateCode, String Contacttypeid)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			
			String QEREY = Query;
			QEREY = Query.replace("parameter1", Id);
			QEREY = QEREY.replace("parameter2", StateCode);
			QEREY = QEREY.replace("parameter3", Contacttypeid);
			Utils.connectToSqlserverDB();
			System.out.println(QEREY);
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("data result");
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null) {
						System.out.println(value);
					}else{
						Assert.fail("No results are found");
					}
				}
			}
			Constants.test.log(Status.PASS, "compare Global record insert status Loaded in database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
		
	}
	public static void GroupID_PlanIDAfterLogicallyDel(String Query, String Id, String StateCode, String Contacttypeid)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			
			String QEREY = Query;
			QEREY = Query.replace("parameter1", Id);
			QEREY = QEREY.replace("parameter2", StateCode);
			QEREY = QEREY.replace("parameter3", Contacttypeid);
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
				for (String value : DBresults.values()) {
					if (value == null) {
						System.out.println(value);
					}else{
						Assert.fail("Results are found");
					}
				}
			}
			Constants.test.log(Status.PASS, "compare Global record delete in data base");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
		
	}
	
	public static String save_GLMultiContactInfo(String inputFileName, String sheetName, int recurrent)
			throws ClassNotFoundException, InterruptedException {
		String selectState = null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			ArrayList<String> array = new ArrayList<String>();
			List<WebElement> stateCodeOptions = ContactPage_EG.GLState_dropdown().getOptions();
			
			for (WebElement we : stateCodeOptions) {
				array.add(we.getText());
			}
			for (int i = 0; i < array.size(); i++) {
				System.out.println(array.get(i));
			}
			for(int i=0; i<=recurrent-1; i++ ){  
				ContactPage_EG.AddButton_CreateNewGL(i).click();
			}
			String state = ContactPage_EG.GLState_dropdown().getFirstSelectedOption().getText();
			
			for(int i=0; i<=recurrent; i++){
				for (int j = 2; j<= ContactPage_EG.rowCount_EditPage(); j++) {	
					if(j==5){
						ContactPage_EG.StateInAddress_Multiple(i).selectByVisibleText(state);
					}else if (!(j == 5)) {
					Thread.sleep(1000);
					ContactPage_EG.AddAddress_Multiple(i, j).sendKeys(sheet.getRow(16).getCell(j+3).getStringCellValue());
					}
				}
					ContactPage_EG.AddAddress_Multiple(i, 1).sendKeys(sheet.getRow(16).getCell(4).getStringCellValue()+" "+i);
			}	
			ContactPage_EG.SaveButton_CreateNewGL().click();
			for (int i = 0; i < array.size(); i++) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alerttext = alert.getText();
				if (alerttext.equalsIgnoreCase("This rule combination is a duplicate in the system.  Please change rule and resubmit.")) {
					Thread.sleep(2000);
					Actions_ContactPage_EG.Alert_Accept();
					Thread.sleep(1000);
					ContactPage_EG.GLState_dropdown().selectByIndex(i);
					selectState = ContactPage_EG.GLState_dropdown().getOptions().get(i).getText();
					for(int j=0; j<=recurrent; j++){
						ContactPage_EG.StateInAddress_Multiple(j).selectByVisibleText(selectState);	
					}
					Thread.sleep(1000);
					ContactPage_EG.SaveButton_CreateNewGL().click();
				} else if (alerttext.equalsIgnoreCase("Are you Sure you want to create this rule?")) {
					//Actions_ContactPage_EG.Alert_Accept();  //uncomment while running
					Actions_ContactPage_EG.Alert_Reject();
					break;
				} else {
					Actions_ContactPage_EG.Alert_Accept();
					Assert.fail("Failed to add the address as it deleted. Run the job and try again");
				}
			}
			Constants.test.log(Status.PASS, "Saved the address to data base");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save  Address");
			Assert.fail("failed to save  Address");
			return null;
		}
		return selectState;
	}
	
	
	public static List<String> storing_GLMultiContactinfo(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		List<String> Addresssaved=null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			
			
			Addresssaved = new ArrayList<String>();
			for(int i=0; i<=2; i++){
				for (int j = 1; j<= 12; j++){
					if(j==1){
						Addresssaved.add(sheet.getRow(16).getCell(j+3).getStringCellValue()+" "+i);
					}
					else if(!(j==5)){
				Addresssaved.add(sheet.getRow(16).getCell(j+3).getStringCellValue());
						}else{
						System.out.println("state");
						}
					}	
			}				
			for(int k=0; k<Addresssaved.size();k++){
			System.out.println(Addresssaved.get(k));
			}
			Constants.test.log(Status.PASS, "Able to save the address to data base");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save  Address");
			Assert.fail("failed to get the saved  Address");
			
		}
		return Addresssaved;
	}
	
	public static String ContactDB_ContractRuletypeID(String Query, String inputFileName, String sheetName) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		String ContactRuleTypeID=null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(37).getCell(3).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(1).getCell(6).getStringCellValue());
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			System.out.println("DB comnnections");
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("DB comnnections   results");
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			//ArrayList<String> arrList = new ArrayList<String>();
			
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			for (String item : DBresults.values()) {
				System.out.println(item);
				ContactRuleTypeID = item;
				}
			
			Constants.test.log(Status.PASS, "Able to save the address in data base");
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save  Address");
			Assert.fail("failed to get the saved  Address");
			
		}
		return ContactRuleTypeID;
	}
	
	public static void compareMultiAddress_GL(String Query, String inputFileName, String sheetName,  String ContacttypeId, String State ) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", ContacttypeId);
			QEREY = QEREY.replace("parameter2", State);
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			List<String> arrList = new ArrayList<String>();
			List<String> StoredAddress = Actions_ContactPage_EG.storing_GLMultiContactinfo("./src/test/java/testData/Contact/Contact_EG.xlsx", "Address"); 
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null){
						System.out.println(value);
						arrList.add(value);
						Assert.assertTrue(StoredAddress.contains(value));
					}
				}
			}
			Constants.test.log(Status.PASS, "Able to save the address in data base");
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable to save  Address");
			Assert.fail("failed to get the saved  Address");
			
		}
		
	}
	
	
	public static void Logically_deletedGroup(String Query1,String Query2, String inputFileName, String sheetName,  String ContacttypeId, String State ) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query1;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", State);
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			String GroupID = "";			
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null){
						System.out.println(value);
						GroupID = value;
						
					}
				}
			}
			System.out.println(GroupID);
			String QEREYupdate = Query2.replace("parameter1", GroupID);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.test.log(Status.PASS, "Update is done in DB");
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "Unable get Group from DB Address");
			Assert.fail("failed to get the group  from DB");
			
		}
	}	
	
	public static void savingAddress(String inputFileName, String sheetName, String State) 
			throws ClassNotFoundException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			for (int i = 1; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (!(i == 5)) {
					ContactPage_EG.Edit_Addresses(i).clear();
					ContactPage_EG.Edit_Addresses(i).sendKeys(sheet.getRow(16).getCell(i + 3).getStringCellValue());
				}
			}
			ContactPage_EG.Edit_StateInAddress().selectByVisibleText(State);
			Constants.test.log(Status.PASS, "Able to save the address in data base");		
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to save Address");
			Assert.fail("failed to save address");
			
		}
	}	
	
	public static String deleteandAddContactData(String inputFileName, String sheetName) 
					throws ClassNotFoundException, SQLException, InterruptedException {
		String StateCode="";
		try {
			
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			for(int i=1; i<ContactPage_EG.rowCount_ResultPage(); i++){
				if(ContactPage_EG.ContactLabel_InGrid(i).getText().equalsIgnoreCase("Y")){
					StateCode = ContactPage_EG.state_InGrid(i).getText();
					ContactPage_EG.Editlink_InGrid(i).click();
					break;
				}
			}	
			
			for(int i=0; i<1; i++){
				for (int j = 1; j<= ContactPage_EG.rowCount_EditPage(); j++) {	
					if(j==5){
						ContactPage_EG.StateInAddress_Multiple(i).selectByVisibleText(StateCode);
					}else if (!(j == 5)) {
						ContactPage_EG.AddAddress_Multiple(i, j).clear();
						ContactPage_EG.AddAddress_Multiple(i, j).sendKeys(sheet.getRow(16).getCell(j+3).getStringCellValue());
					}
				}
			}	
			ContactPage_EG.DeleteButton_CreateNewGL(1).click();
			Thread.sleep(2000);
			Actions_ContactPage_EG.Alert_Accept();
			
			ContactPage_EG.AddButton_CreateNewGL().click();
			for(int i=1; i<2; i++){
				for (int j = 1; j<= ContactPage_EG.rowCount_EditPage(); j++) {	
					if(j==1){
						ContactPage_EG.AddAddress_Multiple(i, 1).sendKeys(sheet.getRow(16).getCell(4).getStringCellValue()+" "+i);
					} else if(j==5){
						ContactPage_EG.StateInAddress_Multiple(i).selectByVisibleText(StateCode);
					}else if (!(j == 5) && !(j==1)) {
						ContactPage_EG.AddAddress_Multiple(i, j).clear();
						ContactPage_EG.AddAddress_Multiple(i, j).sendKeys(sheet.getRow(16).getCell(j+3).getStringCellValue());
						}
					}
			}
			
			ContactPage_EG.SaveButton_CreateNewGL().click();
			Actions_ContactPage_EG.Alert_Accept();
			Constants.test.log(Status.PASS, "Delete and add contact data is done");
			
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "compare UI search results with database");
				Assert.fail("failed to compare UI search results with database");
				}
		return StateCode;
	}
	
	public static void UpdateDelInsert_DBCheck(String Query, String StateCode)
			throws ClassNotFoundException, InterruptedException {
		try {

			String QEREY = Query;
			QEREY = Query.replace("parameter", StateCode);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			List<String> DBvalues = new ArrayList<String>();
			List<String> ExpectedValues = new ArrayList<String>();
			String Insertedstatus = "1", Updatedstatus = "2", Deletedstatus = "3";
			ExpectedValues.add(Deletedstatus);
			ExpectedValues.add(Updatedstatus);
			ExpectedValues.add(Insertedstatus);
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null){
						System.out.println(value);
						DBvalues.add(value);
					}
				}
			}
			Assert.assertTrue(ExpectedValues.containsAll(DBvalues));
			Constants.test.log(Status.PASS, "Update and delete Address is performed correctly ");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Address which is saved is not loaded");
				Assert.fail("failed to check the Address which is saved is not loaded");
			}
		}
	
	public static void DeletePlan_GroupIDinDB(String Query, String Id, String StateCode)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {

				String QEREY = Query;
				QEREY = QEREY.replace("parameter1", Id);
				QEREY = QEREY.replace("parameter2", StateCode);
				Utils.connectToSqlserverDB();
				Thread.sleep(3000);
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				Constants.test.log(Status.PASS, "Results are deleted successfully");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Results are not deleted");
				Assert.fail("failed to delete the results");
			}
	}
	
	public static String plan_group_NoStates_DB(String Query, String year)
			throws ClassNotFoundException, InterruptedException, SQLException {
		String planidORgroupid="";
		try {
			
			String QEREY = Query;
			QEREY = QEREY.replace("parameter", year);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("data result");
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null) {
						System.out.println(value);
						planidORgroupid=value;
					}else{
						Assert.fail("No results are found");
					}
				}
			}
			Constants.test.log(Status.PASS, "Id is found and got stored");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL,"Results are not found");
			Assert.fail("failed to get the results form DB");
		}
		return planidORgroupid;
	}
	
	public static String CountyID_DB(String Query1, String Query2, String StateCode)
			throws ClassNotFoundException, InterruptedException, SQLException {
		String CountyID=null;
		
		try {
			String StateID=null;
			String QEREY1 = Query1;
			QEREY1 = QEREY1.replace("parameter", StateCode);
			System.out.println(QEREY1);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresults.values()) {
					if (value != null) {
						System.out.println(value);
						StateID=value;
					}else{
						Assert.fail("No results are found");
					}
				}
			String QEREY2 = Query2;
			QEREY2 = QEREY2.replace("parameter", StateID);
			System.out.println(QEREY2);
			Constants.resultset = Constants.statement.executeQuery(QEREY2);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresult = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresult.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresult.values()) {
					if (value != null) {
						System.out.println(value);
						CountyID=value;
						
					}else{
						Assert.fail("No results are found");
					}
				}
			Constants.test.log(Status.PASS, "Id is found and got stored");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL,"Results are not found");
			Assert.fail("failed to get the results form DB");
		}
		return CountyID;
	}
	
	public static void InsertCounty(String Query, String CountyID, String Id)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", Id);
			QEREY = QEREY.replace("parameter2", CountyID);
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.test.log(Status.PASS, "Id is found and got stored");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL,"Results are not found");
			Assert.fail("failed to get the results form DB");
		}
	}
	
	public static void ClicktoEditAddress_Grid()
			throws ClassNotFoundException, InterruptedException {
		try {
			for (int i = 1; i <= ContactPage_EG.rowCount_ResultPage(); i++) {
				if (ContactPage_EG.ContactLabel_InGrid(i).getText().isEmpty()) {
					ContactPage_EG.Editlink_InGrid(i).click();
					break;
				}
			}
			Thread.sleep(2000);
			Constants.test.log(Status.PASS, "Edit link is clicked successfully");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Edit link is not found to click");
			Assert.fail("failed to Click the edit link");
		}
	}
	
	public static void MultiAddressUpdation(String inputFileName, String sheetName, String StateCode) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		
		try {
	
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			for(int i=1; i<ContactPage_EG.rowCount_ResultPage(); i++){
				if(ContactPage_EG.state_InGrid(i).getText().equalsIgnoreCase(StateCode)){
					
					ContactPage_EG.Editlink_InGrid(i).click();
					break;
				}
			}	
			for(int i=0; i<1; i++){
				for (int j = 1; j<= ContactPage_EG.rowCount_EditPage(); j++) {	
					if(j==5){
						ContactPage_EG.StateInAddress_Multiple(i).selectByVisibleText(StateCode);
					}else if (!(j == 5)) {
						ContactPage_EG.AddAddress_Multiple(i, j).clear();
						ContactPage_EG.AddAddress_Multiple(i, j).sendKeys(sheet.getRow(16).getCell(j+3).getStringCellValue());
					}
				}
			}				
			for(int i=2; i<3; i++){
				for (int j = 2; j<= ContactPage_EG.rowCount_EditPage(); j++) {	
					 if(j==5){
						ContactPage_EG.StateInAddress_Multiple(i).selectByIndex(0);
					}else if (!(j == 5)) {
						ContactPage_EG.AddAddress_Multiple(i, j).clear();
					}
				}
				for(int j = 7; j<= 9 ; j++){
					ContactPage_EG.AddAddress_Multiple(i, j).sendKeys(sheet.getRow(16).getCell(j+3).getStringCellValue());
				}
			}
			ContactPage_EG.SaveButton_CreateNewGL().click();
			Actions_ContactPage_EG.Alert_Accept();
			Constants.test.log(Status.PASS, "Edit data is successful");
	
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Edit data is completes unsuccessful");
			Assert.fail("failed to Edit data ");
		}
	}
	
	public static List<String>  DeleterecordsGL(Integer deletecount) 
			throws ClassNotFoundException, SQLException, InterruptedException {
			List<String> deletedstates = new ArrayList<String>();
		try {
			
			for(int i=1; i<=deletecount; i++){
					ContactPage_EG.CheckBox_ResultGrid(i).click();
					deletedstates.add(ContactPage_EG.state_InGrid(i).getText());
			}	
			ContactPage_EG.DeleteSelectedButton().click();
			Actions_ContactPage_EG.Alert_Accept();
			ContactPage_EG.submitRecord_Deletion().click();
			for(int i=1; i<ContactPage_EG.rowCount_ResultPage(); i++){
				for(int j=0; j<deletecount; j++){
					if(ContactPage_EG.state_InGrid(i).getText().equalsIgnoreCase(deletedstates.get(j))){
						Assert.fail("Record is not deleted");
					}
				}
			}
			Constants.test.log(Status.PASS, "Record deleted successfully");	
		} catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, " Record deletion is unsuccessful");
			Assert.fail("failed to delete the record "); 
		}
		return deletedstates;
	}
	
	
	public static void DelRecords_IndEmpDBCheck(String Query, String filepath, String sheetname, 
			String ContactType, List<String> StateCode) 	throws ClassNotFoundException, InterruptedException {
		try {
			List<String> State =  new ArrayList<String>(StateCode);
			XSSFSheet sheet = Utils.excel_sheet(filepath, sheetname);
			String QEREY = Query;
			for(int i=0; i<State.size(); i++){
			
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = Query.replace("parameter2", State.get(i));
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresults.values()) {
					if (!(value == null)){
						System.out.println(value);
					Assert.fail();
					}
				}
			}
				Constants.test.log(Status.PASS, "Record is deleted successfully");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Record is not deleted");
				Assert.fail("failed to check the Record deletion");
		}
	}
	
	public static List<String> deleteContactData_Single_Multiple(Integer deleteAddress) 
			throws ClassNotFoundException, SQLException, InterruptedException {
		List <String> StateCode=null;
		try {
			StateCode =new ArrayList<String>();
			
			for(int i=1; i<ContactPage_EG.rowCount_ResultPage(); i++){
				if(ContactPage_EG.ContactLabel_InGrid(i).getText().equalsIgnoreCase("Y")){
					StateCode.add(ContactPage_EG.state_InGrid(i).getText());
					ContactPage_EG.Editlink_InGrid(i).click();
					break;
				}
			}	
			for(int i=1; i<=deleteAddress; i++){
			ContactPage_EG.DeleteButton_CreateNewGL(1).click();
			Actions_ContactPage_EG.Alert_Accept();
			}
			ContactPage_EG.SaveButton_CreateNewGL();
			Constants.test.log(Status.PASS, "Delete the contact data is done");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "dalete contact data is not done correctly");
			Assert.fail("failed to delete the contact data");
			}
		return StateCode;
		}
	
	public static void Deletedcontact_DBCheck(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		try {
			
			String Statusid = "3";
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", sheet.getRow(37).getCell(2).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			for (String value : DBresults.values()) {
					if (value != null){
						DBvalStoring.add(value);
				}
			}
			for(int i=0; i<DBvalStoring.size();i++){
				Assert.assertTrue(DBvalStoring.contains(Statusid));
			}
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}
	
	public static void DeleteIndividualCheck_DB(String Query1, String Query2, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		try {
			String Plandid=null;
			ContactPage_EG.CheckBox_ResultGrid(1).click();
			String ContractNumber = ContactPage_EG.ContractNumber_ResultGrid(1).getText();
			String ContactType   =  ContactPage_EG.ContractType_ResultGrid(1).getText();
			ContactPage_EG.DeleteSelectedButton();
			Actions_ContactPage_EG.Alert_Accept();
			ContactPage_EG.SaveButton_CreateNewGL();
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query1;
			QEREY = QEREY.replace("parameter1", ContractNumber);
			QEREY = QEREY.replace("parameter2", ContactType);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			for (String value : DBresults.values()) {
					if (value != null){
						Plandid=value;
				}
			}
			String QERY = Query2;
			QERY = QERY.replace("parameter", Plandid);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QERY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresult = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresult.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			Assert.assertTrue(DBresult.equals(null));
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}
	
	public static void CreateIndruleandDB_Val(String Query1, String Query2, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		
		try {
			String Plandid=null;
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			ContactPage_EG.CheckBox_ResultGrid(1).click();
			String ContractNumber = ContactPage_EG.ContractNumber(1).getText();
			String ContactType   =  sheet.getRow(2).getCell(4).getStringCellValue();
			for (int i = 1; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (!(i == 5)) {
					ContactPage_EG.Edit_Addresses(i).clear();
					ContactPage_EG.Edit_Addresses(i).sendKeys(sheet.getRow(16).getCell(i + 3).getStringCellValue());
				}
			}
			ContactPage_EG.Edit_StateInAddress().selectByVisibleText("AK");
			ContactPage_EG.SaveButton_CreateNewGL().click();
			ContactPage_EG.DeleteSelectedButton();
			Actions_ContactPage_EG.Alert_Accept();
			ContactPage_EG.SaveButton_CreateNewGL();
			
			String QEREY = Query1;
			QEREY = QEREY.replace("parameter1", ContractNumber);
			QEREY = QEREY.replace("parameter2", ContactType);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			for (String value : DBresults.values()) {
					if (value != null){
						Plandid=value;
				}
			}
			String QERY = Query2;
			QERY = QERY.replace("parameter", Plandid);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QERY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresult = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresult.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			Assert.assertTrue(!(DBresult.equals(null)));
			Constants.test.log(Status.PASS, "Address is entered correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is entered is loaded incorrectly");
			Assert.fail("failed to check the Address which is entered is loaded correctly");
		}
	}
	
	public static String StoringG_IDdP_IDAfterLoadWithDB(String Query, String inputFileName, String sheetName, String StateCode)
			throws ClassNotFoundException, InterruptedException, SQLException {
		String group_planid = null;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter1", sheet.getRow(1).getCell(6).getStringCellValue());
			QEREY = QEREY.replace("parameter2", StateCode);
			Utils.connectToSqlserverDB();
			System.out.println(QEREY);
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("data result");
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null) {
						group_planid = value;
					}
				}
			}
			Constants.test.log(Status.PASS, "compare Global record insert status Loaded in database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
		return group_planid;
	}
	
	public static int planid_addressrowcount(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException, SQLException {
		int count=0;
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter", sheet.getRow(43).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			System.out.println(QEREY);		
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println("data result");
			System.out.println(Constants.resultsetMetadata);
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null) {
					 count = Integer.parseInt(value);
					}
				}
			}
			Constants.test.log(Status.PASS, "compare Global record insert status Loaded in database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to check compareGLinsertstatusWithDB");
		}
		return count;
	}

	public static void Addressinsertcount(int Before, int After)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			if(After==(Before+1)){
				Constants.test.log(Status.PASS, "Data not stored on DB");
			}else{
				Assert.fail();
			}
			Constants.test.log(Status.PASS, "Data not stored on DB");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Saved address is nod loaded in DB");
			Assert.fail("failed to save the address in DB");
		}
		
	}
	
	public static void LoadedContactTypes_DBCheck(String Query1, String Query2, String inputFileName, String sheetName, String Contractid,
			String valuesloaded, Integer cellvalue)		throws ClassNotFoundException, InterruptedException {
		try {
				XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
				String QEREY = Query1;
				QEREY = Query1.replace("parameter1", valuesloaded);
				QEREY = QEREY.replace("parameter2", Contractid);
				Utils.connectToSqlserverDB();
				Thread.sleep(3000);
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				Thread.sleep(3000);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				System.out.println(Constants.resultsetMetadata);
				LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
				LinkedHashMap<Integer, String> DBvalues = new LinkedHashMap<Integer, String>();
				List<String> Values = new ArrayList<String>();
				for (int k = 0; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
					}
				}
				for(int i =1; i<=Values.size();i++){
					DBvalues.put(i, Values.get(i));
				}
				String QEREY2 = Query2;
				for(int i=1; i<=Values.size();i++){
					QEREY2 = Query2.replace("par"+i, Values.get(i));
					}
				Utils.connectToSqlserverDB();
				Constants.resultset = Constants.statement.executeQuery(QEREY2);
				Thread.sleep(3000);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				System.out.println(Constants.resultsetMetadata);
				LinkedHashMap<String, String> DBresultsDesc = new LinkedHashMap<String, String>();
				List<String> Valuesdesc = new ArrayList<String>();
				for (int k = 0; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBresultsDesc.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
					}
				}
				for(String Desc:DBresultsDesc.values()){
					Valuesdesc.add(Desc);
				}
				List<String> SheetValues = new ArrayList<String>();
				for(int i=cellvalue; i<=cellvalue+Valuesdesc.size();i++){
					SheetValues.add(sheet.getRow(i+1).getCell(0).getStringCellValue());
				}
				Assert.assertTrue(Valuesdesc.containsAll(SheetValues));
				Constants.test.log(Status.PASS, "Added Contact types are mapped to correct Planid");
			} catch (Exception e) {
					Constants.test.log(Status.FAIL, "Added Contact types are not mapped correctly");
					Assert.fail("failed to check Added Contact types are not mapped correctly");
				}
		}
	
	public static void UpdateAdddress(String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			for (int i = 2; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (!(i == 5)) {
					ContactPage_EG.Edit_Addresses(i).clear();
					ContactPage_EG.Edit_Addresses(i).sendKeys(sheet.getRow(16).getCell(i + 3).getStringCellValue());
				}
			}
			Constants.test.log(Status.PASS, "Address which is saved is loaded correctly");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address which is saved is loaded incorrectly");
			Assert.fail("failed to check the Address which is saved is loaded correctly");
		}
	}
	
	public static void savingIndividualAddress(String inputFileName, String sheetName, String State) 
			throws ClassNotFoundException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			ContactPage_EG.Edit_IndAddresses1().sendKeys(sheet.getRow(16).getCell(5).getStringCellValue());
			for (int i = 3; i <= ContactPage_EG.rowCount_EditPage(); i++) {
				if (!(i == 5)) {
					ContactPage_EG.Edit_Addresses(i).sendKeys(sheet.getRow(16).getCell(i + 3).getStringCellValue());
				}
			}
			ContactPage_EG.Edit_StateInAddress().selectByVisibleText(State);
			Constants.test.log(Status.PASS, "Able to save the address in data base");		
		}catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to save Address");
			Assert.fail("failed to save address");
			
		}
	}
	
	public static void compareIndAddressUpdate_Load_DB(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			String Statusid = "4";
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter", sheet.getRow(45).getCell(1).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
					DBvalStoring.add(value);				
				}
			}
				for (String str : DBvalStoring) {
					Assert.assertTrue(str == Statusid);
				}
			Constants.test.log(Status.PASS, "Global record updated through Contact rule data load");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compareGLinsertstatusWithDB");
			Assert.fail("failed to record updated through Contact rule data load");
		}
	}
	
	public static void selectCheckBox_MA_Plan() {
		try {
			for(int i=1; i<=ContactPage_EG.rowCount_ResultNewPage(); i++){
				if (ContactPage_EG.DrugCoverage_CreateNewresultpage(i).getText().equalsIgnoreCase("MA")){
					Utils.click(ContactPage_EG.CheckBox_CreateNewresultpage(i));
					break;
					}
			}
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	}
	public static void selectCheckBox_PDP_Plan() {
		try {
			for(int i=1; i<=ContactPage_EG.rowCount_ResultNewPage(); i++){
				if (ContactPage_EG.DrugCoverage_CreateNewresultpage(i).getText().equalsIgnoreCase("PDP")){
					Utils.click(ContactPage_EG.CheckBox_CreateNewresultpage(i));
					break;
					}
			}
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	}
	public static void selectCheckBox_MAPD_Plan() {
		try {
			for(int i=1; i<=ContactPage_EG.rowCount_ResultNewPage(); i++){
				if (ContactPage_EG.DrugCoverage_CreateNewresultpage(i).getText().equalsIgnoreCase("MAPD")){
					Utils.click(ContactPage_EG.CheckBox_CreateNewresultpage(i));
					break;
					}
			}
			Constants.test.log(Status.PASS, "click on single PlanCheckbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Single plan Checkbox");
			Assert.fail("failed to click on Select single plan Checkbox");
		}
	}
	public static void updateDrugCovType(String Query, String DrugCovtype, String Planid)		
			throws ClassNotFoundException, InterruptedException {
		try {
			String QEREY = Query;
			QEREY = Query.replace("parameter1", DrugCovtype);
			QEREY = QEREY.replace("parameter2", Planid);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);		
			Constants.test.log(Status.PASS, "successfully updated the drugcoverage type");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "unable to update the drugcoverage type");
				Assert.fail("failed to update the drugcoverage type");
			}
		}
	
	public static void compareIndInsert_DB(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter", sheet.getRow(48).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresults.values()) {
					if (value != null){
						System.out.println(value);
					DBvalStoring.add(value);
				} else{
					Assert.fail();
				}
			}
			Constants.test.log(Status.PASS, "Record updated through Contact rule data load");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Individual plan contact load is failed");
			Assert.fail("failed to updated through Contact rule data load");
		}
	}
	
	public static void recordWithPart_C_MAPD(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter", sheet.getRow(45).getCell(4).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresults.values()) {
					if (value != null){
						System.out.println(value);
					DBvalStoring.add(value);
				} else{
					Assert.fail();
				}
			}
			Assert.assertEquals(DBvalStoring, 19);
			Constants.test.log(Status.PASS, "Record updated through Contact rule data load");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Individual plan contact load is failed");
			Assert.fail("failed to updated through Contact rule data load");
		}
	}
	
	public static void recordWithPart_C_PDP(String Query, String inputFileName, String sheetName)
			throws ClassNotFoundException, InterruptedException, SQLException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = Query.replace("parameter", sheet.getRow(45).getCell(4).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			System.out.println(Constants.resultsetMetadata);
			List<String> DBvalStoring = new ArrayList<String>();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
				for (String value : DBresults.values()) {
					Assert.assertTrue(value == null);
				} 
			Constants.test.log(Status.PASS, "Record updated through Contact rule data load");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Individual plan contact load is failed");
			Assert.fail("failed to updated through Contact rule data load");
		}
	}
	
	
}
