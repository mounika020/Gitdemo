package pageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import miscellaneous.BaseClass;

public class Header extends BaseClass{

	public Header(WebDriver driver) throws InvalidFormatException, IOException {
		super(driver);
	}
	public static WebElement contact_link() {
		return driver.findElement(By.xpath("//a[@href='/ContactRule']"));
	}
	
	public static WebElement Materials_Link(){
		return driver.findElement(By.xpath("//ul[@class='nav']/li[4]/a"));
		
	}

	public static WebElement EOB_link() {
		return driver.findElement(By.xpath("//a[@href='/EOB']"));
	}
	public static WebElement EOB_Link(){
		return driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/a[contains(text(),'EOB')]"));
		
	}
	
	public static WebElement plan_link() {
		return driver.findElement(By.xpath("//a[@href='/Plan']"));
	}
	public static WebElement Admin_Link() {
		return driver.findElement(By.xpath("//a[contains(text(),'Admin ')]"));
	}
	
	public static WebElement GroupAdmin_Link() {
		return driver.findElement(By.xpath("//a[contains(text(),'Group Admin')]"));
	}
	
	public static WebElement material_dropdown() {
		return driver.findElement(By.xpath("//a[contains(text(),'Materials ')]"));
	}

	public static WebElement group_dropdown() {
		return driver.findElement(By.xpath("//a[contains(text(),'Group ')]"));
	}

	public static WebElement componentCode_link() {
		return driver.findElement(By.xpath("//ul/li/a[contains(text(),'Component Code')]"));
	}

	public static WebElement individualRxWrap_link() {
		return driver.findElement(By.xpath("//ul/li/a[contains(text(),'Individual Rx Wrap')]"));
	}

	public static WebElement EGAncillaryPackage_link() {
		return driver.findElement(By.xpath("//ul/li/a[contains(text(),'EG Ancillary Package')]"));
	}

	public static WebElement GroupInstall_link() {
		return driver.findElement(By.xpath("//ul/li/a[contains(text(), 'Group Install')]"));
	}

	

	public static WebElement Admin_dropdown() {
		return driver.findElement(By.xpath("//a[contains(text(),'Admin ')]"));
	}
	
	public static WebElement ListMaintenance_Link() {
		return driver.findElement(By.xpath("//a[contains(text(),'List Maintenance')]"));
	}
}
