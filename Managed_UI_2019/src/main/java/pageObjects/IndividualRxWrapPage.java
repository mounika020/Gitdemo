package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class IndividualRxWrapPage extends BaseClass {

	public IndividualRxWrapPage(WebDriver driver) {
		super(driver);
	}

	public static Select planYear_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='PlanYear']")));
	}

	public static WebElement groupNumber_textField() {
		return driver.findElement(By.xpath(".//input[@id='GroupNumber']"));
	}

	public static WebElement DURKey_textField() {
		return driver.findElement(By.xpath(".//input[@id='DURKey']"));
	}

	public static WebElement contractNumber_textField() {
		return driver.findElement(By.xpath(".//input[@id='ContractNumber']"));
	}

	public static WebElement groupEffectiveDate_textField() {
		return driver.findElement(By.xpath(".//input[@id='GroupEffectiveDate']"));
	}

	public static WebElement internalBIN_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalBIN']"));
	}

	public static WebElement PBPNumber_textField() {
		return driver.findElement(By.xpath(".//input[@id='PBPNumber']"));
	}

	public static WebElement groupTerminationDate_textField() {
		return driver.findElement(By.xpath(".//input[@id='GroupTerminationDate']"));
	}

	public static WebElement internalPCN_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalPCN']"));
	}

	public static WebElement masterGroupNumber_textField() {
		return driver.findElement(By.xpath(".//input[@id='MasterGroupNumber']"));
	}

	public static Select supplementTypeCode_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='SupplementTypeCode']")));
	}

	public static WebElement internalRxGroup_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalGroup']"));
	}
	
	public static WebElement search_button() {
		return driver.findElement(By.xpath(".//input[@id='SearchGroupButton']"));
	}
	
	public static WebElement edit_link() {
		return driver.findElement(By.linkText("Edit"));
	}
	
	public static WebElement yearContractPBP() {
		return driver.findElement(By.linkText(".//*[@id='grid']/tbody/tr[1]/td[1]"));
	}
	
	public static WebElement edit_supplementTypeCode_checkbox() {
		return driver.findElement(By.xpath(".//input[@id='CanUserEditSupplementTypeCode']"));
	}
	
	public static Select edit_supplementTypeCode_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='SupplementTypeCode']")));
	}
	
	public static WebElement edit_DURKey_checkbox() {
		return driver.findElement(By.xpath(".//input[@id='CanUserEditDURKey']"));
	}
	
	public static WebElement edit_DURKey_textField() {
		return driver.findElement(By.xpath(".//input[@id='DURKey']"));
	}
	
	public static WebElement edit_internalBIN_checkbox() {
		return driver.findElement(By.xpath(".//input[@id='CanUserEditInternalBIN']"));
	}
	
	public static WebElement edit_internalBIN_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalBIN']"));
	}
	
	public static WebElement edit_internalPCN_checkbox() {
		return driver.findElement(By.xpath(".//input[@id='CanUserEditInternalPCN']"));
	}
	
	public static WebElement edit_internalPCN_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalPCN']"));
	}
	
	public static WebElement edit_internalRxGroup_checkbox() {
		return driver.findElement(By.xpath(".//input[@id='CanUserEditInternalGroup']"));
	}
	
	public static WebElement edit_internalRxGroup_textField() {
		return driver.findElement(By.xpath(".//input[@id='InternalGroup']"));
	}
	
	public static WebElement edit_update_button() {
		return driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
	}
	
	public static WebElement edit_Cancel_link() {
		return driver.findElement(By.linkText("Cancel"));
	}
	
	public static WebElement records_Count() {
		return driver.findElement(By.xpath(".//*[@id='OrderBy']//following::strong[1]"));
	}
	
}
