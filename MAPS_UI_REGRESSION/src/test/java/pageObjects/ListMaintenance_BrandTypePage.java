package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;
import utilities.Utils;

public class ListMaintenance_BrandTypePage extends BaseClass {

	public ListMaintenance_BrandTypePage(WebDriver driver) {
		super(driver);
	}

	public static WebElement brandType_link() {
		return driver.findElement(By.xpath("//a[contains(text(),'Brand Types')]"));
	}

	public static WebElement createNewBrand_button() {
		return driver.findElement(By.xpath("//a[contains(text(),'Create New Brand')]"));
	}

	public static WebElement name_textField() {
		return driver.findElement(By.xpath("//input[@id='Name']"));
	}

	public static WebElement createBrand_button() {
		return driver.findElement(By.xpath("//input[@value = 'Create Brand']"));
	}

}
