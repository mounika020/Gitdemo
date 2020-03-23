package stepDefinitions;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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


public class Steps_Configuration_ManagedUI_SearchScreen_PublicAndSecure {
	static WebDriver driver;
	public static int numRec=0;
	String planType="";
	String planName="";
	String contractNumber="";
	String pbpNumber="";
	String year="";
	HashMap<Integer, HashMap<String, String>> OuterHmp = new HashMap<Integer, HashMap<String,String>>();
	HashMap<Integer, HashMap<String, String>> OuterHmp2 = new HashMap<Integer, HashMap<String,String>>();
	LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
	HashMap<String, String> InnerHmp;
	HashMap<String, String> InnerHmp2;
	String[] arrayDetails;

	public Steps_Configuration_ManagedUI_SearchScreen_PublicAndSecure() {
		this.driver = Hooks.driver;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}
	

@Given("^Login to the Maps UI and click on Managed plan UI link$")
public void login_to_the_Maps_UI_and_click_on_Managed_plan_UI_link() throws Throwable {
	
	try {
		Utils.click(driver,Managed_UI_Pageobjects.click_Plan_link(driver));
		Thread.sleep(2000);
		Utils.click(driver,Managed_UI_Pageobjects.click_ManagedPlanSetup_link(driver));
	     }
	catch(Exception e)
	{
		Assert.fail("Failed to click on Manage Plan Setup link");
	}
}

@When("^Managed plan search screen will be displayed$")
public void managed_plan_search_screen_will_be_displayed() throws Throwable {
	
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).isDisplayed(), "Verify_Create_Managed_Plan_Screen");
		
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify Managed plan search screen ");
		  }
}

@When("^Select Year \"([^\"]*)\" from the dropdown and Contract number as \"([^\"]*)\"$")
public void select_Year_from_the_dropdown_and_Contract_number_as(String year, String contractNumber) throws Throwable {
	
		try	{			
			Thread.sleep(2000);
			Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(year);
//			if(contractNumber.equalsIgnoreCase("null"))
//			{
//				Managed_UI_Pageobjects.Enter_contractnumber_textfield(driver).sendKeys("null");
//			}
//			else {
//				Managed_UI_Pageobjects.Enter_contractnumber_textfield(driver).sendKeys(contractNumber);
//			}
	}
	catch(Exception e){
		Assert.fail("Failed to select the year and contact on the screen");
	}

}

@When("^Click on Search Plans button$")
public void click_on_Search_Plans_button() throws Throwable {
	try {
		Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Managed_UI_Pageobjects.click_on_edit(driver)));
	}
	catch(Exception e) {
		Assert.fail("Failed to click on Search button");
	}
}

@Then("^data is displayed in result table and make selected item secure button and make selected item public button are displayed$")
public void data_is_displayed_in_result_table_and_make_selected_item_secure_button_and_make_selected_item_public_button_are_displayed() throws Throwable {
	Thread.sleep(10000);
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	try {
	if(tableRows.size()>1) {
		Assert.assertTrue(tableRows.size()>1, "data is displayed in search results");}
		else 
		{
			Assert.fail("Failed as data is not displayed in search results");
		}
		Assert.assertTrue(Managed_UI_Pageobjects.makeSelectedItemPublic_button(driver).isDisplayed(), "Verify_makeSelectedItemPublic_button is displayed");
		Assert.assertTrue(Managed_UI_Pageobjects.makeSelectedItemSecure_button(driver).isDisplayed(), "Verify_makeSelectedItemSecure_button is displayed");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify makeSelectedItem Public/Secure button");
		  }
	}


@Then("^select (\\d+) where status is \"([^\"]*)\"$")
public void select_where_status_is(int numerOfRecords, String currentStatus) throws Throwable {
	numRec=numerOfRecords;
	arrayDetails=new String[numRec];
	String PlanDetail="";
	int selectedRow=0;
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	try {
		if(tableRows.size()<numerOfRecords) {
			Assert.assertTrue(tableRows.size()<numerOfRecords, "Table does not contains required number of records");}
			else 
			{
				int keyOuter1=1;
			   for(int i=1;i<tableRows.size();i++)
			   {
		        	if(driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[10]")).getText().equalsIgnoreCase(currentStatus))
		        	{
		        		InnerHmp = new HashMap<String, String>();
			        	WebElement checkboxObj=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[1]/input"));
			        	PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[2]")).getText();
			        	arrayDetails[selectedRow]=PlanDetail;
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
						InnerHmp.put("year", year);
						InnerHmp.put("contractNumber", contractNumber);
						InnerHmp.put("pbpNumber", pbpNumber);
						InnerHmp.put("planType", planType);
						InnerHmp.put("planName", planName);
						OuterHmp.put(keyOuter1,InnerHmp);
						keyOuter1++;
			        	checkboxObj.click();
			        	selectedRow++;
			        	if(selectedRow==numerOfRecords) {
			        		break;
			        	}
		        	}
			   }
			}
	}
		 catch(Exception e) 
			{
				Assert.fail("Failed to select records from the table");
			  }
	}

@Then("^click on \"([^\"]*)\" button$")
public void click_on_button(String conversionType) throws Throwable {
	if(conversionType.equalsIgnoreCase("make selected item Secure")) {
		Managed_UI_Pageobjects.makeSelectedItemSecure_button(driver).click();
		}
	else if(conversionType.equalsIgnoreCase("make selected item Public")) {
		Managed_UI_Pageobjects.makeSelectedItemPublic_button(driver).click();
	}
}

@Then("^verify confirmation pop up window to mark plan as \"([^\"]*)\" is displayed$")
public void verify_confirmation_pop_up_window_to_mark_plan_as_is_displayed(String expectedStatus) throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	  switch(expectedStatus) {
      case "Secure" :
         Assert.assertTrue(alertMessage.equalsIgnoreCase("Are you sure you want to Mark these records Secure"), "Are you sure you want to Mark these records Secure is displayed");
         break;
      case "Public" :
    	 Assert.assertTrue(alertMessage.equalsIgnoreCase("Are you sure you want to Mark these records Public?"), "Are you sure you want to Mark these records Pubic is displayed");
    	  break;
      default :
    	  Assert.fail("Mark these records Public/Secure Pop up validation failed");  
	  }
}

@Then("^click on ok button$")
public void click_on_ok_button() throws Throwable {
	try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
	catch(Exception e) {
		Assert.fail("Failed to click on ok button"); 
	}
}

@Then("^The following plans will be Marked \"([^\"]*)\" screen is displayed$")
public void the_following_plans_will_be_Marked_screen_is_displayed(String expectedStatus) throws Throwable {
	Thread.sleep(4000);
	switch(expectedStatus) {
    case "Secure" :
       Assert.assertTrue(Managed_UI_Pageobjects.Verify_Marked_Secure_text(driver).isDisplayed(), "Label The following plans will be Marked Secure is displayed");
       break;
    case "Public" :
  	 Assert.assertTrue(Managed_UI_Pageobjects.Verify_Marked_Public_text(driver).isDisplayed(), "Label The following plans will be Marked Pubic is displayed");
  	  break;
    default :
  	  Assert.fail("Label The following plans will be Marked Pubic/Secure is not displayed");  
	  }
}


@Then("^verify both plans selected are present on the page$")
public void verify_both_plans_selected_are_present_on_the_page() throws Throwable {
	Thread.sleep(4000);
	String planType="";
	String planName="";
	String contractNumber="";
	String pbpNumber="";
	String year="";
	List<WebElement> tableRowsConfirmPage=driver.findElements(By.xpath("//table[@class='table table-striped']//tr"));
	Assert.assertTrue(tableRowsConfirmPage.size()-1==numRec, "Total rows on confimation page are same");
	int keyOuter2=1;
	for(int j=1;j<tableRowsConfirmPage.size();j++) {
		InnerHmp2 = new HashMap<String, String>();
		planName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+j+"]/td[1]")).getText();
		contractNumber=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+j+"]/td[2]")).getText();
		pbpNumber=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+j+"]/td[3]")).getText();
		planType=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+j+"]/td[4]")).getText();
		year=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+j+"]/td[5]")).getText();
		InnerHmp2.put("year", year);
		InnerHmp2.put("contractNumber", contractNumber);
		InnerHmp2.put("pbpNumber", pbpNumber);
		InnerHmp2.put("planType", planType);
		InnerHmp2.put("planName", planName);
		OuterHmp2.put(keyOuter2,InnerHmp2);
		keyOuter2++;
	}
	int matchCount=0;
	for(int k=1;k<tableRowsConfirmPage.size();k++) {
	if(OuterHmp.get(k).equals(OuterHmp2.get(k))) {
		matchCount=matchCount+1;
		}
	}
	System.out.println(OuterHmp);
	System.out.println(OuterHmp2);
	Assert.assertTrue(matchCount==numRec, "Data on confirmation page matched the expected data");
}

@Then("^click on \"([^\"]*)\"$")
public void click_on(String transaction) throws Throwable {
	switch(transaction) {
    case "Submit Records" :
    	Utils.click(driver,Managed_UI_Pageobjects.submitRecords_button(driver));
       break;
    case "Cancel" :
    	Utils.click(driver,Managed_UI_Pageobjects.click_cancel_button(driver));
  	  break;
    default :
  	  Assert.fail("Failed to click Submit Record or Cancel button");  
	  }
}

@Then("^verify Managed plan search screen is displayed$")
public void verify_Managed_plan_search_screen_is_displayed() throws Throwable {
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).isDisplayed(), "Verify_Create_Managed_Plan_Screen");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify Managed plan search screen ");
		  }
}


@Then("^the status of above plans should be \"([^\"]*)\" in UI$")
public void the_status_of_above_plans_should_be_in_UI(String actualStatus) throws Throwable {
	String PlanDetail2="";
	String currStatus="";
	int temp=0;
	Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(year);
	Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
	Thread.sleep(4000);
	List<WebElement> tableRows2=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	for(int m=1;m<tableRows2.size();m++) {
		PlanDetail2=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+m+"]/td[2]")).getText();
		if(arrayDetails[temp].equalsIgnoreCase(PlanDetail2)) {
			currStatus=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+m+"]/td[10]")).getText();
			if(currStatus.equalsIgnoreCase(actualStatus)) {
				Assert.assertTrue(currStatus.equalsIgnoreCase(actualStatus), "The status of Plan Detials="+PlanDetail2+" matched in UI");
				temp=temp+1;
				if(temp==numRec) {
					break;
				}
			}
			else {
				Assert.fail("The status of Plan Detials="+PlanDetail2+" did not matched in UI");
			}
		}
	}
}

@Then("^validate the DB value for isActive flag is (\\d+)$")
public void validate_the_DB_value_for_isActive_flag_is(int flag) throws Throwable {
	String flaginDB="";
	int intFlagDB;
	Utils.connectToSqlserverDB();
	for(int n=1;n<=numRec;n++) {
		year=OuterHmp2.get(n).get("year");
		contractNumber=OuterHmp2.get(n).get("contractNumber");
		pbpNumber=OuterHmp2.get(n).get("pbpNumber");
		String Query="select p.IsActive from [contract] c inner join [plan] p on c.contractid = p.contractid where(p.effectivedate)='strYear' and c.contractnumber='strContractNumber' and p.pbpnumber='strPBPNumber'";
		Query=Query.replace("strYear", year);
		Query=Query.replace("strContractNumber", contractNumber);
		Query=Query.replace("strPBPNumber", pbpNumber);
		System.out.println("Query==>"+Query);
		try {
			Constants.resultset = Constants.statement.executeQuery(Query);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			for (int k = 1; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
			}
			System.out.println(DBresults);
		}
		catch (Exception e) {
		Assert.fail("failed to compare UI search results with database");
		}
	
	for (String value : DBresults.values()) {
		if (value != null)
			flaginDB=value;
			intFlagDB=Integer.parseInt(flaginDB);
			switch(flag) {
		      case 0 :
		    	  Assert.assertTrue(intFlagDB==flag, "isActive flag value in DB is 0=Secure | Which is as Expected" );
		         break;
		      case 1 :
		    	  Assert.assertTrue(intFlagDB==flag, "isActive flag value in DB is 1=Private | Which is as Expected" );
		    	  break;
		      default :
		    	  Assert.fail("isActive Flag validation in DB failed");  
			}
		  }
		}
	}
}
	
