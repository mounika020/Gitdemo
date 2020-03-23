package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.Header;
import utilities.Constants;

public class Actions_Header extends BaseClass {

	public Actions_Header(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static WebDriverWait wait = new WebDriverWait(driver, 30);

	public static void clickOnComponentCodeLink() {
//		try {
//			wait.until(ExpectedConditions.visibilityOf(Header.Materials_Link()));
			utilities.Utils.click(Header.Materials_Link());
//			wait.until(ExpectedConditions.visibilityOf(Header.componentCode_link()));
			utilities.Utils.click(Header.componentCode_link());
			Constants.test.log(Status.PASS, "Click on component code link in header");
//		} catch (Exception e) {
//			Constants.test.log(Status.FAIL, "Click on component code link in header");
//			Assert.fail("failed due to either component link is not visible or not clickable");
//		}
	}
	
	/*public static void clickOnComponentCodeLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.componentCode_link()));
			utilities.Utils.click(Header.componentCode_link());
			Constants.test.log(Status.PASS, "Click on component code link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on component code link in header");
			Assert.fail("failed due to either component link is not visible or not clickable");
		}
	}*/

	public static void clickOnIndividualRxWrapLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.group_dropdown()));
			utilities.Utils.click(Header.group_dropdown());
			wait.until(ExpectedConditions.visibilityOf(Header.individualRxWrap_link()));
			utilities.Utils.click(Header.individualRxWrap_link());
			Constants.test.log(Status.PASS, "Click on IndividualRxWrap link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on IndividualRxWrap link in header");
			Assert.fail("failed due to either IndividualRxWrap is not visible or not clickable");
		}
	}
	
	public static void clickOnEGAncillaryPackageLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.group_dropdown()));
			utilities.Utils.click(Header.group_dropdown());
			wait.until(ExpectedConditions.visibilityOf(Header.EGAncillaryPackage_link()));
			utilities.Utils.click(Header.EGAncillaryPackage_link());
			Constants.test.log(Status.PASS, "Click on EGAncillaryPackage link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on EGAncillaryPackage link in header");
			Assert.fail("failed due to either EGAncillaryPackage is not visible or not clickable");
		}
	}
	
	public static void clickOnGroupInstallLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.group_dropdown()));
			utilities.Utils.click(Header.group_dropdown());
			wait.until(ExpectedConditions.visibilityOf(Header.GroupInstall_link()));
			utilities.Utils.click(Header.GroupInstall_link());
			Constants.test.log(Status.PASS, "Click on GroupInstall link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on GroupInstall link in header");
			Assert.fail("failed due to either GroupInstall is not visible or not clickable");
		}
	}
	
	public static void clickOnListMaintenanceLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.Admin_dropdown()));
			utilities.Utils.click(Header.Admin_dropdown());
			wait.until(ExpectedConditions.visibilityOf(Header.ListMaintenance_Link()));
			utilities.Utils.click(Header.ListMaintenance_Link());
			Constants.test.log(Status.PASS, "Click on ListMaintenance link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on ListMaintenance link in header");
			Assert.fail("failed due to either ListMaintenance is not visible or not clickable");
		}
	}
	
	public static void clickOnContactLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(Header.contact_link()));
			utilities.Utils.click(Header.contact_link());
			Constants.test.log(Status.PASS, "Click on Contact link in header");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Contact link in header");
			Assert.fail("failed due to either Contact is not visible or not clickable");
		}
	}

	
	
	
}
