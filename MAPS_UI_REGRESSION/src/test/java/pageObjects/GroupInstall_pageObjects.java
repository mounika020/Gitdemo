package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;
import utilities.Utils;

public class GroupInstall_pageObjects extends BaseClass {

	public GroupInstall_pageObjects(WebDriver driver) {
		super(driver);
	}

	public static Select contractYear_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'ContractYear']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'ContractYear']")));
	}

	public static WebElement groupNumber_textField() {
		return driver.findElement(By.xpath("//input[@id = 'GroupNumber']"));
	}
	
	public static WebElement groupName_textField() {
		return driver.findElement(By.xpath("//input[@id = 'GroupName']"));
	}

	public static Select claimsSystem_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'ClaimsSystem']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'ClaimsSystem']")));
	}

	public static Select contractNumber_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'ContractNo']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'ContractNo']")));
	}

	public static Select site_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'Site']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'Site']")));
	}

	public static Select drugCoverageType_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'DrugCoverage']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'DrugCoverage']")));
	}

	public static Select groupClassification_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'GroupClassificationTypeID']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'GroupClassificationTypeID']")));
	}

	public static Select effectiveMonth_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'EffectiveMonthID']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'EffectiveMonthID']")));
	}

	public static Select groupStatus_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'GroupStatus']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'GroupStatus']")));
	}

	public static WebElement PBP_textField() {
		return driver.findElement(By.xpath("//input[@id = 'PBPNumber']"));
	}

	public static WebElement search_button() {
		return driver.findElement(By.xpath("//input[@id ='SearchGroupButton']"));
	}
	
	public static WebElement inputRxData_link() {
		return driver.findElement(By.linkText("Input Rx Data"));
	}
	
	public static WebElement inputGroupData_link() {
		return driver.findElement(By.linkText("Input Group Data"));
	}

}
