package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import miscellaneous.BaseClass;

public class dsnp extends BaseClass {

	public dsnp(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
}