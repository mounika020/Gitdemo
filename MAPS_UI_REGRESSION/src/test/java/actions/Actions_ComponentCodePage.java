package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.ComponentCodePage;
import utilities.Constants;
import utilities.Utils;

public class Actions_ComponentCodePage extends BaseClass {

	public Actions_ComponentCodePage(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void clickOnUploadFileTemplateButton() throws InterruptedException {
		try {

			// wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.uploadFileTemplate_button()));
			Thread.sleep(3000);
			utilities.Utils.click(ComponentCodePage.uploadFileTemplate_button());
			Constants.test.log(Status.PASS, "Click on upload file template button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on upload file template button");
			Assert.fail("failed due to either upload file is not visible or not clickable");
		}
	}

	public static void uploadFile_inPopUp(String file_relativePath) throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.uploadFileTemplate_popUp_browsButton()));
			ComponentCodePage.uploadFileTemplate_popUp_browsButton()
					.sendKeys(System.getProperty("user.dir") + file_relativePath);
			wait.until(ExpectedConditions
					.elementToBeClickable(ComponentCodePage.uploadFileTemplate_popUp_upload_button()));
			wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.uploadFileTemplate_popUp_upload_button()));
			Assert.assertTrue(ComponentCodePage.uploadFileTemplate_popUp_upload_button().isDisplayed()
					&& ComponentCodePage.uploadFileTemplate_popUp_upload_button().isEnabled());
			utilities.Utils.click(ComponentCodePage.uploadFileTemplate_popUp_upload_button());
			Constants.test.log(Status.PASS, "Upload file");
		} catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, "Upload file");
			Assert.fail("upload file was unsuccessful");
		}
	}

	public static void clickOnProcessRecordsButton() {
		try {
			// wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.proceesRecords_button()));
			Thread.sleep(5000);
			Assert.assertTrue(ComponentCodePage.proceesRecords_button().isDisplayed()
					&& ComponentCodePage.proceesRecords_button().isEnabled());
			Utils.click(ComponentCodePage.proceesRecords_button());
			// wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.click_here_linkToReturnToMainScreen()));
//			utilities.Utils.click(ComponentCodePage.click_here_linkToReturnToMainScreen());
			Constants.test.log(Status.PASS, "click on process records button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on process records button");
			Assert.fail("failed due to either process record buttion is not visible or not clickable");
		}
	}

	public static void select_DataType(String option) {
		try {
			ComponentCodePage.dataType_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from data type drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from data type drop down");
			Assert.fail("failed to select an option from data type drop down");
		}
	}

	public static void select_RecordType(String option) {
		try {
			ComponentCodePage.recordType_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from Record type drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from Record type drop down");
			Assert.fail("failed to select an option from Record type drop down");
		}
	}

	public static void select_PlanYear(String option) {
		try {
			ComponentCodePage.planYear_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from paln year drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from paln year drop down");
			Assert.fail("failed to select an option from paln year drop down");
		}
	}

	public static void select_ContractNumber_individual(String option) {
		try {
			ComponentCodePage.contractNumber_dropdown_individual().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from contract number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from contract number drop down");
			Assert.fail("failed to select an option from contract number drop down");
		}
	}

	public static void select_ContractNumber_employer(String option) {
		try {
			ComponentCodePage.contractNumber_dropdown_employer().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from contract number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from contract number drop down");
			Assert.fail("failed to select an option from contract number drop down");
		}
	}

	public static void select_PBPNumber_individual(String option) {
		try {
			ComponentCodePage.PBPnumber_dropdown_individual().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from PBP number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from PBP number drop down");
			Assert.fail("failed to select an option from PBP number drop down");
		}
	}

	public static void select_PBPNumber_employer(String option) {
		try {
			ComponentCodePage.PBPnumber_dropdown_employer().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from PBP number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from PBP number drop down");
			Assert.fail("failed to select an option from PBP number drop down");
		}
	}

	public static void select_groupNumber(String option) {
		try {
			ComponentCodePage.groupNumber_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from group number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from group number drop down");
			Assert.fail("failed to select an option from group number drop down");
		}
	}

	public static void enter_ComponentCode(String componentCode) {
		try {
			ComponentCodePage.componentCode_textField().sendKeys(componentCode);
			Constants.test.log(Status.PASS, "Entering component code");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering component code");
			Assert.fail("failed to enter component code");
		}
	}

	public static void select_effectiveDatee(String option) {
		try {
			ComponentCodePage.effectiveDate_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from effective date drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from effective date drop down");
			Assert.fail("failed to select an option from effective date drop down");
		}
	}

	public static void select_masterGroup(String option) {
		try {
			ComponentCodePage.masterGroup_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from master group drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from master group drop down");
			Assert.fail("failed to select an option from master group drop down");
		}
	}

	public static void select_division(String option) {
		try {
			ComponentCodePage.division_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from division drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from division drop down");
			Assert.fail("failed to select an option from division drop down");
		}
	}

	public static void select_compareEffectiveDate(String option) {
		try {
			ComponentCodePage.compareEffectiveDate_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare effective date drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare effective date drop down");
			Assert.fail("failed to select an option from compare effective date drop down");
		}
	}

	public static void select_compareContractNumber_individual(String option) {
		try {
			ComponentCodePage.compareContractNumber_dropdown_individual().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare contract number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare contract number drop down");
			Assert.fail("failed to select an option from compare contract number drop down");
		}
	}

	public static void select_compareContractNumber_employer(String option) {
		try {
			ComponentCodePage.compareContractNumber_dropdown_employer().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare contract number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare contract number drop down");
			Assert.fail("failed to select an option from compare contract number drop down");
		}
	}

	public static void select_comparePBPNumber(String option) {
		try {
			ComponentCodePage.comparePBPnumber_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare PBP number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare PBP number drop down");
			Assert.fail("failed to select an option from compare PBP number drop down");
		}
	}

	public static void select_compareGroupNumber(String option) {
		try {
			ComponentCodePage.compareGroupNumber_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare group number drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare group number drop down");
			Assert.fail("failed to select an option from compare group number drop down");
		}
	}

	public static void select_compareMasterGroup(String option) {
		try {
			ComponentCodePage.compareMasterGroup_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare master group drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare master group drop down");
			Assert.fail("failed to select an option from compare master group drop down");
		}
	}

	public static void select_compareDivision(String option) {
		try {
			ComponentCodePage.compareDivision_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from compare division drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from compare division drop down");
			Assert.fail("failed to select an option from compare division drop down");
		}
	}

	public static void clickOnSearchButton() {
		try {
			Thread.sleep(3000);
			Utils.click(ComponentCodePage.search_button());
			Constants.test.log(Status.PASS, "click on search button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search button");
			Assert.fail("failed to to click on search buttion");
		}
	}

	@SuppressWarnings("resource")
	public static void compareUploadedFileDetailsWithDB(String file_relativePath)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		Thread.sleep(3000);

		File file = new File((String) "./src/test/java/testData/MAPS_INFOBANK.xlsm");
		File file1 = new File((String) System.getProperty("user.dir") + file_relativePath);

		// for Info bank
		FileInputStream query_Excel = new FileInputStream(file);
		XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
		XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");

		// for input sheet
		FileInputStream input_Excel = new FileInputStream(file1);
		XSSFWorkbook inputWorkbook = new XSSFWorkbook(input_Excel);
		XSSFSheet input_Sheet = inputWorkbook.getSheet("Sheet1");

		List<String> InputValues = new ArrayList<String>();
		for (int i = 1; i < input_Sheet.getRow(0).getLastCellNum(); i++) {
			InputValues.add(input_Sheet.getRow(1).getCell(i).getStringCellValue());
		}

		String verSQLQuery = SQL_Sheet.getRow(1).getCell(1).getStringCellValue();
		verSQLQuery = verSQLQuery.replace("parameter1", input_Sheet.getRow(1).getCell(1).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter2", input_Sheet.getRow(1).getCell(2).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter3", input_Sheet.getRow(1).getCell(3).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter4", input_Sheet.getRow(1).getCell(4).getStringCellValue());

		// Database connection
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Connection connection =
		// DriverManager.getConnection(Constants.DATABASE_URL_SQL_TEST3,
		// Constants.DATABASE_USERNAME_SQL_TEST3,
		// Constants.DATABASE_PASSWORD_SQL_TEST3);
		// Statement statement = connection.createStatement();
		// ResultSet Constants.resultset = statement.executeQuery(verSQLQuery);
		// ResultSetMetaData Constants.resultsetMetadata =
		// Constants.resultset.getMetaData();
		Utils.connectToSqlserverDB();
		Thread.sleep(3000);
		Constants.resultset = Constants.statement.executeQuery(verSQLQuery);
		Thread.sleep(3000);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}
		List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());
		if (InputValues.size() == DBvalues.size()) {
			boolean flag = true;
			for (int i = 0; i < InputValues.size(); i++) {
				if (flag == true) {
					try {
						if (InputValues.get(i).isEmpty() && DBvaluesList.get(i) == null) {
							Assert.assertTrue(true);
						} else if (InputValues.get(i).isEmpty() && DBvaluesList.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!InputValues.get(i).isEmpty() && DBvaluesList.get(i) == null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break;
						} else {
							if (InputValues.get(i).equalsIgnoreCase(DBvaluesList.get(i)) == true) {
								flag = true;
							} else {
								flag = false;
							}
						}
					} catch (Exception e) {
						Constants.test.log(Status.FAIL, "compare search results with DB values");
						Assert.fail("failed to to compare uploaded values with DB values");
						break;
					}
				} else {
					Constants.test.log(Status.FAIL, "compare search results with DB values");
					Assert.fail();
					break;
				}
			}
			if (flag == true) {
				Constants.test.log(Status.PASS, "compare search results with DB values");
			}
		} else {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail();
		}

	}

	public static void compareUploadedFileDetailsWithDB_Employee(String file_relativePath)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException, ParseException {

		Thread.sleep(3000);

		File file = new File((String) "./src/test/java/testData/MAPS_INFOBANK.xlsm");
		File file1 = new File((String) System.getProperty("user.dir") + file_relativePath);
		FileInputStream query_Excel = new FileInputStream(file);
		XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
		XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");

		FileInputStream input_Excel = new FileInputStream(file1);
		XSSFWorkbook inputWorkbook = new XSSFWorkbook(input_Excel);
		XSSFSheet input_Sheet = inputWorkbook.getSheet("Sheet1");

		List<String> InputValues = new ArrayList<String>();
		for (int i = 1; i < input_Sheet.getRow(0).getLastCellNum(); i++) {
			InputValues.add(input_Sheet.getRow(1).getCell(i).getStringCellValue().toString());
		}
		String date = Utils.convertDateFormat(InputValues.get(6));
		InputValues.set(6, date);
		String verSQLQuery = SQL_Sheet.getRow(2).getCell(1).getStringCellValue();
		verSQLQuery = verSQLQuery.replace("parameter1", input_Sheet.getRow(1).getCell(1).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter2", input_Sheet.getRow(1).getCell(2).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter3", input_Sheet.getRow(1).getCell(3).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter4", input_Sheet.getRow(1).getCell(4).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter5", input_Sheet.getRow(1).getCell(5).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter6", input_Sheet.getRow(1).getCell(6).getStringCellValue());
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//
		// Connection connection =
		// DriverManager.getConnection(Constants.DATABASE_URL_SQL_TEST3,
		// Constants.DATABASE_USERNAME_SQL_TEST3,
		// Constants.DATABASE_PASSWORD_SQL_TEST3);
		// Statement statement = connection.createStatement();
		// ResultSet Constants.resultset = statement.executeQuery(verSQLQuery);
		// ResultSetMetaData Constants.resultsetMetadata =
		// Constants.resultset.getMetaData();
		Utils.connectToSqlserverDB();
		Thread.sleep(3000);
		Constants.resultset = Constants.statement.executeQuery(verSQLQuery);
		Thread.sleep(3000);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}
		List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());
		for (int i = 0; i < DBvalues.size(); i++) {
			System.out.println(InputValues.get(i));
			System.out.println(DBvaluesList.get(i));
		}
		if (InputValues.size() == DBvalues.size()) {
			boolean flag = true;
			for (int i = 0; i < InputValues.size(); i++) {
				if (flag == true) {
					try {
						if (InputValues.get(i).isEmpty() && DBvaluesList.get(i) == null) {
							Assert.assertTrue(true);
						} else if (InputValues.get(i).isEmpty() && DBvaluesList.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!InputValues.get(i).isEmpty() && DBvaluesList.get(i) == null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break;
						} else {
							if (InputValues.get(i).equalsIgnoreCase(DBvaluesList.get(i)) == true) {
								flag = true;
							} else {
								flag = false;
							}
						}
					} catch (Exception e) {
						Constants.test.log(Status.FAIL, "compare search results with DB values");
						Assert.fail("failed to to compare uploaded values with DB values");
						break;
					}
				} else {
					Constants.test.log(Status.FAIL, "compare search results with DB values");
					Assert.fail();
					break;
				}
			}
			if (flag == true) {
				Constants.test.log(Status.PASS, "compare search results with DB values");
			}
		} else {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail();
		}

	}

	public static void compareUploadedFileDetailsWithDB_Delete(String file_relativePath)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {

		Thread.sleep(3000);

		File file = new File((String) "./src/test/java/testData/MAPS_INFOBANK.xlsm");
		File file1 = new File((String) System.getProperty("user.dir") + file_relativePath);
		FileInputStream query_Excel = new FileInputStream(file);
		XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
		XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");

		FileInputStream input_Excel = new FileInputStream(file1);
		XSSFWorkbook inputWorkbook = new XSSFWorkbook(input_Excel);
		XSSFSheet input_Sheet = inputWorkbook.getSheet("Sheet1");

		String verSQLQuery = SQL_Sheet.getRow(1).getCell(1).getStringCellValue();
		verSQLQuery = verSQLQuery.replace("parameter1", input_Sheet.getRow(1).getCell(1).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter2", input_Sheet.getRow(1).getCell(2).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter3", input_Sheet.getRow(1).getCell(3).getStringCellValue());
		verSQLQuery = verSQLQuery.replace("parameter4", input_Sheet.getRow(1).getCell(4).getStringCellValue());

		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//
		// Connection connection =
		// DriverManager.getConnection(Constants.DATABASE_URL_SQL_TEST3,
		// Constants.DATABASE_USERNAME_SQL_TEST3,
		// Constants.DATABASE_PASSWORD_SQL_TEST3);
		// Statement statement = connection.createStatement();
		// ResultSet Constants.resultset = statement.executeQuery(verSQLQuery);
		Utils.connectToSqlserverDB();
		Thread.sleep(3000);
		Constants.resultset = Constants.statement.executeQuery(verSQLQuery);
		Thread.sleep(3000);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		if (!Constants.resultset.next()) {
			Constants.test.log(Status.PASS, "compare search results with DB values");
		} else {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to compare search results with DB values");
		}
	}

	public static void compareSearchResultWithDBvalues_individual()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {
			Thread.sleep(3000);

			File file = new File((String) "./src/test/java/testData/MAPS_INFOBANK.xlsm");
			FileInputStream query_Excel = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
			XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");
			String verSQLQuery = SQL_Sheet.getRow(3).getCell(1).getStringCellValue();
			verSQLQuery = verSQLQuery.replace("parameter1",
					ComponentCodePage.searchResults_tableValues(1).get(0).getText());
			verSQLQuery = verSQLQuery.replace("parameter2",
					ComponentCodePage.searchResults_tableValues(1).get(2).getText());
			verSQLQuery = verSQLQuery.replace("parameter3",
					ComponentCodePage.searchResults_tableValues(1).get(3).getText());
			verSQLQuery = verSQLQuery.replace("parameter4",
					ComponentCodePage.searchResults_tableValues(1).get(1).getText());

			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//
			// Connection connection =
			// DriverManager.getConnection(Constants.DATABASE_URL_SQL_TEST3,
			// Constants.DATABASE_USERNAME_SQL_TEST3,
			// Constants.DATABASE_PASSWORD_SQL_TEST3);
			// Statement statement = connection.createStatement();
			// ResultSet Constants.resultset =
			// statement.executeQuery(verSQLQuery);
			// ResultSetMetaData Constants.resultsetMetadata =
			// Constants.resultset.getMetaData();
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(verSQLQuery);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
			System.out.println(((ResultSet) Constants.resultsetMetadata).getString(2));
			for (int i = 0; Constants.resultset.next(); i++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}

			List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());

			if (ComponentCodePage.searchResults_tableHeadingsCount() == DBvaluesList.size()) {
				boolean flag = true;
				lable: for (int i = 1; i <= ComponentCodePage.searchResults_numberOfRows().size(); i++) {
					int j = 0;
					for (WebElement element : ComponentCodePage.searchResults_tableValues(i)) {
						if (element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) == null) {
							Assert.assertTrue(true);
						} else if (element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) != null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break lable;
						} else if (!element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) == null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break lable;
						} else {
							if (element.getText().trim().equalsIgnoreCase(DBvaluesList.get(j)) == true) {
								flag = true;
							} else {
								flag = false;
								break lable;
							}
						}
						j++;
					}
				}
				if (flag == true) {
					Constants.test.log(Status.PASS, "compare search results with DB values");
				} else {
					Constants.test.log(Status.FAIL, "compare search results with DB values");
					Assert.fail();
				}
			} else {
				Constants.test.log(Status.FAIL, "compare search results with DB values");
				Assert.fail("failed to compare search results with DB values");
			}
		} catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to compare search results with DB values");
		}
	}

	public static void compareSearchResultWithDBvalues_employer()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {
			Thread.sleep(3000);

			File file = new File((String) "./src/test/java/testData/MAPS_INFOBANK.xlsm");
			FileInputStream query_Excel = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
			XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");
			String verSQLQuery = SQL_Sheet.getRow(3).getCell(1).getStringCellValue();
			verSQLQuery = verSQLQuery.replace("parameter1",
					ComponentCodePage.searchResults_tableValues(1).get(0).getText());
			verSQLQuery = verSQLQuery.replace("parameter2",
					ComponentCodePage.searchResults_tableValues(1).get(2).getText());
			verSQLQuery = verSQLQuery.replace("parameter3",
					ComponentCodePage.searchResults_tableValues(1).get(3).getText());
			verSQLQuery = verSQLQuery.replace("parameter4",
					ComponentCodePage.searchResults_tableValues(1).get(1).getText());

			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//
			// Connection connection =
			// DriverManager.getConnection(Constants.DATABASE_URL_SQL_TEST3,
			// Constants.DATABASE_USERNAME_SQL_TEST3,
			// Constants.DATABASE_PASSWORD_SQL_TEST3);
			// Statement statement = connection.createStatement();
			// ResultSet Constants.resultset =
			// statement.executeQuery(verSQLQuery);
			// ResultSetMetaData Constants.resultsetMetadata =
			// Constants.resultset.getMetaData();
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(verSQLQuery);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
			for (int i = 0; Constants.resultset.next(); i++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}

			List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());

			if (ComponentCodePage.searchResults_tableHeadingsCount() == DBvaluesList.size()) {
				boolean flag = true;
				lable: for (int i = 1; i <= ComponentCodePage.searchResults_numberOfRows().size(); i++) {
					int j = 0;
					for (WebElement element : ComponentCodePage.searchResults_tableValues(i)) {
						if (element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) == null) {
							Assert.assertTrue(true);
						} else if (element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) != null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break lable;
						} else if (!element.getText().equalsIgnoreCase("") && DBvaluesList.get(j) == null) {
							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break lable;
						} else {
							if (element.getText().trim().equalsIgnoreCase(DBvaluesList.get(j)) == true) {
								flag = true;
							} else {
								flag = false;
								break lable;
							}
						}
						j++;
					}
				}
				if (flag == true) {
					Constants.test.log(Status.PASS, "compare search results with DB values");
				} else {
					Constants.test.log(Status.FAIL, "compare search results with DB values");
					Assert.fail();
				}
			} else {
				Constants.test.log(Status.FAIL, "compare search results with DB values");
				Assert.fail("failed to compare search results with DB values");
			}
		} catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to compare search results with DB values");
		}
	}

	public static void checkErrorMessage_min4Chars_individual() {
		try {
			File file = new File((String) "./src/test/java/testData/TC_IND_ErrorMessage_Min4Chars.xlsx");
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(in);
			XSSFSheet sheet = queryworkbook.getSheet("Sheet1");
			String componentCode = sheet.getRow(0).getCell(5).getStringCellValue();
			String componentCodeValue = sheet.getRow(1).getCell(5).getStringCellValue();
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase(
					componentCode + " with value of: " + componentCodeValue + ", length cannot be less 4 characters"));
			Constants.test.log(Status.PASS, "check error message for min 4 characters validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for min 4 characters validation");
			Assert.fail("failed to check error message for min 4 characters validation");
		}
	}

	public static void checkErrorMessage_min4Chars_employer() {
		try {
			File file = new File(
					(String) "./src/test/java/testData/EmployerGroup_Component codes_ErrorMessage_Min4Char.xlsx");
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(in);
			XSSFSheet sheet = queryworkbook.getSheet("Sheet1");
			String componentCode = sheet.getRow(0).getCell(8).getStringCellValue().substring(0,
					(sheet.getRow(0).getCell(8).getStringCellValue().length() - 1))
					+ " "
					+ sheet.getRow(0).getCell(8).getStringCellValue().substring(
							(sheet.getRow(0).getCell(8).getStringCellValue().length() - 1),
							sheet.getRow(0).getCell(8).getStringCellValue().length());
			String componentCodeValue = sheet.getRow(1).getCell(8).getStringCellValue();
			System.out.println(
					componentCode + " with value of: " + componentCodeValue + ", length cannot be less 4 characters");
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase(
					componentCode + " with value of: " + componentCodeValue + ", length cannot be less 4 characters"));
			Constants.test.log(Status.PASS, "check error message for min 4 characters validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for min 4 characters validation");
			Assert.fail("failed to check error message for min 4 characters validation");
		}
	}

	public static void checkErrorMessage_max30Chars_individual() {
		try {
			File file = new File((String) "./src/test/java/testData/TC_IND_ErrorMessage_Max30Chars.xlsx");
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(in);
			XSSFSheet sheet = queryworkbook.getSheet("Sheet1");
			String componentCode = sheet.getRow(0).getCell(5).getStringCellValue();
			String componentCodeValue = sheet.getRow(1).getCell(5).getStringCellValue();
			System.out.println(componentCode + " with value of: " + componentCodeValue
					+ ", length cannot be exceed 30 characters");
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase(componentCode
					+ " with value of: " + componentCodeValue + ", length cannot be exceed 30 characters"));
			Constants.test.log(Status.PASS, "check error message for max 30 characters validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for max 30 characters validation");
			Assert.fail("failed to check error message for max 30 characters validation");
		}
	}

	public static void checkErrorMessage_max30Chars_employer() {
		try {
			File file = new File(
					(String) "./src/test/java/testData/EmployerGroup_Component codes_ErrorMessage_Max30Chars.xlsx");
			FileInputStream in = new FileInputStream(file);
			XSSFWorkbook queryworkbook = new XSSFWorkbook(in);
			XSSFSheet sheet = queryworkbook.getSheet("Sheet1");
			String componentCode = sheet.getRow(0).getCell(8).getStringCellValue().substring(0,
					(sheet.getRow(0).getCell(8).getStringCellValue().length() - 1))
					+ " "
					+ sheet.getRow(0).getCell(8).getStringCellValue().substring(
							(sheet.getRow(0).getCell(8).getStringCellValue().length() - 1),
							sheet.getRow(0).getCell(8).getStringCellValue().length());
			String componentCodeValue = sheet.getRow(1).getCell(8).getStringCellValue();
			System.out.println(componentCode + " with value of: " + componentCodeValue
					+ ", length cannot be exceed 30 characters");
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase(componentCode
					+ " with value of: " + componentCodeValue + ", length cannot be exceed 30 characters"));
			Constants.test.log(Status.PASS, "check error message for max 30 characters validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for max 30 characters validation");
			Assert.fail("failed to check error message for max 30 characters validation");
		}
	}

	public static void checkErrorMessage_invalidPlanYear_individual() {
		try {
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase("Invalid plan year format"));
			Constants.test.log(Status.PASS, "check error message for invalid plan year validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for invalid plan year validation");
			Assert.fail("failed to check error message for invalid plan year validation");
		}
	}

	public static void checkErrorMessage_invalidPlanYear_employer() {
		try {
			Assert.assertTrue(
					ComponentCodePage.errorMessage().getText().equalsIgnoreCase("Invalid effective date format"));
			Constants.test.log(Status.PASS, "check error message for invalid plan year validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for invalid plan year validation");
			Assert.fail("failed to check error message for invalid plan year validation");
		}
	}

	public static void checkErrorMessage_invalidPlanData() {
		try {
			Assert.assertTrue(ComponentCodePage.errorMessage().getText().equalsIgnoreCase("No matching plan found"));
			Constants.test.log(Status.PASS, "check error message for invalid plan data validation");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for invalid plan data validation");
			Assert.fail("failed to check error message for invalid plan data validation");
		}
	}
}
