package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.ContactPage;
import pageObjects.ListMaintenance_BrandTypePage;
import utilities.Constants;
import utilities.Utils;

public class Actions_ListMaintenance extends BaseClass {

	public Actions_ListMaintenance(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void Alert_Accept() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Thread.sleep(8000);
			alert.accept();
			Constants.test.log(Status.PASS, "check Alert is displayed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "check Alert is displayed");
			Assert.fail("failed to check Alert is displayed");
		}
	}

	public static void clickOnBrandTypeLink() {
		try {
			ListMaintenance_BrandTypePage.brandType_link().click();
			Constants.test.log(Status.PASS, "Clicked on Brand Type link");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Clicked on Brand Type link");
			Assert.fail("failed to Click on Brand Type link");
		}
	}

	public static void clickOnCreateNewBrandButton() {
		try {
			ListMaintenance_BrandTypePage.createNewBrand_button().click();
			Constants.test.log(Status.PASS, "Clicked on Create New Brand button");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Clicked on Create New Brand button");
			Assert.fail("failed to Click on Create New Brand button");
		}
	}

	public static void enterName(String name) {
		try {
			ListMaintenance_BrandTypePage.name_textField().sendKeys(name);
			Constants.test.log(Status.PASS, "enter Name");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Name");
			Assert.fail("failed to enter value in Name text field");
		}
	}

	public static void clickOnCreateBrandButton() {
		try {
			ListMaintenance_BrandTypePage.createBrand_button().click();
			Constants.test.log(Status.PASS, "Clicked on Create Brand button");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Clicked on Create Brand button");
			Assert.fail("failed to Click on Create Brand button");
		}
	}

}
