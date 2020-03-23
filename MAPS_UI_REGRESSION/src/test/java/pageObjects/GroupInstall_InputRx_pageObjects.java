package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;
import utilities.Utils;

public class GroupInstall_InputRx_pageObjects extends BaseClass {

	public GroupInstall_InputRx_pageObjects(WebDriver driver) {
		super(driver);
	}

	public static Select sendEmpID_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'IsSendEmpIDOption']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'IsSendEmpIDOption']")));
	}
	
	public static Select sendBranchID_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'IsSendBranchIDOption']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'IsSendBranchIDOption']")));
	}
	
	public static Select externalBIN_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'ExternalBINOption']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'ExternalBINOption']")));
	}
	
	public static Select externalPCN_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'ExternalPCNOption']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'ExternalPCNOption']")));
	}
	
	public static Select internalBIN_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'InternalBINOption']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'InternalBINOption']")));
	}
	
	public static Select internalPCN_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'InternalPCNValues']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'InternalPCNValues']")));
	}
	
	public static Select supplementType_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'SupplementTypeCodeOptions']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'SupplementTypeCodeOptions']")));
	}

	public static WebElement rxBPLCode_textField() {
		return driver.findElement(By.xpath("//input[@id = 'RxBPLBenefitCode']"));
	}
	
	public static WebElement carrierID_textField() {
		return driver.findElement(By.xpath("//input[@id = 'CarrierID']"));
	}
	
	public static WebElement DURKey_textField() {
		return driver.findElement(By.xpath("//input[@id = 'DURKey']"));
	}
	
	public static WebElement internalGroup_textField() {
		return driver.findElement(By.xpath("//input[@id = 'InternalGroup']"));
	}
	
	public static WebElement comments_textField() {
		return driver.findElement(By.xpath("//textarea[@id='txtComments']"));
	}


}
