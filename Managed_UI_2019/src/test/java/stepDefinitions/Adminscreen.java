//package stepDefinitions;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.testng.Assert;
//
//import pageObjects.Admin_pageobjects;
//import utilities.Utils;
//
//public class Adminscreen {
//	static WebDriver driver;
//	public void Steps_Configuration_Contact_dropdown() {
//		this.driver = Hooks.driver;
//	}
//
//	@Given("^Login to the Maps UI and click on admin\\.$")
//	public void login_to_the_Maps_UI_and_click_on_admin() throws Throwable {
//		Admin_pageobjects.adminlink().click();
//		Thread.sleep(5000);
//	}
//
//	@Given("^click on groupadmin click\\.$")
//	public void click_on_groupadmin_click() throws Throwable {
//	    try {
//	    	Admin_pageobjects.Groupadminlink().click();
//	    	//Utils.click(driver, Admin_pageobjects.Groupadminlink());
//	    }
//	    catch(Exception e){
//	    	Assert.fail("failed to click on groupadmin");
//	    }
//	}
//
//	@Then("^verify group admin screen is dispalyed\\.$")
//	public void verify_group_admin_screen_is_dispalyed() throws Throwable {
//	    try {
//	    	Assert.assertTrue(Admin_pageobjects.VerifyGroupadminscreen().isDisplayed());
//	    	
//		    }
//	    catch(Exception e){
//	    	Assert.fail("Failed to verify group admin screen is dispalyed");
//	    }
//	}
//
//	@Then("^Select the Grouptype \"([^\"]*)\" from dropdown\\.$")
//	public void select_the_Grouptype_from_dropdown(String GroupType) throws Throwable {
//		try {
//		Admin_pageobjects.selectgrouptype().selectByVisibleText(GroupType);
//		}
//		catch(Exception e) {
//			Assert.fail("Failed to select the grouptype");
//		}
//	}
//
//	@Then("^Select Year \"([^\"]*)\" from dropdown\\.$")
//	public void select_Year_from_dropdown(String Year) throws Throwable {
//		try {
//			Admin_pageobjects.selectyear().selectByVisibleText(Year);
//		}
//		catch(Exception e) {
//			Assert.fail("Failed to select the year");
//		}
//	    
//	}
//
//	@Then("^Enter MasterGroupNumber\"([^\"]*)\" in text field\\.$")
//	public void enter_MasterGroupNumber_in_text_field(String MasterGroupNumber) throws Throwable {
//		Admin_pageobjects.Mastergroupnumber().sendKeys(MasterGroupNumber);
//	}
//
//	@Then("^Enter the PBP \"([^\"]*)\" in text field\\.$")
//	public void enter_the_PBP_in_text_field(String PBP) throws Throwable {
//		Admin_pageobjects.PBPNumber().sendKeys(PBP);
//	}
//
//	@Then("^Select claims system \"([^\"]*)\" from dropdown\\.$")
//	public void select_claims_system_from_dropdown(String ClaimsSystem) throws Throwable {
//		Admin_pageobjects.Claimssystem().selectByVisibleText(ClaimsSystem);
//	}
//
//	@Then("^Enter GroupNumber \"([^\"]*)\" in text field\\.$")
//	public void enter_GroupNumber_in_text_field(String GroupNumber) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		Admin_pageobjects.Groupnumber().sendKeys(GroupNumber);
//	}
//
//	@Then("^Enter Contract\"([^\"]*)\" in text field\\.$")
//	public void enter_Contract_in_text_field(String Contract) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		Admin_pageobjects.Contractnumber().sendKeys(Contract);
//	}
//	@Then("^Enter SiteName\"([^\"]*)\"$")
//	public void enter_SiteName(String SiteName) throws Throwable {
//	  
//	    Admin_pageobjects.sitename().selectByVisibleText(SiteName);
//	}
//
//	@When("^Click on search Groups\\.$")
//	public void click_on_search_Groups() throws Throwable {
//		Admin_pageobjects.clickonsearch_button().click();
//		Thread.sleep(5000);
//	    
//	}
//
//	@Then("^Click on Edit link\\.$")
//	public void click_on_Edit_link() throws Throwable {
//	   Admin_pageobjects.clickonedit().click();
//	   Thread.sleep(5000);
//	}
//
//
//
//	@Then("^Click on terminationdate checkbox\\.$")
//	public void click_on_terminationdate_checkbox() throws Throwable {
//		Admin_pageobjects.clickonterminationdate_ckeckbox().click();
//	}
//
//	@Then("^Edit terminatiom date\"([^\"]*)\"\\.$")
//	public void edit_terminatiom_date(String terminationdate) throws Throwable {
//		//Admin_pageobjects.Enter_Terminationdate().clear();
//		//System.out.println();
//		//((JavascriptExecutor)driver).executeScript("arguments[0].value = 'terminationdate'",Admin_pageobjects.Enter_Terminationdate());
//		Admin_pageobjects.Enter_Terminationdate().sendKeys(terminationdate);
//		Thread.sleep(5000);
//	}
//
//	@Then("^click on rxvendor checkbox and clear the text textfield\\.$")
//	public void click_on_rxvendor_checkbox_and_clear_the_text_textfield() throws Throwable {
//		
//		Admin_pageobjects.clickonrxvendor().click();
//	}
//
//	@Then("^Edit rxvendor\"([^\"]*)\"\\.$")
//	public void edit_rxvendor(String rxvendor) throws Throwable {
//		Admin_pageobjects.Enterrxvendor().clear();
//		Admin_pageobjects.Enterrxvendor().sendKeys(rxvendor);
//	}
//
//	@When("^click on save\\.$")
//	public void click_on_save() throws Throwable {
//		Admin_pageobjects.clickonsave().click();
//		 
//	}
//
//	@Then("^Verify the alert is displayed and click on ok\\.$")
//	public void verify_the_alert_is_displayed_and_click_on_ok() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		Alert al= driver.switchTo().alert();
//	    System.out.println(al.getText());
//	    al.accept();
//	Thread.sleep(3000);
//	   
//	  
//	}
//}
