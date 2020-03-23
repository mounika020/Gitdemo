package actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import miscellaneous.BaseClass;
import pageObjects.EOBGroupException;
import pageObjects.Header;
import utilities.Constants;
import utilities.Utils;

public class Action_EOB_Page extends BaseClass {

	public Action_EOB_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static FileOutputStream outputStream = null;
	static Workbook outWorkbook = null;
	static Sheet outSheet;
	static Row row = null;

	static WebDriverWait wait = new WebDriverWait(driver, 30000);
	public static LinkedHashMap<String, String> Inputvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Parametervalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> indiviualparameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Particularrowtext = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> logicaldeleteGroup = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> EmployerGroup = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> ManagedGroup = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Alllanguages = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> DifferentEffectivedate = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Searchresults = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroup = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> inputparameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> inputvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> parametervalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupparameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues_updated_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues_updated_DBvalue = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupvaluesDBvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues_DBvalue = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupvalues_DBvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employergroupparameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualvalues_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> employer_groupparameters_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individual_groupparameters = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupvalues_DBvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupparameters_DBvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroupparameters_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroup_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualgroups_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individual_groups_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individual_groups_inDB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individual_groups_inDBvalues = new LinkedHashMap<String, String>();
	public static ArrayList<String> searchresults = new ArrayList<String>();
	public static ArrayList<String> updatedresults = new ArrayList<String>();
	public static ArrayList<String> updated_results = new ArrayList<String>();

	public static void clickOnMaterials() {
		try {
			Utils.click(Header.Materials_Link());
			Constants.test.log(Status.PASS, "click on Materials link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Materials link");
			Assert.fail("failed to click on Materials Link");
		}
	}

	public static void clickOnEOB_Link() {
		try {

			Utils.click(Header.EOB_Link());
			Constants.test.log(Status.PASS, "click on EOB link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on EOB link");
			Assert.fail("failed to click on EOB Link");
		}
	}

	public static void VerifySearchEOBGroupExceptions_Button() {
		try {

			Assert.assertTrue(EOBGroupException.SearchEOBGroupExceptions().isDisplayed());
			Constants.test.log(Status.PASS, "SearchEOBGroupExceptions button is displayed for  EOBPlanRuleList");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "SearchEOBGroupExceptions button is displayed for  EOBPlanRuleList");
			Assert.fail("failed to verify SearchEOBGroupExceptions button for  EOBPlanRuleList");
		}
	}

	public static void VerifyCreateNewEOBPlanRule_Button() {
		try {

			Assert.assertTrue(EOBGroupException.EOBPlanRuleListScreen().isDisplayed());
			Constants.test.log(Status.PASS, "EOBPlanRuleList button is displayed for  EOBPlanRuleList");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "EOBPlanRuleList  button is displayed for  EOBPlanRuleList");
			Assert.fail("failed to verify EOBPlanRuleList  button for  EOBPlanRuleList");
		}
	}

	public static void VerifyEOBGroupExceptionMastergroupnumber_IsEmpty() {
		try {

			Assert.assertTrue(EOBGroupException.EnterMasterGroupNumber_textfield().getText().isEmpty());
			Constants.test.log(Status.PASS, "GroupNumber is displayed as empty");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "GroupNumber is displayed as empty");
			Assert.fail("failed to verify GroupNumber is displayed as empty");
		}
	}

	public static void VerifyEOBGroupExceptionGroupEffectiveDate_IsEmpty() {
		try {

			Assert.assertTrue(EOBGroupException.SearchGroupEffectiveDate_textfield().getText().isEmpty());
			Constants.test.log(Status.PASS, "GroupEffectiveDate is displayed as empty");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "GroupEffectiveDate is displayed as empty");
			Assert.fail("failed to verify GroupEffectiveDate is displayed as empty");
		}
	}

	public static void VerifyEOBGroupExceptionGroupnumber_IsEmpty() {
		try {

			Assert.assertTrue(EOBGroupException.EnterGroupNumber_textfield().getText().isEmpty());
			Constants.test.log(Status.PASS, "MasterGroupNumber is displayed as empty");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "MasterGroupNumber is displayed as empty");
			Assert.fail("failed to verify MasterGroupNumber is displayed as empty");
		}
	}

	public static void VerifyCreateNewEOBGroupExceptions_Button() {
		try {

			Assert.assertTrue(EOBGroupException.CreateNewEOBGroupException().isDisplayed());
			Constants.test.log(Status.PASS, "CreateNewEOBGroupExceptions button is displayed for  EOBPlanRuleList");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "CreateNewEOBGroupExceptions button is displayed for  EOBPlanRuleList");
			Assert.fail("failed to verify CreateNewEOBGroupExceptions button for  EOBPlanRuleList");
		}
	}

	public static void clickOnCreateNewEOBGroupException_Link() {
		try {
			Utils.click(EOBGroupException.CreateNewEOBGroupException());
			Constants.test.log(Status.PASS, "click on CreateNewEOBGroupException link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "CreateNewEOBGroupException");
			Assert.fail("failed to click on CreateNewEOBGroupException");
		}

	}

	public static void clickOnUpdate_button() {
		try {
			Utils.click(EOBGroupException.Clickonupdatebutton());
			Constants.test.log(Status.PASS, "click on update button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on update button");
			Assert.fail("failed to click on update button");
		}

	}
	public static void clickOnsave_button() {
		try {
			Utils.click(EOBGroupException.clickonupdatescreensavebutton());
			Constants.test.log(Status.PASS, "click on save button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on save button");
			Assert.fail("failed to click on update button");
		}

	}


	public static void EnterMasterGroupNumber(String MasterGroupNumber) {
		try {
			if (MasterGroupNumber.equalsIgnoreCase("null")) {
				EOBGroupException.EnterMasterGroupNumber_textfield().sendKeys("");
				Constants.test.log(Status.PASS, "EnterMasterGroupNumber");
			} else {
				EOBGroupException.EnterMasterGroupNumber_textfield().sendKeys(MasterGroupNumber);
				Constants.test.log(Status.PASS, "EnterMasterGroupNumber");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "EnterMasterGroupNumber");
			Assert.fail("failed to enter value in EnterMasterGroupNumber text field");
		}
	}

	public static void EnterGroupNumber(String GroupNumber) {
		try {
			if (GroupNumber.equalsIgnoreCase("null")) {
				EOBGroupException.EnterGroupNumber_textfield().sendKeys("");
				Constants.test.log(Status.PASS, "GroupNumber");
			} else {
				EOBGroupException.EnterGroupNumber_textfield().sendKeys(GroupNumber);
				Constants.test.log(Status.PASS, "GroupNumber");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "GroupNumber");
			Assert.fail("failed to enter value in EnterGroupNumber text field");
		}
	}

	public static void EnterGroupEffectiveDate(String GroupEffectiveDate) {
		try {
			System.out.println(GroupEffectiveDate);
			if (GroupEffectiveDate.equalsIgnoreCase("null")) {
				EOBGroupException.EnterGroupEffectiveDate_textfield().sendKeys("");
				Constants.test.log(Status.PASS, "GroupEffectiveDate");
			} else {
				EOBGroupException.EnterGroupEffectiveDate_textfield().sendKeys(GroupEffectiveDate);
				Constants.test.log(Status.PASS, "GroupEffectiveDate");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "GroupEffectiveDate");
			Assert.fail("failed to enter value in GroupEffectiveDate text field");
		}

	}

	public static void EOBGroupExceptiongroupeffectivedate_textfield(String GroupEffectiveDate) {
		try {
			if (GroupEffectiveDate.equalsIgnoreCase("null")) {
				EOBGroupException.SearchGroupEffectiveDate_textfield().sendKeys("");
				Constants.test.log(Status.PASS, "GroupEffectiveDate");
			} else {
				EOBGroupException.SearchGroupEffectiveDate_textfield().sendKeys(GroupEffectiveDate);
				Constants.test.log(Status.PASS, "GroupEffectiveDate");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "GroupEffectiveDate");
			Assert.fail("failed to enter value in GroupEffectiveDate text field");
		}

	}

	public static void VerifyEOBGroupExceptionSearchgrid() {
		try {

			Assert.assertTrue(EOBGroupException.verifysearchgrid().isDisplayed());
			System.out.println(EOBGroupException.verifysearchgrid().getText());
			Constants.test.log(Status.PASS, "Searchgrid is displayed for  EOBGroupException");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Searchgrid is displayed for  EOBGroupException");
			Assert.fail("failed to verify Searchgrid is displayed for  EOBGroupException");
		}
	}

	public static void VerifyEOBGroupExceptionSearchgrid_isempty() {
		try {
			Assert.assertTrue(EOBGroupException.verifysearchgrid().isDisplayed());
			Constants.test.log(Status.PASS, "Searchgrid is displayed for  EOBGroupException");

		} catch (NoSuchElementException e) {
			System.out.println("element not found");
		}
	}

	public static void EOBGroupExceptionPlanYear_Dropdown(String option) {
		try {
			
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.Search_PlanYear_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	public static void EOBGroupExceptionCategory_Dropdown(String option) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='eob-ajax-loading']")));
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				
				EOBGroupException.Search_Category_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	public static void EOBGroupExceptionContract_Dropdown(String option) {
		
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='eob-ajax-loading']")));
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.Search_Contract_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	public static void EOBGroupExceptionPBP_Dropdown(String option) {
		try {
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='eob-ajax-loading']")));
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.Search_PBP_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	public static void EOBGroupExceptionSiteName_Dropdown(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.SearchSiteName_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void selectSiteName(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.SiteName_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void selectSiteName_logicaldelete(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				EOBGroupException.SiteName_dropdown().selectByValue(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void EOBGroupExceptionsEOBIndicator_dropdown(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				System.out.println("enter");
				EOBGroupException.SearchEOBIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void EOBGroupExceptionsupdateEOBIndicator_dropdown(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				System.out.println("enter");
				EOBGroupException.updateEOBIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void selectEOBIndicator(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				System.out.println("enter");
				EOBGroupException.EOBIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void EOBGroupExceptionslanguages_dropdown(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				System.out.println("enter");
				EOBGroupException.Searchlanguages_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void VerifyEOBGroupExceptionsEOBIndicator_dropdown_isempty() {
		try {
			Assert.assertTrue(
					EOBGroupException.SearchEOBIndicator_dropdown().getFirstSelectedOption().getText().isEmpty());
			Constants.test.log(Status.PASS, "select status");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void VerifyEOBGroupExceptionslanguages_dropdown_isempty() {
		try {
			Assert.assertTrue(
					EOBGroupException.SearchEOBIndicator_dropdown().getFirstSelectedOption().getText().isEmpty());
			Constants.test.log(Status.PASS, "select status");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void VerifyEOBGroupExceptionSiteName_Dropdown_isempty() {
		try {
			Assert.assertTrue(
					EOBGroupException.SearchEOBIndicator_dropdown().getFirstSelectedOption().getText().isEmpty());
			Constants.test.log(Status.PASS, "select status");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void Clear_Groupeffectivedate_Textfield() {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].value ='';",
					EOBGroupException.EnterGroupEffectiveDate_textfield());
			Constants.test.log(Status.PASS, " Clear the Groupeffectivedate Textfield");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void Clear_Mastergroupnumber_Textfield() {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].value ='';",
					EOBGroupException.EnterMasterGroupNumber_textfield());
			Constants.test.log(Status.PASS, " Clear the Groupeffectivedate Textfield");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}

	public static void Clear_Groupnumber_Textfield() {
		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].value ='';",
					EOBGroupException.EnterGroupNumber_textfield());
			Constants.test.log(Status.PASS, " Clear the Groupeffectivedate Textfield");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	

	public static void select_ArabicCheckbox() {
		try {
			Utils.click(EOBGroupException.Arabic_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Arabic checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Arabic checkbox for EOB Language");
			Assert.fail("failed to select Arabic checkbox for EOB Language");
		}

	}

	public static void select_ChineseCantonese_checkbox() {
		try {
			Utils.click(EOBGroupException.Chinese_Cantonese_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Chinese (Cantonese) checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Chinese (Cantonese) checkbox for EOB Language");
			Assert.fail("failed to select Chinese (Cantonese) checkbox for EOB Language");
		}

	}

	public static void select_ChineseMandarin_checkbox() {
		try {
			Utils.click(EOBGroupException.Chinese_Mandarin_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Chinese (Mandarin) checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Chinese (Mandarin) checkbox for EOB Language");
			Assert.fail("failed to select Chinese (Mandarin) checkbox for EOB Language");
		}

	}
	public static void clickonEobplanrulenutton() {
		try {
			Utils.click(EOBGroupException.CreateNewEOBPlanRule());
			Constants.test.log(Status.PASS, "clicking on  CreateNewEOBPlanRule button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "clicking on  CreateNewEOBPlanRule button");
			Assert.fail("failed to click on  CreateNewEOBPlanRule button");
		}

	}


	public static void select_Creole_checkbox() {
		try {
			Utils.click(EOBGroupException.Creole_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Creole checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Creole checkbox for EOB Language");
			Assert.fail("failed to select Creole checkbox for EOB Language");
		}

	}

	public static void select_French_checkbox() {
		try {
			Utils.click(EOBGroupException.French_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting French checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting French checkbox for EOB Language");
			Assert.fail("failed to select French checkbox for EOB Language");
		}

	}
	// Hawaiian (Pidgin)

	public static void select_HawaiianPidgin_checkbox() {
		try {
			Utils.click(EOBGroupException.Hawaiian_Pidgin_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Hawaiian (Pidgin) checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Hawaiian (Pidgin) checkbox for EOB Language");
			Assert.fail("failed to select Hawaiian (Pidgin)checkbox for EOB Language");
		}

	}

	public static void select_HindiCheckbox() {
		try {
			Utils.click(EOBGroupException.Hindi_India_Language_chkbox());
			// EOBGroupException.Hindi_India_Language_chkbox().click();
			Constants.test.log(Status.PASS, "selecting Hindi checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Hindi checkbox for EOB Language");
			Assert.fail("failed to select Hindi checkbox for EOB Language");
		}

	}// Italian

	public static void select_Italian_checkbox() {
		try {
			Utils.click(EOBGroupException.Italian_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Italian checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Italian checkbox for EOB Language");
			Assert.fail("failed to select Italian checkbox for EOB Language");
		}

	}

	public static void select_Korean_checkbox() {
		try {
			Utils.click(EOBGroupException.Korean_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Korean checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Korean checkbox for EOB Language");
			Assert.fail("failed to select Korean checkbox for EOB Language");
		}

	}

	public static void select_PhilippineCheckbox() {
		try {
			Utils.click(EOBGroupException.Philippine_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Philippine checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Philippine checkbox for EOB Language");
			Assert.fail("failed to select Philippine checkbox for EOB Language");
		}

	}

	public static void select_PolishCheckbox() {
		try {
			Utils.click(EOBGroupException.Polish_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Philippine checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Philippine checkbox for EOB Language");
			Assert.fail("failed to select Philippine checkbox for EOB Language");
		}

	}

	public static void select_RussianCheckbox() {
		try {
			Utils.click(EOBGroupException.Russian_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Russian checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Russian checkbox for EOB Language");
			Assert.fail("failed to select Russian checkbox for EOB Language");
		}

	}

	public static void select_VietnameseCheckbox() {
		try {
			Utils.click(EOBGroupException.Vietnamese_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Vietnamese checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Vietnamese checkbox for EOB Language");
			Assert.fail("failed to select Vietnamese checkbox for EOB Language");
		}

	}

	public static void select_SpanishCheckbox() {
		try {
			Utils.click(EOBGroupException.Spanish_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Spanish checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Spanish checkbox for EOB Language");
			Assert.fail("failed to select Spanish checkbox for EOB Language");
		}
	}

	public static void clickOnCancel() {
		try {
			Utils.click(EOBGroupException.clickoncancellink());
			Constants.test.log(Status.PASS, "click on cancel link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on cancel link");
			Assert.fail("failed to on cancel Link");
		}

	}

	public static void clickOnSave() {
		try {
			Utils.click(EOBGroupException.Save_Button());
			Constants.test.log(Status.PASS, "click on save");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on save");
			Assert.fail("failed to click on click on save");
		}

	}

	public static void select_DeleteRequiredrecord_Checkbox(String GroupNumber) {
		try {
			System.out.println("//*[@id='eob-exception-search-grid']/tbody/tr/td[text()='" + GroupNumber
					+ "']/preceding-sibling::td/input");
			Utils.click(EOBGroupException.SelectEmployerGrouprecord(GroupNumber));
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	public static void select_DeleteRequiredrecord_Checkbox(String GroupNumber, String GroupNumber1) {
		try {

			// Utils.click(EOBGroupException.Selectmutliplerecords(GroupNumber,Groupnumber1,Groupnumber2));
			List<WebElement> elements = EOBGroupException.SelectmultiplegroupsEmployerGrouprecord(GroupNumber,
					GroupNumber1);
			for (WebElement ele : elements) {
				ele.click();
			}

			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}
	
	public static void select_Checkbox(String GroupNumber) {
		try {
			System.out.println("//*[@id='eob-exception-search-grid']/tbody/tr/td[text()='" + GroupNumber
					+ "']/preceding-sibling::td/input");
			Utils.click(EOBGroupException.SelectEmployerGrouprecord(GroupNumber));
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}
	public static void clickonsearchdeletebutton() {
		try {
		     
		     EOBGroupException.clickondeletebutton().click();
			Constants.test.log(Status.PASS, "deleted button was clicked");
			} catch (Exception e) {
			Constants.test.log(Status.FAIL, "deleted button was clicked");
			Assert.fail("deleted button was clicked ");
			}

			}

	
	
	public static void select_search_Checkbox(String Contractnumber, String pbp) {
				try {
				     System.out.println("//td[text()='"+Contractnumber+"']/following-sibling::td[text()='"+pbp+"']/parent::tr/td[1]/input");
					// Utils.click(EOBPlanRule.Selectaleternateplan(Contractnumber,pbp));
				     EOBGroupException.select_searchscreen_checkbox(Contractnumber, pbp).click();
					Constants.test.log(Status.PASS, "Checkbox was selected");
					} catch (Exception e) {
					Constants.test.log(Status.FAIL, "Checkbox was selected");
					Assert.fail("failed to select  checkbox ");
					}

					}

		


	
	public static void select_Multiplerecords_Checkbox(String GroupNumber, String GroupNumber1) {
		try {

			// Utils.click(EOBGroupException.Selectmutliplerecords(GroupNumber,Groupnumber1,Groupnumber2));
			List<WebElement> elements = EOBGroupException.SelectmultiplegroupsEmployerGrouprecord(GroupNumber,
					GroupNumber1);
			for (WebElement ele : elements) {
				ele.click();
			}

			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	public static void select_Multiplerecords_Checkbox(String GroupNumber, String Groupnumber1, String Groupnumber2) {
		try {

			// Utils.click(EOBGroupException.Selectmutliplerecords(GroupNumber,Groupnumber1,Groupnumber2));
			List<WebElement> elements = EOBGroupException.Selectmutliplerecords(GroupNumber, Groupnumber1,
					Groupnumber2);
			for (WebElement ele : elements) {
				ele.click();
			}

			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}
	public static void select_Multiplerecordscheckbox(String GroupNumber, String Groupnumber1) {
		try {

			// Utils.click(EOBGroupException.Selectmutliplerecords(GroupNumber,Groupnumber1,Groupnumber2));
			List<WebElement> elements = EOBGroupException.Select_mutliplerecords(GroupNumber, Groupnumber1);
			for (WebElement ele : elements) {
				ele.click();
			}

			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	public static void verify_Multiplerecords_searchresults_withdbresults(String GroupNumber, String Groupnumber1,
			String Groupnumber2) {
		List<WebElement> elements = null;
		elements = EOBGroupException.verifymutliplerecords_searchscreen(GroupNumber, Groupnumber1, Groupnumber2);
		for (int i = 0; i < elements.size(); i++) {
			searchresults.add(elements.get(i).getText());
		}
		System.out.println(searchresults.size());

		List<WebElement> elements1 = null;
		elements1 = EOBGroupException.verifymutliplerecords_updatedscreen(GroupNumber, Groupnumber1, Groupnumber2);
		for (int i = 0; i < elements1.size(); i++) {
			elements1.get(i).isDisplayed();
			updatedresults.add(elements1.get(i).getText());

		}
		System.out.println(updatedresults.size());
		System.out.println(searchresults);
		System.out.println(updatedresults);
		try {

			Assert.assertTrue(searchresults.equals(updatedresults));
			Constants.test.log(Status.PASS, "compared search results with updated results");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Failed to compare search results with updated results");
			Assert.fail("Failed to compare search results with updated results");
		}
	}

	public static void verify_Multiplerecords_searchresults_withupdatedscreenresultsresults(String GroupNumber, String Groupnumber1)
			 {
		List<WebElement> elements = null;
		elements = EOBGroupException.verifymutliplerecords_searchscreen(GroupNumber, Groupnumber1);
		for (int i = 0; i < elements.size(); i++) {
			searchresults.add(elements.get(i).getText());
		}
		System.out.println(searchresults.size());

		List<WebElement> elements1 = null;
		elements1 = EOBGroupException.verifymutliplerecords_updatedscreen(GroupNumber, Groupnumber1);
		for (int i = 0; i < elements1.size(); i++) {
			elements1.get(i).isDisplayed();
			updatedresults.add(elements1.get(i).getText());

		}
		System.out.println(updatedresults.size());
		System.out.println(searchresults);
		System.out.println(updatedresults);
		try {

			Assert.assertTrue(searchresults.equals(updatedresults));
			Constants.test.log(Status.PASS, "compared search results with updated results");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Failed to compare search results with updated results");
			Assert.fail("Failed to compare search results with updated results");
		}
	}
	public static void verify_Multiple_records_searchresults_withupdatedscreenresultsresults(String GroupNumber,String Groupnumber1 )
	 {
List<WebElement> elements = null;
elements = EOBGroupException.verifyrecord_searchscreen(GroupNumber,Groupnumber1 );
for (int i = 0; i < elements.size(); i++) {
	searchresults.add(elements.get(i).getText());
}
System.out.println(searchresults.size());

List<WebElement> elements1 = null;
elements1 = EOBGroupException.verifyrecord_updatedscreen(GroupNumber,Groupnumber1 );
for (int i = 0; i < elements1.size(); i++) {
	elements1.get(i).isDisplayed();
	updatedresults.add(elements1.get(i).getText());

}
System.out.println(updatedresults.size());
System.out.println(searchresults);
System.out.println(updatedresults);
try {

	Assert.assertTrue(searchresults.equals(updatedresults));
	Constants.test.log(Status.PASS, "compared search results with updated results");

} catch (Exception e) {
	Constants.test.log(Status.FAIL, "Failed to compare search results with updated results");
	Assert.fail("Failed to compare search results with updated results");
}
}

	public static void verify_Multiplerecords_searchresults_with_updatedscreenresultsresults(String Contractnumber,String pbp)
	 {
List<WebElement> elements = null;
elements = EOBGroupException.verifyrecord_search_screen(Contractnumber,pbp);
for (int i = 0; i < elements.size(); i++) {
	searchresults.add(elements.get(i).getText());
}
System.out.println(searchresults.size());

List<WebElement> elements1 = null;
elements1 = EOBGroupException.verifyrecord_updatedsearchscreen(Contractnumber,pbp);
for (int i = 0; i < elements1.size(); i++) {
	elements1.get(i).isDisplayed();
	updatedresults.add(elements1.get(i).getText());

}

try {

	Assert.assertTrue(searchresults.equals(updatedresults));
	Constants.test.log(Status.PASS, "compared search results with updated results");

} catch (Exception e) {
	Constants.test.log(Status.FAIL, "Failed to compare search results with updated results");
	Assert.fail("Failed to compare search results with updated results");
}
}
	public static ArrayList<String> storingupdatedrecords(String GroupNumber, String Groupnumber1, String Groupnumber2)
			throws ClassNotFoundException, SQLException {
		List<WebElement> elements = null;
		elements = EOBGroupException.verifymutliplerecords_updatedscreen(GroupNumber, Groupnumber1, Groupnumber2);
		for (int i = 0; i < elements.size(); i++) {
			updated_results.add(elements.get(i).getText());
		}
		updated_results.set(3, Utils.convertDateFormat_yyyymmdd(elements.get(3).getText()));
		updated_results.set(10, Utils.convertDateFormat_yyyymmdd(elements.get(10).getText()));
		updated_results.set(17, Utils.convertDateFormat_yyyymmdd(elements.get(17).getText()));

		return updated_results;
	}

	public static void comparingupdatedresultswithdbresults() throws ClassNotFoundException, SQLException {
		String QEREY = Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue();
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		System.out.println(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> DBresultsList = new ArrayList<String>(DBvalues.values());
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresultsList.add(Constants.resultset.getString(j).trim());
			}
		}
		
		if (updatedresults.size() == searchresults.size()) {
			boolean flag = true;
			for (int i = 0; i < updatedresults.size(); i++) {

				if (flag == true) {
					try {
						if (updatedresults.get(i) == null && searchresults.get(i) == null) {
							Assert.assertTrue(true);
						} else if (updatedresults.get(i) == null && searchresults.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!(updatedresults.get(i) == null) && searchresults.get(i) == null) {

							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break;
						} else {
							if (updatedresults.get(i).equalsIgnoreCase(searchresults.get(i)) == true) {
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

	public static void clickOnDeleteGroupExceptions() {
		// try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='eob-ajax-loading']")));
		// Utils.click(EOBGroupException.ClickonDeleteGroupExceptions());
		EOBGroupException.ClickonDeleteGroupExceptions().click();
		Constants.test.log(Status.PASS, "click on DeleteGroupExceptions");
		// } catch (Exception e) {
		// Constants.test.log(Status.FAIL, "click on DeleteGroupExceptions");
		// Assert.fail("failed to click on click on DeleteGroupExceptions");
		// }

	}

	public static void VerifySuccesfulllMessage_EOBGroupException() {
		try {

			Assert.assertTrue(EOBGroupException.checkSuccessfullMessage().getText()
					.equalsIgnoreCase("Your new exception has been successfully created."));
			Constants.test.log(Status.PASS, "check message displayed for DuplicateRecord EOBGroupException");
			System.out.println(EOBGroupException.checkSuccessfullMessage().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for DuplicateRecord EOBGroupException");
			Assert.fail("failed to check message displayed for DuplicateRecord EOBGroupException");
		}
	}

	public static void checkErrorMessage_DuplicateRecord_EOBGroupException() {
		try {

			Assert.assertTrue(EOBGroupException.checkErrorMessage().getText()
					.equalsIgnoreCase("Cannot create a new EOB exception, the exception already exists."));
			Constants.test.log(Status.PASS, "check error message displayed for DuplicateRecord EOBGroupException");
			System.out.println(EOBGroupException.checkErrorMessage().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for DuplicateRecord EOBGroupException");
			Assert.fail("failed to check error message displayed for DuplicateRecord EOBGroupException");
		}
	}

	public static void VerifyEOBPlanRuleListScreen() {
		try {
			Assert.assertTrue(
					EOBGroupException.EOBPlanRuleListScreen().getText().equalsIgnoreCase("EOB Plan Rule List"));
			Constants.test.log(Status.PASS, "Verify message displayed for EOB Plan Rule List");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Verify error message for  displayed for EOB Plan Rule List");
			Assert.fail("failed to Verify error message displayed for EOB Plan Rule List");
		}
	}

	public static void VerifyEOBGroupExceptionsScreen() {
		try {

			Assert.assertTrue(
					EOBGroupException.EOBGroupExceptions().getText().equalsIgnoreCase("EOB Group Exceptions"));
			Constants.test.log(Status.PASS, "Verify message displayed for EOB Group Exceptions");
			System.out.println(EOBGroupException.EOBGroupExceptions().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Verify error message for  displayed for EOB Group Exceptions");
			Assert.fail("failed to Verify error message displayed for EOB Group Exceptions");
		}
	}

	public static void VerifyCreateNewEOBGroupExceptionScreen() {
		try {

			Assert.assertTrue(EOBGroupException.VerifyCreateNewEOBGroupException().getText()
					.equalsIgnoreCase("Create New EOB Group Exception"));
			Constants.test.log(Status.PASS, "check message displayed for Create New EOB Group Exception");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Create New EOB Group Exception");
			Assert.fail("failed to check error message displayed for Create New EOB Group Exception");
		}
	}

	public static void checkErrormessage_GroupEffectiveDate(String GroupEffectivedate) {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupEffectiveDate().getText()
					.equalsIgnoreCase("The value '" + GroupEffectivedate + "' is not valid for EffectiveDate."));
			Constants.test.log(Status.PASS, "Verify message displayed for GroupEffectiveDate");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Verify error message for  displayed for GroupEffectiveDate");
			Assert.fail("failed to Verify error message displayed for GroupEffectiveDate");
		}
	}

	public static void checkErrormessage_Datewithnoslashes_GroupEffectiveDate() {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupEffectiveDate().getText().toString().trim()
					.equalsIgnoreCase("The effective date year must be greater than 2012."));
			Constants.test.log(Status.PASS, "check message displayed for GroupEffectiveDate");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for GroupEffectiveDate");
			Assert.fail("failed to check error message displayed for GroupEffectiveDate");
		}
	}

	public static void HighlightedGroups() {
		try {

			List<WebElement> ff = driver.findElements(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr"));
			System.out.println(ff.size());

			for (WebElement h : EOBGroupException.highLighted_groups()) {
				System.out.println(h.getText());
			}

			Constants.test.log(Status.PASS, "groups retrieved");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "groups retrieved");
			Assert.fail("failed to retrieve groups");
		}
	}

	public static void checkErrormessage_Datewith2012year_GroupEffectiveDate() {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupEffectiveDate().getText().toString().trim()
					.equalsIgnoreCase("The effective date year must be greater than 2012."));
			Constants.test.log(Status.PASS, "check message displayed for GroupEffectiveDate");
			System.out.println(EOBGroupException.checkerror_message_GroupEffectiveDate().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for GroupEffectiveDate");
			Assert.fail("failed to check error message displayed for GroupEffectiveDate");
		}
	}

	public static void checkErrormessage_Datewithbackwardslash_GroupEffectiveDate() {
		try {

			System.out.println(EOBGroupException.checkerror_message_GroupEffectiveDate().getText());
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupEffectiveDate().getText()
					.equalsIgnoreCase("The value '12\1\2012' is not valid for EffectiveDate."));

			Constants.test.log(Status.PASS, "check message displayed for GroupEffectiveDate");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for GroupEffectiveDate");
			Assert.fail("failed to check error message displayed for GroupEffectiveDate");
		}
	}

	public static void checkErrormessage_GroupNumberisrequired() {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupNumberisrequired().getText().toString().trim()
					.equalsIgnoreCase("Group Number is required."));
			Constants.test.log(Status.PASS, "check message displayed for GroupNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for GroupNumber");
			Assert.fail("failed to check error message displayed for GroupNumber");
		}
	}

	public static void checkErrormessage_MastergroupNumberisrequired() {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_MasterGroupNumberisrequired().getText().toString()
					.trim().equalsIgnoreCase("Master Group Number is required."));
			Constants.test.log(Status.PASS, "check message displayed for MastergroupNumber");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for MastergroupNumber");
			Assert.fail("failed to check error message displayed for MastergroupNumber");
		}
	}

	public static void checkErrormessage_GroupEffectivedateisrequired() {
		try {
			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.checkerror_message_GroupEffectiveDateisrequired().getText().toString()
					.trim().equalsIgnoreCase("Group Effective Date is required."));
			Constants.test.log(Status.PASS, "check message displayed for GroupEffectiveDate");
			System.out.println(EOBGroupException.EnterMasterGroupNumber_textfield().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for GroupEffectiveDate");
			Assert.fail("failed to check error message displayed for GroupEffectiveDate");
		}
	}

	public static void compareSearchResultWithDBvalues_Duplicaterecord() {
		try {
			String MasterGroupNumber = null;
			String GroupNumber = null;
			String EffectiveDate = null;
			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
			System.out.println(QEREY);
			String inputMastergroupnumber = inSheet.getRow(1).getCell(4).getStringCellValue();

			String inputGroupNumber = inSheet.getRow(2).getCell(1).getStringCellValue();

			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement
					.executeQuery("select * from dbo.EOBplanruleexception where groupnumber='67490' ");
			while (Constants.resultset.next()) {
				String EOBPlanRuleExceptionID = Constants.resultset.getString(1);
				System.out.println("EOBPlanRuleExceptionID:" + EOBPlanRuleExceptionID);
				MasterGroupNumber = Constants.resultset.getString("MasterGroupNumber");

				GroupNumber = Constants.resultset.getString("GroupNumber");

				EffectiveDate = Constants.resultset.getString("EffectiveDate");
				System.out.println("EffectiveDate:" + EffectiveDate);
			}

			Assert.assertEquals(inputMastergroupnumber, MasterGroupNumber);
			Constants.test.log(Status.PASS, "Click on component code link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on component code link in header");
			Assert.fail("failed due to either component link is not visible or not clickable");
		}
	}

	public static LinkedHashMap<String, String> InputParameters() throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
		Inputvalues.put("MasterGroupNumber", inSheet.getRow(1).getCell(4).getStringCellValue());
		Inputvalues.put("GroupNumber", RandomStringUtils.randomNumeric(5));
		Inputvalues.put("EffectiveDate", inSheet.getRow(1).getCell(2).getStringCellValue());
		Inputvalues.put("SiteName", inSheet.getRow(1).getCell(3).getStringCellValue());
		return Inputvalues;
	}

	public static void VerifyRecordsinDB() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Input_Values");
		String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", Inputvalues.get("GroupNumber")).replace("parameter2",
				inSheet.getRow(1).getCell(5).getStringCellValue());
		
		Utils.connectToSqlserverDB();
		System.out.println(QEREY);
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}

	public static void VerifyDeletedgroup_Record() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(10).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void VerifyEOBPlanRuleException_Record() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
				.replace("parameter1", inSheet.getRow(3).getCell(1).getStringCellValue()).replace("parameter2",
				inSheet.getRow(4).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void VerifyDeletedgroupRecord_DB() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(1).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(10).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(Constants.resultset.next());
	}
	public static void Verifyiseob_group_multiplegroups_indb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
			String QUEREY = Constants.Input_SQLS.getRow(72).getCell(1).getStringCellValue();
			QUEREY = QUEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(3).getCell(18).getStringCellValue())
					.replace("parameter3", inSheet.getRow(3).getCell(20).getStringCellValue())
					.replace("parameter4", inSheet.getRow(4).getCell(20).getStringCellValue());
				
			System.out.println(QUEREY);
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QUEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			List<String> DBresultsList = new ArrayList<String>(DBvalues.values());
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresultsList.add(Constants.resultset.getString(j).trim());
				}
			}
			
			System.out.println(DBresultsList);
			String QUEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
			QUEREY1 = QUEREY1.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(3).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(4).getCell(1).getStringCellValue());
				
			System.out.println(QUEREY1);
			Utils.connectToSqlserverDB();
			Constants.resultset1 = Constants.statement.executeQuery(QUEREY1);
			Constants.resultsetMetadata1= Constants.resultset.getMetaData();
			List<String> DBresults = new ArrayList<String>(DBvalues.values());
			for (int k = 0; Constants.resultset1.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata1.getColumnCount(); j++) {
					DBresults.add(Constants.resultset1.getString(j).trim());
				}
			}
			System.out.println(DBresults);
			Assert.assertEquals(DBresultsList,DBresults);
	}
	public static void Verifystatus_EOBPlanRuleExceptioninDB() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String status=inSheet.getRow(3).getCell(19).getStringCellValue();
		
		String QEREY = Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());

		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			String DBstatus = Constants.resultset.getString(1);
			System.out.println("DBstatus:" + DBstatus);
		
		Assert.assertTrue(DBstatus.equalsIgnoreCase(status));
		}
	
	}
	public static void Verify_status_EOBPlanRuleExceptioninDB() throws ClassNotFoundException, SQLException {
		
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String status = inSheet.getRow(7).getCell(19).getStringCellValue();
			System.out.println(status);
		
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			System.out.println(rowCount);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
		}
	
	
	public static void Verifystatus_EOBPlanRuleException_inDB() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String status=inSheet.getRow(5).getCell(19).getStringCellValue();
		
		String QEREY = Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());

		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			String DBstatus = Constants.resultset.getString(1);
			System.out.println("DBstatus:" + DBstatus);
		
		Assert.assertTrue(DBstatus.equalsIgnoreCase(status));
		}
	
	}
	
	public static void Verifystatus_EOBPlanRuleExceptionDB_employergroup() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String status=inSheet.getRow(5).getCell(17).getStringCellValue();
		
		String QEREY = Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			String DBstatus = Constants.resultset.getString(1);
		Assert.assertTrue(DBstatus.equalsIgnoreCase(status));
		}
	
	}
	public static void Verifystatus_DB() throws ClassNotFoundException, SQLException {
		// try {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String status=inSheet.getRow(3).getCell(8).getStringCellValue();
		
		String QEREY = Constants.Input_SQLS.getRow(35).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(18).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			String DBstatus = Constants.resultset.getString(1);
			System.out.println("DBstatus:" + DBstatus);
		
		Assert.assertTrue(DBstatus.equalsIgnoreCase(status));
		}
	
		//Assert.assertTrue(!Constants.resultset.next());
	}

	public static LinkedHashMap<String, String> IdentifyEmployerGroupParametersinDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			inputparameters.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			inputparameters.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			inputparameters.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			inputparameters.put("SiteName", Constants.resultset.getString("SiteName"));
			inputparameters.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			inputparameters.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(inputparameters);
		return inputparameters;
	}

	public static LinkedHashMap<String, String> Identify_EmployerGroupParametersinDB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);

		parametervalues.put("MasterGroupNumber", inSheet.getRow(5).getCell(4).getStringCellValue());
		parametervalues.put("GroupNumber", inSheet.getRow(5).getCell(1).getStringCellValue());
		parametervalues.put("EffectiveDate", inSheet.getRow(5).getCell(2).getStringCellValue());
		parametervalues.put("SiteName", inSheet.getRow(5).getCell(3).getStringCellValue());
		parametervalues.put("IsEOB", inSheet.getRow(5).getCell(11).getStringCellValue());
		parametervalues.put("EOBIndicator", inSheet.getRow(5).getCell(6).getStringCellValue());
		parametervalues.put("status", inSheet.getRow(5).getCell(17).getStringCellValue());
		parametervalues.put("actiontypeid", inSheet.getRow(5).getCell(19).getStringCellValue());
		parametervalues.put("CreateBy", CreatBy_UI);
		parametervalues.put("UpdateBy", UpdateBy_UI);
		parametervalues.put("CreateDate", Createdate);
		parametervalues.put("UpdateDate", UpdateDate);
		parametervalues.put("Languages", inSheet.getRow(5).getCell(7).getStringCellValue());

		return parametervalues;
	}

	public static LinkedHashMap<String, String> Identify_employergroupvalues_updated_DBvalue()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(10).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues_DB.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues_DB.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues_DB.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroupvalues_DB.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(employergroupvalues_DB);
		return employergroupvalues_DB;
	}
	public static LinkedHashMap<String, String> Identify_employergroupvalues_updated_DB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(16).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues_updated_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues_updated_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues_updated_DB.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues_updated_DB.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues_updated_DB.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroupvalues_updated_DB.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(employergroupvalues_updated_DB);
		return employergroupvalues_updated_DB;
	}
	public static LinkedHashMap<String, String> Identify_EmployerGroupParametersin_DB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(17).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(17).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues_updated_DBvalue.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues_updated_DBvalue.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues_updated_DBvalue.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues_updated_DBvalue.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues_updated_DBvalue.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroupvalues_updated_DBvalue.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(employergroupvalues_updated_DBvalue);
		return employergroupvalues_updated_DBvalue;
	}
	public static LinkedHashMap<String, String> Identify_individual_groups_Db()
			throws SQLException, ClassNotFoundException {
		
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(10).getCell(1).getStringCellValue());
		System.out.println(QEREY);

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);

		
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individual_groups_inDB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individual_groups_inDB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individual_groups_inDB.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individual_groups_inDB.put("SiteName", Constants.resultset.getString("SiteName"));
			individual_groups_inDB.put("iseob", inSheet.getRow(9).getCell(12).getStringCellValue());
			individual_groups_inDB.put("Iseob", inSheet.getRow(9).getCell(6).getStringCellValue());
			individual_groups_inDB.put("status", inSheet.getRow(9).getCell(8).getStringCellValue());
			individual_groups_inDB.put("CreateBy", CreatBy_UI);
			individual_groups_inDB.put("UpdateBy", UpdateBy_UI);
			individual_groups_inDB.put("CreateDate", Createdate);
			individual_groups_inDB.put("UpdateDate", UpdateDate);
			individual_groups_inDB.put("Languages", inSheet.getRow(9).getCell(7).getStringCellValue());
		}
		System.out.println(individual_groups_inDB);
		return individual_groups_inDB;
	}
	public static LinkedHashMap<String, String> Identify_individualgroupvalues_DBvalues()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(7).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);

		
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individualgroupvaluesDBvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individualgroupvaluesDBvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individualgroupvaluesDBvalues.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individualgroupvaluesDBvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			individualgroupvaluesDBvalues.put("iseob", inSheet.getRow(7).getCell(12).getStringCellValue());
			individualgroupvaluesDBvalues.put("Iseob", inSheet.getRow(7).getCell(6).getStringCellValue());
			individualgroupvaluesDBvalues.put("status", inSheet.getRow(7).getCell(8).getStringCellValue());
			individualgroupvaluesDBvalues.put("CreateBy", CreatBy_UI);
			individualgroupvaluesDBvalues.put("UpdateBy", UpdateBy_UI);
			individualgroupvaluesDBvalues.put("CreateDate", Createdate);
			individualgroupvaluesDBvalues.put("UpdateDate", UpdateDate);
			individualgroupvaluesDBvalues.put("Languages", inSheet.getRow(7).getCell(7).getStringCellValue());
		}
		System.out.println(individualgroupvaluesDBvalues);
		return individualgroupvaluesDBvalues;
	}
	public static LinkedHashMap<String, String> Identify_individual_groupindb()
			throws SQLException, ClassNotFoundException {
		
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(9).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);

		
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individual_groups_inDBvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individual_groups_inDBvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individual_groups_inDBvalues.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individual_groups_inDBvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			individual_groups_inDBvalues.put("iseob", inSheet.getRow(9).getCell(12).getStringCellValue());
			individual_groups_inDBvalues.put("Iseob", inSheet.getRow(9).getCell(6).getStringCellValue());
			individual_groups_inDBvalues.put("status", inSheet.getRow(9).getCell(8).getStringCellValue());
			individual_groups_inDBvalues.put("CreateBy", CreatBy_UI);
			individual_groups_inDBvalues.put("UpdateBy", UpdateBy_UI);
			individual_groups_inDBvalues.put("CreateDate", Createdate);
			individual_groups_inDBvalues.put("UpdateDate", UpdateDate);
			individual_groups_inDBvalues.put("Languages", inSheet.getRow(9).getCell(7).getStringCellValue());
		}
		System.out.println(individual_groups_inDBvalues);
		return individual_groups_inDBvalues;
	}
	public static LinkedHashMap<String, String> Identify_individual_groups_DB_DBvalues()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(8).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(8).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);

		
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individual_groups_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individual_groups_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individual_groups_DB.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individual_groups_DB.put("SiteName", Constants.resultset.getString("SiteName"));
			individual_groups_DB.put("iseob", inSheet.getRow(7).getCell(12).getStringCellValue());
			individual_groups_DB.put("Iseob", inSheet.getRow(7).getCell(6).getStringCellValue());
			individual_groups_DB.put("status", inSheet.getRow(7).getCell(8).getStringCellValue());
			individual_groups_DB.put("CreateBy", CreatBy_UI);
			individual_groups_DB.put("UpdateBy", UpdateBy_UI);
			individual_groups_DB.put("CreateDate", Createdate);
			individual_groups_DB.put("UpdateDate", UpdateDate);
			individual_groups_DB.put("Languages", inSheet.getRow(7).getCell(7).getStringCellValue());
		}
		System.out.println(individual_groups_DB);
		return individual_groups_DB;
	}
	public static LinkedHashMap<String, String> Identify_EmployerGroup_Parametersin_DB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(11).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(11).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues_DBvalue.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues_DBvalue.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues_DBvalue.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues_DBvalue.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues_DBvalue.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroupvalues_DBvalue.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(employergroupvalues_DBvalue);
		return employergroupvalues_DBvalue;
	}

	public static LinkedHashMap<String, String> IdentifyEmployerGroupParametersin_DB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(12).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(12).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues_DBvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues_DBvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues_DBvalues.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues_DBvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues_DBvalues.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroupvalues_DBvalues.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(employergroupvalues_DBvalues);
		return employergroupvalues_DBvalues;
	}

	public static void ComparingDeteletedgroupparameters_inauditEOBPlanRuleException()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String Query = Constants.Input_SQLS.getRow(31).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue())
				.replace("parameter2", inSheet.getRow(5).getCell(19).getStringCellValue())
				.replace("parameter3", parametervalues.get("CreateDate"));
		System.out.println(Query);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();

		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {

				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}

		}

		System.out.println(DBvalues);

		try {
			Assert.assertEquals(DBvalues.get("actiontypeid"), parametervalues.get("actiontypeid"),
					"Failed as actiontypeid not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), parametervalues.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("GroupNumber"), parametervalues.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), parametervalues.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), parametervalues.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), parametervalues.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), parametervalues.get("IsEOB"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), parametervalues.get("status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), parametervalues.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), parametervalues.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), parametervalues.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), parametervalues.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}
		String Query1 = Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue();
		System.out.println(parametervalues.get("CreateDate"));
		Query1 = Query1.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue()).replace("parameter2",
				parametervalues.get("CreateDate"));
		Utils.connectToSqlserverDB();
		System.out.println(Query1);
		ResultSet Result = Constants.statement.executeQuery(Query1);
		Assert.assertTrue(!Result.next());

	}

	public static void verifylanguagesinEOBPlanRuleLanguageType() throws ClassNotFoundException, SQLException {
	String Query = Constants.Input_SQLS.getRow(65).getCell(1).getStringCellValue();
	XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
	String language=inSheet.getRow(3).getCell(7).getStringCellValue();

	Query = Query.replace("parameter1",inSheet.getRow(3).getCell(10).getStringCellValue())
			.replace("parameter2", inSheet.getRow(3).getCell(18).getStringCellValue())
	         .replace("parameter3", inSheet.getRow(3).getCell(20).getStringCellValue());
			
	System.out.println(Query);
	Utils.connectToSqlserverDB();
	System.out.println(Query);
	Constants.resultset = Constants.statement.executeQuery(Query);
	while (Constants.resultset.next()) {
		String DBstatus = Constants.resultset.getString(1).trim();
		System.out.println(language);
		System.out.println(DBstatus);
		Assert.assertEquals(DBstatus, language);
		System.out.println("DB values are equal");
	}
	}
	public static void VerifyDeletedgroupsin_auditEOBPlanRuleLanguage_indb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		
			String languages = inSheet.getRow(3).getCell(7).getStringCellValue();
			System.out.println(languages);
			String QEREY1 = Constants.Input_SQLS.getRow(70).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(3).getCell(18).getStringCellValue())
					.replace("parameter2", inSheet.getRow(3).getCell(21).getStringCellValue())
					.replace("parameter3", inSheet.getRow(3).getCell(20).getStringCellValue())
					.replace("parameter4", inSheet.getRow(4).getCell(20).getStringCellValue());
				
			System.out.println(QEREY1);
			String QEREY2 = Constants.Input_SQLS.getRow(71).getCell(1).getStringCellValue();
			QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(4).getCell(18).getStringCellValue())
					.replace("parameter2", inSheet.getRow(4).getCell(21).getStringCellValue())
					.replace("parameter3", inSheet.getRow(3).getCell(20).getStringCellValue())
					.replace("parameter4", inSheet.getRow(4).getCell(20).getStringCellValue());
			System.out.println(QEREY1);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY2);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} 
	public static void Verifymultiplegroupsin_dboGroupEOBLanguageType_indb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		
			String languages = inSheet.getRow(3).getCell(7).getStringCellValue();
			System.out.println(languages);
			String QEREY1 = Constants.Input_SQLS.getRow(73).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(3).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(4).getCell(1).getStringCellValue());
				
			System.out.println(QEREY1);
			String QEREY2 = Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue();
			QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(3).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(4).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY2);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} 
	public static void verifynorecordGrouptable() throws ClassNotFoundException, SQLException {
	
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(51).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}//
	public static void CompareauditEOBPlanRuleExceptionLanguageinDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String Query = Constants.Input_SQLS.getRow(34).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue()).replace("parameter2",
				parametervalues.get("CreateDate"));
		Utils.connectToSqlserverDB();
		System.out.println(Query);

		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> languages = new ArrayList<String>();
		System.out.println(parametervalues.get("Languages"));
		String lng[] = parametervalues.get("Languages").toString().split(",");

		Map<String, String> DBvalues = new HashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());
		}

		System.out.println(parametervalues);
		System.out.println(languageFromDB);
		try {
			Assert.assertEquals(DBvalues.get("actiontypeid"), parametervalues.get("actiontypeid"),
					"Failed as actiontypeid not matched with DB");
			Assert.assertEquals(DBvalues.get("EffectiveDate"), parametervalues.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("groupnumber"), parametervalues.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("mastergroupnumber"), parametervalues.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), parametervalues.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), parametervalues.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), parametervalues.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), parametervalues.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), parametervalues.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), parametervalues.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");

			int i = 0;
			for (String lngs : lng) {

				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}

	}

	public static LinkedHashMap<String, String> IdentifyEmployervalues() throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(4).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(4).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			inputvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			inputvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			inputvalues.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			inputvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			inputvalues.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			inputvalues.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(inputvalues);
		return inputvalues;
	}

	public static LinkedHashMap<String, String> IdentifyEmployerGroupParametersinDB_employer()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			parameters.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			parameters.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			parameters.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			parameters.put("SiteName", Constants.resultset.getString("SiteName"));
			parameters.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			parameters.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(parameters);
		return parameters;
	}

	public static LinkedHashMap<String, String> IdentifyEmployerGroupParametersinDB()
			throws SQLException, ClassNotFoundException {

		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroup.put("MasterGroupNumber", inSheet.getRow(3).getCell(4).getStringCellValue());
			employergroup.put("GroupNumber", inSheet.getRow(3).getCell(1).getStringCellValue());
			employergroup.put("EffectiveDate", inSheet.getRow(3).getCell(2).getStringCellValue());
			employergroup.put("SiteName", inSheet.getRow(3).getCell(3).getStringCellValue());
			employergroup.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			employergroup.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());

		}
		System.out.println(parameters);
		return parameters;
	}

	public static void compareUIvalueswithDBvalues()
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}
		List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());
		List<String> paramValues = new ArrayList<String>(parameters.values());
		System.out.println(paramValues.size());
		System.out.println(DBvalues.size());
		System.out.println(DBvaluesList);
		System.out.println(paramValues);

		if (paramValues.size() == DBvalues.size()) {
			boolean flag = true;
			for (int i = 0; i < paramValues.size(); i++) {
				if (flag == true) {
					try {

						if (paramValues.get(i) == null && DBvaluesList.get(i) == null) {
							Assert.assertTrue(true);
						} else if (paramValues.get(i) == null && DBvaluesList.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!(paramValues.get(i) == null) && DBvaluesList.get(i) == null) {

							Constants.test.log(Status.FAIL, "compare search results with B values");
							Assert.fail();
							break;
						} else {

							if (paramValues.get(i).equalsIgnoreCase(DBvaluesList.get(i)) == true) {
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

	public static boolean VerfiyingEmployerGroupgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean VerfiyingIndivualGroupgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean Verfiying_IndivualGroupgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(12).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(7).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean Verfiying_Indivual_Groupgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}
		return flag;

	}
	public static boolean Verfiying_Indivual_Groupgroup_inDB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(9).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(10).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}
		return flag;

	}
	public static boolean Verfiying_EObplanrule_DB() throws ClassNotFoundException, SQLException {
		

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(79).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(18).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}
		return flag;

	}
	public static void delete_EObplanrule_DB() throws ClassNotFoundException, SQLException {
		
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(80).getCell(1).getStringCellValue();
	
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		Assert.assertTrue(!Constants.resultset.next());

		
		String QEREY1 = Constants.Input_SQLS.getRow(80).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(18).getStringCellValue());
		System.out.println(QEREY1);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		Assert.assertTrue(!Constants.resultset.next());
	}
	public static boolean VerfiyingLogicaldeletegroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"Logicaldelete_Group");
		String QEREY = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean Employergroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean Employergroup_DB_update() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean verify_Employergroup_inDB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean verify_Individual_Groups_inDB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean Employergroups_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		XSSFSheet managedSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
		String QEREY = Constants.Input_SQLS.getRow(38).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue())
				.replace("parameter4", managedSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean Employergroups_update_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(38).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean DB_Record_Employergroup() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean DB_planruleRecord_Employergroup() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(5).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}
	public static boolean DB_Record_individual() throws ClassNotFoundException, SQLException {
	

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(54).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(2).getCell(10).getStringCellValue())
				.replace("parameter3", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter4", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}
		return flag;
	}
	public static boolean MultipleRecord_withsameMastergroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(43).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean multiple_Employergroup_inDB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(32).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(6).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter2", inSheet.getRow(9).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean VerfiyingAllLanguagesgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"All_languages_group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean Verifydifferenteffectivedate() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"differenteffectivedate");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean Managedgroup_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static boolean VerifyAlllanguagesin_DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
		String QEREY = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static void Verifymessage_GroupException_weresuccessfullydeleted() {
		try {

			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.DeleteGroupException().getText().toString().trim()
					.equalsIgnoreCase("Your 1 EOB Group Exception(s) were successfully deleted."));

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for  Group Exception(s)");
			Assert.fail("failed to check error message displayed for  EOBGroupException");
		}
	}

	public static void Verifymessage_multipleGroupException_weresuccessfullydeleted() {
		try {

			Utils.waitForPageToLoad(driver);
			Assert.assertTrue(EOBGroupException.multipleDeleteGroupException().getText().toString().trim()
					.equalsIgnoreCase("Your 2 EOB Group Exception(s) were successfully deleted."));

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for  Group Exception(s)");
			Assert.fail("failed to check error message displayed for  EOBGroupException");
		}
	}

	public static void storeprocedure() throws ClassNotFoundException, SQLException {
		String QUEREY = Constants.Input_SQLS.getRow(17).getCell(1).getStringCellValue();
		System.out.println(QUEREY);
		Utils.connectToSqlserverDB();
		try {
			Constants.statement.executeQuery("{call uspEOBLoadLanguageRule}");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static LinkedHashMap<String, String> Identify_parametersinDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(6).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(6).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupparameters.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupparameters.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupparameters.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupparameters.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupparameters.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			employergroupparameters.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			employergroupparameters.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			employergroupparameters.put("CreateBy", CreatBy_UI);
			employergroupparameters.put("UpdateBy", UpdateBy_UI);
			employergroupparameters.put("CreateDate", Createdate);
			employergroupparameters.put("UpdateDate", UpdateDate);
			employergroupparameters.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(employergroupparameters);
		return employergroupparameters;
	}
	public static LinkedHashMap<String, String> IdentifyparametersinDB_individualGroup()
			throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(5).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individualvalues_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individualvalues_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individualvalues_DB.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individualvalues_DB.put("SiteName", Constants.resultset.getString("SiteName"));
			individualvalues_DB.put("EOBIndicator", inSheet.getRow(5).getCell(6).getStringCellValue());
			individualvalues_DB.put("IsEOB", inSheet.getRow(5).getCell(0).getStringCellValue());
			individualvalues_DB.put("Status", inSheet.getRow(5).getCell(8).getStringCellValue());
			individualvalues_DB.put("CreateBy", CreatBy_UI);
			individualvalues_DB.put("UpdateBy", UpdateBy_UI);
			individualvalues_DB.put("CreateDate", Createdate);
			individualvalues_DB.put("UpdateDate", UpdateDate);
			individualvalues_DB.put("Languages", inSheet.getRow(5).getCell(7).getStringCellValue());

		}
		System.out.println(individualvalues_DB);
		return individualvalues_DB;
	}
	public static void CompareIndivualGroupParameters_inDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(61).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(5).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			
		}
		System.out.println(DBvalues);
		System.out.println(individualvalues_DB);
         
	
			Assert.assertEquals(DBvalues.get("GroupNumber"), individualvalues_DB.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), individualvalues_DB.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), individualvalues_DB.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), individualvalues_DB.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), individualvalues_DB.get("IsEOB"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), individualvalues_DB.get("Status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), individualvalues_DB.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), individualvalues_DB.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			/*Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), individualvalues_DB.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), individualvalues_DB.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");*/
			

	

		
		String Query1 = Constants.Input_SQLS.getRow(33).getCell(1).getStringCellValue();
		System.out.println(individualvalues_DB.get("CreateDate"));
		Query1 = Query1.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue()).replace("parameter2",
				individualvalues_DB.get("CreateDate"));
		Utils.connectToSqlserverDB();
		System.out.println(Query1);
		ResultSet Result = Constants.statement.executeQuery(Query1);
		Assert.assertTrue(!Result.next());

	}
	public static LinkedHashMap<String, String> IdentifyinDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(9).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupvalues.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupvalues.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			employergroupvalues.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			employergroupvalues.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			employergroupvalues.put("CreateBy", CreatBy_UI);
			employergroupvalues.put("UpdateBy", UpdateBy_UI);
			employergroupvalues.put("CreateDate", Createdate);
			employergroupvalues.put("UpdateDate", UpdateDate);
			employergroupvalues.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(employergroupvalues);
		return employergroupvalues;
	}

	public static LinkedHashMap<String, String> Identify_employergroupparameters_inDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(9).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(9).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(9).getCell(1).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			employergroupparameters.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			employergroupparameters.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			employergroupparameters.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			employergroupparameters.put("SiteName", Constants.resultset.getString("SiteName"));
			employergroupparameters.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			employergroupparameters.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			employergroupparameters.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			employergroupparameters.put("CreateBy", CreatBy_UI);
			employergroupparameters.put("UpdateBy", UpdateBy_UI);
			employergroupparameters.put("CreateDate", Createdate);
			employergroupparameters.put("UpdateDate", UpdateDate);
			employergroupparameters.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(employergroupparameters);
		return employergroupparameters;
	}

	public static LinkedHashMap<String, String> IdentifyIndivualGroupParametersinDB_SameMastergroup()
			throws SQLException, ClassNotFoundException {

		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(55).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(2).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(2).getCell(1).getStringCellValue()).replace("parameter3",
						inSheet.getRow(2).getCell(19).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individualgroupvalues.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individualgroupvalues.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individualgroupvalues.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individualgroupvalues.put("SiteName", Constants.resultset.getString("SiteName"));
			individualgroupvalues.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			individualgroupvalues.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			individualgroupvalues.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			individualgroupvalues.put("CreateBy", CreatBy_UI);
			individualgroupvalues.put("UpdateBy", UpdateBy_UI);
			individualgroupvalues.put("CreateDate", Createdate);
			individualgroupvalues.put("UpdateDate", UpdateDate);
			individualgroupvalues.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(individualgroupvalues);
		return individualgroupvalues;
	}

	public static LinkedHashMap<String, String> IdentifyIndivualGroupsParametersinDB()
			throws SQLException, ClassNotFoundException {

		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individualgroup_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individualgroup_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individualgroup_DB.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			individualgroup_DB.put("SiteName", Constants.resultset.getString("SiteName"));
			individualgroup_DB.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			individualgroup_DB.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			individualgroup_DB.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			individualgroup_DB.put("CreateBy", CreatBy_UI);
			individualgroup_DB.put("UpdateBy", UpdateBy_UI);
			individualgroup_DB.put("CreateDate", Createdate);
			individualgroup_DB.put("UpdateDate", UpdateDate);
			individualgroup_DB.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(individualgroup_DB);
		return individualgroup_DB;
	}
	public static LinkedHashMap<String, String> IdentifyIndivualGroupParametersinDB()
			throws SQLException, ClassNotFoundException {

		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(13).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, UpdateBy.length());
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			indiviualparameters.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			indiviualparameters.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			indiviualparameters.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			indiviualparameters.put("SiteName", Constants.resultset.getString("SiteName"));
			indiviualparameters.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			indiviualparameters.put("IsEOB", inSheet.getRow(1).getCell(12).getStringCellValue());
			indiviualparameters.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			indiviualparameters.put("CreateBy", CreatBy_UI);
			indiviualparameters.put("UpdateBy", UpdateBy_UI);
			indiviualparameters.put("CreateDate", Createdate);
			indiviualparameters.put("UpdateDate", UpdateDate);
			indiviualparameters.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}
		System.out.println(indiviualparameters);
		return indiviualparameters;
	}
	//CompareIndivual_GroupParameters_inDB
	public static void CompareIndivual_GroupParameters_inDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(21).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(7).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> languages = new ArrayList<String>();
		String lng[] = individualgroupvaluesDBvalues.get("Languages").toString().split(",");
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());
		}
		System.out.println(languageFromDB);
		System.out.println(DBvalues);
		System.out.println(individualgroupvaluesDBvalues);

		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), individualgroupvaluesDBvalues.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), individualgroupvaluesDBvalues.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), individualgroupvaluesDBvalues.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), individualgroupvaluesDBvalues.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), individualgroupvaluesDBvalues.get("iseob"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), individualgroupvaluesDBvalues.get("Iseob"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), individualgroupvaluesDBvalues.get("status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), individualgroupvaluesDBvalues.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), individualgroupvaluesDBvalues.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), individualgroupvaluesDBvalues.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), individualgroupvaluesDBvalues.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");
			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}

	}

	public static void CompareIndivualGroupParametersinDB_afterstoreprocedure()
			throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(18).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		String Query1 = Constants.Input_SQLS.getRow(19).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			Assert.assertEquals(Constants.resultset.getString("IsEOB"), indiviualparameters.get("IsEOB"),
					"Failed as iseov not matched with DB");
		}
		String lng[] = indiviualparameters.get("Languages").toString().split(",");
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		ArrayList<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset1.next(); k++) {
			languageFromDB.add(Constants.resultset1.getString("name").trim());
		}
		System.out.println(languageFromDB);
		int i = 0;
		for (String lngs : lng) {
			Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
					"Failed as languages are matched with DB");
			i++;
		}

	}

	public static LinkedHashMap<String, String> IdentifyEmployerGroupinDB_Alllanguages()
			throws SQLException, ClassNotFoundException {

		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		String Languages = inSheet.getRow(1).getCell(7).getStringCellValue();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(inSheet.getRow(2).getCell(11).getCellType());
		Date date = inSheet.getRow(1).getCell(11).getDateCellValue();
		String Createdate = df.format(date);
		System.out.println(Createdate);
		Date date1 = inSheet.getRow(1).getCell(12).getDateCellValue();
		String UpdateDate = df.format(date);
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			EmployerGroup.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			EmployerGroup.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			EmployerGroup.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			EmployerGroup.put("SiteName", Constants.resultset.getString("SiteName"));
			EmployerGroup.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			EmployerGroup.put("IsEOB", inSheet.getRow(1).getCell(13).getStringCellValue());
			EmployerGroup.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			EmployerGroup.put("CreateBy", CreatBy_UI);
			EmployerGroup.put("UpdateBy", UpdateBy_UI);
			EmployerGroup.put("CreateDate", Createdate);
			EmployerGroup.put("UpdateDate", UpdateDate);
			EmployerGroup.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		}

		return EmployerGroup;
	}

	public static void CompareEmployerGroupParametersinDB_alllanguages()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
		String Query = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		String lngs[] = EmployerGroup.get("Languages").toString().split(",");

		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		String languageFromDB = "";
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB = languageFromDB + Constants.resultset.getString("name") + ",";

		}

		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), EmployerGroup.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), EmployerGroup.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), EmployerGroup.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), EmployerGroup.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), EmployerGroup.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), EmployerGroup.get("IsEOB"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), EmployerGroup.get("Status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), EmployerGroup.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), EmployerGroup.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), EmployerGroup.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), EmployerGroup.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");

			for (String lng : lngs) {

				Assert.assertTrue(languageFromDB.contains(lng), "Failed as languages are matched with DB");

			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excelvalues values with DB values");

		}

	}

	public static void CompareEmployerGroupParametersinDB_alllanguages_afterstoreprocedure()
			throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
		String Query = Constants.Input_SQLS.getRow(18).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		String Query1 = Constants.Input_SQLS.getRow(19).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		while (Constants.resultset.next()) {
			Assert.assertEquals(Constants.resultset.getString("IsEOB"), EmployerGroup.get("IsEOB"),
					"Failed as iseov not matched with DB");
		}
		String lngs[] = EmployerGroup.get("Languages").toString().split(",");
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		ArrayList<String> languageFromDB = new ArrayList<String>();
		while (Constants.resultset1.next()) {
			languageFromDB.add(Constants.resultset1.getString("name"));
		}
		System.out.println(languageFromDB);

		for (String lng : lngs) {
			Assert.assertTrue(languageFromDB.contains(lng), "Failed as languages are matched with DB");

		}
	}

	public static LinkedHashMap<String, String> IdentifylogicaldeletegroupGroupParametersinDB()
			throws SQLException, ClassNotFoundException {

		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"Logicaldelete_Group");
		String QEREY = Constants.Input_SQLS.getRow(20).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset1 = Constants.statement.executeQuery(QEREY);
		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			logicaldeleteGroup.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			logicaldeleteGroup.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			logicaldeleteGroup.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			logicaldeleteGroup.put("SiteName", Constants.resultset.getString("SiteName"));
			logicaldeleteGroup.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			logicaldeleteGroup.put("IsEOB", inSheet.getRow(1).getCell(13).getStringCellValue());
			logicaldeleteGroup.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
			logicaldeleteGroup.put("CreateBy", CreatBy_UI);
			logicaldeleteGroup.put("UpdateBy", UpdateBy_UI);
			logicaldeleteGroup.put("CreateDate", Createdate);
			logicaldeleteGroup.put("UpdateDate", UpdateDate);
			logicaldeleteGroup.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());
			logicaldeleteGroup.put("ISEOBNULL", inSheet.getRow(1).getCell(17).getStringCellValue());

		}
		System.out.println(logicaldeleteGroup);
		return logicaldeleteGroup;
	}

	public static void ComparelogicaldeleteGroupParametersinDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"Logicaldelete_Group");
		String Query = Constants.Input_SQLS.getRow(21).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		List<String> languages = new ArrayList<String>();
		String lng[] = logicaldeleteGroup.get("Languages").toString().split(",");
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());
		}

		System.out.println(DBvalues);
		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), logicaldeleteGroup.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), logicaldeleteGroup.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), logicaldeleteGroup.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), logicaldeleteGroup.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), logicaldeleteGroup.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), logicaldeleteGroup.get("IsEOB"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), logicaldeleteGroup.get("Status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), logicaldeleteGroup.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), logicaldeleteGroup.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), logicaldeleteGroup.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), logicaldeleteGroup.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");

			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}

	}
	public static void verify_GroupEOBLanguageTypevaluesintable() throws SQLException, ClassNotFoundException{
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		
		String languages = inSheet.getRow(7).getCell(7).getStringCellValue();
		System.out.println(languages);
		String QEREY1 = Constants.Input_SQLS.getRow(73).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
			
		System.out.println(QEREY1);
		String QEREY2 = Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue();
		QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
	    int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY2);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
		
	}		    
	public static void ComparelogicaldeletegroupinDB_afterstoreprocedure() throws ClassNotFoundException, SQLException {
		System.out.println(logicaldeleteGroup);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"Logicaldelete_Group");
		String Query = Constants.Input_SQLS.getRow(18).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		String Query1 = Constants.Input_SQLS.getRow(19).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(Constants.resultset.next());
		if (Constants.resultset.getString("IsEOB") == null)
			Assert.assertTrue(logicaldeleteGroup.get("ISEOBNULL").equalsIgnoreCase("NULL"));
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		Assert.assertTrue(!Constants.resultset1.next());
	}

	public static LinkedHashMap<String, String> Identify_ManagedGroup_Parameters_inDB()
			throws SQLException, ClassNotFoundException {

		XSSFSheet Managed_Group = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"Managed_Group");
		String QEREY = Constants.Input_SQLS.getRow(22).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", Managed_Group.getRow(1).getCell(10).getStringCellValue());
		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			ManagedGroup.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			ManagedGroup.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			ManagedGroup.put("EffectiveDate", Constants.resultset.getString("EffectiveDate").substring(0, 10));
			ManagedGroup.put("SiteName", Constants.resultset.getString("SiteName"));
			ManagedGroup.put("ISEOB", Managed_Group.getRow(1).getCell(18).getStringCellValue());
			ManagedGroup.put("EOBIndicator", Managed_Group.getRow(1).getCell(0).getStringCellValue());
		}
		return ManagedGroup;
	}

	public static void compareMangedgroupexcelvalueswithDBvalues()
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}

		List<String> DBvaluesList = new ArrayList<String>(DBvalues.values());
		List<String> ManagedValues = new ArrayList<String>(ManagedGroup.values());
		System.out.println(ManagedValues);
		System.out.println(DBvalues);
		if (ManagedValues.size() == DBvalues.size()) {
			boolean flag = true;
			for (int i = 0; i < ManagedValues.size(); i++) {

				if (flag == true) {
					try {
						if (ManagedValues.get(i) == null && DBvaluesList.get(i) == null) {
							Assert.assertTrue(true);
						} else if (ManagedValues.get(i) == null && DBvaluesList.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!(ManagedValues.get(i) == null) && DBvaluesList.get(i) == null) {

							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break;
						} else {
							if (ManagedValues.get(i).equalsIgnoreCase(DBvaluesList.get(i)) == true) {
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

	public static void compareMangedgrouplanguageswithDBlanguages()
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");

		String QUEREY = Constants.Input_SQLS.getRow(6).getCell(1).getStringCellValue();
		QUEREY = QUEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QUEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QUEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}

	public static void CompareManagedGroupParametersinDB_afterstoreprocedure()
			throws ClassNotFoundException, SQLException {
		System.out.println(logicaldeleteGroup);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Managed_Group");
		String Query = Constants.Input_SQLS.getRow(18).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		String Query1 = Constants.Input_SQLS.getRow(19).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(Constants.resultset.next());
		Assert.assertEquals(Constants.resultset.getString("IsEOB"), ManagedGroup.get("ISEOB"),
				"Failed as iseob not matched with DB");
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		Assert.assertTrue(!Constants.resultset1.next());
	}

	public static LinkedHashMap<String, String> IdentifyAlllanguagesGroupParametersinDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		String CreateBy = EOBGroupException.Loginid().getText();
		String CreatBy_UI = CreateBy.substring(3, 11);
		String UpdateBy = EOBGroupException.Loginid().getText();
		String UpdateBy_UI = UpdateBy.substring(3, 11);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		System.out.println(Createdate);
		String UpdateDate = date1;
		System.out.println(UpdateDate);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"All_languages_group");
		Alllanguages.put("MasterGroupNumber", inSheet.getRow(1).getCell(4).getStringCellValue());
		Alllanguages.put("GroupNumber", inSheet.getRow(1).getCell(1).getStringCellValue());
		Alllanguages.put("EffectiveDate", inSheet.getRow(1).getCell(2).getStringCellValue());
		Alllanguages.put("SiteName", inSheet.getRow(1).getCell(3).getStringCellValue());
		Alllanguages.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
		Alllanguages.put("Alllanguages", inSheet.getRow(1).getCell(7).getStringCellValue());
		Alllanguages.put("IsEOB", inSheet.getRow(1).getCell(13).getStringCellValue());
		Alllanguages.put("Status", inSheet.getRow(1).getCell(8).getStringCellValue());
		Alllanguages.put("CreateBy", CreatBy_UI);
		Alllanguages.put("UpdateBy", UpdateBy_UI);
		Alllanguages.put("CreateDate", Createdate);
		Alllanguages.put("UpdateDate", UpdateDate);
		Alllanguages.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());

		return Alllanguages;

	}
	public static void CompareIndivualGroupParametersinDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(21).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println("languages");
		System.out.println(indiviualparameters);
		List<String> languages = new ArrayList<String>();
		String lng[] = indiviualparameters.get("Languages").toString().split(",");
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());
		}
		System.out.println(languageFromDB);
		System.out.println(DBvalues);
		System.out.println(indiviualparameters);

		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), indiviualparameters.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), indiviualparameters.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), indiviualparameters.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), indiviualparameters.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), indiviualparameters.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), indiviualparameters.get("IsEOB"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), indiviualparameters.get("Status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), indiviualparameters.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), indiviualparameters.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), indiviualparameters.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), indiviualparameters.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");
			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}

	}

	public static void CompareAlllanguagesGroupParametersinDB()
			throws SQLException, ClassNotFoundException, InterruptedException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"All_languages_group");
		String Query = Constants.Input_SQLS.getRow(21).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> languages = new ArrayList<String>();
		String lng[] = Alllanguages.get("Languages").toString().split(",");
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());
		}

		System.out.println(DBvalues);
		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), Alllanguages.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), Alllanguages.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), Alllanguages.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), Alllanguages.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), Alllanguages.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), Alllanguages.get("IsEOB"),
					"Failed as IsEOB not matched with DB");
			Assert.assertEquals(DBvalues.get("Status"), Alllanguages.get("Status"),
					"Failed as Status not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateBy"), Alllanguages.get("CreateBy"),
					"Failed as CreateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateBy"), Alllanguages.get("UpdateBy"),
					"Failed as UpdateBy not matched with DB");
			Assert.assertEquals(DBvalues.get("CreateDate").substring(0, 10), Alllanguages.get("CreateDate"),
					"Failed as CreateDate not matched with DB");
			Assert.assertEquals(DBvalues.get("UpdateDate").substring(0, 10), Alllanguages.get("UpdateDate"),
					"Failed as UpdateDate not matched with DB");

			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}
	}

	public static LinkedHashMap<String, String> IdentifyDifferentEffectiveDateGroupParametersinDB_EmployerGroup()
			throws SQLException, ClassNotFoundException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"differenteffectivedate");
		String QEREY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			DifferentEffectivedate.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			DifferentEffectivedate.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			DifferentEffectivedate.put("EffectiveDate",
					Constants.resultset.getString("EffectiveDate").substring(0, 10));
			DifferentEffectivedate.put("SiteName", Constants.resultset.getString("SiteName"));
			DifferentEffectivedate.put("ISEOB", inSheet.getRow(1).getCell(13).getStringCellValue());
			DifferentEffectivedate.put("IsEOB_0", inSheet.getRow(1).getCell(17).getStringCellValue());
			DifferentEffectivedate.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
			DifferentEffectivedate.put("Languages", inSheet.getRow(1).getCell(7).getStringCellValue());
		}
		System.out.println(DifferentEffectivedate);
		return DifferentEffectivedate;
	}

	public static void compareDifferentEffectiveDateGroupParametersinDBwithDBvalues()
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"differenteffectivedate");
		String QEREY = Constants.Input_SQLS.getRow(25).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(2).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> languages = new ArrayList<String>();
		String lng[] = DifferentEffectivedate.get("Languages").toString().split(",");
		LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
		List<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset.next(); k++) {

			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				if (k == 0)
					DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

			}
			languageFromDB.add(Constants.resultset.getString("name").trim());

		}

		try {
			Assert.assertEquals(DBvalues.get("GroupNumber"), DifferentEffectivedate.get("GroupNumber"),
					"Failed as Group Number not matched with DB");
			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), DifferentEffectivedate.get("MasterGroupNumber"),
					"Failed as mastegroupnumber Number not matched with DB");
			Assert.assertEquals(DBvalues.get("Effectivedate"), DifferentEffectivedate.get("EffectiveDate"),
					"Failed as Groupeffectivedate not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), DifferentEffectivedate.get("SiteName"),
					"Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), DifferentEffectivedate.get("EOBIndicator"),
					"Failed as EOB Indicator not matched with DB");
			Assert.assertEquals(DBvalues.get("IsEOB"), DifferentEffectivedate.get("ISEOB"),
					"Failed as IsEOB not matched with DB");

			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to to compare excel values with DB values");

		}
	}

	public static void compareDifferentEffectiveDateGroupParametersinDBwithDBvalues_afterstoreprocedure()
			throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
				"differenteffectivedate");
		String Query = Constants.Input_SQLS.getRow(26).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(1).getCell(2).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(Query);
		String Query1 = Constants.Input_SQLS.getRow(27).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1", inSheet.getRow(1).getCell(2).getStringCellValue()).replace("parameter2",
				inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(Query1);
		String Query2 = Constants.Input_SQLS.getRow(26).getCell(1).getStringCellValue();
		Query2 = Query2.replace("parameter1", inSheet.getRow(2).getCell(2).getStringCellValue()).replace("parameter2",
				inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(Query2);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();

		while (Constants.resultset.next()) {
			System.out.println(Constants.resultset.getString("IsEOB"));
			Assert.assertEquals(Constants.resultset.getString("IsEOB"), DifferentEffectivedate.get("ISEOB"),
					"Failed as iseov not matched with DB");
		}
		String lng[] = DifferentEffectivedate.get("Languages").toString().split(",");
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		ArrayList<String> languageFromDB = new ArrayList<String>();
		for (int k = 0; Constants.resultset1.next(); k++) {
			languageFromDB.add(Constants.resultset1.getString("name").trim());
		}
		System.out.println(languageFromDB);
		int i = 0;
		for (String lngs : lng) {
			Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
					"Failed as languages are matched with DB");
			i++;
		}
		
		Constants.resultset2 = Constants.statement.executeQuery(Query2);
		Constants.resultsetMetadata2 =Constants.resultset2.getMetaData();
		while (Constants.resultset2.next()) {
			
			Assert.assertEquals(Constants.resultset2.getString("IsEOB"), DifferentEffectivedate.get("IsEOB_0"),
					"Failed as iseov not matched with DB");
			System.out.println(Constants.resultset2.getString("IsEOB"));
		}
		

	}

	public static void clickOnSearch_button() {
		try {
			Utils.click(EOBGroupException.clickonSearch());
			Constants.test.log(Status.PASS, "click on Search Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Button");
			Assert.fail("failed to click on Search Button");
		}
	}
	//updateclickonSearch

	public static void updateclickOnSearch_button() {
		try {
			Utils.click(EOBGroupException.updateclickonSearch());
			Constants.test.log(Status.PASS, "click on Search Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Button");
			Assert.fail("failed to click on Search Button");
		}
	}
	public static void clickOnSearchEOBGroupExceptions_link() {
		try {
			Utils.click(EOBGroupException.SearchEOBGroupExceptions());
			Constants.test.log(Status.PASS, "click on Search EOB Group Exceptions link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search EOB Group Exceptions link");
			Assert.fail("failed to click on Search EOB Group Exceptions link");
		}
	}

	public static void compareEoblanguageswithDBlanguages_EOBGroupException()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {

			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			String QUEREY = Constants.Input_SQLS.getRow(9).getCell(1).getStringCellValue();
			QUEREY = QUEREY.replace("parameter1", inSheet.getRow(1).getCell(9).getStringCellValue());
			Utils.connectToSqlserverDB();

			Constants.resultset = Constants.statement.executeQuery(QUEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();

			List<String> DBValues = new ArrayList<String>();

			while (Constants.resultset.next()) {
				DBValues.add(Constants.resultset.getString(1));

			}
			try {

				List<WebElement> languageElements = EOBGroupException.Verifylanguages();

				for (int i = 0; i < languageElements.size(); i++) {
					Assert.assertTrue(DBValues.get(i).toString().equals(languageElements.get(i).getText()),
							"Failed as languages are matched with DB");
				}

			}
			catch (AssertionError ae) {

				Assert.fail(ae.getMessage());

			}
		}

		catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to compare search results with DB values");

		}
	}

	public static void compareSiteNamedropdownvalueswithDBvalues_EOBGroupException()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			String QUEREY = Constants.Input_SQLS.getRow(10).getCell(1).getStringCellValue();

			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QUEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();

			List<String> DBValues = new ArrayList<String>();

			while (Constants.resultset.next()) {
				DBValues.add(Constants.resultset.getString(1));

			}

			try {

				List<WebElement> Sitenames = EOBGroupException.SiteName_dropdown().getOptions();

				for (int i = 0; i < Sitenames.size(); i++) {
					Assert.assertTrue(DBValues.get(i).toString().equals(Sitenames.get(i).getText()),
							"Failed as languages are matched with DB");
				}

			}

			catch (AssertionError ae) {

				Assert.fail(ae.getMessage());

			}
		}

		catch (Exception e) {
			System.out.println(e);
			Constants.test.log(Status.FAIL, "compare search results with DB values");
			Assert.fail("failed to compare search results with DB values");

		}
	}
/*	public static void compareiseobvalueswithDBvalues_EOBGroupException()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
	

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String iseob = inSheet.getRow(1).getCell(16).getStringCellValue();
		System.out.println(iseob);
		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue())
				.replace("parameter1", inSheet.getRow(2).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter1", inSheet.getRow(2).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
		

			List<String> DBValues = new ArrayList<String>();

			while (Constants.resultset.next()) {
				DBValues.add(Constants.resultset.getString(1));

			}
			System.out.println(DBValues);
			List<String> iseob = new ArrayList<String>();
			iseob.add(inSheet.getRow(5).getCell(17).getStringCellValue());
			iseob.add(inSheet.getRow(5).getCell(12).getStringCellValue());
			System.out.println(iseob);
		
				for (int i = 0; i < iseob.size(); i++) {
					System.out.println(DBValues.get(i));
					System.out.println(iseob.get(i));
					Assert.assertTrue(DBValues.get(i).toString().equals(iseob.get(i).toString()),
							"Failed as iseob are matched with DB");
				}

		

			
	}*/

	public static void compareSearchResultcountWithDBvaluescount_EOBGroupException()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {

			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			String QUEREY = Constants.Input_SQLS.getRow(8).getCell(1).getStringCellValue();
			QUEREY = QUEREY.replace("parameter1", inSheet.getRow(1).getCell(8).getStringCellValue());
			System.out.println(QUEREY);
			Utils.connectToSqlserverDB();
			int uiresult = EOBGroupException.searchResults_Count().size();
			System.out.println(uiresult);
			Constants.resultset = Constants.statement.executeQuery(QUEREY);
			while (Constants.resultset.next()) {
				Constants.resultset = Constants.statement.executeQuery(QUEREY);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				System.out.println(Constants.resultset);
				System.out.println(Constants.resultset.next());
				String DBcount = Constants.resultset.getString("count");
				System.out.println(DBcount);
				int DBCountresult = Integer.parseInt(DBcount);
				Assert.assertTrue(uiresult == DBCountresult);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void verifyhighlightedrecord() {
		try {
			// wait.until(ExpectedConditions.visibilityOf(ComponentCodePage.proceesRecords_button()));
			Thread.sleep(5000);
			String recordcolor = EOBGroupException.verifyinghighlightedrecord().getCssValue("color");
			System.out.println(recordcolor);
			System.out.println(Color.fromString(recordcolor).asHex());

			Constants.test.log(Status.PASS, "records are highlighted in Green color ");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "records are highlighted in Green color");
			Assert.fail("failed to verify record colour");
		}
	}

	public static void checkSuccessfullmessage_EOBGroupException() {
		try {

			Assert.assertTrue(EOBGroupException.checkSuccessfullMessage().getText()
					.equalsIgnoreCase("Your new exception has been successfully created."));
			Constants.test.log(Status.PASS, "check error message displayed for  EOBGroupException");
			System.out.println(EOBGroupException.checkErrorMessage().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for  EOBGroupException");
			Assert.fail("failed to check error message displayed for  EOBGroupException");
		}
	}

	public static void verifyMastergroupnumberinEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifyMasterGroupNumber().isDisplayed());
			Constants.test.log(Status.PASS, "check MasterGroupNumber Parameter is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check MasterGroupNumber Parameter is displayed");
			Assert.fail("failed tocheck MasterGroupNumber Parameter is displayed");
		}
	}
	public static void verifylanguagesinupdatedscreen() {
		try {
			
			for (int i = 0; i < EOBGroupException.multiplecheckbox_languages().size(); i++) {
				Assert.assertFalse(EOBGroupException.multiplecheckbox_languages().get(i).isEnabled());
			}
			
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check MasterGroupNumber Parameter is displayed");
			Assert.fail("failed tocheck MasterGroupNumber Parameter is displayed");
		}
	}

	public static void verifygroupnumberinEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifyGroupNumber().isDisplayed());
			Constants.test.log(Status.PASS, "check GroupNumber Parameter is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check GroupNumber Parameter is displayed");
			Assert.fail("failed to check GroupNumber Parameter is displayed");
		}
	}

	public static void verifygroupEffectivedateinEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifyGroupEffectiveDate().isDisplayed());
			Constants.test.log(Status.PASS, "check GroupEffectivedate Parameter is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check GroupEffectivedate Parameter is displayed");
			Assert.fail("failed to check GroupEffectivedate Parameter is displayed");
		}
	}

	public static void verifySiteNameinEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifySiteName().isDisplayed());
			Constants.test.log(Status.PASS, "check SiteName Parameter is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check SiteName Parameter is displayed");
			Assert.fail("failed to check SiteName Parameter is displayed");
		}
	}

	public static void verifyEOBIndicatorinEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifyEOBIndicator().isDisplayed());
			Constants.test.log(Status.PASS, "check EOBGroupIndicator Parameter is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check EOBGroupIndicator Parameter is displayed");
			Assert.fail("failed to check EOBGroupIndicator Parameter is displayed");
		}
	}

	public static void verifySaveButtonEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.Save_Button().isDisplayed());
			Constants.test.log(Status.PASS, "check Save Button is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Save Button is displayed");
			Assert.fail("failed to check Save Button is displayed");
		}
	}

	public static void verifyCancelButtonEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.Save_Button().isDisplayed());
			Constants.test.log(Status.PASS, "check Cancel Button is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Cancel Button is displayed");
			Assert.fail("failed to check Cancel Button is displayed");
		}
	}

	public static void verifySearchButtoninEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifySearchButton().isDisplayed());
			Constants.test.log(Status.PASS, "check Serach Button is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Serach Button is displayed");
			Assert.fail("failed to check check Serach Button is displayed");
		}
	}

	public static void verifyCancelButtonnEobgroupException() {
		try {
			Assert.assertTrue(EOBGroupException.VerifyCancelButton().isDisplayed());
			Constants.test.log(Status.PASS, "check Cancel Button is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Cancel Button is displayed");
			Assert.fail("failed to check Cancel Button is displayed");
		}
	}

	public static void verifyMasterGroupNumber_Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.Mastergroupnumber_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify MasterGroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify MasterGroupNumber is displayed");
			Assert.fail("failed to verify MasterGroupNumber is displayed");
		}
	}

	public static void verifyGroupNumber__Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.Groupnumber_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify GroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify GroupNumber is displayed");
			Assert.fail("failed to verify GroupNumber is displayed");
		}
	}

	public static void verifyGroupName__Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.GroupName_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify GroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify GroupNumber is displayed");
			Assert.fail("failed to verify GroupNumber is displayed");
		}
	}

	public static void verifyGroupEffectiveDate_Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.GroupEffectiveDate_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify GroupEffectiveDate is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify GroupEffectiveDate is displayed");
			Assert.fail("failed to verify GroupEffectiveDate is displayed");
		}
	}

	public static void verifySiteName_Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.SiteName_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify SiteName is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify SiteName is displayed");
			Assert.fail("failed to verify SiteName is displayed");
		}
	}

	public static boolean Search_Employergroup__DB() throws ClassNotFoundException, SQLException {
		// try {

		boolean flag = false;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(23).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		System.out.println(Constants.resultset);

		if (Constants.resultset.next()) {

			flag = true;
		}

		return flag;

	}

	public static void verifyEOBIndicator_Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.EOBIndicator_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify MasterGroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify MasterGroupNumber is displayed");
			Assert.fail("failed to verify MasterGroupNumber is displayed");
		}
	}

	public static void verifyLanguage_Result_grid() {
		try {
			Assert.assertTrue(EOBGroupException.Language_result_grid().isDisplayed());
			Constants.test.log(Status.PASS, "verify Language is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify Language is displayed");
			Assert.fail("failed to verify Language is displayed");
		}
	}

	public static void verifyMasterGroupNumber_label() {
		try {
			Assert.assertTrue(EOBGroupException.Mastergroupnumber_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify MasterGroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify MasterGroupNumber is displayed");
			Assert.fail("failed to verify MasterGroupNumber is displayed");
		}
	}

	public static void verifyGroupNumber_label() {
		try {
			Assert.assertTrue(EOBGroupException.groupnumber_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify GroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify GroupNumber is displayed");
			Assert.fail("failed to verify GroupNumber is displayed");
		}
	}

	public static void Clear_button() {
		EOBGroupException.Clear_Button().click();
	}

	public static void verifyGroupEffectiveDate_label() {
		try {
			Assert.assertTrue(EOBGroupException.GroupEffectiveDate_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify GroupEffectiveDate is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify GroupEffectiveDate is displayed");
			Assert.fail("failed to verify GroupEffectiveDate is displayed");
		}
	}

	public static void refresh() {
		driver.navigate().refresh();

		Actions actionObject = new Actions(driver);
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();

	}

	public static void verifySiteName_label() {
		try {
			Assert.assertTrue(EOBGroupException.SiteName_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify SiteName is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify SiteName is displayed");
			Assert.fail("failed to verify SiteName is displayed");
		}
	}

	public static void verifyEOBIndicator_label() {
		try {
			Assert.assertTrue(EOBGroupException.EOBIndicator_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify MasterGroupNumber is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify MasterGroupNumber is displayed");
			Assert.fail("failed to verify MasterGroupNumber is displayed");
		}
	}

	public static void verifyLanguage_label() {
		try {
			Assert.assertTrue(EOBGroupException.Language_label().isDisplayed());
			Constants.test.log(Status.PASS, "verify Language is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify Language is displayed");
			Assert.fail("failed to verify Language is displayed");
		}
	}

	public static void clickOnCancel_button() {
		try {
			Utils.click(EOBGroupException.Clickoncancel());
			Constants.test.log(Status.PASS, "click on Cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Failed to click on cancel button");
			Assert.fail("Failed to click on cancel button");
		}

	}

	public static void Alert_Accept() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(8000);
			alert.accept();
			Constants.test.log(Status.PASS, "check Alert is displayed");
		}

		catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Alert is displayed");
			Assert.fail("failed to check Alert is displayed");
		}
	}

	public static void Alert_Dismiss() throws InterruptedException {
		// TODO Auto-generated method stub
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
	
	/*
	public static LinkedHashMap<String, String>securityquestions()
			throws SQLException, ClassNotFoundException {
		
		securityquestion.put("What was your first phone number?", "phone1");
		securityquestion.put("Who is your favorite sports team?", "sports1");
		securityquestion.put("What is your favorite color?", "color1");
		
		System.out.println(securityquestion);
		return securityquestion;

	}*/

	public static LinkedHashMap<String, String> Retrivingparticularrowtext(String GroupNumber)
			throws SQLException, ClassNotFoundException {

		System.out.println(EOBGroupException.Selectparticularrowtext(GroupNumber).size());
		List<WebElement> rowtext = EOBGroupException.Selectparticularrowtext(GroupNumber);
		String EOBIndicator = rowtext.get(5).getText();
		String Languages = rowtext.get(6).getText();
		Particularrowtext.put("MasterGroupNumber", rowtext.get(0).getText());
		Particularrowtext.put("GroupNumber", rowtext.get(1).getText());
		Particularrowtext.put("GroupName", rowtext.get(2).getText());
		Particularrowtext.put("EffectiveDate", rowtext.get(3).getText());
		Particularrowtext.put("SiteName", rowtext.get(4).getText());
		Particularrowtext.put("EOBIndicator", rowtext.get(5).getText());
		Particularrowtext.put("Languages", rowtext.get(6).getText());
		System.out.println(Particularrowtext);
		return Particularrowtext;

	}// Searchresults

	public static void count_EOBGroupException()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		try {

			XSSFSheet inSheet = Utils.excel_sheet(
					"./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx", "Sheet1");
			String QUEREY = Constants.Input_SQLS.getRow(8).getCell(1).getStringCellValue();
			QUEREY = QUEREY.replace("parameter1", inSheet.getRow(1).getCell(8).getStringCellValue());
			System.out.println(QUEREY);
			Utils.connectToSqlserverDB();
			int uiresult = EOBGroupException.searchResults_Count().size();
			System.out.println(uiresult);

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void clickOnUpdatebutton() {
		try {

			Utils.click(EOBGroupException.Clickonupdategroupexception());
			Constants.test.log(Status.PASS, "click on update");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on update");
			Assert.fail("failed to click on click on update");
		}

	}

	public static void CompareDelete_Exception_Cancel_withDbValus() throws ClassNotFoundException, SQLException {

		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String QEREY = Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter2",
					inSheet.getRow(3).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			String Status = inSheet.getRow(3).getCell(8).getStringCellValue();
			System.out.println(Status);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			while (Constants.resultset.next()) {
				String DBstatus = Constants.resultset.getString("status");
				System.out.println(DBstatus);
				Assert.assertEquals(DBstatus, Status);
				System.out.println("DB values are equal");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void Compare_Status_withDbValus() throws ClassNotFoundException, SQLException {

		try {

			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String Query = Constants.Input_SQLS.getRow(15).getCell(1).getStringCellValue();
			Query = Query.replace("parameter1", inSheet.getRow(5).getCell(1).getStringCellValue());
			System.out.println(Query);
			Utils.connectToSqlserverDB();
			String Status = inSheet.getRow(5).getCell(17).getStringCellValue();
			System.out.println(Status);
			Constants.resultset = Constants.statement.executeQuery(Query);
			while (Constants.resultset.next()) {
				String DBstatus = Constants.resultset.getString("status");
				Assert.assertEquals(DBstatus, Status);

			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}

	public static void Compare_multiplerecord_Status_withDbValus() throws ClassNotFoundException, SQLException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(5).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(6).getCell(1).getStringCellValue());
		System.out.println(Query);
		Utils.connectToSqlserverDB();

		Constants.resultset = Constants.statement.executeQuery(Query);

		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		/*List<Map> list = new ArrayList<Map>();
		System.out.println("Column count " + Constants.resultsetMetadata.getColumnCount());
		while (Constants.resultset.next()) {
			Map<String, String> DBvalues = new HashMap<String, String>();
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
			list.add(DBvalues);

		}

		List<Map<String, String>> dataFromExcel = new ArrayList<Map<String, String>>();

		Map<String, String> map1FromExcel = new HashMap<String, String>();

		map1FromExcel.put("groupnumber", inSheet.getRow(6).getCell(1).getStringCellValue());
		map1FromExcel.put("name", inSheet.getRow(6).getCell(7).getStringCellValue());

		Map<String, String> map2FromExcel = new HashMap<String, String>();

		map2FromExcel.put("groupnumber", inSheet.getRow(9).getCell(1).getStringCellValue());
		map2FromExcel.put("name", inSheet.getRow(9).getCell(7).getStringCellValue());

		dataFromExcel.add(map1FromExcel);
		dataFromExcel.add(map2FromExcel);

		System.out.println(dataFromExcel);
		System.out.println(list);*/
		//Assert.assertEquals(dataFromExcel, list);

	}

	public static void verifyinsertedrecordindb()
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		Thread.sleep(3000);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		System.out.println(date1);
		String Createdate = date1;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String languages = inSheet.getRow(7).getCell(7).getStringCellValue();
		System.out.println(languages);
		String QEREY = Constants.Input_SQLS.getRow(78).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter2", inSheet.getRow(8).getCell(1).getStringCellValue())
				.replace("parameter3",Createdate );
		String QEREY1 = Constants.Input_SQLS.getRow(37).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter2", inSheet.getRow(8).getCell(1).getStringCellValue())
				.replace("parameter3", Createdate);
		int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
	
	}

	

	public static void comparedbvalueswithexcelvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String status = inSheet.getRow(6).getCell(17).getStringCellValue();
			System.out.println(status);
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void compareupdatedstatusdbvalueswithexcelvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String status = inSheet.getRow(16).getCell(21).getStringCellValue();
			System.out.println(status);
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void comparestatusdbvalueswithexcelvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String status = inSheet.getRow(16).getCell(22).getStringCellValue();
			System.out.println(status);
			String QEREY = Constants.Input_SQLS.getRow(76).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(17).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(18).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(77).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(17).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(18).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void compareiseobdbvalueswithexcelvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String status = inSheet.getRow(16).getCell(16).getStringCellValue();
			System.out.println(status);
			String QEREY = Constants.Input_SQLS.getRow(44).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void compareactiontypeiddbvaluesandexcelvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String status = inSheet.getRow(6).getCell(17).getStringCellValue();
			System.out.println(status);
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void comparedeletedrecordstatusin_withdbvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String status = inSheet.getRow(1).getCell(18).getStringCellValue();
		
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(1).getCell(1).getStringCellValue());
	
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(2).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			System.out.println(rowCount);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void verifyupdatediseobdbexcelvaluewithdbvalue()
			throws ClassNotFoundException, SQLException, InterruptedException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String iseob = inSheet.getRow(7).getCell(12).getStringCellValue();
		System.out.println(iseob);
		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(8).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
		int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					System.out.println(Constants.resultset.getString(j));
					if (Constants.resultset.getString(j) == null && iseob.equals("NULL")) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
	}
	public static void verifyiseobdbexcelvaluewithdbvalue()
			throws ClassNotFoundException, SQLException, InterruptedException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String iseob = inSheet.getRow(6).getCell(14).getStringCellValue();
		System.out.println(iseob);
		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
		int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset1 = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata1 = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					System.out.println(Constants.resultset.getString(j));
					if (Constants.resultset.getString(j) == null && iseob.equals("NULL")) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
	}
	public static void verifygroupiseobdbexcelvaluewithdbvalue()
			throws ClassNotFoundException, SQLException, InterruptedException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String iseob = inSheet.getRow(16).getCell(16).getStringCellValue();
		System.out.println(iseob);
		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
		int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					System.out.println(Constants.resultset.getString(j));
					if (Constants.resultset.getString(j) == null && iseob.equals("NULL")) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
	}
		public static void verifyiseobdbexcelvalueswithdbvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String iseob = inSheet.getRow(1).getCell(16).getStringCellValue();
		System.out.println(iseob);
		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QEREY1);
		int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					System.out.println(Constants.resultset.getString(j));
					if (Constants.resultset.getString(j) == null && iseob.equals("NULL")) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
		XSSFSheet individual = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String Query = Constants.Input_SQLS.getRow(60).getCell(1).getStringCellValue();
		Query = Query.replace("parameter1", individual.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", individual.getRow(2).getCell(10).getStringCellValue())
				.replace("parameter3", individual.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter4", individual.getRow(2).getCell(1).getStringCellValue());
		System.out.println(Query);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
		public static void verifyGroupEOBLanguageTypevaluesintable() throws SQLException, ClassNotFoundException{
		XSSFSheet individual = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String Query = Constants.Input_SQLS.getRow(66).getCell(1).getStringCellValue();
		System.out.println(individual.getRow(5).getCell(10).getStringCellValue());
		Query = Query.replace("parameter1",individual.getRow(5).getCell(10).getStringCellValue())
				.replace("parameter2", individual.getRow(5).getCell(20).getStringCellValue());
				
		System.out.println(Query);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
			    
		String Query1 = Constants.Input_SQLS.getRow(65).getCell(1).getStringCellValue();
		Query1 = Query1.replace("parameter1",individual.getRow(6).getCell(10).getStringCellValue())
				.replace("parameter2", individual.getRow(6).getCell(18).getStringCellValue())
		         .replace("parameter3", individual.getRow(6).getCell(20).getStringCellValue());
				
		System.out.println(Query1);
		Constants.resultset1 = Constants.statement.executeQuery(Query1);
		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		List<String> DBValues = new ArrayList<String>();

		while (Constants.resultset1.next()) {
			DBValues.add(Constants.resultset1.getString(1));

		}
	   
	    System.out.println(DBValues);
	    String Query2 = Constants.Input_SQLS.getRow(64).getCell(1).getStringCellValue();
        Query2 = Query2.replace("parameter1",individual.getRow(6).getCell(20).getStringCellValue())
        .replace("parameter2",individual.getRow(6).getCell(21).getStringCellValue())
        .replace("parameter3",individual.getRow(6).getCell(11).getStringCellValue());
		System.out.println(Query2);
			ResultSet Result = Constants.statement.executeQuery(Query2);
			List<String> auditDBValues = new ArrayList<String>();
			while (Result.next()) {
				auditDBValues.add(Result.getString(1));
			}
			System.out.println(auditDBValues);
			 
	
		}
		public static void verifyiseobdbexcelvalues_withdbvalues()
				throws ClassNotFoundException, SQLException, InterruptedException {
			List<String> ExcelValues = new ArrayList<String>();
			
		    	  XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		  		String QEREY = Constants.Input_SQLS.getRow(45).getCell(1).getStringCellValue();
		  		QEREY = QEREY.replace("parameter1", inSheet.getRow(5).getCell(10).getStringCellValue())
		  				.replace("parameter2", inSheet.getRow(5).getCell(1).getStringCellValue())
		  				.replace("parameter3", inSheet.getRow(6).getCell(1).getStringCellValue());
		  	
		  		System.out.println(QEREY);
		  		String QEREY1 = Constants.Input_SQLS.getRow(46).getCell(1).getStringCellValue();
		  		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(6).getCell(10).getStringCellValue())
		  				.replace("parameter2", inSheet.getRow(5).getCell(1).getStringCellValue())
		  				.replace("parameter3", inSheet.getRow(6).getCell(1).getStringCellValue());
		  		System.out.println(QEREY1);
		  		List<String> DBValues = new ArrayList<String>();
		  		Utils.connectToSqlserverDB();
		  		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		  		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		  		
				while (Constants.resultset.next()) {
					DBValues.add(Constants.resultset.getString("iseob"));
                }
				List<String>excelvalues=new ArrayList<String>();
				excelvalues.add(inSheet.getRow(5).getCell(17).getStringCellValue());
				excelvalues.add(inSheet.getRow(5).getCell(12).getStringCellValue());
				System.out.println(excelvalues);
                System.out.println(DBValues);
                Assert.assertEquals(excelvalues,DBValues);
		}
		public static void compareupdatediseobdbvalueswithexcelvalues()
				throws ClassNotFoundException, SQLException, InterruptedException {
			try {
				XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
				String status = inSheet.getRow(7).getCell(9).getStringCellValue();
				System.out.println(status);
				String QEREY = Constants.Input_SQLS.getRow(44).getCell(1).getStringCellValue();
				QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
						.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
						.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
				System.out.println(QEREY);
				String QEREY1 = Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue();
				QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
						.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
						.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
				System.out.println(QEREY1);
				int rowCount = 0;
				boolean versionFoundInDB = false;
				Utils.connectToSqlserverDB();
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				Constants.resultset.next();
				rowCount = Constants.resultset.getInt(1);
				Constants.resultset = Constants.statement.executeQuery(QEREY1);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				label: for (int i = 1; i <= rowCount; i++) {
					if (Constants.resultset.next()) {
						for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
							if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
								versionFoundInDB = true;
								break label;
							}
						}
					}
				}
				if (versionFoundInDB == true) {
					Assert.assertTrue(versionFoundInDB, "Record is present in Database");
				}
			} catch (Exception e) {
				Assert.fail();
			}
		}
	public static void compareupdatedrecordstatusindbvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String status = inSheet.getRow(7).getCell(8).getStringCellValue();
			System.out.println(status);
		
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(7).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(7).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(8).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			System.out.println(rowCount);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void comparedeletedrecordstatusindbvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String status = inSheet.getRow(6).getCell(17).getStringCellValue();
			System.out.println(status);
		
			String QEREY = Constants.Input_SQLS.getRow(67).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(68).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
			System.out.println(QEREY1);
			int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			System.out.println(rowCount);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(status)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
	public static void compareactiontypeidinauditEOBPlanRuleException_db()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
			String actiontypeid = inSheet.getRow(1).getCell(7).getStringCellValue();
			System.out.println(actiontypeid);
			String QEREY = Constants.Input_SQLS.getRow(56).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			String QEREY1 = Constants.Input_SQLS.getRow(57).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(actiontypeid)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}}
	public static void compareactiontypeidinauditEOBPlanRuleExceptiondbvalues()
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
			String actiontypeid = inSheet.getRow(6).getCell(18).getStringCellValue();
			System.out.println(actiontypeid);
			String QEREY = Constants.Input_SQLS.getRow(50).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(9).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY);
			String QEREY1 = Constants.Input_SQLS.getRow(40).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(6).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(9).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY1);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(actiontypeid)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}


	public static void verifysearchresultswithdbresults()
			throws ClassNotFoundException, SQLException, InterruptedException {
		String QEREY = Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue();
		Utils.connectToSqlserverDB();
		Thread.sleep(3000);
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Thread.sleep(3000);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> DBresultsList = new ArrayList<String>(DBvalues.values());
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresultsList.add(Constants.resultset.getString(j));
			}

		}
		System.out.println(DBresultsList.size());
		System.out.println(updated_results.size());
		System.out.println(DBresultsList);
		System.out.println(updated_results);

		if (updated_results.size() == DBresultsList.size()) {
			boolean flag = true;
			for (int i = 0; i < updated_results.size(); i++) {

				if (flag == true) {
					try {
						if (updated_results.get(i) == null && DBresultsList.get(i) == null) {
							Assert.assertTrue(true);
						} else if (updated_results.get(i) == null && DBresultsList.get(i) != null) {
							Constants.test.log(Status.FAIL, "compare uploaded values with DB values");
							Assert.fail();
							break;
						} else if (!(updated_results.get(i) == null) && DBresultsList.get(i) == null) {

							Constants.test.log(Status.FAIL, "compare search results with DB values");
							Assert.fail();
							break;
						} else {
							if (updated_results.get(i).equalsIgnoreCase(DBresultsList.get(i)) == true) {
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

	public static void verifyactiontypein_DB() throws ClassNotFoundException, SQLException, InterruptedException {

		String QEREY = Constants.Input_SQLS.getRow(39).getCell(1).getStringCellValue();
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
				if (value != null)
					System.out.println(value);
			}

		}
	}

	public static void comparesearchuiresultscountwithdbcount() throws SQLException, ClassNotFoundException {
	

		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
			String QUEREY = Constants.Input_SQLS.getRow(42).getCell(1).getStringCellValue();
			QUEREY = QUEREY.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue());
		
			System.out.println(QUEREY);
			Utils.connectToSqlserverDB();
			int uiresult = EOBGroupException.searchResults_Count().size();
			System.out.println(uiresult);
			Constants.resultset = Constants.statement.executeQuery(QUEREY);
			while (Constants.resultset.next()) 
			{
				Constants.resultset = Constants.statement.executeQuery(QUEREY);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				System.out.println(Constants.resultset);
				System.out.println(Constants.resultset.next());
				String DBcount = Constants.resultset.getString("count");
				System.out.println(DBcount);
				int DBCountresult = Integer.parseInt(DBcount);
				Assert.assertTrue(uiresult == DBCountresult);
			}}
			
		
			
	
	public static void VerifyauditEOBPlanRuleExceptionLanguageType_EOBPlanRuleExceptionLanguageTypeindb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void VerifyDeletedgroupsin_EOBPlanRuleExceptionLanguageType_audittableindb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void VerifyDeletedgroupsin_EOBPlanRuleExceptionLanguageTypetableindb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(48).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void VerifyDeletedgroupsin_auditGroupEOBLanguageType_indb() throws ClassNotFoundException, SQLException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String languages = inSheet.getRow(3).getCell(7).getStringCellValue();
		System.out.println(languages);
		String QEREY1 = Constants.Input_SQLS.getRow(74).getCell(1).getStringCellValue();
		QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(3).getCell(20).getStringCellValue())
				.replace("parameter2", inSheet.getRow(3).getCell(21).getStringCellValue())
				.replace("parameter3", date1);
		System.out.println(QEREY1);
		String QEREY2 = Constants.Input_SQLS.getRow(75).getCell(1).getStringCellValue();
		QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(3).getCell(20).getStringCellValue())
				.replace("parameter2", inSheet.getRow(3).getCell(21).getStringCellValue())
				.replace("parameter3", date1);
		System.out.println(QEREY2);
	int rowCount = 0;
		boolean versionFoundInDB = false;
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY1);
		Constants.resultset.next();
		rowCount = Constants.resultset.getInt(1);
		Constants.resultset = Constants.statement.executeQuery(QEREY2);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
						versionFoundInDB = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB == true) {
			Assert.assertTrue(versionFoundInDB, "Record is present in Database");
		}
		String languages1 = inSheet.getRow(4).getCell(7).getStringCellValue();
		System.out.println(languages1);
		String QUEREY3 = Constants.Input_SQLS.getRow(74).getCell(1).getStringCellValue();
		QUEREY3 = QUEREY3.replace("parameter1", inSheet.getRow(4).getCell(20).getStringCellValue())
				.replace("parameter2", inSheet.getRow(4).getCell(21).getStringCellValue())
				.replace("parameter3", date1);
		System.out.println(QEREY1);
		String QUEREY4 = Constants.Input_SQLS.getRow(75).getCell(1).getStringCellValue();
		QUEREY4 = QUEREY4.replace("parameter1", inSheet.getRow(4).getCell(20).getStringCellValue())
				.replace("parameter2", inSheet.getRow(4).getCell(21).getStringCellValue())
				.replace("parameter3", date1);
		System.out.println(QUEREY4);
	int rowCount1 = 0;
		boolean versionFoundInDB1 = false;
		Utils.connectToSqlserverDB();
		Constants.resultset1 = Constants.statement.executeQuery(QEREY1);
		Constants.resultset1.next();
		rowCount = Constants.resultset1.getInt(1);
		Constants.resultset1 = Constants.statement.executeQuery(QEREY2);
		Constants.resultsetMetadata1 = Constants.resultset.getMetaData();
		label: for (int i = 1; i <= rowCount; i++) {
			if (Constants.resultset1.next()) {
				for (int j = 1; j <= Constants.resultsetMetadata1.getColumnCount(); j++) {
					if (Constants.resultset1.getString(j).equalsIgnoreCase(languages)) {
						versionFoundInDB1 = true;
						break label;
					}
				}
			}
		}
		if (versionFoundInDB1 == true) {
			Assert.assertTrue(versionFoundInDB1, "Record is present in Database");
		}
	}
	public static void VerifyDeletedgroupsin_auditGroupEOBLanguageTypetable_indb() throws ClassNotFoundException, SQLException {
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
			String languages = inSheet.getRow(1).getCell(7).getStringCellValue();
			System.out.println(languages);
			String QEREY1 = Constants.Input_SQLS.getRow(62).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY1);
			String QEREY2 = Constants.Input_SQLS.getRow(63).getCell(1).getStringCellValue();
			QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY2);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY2);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} 
	public static void VerifyDeletedgroupsin_EOBPlanRuleExceptionLanguageTypetable_indb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String languages = inSheet.getRow(1).getCell(7).getStringCellValue();
			System.out.println(languages);
			String QEREY1 = Constants.Input_SQLS.getRow(50).getCell(1).getStringCellValue();
			QEREY1 = QEREY1.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY1);
			String QEREY2 = Constants.Input_SQLS.getRow(40).getCell(1).getStringCellValue();
			QEREY2 = QEREY2.replace("parameter1", inSheet.getRow(1).getCell(1).getStringCellValue())
					.replace("parameter2", inSheet.getRow(2).getCell(1).getStringCellValue())
					.replace("parameter3", date1);
			System.out.println(QEREY1);
		int rowCount = 0;
			boolean versionFoundInDB = false;
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY1);
			Constants.resultset.next();
			rowCount = Constants.resultset.getInt(1);
			Constants.resultset = Constants.statement.executeQuery(QEREY2);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			label: for (int i = 1; i <= rowCount; i++) {
				if (Constants.resultset.next()) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						if (Constants.resultset.getString(j).equalsIgnoreCase(languages)) {
							versionFoundInDB = true;
							break label;
						}
					}
				}
			}
			if (versionFoundInDB == true) {
				Assert.assertTrue(versionFoundInDB, "Record is present in Database");
			}
		} 
	
	public static void VerifyDeletedgroupsin_GroupEOBLanguageTypetableindb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void Verifyupdatedgroupsin_EOBPlanRuleExceptionlanguagetype() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(69).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter2", inSheet.getRow(17).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static void Verifyupdatedgroupsin_GroupEOBLanguageTypetableindb() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
		String QEREY = Constants.Input_SQLS.getRow(47).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(16).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(16).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(17).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
	}
	public static LinkedHashMap<String, String> IdentifyindividualgroupParametersinDB()
			throws SQLException, ClassNotFoundException {
		
		// try {
		String MasterGroupNumber = null;
		String GroupNumber = null;
		String EffectiveDate = null;
		String Groupid = null;
		String SiteName = null;
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(49).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(18).getStringCellValue()).replace("parameter2",
				inSheet.getRow(3).getCell(10).getStringCellValue()).replace("parameter3",
						inSheet.getRow(3).getCell(1).getStringCellValue());

		System.out.println(QEREY);

		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		while (Constants.resultset.next()) {
			individualgroupparameters_DB.put("MasterGroupNumber", Constants.resultset.getString("mastergroupnumber"));
			individualgroupparameters_DB.put("GroupNumber", Constants.resultset.getString("GroupNumber"));
			individualgroupparameters_DB.put("EffectiveDate", Constants.resultset.getString("Effectivedate").substring(0, 10));
			individualgroupparameters_DB.put("SiteName", Constants.resultset.getString("sitename"));
			individualgroupparameters_DB.put("IsEOB", inSheet.getRow(1).getCell(11).getStringCellValue());
			individualgroupparameters_DB.put("EOBIndicator", inSheet.getRow(1).getCell(6).getStringCellValue());
}
		System.out.println(individualgroupparameters_DB);
		return individualgroupparameters_DB;
	}
	public static void Verifrecordsaredeleted() throws ClassNotFoundException, SQLException {
	XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Employer_Group");
	String QEREY = Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue();
	QEREY = QEREY.replace("parameter1", inSheet.getRow(10).getCell(10).getStringCellValue())
			.replace("parameter2", inSheet.getRow(6).getCell(1).getStringCellValue())
			.replace("parameter3", inSheet.getRow(9).getCell(1).getStringCellValue());
	System.out.println(QEREY);
	Utils.connectToSqlserverDB();
	Constants.resultset = Constants.statement.executeQuery(QEREY);
	Constants.resultsetMetadata = Constants.resultset.getMetaData();
	Assert.assertTrue(!Constants.resultset.next());
	}
	public static void Verifrecordsaredeleted_samemastergroup() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Mastergroup");
		String QEREY = Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(2).getCell(1).getStringCellValue());
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
		}
	public static void Verifrecordsaredeleted_DB() throws ClassNotFoundException, SQLException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Individual_Groups");
		String QEREY = Constants.Input_SQLS.getRow(36).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", inSheet.getRow(3).getCell(10).getStringCellValue())
				.replace("parameter2", inSheet.getRow(3).getCell(1).getStringCellValue())
				.replace("parameter3", inSheet.getRow(4).getCell(1).getStringCellValue());
		System.out.println(QEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Assert.assertTrue(!Constants.resultset.next());
		}
	public static void compareSearchResultWithDBvalues()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {

		try {

			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx",
					"Individual_Groups");
			String QEREY = Constants.Input_SQLS.getRow(29).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", inSheet.getRow(1).getCell(10).getStringCellValue())
					.replace("parameter2", inSheet.getRow(1).getCell(1).getStringCellValue());
			String searchcount = EOBGroupException.verifysearchresultscount().getText();

			String searchuicount = searchcount.substring(0, 1);

			String SearchMasterGroupNumber_text = EOBGroupException.SearchMasterGroupNumber_text().getText();

			String SearchGroupNumber = EOBGroupException.SearchGroupNumber_text().getText();

			String SearchGroupName = EOBGroupException.SearchGroupName_text().getText();

			String SearchGroupEffectiveDate = EOBGroupException.SearchGroupEffectiveDate_text().getText();

			String SearchSiteName = EOBGroupException.SearchSiteName_text().getText();

			String SearchEOBIndicator = EOBGroupException.SearchEOBIndicator_text().getText();

			String SearchLanguages = EOBGroupException.SearchLanguages_text().getText();

			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
			List<String> languageFromDB = new ArrayList<String>();
			for (int k = 0; Constants.resultset.next(); k++) {

				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					if (k == 0)
						DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

				}
				languageFromDB.add(Constants.resultset.getString("name").trim());

			}

			Assert.assertEquals(DBvalues.get("MasterGroupNumber"), SearchMasterGroupNumber_text,
					"Failed as mastergroupnumber not matched with DB");
			Assert.assertEquals(DBvalues.get("GroupNumber"), SearchGroupNumber,
					"Failed as groupnumber not matched with DB");
			Assert.assertEquals(DBvalues.get("Name").trim(), SearchGroupName,
					"Failed as groupname not matched with DB");
			Assert.assertEquals(DBvalues.get("sitename"), SearchSiteName, "Failed as sitename not matched with DB");
			Assert.assertEquals(DBvalues.get("iseob"), SearchEOBIndicator, "Failed as iseob not matched with DB");
			Assert.assertEquals(DBvalues.get("EfectiveDate"), SearchGroupEffectiveDate,
					"Failed as groupname not matched with DB");

			/*List<String> languages = new ArrayList<String>();
			String lng[] = SearchLanguages.toString().split(",");
			int i = 0;
			for (String lngs : lng) {
				Assert.assertTrue(languageFromDB.get(i).toString().equals(lngs.trim()),
						"Failed as languages are matched with DB");
				i++;
			}*/

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}

	}
	
	
	
	public static void copyTable_intoExcel() throws SQLException, IOException, ClassNotFoundException {
		outputStream = new FileOutputStream("./src/test/java/testData/TC_EOB_GroupExceptions_DB.xlsx");
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");
		row = outSheet.createRow(0);
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBGroupExceptions.xlsx", "Sheet1");
		String QUEREY = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QUEREY = QUEREY.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QUEREY);
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QUEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		for (int i = 0; i < Constants.resultsetMetadata.getColumnCount(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Constants.resultsetMetadata.getColumnName(i + 1));
		}
		Assert.assertTrue(Constants.resultset.next());
		for (int i = 1; i <= Constants.resultset.getRow(); i++) {
			for (int j = 0; j < Constants.resultsetMetadata.getColumnCount(); j++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(Constants.resultset.getString(j + 1));
			}
		}

		String QUEREY1 = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QUEREY1 = QUEREY1.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QUEREY1);
		Constants.resultset1 = Constants.statement.executeQuery(QUEREY1);
		outSheet = outWorkbook.createSheet("testSheet2");
		for (int i = 0; i < Constants.resultsetMetadata1.getColumnCount(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Constants.resultsetMetadata1.getColumnName(i + 1));
		}
		System.out.println(Constants.resultset1.getRow());
		for (int i = 1; i <= Constants.resultset1.getRow(); i++) {
			for (int j = 0; j < Constants.resultsetMetadata1.getColumnCount(); j++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(Constants.resultset1.getString(j + 1));
			}
		}
		String QUEREY2 = Constants.Input_SQLS.getRow(14).getCell(1).getStringCellValue();
		QUEREY2 = QUEREY2.replace("parameter1", inSheet.getRow(2).getCell(1).getStringCellValue());
		System.out.println(QUEREY2);
		Constants.resultset2 = Constants.statement.executeQuery(QUEREY2);
		outSheet = outWorkbook.createSheet("testSheet3");
		for (int i = 0; i < Constants.resultsetMetadata2.getColumnCount(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Constants.resultsetMetadata2.getColumnName(i + 1));
		}
		System.out.println(Constants.resultset2.getRow());
		for (int i = 1; i <= Constants.resultset2.getRow(); i++) {
			for (int j = 0; j < Constants.resultsetMetadata2.getColumnCount(); j++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(Constants.resultset2.getString(j + 1));
			}
		}

		outWorkbook.write(outputStream);

		outWorkbook.close();
	}
}
