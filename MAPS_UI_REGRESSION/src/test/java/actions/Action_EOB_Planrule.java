package actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.EOBGroupException;
import pageObjects.EOBPlanRule;
import pageObjects.Header;
import utilities.Constants;
import utilities.Utils;

public class Action_EOB_Planrule extends BaseClass {

	public Action_EOB_Planrule(WebDriver driver) {
		super(driver);
	}
	public static LinkedHashMap<String, String> UIvalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
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

	public static void clickOnCreateEobPlanRule() {
		try {
			Utils.click(EOBPlanRule.CreateNewEOBplanRule());
			Constants.test.log(Status.PASS, "click on CreateNewEOBplanRule link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "CreateNewEOBplanRule");
			Assert.fail("failed to click on CreateNewEOBplanRule");
		}

	}


public static void clickOndeleteplanrule() {
	try {
		//Utils.click(EOBPlanRule.deleteplanrule());
		EOBPlanRule.deleteplanrule().click();
		
		
		System.out.println("After Click");
		Constants.test.log(Status.PASS, "click on deleteplanrule link");
	} 
	catch (Exception e) {
		Constants.test.log(Status.FAIL, "deleteplanrule");
		Assert.fail("failed to click on deleteplanrule");}
	
	}

	public static void verify_planyear() {
		try {
			Assert.assertTrue(EOBPlanRule.verify_planyear_parameter().getText().trim().equalsIgnoreCase("Plan Year"));
			// Assert.assertTrue(EOBPlanRule.verify_planyear_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for Plan Year");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Plan Year");
			Assert.fail("failed to check message displayed for Plan Year");
		}
	}

	public static void verify_Category() {
		try {
			Assert.assertTrue(EOBPlanRule.verify_Category_parameter().getText().trim().equalsIgnoreCase("Category"));
			Constants.test.log(Status.PASS, "check message displayed for Category");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Category");
			Assert.fail("failed to check message displayed for Category");
		}
	}

	//// h2[contains(text(),'Create New EOB Plan Rule')]
	public static void verify_PBP() {
		try {
			Assert.assertTrue(EOBPlanRule.verify_PBP_parameter().getText().trim().equalsIgnoreCase("PBP"));
			// Assert.assertTrue(EOBPlanRule.verify_PBP_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for PBP");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for PBP");
			Assert.fail("failed to check message displayed for PBP");
		}
	}

	public static void verify_DrugCoverageType() {
		try {
			System.out.println(EOBPlanRule.verify_DrugCoverageType_parameter().getText());
			Assert.assertTrue(EOBPlanRule.verify_DrugCoverageType_parameter().getText().trim()
					.equalsIgnoreCase("Drug Coverage Type"));
			// Assert.assertTrue(EOBPlanRule.verify_DrugCoverageType_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for Drug Coverage Type");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Drug Coverage Type");
			Assert.fail("failed to check message displayed for Drug Coverage Type");
		}
	}

	public static void verify_SNPType() {
		try {

			Assert.assertTrue(EOBPlanRule.verify_SNPType_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for Drug Coverage Type");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Drug Coverage Type");
			Assert.fail("failed to check message displayed for Drug Coverage Type");
		}
	}

	public static void verify_ClaimsSystem() {
		
			System.out.println(EOBPlanRule.verify_ClaimsSystem_parameter().getText());
			boolean verification=EOBPlanRule.verify_ClaimsSystem_parameter().getText().trim().equalsIgnoreCase("Claims System");
			System.out.println(verification);
			Assert.assertTrue(verification);
			

	}

	public static void verify_BusinessSegment() {

		System.out.println(EOBPlanRule.verify_BusinessSegment_parameter().getText());
		Assert.assertTrue(
				EOBPlanRule.verify_BusinessSegment_parameter().getText().trim().equalsIgnoreCase("Business Segment"));
		// Assert.assertTrue(EOBPlanRule.verify_BusinessSegment_parameter().isDisplayed());

	}

	public static void verify_EOBPlanRuleList() {
		try {

			Assert.assertTrue(EOBPlanRule.verify_Contract_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for EOBPlanRuleList");
			System.out.println(EOBPlanRule.verify_ClaimsSystem_parameter().getText());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for EOBPlanRuleList");
			Assert.fail("failed to check message displayed for EOBPlanRuleList");
		}

	}

	public static void verify_Contract() {
		try {
			System.out.println(EOBPlanRule.verify_Contract_parameter().getText());
			Assert.assertTrue(EOBPlanRule.verify_Contract_parameter().getText().trim().equalsIgnoreCase("Contract"));
			// Assert.assertTrue(EOBPlanRule.verify_Contract_parameter().isDisplayed());
			Constants.test.log(Status.PASS, "check message displayed for Contract");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for Contract");
			Assert.fail("failed to check message displayed for Contract");
		}

	}

	public static void verify_CategoryDropdown() {
		try {

			List<WebElement> options = EOBPlanRule.categorydropdown().getOptions();
			System.out.println(options);
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check error message for  displayed for category");
			Assert.fail("failed to check message displayed for category");
		}
	}

	/*
	 * public static void selectPlanYear_dropdown(String option) {
	 * 
	 * EOBPlanRule.planyear().selectByVisibleText(option);
	 * 
	 * }
	 */
	public static void waitForPageToLoad(WebDriver driver) {
		try {
			for (int i = 0; i <= i; i++) {
				if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
					break;
				}
			}
		} catch (JavascriptException e) {
		}
	}

	public static void selectPlanYear_dropdown(String option) {

		if (option.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
			Constants.test.log(Status.PASS, "select status");
		} else {
			System.out.println("enter");
			EOBPlanRule.planyear().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select status");
		}

	}

	public static void selectcategory_dropdown(String option) {

		if (option.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
			Constants.test.log(Status.PASS, "select status");
		} else {
			System.out.println("enter");
			EOBPlanRule.Category().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select status");
		}

	}

	public static void selectcontract_dropdown(String option) {

		if (option.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
			Constants.test.log(Status.PASS, "select status");
		} else {
			System.out.println("enter");
			EOBPlanRule.Contractdropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select status");
		}

	}

	public static void selectPBP_dropdown(String option) {

		if (option.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
			Constants.test.log(Status.PASS, "select status");
		} else {
			System.out.println("enter");
			EOBPlanRule.SelectPBP_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select status");
		}

	}

	public static void clickOn_Search() {
		try {
			// Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOf(driver.findElement(By.xpath("//div[@class='eob-ajax-loading']"))));
			// Utils.click(EOBPlanRule.clickonSearch());
			EOBPlanRule.searchPlans_button().click();
			Thread.sleep(4000);
			Constants.test.log(Status.PASS, "click on cancel link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on cancel link");
			Assert.fail("failed to on cancel Link");
		}

	}
	public static void clickOnSearch() {
		try {
			// Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOf(driver.findElement(By.xpath("//div[@class='eob-ajax-loading']"))));
			// Utils.click(EOBPlanRule.clickonSearch());
			EOBPlanRule.clickonSearch().click();
			Thread.sleep(4000);
			Constants.test.log(Status.PASS, "click on cancel link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on cancel link");
			Assert.fail("failed to on cancel Link");
		}

	}
	public static void select_RussianCheckbox() {
		try {
			Utils.click(EOBPlanRule.Russian_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Russian checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Russian checkbox for EOB Language");
			Assert.fail("failed to select Russian checkbox for EOB Language");
		}

	}

	public static void select_VietnameseCheckbox() {
		try {
			Utils.click(EOBPlanRule.Vietnamese_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Vietnamese checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Vietnamese checkbox for EOB Language");
			Assert.fail("failed to select Vietnamese checkbox for EOB Language");
		}

	}

	public static void select_SpanishCheckbox() {
		try {
			Utils.click(EOBPlanRule.Spanish_Language_chkbox());
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

	public static void selectEmployergroup_Checkbox() {
		try {

			Utils.click(EOBPlanRule.SelectEmployerGrouprecord());
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	public static void selectPlan_Checkbox() {
		try {

			Utils.click(EOBPlanRule.Select_plan_chkbox());
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	//// select[@id='IsEOB']

	public static void selectEOBIndicator_dropdown(String option) {

		if (option.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('Status').selectedIndex=0;");
			Constants.test.log(Status.PASS, "select status");
		} else {
			System.out.println("enter");
			EOBPlanRule.EOBdropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select status");
		}
	}

	public static void select_DeleteRequiredrecord_Checkbox(String Contractnumber) {
		try {

			Utils.click(EOBGroupException.SelectindividualGrouprecord(Contractnumber));
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}

	public static void clickOnSave() {

		// Utils.click(EOBPlanRule.clickonSave());
		EOBPlanRule.clickonSave().click();

	}

	public static void alert() {
		Alert alert = driver.switchTo().alert();
		Assert.assertTrue(alert.getText().equalsIgnoreCase("You must select at least one plan to create a rule."));
		Constants.test.log(Status.PASS, "click on Save");
	}
	public static void alertaccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Constants.test.log(Status.PASS, "click on Save");
	}

public static void alertdismiss() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
	Constants.test.log(Status.PASS, "click on Save");
}


	public static void select_mutipleplans_Checkbox(String Contractnumber, String pbp) {
		try {
     System.out.println("//td[text()='"+Contractnumber+"']/following-sibling::td[text()='"+pbp+"']/parent::tr/td[1]/input");
			// Utils.click(EOBPlanRule.Selectaleternateplan(Contractnumber,pbp));
			EOBPlanRule.Selectaleternateplan(Contractnumber, pbp).click();
			Constants.test.log(Status.PASS, "Checkbox was selected");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Checkbox was selected");
			Assert.fail("failed to select  checkbox ");
		}

	}
	
	
	public static LinkedHashMap<String, String> verifyUiresults_cancel()
			throws SQLException, ClassNotFoundException {
			
				UIvalues.put("planyear",EOBPlanRule.VerifyPlanYear().getText());
				UIvalues.put("Category",EOBPlanRule.VerifyCategory().getText());
				UIvalues.put("contract",EOBPlanRule.VerifyContract().getText());
				UIvalues.put("PBP",EOBPlanRule.VerifyPBP().getText());
				UIvalues.put("DrugCoverageType",EOBPlanRule.verifyDrugCoverageType().getText());
				UIvalues.put("ClaimsSystem",EOBPlanRule.verifyclaimssystem().getText());
				UIvalues.put("BusinessSegment",EOBPlanRule.verifyBusinessSegment().getText());
				UIvalues.put("EOBIndicator",EOBPlanRule.verifyEOBIndicator().getText());
				UIvalues.put("Languages",EOBPlanRule.verifyLanguages().getText());
			
			System.out.println(UIvalues);
			return UIvalues;
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
	

	public static void compareSearchResultWithDBvalues()
            throws ClassNotFoundException, SQLException, IOException, InterruptedException {

 

            XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/EOBExceptions.xlsx",
                         "Sheet1");
            String QEREY = Constants.Input_SQLS.getRow(22).getCell(1).getStringCellValue();
            System.out.println(QEREY);
            String planyear = EOBPlanRule.VerifyPlanYear().getText();
            System.out.println(planyear);
            String SearchPBP = EOBPlanRule.VerifyPBP().getText();
            System.out.println(SearchPBP);
            String SearchDrugCoverageType = EOBPlanRule.verifyDrugCoverageType().getText();
            System.out.println(SearchDrugCoverageType);
            String SearchClaimsSystem = EOBPlanRule.verifyclaimssystem().getText();
            System.out.println(SearchClaimsSystem);
            String SearchCategory_text = EOBPlanRule.VerifyCategory().getText();
            System.out.println(SearchCategory_text);
            String SearchContract = EOBPlanRule.VerifyContract().getText();
            System.out.println(SearchContract);
            String SearchBusinessSegment = EOBPlanRule.verifyBusinessSegment().getText();
            //System.out.println(SearchBushttp://adr2.uhc.com/apps/MAPS/20170908_MAPS_CHG0098012/Design/Forms/AllItems.aspxinessSegment);
            String SearchEOBIndicator = EOBPlanRule.verifyEOBIndicator().getText();
            System.out.println(SearchEOBIndicator);
            String SearchLanguages = EOBPlanRule.verifyLanguages().getText();
            System.out.println(SearchLanguages);
            System.out.println(inSheet.getRow(2).getCell(1).getStringCellValue());
            String category =inSheet.getRow(6).getCell(1).getStringCellValue();
            Utils.connectToSqlserverDB();
            Constants.resultset = Constants.statement.executeQuery(QEREY);
            Constants.resultsetMetadata = Constants.resultset.getMetaData();
            LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
            for (int k = 0; Constants.resultset.next(); k++) {

                   for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
                                 DBvalues.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));

                   }
            }
            System.out.println(DBvalues);

       Assert.assertEquals(DBvalues.get("Plan Year"), planyear,
                         "Failed as planyear not matched with DB");
            Assert.assertEquals(DBvalues.get("ContractNumber"), SearchContract,
                         "Failed as ContractNumber not matched with DB");
            Assert.assertEquals(DBvalues.get("PBPNumber"), SearchPBP,
                         "Failed as PBPNumber not matched with DB");
            Assert.assertEquals(DBvalues.get("DrugCoverageType"), SearchDrugCoverageType, "Failed as DrugCoverageType not matched with DB");
      
            System.out.println(DBvalues.get("SNPTypeID"));
            System.out.println(EOBPlanRule.verifySNPTypeType().getText().isEmpty());
        	  Assert.assertTrue((EOBPlanRule.verifySNPTypeType().getText().isEmpty())&& DBvalues.get("SNPTypeID")==null);
       

            Assert.assertEquals(DBvalues.get("claimsystem"), SearchClaimsSystem,
                         "Failed as claimsystem not matched with DB");
     
            System.out.println(DBvalues.get("bussinesssegment"));
            System.out.println(SearchClaimsSystem);
            Assert.assertEquals(DBvalues.get("bussinesssegment").trim(), SearchBusinessSegment,
                    "Failed as SearchBusinessSegment not matched with DB");
            Assert.assertEquals(DBvalues.get("iseob"), SearchEOBIndicator,
                    "Failed as SearchEOBIndicator not matched with DB");
            System.out.println(category);
            System.out.println(SearchCategory_text);
            Assert.assertTrue(category.equalsIgnoreCase(SearchCategory_text), "Failed as SearchCategory not matched with DB");
           Assert.assertEquals(DBvalues.get("language"), SearchLanguages,
                    "Failed as SearchLanguages not matched with DB");
    
     } 



	public static boolean Verfiyingindividualgroup_DB() throws ClassNotFoundException, SQLException {
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
}
