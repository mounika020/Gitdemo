package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;
import utilities.Utils;

public class GroupInstall_InputGroup_pageObjects extends BaseClass {

	public GroupInstall_InputGroup_pageObjects(WebDriver driver) {
		super(driver);
	}

	public static Select PCPRequired_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'PCPRequiredOptions']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'PCPRequiredOptions']")));
	}
	
	public static Select defaultPCP_dropdown() {
		Utils.change_dropdownStyle(driver.findElement(By.xpath("//select[@id = 'defaultPCPOptions']")));
		return new Select(driver.findElement(By.xpath("//select[@id = 'defaultPCPOptions']")));
	}
	
	public static WebElement GPSEmployerID_textField() {
		return driver.findElement(By.xpath("//input[@id = 'GPSEmployerID']"));
	}
	
	public static WebElement GPSBranchNumber_textField() {
		return driver.findElement(By.xpath("//input[@id = 'GPSBranchNumber']"));
	}
	
	public static WebElement comment_textField() {
		return driver.findElement(By.xpath("//textarea[@id = 'txtCommt']"));
	}
	
	public static WebElement changeRequiredToSourceSystem_textField() {
		return driver.findElement(By.xpath("//input[@id = 'GetBCCIInput_ChangeRequiredToSourceSystem']"));
	}
	
	
}
