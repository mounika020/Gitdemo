package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class Groupadmin extends BaseClass {

	public Groupadmin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	
	}
	public static WebElement SelectIndividualGrouprecord(String GroupNumber) {
		
		return driver.findElement(By.xpath(".//table[@id='grid']/tbody/tr/td[text()='"+GroupNumber+"']/preceding-sibling::td/input"));
	}
	public static WebElement IndividualGroupListScreen() {
		return driver.findElement(By.xpath("//span[contains(text(),'Individual Group List')]"));
	}
	public static Select Grouptype_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='GroupType']")));
	}
	public static WebElement SearchGroups() {
		return driver.findElement(By.xpath(".//*[@id='search-button']"));
	}
	public static WebElement EnterGroupNumber_textfield() {
		return driver.findElement(By.xpath(".//*[@id='GroupNumber']"));
	}
	public static WebElement clickonflipgrouptype() {
		return driver.findElement(By.xpath(".//*[@id='btnChangeGroupType']"));
	}
	
	public static WebElement EnterMasterGroupNumber_textfield() {
		return driver.findElement(By.xpath(".//*[@id='MasterGroupNumber']"));
	}
	
	public static WebElement EnterContract_textfield() {
		return driver.findElement(By.xpath(".//*[@id='ContractNumber']"));
	}
	
	public static WebElement EnterPBP_textfield() {
		return driver.findElement(By.xpath(".//*[@id='PBPNumber']"));
	}
	
	public static Select Year_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Year']")));
	}
	
	public static Select SiteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Division']")));
	}
	
	public static Select ClaimsSystem_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SourceSystem']")));
	}
	
	public static WebElement resultsetEdit() {
		return driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
	}
	
	public static WebElement GroupEditScreen() {
		return driver.findElement(By.xpath("//form[@class='form-horizontal']/h2"));
	}
	
	public static WebElement GroupEditScreen_Contract_PBP_Year() {
		return driver.findElement(By.xpath("//label[contains(text(),'Contract / PBP / Year')]"));
	}
	
	public static WebElement GroupEditScreen_GroupNumber() {
		return driver.findElement(By.xpath("//label[contains(text(),'Group Number')]"));
	}
	
	public static WebElement GroupEditScreen_GroupName() {
		return driver.findElement(By.xpath("//label[contains(text(),'Group Name')]"));
	}
	
	public static WebElement GroupEditScreen_Location() {
		return driver.findElement(By.xpath("//label[contains(text(),'Location')]"));
	}
	
	public static WebElement GroupEditScreen_EffectiveDate() {
		return driver.findElement(By.xpath("//label[contains(text(),'Effective Date')]"));
	}

	public static WebElement GroupEditScreen_TerminationDate() {
		return driver.findElement(By.xpath("//label[contains(text(),'Termination Date')]"));
	}
	
	public static WebElement GroupEditScreen_RxVendor() {
		return driver.findElement(By.xpath("//label[contains(text(),'RxVendor')]"));
	}
	
	public static WebElement GroupEditScreen_GroupType() {
		return driver.findElement(By.xpath("//label[contains(text(),'Group Type')]"));
	}
	
	public static WebElement GroupEditScreen_TerminationDate_Checkbox() {
		return driver.findElement(By.xpath("//input[@id='IsUseTerminationDateSelected']"));
	}
	
	public static WebElement GroupEditScreen_RxVendor_Checkbox() {
		return driver.findElement(By.xpath(".//*[@id='IsUseRxVendorSelected']"));
	}
	
	public static WebElement EditTerminationDate_textfield() {
		return driver.findElement(By.xpath(".//*[@id='MyID']"));
	}
	
	public static WebElement EditRxVendor_textfield() {
		return driver.findElement(By.xpath(".//*[@id='RxVendor']"));
	}
	
	public static WebElement SaveOnEditScreen() {
		return driver.findElement(By.xpath("//input[@value='Save']"));		
	}
	
	public static WebElement CancelOnEditScreen() {
		return driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));		
	}
	public static WebElement ClickonMarkasEmployer() {
		return driver.findElement(By.xpath("//*[@id='btnChangeGroupType']"));		
	}
}