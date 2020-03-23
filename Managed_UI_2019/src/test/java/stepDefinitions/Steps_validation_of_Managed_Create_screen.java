package stepDefinitions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.Managed_UI_Pageobjects;
//import pageObjects.Managed_UI_Pageobjectss;
//import pageObjects.VersionControl_pageOjects;
import utilities.Constants;
import utilities.Utils;

public class Steps_validation_of_Managed_Create_screen {
	static WebDriver driver;

	public Steps_validation_of_Managed_Create_screen() {
		this.driver = Hooks.driver;
	}

	static String Contract_PBP_Year_managedscreen;
	static String Market_product_Name_createscreen;
	static String contract;
	static String pbp;
	static String year;
	static String marketproductname;
	static String producttype;
	static String drugcoveragetype;
	static String bussinessSegment;
	static String enrolletype;
	static String snpflag;
	static String snptype;
	public static int numRec = 0;
	String GlobalPlanType="";
	String GlobalPlanName="";
	String GlobalContractNumber="";
	String GlobalPBPNumber="";
	String GlobalYear="";
	String GlobalState="";
	int countyCount=0;
	String[] arrayDetails;
	public static LinkedHashMap<String, String> employer_groupparameters_DB = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Manageduivalues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> Dbvalues = new LinkedHashMap<String, String>();
	String GlobalProductType="";
	static String Contract_PBP_Year_createscreen;
	static String Market_product_Name_managedscreen;
	public static ArrayList<String> searchresults = new ArrayList<String>();
	public static ArrayList<String> updatedresults = new ArrayList<String>();
	public static LinkedHashMap<String, String> individual_groups_inDBvalues = new LinkedHashMap<String, String>();
	ArrayList<String> arrList2=new ArrayList<String>();
	ArrayList<String> arrList3=new ArrayList<String>();
	ArrayList<String> DBResultDBOTable=new ArrayList<String>();
	ArrayList<String> DBResultStageTableUI=new ArrayList<String>();
	ArrayList<String> DBResultStageTableDB=new ArrayList<String>();
	ArrayList<String> DBResultStageTableTemp=new ArrayList<String>();

	@Then("^Verify that Plan Name textfield data is same as the previous screen selected data\\.$")
	public void verify_that_Plan_Name_textfield_data_is_same_as_the_previous_screen_selected_data() throws Throwable {
		try {
			Market_product_Name_managedscreen = Managed_UI_Pageobjects.Marketproductname_textfield(driver)
					.getAttribute("value");
			Assert.assertTrue(Market_product_Name_createscreen.equalsIgnoreCase(Market_product_Name_managedscreen),
					"verify_that_Plan_Name_textfield_data");

		} catch (Exception e) {
			Assert.fail("Failed to verify the contract/PBP/Year data");
		}
	}


	@When("^Store field \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"values values to compare the data with next screen and database\\.$")
	public void store_field_and_and_and_and_and_and_and_and_and_values_values_to_compare_the_data_with_next_screen_and_database(
			String Year, String Contract, String Pbp, String Marketproductname, String Producttype,
			String BussinessSegment, String Snpflag, String Snptype, String Drugcoveragetype, String Enrolletype)
			throws Throwable {

		Contract_PBP_Year_createscreen = Contract + " - " + Pbp + " - " + Year;
		Market_product_Name_createscreen = Marketproductname;
		Manageduivalues.put("year", Year);
		Manageduivalues.put("contractnumber", Contract);
		Manageduivalues.put("pbpnumber", Pbp);
		Manageduivalues.put("marketProductName", Marketproductname);
		Manageduivalues.put("productType", Producttype);
		Manageduivalues.put("businessSegment", BussinessSegment);
		Manageduivalues.put("enrolleeType", Enrolletype);
		Manageduivalues.put("snpflag", Snpflag);
		Manageduivalues.put("snptype", Snptype);
		Manageduivalues.put("drugCoverageType", Drugcoveragetype);

	}


	@Then("^Verify the Manged area is displayed\\.$")
	public void verify_the_Manged_area_is_displayed() throws Throwable {
		try {
			Thread.sleep(5000);
			Assert.assertTrue(Managed_UI_Pageobjects.verify_Managed_area_screen(driver).isDisplayed(),
					"verify_the_Manged_area_screen");

		} catch (Exception e) {
			Assert.fail("Failed to verify on Managed area screen");
		}
	}

	@Then("^Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data\\.$")
	public void verify_that_Contract_PBP_Year_textfield_plan_data_is_same_as_the_previous_screen_selected_plan_data()
			throws Throwable {
		try {
			Thread.sleep(6000);
			Contract_PBP_Year_managedscreen = Managed_UI_Pageobjects.verify_Contract_PBP_Year_text(driver).getAttribute("value");

			Assert.assertTrue(Contract_PBP_Year_createscreen.equalsIgnoreCase(Contract_PBP_Year_managedscreen),"verify_that_Contract_PBP_Year_textfield_plan_data");
			Utils.waitForPageToLoad(driver);
		} catch (Exception e) {
			Assert.fail("Failed to verify the contract/PBP/Year data");
		}
	}
	

	@When("^click on Add state\\.$")
	public void click_on_Add_state() throws Throwable {
		try {
			 Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
			addStateButton.click();
			Thread.sleep(3000);
//			wait.until(ExpectedConditions.elementToBeClickable(Managed_UI_Pageobjects.Add_state_click(driver)));
//			Utils.click(driver, Managed_UI_Pageobjects.Add_state_click(driver));
			// Managed_UI_Pageobjects.Add_state_click(driver).click();

		} catch (Exception e) {
			Assert.fail("Failed to click on Managed Plan setup link");

		}
	}

	@Then("^check state and county dropdowns are displayed\\.$")
	public void check_state_and_county_dropdowns_are_displayed() throws Throwable {
		try {
			Assert.assertTrue(Managed_UI_Pageobjects.Verify_Select_state_dropdown(driver).isDisplayed()
					&& Managed_UI_Pageobjects.Verify_Select_state_dropdown(driver).isEnabled());
			Assert.assertTrue(Managed_UI_Pageobjects.Verify_county_dropdown(driver).isDisplayed()
					&& Managed_UI_Pageobjects.Verify_county_dropdown(driver).isEnabled());
		} catch (Exception e) {

		}
	}

	@When("^provide value to state \"([^\"]*)\" dropdown$")
	public void provide_value_to_state_dropdown(String State) throws Throwable {
		try {

			Managed_UI_Pageobjects.select_state_dropdown(driver).selectByVisibleText(State);
			Thread.sleep(3000);

		} catch (Exception e) {
			Assert.fail("Failed to select the Snpflag");
		}
	}

	@Then("^compare UI and DB values$")
	public void compare_UI_and_DB_values() throws Throwable {
try {
		String year = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[2]")).getText()
				.split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[0].trim();
		String contractnumber = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[2]"))
				.getText().split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[1]
						.trim();
		String pbpnumber = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[2]"))
				.getText().split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[2]
						.trim();
		String yearcontractpbp=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[2]")).getText()
				.split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].trim();
		
	
		String marketproductname = driver
				.findElement(By.xpath("//tr[1]/td[contains(.,'Year/Contract/PBP')]")).getText()
				.split("Market Product Name:")[1].trim();
		String producttype=driver.findElement(By.xpath("//tr[1]/td[contains(.,'Year/Contract/PBP')]")).getText().split("Year/Contract/PBP:")[0].split("Product Type:")[1].trim();
	
		String bussinesssegment=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[3]")).getText();
		String statecode=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[4]")).getText();
		String cmscountycode=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[5]")).getText();
		String drugcoveragetype=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[6]")).getText();
		String enrolletype=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[7]")).getText();
		String snpflag=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[8]")).getText();
		String snptype=driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[9]")).getText();
		Utils.connectToSqlserverDB();

		String QUERY = Constants.Input_SQLS.getRow(11).getCell(1).getStringCellValue();
		QUERY = QUERY.replace("parameter1", year).replace("parameter2", contractnumber)
				.replace("parameter3", pbpnumber);
		String Query1=Constants.Input_SQLS.getRow(10).getCell(1).getStringCellValue();
		Query1= Query1.replace("parameter1", year).replace("parameter2", contractnumber)
				.replace("parameter3", pbpnumber);
	
		Constants.resultset = Constants.statement.executeQuery(QUERY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		Constants.resultset.next();
		String dbProductType = Constants.resultset.getString("ProductType");
		String dbYearContractPBP = Constants.resultset.getString("YearContractPBP");
		String dbmarketproductname = Constants.resultset.getString("marketproductname");
		String dbBusinessSegment = Constants.resultset.getString("BusinessSegment");
		String dbStateAbbr = Constants.resultset.getString("StateAbbr");
		String dbCMSCountyCode = Constants.resultset.getString("CMSCountyCode");
		String dbDrugCoverageType = Constants.resultset.getString("DrugCoverageType");
		String dbEnrolleeType = Constants.resultset.getString("EnrolleeType");
		String dbSNPFlag = Constants.resultset.getString("SNPFlag");
		String dbSnptype = Constants.resultset.getString("Snptype");
		Constants.resultset1 = Constants.statement.executeQuery(Query1);

		Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
		Constants.resultset1.next();
		String Dbomarketproductname = Constants.resultset1.getString("PlanName");
		
		String Dbobussinesssegment = Constants.resultset1.getString("bussinesssegment");
		String Dbosnptype = Constants.resultset1.getString("SNPType");
		String Dbosnpflag = Constants.resultset1.getString("snpflag");
	
		Assert.assertTrue(yearcontractpbp.equalsIgnoreCase(dbYearContractPBP));
		Assert.assertTrue(marketproductname.equalsIgnoreCase(dbmarketproductname));
		Assert.assertTrue(Dbomarketproductname.equals(marketproductname));
		Assert.assertTrue(statecode.equalsIgnoreCase(dbStateAbbr));
		Assert.assertTrue(cmscountycode.equalsIgnoreCase(dbCMSCountyCode));
		if(bussinesssegment.equalsIgnoreCase("Medica")){
			Assert.assertTrue(bussinesssegment.equalsIgnoreCase(dbBusinessSegment));
			Assert.assertTrue(enrolletype.equals(dbEnrolleeType));
			Assert.assertTrue(Dbobussinesssegment.equalsIgnoreCase(bussinesssegment));	
			
		}
		else {
			Assert.assertTrue(bussinesssegment.equalsIgnoreCase(dbBusinessSegment));
			Assert.assertTrue(enrolletype.isEmpty()&& dbEnrolleeType==null);
			Assert.assertTrue(Dbobussinesssegment.equalsIgnoreCase(bussinesssegment));	
		
		}
	
	    if (snpflag.equalsIgnoreCase("Y")){
			Assert.assertTrue(snpflag.equalsIgnoreCase(dbSNPFlag));
			Assert.assertTrue(snptype.equalsIgnoreCase(dbSnptype));
			Assert.assertTrue( Dbosnpflag.equalsIgnoreCase(snpflag));
		
		}
	    else {
	    	Assert.assertTrue(snpflag.equalsIgnoreCase(dbSNPFlag));
	    	Assert.assertTrue(snptype.isEmpty()&& dbSnptype==null);
			Assert.assertTrue( Dbosnpflag.equalsIgnoreCase(snpflag));
			
	    }
	    if(producttype.equalsIgnoreCase("Medicaid")||producttype.equalsIgnoreCase("Dental")||producttype.equalsIgnoreCase("Select Solutions")) {
	    	Assert.assertTrue(producttype.equalsIgnoreCase(dbProductType));
	    	Assert.assertTrue(drugcoveragetype.isEmpty()&& dbDrugCoverageType==null);
	
	    	
	    }
	    else {
	    	Assert.assertTrue(producttype.equalsIgnoreCase(dbProductType));
	    	Assert.assertTrue(drugcoveragetype.equalsIgnoreCase(dbDrugCoverageType));
	    	
	    }
}
catch(Exception e) {
	Assert.fail("Failed to verify UI values with DB values");
}
	}
	
	
	@When("^Verify that the following fields are there on create new managed plan screen\\.$")
	public void verify_that_the_following_fields_are_there_on_create_new_managed_plan_screen(DataTable fields)
			throws Throwable {
		List<String> list = fields.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			driver.getPageSource().contains(list.get(i));
			System.out.println("verified");
		}

	}


	@When("^Verify that Plan year drop down contains the following values \\.$")
	public void verify_that_Plan_year_drop_down_contains_the_following_values(DataTable Year) throws Throwable {
		try {

			List<String> list = Year.asList(String.class);
			List<WebElement> yeardropdownvalues = Managed_UI_Pageobjects.select_planyear_dropdown(driver).getOptions();
			for (int i = 0; i < yeardropdownvalues.size(); i++) {
				Assert.assertTrue(yeardropdownvalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify Year dropdown values");
		}

	}

	@When("^Verify that producttype dropdown contains following values it is should be in the format of PlanTypeID - Name$")
	public void verify_that_producttype_dropdown_contains_following_values_it_is_should_be_in_the_format_of_PlanTypeID_Name(
			DataTable producttype) throws Throwable {
		try {

			List<String> list = producttype.asList(String.class);
			List<WebElement> producttypevalues = Managed_UI_Pageobjects.select_producttype_dropdown(driver)
					.getOptions();
			for (int i = 0; i < producttypevalues.size(); i++) {
				Assert.assertTrue(producttypevalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify producttype dropdown values");
		}

	}

	@When("^Verify the Enrollee Type contains the following values\\.$")
	public void verify_the_Enrollee_Type_contains_the_following_values(DataTable EnrolleeType) throws Throwable {
		try {

			List<String> list = EnrolleeType.asList(String.class);
			List<WebElement> Enrolletypevalues = Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver)
					.getOptions();
			for (int i = 0; i < Enrolletypevalues.size(); i++) {
				Assert.assertTrue(Enrolletypevalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify Enrolleetype dropdown values");
		}

	}

	@When("^Verify that Contract and Pbp and Market product name fields are textfields\\.$")
	public void verify_that_Contract_and_Pbp_and_Market_product_name_fields_are_textfields() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertTrue(Managed_UI_Pageobjects.contractnumber_textfield(driver).isDisplayed()
					&& Managed_UI_Pageobjects.contractnumber_textfield(driver).isEnabled());
			Assert.assertTrue(Managed_UI_Pageobjects.pbpnumber_textfield(driver).isDisplayed()
					&& Managed_UI_Pageobjects.pbpnumber_textfield(driver).isEnabled());
			Assert.assertTrue(Managed_UI_Pageobjects.Marketproductname_textfield(driver).isDisplayed()
					&& Managed_UI_Pageobjects.Marketproductname_textfield(driver).isEnabled());
		} catch (Exception e) {
			Assert.fail("Failed to verify the textfields");
		}

	}

	@When("^Verify that Business Segment dropdown contains the following values\\.$")
	public void verify_that_Business_Segment_dropdown_contains_the_following_values(DataTable BusinessSegment)
			throws Throwable {
		try {

			List<String> list = BusinessSegment.asList(String.class);
			List<WebElement> businesssegmentvalues = Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
					.getOptions();
			for (int i = 0; i < businesssegmentvalues.size(); i++) {
				Assert.assertTrue(businesssegmentvalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify  BusinessSegment dropdown values");
		}
	}

	@When("^Verify that SNP Flag dropdown contains the following values\\.$")
	public void verify_that_SNP_Flag_dropdown_contains_the_following_values(DataTable SNPflag) throws Throwable {
		try {

			List<String> list = SNPflag.asList(String.class);
			List<WebElement> SNPvalues = Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).getOptions();
			for (int i = 0; i < SNPvalues.size(); i++) {
				Assert.assertTrue(SNPvalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify SNP Flag dropdown values");
		}
	}

	@When("^Veridy that SNP Type contains the following values\\.$")
	public void veridy_that_SNP_Type_contains_the_following_values(DataTable SNPType) throws Throwable {
		try {
			List<String> list = SNPType.asList(String.class);

			List<WebElement> SNPTypevalues = Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).getOptions();
			for (int i = 0; i < SNPTypevalues.size(); i++) {

				Assert.assertTrue(SNPTypevalues.get(i).getText().equalsIgnoreCase(list.get(i)));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify dropdown values");
		}
	}

	@When("^Verify the Drug Coverage Type contains the following values\\.$")
	public void verify_the_Drug_Coverage_Type_contains_the_following_values(DataTable DrugCoverageType)
			throws Throwable {
		try {

			List<String> list = DrugCoverageType.asList(String.class);

			List<WebElement> DrugCoverageTypevalues = Managed_UI_Pageobjects.select_Drugcoveragetype_dropdown(driver)
					.getOptions();
			for (int i = 0; i < DrugCoverageTypevalues.size(); i++) {
				Assert.assertTrue(DrugCoverageTypevalues.get(i).getText().equalsIgnoreCase(list.get(i)));

			}
		} catch (Exception e) {
			Assert.fail("Failed to verify dropdown values");
		}
	}

	@When("^click on county textfield$")
	public void click_on_county_textfield() throws Throwable {
		try {

			Thread.sleep(4000);
			Utils.click(driver, Managed_UI_Pageobjects.click_county_dropdown(driver));
			Thread.sleep(4000);

			Utils.click(driver, Managed_UI_Pageobjects.select_checkbox_selectall(driver));
			Thread.sleep(5000);

		} catch (Exception e) {
			Assert.fail("Failed to select the Snpflag");
		}
	}

	@When("^Select Producttype \"([^\"]*)\" and Drug Coverage Type \"([^\"]*)\" from the dropdown$")
	public void select_Producttype_and_Drug_Coverage_Type_from_the_dropdown(String Producttype, String Drugcoveragetype)
			throws Throwable {

		if (!Producttype.equals("30 - Medicaid") && !Producttype.equals("31 - Dental")
				&& !Producttype.equals("32 - Select Solutions")) {

			if (Producttype.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ProductType').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_producttype_dropdown(driver).selectByVisibleText(Producttype);
			}

			if (Drugcoveragetype.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('DrugCoverageType').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_Drugcoveragetype_dropdown(driver).selectByVisibleText(Drugcoveragetype);
			}

		}

		else if (Producttype.equals("30 - Medicaid") || Producttype.equals("31 - Dental")
				|| Producttype.equals("32 - Select Solutions")) {

			if (Producttype.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ProductType').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_producttype_dropdown(driver).selectByVisibleText(Producttype);
			}
			Assert.assertTrue(!Managed_UI_Pageobjects.verify_Drugcoveragetype_dropdown_isdisabled(driver).isEnabled(),
					"Enrolletype is verified");

		}
	}

	@When("^Select Bussiness Segment \"([^\"]*)\" and  Enrolle Type\"([^\"]*)\" from the dropdown$")
	public void select_Bussiness_Segment_and_Enrolle_Type_from_the_dropdown(String BussinessSegment, String Enrolletype)
			throws Throwable {

		if (BussinessSegment.equalsIgnoreCase("Medica")) {
			if (BussinessSegment.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('BusinessSegment').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver).selectByVisibleText(BussinessSegment);
			}
			if (Enrolletype.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('EnrolleeType').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(Enrolletype);
			}
		} else if (BussinessSegment.equalsIgnoreCase("Senior Supplement")) {

			if (BussinessSegment.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('BusinessSegment').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver).selectByVisibleText(BussinessSegment);
			}
			Assert.assertTrue(!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
					"Enrolletype is verified");

		}
	}

	@When("^Select SNP Flag \"([^\"]*)\" and SNP Type \"([^\"]*)\" from the dropdown$")
	public void select_SNP_Flag_and_SNP_Type_from_the_dropdown(String Snpflag, String Snptype) throws Throwable {

		if (Snpflag.equalsIgnoreCase("Y")) {
			if (Snpflag.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SNPFlag').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(Snpflag);
			}
			if (Snptype.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SNPType').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(Snptype);
			}
		} else if (Snpflag.equalsIgnoreCase("N")) {
			if (Snpflag.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SNPFlag').selectedIndex=0;");

			} else {
				Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(Snpflag);
			}
			Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
					"Enrolletype is verified");
		}
	}

	@When("^select \"([^\"]*)\" and click on create button\\.$")
	public void select_and_click_on_create_button(String counties) throws Throwable {

		String storecounties = "";
		int temp;
		storecounties = counties;
		String[] array = storecounties.split(",");
		temp = array.length;
		for (int j = 0; j < temp; j++) {
			Managed_UI_Pageobjects.select_checkbox(driver, array[j]).click();
			Thread.sleep(1000);

		}
		Managed_UI_Pageobjects.click_ongreybar(driver).click();

	}

	@When("^click on create button\\.$")
	public void click_on_create_button() throws Throwable {
		Thread.sleep(5000);
		Managed_UI_Pageobjects.create_button(driver).click();
	}

	@When("^Select producttype \"([^\"]*)\" from the dropdown$")
	public void select_producttype_from_the_dropdown(String ProductType) throws Throwable {
		try {
			GlobalProductType=ProductType;
			Managed_UI_Pageobjects.select_producttype_dropdown(driver).selectByVisibleText(ProductType);
		} catch (Exception e) {
			Assert.fail("Failed to select the year from the dropdown");
		}
	}

	@When("^Records will be displayed in search grid  and verify Mass Data Update button is displayed$")
	public void records_will_be_displayed_in_search_grid_and_verify_Mass_Data_Update_button_is_displayed()
			throws Throwable {
		Thread.sleep(5000);
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		try {

			if (tableRows.size() > 1) {
				Assert.assertTrue(tableRows.size() > 1, "data is displayed in search results");
			} else {
				Assert.fail("Failed as data is not displayed in search results");
			}
			Assert.assertTrue(Managed_UI_Pageobjects.mass_update_button(driver).isDisplayed(),
					"Verify_massupdate_button is displayed");

		} catch (Exception e) {
			Assert.fail("Failed to verify the data displayed in the search grid");
		}
	}

	@When("^select (\\d+)from the search results grid and click on Mass Data Update button and verify the \"([^\"]*)\"$")
	public void select_from_the_search_results_grid_and_click_on_Mass_Data_Update_button_and_verify_the(
			int NumberOfRecords, String message) throws Throwable {

		int selectedRow = 0;
		System.out.println(NumberOfRecords);
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		try {
			if (NumberOfRecords == 0) {

				System.out.println("no values will be selected");

			} else if (tableRows.size() < NumberOfRecords) {
				Assert.assertTrue(tableRows.size() < NumberOfRecords,
						"Table does not contains required number of records");
			} else {
				for (int i = 1; i <= tableRows.size(); i++) {
					WebElement checkboxObj = driver
							.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[1]/input"));
					List<WebElement> elements = Managed_UI_Pageobjects.verify_search_results(driver, i);
					for (WebElement ele : elements) {
						searchresults.add(ele.getText());
					}

					checkboxObj.click();
					selectedRow++;
					if (selectedRow == NumberOfRecords) {
						break;
					}

				}
			}
			Managed_UI_Pageobjects.mass_update_button(driver).click();

			if (NumberOfRecords == 0) {
				System.out.println("print");
				Alert al = driver.switchTo().alert();
				System.out.println(al.getText());
				Assert.assertTrue(al.getText().equals(message), "Alert message is displayed");
				al.accept();

			} else {
				Assert.assertTrue(Managed_UI_Pageobjects.mass_update_screen(driver).getText().equalsIgnoreCase(message),
						message);
				tableRows = driver.findElements(
						By.xpath("//table[@class='table table-striped table-condensed table-bordered']/tbody/tr"));

				for (int j = 1; j <= tableRows.size(); j++) {
					List<WebElement> elements1 = Managed_UI_Pageobjects.verify_updated_results(driver, j);
					for (WebElement ele : elements1) {
						updatedresults.add(ele.getText());
					}
				}
				Assert.assertTrue(searchresults.equals(updatedresults));
			}

		} catch (Exception e) {
			Assert.fail("Failed to select records from the table");
		}
	}

	@When("^uncheck the checkbox and provide the data for the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void uncheck_the_checkbox_and_provide_the_data_for_the_and_and_and_and_and(String Fields,
			String MarketProductName, String BusinessSegment, String SNPFlag, String SNPType, String EnrolleeType)
			throws Throwable {
		try {

			if (Fields.equalsIgnoreCase("ALL")) {
				Managed_UI_Pageobjects.uncheck_marketproductname_checkbox(driver).click();
				Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys(MarketProductName);

				if (BusinessSegment.equalsIgnoreCase("Medica")) {
					Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);

					Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(EnrolleeType);
				} else if (BusinessSegment.equalsIgnoreCase("Senior Supplement")) {
					Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Assert.assertTrue(
							!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the enrolle type dropdown is in disable");

				}
				if (SNPFlag.equalsIgnoreCase("Y")) {
					Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);

					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(SNPType);
				} else if (SNPFlag.equalsIgnoreCase("N")) {
					Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the snptype dropdown is in disable");

				}

			} else if (Fields.equalsIgnoreCase("BusinessSegment and EnrolleeType")) {
				if (BusinessSegment.equalsIgnoreCase("Medica")) {
					Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);

					Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(EnrolleeType);
				} else if (BusinessSegment.equalsIgnoreCase("Senior Supplement")) {
					Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Assert.assertTrue(
							!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the enrolle type dropdown is in disable");
				}

			} else if (Fields.equalsIgnoreCase("SNPFlag and SNPType")) {
				if (SNPFlag.equalsIgnoreCase("Y")) {
					Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(SNPType);
				} else if (SNPFlag.equalsIgnoreCase("N")) {
					Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the snptype dropdown is in disable");

				}
			} else if (Fields.isEmpty()) {
				Assert.assertTrue(true, "no fields will be selected");
			} else if (Fields.equalsIgnoreCase("MarketProductName")) {
				if (MarketProductName.isEmpty()) {
					Managed_UI_Pageobjects.uncheck_marketproductname_checkbox(driver).click();
				} else {
					Managed_UI_Pageobjects.uncheck_marketproductname_checkbox(driver).click();
					Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys(MarketProductName);
				}
			} else if (Fields.equalsIgnoreCase("BusinessSegment")) {
				Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
			} else if (Fields.equalsIgnoreCase("SNP Flag")) {
				Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
			} else if (Fields.equalsIgnoreCase("SNPType")) {
				Managed_UI_Pageobjects.uncheck_snpflag_checkbox(driver).click();
				Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);

			} else if (Fields.equalsIgnoreCase("EnrolleeType")) {
				Managed_UI_Pageobjects.uncheck_bussinesssegment_checkbox(driver).click();
				Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver).selectByVisibleText(BusinessSegment);

			}
		} catch (Exception e) {
			Assert.fail("Failed to update the fields in managed update screen");
		}
	}

	@When("^After clicking on the \"([^\"]*)\" button the \"([^\"]*)\" will be diplayed then click on the popmessage and then verify the \"([^\"]*)\" screen is displayed$")
	public void after_clicking_on_the_button_the_will_be_diplayed_then_click_on_the_popmessage_and_then_verify_the_screen_is_displayed(
			String Transaction, String popupmessage, String Expectedresults) throws Throwable {
		try {
			if (Transaction.equalsIgnoreCase("Update")) {
				Managed_UI_Pageobjects.update_button(driver).click();
				Alert al = driver.switchTo().alert();
				Assert.assertTrue(al.getText().equalsIgnoreCase(popupmessage));
				al.accept();
				if (Expectedresults.equalsIgnoreCase("Managed Plan Search")) {
					Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).getText()
							.equalsIgnoreCase(Expectedresults), Expectedresults);

				} else if (Expectedresults.equalsIgnoreCase("Managed Plan Mass Update")) {
					Assert.assertTrue(Managed_UI_Pageobjects.mass_update_screen(driver).getText()
							.equalsIgnoreCase(Expectedresults), Expectedresults);

				}

			} else if (Transaction.equalsIgnoreCase("Cancel")) {
				Managed_UI_Pageobjects.click_cancel_button(driver).click();
				Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).getText()
						.equalsIgnoreCase(Expectedresults), "Verify the managed plan search screen");
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify the popup messages");
		}
	}

	@SuppressWarnings("null")
    @When("^Verify that (\\d+) are updated for the \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" in search results and also compare search results with database results$")
    public void verify_that_are_updated_for_the_and_and_and_and_in_search_results_and_also_compare_search_results_with_database_results(
                 int NumberOfRecords, String Fields, String MarketProductName, String BusinessSegment, String SNPFlag,
                 String SNPType, String EnrolleeType) throws Throwable {
//        try {
                 int selectedRow = 0;

                 if (Fields.equalsIgnoreCase("Marketproductname") || Fields.equalsIgnoreCase("BusinessSegment")
                              || (Fields.equalsIgnoreCase("SNP Flag") || Fields.equalsIgnoreCase("SNPType")
                                            || (Fields.equalsIgnoreCase("EnrolleeType") || Fields.equalsIgnoreCase("null")))) {
                        Assert.assertTrue(true, "no value will be updated for popup messages");
                 
                 } else {
                        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));

                        for (int i = 1; i <= tableRows.size(); i++) {
                              String year = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[" + i + "]/td[2]")).getText()
                                            .split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[0].trim();
                              String contractnumber = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[" + i + "]/td[2]"))
                                            .getText().split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[1]
                                                         .trim();
                              String pbpnumber = driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[" + i + "]/td[2]"))
                                            .getText().split("Year/Contract/PBP:")[1].split("Market Product Name:")[0].split("-")[2]
                                                         .trim();
                              Utils.connectToSqlserverDB();

                              String QUERY = Constants.Input_SQLS.getRow(9).getCell(1).getStringCellValue();
                             
                              QUERY = QUERY.replace("parameter1", year).replace("parameter2", contractnumber)
                                            .replace("parameter3", pbpnumber);
                              String Query1=Constants.Input_SQLS.getRow(10).getCell(1).getStringCellValue();
                              Query1= Query1.replace("parameter1", year).replace("parameter2", contractnumber)
                                            .replace("parameter3", pbpnumber);
                              System.out.println(QUERY);
                              System.out.println(Query1);
                              Constants.resultset = Constants.statement.executeQuery(QUERY);
                              Constants.resultsetMetadata = Constants.resultset.getMetaData();
                              Constants.resultset.next();
                              String Dbmarketproductname = Constants.resultset.getString("marketproductname");
                              String Dbbussinesssegment = Constants.resultset.getString("BusinessSegment");
                              String Dbenrolletpe = Constants.resultset.getString("EnrolleeType");
                              String Dbsnpflag = Constants.resultset.getString("SNPFlag");
                              String Dbsnptype = Constants.resultset.getString("Snptype");
                              Constants.resultset1 = Constants.statement.executeQuery(Query1);
                              System.out.println(Query1);
                              Constants.resultsetMetadata1 = Constants.resultset1.getMetaData();
                              Constants.resultset1.next();
                              String Dbomarketproductname = Constants.resultset1.getString("PlanName");
                 
                              String Dbobussinesssegment = Constants.resultset1.getString("bussinesssegment");
                              String Dbosnptype = Constants.resultset1.getString("SNPType");
                              String Dbosnpflag = Constants.resultset1.getString("snpflag");

                              if (Fields.equalsIgnoreCase("ALL")) {
                                     String marketproductname = driver
                                                  .findElement(By.xpath("//tr[" + i + "]/td[contains(.,'Year/Contract/PBP')]")).getText()
                                                  .split("Market Product Name:")[1].trim();
                                     String bussinesssegment = driver
                                                   .findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[3]")).getText();
                                     String enrolletpe = driver
                                                   .findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[7]")).getText();
                                     String snpflag = driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[8]"))
                                                  .getText();
                                     String snptype = driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[9]"))
                                                  .getText();
                                     Assert.assertTrue(bussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                  && enrolletpe.equalsIgnoreCase(EnrolleeType) && snpflag.equalsIgnoreCase(SNPFlag)
                                                  && snptype.equalsIgnoreCase(SNPType) && marketproductname.equals(MarketProductName));
                                     Assert.assertTrue(Dbbussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                  && Dbenrolletpe.equalsIgnoreCase(EnrolleeType) && Dbsnpflag.equalsIgnoreCase(SNPFlag)
                                                  && Dbsnptype.equalsIgnoreCase(SNPType)
                                                  && Dbmarketproductname.equals(MarketProductName));
                                     Assert.assertTrue(Dbobussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                  && Dbosnptype.equalsIgnoreCase(SNPType) && Dbosnpflag.equalsIgnoreCase(SNPFlag)
                                                  && Dbomarketproductname.equals(MarketProductName));
                        
                              } else if (Fields.equalsIgnoreCase("MarketProductName")) {
                                     
                                     String marketproductname = driver
                                                  .findElement(By.xpath("//tr[" + i + "]/td[contains(.,'Year/Contract/PBP')]")).getText()
                                                  .split("Market Product Name:")[1].trim();
                                     Assert.assertTrue(marketproductname.equals(MarketProductName));
                                     Assert.assertTrue(Dbmarketproductname.equals(MarketProductName));
                                     Assert.assertTrue(Dbomarketproductname.equals(MarketProductName));

                              } else if (Fields.equalsIgnoreCase("SNPFlag and SNPType")) {
                                     String snpflag = driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[8]"))
                                                  .getText();
                                     String snptype = driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[9]"))
                                                  .getText();
                                     if(SNPFlag.equals("Y")) {
                                            Assert.assertTrue(snpflag.equalsIgnoreCase(SNPFlag) && snptype.equalsIgnoreCase(SNPType));
                                            Assert.assertTrue((snptype.equalsIgnoreCase(Dbsnptype)) && Dbsnpflag.equalsIgnoreCase(SNPFlag));
                                            Assert.assertTrue(Dbosnptype.equalsIgnoreCase(SNPType) && Dbosnpflag.equalsIgnoreCase(SNPFlag));

                                     }
                                     else
                                     {
                                            Assert.assertTrue(snpflag.equalsIgnoreCase(SNPFlag) && snptype.equalsIgnoreCase(SNPType));
                                            Assert.assertTrue((snptype.isEmpty()&& Dbsnptype==null) && Dbsnpflag.equalsIgnoreCase(SNPFlag));
                                            Assert.assertTrue((SNPType.isEmpty()&& Dbosnptype==null) && Dbosnpflag.equalsIgnoreCase(SNPFlag));
                                     }
                                     
                                     
          

                              } else if (Fields.equalsIgnoreCase("BusinessSegmentandEnrolleeType")) {
                                     String bussinesssegment = driver
                                                   .findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[3]")).getText();
                                     String enrolletpe = driver
                                                   .findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[7]")).getText();
                                     if(BusinessSegment.equals("Medica")) {
                                     Assert.assertTrue(bussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                  && enrolletpe.equalsIgnoreCase(EnrolleeType));
                                     Assert.assertTrue(Dbbussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                  && Dbenrolletpe.equalsIgnoreCase(EnrolleeType));
                                     Assert.assertTrue(Dbobussinesssegment.equalsIgnoreCase(BusinessSegment));
                              
                                       }
                                     else  {
                                            Assert.assertTrue(bussinesssegment.equalsIgnoreCase(BusinessSegment)
                                                         && enrolletpe.equalsIgnoreCase(EnrolleeType));
                                            Assert.assertTrue((EnrolleeType.isEmpty()&& Dbenrolletpe==null)
                                                         && Dbbussinesssegment.equalsIgnoreCase(BusinessSegment));
                                            Assert.assertTrue(Dbobussinesssegment.equalsIgnoreCase(BusinessSegment));
                                     
                                     }

                              }
                              else if (Fields.equalsIgnoreCase("onlyEnrolleeType")) {
                 
                                     String enrolletpe = driver
                                                   .findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[7]")).getText();
                                     Assert.assertTrue(enrolletpe.equalsIgnoreCase(EnrolleeType));
                        
                              }
                              
                              else if(Fields.equalsIgnoreCase("onlyEnrolleeType")) {
                                     String snptype = driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + i + "]/td[9]"))
                                                  .getText();
                                     
                                            Assert.assertTrue((snptype.equalsIgnoreCase(Dbsnptype)));
                                            
                              }

                              selectedRow++;
                               if (selectedRow == NumberOfRecords) {
                                     break;
                              }

                        }
                 }
	}

//	@When("^click on Mass Data Update button$")
//	public void click_on_Mass_Data_Update_button() throws Throwable {
//	}
//
//	@When("^Verify the \"([^\"]*)\" is displayed\\.$")
//	public void verify_the_is_displayed(String arg1) throws Throwable {
//	}
//
//	@When("^verify Managed Plan Mass Update Screen is displayed with below fields in disable mode with checkbox$")
//	public void verify_Managed_Plan_Mass_Update_Screen_is_displayed_with_below_fields_in_disable_mode_with_checkbox(
//			DataTable arg1) throws Throwable {
//	}
//
//	@When("^Verify the below buttons are displayed and also records will be displayed in the grid as per the records selected in search screen$")
//	public void verify_the_below_buttons_are_displayed_and_also_records_will_be_displayed_in_the_grid_as_per_the_records_selected_in_search_screen(
//			DataTable arg1) throws Throwable {
//	}
//
//	@When("^Select the checkbox for the below fields and verify the fields is for editing$")
//	public void select_the_checkbox_for_the_below_fields_and_verify_the_fields_is_for_editing(DataTable arg1)
//			throws Throwable {
//	}
//
//	@When("^Select the checkbox and Enter data for \"([^\"]*)\"$")
//	public void select_the_checkbox_and_Enter_data_for(String arg1) throws Throwable {
//
//	}
//
//	@Then("^Verify <Expected Results> are displayed$")
//	public void verify_Expected_Results_are_displayed() throws Throwable {
//
//	}
//
//	@Then("^Compare UI results with Data base results$")
//	public void compare_UI_results_with_Data_base_results() throws Throwable {
//
//	}
//
//	@When("^select  from the search results grid$")
//	public void select_from_the_search_results_grid() throws Throwable {
//
//	}
//
//	@When("^Select the checkbox and Enter data for $")
//	public void select_the_checkbox_and_Enter_data_for() throws Throwable {
//
//	}
//
//	@When("^click on  button$")
//	public void click_on_button() throws Throwable {
//
//	}

	@When("^verify snptype$")
	public void verify_snptype() throws Throwable {

		Utils.connectToSqlserverDB();

		Constants.resultset = Constants.statement.executeQuery("select name from [snptype]");
		while (Constants.resultset.next()) {
			employer_groupparameters_DB.put("MasterGroupNumber", Constants.resultset.getString("name"));

		}
		System.out.println(employer_groupparameters_DB);
	}

	@When("^verify (\\d+) and Market Product Name and Business Segment and  SNP Flag and SNP Type and Enrollee Type  is displayed with below fields in disable mode with checkbox$")
	public void verify_and_Market_Product_Name_and_Business_Segment_and_SNP_Flag_and_SNP_Type_and_Enrollee_Type_is_displayed_with_below_fields_in_disable_mode_with_checkbox(
			int NumberOfRecords) throws Throwable {
		try {
			if (!(NumberOfRecords == 0)) {
				Assert.assertTrue(!Managed_UI_Pageobjects.Marketproductname_textfield(driver).isEnabled(),
						"verify marketproductname is in disabled mode");
				Assert.assertTrue(!Managed_UI_Pageobjects.verify_businesssegment_disablemode(driver).isEnabled(),
						"verify bussinesssegment is in disable mode");
				Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNPFlag_disablemode(driver).isEnabled(),
						"verify snpflag is in disable mode");
				Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
						"verify snptype is in disable mode");
				Assert.assertTrue(!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
						"verify enrolletype is in disable mode");
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify the fields is in disable mode");
		}

	}

	@When("^Records will be displayed in the search grid then click on edit link for the provided plan in the above step$")
	public void records_will_be_displayed_in_the_search_grid_then_click_on_edit_link_for_the_provided_plan_in_the_above_step()
			throws Throwable {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		try {

			if (tableRows.size() >= 1) {
				Assert.assertTrue(tableRows.size() >= 1, "data is displayed in search results");
				System.out.println("verS");
			} else {
				Assert.fail("Failed as data is not displayed in search results");
			}
			Managed_UI_Pageobjects.click_on_edit(driver).click();
			Thread.sleep(4000);

		} catch (Exception e) {
			Assert.fail("Failed to verify the data in the search results");
		}
	}

	@Then("^verify user is navagated to edit screen \"([^\"]*)\"$")
	public void verify_user_is_navagated_to_edit_screen(String ManagedPlanEditscreen) throws Throwable {
		try {

			Assert.assertTrue(
					Managed_UI_Pageobjects.verify_editscreen(driver).getText().equalsIgnoreCase(ManagedPlanEditscreen),
					"verify the edit screen is displayed");
			System.out.println("mouni");

		} catch (Exception e) {
			Assert.fail("Failed to verify the edit screen");
		}
	}

	@Then("^verify that Contract / PBP / Year and Product Type and Drug Coverage Type  and State fields are displayed in disable mode$")
	public void verify_that_Contract_PBP_Year_and_Product_Type_and_Drug_Coverage_Type_and_State_fields_are_displayed_in_disable_mode()
			throws Throwable {
		try {
			Assert.assertTrue(Managed_UI_Pageobjects.verify_edit_contract_pbp_year(driver).getAttribute("readonly").equals("true"));
			Assert.assertTrue(Managed_UI_Pageobjects.verify_edit_drugcoveragetype(driver).getAttribute("readonly").equals("true"));
			Assert.assertTrue(Managed_UI_Pageobjects.verify_edit_producttype(driver).getAttribute("readonly").equals("true"));
			Assert.assertTrue(Managed_UI_Pageobjects.verify_edit_state(driver).getAttribute("readonly").equals("true"));
		}
	  catch(Exception e) {
		  Assert.fail("Failed to verify the disable fields");
	  }
		}


	@Then("^verify that below fields are displayed with checkbox with editing mode$")
	public void verify_that_below_fields_are_displayed_with_checkbox_with_editing_mode(DataTable arg1)
			throws Throwable {
	}

	@Then("^Verify the below buttons are displayed$")
	public void verify_the_below_buttons_are_displayed(DataTable fields) throws Throwable {
		try {
			List<String> list = fields.asList(String.class);
			for (int i = 0; i < list.size(); i++) {
				driver.getPageSource().contains(list.get(i));
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify the buttons displayed");
		}
	}


	@Then("^uncheck the checkbox and provide the data for the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" displayed in the edit screen$")
	public void uncheck_the_checkbox_and_provide_the_data_for_the_and_and_and_and_and_displayed_in_the_edit_screen(
			String Fields, String MarketProductName, String BusinessSegment, String SNPFlag, String SNPType, String EnrolleeType) throws Throwable {
		
	try {

			if (Fields.equalsIgnoreCase("ALL")) {
				Managed_UI_Pageobjects.uncheck_edit_productname(driver).click();
				Managed_UI_Pageobjects.Marketproductname_textfield(driver).clear();
				Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys(MarketProductName);

				if (BusinessSegment.equalsIgnoreCase("Medica")) {
					Managed_UI_Pageobjects.uncheck_edit_businesssegment(driver).click();
					
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Managed_UI_Pageobjects.uncheck_edit_enrolletype(driver).click();
					Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(EnrolleeType);
				} else if (BusinessSegment.equalsIgnoreCase("Senior Supplement")) {
					Managed_UI_Pageobjects.uncheck_edit_businesssegment(driver).click();
				
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Assert.assertTrue(
							!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the enrolle type dropdown is in disable");

				}
				if (SNPFlag.equalsIgnoreCase("Y")) {
					Managed_UI_Pageobjects.uncheck_edit_SNPFlag(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Managed_UI_Pageobjects.uncheck_edit_Snptype(driver).click();
					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(SNPType);
				} else if (SNPFlag.equalsIgnoreCase("N")) {
					Managed_UI_Pageobjects.uncheck_edit_SNPFlag(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the snptype dropdown is in disable");

				}

			} else if (Fields.equalsIgnoreCase("BusinessSegmentandEnrolleeType")) {
				if (BusinessSegment.equalsIgnoreCase("Medica")) {
					Managed_UI_Pageobjects.uncheck_edit_businesssegment(driver).click();
				
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Managed_UI_Pageobjects.uncheck_edit_enrolletype(driver).click();
					Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(EnrolleeType);
				} else if (BusinessSegment.equalsIgnoreCase("Senior Supplement")) {
					Managed_UI_Pageobjects.uncheck_edit_businesssegment(driver).click();
					Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver)
							.selectByVisibleText(BusinessSegment);
					Assert.assertTrue(
							!Managed_UI_Pageobjects.verify_Enrolle_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the enrolle type dropdown is in disable");

				}

			} else if (Fields.equalsIgnoreCase("SNPFlag and SNPType")) {
				if (SNPFlag.equalsIgnoreCase("Y")) {
					Managed_UI_Pageobjects.uncheck_edit_SNPFlag(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					Managed_UI_Pageobjects.uncheck_edit_Snptype(driver).click();
					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(SNPType);
				} else if (SNPFlag.equalsIgnoreCase("N")) {
					Managed_UI_Pageobjects.uncheck_edit_SNPFlag(driver).click();
					Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(SNPFlag);
					
					System.out.println("mou");
					Assert.assertTrue(!Managed_UI_Pageobjects.verify_SNP_Type_dropdown_isdisabled(driver).isEnabled(),
							"verify the snptype dropdown is in disable");

				}
			}
			 else if (Fields.equalsIgnoreCase("MarketProductName")) {
				if (MarketProductName.isEmpty()) {
					Managed_UI_Pageobjects.uncheck_edit_productname(driver).click();
					Managed_UI_Pageobjects.Marketproductname_textfield(driver).clear();
				} else {
					Managed_UI_Pageobjects.uncheck_edit_productname(driver).click();
					Managed_UI_Pageobjects.Marketproductname_textfield(driver).clear();
					Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys(MarketProductName);
				}
			} else if (Fields.equalsIgnoreCase("BusinessSegment")) {
				Managed_UI_Pageobjects.uncheck_edit_businesssegment(driver).click();
				Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver).selectByIndex(0);
				
			} else if (Fields.equalsIgnoreCase("SNP Flag")) {
				Managed_UI_Pageobjects.uncheck_edit_SNPFlag(driver).click();
				Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByIndex(0);
			} else if (Fields.equalsIgnoreCase("SNPType")||Fields.equalsIgnoreCase("onlySNPType")) {
				if(SNPType.isEmpty()) {
					Managed_UI_Pageobjects.uncheck_edit_Snptype(driver).click();
					
					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByIndex(0);
				}
				else {
					Managed_UI_Pageobjects.uncheck_edit_Snptype(driver).click();
					
					Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(SNPType);
				}
				

			} else if (Fields.equalsIgnoreCase("EnrolleeType")||Fields.equalsIgnoreCase("onlyEnrolleeType")) {
				if(EnrolleeType.isEmpty()) {
				Managed_UI_Pageobjects.uncheck_edit_enrolletype(driver).click();
				Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByIndex(0);

			}
				else {
					Managed_UI_Pageobjects.uncheck_edit_enrolletype(driver).click();
					Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(EnrolleeType);
				}
			}
			else if(Fields.isEmpty()) {
		Assert.assertTrue(true, "no fields will be checked");
				
			}
	}
		
		catch (Exception e) {
			Assert.fail("Failed to update the fields in managed edit screen");
		}
	}


	@When("^After clicking on \"([^\"]*)\" button the \"([^\"]*)\" will be diplayed then click on the popmessage and then verify the \"([^\"]*)\" screen is displayed$")
	public void after_clicking_on_button_the_will_be_diplayed_then_click_on_the_popmessage_and_then_verify_the_screen_is_displayed(
			String Transaction, String popupmessage, String ExceptedResults) throws Throwable {
		try {
			if (Transaction.equalsIgnoreCase("Update")) {
				Managed_UI_Pageobjects.update_button(driver).click();
				Alert al = driver.switchTo().alert();
				Assert.assertTrue(al.getText().equalsIgnoreCase(popupmessage));
				al.accept();
				if (ExceptedResults.equalsIgnoreCase("Managed Plan Search")) {
					Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).getText()
							.equalsIgnoreCase(ExceptedResults), "Veify managed plan search");

				} else if (ExceptedResults.equalsIgnoreCase("Managed Plan Edit")) {
					Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_edit_screen(driver).getText()
							.equalsIgnoreCase(ExceptedResults), "Veify managed plan edit ");

				}

			} else if (Transaction.equalsIgnoreCase("Cancel")) {
				Managed_UI_Pageobjects.click_cancel_button(driver).click();
				Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).getText()
						.equalsIgnoreCase(ExceptedResults), "Verify the managed plan search screen");
			}
		} catch (Exception e) {
			Assert.fail("Failed to verify the popup messages");
		}
	}

	
	@When("^Select \"([^\"]*)\" and enter \"([^\"]*)\" and \"([^\"]*)\" then click on search plans in the search screen$")
	public void select_and_enter_and_then_click_on_search_plans_in_the_search_screen(String Year, String Contract, String Pbp) throws Throwable {
	  try {
	Managed_UI_Pageobjects.contractnumber_textfield(driver).sendKeys(Contract);
	Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys(Pbp);
	Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(Year);
	Utils.click(driver, Managed_UI_Pageobjects.click_on_search_button(driver));
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(Managed_UI_Pageobjects.click_on_edit(driver)));

	}
	  catch(Exception e) {
		  Assert.fail("Failed to select year and contract and pbp");
	  }
	}
	
	
	@When("^Enter PBP Number as \"([^\"]*)\" in the textfield for edit scenario$")
	public void enter_PBP_Number_as_in_the_textfield(String Pbp) throws Throwable {
		try {
			pbp = Pbp;

			if (Pbp.equalsIgnoreCase("null")) {
				Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys("null");
			} else {
				Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys(Pbp);
			}
		} catch (Exception e) {
			Assert.fail("Failed to enter pbp number");
		}
	}
	
	@When("^click on county textfield and then select county$")
	public void click_on_county_textfield_and_then_select_county() throws Throwable {
		try {

			driver.findElement(By.xpath("//*[@id='statesMainDiv1']/div/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='statesMainDiv1']/div/div/ul/li[1]/label/input")).click();
	
		} catch (Exception e) {
			Assert.fail("Failed to select the county");
		}
	}
	

	//------------------edit county part--------------------------

	@When("^Records will be displayed in search grid$")
	public void records_will_be_displayed_in_search_grid() throws Throwable {
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		try {
			if (tableRows.size() > 1) {
				Assert.assertTrue(tableRows.size() > 1, "data is displayed in search results");
			} else {
				Assert.fail("Failed as data is not displayed in search results");
			}
		} 
		catch (Exception e) {
			Assert.fail("Failed to verify the data displayed in the search grid");
		}
	}


	@When("^select one record from the result list and get its county count and click on Edit link$")
	public void select_one_record_from_the_result_list_and_get_its_county_count_and_click_on_Edit_link() throws Throwable {
				String PlanDetail="";
				String planType="";
				String planName="";
				String year="";
				String contractNumber="";
				String pbpNumber="";
				String CMSCountyCode="";
				TreeMap<String,String> InnerHmpCounty=new TreeMap<String,String>();
				WebElement checkboxObj=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[1]/input"));
				PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[2]")).getText();
				CMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[5]")).getText();
				GlobalState=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[4]")).getText();
				if(CMSCountyCode.contains(",")) {
					String[] countyCountArr=CMSCountyCode.split(",");
			    	countyCount=countyCountArr.length;
			    	System.out.println("countyCount="+countyCount);
				}
				else {
					countyCount=1;
				}
				System.out.println("PlanDetail="+PlanDetail);
				String[] part1=PlanDetail.split(": ");
				String[] part3=part1[1].split("\n");
				planType=part3[0];
				planName=part1[part1.length-1];
				System.out.println("planType="+planType);
				System.out.println("planName="+planName);
				String[] part2=part1[2].split(" - ");
				year=part2[0];
				contractNumber=part2[1];
				String[] part4=part2[2].split("\n");
				pbpNumber=part4[0];
				System.out.println("year="+year);
				System.out.println("contractNumber="+contractNumber);
				System.out.println("pbpNumber="+pbpNumber);
				GlobalContractNumber=contractNumber;
				GlobalPBPNumber=pbpNumber;
				GlobalYear=year;
				InnerHmpCounty.put("year", year);
				InnerHmpCounty.put("contractNumber", contractNumber);
				InnerHmpCounty.put("pbpNumber", pbpNumber);
				InnerHmpCounty.put("planType", planType);
				InnerHmpCounty.put("planName", planName);
				InnerHmpCounty.put("CMSCountyCode", CMSCountyCode);
				System.out.println(InnerHmpCounty);
				System.out.println("Clicks on Edit Link");
				driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[11]/a")).click();
				Thread.sleep(5000);
	}

	@Then("^manage plan edit page should display for the selected record$")
	public void manage_plan_edit_page_should_display_for_the_selected_record() throws Throwable {
		try {
			String Actual_Contract_PBP_Year_EditScreen="";
			String Contract_PBP_Year_EditScreen="";
			Assert.assertTrue(Managed_UI_Pageobjects.verify_editscreen(driver).getText().equalsIgnoreCase("Managed Plan Edit"),"verify the Edit screen is displayed");
			Contract_PBP_Year_EditScreen= GlobalContractNumber +" - "+ GlobalPBPNumber +" - "+ GlobalYear;
			System.out.println(Contract_PBP_Year_EditScreen);
			Actual_Contract_PBP_Year_EditScreen=Managed_UI_Pageobjects.verify_Contract_PBP_Year_text(driver).getAttribute("value");
			Assert.assertTrue(Contract_PBP_Year_EditScreen.equalsIgnoreCase(Actual_Contract_PBP_Year_EditScreen), "verify_Contract_PBP_Year_textfield_plan_data_on edit screen is loaded correctly");
		} 
		catch (Exception e) {
			Assert.fail("Failed to verify the edit screen and the expected data on page");
		}
		
	}

	@Then("^verify the selected county count in county field is equal to searched record and if selected record have less than (\\d+) counties names should be dispayed$")
	public void verify_the_selected_county_count_in_county_field_is_equal_to_searched_record_and_if_selected_record_have_less_than_counties_names_should_be_dispayed(int arg1) throws Throwable {
				WebElement countyEditScreen=driver.findElement(By.xpath("//div[@id='divStateCountyDrps']"));
				String valCounty=countyEditScreen.getText();
				WebElement currCheck;
				int countCheck=0;
				String currLabel="";
				if(valCounty.equals("All selected")) {
					WebElement CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
					CountyEditCheckBox.click();
					Thread.sleep(2000);
					countyEditScreen=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/button"));
					countyEditScreen.click();
					List<WebElement> listCheckBox=driver.findElements(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li"));
					for(int d=2;d<=listCheckBox.size()-1;d++) {
						currCheck=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+d+"]/label/input"));
						if(currCheck.isSelected()) {
							countCheck=countCheck+1;
							CountyEditCheckBox.click();
						}
					}
				}
				else if(valCounty.contains("of")) {
					String[] arr1=valCounty.split(" of ");
					countCheck=Integer.parseInt(arr1[0]);
				}
				
				else if(valCounty.contains(",")) {
					String[] arr2=valCounty.split(",");
					countCheck=arr2.length;
				}
				
				WebElement CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
				CountyEditCheckBox.click();
				Thread.sleep(2000);
				countyEditScreen=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/button"));
				countyEditScreen.click();
				List<WebElement> listCheckBox=driver.findElements(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li"));
				for(int d=1;d<listCheckBox.size()-1;d++) {
					currCheck=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+(d+1)+"]/label/input"));
					currLabel=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+(d+1)+"]/label/span")).getText();
					if(currCheck.isSelected()) {
						System.out.println(currLabel);
						arrList2.add(currLabel);
						System.out.println("d="+d);
					}
				}
				Collections.sort(arrList2);
				System.out.println(arrList2);
				countyEditScreen.click();
				Thread.sleep(2000);
				countyEditScreen.click();
	}

	@Then("^verify the selected county names in county field belongs to assigned county code of searched record$")
	public void verify_the_selected_county_names_in_county_field_belongs_to_assigned_county_code_of_searched_record() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^verify after clicking county checbox the county values are editable$")
	public void verify_after_clicking_county_checbox_the_county_values_are_editable() throws Throwable {
			Thread.sleep(2000);
			WebElement CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
			if (CountyEditCheckBox.isSelected()) {
				CountyEditCheckBox.click();
				Thread.sleep(2000);
			}
			WebElement countyEditScreen1=driver.findElement(By.xpath("//div[@id='divStateCountyDrps']"));
			String strDisableTagValue=countyEditScreen1.getAttribute("disabled");
			Assert.assertTrue(strDisableTagValue.equals("true"),"Verify if county is not checked values are disabled");
			CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
			Thread.sleep(2000);
			CountyEditCheckBox.click();
			Thread.sleep(2000);
			WebElement countyEditScreen2=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/button"));
			countyEditScreen2.click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li[1]/label/input")).isEnabled(), "Verify if county is checked values are enabled");
			countyEditScreen2.click();
			CountyEditCheckBox.click();
	}

	@Then("^select and update county$")
	public void select_and_update_county() throws Throwable {
		WebElement countyEdit=driver.findElement(By.xpath("//div[@id='divStateCountyDrps']"));
		String valCounty=countyEdit.getText();
		WebElement CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
		CountyEditCheckBox.click();
		WebElement countyEditScreen=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/button"));
		countyEditScreen.click();
		WebElement SelectAllCheck;
		SelectAllCheck=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li[1]/label/input"));
		if(valCounty.equals("All selected")) {
			SelectAllCheck.click();
			Thread.sleep(2000);
			WebElement currCheck;
			for(int k=2;k<5;k++) {
				currCheck=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+k+"]/label/input"));
				currCheck.click();
				Thread.sleep(2000);
			}
		}
		else {
			SelectAllCheck.click();
		}
		WebElement currCheckSelected;
		String currLabelSelected="";
		List<WebElement> listCheckBoxSelected=driver.findElements(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li"));
		for(int d=1;d<listCheckBoxSelected.size()-1;d++) {
			currCheckSelected=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+(d+1)+"]/label/input"));
			currLabelSelected=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li["+(d+1)+"]/label/span")).getText();
			if(currCheckSelected.isSelected()) {
				arrList3.add(currLabelSelected);
			}
		}
		Collections.sort(arrList3);
		System.out.println(arrList3);
		driver.findElement(By.xpath("//*[@id='UpdateManagedPlan']")).click();
		Thread.sleep(2000);
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			}
		catch(Exception e) {
			Assert.fail("Failed to click on ok button"); 
		}
		Thread.sleep(5000);
	}

	@Then("^The updated vaues should reflect in UI and DB for county on Edit screen$")
	public void the_updated_vaues_should_reflect_in_UI_and_DB_for_county_on_Edit_screen() throws Throwable {
		Managed_UI_Pageobjects.select_producttype_dropdown(driver).selectByVisibleText(GlobalProductType);
		Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
		Thread.sleep(5000);
		String CMSCountyCode="";
		int countyCountAfterUpdate=0;
		CMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[5]")).getText();
		if(CMSCountyCode.contains(",")) {
			String[] countyCountArr=CMSCountyCode.split(",");
	    	countyCountAfterUpdate=countyCountArr.length;
	    	System.out.println("countyCount="+countyCount);
	    	for(int z=0;z<countyCountArr.length;z++) {
	    		DBResultStageTableUI.add(countyCountArr[z]);
	    	}
		}
		else {
			countyCountAfterUpdate=1;
			DBResultStageTableUI.add(CMSCountyCode);
		}
		System.out.println(DBResultStageTableUI);
		Assert.assertTrue(countyCountAfterUpdate!=countyCount, "Verify the county got updated in UI");
		
			Utils.connectToSqlserverDB();
		  	String Query="select ct.CMSName from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.StateCode='strState'";
			Query=Query.replace("strYear", GlobalYear);
			Query=Query.replace("strContractNumber", GlobalContractNumber);
			Query=Query.replace("strPBPNumber", GlobalPBPNumber);
			Query=Query.replace("strState", GlobalState);
			System.out.println("Query==>"+Query);
			try {
				Constants.resultset = Constants.statement.executeQuery(Query);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				for (int k = 1; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBResultDBOTable.add(Constants.resultset.getString(j));
					}
				}
				Collections.sort(DBResultDBOTable);
				System.out.println(DBResultDBOTable);
				System.out.println("State="+GlobalState);
				Assert.assertTrue(DBResultDBOTable.equals(arrList3), "Verify the county got updated in DBO Table");
			}
			catch (Exception e) {
			Assert.fail("failed to validate UI and DB data");
			}
			
			try {
			String Query8="select CMSCountyCode from [dbo].[StgManagedPlansLoad] where year(planeffectivedate)='strYear'and contractnumber='strContractNumber' and pbpnumber='strPBPNumber' and StateAbbr='strState'";
			Query8=Query8.replace("strYear", GlobalYear);
			Query8=Query8.replace("strContractNumber", GlobalContractNumber);
			Query8=Query8.replace("strPBPNumber", GlobalPBPNumber);
			Query8=Query8.replace("strState", GlobalState);
			System.out.println("Query8==>"+Query8);
			Constants.resultset = Constants.statement.executeQuery(Query8);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			for (int m = 1; Constants.resultset.next(); m++) {
				for (int n=1; n<=1; n++) {
					DBResultStageTableTemp.add(Constants.resultset.getString(n));
				}
			}
			Collections.sort(DBResultStageTableTemp);
			if(DBResultStageTableTemp.get(0).contains(",")) {
				String[] countyCountArr2=DBResultStageTableTemp.get(0).split(",");
		    	for(int z=0;z<countyCountArr2.length;z++) {
		    		DBResultStageTableDB.add(countyCountArr2[z]);
		    	}
			}
			System.out.println(DBResultStageTableDB);
			System.out.println(DBResultStageTableUI);
			Assert.assertTrue(DBResultStageTableDB.equals(DBResultStageTableUI), "Verify the county got updated in Stage Table");
			}
			catch (Exception e) {
				Assert.fail("failed to validate UI and DB data");
				}
	}

	@Then("^verify if no county is selected and clicked on update button pop up validation should appear$")
	public void verify_if_no_county_is_selected_and_clicked_on_update_button_pop_up_validation_should_appear() throws Throwable {
		WebElement countyEdit=driver.findElement(By.xpath("//div[@id='divStateCountyDrps']"));
		String valCounty=countyEdit.getText();
		WebElement CountyEditCheckBox=driver.findElement(By.xpath("//input[@id='EditCounties']"));
		CountyEditCheckBox.click();
		WebElement countyEditScreen=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/button"));
		countyEditScreen.click();
		WebElement SelectAllCheck;
		SelectAllCheck=driver.findElement(By.xpath("//*[@id='divStateCountyDrps']/div/div/ul/li[1]/label/input"));
		if(valCounty.equals("All selected")) {
			SelectAllCheck.click();
			Thread.sleep(2000);
		}
		else {
			SelectAllCheck.click();
			Thread.sleep(2000);
			SelectAllCheck.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//*[@id='UpdateManagedPlan']")).click();
		Thread.sleep(2000);
		try {
			Alert alert = driver.switchTo().alert();
			Assert.assertTrue(alert.getText().equals("Please select atleast one county."), "Verify blank county trows pop up validation");
			alert.accept();
			}
		catch(Exception e) {
			Assert.fail("Failed to validate blank county pop up validation"); 
		}
	}

	//------------------edit county part--------------------------


}
