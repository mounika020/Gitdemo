package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Managed_UI_Pageobjects {
 
	public static WebElement click_Plan_link(WebDriver driver)
	{
		return driver.findElement(By.xpath("//a[contains(text(),'Plan')]"));
	}
	
	public static WebElement click_ManagedPlanSetup_link(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Managed Plan Setup')]"));
		
	}
	public static WebElement Create_New_Manged_plan_link(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@id='mass-edit-button']"));
		
	}
	public static WebElement Verify_Managed_plan_search(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'Managed Plan Search')]"));
		
	}
	public static WebElement Verify_Create_New_Managed_plan_screen(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'Create Managed Plan')]"));
		
	}
	public static WebElement Verify_StateandCounty_text(WebDriver driver) {
		return driver.findElement(By.xpath("//h3[contains(text(),'State and County data entered on next screen')]"));
		
	}
	public static Select select_planyear_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
		
	}
	public static WebElement Enter_contractnumber_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='ContractNumber']"));
	}
	
	public static WebElement contractnumber_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='ContractNumber']"));
		
	}
	public static WebElement Enter_pbpnumber_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
		
	}
	public static WebElement pbpnumber_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
		
	}
	public static WebElement Enter_Marketproductname_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='MarketProductName']"));
	}
	
	public static WebElement Marketproductname_textfield(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='MarketProductName']"));
	}
	
	public static Select Marketproductname_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='MarketProductName' and @name='MarketProductName']")));
    }
	
	public static Select select_producttype_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='ProductType']")));
    }
	
	public static Select select_Bussiness_Segment_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='BusinessSegment']")));
		
	}
	public static Select select_Enrolle_Type_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='EnrolleeType']")));
		
	}
	public static Select select_SNP_Flag_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='SNPFlag']")));
		
	}
	public static Select select_SNP_Type_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='SNPType']")));
		
	}
	public static Select select_Drugcoveragetype_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='DrugCoverageType']")));
		
	}
	public static WebElement click_Next_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='btnNext']"));
		
	}
	public static WebElement click_cancel_button(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
		
	}
	public static WebElement click_copyfrom2018_checkbox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='chkcopyYearData']"));
		
	}
	public static Select select_copyfrom2018_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='ManagedContractPBP']")));
	}
	
	public static WebElement verify_planyear_label(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Plan Year')]"));
	}
	public static WebElement verify_contract_label(WebDriver driver) {
		return driver.findElement(By.xpath("//div[contains(text(),'Contract')]"));
		
	}
	public static WebElement verify_Managed_area_screen(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),' Managed Plan Area')]"));
		
	}
	public static WebElement click_searchPlan_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='SearchPlanButton']"));
	}
	
	public static WebElement makeSelectedItemPublic_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='btnDeactivate']"));
	}

	public static WebElement makeSelectedItemSecure_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='btnActivate']"));
	}
	
	public static WebElement Verify_Marked_Secure_text(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'The following plans will be Marked Secure')]"));
	}
	
	public static WebElement Verify_Marked_Public_text(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),'The following plans will be Marked Public')]"));
	}
	
	public static WebElement submitRecords_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='Submit Records']"));
	}
	
	public static WebElement click_county_dropdown(WebDriver driver){
		return driver.findElement(By.xpath("//input[@class='multiselect-input']"));
	}

	public static WebElement verify_Contract_PBP_Year_text(WebDriver driver){
		return driver.findElement(By.xpath("//input[@class='input-medium']"));
	}
	
	public static WebElement verify_ManagedPlan_ServiceArea_screen(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[contains(text(),' Service Area')]"));
	}
	
	public static WebElement click_AddStateButton(WebDriver driver){
//		return driver.findElement(By.xpath("//button[@id='btnAddState']"));
		return driver.findElement(By.xpath("//img[@alt='New' and @id='btnAddState']"));
	}
	
	public static WebElement createButton(WebDriver driver){
		return driver.findElement(By.xpath("//input[(@id='btnCreate') and (@value='Create')]"));
	}
	
	public static WebElement select_checkbox(WebDriver driver,String county) {
		return driver.findElement(By.xpath("//span[contains(text(),'"+county+"')]"));
	}
	
	public static Select select_State_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='statesOpt1']")));
	}
	
	public static WebElement select_County_dropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='countyOpt1_input' and @class='multiselect-input']"));
	}
	
	public static WebElement selectAll_checkbox(WebDriver driver) {
		return driver.findElement(By.xpath("//div[@id='countyOpt1_itemList']//span//label//input[@type='checkbox' and @data-val='-1']"));
	}
	
	public static WebElement Export_Results_button(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@id='btnPlanUIExport' and @value='Export Results']"));
	}
	
	public static WebElement All_Checkbox(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='checkbox' and @id='checkAll']"));
	}
	
	public static Select select_OrderBy_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='OrderBy' and @class='input-medium']")));
	}
	
	public static WebElement Delete_Link(WebDriver driver)
	{
		return driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
	}
	
	public static Select State_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='State']")));
	}
	
	public static WebElement Add_state_click(WebDriver driver){
		return driver.findElement(By.xpath("//button[@id='btnAddState']"));
	}
	
	public static WebElement Verify_Select_state_dropdown(WebDriver driver){
		return driver.findElement(By.xpath("//select[@id='statesOpt3']"));
	}
	
	public static WebElement Verify_county_dropdown(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='countyOpt1_input']"));
	}
	
	public static Select select_state_dropdown(WebDriver driver) {
		return new Select(driver.findElement(By.xpath("//select[@id='statesOpt1']")));
	}
	
	 public static WebElement select_checkbox_selectall(WebDriver driver) {
			return driver.findElement(By.xpath("//*[@id='countyOpt1_itemList']/span/label/input"));
	}
	 
	 public static WebElement verify_Drugcoveragetype_dropdown_isdisabled(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@id='DrugCoverageType']"));
	}
	 
	 public static WebElement verify_Enrolle_Type_dropdown_isdisabled(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@id='EnrolleeType']"));
	}
	 
	 public static WebElement verify_SNP_Type_dropdown_isdisabled(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@id='SNPType']"));
	}
	 
	 public static WebElement click_ongreybar(WebDriver driver) {
			return driver.findElement(By.xpath("//div[@class='form-actions']"));
	}
	 
	 public static WebElement create_button(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='btnCreate']"));
	 }
	 
	 public static WebElement mass_update_button(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='btnMassUpdate']"));
	}
	 
	 public static List<WebElement> verify_search_results(WebDriver driver, int i) {
			return driver.findElements(By.xpath("//*[@id='grid']/tbody/tr[" + i + "]/td[position()>1and not( position()=last())]"));
	}
	 
	 public static WebElement mass_update_screen(WebDriver driver) {
			return driver.findElement(By.xpath("//h1[contains(text(),' Managed Plan Mass Update')]"));
	}
	 
	 public static List<WebElement> verify_updated_results(WebDriver driver, int i) {
			return driver.findElements(By.xpath("//table[@class='table table-striped table-condensed table-bordered']/tbody/tr[" + i +"]/td"));
	}
	 
	 public static WebElement uncheck_marketproductname_checkbox(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='IsMarketProductNameSelected']"));
	}
	 
	 public static WebElement uncheck_bussinesssegment_checkbox(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='EditBusinessSegment']"));
	}
	 
	 public static WebElement uncheck_snpflag_checkbox(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='EditSNPFlag']"));
	} 
	 
	 public static WebElement update_button(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	 
	 public static WebElement verify_businesssegment_disablemode(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@id='BusinessSegment']"));
	 }
	 
	 public static WebElement verify_SNPFlag_disablemode(WebDriver driver) {
			return driver.findElement(By.xpath("//select[@id='SNPFlag']"));
	}
	 
	 public static WebElement click_on_edit(WebDriver driver) {
			return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[( position()=last())]/a"));
	}
	 
	 public static WebElement verify_editscreen(WebDriver driver) {
			return driver.findElement(By.xpath("//h1[contains(text(),'Managed Plan Edit')]"));
    }
	 
	 public static WebElement click_on_search_button(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='SearchPlanButton']"));
	 }
	 
	 public static WebElement verify_edit_contract_pbp_year(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@class='input-medium']"));
	 }
	 
	 public static WebElement verify_edit_drugcoveragetype(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='DrugCoverageType']"));
	 }
	 
	 public static WebElement verify_edit_producttype(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='ProductType']"));
	}
	 
	 public static WebElement verify_edit_state(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='State']"));
   }
	 
	  public static WebElement uncheck_edit_productname(WebDriver driver) {
			return driver.findElement(By.xpath("//input[@id='EditMarketProductName']"));
   }
	  
	  public static WebElement uncheck_edit_businesssegment(WebDriver driver) {
			return driver.findElement(By.xpath("//*[@id='EditBusinessSegment']"));
	}
	  
	   public static WebElement  uncheck_edit_SNPFlag(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='EditSNPFlag']"));
	}
	   
	   public static WebElement uncheck_edit_Snptype(WebDriver driver) {
			return driver.findElement(By.xpath("//*[@id='EditSNPType']"));
   }
	   
	   public static WebElement  uncheck_edit_enrolletype(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='EditEnrolleeType']"));
   }
	
	   public static WebElement Verify_Managed_plan_edit_screen(WebDriver driver) {
			return driver.findElement(By.xpath("//h1[contains(text(),'Managed Plan Edit')]"));
	}
	
	}
