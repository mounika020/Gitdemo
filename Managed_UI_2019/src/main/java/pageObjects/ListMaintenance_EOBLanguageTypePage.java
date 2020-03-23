package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;
import utilities.Utils;

public class ListMaintenance_EOBLanguageTypePage extends BaseClass {

	public ListMaintenance_EOBLanguageTypePage(WebDriver driver) {
		super(driver);
	}

	public static WebElement EOBLanguageType_link() {
		return driver.findElement(By.xpath("//a[contains(text(),'EOB Language Types')]"));
	}

	public static WebElement createNewBrand_button() {
		return driver.findElement(By.xpath("//a[contains(text(),'Create New Language')]"));
	}

	public static WebElement name_textField() {
		return driver.findElement(By.xpath("//input[@id='Name']"));
	}

	public static WebElement createEOBLanguage_button() {
		return driver.findElement(By.xpath("//input[@value = 'Create EOB Language']"));
	}

}
