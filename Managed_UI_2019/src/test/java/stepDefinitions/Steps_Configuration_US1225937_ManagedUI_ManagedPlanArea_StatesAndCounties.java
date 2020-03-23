package stepDefinitions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageObjects.Contactui_pageobjects;
import pageObjects.Managed_UI_Pageobjects;
import pageObjects.Planui_pageobjects;
//import pageObjects.RuntimeSettings_pageObjects;
//import pageObjects.Test1_pageObjects;
import utilities.Constants;
import utilities.Utils;


public class Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties {
	static WebDriver driver;
	static String Contract_PBP_Year_managedscreen;
	static String Market_product_Name_createscreen;
	static String Contract_PBP_Year_createscreen;
	static String Market_product_Name_managedscreen;
	static String Contract;
	static String PBP;
	static String year;
	static String MarketProductName;
	static String ProductTypeDropDown;
	static String BussinessSegmentDropDown;
	static String EnrolleeTypeDropDown;
	static String SNPFlagDropDown;
	static String SNPTypeDropDown;
	static String DrugCoverageDropDown;
	String Contract2018;
	String PBP2018;
	int tempStateCount=0;
//	HashMap<String, HashMap<String,Integer>> OuterHmp = new HashMap<String, HashMap<String,Integer>>();
	HashMap<String,ArrayList<String>> OuterHmp = new HashMap<String,ArrayList<String>>();
	ArrayList<String> DBResult;
	ArrayList<String> DBResult2;
	ArrayList<String> DBResult3;
	ArrayList<String> DBResult4;
	ArrayList<String> DBResult5;
	LinkedHashMap<Integer, String> DBresults = new LinkedHashMap<Integer, String>();
	HashMap<String,Integer> InnerHmp=new HashMap<String,Integer>();
	TreeMap<String,String> StgStateCountyUI=new TreeMap<String,String>();
	TreeMap<String,String> StgStateCountyDB=new TreeMap<String,String>();
	TreeMap<String,Integer> OuterHmp1=new TreeMap<String,Integer>();
	TreeMap<String,Integer> OuterHmp2018DB=new TreeMap<String,Integer>();
	TreeMap<String,Integer> OuterHmp2019DB=new TreeMap<String,Integer>();
	TreeMap<String,Integer> OuterHmp2019StageDB=new TreeMap<String,Integer>();
	TreeMap<String,ArrayList<String>> OuterHmp2018DBCounty=new TreeMap<String,ArrayList<String>>();
	TreeMap<String,ArrayList<String>> OuterHmp4=new TreeMap<String,ArrayList<String>>();
	TreeMap<String,ArrayList<String>> OuterHmp5=new TreeMap<String,ArrayList<String>>();
	
//	HashMap<Integer, String> InnerHmp;

	public Steps_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties() {
		this.driver = Hooks.driver;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}
	
	
@Given("^Login to the Maps UI and click on Managed plan setup link$")
	public void login_to_the_Maps_UI_and_click_on_Managed_plan_setup_link() throws Throwable {
	try {
		Utils.click(driver, Managed_UI_Pageobjects.click_ManagedPlanSetup_link(driver));
	}
	catch(Exception e) {
		Assert.fail("Failed to click on Managed Plan setup link");
	}
	}

@When("^Managed plan search and Create New Managed Plan button screen will be displayed$")
public void managed_plan_search_and_Create_New_Managed_Plan_button_screen_will_be_displayed() throws Throwable {
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).isDisplayed(),"Verify_Managed_plan_search");
		Assert.assertTrue(Managed_UI_Pageobjects.Create_New_Manged_plan_link(driver).isDisplayed(),"Verify_Create_New_Managed_Plan_button");
	  }
	  catch(Exception e) {
		Assert.fail("Faile to verify Managed plan search screen and create new managed plan button");
	  }
}

@When("^click on Create New Managed Plan button$")
public void click_on_Create_New_Managed_Plan_button1() throws Throwable {
	try {
    	Utils.click(driver, Managed_UI_Pageobjects.Create_New_Manged_plan_link(driver));
    	Assert.assertTrue(Managed_UI_Pageobjects.Verify_Create_New_Managed_plan_screen(driver).isDisplayed(),"verify_create_managed_plan_screen");
    }
    catch(Exception e) {
    	Assert.fail("Failed to click on create new manged plan button");
    }
}
	
@When("^verify create managed plan screen is displayed$")
public void verify_create_managed_plan_screen_is_displayed() throws Throwable {
    	Assert.assertTrue(Managed_UI_Pageobjects.Verify_Create_New_Managed_plan_screen(driver).isDisplayed(),"verify_create_managed_plan_screen");
}

@When("^Select Year \"([^\"]*)\" from the dropdown$")
public void select_Year_from_the_dropdown(String reqYear) throws Throwable {
	try {
		year=reqYear;
		Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(reqYear);
	    }
		
	catch(Exception e)
	{
		Assert.fail("Failed to select year");
	}
}

@When("^Enter Contract number \"([^\"]*)\" in the textfield$")
public void enter_Contract_number_in_the_textfield(String reqContractNumber) throws Throwable {
	try {
		Contract=reqContractNumber;
		if(reqContractNumber.equalsIgnoreCase("null")) {
			Managed_UI_Pageobjects.contractnumber_textfield(driver).sendKeys("null");
		}
		else {
			Managed_UI_Pageobjects.contractnumber_textfield(driver).sendKeys(reqContractNumber);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Contract Number value");
    }
}

@When("^Enter PBP Number as \"([^\"]*)\" in the textfield$")
public void enter_PBP_Number_as_in_the_textfield(String reqPBPNumber) throws Throwable {
	try {
		PBP=reqPBPNumber;
		if(reqPBPNumber.equalsIgnoreCase("null")) {
			Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys("null");
		}
		else {
			Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys(reqPBPNumber);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter PBP Number value");
    }
}

@When("^Enter Market Product Name \"([^\"]*)\" in the textfield$")
public void enter_Market_Product_Name_in_the_textfield(String reqMarketProductName) throws Throwable {
	try {
		Market_product_Name_createscreen=reqMarketProductName;
		if(reqMarketProductName.equalsIgnoreCase("null")) {
			Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys("null");
		}
		else {
			Managed_UI_Pageobjects.Marketproductname_textfield(driver).sendKeys(reqMarketProductName);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Market Product Name value");
    }
}

@When("^Select Producttype \"([^\"]*)\" from the dropdown$")
public void select_Producttype_from_the_dropdown(String reqProductType) throws Throwable {
	try {
		if(reqProductType.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('ProductType').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_producttype_dropdown(driver).selectByVisibleText(reqProductType);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Product Type dropdown value");
    }
}

@When("^Drug Coverage Type \"([^\"]*)\" from the dropdown$")
public void drug_Coverage_Type_from_the_dropdown(String reqDrugCoverage) throws Throwable {
	try {
		if(reqDrugCoverage.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('DrugCoverageType').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_Drugcoveragetype_dropdown(driver).selectByVisibleText(reqDrugCoverage);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Drug Coverage dropdown value");
    }
}

@When("^Select Bussiness Segment \"([^\"]*)\" from the dropdown$")
public void select_Bussiness_Segment_from_the_dropdown(String reqBusinessSegment) throws Throwable {
	try {
		if(reqBusinessSegment.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('BusinessSegment').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver).selectByVisibleText(reqBusinessSegment);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Business Segment dropdown value");
    }
}


@When("^Enrolle Type\"([^\"]*)\" from the dropdown$")
public void enrolle_Type_from_the_dropdown(String reqEnrolleType) throws Throwable {
	try {
		if(reqEnrolleType.equalsIgnoreCase("null")) {
			  ((JavascriptExecutor) driver).executeScript("document.getElementById('EnrolleeType').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver).selectByVisibleText(reqEnrolleType);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter Enrolle Type dropdown value");
    }
}

@When("^Select SNP Flag \"([^\"]*)\" from the dropdown$")
public void select_SNP_Flag_from_the_dropdown(String reqSNPFlag) throws Throwable {
	try {
		if(reqSNPFlag.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('SNPFlag').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver).selectByVisibleText(reqSNPFlag);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter SNP Flag dropdown value");
    }
}

@When("^SNP Type \"([^\"]*)\" from the dropdown$")
public void snp_Type_from_the_dropdown(String reqSNPType) throws Throwable {
	try {
		if(reqSNPType.equalsIgnoreCase("null")) {
			((JavascriptExecutor) driver).executeScript("document.getElementById('SNPType').selectedIndex=0;");
		}
		else {
			Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver).selectByVisibleText(reqSNPType);
		}
	}
    catch(Exception e) {
    	Assert.fail("Failed to enter SNP Type dropdown value");
    }
}

@When("^Store \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"  values to compare the data with next screen$")
public void store_and_and_and_values_to_compare_the_data_with_next_screen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	Contract_PBP_Year_createscreen= Contract +" - "+ PBP +" - "+ year;
	System.out.println(Contract_PBP_Year_createscreen);
}

@When("^Click on Next button$")
public void click_on_Next_button() throws Throwable {
	try {
		Utils.click(driver, Managed_UI_Pageobjects.click_Next_button(driver));
	}
	catch(Exception e) {
		Assert.fail("Failed to click on next button");
	}
}

@Then("^Verify the Manged area and page loading is displayed$")
public void verify_the_Manged_area_and_page_loading_is_displayed() throws Throwable {
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.verify_ManagedPlan_ServiceArea_screen(driver).isDisplayed(), "verify_the_Manged_area_screen");
	}
	catch(Exception e) {
		Assert.fail("Failed to verify on Managed area screen");
	}
}

@Then("^Verify that Contract/PBP/Year textfield plan data is same as the previous screen selected plan data$")
public void verify_that_Contract_PBP_Year_textfield_plan_data_is_same_as_the_previous_screen_selected_plan_data() throws Throwable {
	try {
		Contract_PBP_Year_managedscreen=Managed_UI_Pageobjects.verify_Contract_PBP_Year_text(driver).getAttribute("value");
		System.out.println(Contract_PBP_Year_createscreen);
		System.out.println(Contract_PBP_Year_managedscreen);
		Assert.assertTrue(Contract_PBP_Year_createscreen.equalsIgnoreCase(Contract_PBP_Year_managedscreen), "verify_that_Contract_PBP_Year_textfield_plan_data");
	   }
	   catch(Exception e) {
		   Assert.fail("Failed to verify the contract/PBP/Year data");
	   }
}

@Then("^Verify that Plan Name textfield data is same as the previous screen selected data$")
public void verify_that_Plan_Name_textfield_data_is_same_as_the_previous_screen_selected_data() throws Throwable {
	try {
	    Market_product_Name_managedscreen=Managed_UI_Pageobjects.Marketproductname_textfield(driver).getAttribute("value");
	    Assert.assertTrue(Market_product_Name_createscreen.equalsIgnoreCase(Market_product_Name_managedscreen), "verify_that_Plan_Name_textfield_data");
	   }
	   catch(Exception e) {
		   Assert.fail("Failed to verify the Plan Name data");
	   }
}

@When("^click on Add state and provide value to state \"([^\"]*)\" dropdown and select all counties from county dropdowns$")
public void click_on_Add_state_and_provide_value_to_state_dropdown_and_select_all_counties_from_county_dropdowns(String states) throws Throwable {
	String pathState="";
	String pathCounty="";
	String selectAll="";
	String selectedState="";
	String totalCounties="";
	String tempCountyName="";
	String[] arrayState= states.split(",");
	Thread.sleep(4000);
	tempStateCount=arrayState.length;
    for(int i=1;i<=tempStateCount;i++) {
    	LinkedHashMap<String,Integer> TempInnerHmp=new LinkedHashMap<String,Integer>();
    	InnerHmp=new HashMap<String,Integer>();
    	ArrayList<String> arrList = new ArrayList<String>(); 
    	WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
    	addStateButton.click();
//    	Thread.sleep(2000);
    	pathState="//select[contains(@id,'statesOpt"+i+"')]";
    	Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
//    	Thread.sleep(2000);
    	stateDropdown.selectByVisibleText(arrayState[i-1]);
    	selectedState = stateDropdown.getFirstSelectedOption().getText();
//    	Thread.sleep(2000);
    	 pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
        WebElement county=driver.findElement(By.xpath(pathCounty));
        Utils.click(driver, county);
        selectAll="//input[@data-name='selectAllcountyOpt"+i+"' and @type='checkbox']";
    	WebElement selectAllCheck=driver.findElement(By.xpath(selectAll));
    	Utils.click(driver, selectAllCheck);
//    	Thread.sleep(2000);
    	totalCounties="//*[@id='statesMainDiv"+i+"']/div/div//ul//li//label//span";
    	List<WebElement> elems=driver.findElements(By.xpath(totalCounties));
    	for(int j=0;j<elems.size();j++) {
    		tempCountyName=elems.get(j).getText();
    		arrList.add(tempCountyName);
    	}
    	Collections.sort(arrList);
    	System.out.println(arrList);
    	OuterHmp.put(selectedState,arrList);
      }
    System.out.println(OuterHmp);
}


@When("^click on create button$")
public void click_on_create_button() throws Throwable {
	Managed_UI_Pageobjects.createButton(driver).click();
//	Utils.click(driver, Managed_UI_Pageobjects.createButton(driver));
	Thread.sleep(5000);
}

@Then("^verify UI and DB values are matching$")
public void verify_UI_and_DB_values_are_matching() throws Throwable {
	String yearDB="";
	String contractNumberDB="";
	String pbpNumberDB="";
	String stateDB="";
	Utils.connectToSqlserverDB();
	for (String key : OuterHmp.keySet()) {
		DBResult=new ArrayList<String>();
	    System.out.println("Key = " + key);
		yearDB=year;
		contractNumberDB=Contract;
		pbpNumberDB=PBP;
		stateDB=key;
		String Query="select ct.CMSName from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.StateCode='strState'";
		Query=Query.replace("strYear", yearDB);
		Query=Query.replace("strContractNumber", contractNumberDB);
		Query=Query.replace("strPBPNumber", pbpNumberDB);
		Query=Query.replace("strState", stateDB);
		System.out.println("Query==>"+Query);
		try {
			Constants.resultset = Constants.statement.executeQuery(Query);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			for (int k = 1; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBResult.add(Constants.resultset.getString(j));
				}
			}
			Collections.sort(DBResult);
			System.out.println(DBResult);
			System.out.println("State="+stateDB);
			  if(OuterHmp.get(key).equals(DBResult)) {
				  Assert.assertTrue(OuterHmp.get(key).equals(DBResult), "verify_Match county PASS==>");
				  System.out.println("Match county PASS==>");
			  }
			  else {
				  Assert.fail("Verify Match county FAIL==>");
				  System.out.println("Match county FAIL==>");
			  }
		}
		catch (Exception e) {
		Assert.fail("failed to validate UI and DB data");
		}
	}
//------------------Staging table validation
	String reqStateCode;
	String reqCMSCountyCode;
	Utils.click(driver, Managed_UI_Pageobjects.click_ManagedPlanSetup_link(driver));
	Thread.sleep(2000);
	Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(yearDB);
	Managed_UI_Pageobjects.contractnumber_textfield(driver).sendKeys(contractNumberDB);
	Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys(pbpNumberDB);
	Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
	Thread.sleep(4000);
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	if(tableRows.size()>0) {
		for(int i=1;i<=tableRows.size();i++) {
			reqStateCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[4]")).getText();
			reqCMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[5]")).getText();
			StgStateCountyUI.put(reqStateCode,reqCMSCountyCode);
		}
		System.out.println(StgStateCountyUI);
	}
	else {
		Assert.fail("The required records does not exist in UI");
		}
	String Query2="select StateAbbr,CMSCountyCode from [dbo].[StgManagedPlansLoad] where year(planeffectivedate)='strYear'and contractnumber='strContractNumber' and pbpnumber='strPBPNumber'";
	Query2=Query2.replace("strYear", yearDB);
	Query2=Query2.replace("strContractNumber", contractNumberDB);
	Query2=Query2.replace("strPBPNumber", pbpNumberDB);
	System.out.println("Query2==>"+Query2);
	Constants.resultset = Constants.statement.executeQuery(Query2);
	Constants.resultsetMetadata = Constants.resultset.getMetaData();
	for (int m = 1; Constants.resultset.next(); m++) {
		for (int n=1; n<=1; n++) {
			StgStateCountyDB.put(Constants.resultset.getString(n), Constants.resultset.getString(n+1));
		}
	}
	System.out.println(StgStateCountyDB);
	Assert.assertTrue(StgStateCountyUI.equals(StgStateCountyDB), "verify_DB and UI match for stage table");
}		



@When("^click on Add state and provide value to state \"([^\"]*)\" and \"([^\"]*)\" dropdown and click on delete link for some state$")
public void click_on_Add_state_and_provide_value_to_state_and_dropdown_and_click_on_delete_link_for_some_state(String arg1, String arg2) throws Throwable {
	String pathState="";
    String pathCounty="";
    String pathSelectAll="";
    Thread.sleep(4000);
   WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
   for(int i=1;i<=4;i++) {
   	addStateButton.click();
   	Thread.sleep(2000);
   	pathState="//select[contains(@id,'statesOpt"+i+"')]";
   	Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
   	stateDropdown.selectByIndex(i);
   	Thread.sleep(2000);
   	 pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
   	 WebElement countyField=driver.findElement(By.xpath(pathCounty));
   	 countyField.click();
   	pathSelectAll="//input[@data-name='selectAllcountyOpt"+i+"' and @type='checkbox']";
   	WebElement chkSelectAll=driver.findElement(By.xpath(pathSelectAll));
   	chkSelectAll.click();
   	if(i==3) {
   		WebElement deleteLink=driver.findElement(By.xpath("//div[@id='statesMainDiv"+i+"']/a"));
   		deleteLink.click();
   	}
   }
}

@Then("^Validate selected state got deleted$")
public void validate_selected_state_got_deleted() throws Throwable {
	String totalStates="//select[contains(@id,'statesOpt')]";
	List<WebElement> statesList=driver.findElements(By.xpath(totalStates));
	System.out.println("count="+statesList.size());
	if(statesList.size()==3) {
	 	System.out.println("The selected state row got deleted successfully");	
	 }
}

@When("^click on Add state and provide value to state \"([^\"]*)\" and \"([^\"]*)\" dropdown and Add another state\"([^\"]*)\" and \"([^\"]*)\"$")
public void click_on_Add_state_and_provide_value_to_state_and_dropdown_and_Add_another_state_and(String reqState1, String reqCounty1, String reqState2, String reqCounty2) throws Throwable {
  String stateValue=reqState1;
  String pathState="";
  String pathCounty="";
  String pathSelectAll="";
  WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
  Thread.sleep(4000);
  for(int i=1;i<=2;i++) {
  	 addStateButton.click();
  	 Thread.sleep(2000);
  	 pathState="//select[contains(@id,'statesOpt"+i+"')]";
  	 Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
  	 stateDropdown.selectByVisibleText(stateValue);
  	 Thread.sleep(2000);
  	 pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
  	 WebElement countyField=driver.findElement(By.xpath(pathCounty));
  	 countyField.click();
  	 pathSelectAll="//input[@data-name='selectAllcountyOpt"+i+"' and @type='checkbox']";
  	 WebElement chkSelectAll=driver.findElement(By.xpath(pathSelectAll));
  	 chkSelectAll.click();
  }
}

@Then("^verify pop up error message to check duplicate state exist$")
public void verify_pop_up_error_message_to_check_duplicate_state_exist() throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	if(alertMessage.contains("more than once.You cannot enter the same state multiple times")) {
		 System.out.println("Duplicate pop up validation exist");
		 alert.accept();
	 }
}

@When("^click on Create New Managed Plan button\\.$")
public void click_on_Create_New_Managed_Plan_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^validate checkbox copy from (\\d+) is unchecked and dropdown is disabled$")
public void validate_checkbox_copy_from_is_unchecked_and_dropdown_is_disabled(int arg1) throws Throwable {
	WebElement click_copyfrom2018_checkbox= Managed_UI_Pageobjects.click_copyfrom2018_checkbox(driver);
	if(!click_copyfrom2018_checkbox.isSelected()) {
		System.out.println("checkbox copy from 2018 is unchecked by default");
		if(!driver.findElement(By.xpath("//select[@id='ManagedContractPBP']")).isEnabled()) {
			System.out.println("checkbox copy from 2018 dropdown is disabled by default");
		}
	}
}

@When("^Select checkbox copy from (\\d+)$")
public void select_checkbox_copy_from(int arg1) throws Throwable {
	WebElement click_copyfrom2018_checkbox= Managed_UI_Pageobjects.click_copyfrom2018_checkbox(driver);
	click_copyfrom2018_checkbox.click();
	if(driver.findElement(By.xpath("//select[@id='ManagedContractPBP']")).isEnabled()) {
		System.out.println("checkbox copy from 2018 dropdown is enabled on clicking the checkbox");
	}
}

@When("^select \"([^\"]*)\" from copy from (\\d+) dropdown$")
public void select_from_copy_from_dropdown(String reqPlan, int arg2) throws Throwable {
	Select  select_copyfrom2018_dropdown=Managed_UI_Pageobjects.select_copyfrom2018_dropdown(driver);
	select_copyfrom2018_dropdown.selectByVisibleText(reqPlan);
	String [] part=reqPlan.split("-");
	Contract2018=part[0];
	PBP2018=part[1];
	Thread.sleep(4000);
}

@When("^Enter Contract number \"([^\"]*)\" if enabled and not prefilled$")
public void enter_Contract_number_if_enabled_and_not_prefilled(String reqContractNumber) throws Throwable {
	try {
		WebElement elem=Managed_UI_Pageobjects.contractnumber_textfield(driver);
		Contract=reqContractNumber;
		if(elem.isEnabled()) {
			if(elem.getText().equals("")|| elem.getText()==null) {
				elem.sendKeys(reqContractNumber);
			}
			else {
				Contract=elem.getText();
			}
		}
		else {
			Contract=elem.getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Contract Number value");
	}
}

@When("^Enter PBP Number as \"([^\"]*)\" if enabled and not prefilled$")
public void enter_PBP_Number_as_if_enabled_and_not_prefilled(String reqPBPNumber) throws Throwable {
	try {
		WebElement elem=Managed_UI_Pageobjects.pbpnumber_textfield(driver);
		PBP=reqPBPNumber;
		if(elem.isEnabled()) {
			if(elem.getText().equals("")|| elem.getText()==null) {
				elem.sendKeys(reqPBPNumber);
			}
			else {
				PBP=elem.getText();
			}
		}
		else {
			PBP=elem.getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter PBP Number value");
	}
}

@When("^Enter Market Product Name \"([^\"]*)\" if enabled and not prefilled$")
public void enter_Market_Product_Name_if_enabled_and_not_prefilled(String reqMarketProductName) throws Throwable {
	try {
		WebElement elem=Managed_UI_Pageobjects.Marketproductname_textfield(driver);
		MarketProductName=reqMarketProductName;
		if(elem.isEnabled()) {
			if(elem.getText().equals("")|| elem.getText()==null) {
				elem.sendKeys(reqMarketProductName);
			}
			else {
				MarketProductName=elem.getText();
			}
		}
		else {
			MarketProductName=elem.getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Market Product Name value");
	}
}

@When("^Select Producttype \"([^\"]*)\" if enabled and not prefilled$")
public void select_Producttype_if_enabled_and_not_prefilled(String reqProductType) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='ProductType']"));
		Select dropdown=Managed_UI_Pageobjects.select_producttype_dropdown(driver);
		ProductTypeDropDown=reqProductType;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqProductType);
			}
			else {
				ProductTypeDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			ProductTypeDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Product Type value");
	}
}

@When("^Select Bussiness Segment \"([^\"]*)\" if enabled and not prefilled$")
public void select_Bussiness_Segment_if_enabled_and_not_prefilled(String reqBusinessSegment) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='BusinessSegment']"));
		Select dropdown=Managed_UI_Pageobjects.select_Bussiness_Segment_dropdown(driver);
		BussinessSegmentDropDown=reqBusinessSegment;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqBusinessSegment);
			}
			else {
				BussinessSegmentDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			BussinessSegmentDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Bussiness Segment value");
	}
}

@When("^Select Enrolle Type\"([^\"]*)\" if enabled and not prefilled$")
public void select_Enrolle_Type_if_enabled_and_not_prefilled(String reqEnrolleeType) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='EnrolleeType']"));
		Select dropdown=Managed_UI_Pageobjects.select_Enrolle_Type_dropdown(driver);
		EnrolleeTypeDropDown=reqEnrolleeType;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqEnrolleeType);
			}
			else {
				EnrolleeTypeDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			EnrolleeTypeDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Enrollee Type value");
	}
}

@When("^Select SNP Flag \"([^\"]*)\" if enabled and not prefilled$")
public void select_SNP_Flag_if_enabled_and_not_prefilled(String reqSNPFlag) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='SNPFlag']"));
		Select dropdown=Managed_UI_Pageobjects.select_SNP_Flag_dropdown(driver);
		SNPFlagDropDown=reqSNPFlag;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqSNPFlag);
			}
			else {
				SNPFlagDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			SNPFlagDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter SNP Flag value");
	}
}

@When("^Select SNP Type \"([^\"]*)\" if enabled and not prefilled$")
public void select_SNP_Type_if_enabled_and_not_prefilled(String reqSNPType) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='SNPType']"));
		Select dropdown=Managed_UI_Pageobjects.select_SNP_Type_dropdown(driver);
		SNPTypeDropDown=reqSNPType;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqSNPType);
			}
			else {
				SNPTypeDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			SNPTypeDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter SNP Type value");
	}
}

@When("^Select Drug Coverage Type \"([^\"]*)\" if enabled and not prefilled$")
public void select_Drug_Coverage_Type_if_enabled_and_not_prefilled(String reqDrugCoverage) throws Throwable {
	try {
		WebElement elem=driver.findElement(By.xpath("//select[@id='DrugCoverageType']"));
		Select dropdown=Managed_UI_Pageobjects.select_Drugcoveragetype_dropdown(driver);
		DrugCoverageDropDown=reqDrugCoverage;
		if(elem.isEnabled()) {
			if(dropdown.getFirstSelectedOption().getText().equals("") || dropdown.getFirstSelectedOption().getText()==null) {
				dropdown.selectByVisibleText(reqDrugCoverage);
			}
			else {
				DrugCoverageDropDown=dropdown.getFirstSelectedOption().getText();
			}
		}
		else {
			DrugCoverageDropDown=dropdown.getFirstSelectedOption().getText();
		}
	}	
	catch(Exception e) {
		Assert.fail("Failed to enter Drug Coverage value");
	}
}


@Then("^verify total number of states and their counties count on service area screen is equal to (\\d+) values$")
public void verify_total_number_of_states_and_their_counties_count_on_service_area_screen_is_equal_to_values(int arg1) throws Throwable {
	String pathCounty="";
	String currPathState="";
	String selectedState="";
	String currCountyLabel="";
	int countyCount=0;
	String selectAllCheckBoxpath="";
	String totalCheckBoxpath="";
	String [] temp1;
	boolean checkStatus=false;
	String countyText;
	int numberForSelectAll=0;
    WebDriverWait wait = new WebDriverWait(driver,30);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[contains(@id,'statesOpt1')]"))));
	String pathState="//select[contains(@id,'statesOpt')]";
	List<WebElement> statesList=driver.findElements(By.xpath(pathState));
	System.out.println("count="+statesList.size());
	int countState=statesList.size();
	for(int i=1;i<=countState;i++) {
		currPathState="//select[contains(@id,'statesOpt"+i+"')]";
		Select currStateDropdown= new Select(driver.findElement(By.xpath(currPathState)));
		selectedState = currStateDropdown.getFirstSelectedOption().getText();
    	Thread.sleep(1000);
		pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
		WebElement countyField=driver.findElement(By.xpath(pathCounty));
		if(countyField.getText().equals("All selected")) {
			countyField.click();
			selectAllCheckBoxpath="//div[@id='statesMainDiv"+i+"']/div/div/ul/li[1]/label/input";
			WebElement selectAllCheckBox=driver.findElement(By.xpath(selectAllCheckBoxpath));
			checkStatus=selectAllCheckBox.isSelected();
			if(checkStatus) {
				totalCheckBoxpath="//div[@id='statesMainDiv"+i+"']/div/div/ul/li";
				List<WebElement> listOfElements = driver.findElements(By.xpath(totalCheckBoxpath));
				numberForSelectAll=listOfElements.size()-2;
				countyCount=numberForSelectAll;
				countyField.click();
			}
		}
		else {
			countyText=countyField.getText();
			if(countyText.contains(" of ")) {
				temp1=countyText.split(" of ");
				countyCount=Integer.parseInt(temp1[0]);
			}
			else if(countyText.contains(",")) {
				temp1=countyText.split(",");
				countyCount=temp1.length;
			}
			else {
				countyCount=1;
			}
		}
    	OuterHmp1.put(selectedState, countyCount);
	}
	System.out.println(OuterHmp1);
	
	//2018 DB Verification
	String yearDB="";
	String contractNumberDB="";
	String pbpNumberDB="";
	String stateDB="";
	String text="";
	Utils.connectToSqlserverDB();
	for (String key : OuterHmp1.keySet()) {
		DBResult=new ArrayList<String>();
	    System.out.println("Key = " + key);
		yearDB="2018";
		contractNumberDB=Contract2018;
		pbpNumberDB=PBP2018;
		stateDB=key;
		String Query3="select count (*) as stateCountyCount from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.statecode='strState'";
		Query3=Query3.replace("strYear", yearDB);
		Query3=Query3.replace("strContractNumber", contractNumberDB);
		Query3=Query3.replace("strPBPNumber", pbpNumberDB);
		Query3=Query3.replace("strState", stateDB);
		System.out.println("Query3==>"+Query3);
		try {
			Constants.resultset = Constants.statement.executeQuery(Query3);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			for (int k = 1; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBResult.add(Constants.resultset.getString(j));
					text=DBResult.get(0);
				}
			}
		}

		catch (Exception e) {
		Assert.fail("failed to validate UI and DB data");
		}
		OuterHmp2018DB.put(key,Integer.parseInt(text));
		System.out.println(OuterHmp2018DB);
	}
	
	Assert.assertTrue(OuterHmp1.equals(OuterHmp2018DB), "verify_DB and UI match for 2018");	
}

@Then("^verify the county names of one state is equal to that in (\\d+) values for same state$")
public void verify_the_county_names_of_one_state_is_equal_to_that_in_values_for_same_state(int arg1) throws Throwable {
	 String pathCounty="";
		String currPathState="";
		String selectedState="";
		String totalCheckBoxpath="";
		String pathCheckBox="";
		String checkBoxValue="";
		String chk="";
		ArrayList<String> arrList1=new ArrayList<String>();
		HashMap<String,ArrayList<String>> OuterHmp3=new HashMap<String,ArrayList<String>>();
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//select[contains(@id,'statesOpt1')]"))));
		String pathState="//select[contains(@id,'statesOpt')]";
		List<WebElement> statesList=driver.findElements(By.xpath(pathState));
		System.out.println("count="+statesList.size());
		int countState=statesList.size();
		for(int i=1;i<=countState;i++) {
			if(i>1) {
     		break;
     	}
			currPathState="//select[contains(@id,'statesOpt"+i+"')]";
			Select currStateDropdown= new Select(driver.findElement(By.xpath(currPathState)));
			selectedState = currStateDropdown.getFirstSelectedOption().getText();
     	Thread.sleep(1000);
			pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
			WebElement countyField=driver.findElement(By.xpath(pathCounty));
			countyField.click();
			totalCheckBoxpath="//div[@id='statesMainDiv"+i+"']/div/div/ul/li";
			WebElement checkBoxElem;
			List<WebElement> listOfElements = driver.findElements(By.xpath(totalCheckBoxpath));
			for(int h=2;h<listOfElements.size();h++) {
				chk="//*[@id='statesMainDiv"+i+"']/div/div/ul/li["+h+"]/label/input";
				pathCheckBox="//*[@id='statesMainDiv"+i+"']/div/div/ul/li["+h+"]/label/span";
				checkBoxElem=driver.findElement(By.xpath(pathCheckBox));
				checkBoxValue=checkBoxElem.getText();
				if(driver.findElement(By.xpath(chk)).isSelected()) {
					arrList1.add(checkBoxValue);
				}
			}
     	OuterHmp3.put(selectedState,arrList1);
		}
		System.out.println(OuterHmp3);
	
//	//2018 DB Verification for list of counties for one state
	String yearDB="";
	String contractNumberDB="";
	String pbpNumberDB="";
	String stateDB="";
	Utils.connectToSqlserverDB();
	for (String key : OuterHmp3.keySet()) {
		DBResult4=new ArrayList<String>();
	    System.out.println("Key = " + key);
		yearDB="2018";
		contractNumberDB=Contract2018;
		pbpNumberDB=PBP2018;
		stateDB=key;
		String Query6="select CMSName from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.statecode='strState'";
		Query6=Query6.replace("strYear", yearDB);
		Query6=Query6.replace("strContractNumber", contractNumberDB);
		Query6=Query6.replace("strPBPNumber", pbpNumberDB);
		Query6=Query6.replace("strState", stateDB);
		System.out.println("Query3==>"+Query6);
		try {
			Constants.resultset = Constants.statement.executeQuery(Query6);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			for (int k = 1; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBResult4.add(Constants.resultset.getString(j));
				}
			}
		}
		catch (Exception e) {
		Assert.fail("failed to validate UI and DB data");
		}
		OuterHmp2018DBCounty.put(key,DBResult4);
		System.out.println(OuterHmp2018DBCounty);
	}
	Assert.assertTrue(OuterHmp3.equals(OuterHmp2018DBCounty), "verify_DB and UI county names match for 2018");	
}

@Then("^both year values in DB for state and county are same$")
public void both_year_values_in_DB_for_state_and_county_are_same() throws Throwable {
	//2019 Stage DB Verification
		String yearDB="";
		String contractNumberDB="";
		String pbpNumberDB="";
		String stateDB="";
		String text;
		String [] splitPart;
		int len=0;
		Utils.connectToSqlserverDB();
		for (String key : OuterHmp1.keySet()) {
			DBResult2=new ArrayList<String>();
		    System.out.println("Key = " + key);
			yearDB=year;
			contractNumberDB=Contract;
			pbpNumberDB=PBP;
			stateDB=key;
			String Query4="select CMSCountyCode from [dbo].[StgManagedPlansLoad] where year(planeffectivedate)='strYear' and contractnumber='strContractNumber' and pbpnumber='strPBPNumber' and StateAbbr='strState'";
			Query4=Query4.replace("strYear", yearDB);
			Query4=Query4.replace("strContractNumber", contractNumberDB);
			Query4=Query4.replace("strPBPNumber", pbpNumberDB);
			Query4=Query4.replace("strState", stateDB);
			System.out.println("Query3==>"+Query4);
			try {
				Constants.resultset = Constants.statement.executeQuery(Query4);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				for (int k = 1; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBResult.add(Constants.resultset.getString(j));
						for(int g=0;g<DBResult.size();g++) {
							text=DBResult.get(g);
							splitPart=text.split(",");
							len=splitPart.length;
						}
					}
				}
			}

			catch (Exception e) {
			Assert.fail("failed to validate UI and DB data");
			}
			OuterHmp2019StageDB.put(key,len);
			System.out.println(OuterHmp2019StageDB);
		}
		
		Assert.assertTrue(OuterHmp1.equals(OuterHmp2019StageDB), "verify_DB and UI match for 2019 Stage Table");
		
		//2019 DB0 Verification
		String text2="";
		Utils.connectToSqlserverDB();
		for (String key : OuterHmp1.keySet()) {
			DBResult3=new ArrayList<String>();
		    System.out.println("Key = " + key);
			yearDB=year;
			contractNumberDB=Contract;
			pbpNumberDB=PBP;
			stateDB=key;
			String Query5="select count (*) as stateCountyCount from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.statecode='strState'";
			Query5=Query5.replace("strYear", yearDB);
			Query5=Query5.replace("strContractNumber", contractNumberDB);
			Query5=Query5.replace("strPBPNumber", pbpNumberDB);
			Query5=Query5.replace("strState", stateDB);
			System.out.println("Query3==>"+Query5);
			try {
				Constants.resultset = Constants.statement.executeQuery(Query5);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				for (int k = 1; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBResult3.add(Constants.resultset.getString(j));
						text2=DBResult3.get(0);
					}
				}
			}

			catch (Exception e) {
			Assert.fail("failed to validate UI and DB data");
			}
			OuterHmp2019DB.put(key,Integer.parseInt(text2));
			System.out.println(OuterHmp2019DB);
		}
		Assert.assertTrue(OuterHmp1.equals(OuterHmp2019DB), "verify_DB and UI match for 2019 DBO Table");
	}

@When("^click on Add state and provide value to state \"([^\"]*)\" dropdown and \"([^\"]*)\" from county dropdowns$")
public void click_on_Add_state_and_provide_value_to_state_dropdown_and_from_county_dropdowns(String states, String counties) throws Throwable {
    int tempStateCount=0;
	String pathState="";
	String pathCounty="";
	String selectedState="";
	String totalCheckBoxpath="";
	String[] arrayState= states.split(",");
	Thread.sleep(4000);
	String[] arrayCounties= counties.split("_");
	String [] perStateCounty;
	String chk="";
	String pathCheckBox="";
	String checkBoxValue="";
	Thread.sleep(2000);
	tempStateCount=arrayState.length;
  for(int i=1;i<=tempStateCount;i++) {
  	ArrayList<String> arrList2 = new ArrayList<String>(); 
  	WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
  	addStateButton.click();
//  	Thread.sleep(2000);
  	pathState="//select[contains(@id,'statesOpt"+i+"')]";
  	Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
//  	Thread.sleep(2000);
  	stateDropdown.selectByVisibleText(arrayState[i-1]);
  	selectedState = stateDropdown.getFirstSelectedOption().getText();
//  	Thread.sleep(2000);
  	 pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
      WebElement county=driver.findElement(By.xpath(pathCounty));
      county.click();
//      Utils.click(driver, county);
      totalCheckBoxpath="//div[@id='statesMainDiv"+i+"']/div/div/ul/li";
		WebElement checkBoxElem;
		perStateCounty=arrayCounties[i-1].split(",");
		List<WebElement> listOfElements = driver.findElements(By.xpath(totalCheckBoxpath));
		for(int h=2;h<listOfElements.size();h++) {
			chk="//*[@id='statesMainDiv"+i+"']/div/div/ul/li["+h+"]/label/input";
			pathCheckBox="//*[@id='statesMainDiv"+i+"']/div/div/ul/li["+h+"]/label/span";
			checkBoxElem=driver.findElement(By.xpath(pathCheckBox));
			checkBoxValue=checkBoxElem.getText();
			for(int k=0;k<perStateCounty.length;k++) {
				if(checkBoxValue.equals(perStateCounty[k])) {
					driver.findElement(By.xpath(chk)).click();				
					arrList2.add(checkBoxValue);
				}
			}
    }
		System.out.println(arrList2);
  	OuterHmp5.put(selectedState,arrList2);
}
  System.out.println(OuterHmp5);
  
	}		

@Then("^verify UI and DB values are matching for counties$")
public void verify_UI_and_DB_values_are_matching_for_counties() throws Throwable {
	//2019 DB0 Verification
		TreeMap<String,ArrayList<String>> OuterHmp2019DBOCounty=new TreeMap<String,ArrayList<String>>();
		String yearDB="";
		String contractNumberDB="";
		String pbpNumberDB="";
		String stateDB="";
		Utils.connectToSqlserverDB();
		for (String key : OuterHmp5.keySet()) {
			DBResult5=new ArrayList<String>();
		    System.out.println("Key = " + key);
			yearDB=year;
			contractNumberDB=Contract;
			pbpNumberDB=PBP;
			stateDB=key;
			String Query7="select CMSName from [contract] c inner join [plan] p on c.contractid = p.contractid inner join plancounty pc on pc.planid = p.planid inner join county ct on pc.countyid = ct.countyid inner join [state] s on s.stateid = ct.stateid where year(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber' and s.statecode='strState'";
			Query7=Query7.replace("strYear", yearDB);
			Query7=Query7.replace("strContractNumber", contractNumberDB);
			Query7=Query7.replace("strPBPNumber", pbpNumberDB);
			Query7=Query7.replace("strState", stateDB);
			System.out.println("Query7==>"+Query7);
			try {
				Constants.resultset = Constants.statement.executeQuery(Query7);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				for (int k = 1; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBResult5.add(Constants.resultset.getString(j));
					}
				}
			}
			catch (Exception e) {
			Assert.fail("failed to validate UI and DB data");
			}
			OuterHmp2019DBOCounty.put(key,DBResult5);
			System.out.println(OuterHmp5);
			System.out.println(OuterHmp2019DBOCounty);
		}
		Assert.assertTrue(OuterHmp5.equals(OuterHmp2019DBOCounty), "verify_DB and UI match for 2019 DBO Table");
		
		//------------------Staging table validation
		TreeMap<String,String> StgStateCountyUICounty=new TreeMap<String,String>();
		TreeMap<String,String> StgStateCountyDBCounty=new TreeMap<String,String>();
		String reqStateCode;
		String reqCMSCountyCode;
		Utils.click(driver, Managed_UI_Pageobjects.click_ManagedPlanSetup_link(driver));
		Thread.sleep(2000);
		Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(yearDB);
		Managed_UI_Pageobjects.contractnumber_textfield(driver).sendKeys(contractNumberDB);
		Managed_UI_Pageobjects.pbpnumber_textfield(driver).sendKeys(pbpNumberDB);
		Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
		Thread.sleep(4000);
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		if(tableRows.size()>0) {
			for(int i=1;i<=tableRows.size();i++) {
				reqStateCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[4]")).getText();
				reqCMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[5]")).getText();
				StgStateCountyUICounty.put(reqStateCode,reqCMSCountyCode);
			}
			System.out.println(StgStateCountyUICounty);
		}
		else {
			Assert.fail("The required records does not exist in UI");
			}
		String Query8="select StateAbbr,CMSCountyCode from [dbo].[StgManagedPlansLoad] where year(planeffectivedate)='strYear'and contractnumber='strContractNumber' and pbpnumber='strPBPNumber'";
		Query8=Query8.replace("strYear", yearDB);
		Query8=Query8.replace("strContractNumber", contractNumberDB);
		Query8=Query8.replace("strPBPNumber", pbpNumberDB);
		System.out.println("Query8==>"+Query8);
		Constants.resultset = Constants.statement.executeQuery(Query8);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		for (int m = 1; Constants.resultset.next(); m++) {
			for (int n=1; n<=1; n++) {
				StgStateCountyDBCounty.put(Constants.resultset.getString(n), Constants.resultset.getString(n+1));
			}
		}
		System.out.println(StgStateCountyDBCounty);
		Assert.assertTrue(StgStateCountyUICounty.equals(StgStateCountyDBCounty), "verify_DB and UI match for stage table");
}

@When("^click on create button without adding any state and county$")
public void click_on_create_button_without_adding_any_state_and_county() throws Throwable {
	Managed_UI_Pageobjects.createButton(driver).click();
	Thread.sleep(5000);
}

@Then("^Pop up validation with message to add atleast one state and county should appear$")
public void pop_up_validation_with_message_to_add_atleast_one_state_and_county_should_appear() throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	if(alertMessage.contains("Please add at least one state row to create managed plan")) {
		 System.out.println("pop up validation exist");
		 alert.accept();
	 }
}

@When("^click on create button by adding data row without selecting a state and county$")
public void click_on_create_button_by_adding_data_row_without_selecting_a_state_and_county() throws Throwable {
	WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
	addStateButton.click();
	Thread.sleep(3000);
	Managed_UI_Pageobjects.createButton(driver).click();
	Thread.sleep(5000);
}

@Then("^Pop up validation with message to select state should appear$")
public void pop_up_validation_with_message_to_select_state_should_appear() throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	if(alertMessage.contains("Please select the state value in the state dropdown")) {
		 System.out.println("pop up validation exist");
		 alert.accept();
	 }
}

@When("^click on create button by selecting any state and without any county$")
public void click_on_create_button_by_selecting_any_state_and_without_any_county() throws Throwable {
	  String pathState="";
//	  WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
//	  Thread.sleep(4000);
//  	  addStateButton.click();
//  	  Thread.sleep(2000);
  	  pathState="//select[contains(@id,'statesOpt1')]";
  	  Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
  	  stateDropdown.selectByIndex(1);
  	  Thread.sleep(2000);
  	  Managed_UI_Pageobjects.createButton(driver).click();
	  Thread.sleep(5000);
}

@Then("^Pop up validation with message to select atleast one county should appear$")
public void pop_up_validation_with_message_to_select_atleast_one_county_should_appear() throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	if(alertMessage.contains("Please select at least once county for the state")) {
		 System.out.println("pop up validation exist");
		 alert.accept();
	 }
}

@When("^click on create button by selecting a state with county and add another data without any state and county values$")
public void click_on_create_button_by_selecting_a_state_with_county_and_add_another_data_without_any_state_and_county_values() throws Throwable {
	  String pathState="";
	  String pathCounty="";
	  String pathSelectAll="";
	  WebElement addStateButton=driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
	  Thread.sleep(4000);
	  for(int i=1;i<=2;i++) {
	  	 Thread.sleep(2000);
	  	 pathState="//select[contains(@id,'statesOpt"+i+"')]";
	  	 Select stateDropdown= new Select(driver.findElement(By.xpath(pathState)));
	  	 stateDropdown.selectByIndex(i);
	  	 Thread.sleep(2000);
	  	 if(i==1) {
	  		 pathCounty="//*[@id='statesMainDiv"+i+"']/div/button";
		  	 WebElement countyField=driver.findElement(By.xpath(pathCounty));
		  	 countyField.click();
		  	 pathSelectAll="//input[@data-name='selectAllcountyOpt"+i+"' and @type='checkbox']";
		  	 WebElement chkSelectAll=driver.findElement(By.xpath(pathSelectAll));
		  	 chkSelectAll.click(); 
		  	 addStateButton.click();
	  	 }
	  }
	  Managed_UI_Pageobjects.createButton(driver).click();
	  Thread.sleep(5000);
	}

}