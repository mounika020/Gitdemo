package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {

	public static WebElement group_dropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Group ')]"));
	}
	
	public static WebElement IGE_dropdown(WebDriver driver) {
		return driver.findElement(By.xpath("//a[contains(text(),'Admin ')]"));
	}

	public static WebElement groupInstall_link(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='/GroupInstall']"));
	}
	
	public static WebElement IGE_link(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='/Admin/IGE']"));
	}
}
