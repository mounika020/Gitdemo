package actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.ComponentCodePage;
import pageObjects.EOBGroupException;
import pageObjects.Groupadmin;
import pageObjects.Header;
import utilities.Constants;
import utilities.Utils;

public class Actions_GroupAdmin extends BaseClass {

		public Actions_GroupAdmin(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		static FileOutputStream outputStream = null;
		static Workbook outWorkbook = null;
		static Sheet outSheet;
		static Row row = null;
		
		static WebDriverWait wait = new WebDriverWait(driver, 30000);
		public static LinkedHashMap<String, String> Inputvalues = new LinkedHashMap<String, String>();
		
		public static void clickOnAdmin() {
			try {
				Utils.click(Header.Admin_Link());
				Constants.test.log(Status.PASS, "click on Admin link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Admin link");
				Assert.fail("failed to click on Admin Link");
			}
		}

		public static void clickOnGroupAdmin_Link() {
			try {
				Utils.click(Header.GroupAdmin_Link());
				Constants.test.log(Status.PASS, "click on Group Admin link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Group Admin link");
				Assert.fail("failed to click on Group Admin Link");
			}
		}
		
		public static void clickOnSearchGroups_Link() throws InterruptedException {
			
		try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search-button']")));
			   Utils.click(Groupadmin.SearchGroups());
			 Thread.sleep(3000);
		
			
				Constants.test.log(Status.PASS, "click on SearchGroups link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "SearchGroups");
				Assert.fail("failed to click on SearchGroups");
			}

		}
		
		

		public static void clickOnMarkasEmployer_Button() throws InterruptedException {
			
		try {
			Groupadmin.ClickonMarkasEmployer().click();
			   //Utils.click(Groupadmin.ClickonMarkasEmployer());
//			   Thread.sleep(30000);
				Constants.test.log(Status.PASS, "click on SearchGroups link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "SearchGroups");
				Assert.fail("failed to click on SearchGroups");
			}

		}
	
		
		public static void VerifyIndividualGroupListScreen() {
			try {

				Assert.assertTrue(Groupadmin.IndividualGroupListScreen().getText()
						.equalsIgnoreCase("Individual Group List"));
				Constants.test.log(Status.PASS, "check message displayed for Individual Group List");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Individual Group List");
				Assert.fail("failed to check error message displayed for Individual Group List");
			}
		}

		public static void EnterGroupNumber(String GroupNumber) {
			try {
				if (GroupNumber.equalsIgnoreCase("null")) {
					Groupadmin.EnterGroupNumber_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "GroupNumber");
				} else {
					Groupadmin.EnterGroupNumber_textfield().sendKeys(GroupNumber);
					Constants.test.log(Status.PASS, "GroupNumber");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "GroupNumber");
				Assert.fail("failed to enter value in EnterGroupNumber text field");
			}
		}
		
		public static void EnterMasterGroupNumber(String GroupNumber) {
			try {
				if (GroupNumber.equalsIgnoreCase("null")) {
					Groupadmin.EnterMasterGroupNumber_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "GroupNumber");
				} else {
					Groupadmin.EnterMasterGroupNumber_textfield().sendKeys(GroupNumber);
					Constants.test.log(Status.PASS, "GroupNumber");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "GroupNumber");
				Assert.fail("failed to enter value in EnterGroupNumber text field");
			}
		}
		
		public static void EnterContract(String GroupNumber) {
			try {
				if (GroupNumber.equalsIgnoreCase("null")) {
					Groupadmin.EnterContract_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "GroupNumber");
				} else {
					Groupadmin.EnterContract_textfield().sendKeys(GroupNumber);
					Constants.test.log(Status.PASS, "GroupNumber");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "GroupNumber");
				Assert.fail("failed to enter value in EnterGroupNumber text field");
			}
		}
		
		public static void EnterPBP(String GroupNumber) {
			try {
				if (GroupNumber.equalsIgnoreCase("null")) {
					Groupadmin.EnterPBP_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "GroupNumber");
				} else {
					Groupadmin.EnterPBP_textfield().sendKeys(GroupNumber);
					Constants.test.log(Status.PASS, "GroupNumber");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "GroupNumber");
				Assert.fail("failed to enter value in EnterGroupNumber text field");
			}
		}
		
		public static void IndividualGroupListSiteName_Dropdown(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select SiteName");
				} else {
					Groupadmin.SiteName_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select SiteName");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from SiteName dropdown");
			}
		}	
		
		public static void IndividualGroupListYear_Dropdown(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('Year').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select Year");
				} else {
					Groupadmin.Year_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select Year");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from Year dropdown");
			}
		}	
		
		
		public static void IndividualGrouptype_Dropdown(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('Year').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select Year");
				} else {
					Groupadmin.Grouptype_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select Grouptype");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from Grouptype dropdown");
			}
		}	
		
		
		public static void IndividualGroupListClaimsSystem_Dropdown(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select ClaimsSystem");
				} else {
					Groupadmin.ClaimsSystem_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select ClaimsSystem");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from ClaimsSystem dropdown");
			}
		}
		
		public static LinkedHashMap<String, String> InputParameters() throws SQLException, ClassNotFoundException {

			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
			Inputvalues.put("MasterGroupNumber", inSheet.getRow(1).getCell(2).getStringCellValue());
			Inputvalues.put("GroupNumber", inSheet.getRow(1).getCell(0).getStringCellValue());
			Inputvalues.put("Contract", inSheet.getRow(1).getCell(4).getStringCellValue());
			Inputvalues.put("PBP", inSheet.getRow(1).getCell(5).getStringCellValue());
			Inputvalues.put("SiteName", inSheet.getRow(1).getCell(1).getStringCellValue());
			Inputvalues.put("Year", inSheet.getRow(1).getCell(3).getStringCellValue());
			Inputvalues.put("ClaimsSystem", inSheet.getRow(1).getCell(6).getStringCellValue());
			Inputvalues.put("TerminationDate", inSheet.getRow(1).getCell(7).getStringCellValue());
			Inputvalues.put("RxVendor", inSheet.getRow(1).getCell(8).getStringCellValue());
			Inputvalues.put("TerminationDate_1", inSheet.getRow(1).getCell(12).getStringCellValue());
			Inputvalues.put("RxVendor_1", inSheet.getRow(1).getCell(13).getStringCellValue());
			Inputvalues.put("GroupType", inSheet.getRow(1).getCell(14).getStringCellValue());
			return Inputvalues;
		}
		
		public static void clickOnEdit_Link() {
			try {
				Utils.click(Groupadmin.resultsetEdit());
				Constants.test.log(Status.PASS, "click on Edit link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Edit");
				Assert.fail("failed to click on Edit");
			}

		}
		
		public static void VerifyGroupEditScreen() {
			try {
				//System.out.println(Groupadmin.GroupEditScreen().getText());
				Assert.assertTrue(Groupadmin.GroupEditScreen().getText().trim()
						.equalsIgnoreCase("Group Edit"));
				Constants.test.log(Status.PASS, "check message displayed for Group Edit");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Group Edit");
				Assert.fail("failed to check error message displayed for Group Edit");
			}
		}
		
		public static void VerifyGroupEditScreen_Contract_PBP_Year() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_Contract_PBP_Year().getText()
						.equalsIgnoreCase("Contract / PBP / Year"));
				Constants.test.log(Status.PASS, "check message displayed for Contract_PBP_Year");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Contract_PBP_Year");
				Assert.fail("failed to check error message displayed for Contract_PBP_Year");
			}
		}
		
		public static void select_GroupType(String option) {
			try {
				
				Groupadmin.Grouptype_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select an option from group number drop down");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select an option from group number drop down");
				Assert.fail("failed to select an option from group number drop down");
			}
		}
		
		public static void VerifyGroupEditScreen_GroupNumber() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_GroupNumber().getText()
						.equalsIgnoreCase("Group Number"));
				Constants.test.log(Status.PASS, "check message displayed for Group Number");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Group Number");
				Assert.fail("failed to check error message displayed for Group Number");
			}
		}
		
		public static void VerifyGroupEditScreen_GroupName() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_GroupName().getText()
						.equalsIgnoreCase("Group Name"));
				Constants.test.log(Status.PASS, "check message displayed for Group Name");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Group Name");
				Assert.fail("failed to check error message displayed for Group Name");
			}
		}
		
		public static void VerifyGroupEditScreen_Location() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_Location().getText().trim()
						.equalsIgnoreCase("Location"));
				Constants.test.log(Status.PASS, "check message displayed for Location");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Location");
				Assert.fail("failed to check error message displayed for Location");
			}
		}
		
		public static void VerifyGroupEditScreen_EffectiveDate() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_EffectiveDate().getText().trim()
						.equalsIgnoreCase("Effective Date"));
				Constants.test.log(Status.PASS, "check message displayed for EffectiveDate");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for EffectiveDate");
				Assert.fail("failed to check error message displayed for EffectiveDate");
			}
		}
		
		public static void VerifyGroupEditScreen_TerminationDate() {
			try {
				Utils.click(Groupadmin.GroupEditScreen_TerminationDate());
				Constants.test.log(Status.PASS, "click on TerminationDate editable field");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Edit");
				Assert.fail("failed to click on Edit");
			}

		}
		
		public static void VerifyGroupEditScreen_RxVendor() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_RxVendor().getText().trim()
						.equalsIgnoreCase("RxVendor"));
				Constants.test.log(Status.PASS, "check message displayed for RxVendor");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for RxVendor");
				Assert.fail("failed to check error message displayed for RxVendor");
			}
		}
		
		public static void VerifyGroupEditScreen_GroupType() {
			try {

				Assert.assertTrue(Groupadmin.GroupEditScreen_GroupType().getText().trim()
						.equalsIgnoreCase("Group Type"));
				Constants.test.log(Status.PASS, "check message displayed for Group Type");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "check error message displayed for Group Type");
				Assert.fail("failed to check error message displayed for Group Type");
			}
		}
		
		public static void clickOnTerminationDate_Checkbox() {
			try {
				Utils.click(Groupadmin.GroupEditScreen_TerminationDate_Checkbox());
				Constants.test.log(Status.PASS, "click on TerminationDate Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "TerminationDate Checkbox");
				Assert.fail("failed to click on TerminationDate Checkbox");
			}
		}
		
		public static void clickOnRxVendor_Checkbox() {
			try {
				Utils.click(Groupadmin.GroupEditScreen_RxVendor_Checkbox());
				Constants.test.log(Status.PASS, "click on RxVendor Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "RxVendor Checkbox");
				Assert.fail("failed to click on RxVendor Checkbox");
			}

		}
		
		public static void EditTerminationDate(String TerminationDate) {

((JavascriptExecutor)driver).executeScript("arguments[0].value = '"+TerminationDate+"'", Groupadmin.EditTerminationDate_textfield());
				
		}
		
		public static void EditTerminationDate_1(String TerminationDate_1) {

			((JavascriptExecutor)driver).executeScript("arguments[0].value = '"+TerminationDate_1+"'", Groupadmin.EditTerminationDate_textfield());
							
					}
		
		public static void EditClearRxVendor() {
			Groupadmin.EditRxVendor_textfield().clear();
		
		}
		
		public static void EditRxVendor(String RxVendor) {
			
			try{
			 if (RxVendor.equalsIgnoreCase("null")) {
					Groupadmin.EditRxVendor_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "RxVendor");
				} else {
					Groupadmin.EditRxVendor_textfield().sendKeys(RxVendor);
					Constants.test.log(Status.PASS, "RxVendor");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "RxVendor");
				Assert.fail("failed to enter value in Enter RxVendor text field");
			}
		}
		
		public static void EditRxVendor_1(String RxVendor_1) {
			
			try{
			 if (RxVendor_1.equalsIgnoreCase("null")) {
					Groupadmin.EditRxVendor_textfield().sendKeys("");
					Constants.test.log(Status.PASS, "RxVendor");
				} else {
					Groupadmin.EditRxVendor_textfield().sendKeys(RxVendor_1);
					Constants.test.log(Status.PASS, "RxVendor");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "RxVendor");
				Assert.fail("failed to enter value in Enter RxVendor text field");
			}
		}
		
		public static void clickOnSaveOnEditScreen() {
			try {
				//Utils.click(Groupadmin.SaveOnEditScreen());
				Groupadmin.SaveOnEditScreen().click();
				Constants.test.log(Status.PASS, "click on Save Button");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Save Button");
				Assert.fail("failed to click on Save Button");
			}
		}
		
		public static void Alert_Accept() throws InterruptedException {
			// TODO Auto-generated method stub
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				Constants.test.log(Status.PASS, "check Alert is displayed");
			}

			catch (Exception e) {
				Constants.test.log(Status.FAIL, "check Alert is displayed");
				Assert.fail("failed to check Alert is displayed");
			}
		}
		
		public static void IndividualGroupList_ClearGroupNumber() {
			Groupadmin.EnterGroupNumber_textfield().clear();
		}
		
		public static void IndividualGroupList_ClearMasterGroupNumber() {
			Groupadmin.EnterMasterGroupNumber_textfield().clear();
		}
		
		public static void IndividualGroupList_ClearContract() {
			Groupadmin.EnterContract_textfield().clear();
		}
		
		public static void IndividualGroupList_ClearPBP() {
			Groupadmin.EnterPBP_textfield().clear();
		}
		
		public static void VerifyUpdatedData_TerminationDate() {
			try {
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
				Assert.assertTrue(Groupadmin.EditTerminationDate_textfield().getAttribute("value").trim()
						.equalsIgnoreCase(inSheet.getRow(1).getCell(7).getStringCellValue()));
				Constants.test.log(Status.PASS, "updated data is displayed for TerminationDate");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "updated data is displayed for TerminationDate");
				Assert.fail("updated data is not displayed for TerminationDate");
			}
		}
		
		
		public static void VerifyUpdatedData_RxVendor() {
			try {
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
			//System.out.println(Groupadmin.EditRxVendor_textfield().getAttribute("value"));
				String Rxvendor=Groupadmin.EditRxVendor_textfield().getAttribute("value");
				String comparerxvendor=inSheet.getRow(1).getCell(8).getStringCellValue();
				//System.out.println(inSheet.getRow(1).getCell(8).getStringCellValue());
				Assert.assertEquals(Rxvendor,comparerxvendor);
				Constants.test.log(Status.PASS, "updated data is displayed for RxVendor");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "updated data is displayed for RxVendor");
				Assert.fail("updated data is not displayed for RxVendor");
			}
		}
		public static void select_Group_inSearchgrid_Checkbox(String GroupNumber) {
			System.out.println("//table[@id='grid']/tbody/tr/td[text()='"+GroupNumber+"']/preceding-sibling::td/input");
			try {
				Utils.click(Groupadmin.SelectIndividualGrouprecord(GroupNumber));
				Constants.test.log(Status.PASS, "Checkbox was selected");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Checkbox was selected");
				Assert.fail("failed to select  checkbox ");
			}

		}
		
		public static void VerifyRecordsinDB() throws ClassNotFoundException, SQLException {
			// try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
			String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", Inputvalues.get("GroupNumber")).replace("parameter2",
					inSheet.getRow(1).getCell(10).getStringCellValue());
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			Assert.assertTrue(!Constants.resultset.next());
		}
		
		
		public static void CompareSearchResultWithDBvalues()
				throws ClassNotFoundException, SQLException, IOException, InterruptedException {

			Thread.sleep(3000);

			Thread.sleep(3000);
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
			String QEREY = Constants.Input_SQLS.getRow(31).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(3).getStringCellValue()).replace("parameter2",
					inSheet.getRow(1).getCell(0).getStringCellValue());
			
			String UpdatedTerminationDate_Value = Groupadmin.EditTerminationDate_textfield().getAttribute("value");
			String UpdatedRxVendor_Value = Groupadmin.EditRxVendor_textfield().getAttribute("value");

			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
			
			for (int k = 0; Constants.resultset.next(); k++) {

				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				
						DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

			}
			//Utils.convertDateFormat(UpdatedTerminationDate_Value);
			//System.out.println(UpdatedTerminationDate_Value);
//System.out.println(Utils.convertDateFormat(UpdatedTerminationDate_Value));
			Assert.assertEquals(DBvalues.get("TerminationDate"), Utils.convertDateFormat(UpdatedTerminationDate_Value), "Failed as TerminationDate not matched with DB");
			Assert.assertEquals(DBvalues.get("RxVendor"), UpdatedRxVendor_Value, "Failed as RxVendor not matched with DB");

		}
		
		public static void Compare_Status_withDbValus() throws ClassNotFoundException, SQLException {

			try {

				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
				String QEREY = Constants.Input_SQLS.getRow(82).getCell(1).getStringCellValue();
				QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(0).getStringCellValue()).replace("parameter2",
						inSheet.getRow(1).getCell(3).getStringCellValue());
				System.out.println(QEREY);
				Utils.connectToSqlserverDB();
				String Status = inSheet.getRow(1).getCell(15).getStringCellValue();
				System.out.println(Status);
				System.out.println(Status);
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				while (Constants.resultset.next()) {
					String DBstatus = Constants.resultset.getString("grouptypeid");
					Assert.assertEquals(DBstatus, Status);

				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "compare UI search results with database");
				Assert.fail("failed to compare UI search results with database");
			}

		}
		public static void clickOnCancelOnEditScreen() {
			try {
				//Utils.click(Groupadmin.SaveOnEditScreen());
				Groupadmin.CancelOnEditScreen().click();
				Constants.test.log(Status.PASS, "click on Cancel link");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Cancel link");
				Assert.fail("failed to click on Cancel link");
			}
		}
		

public static void clickOnflipgroup() {
	try {
		//Utils.click(Groupadmin.SaveOnEditScreen());
		Groupadmin.clickonflipgrouptype().click();
		Constants.test.log(Status.PASS, "click on Cancel link");
	} catch (Exception e) {
		Constants.test.log(Status.FAIL, "Cancel link");
		Assert.fail("failed to click on Cancel link");
	}
}
}		