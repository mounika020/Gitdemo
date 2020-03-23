package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.EGAncillaryPackagePage;
import pageObjects.IndividualRxWrapPage;
import utilities.Constants;
import utilities.Utils;

public class Actions_EGAncillaryPackagePage extends BaseClass {

	public Actions_EGAncillaryPackagePage(WebDriver driver) {
		super(driver);
	}

	public static void select_packageType_dropdown(String option) {
		try {
			EGAncillaryPackagePage.packageType_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from Package Type drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from Package Type drop down");
			Assert.fail("failed to select an option from Package Type drop down");
		}
	}

	public static void clickOnCreateNewPackageButton() {
		try {
			Utils.click(EGAncillaryPackagePage.createNewPackage_button());
			Constants.test.log(Status.PASS, "Click on Create New Package button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Create New Package button");
			Assert.fail("unable to click on Create New Package button");
		}
	}

	public static void enter_packageNumber(String packageNumber) {
		try {
			EGAncillaryPackagePage.packageNumber_textField().sendKeys(packageNumber);
			Constants.test.log(Status.PASS, "Entering Package Number");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Package Number");
			Assert.fail("failed to enter Package Number");
		}
	}

	public static void clickOnNextButton() {
		try {
			Utils.click(EGAncillaryPackagePage.next_button());
			Constants.test.log(Status.PASS, "Click on Next button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Next button");
			Assert.fail("unable to click on Next button");
		}
	}

	public static void clickOnCancelLink() {
		try {
			Utils.click(EGAncillaryPackagePage.cancel_link());
			Constants.test.log(Status.PASS, "Click on Cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Cancel button");
			Assert.fail("unable to click on Cancel button");
		}
	}

	public static void select_outOfNetwork_dropdown(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork dropdown");
			Assert.fail("failed to select an option from outOfNetwork dropdown");
		}
	}

	public static void select_outOfNetwork_dropdown_18a1(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_dropdown_18a1().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork 18a1 dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork 18a1 dropdown");
			Assert.fail("failed to select an option from outOfNetwork 18a1 dropdown");
		}
	}

	public static void select_outOfNetwork_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork 18a4 dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork 18a4 dropdown");
			Assert.fail("failed to select an option from outOfNetwork 18a4 dropdown");
		}
	}

	public static void select_benefitOption_dropdown(String option) {
		try {
			EGAncillaryPackagePage.benefitOption_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from Benefit Option drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from Benefit Option drop down");
			Assert.fail("failed to select an option from Benefit Option drop down");
		}
	}

	public static void select_benefitOption_dropdown_18a1(String option) {
		try {
			EGAncillaryPackagePage.benefitOption_dropdown_18a1().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from Benefit Option 18a1 drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from Benefit Option 18a1 drop down");
			Assert.fail("failed to select an option from Benefit Option 18a1 drop down");
		}
	}

	public static void select_benefitOption_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.benefitOption_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from Benefit Option 18a4 drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from Benefit Option 18a4 drop down");
			Assert.fail("failed to select an option from Benefit Option 18a4 drop down");
		}
	}

	public static void select_inNetworkCopay_radioButton() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCopay_radioButton());
			Constants.test.log(Status.PASS, "select In-Network Copay radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Copay radio button");
			Assert.fail("failed to select In-Network Copay radio button");
		}
	}

	public static void select_inNetworkCopay_radioButton_18a1() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCopay_radioButton_18a1());
			Constants.test.log(Status.PASS, "select In-Network Copay 18a1 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Copay 18a1 radio button");
			Assert.fail("failed to select In-Network Copay 18a1 radio button");
		}
	}

	public static void select_inNetworkCopay_radioButton_18a4() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCopay_radioButton_18a4());
			Constants.test.log(Status.PASS, "select In-Network Copay 18a4 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Copay 18a4 radio button");
			Assert.fail("failed to select In-Network Copay 18a4 radio button");
		}
	}

	public static void select_inNetworkCoins_radioButton() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCoins_radioButton());
			Constants.test.log(Status.PASS, "select In-Network Coins radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Coins radio button");
			Assert.fail("failed to select In-Network Coins radio button");
		}
	}

	public static void select_inNetworkCoins_radioButton_18a1() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCoins_radioButton());
			Constants.test.log(Status.PASS, "select In-Network Coins 18a1 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Coins 18a1 radio button");
			Assert.fail("failed to select In-Network Coins 18a1 radio button");
		}
	}

	public static void select_inNetworkCoins_radioButton_18a4() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetworkCoins_radioButton_18a4());
			Constants.test.log(Status.PASS, "select In-Network Coins 18a4 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select In-Network Coins 18a4 radio button");
			Assert.fail("failed to select In-Network Coins 18a4 radio button");
		}
	}

	public static void select_outOfNetworkCopay_radioButton() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCopay_radioButton());
			Constants.test.log(Status.PASS, "select Out-of-Network Copay radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Copay radio button");
			Assert.fail("failed to select Out-of-Network Copay radio button");
		}
	}

	public static void select_outOfNetworkCopay_radioButton_18a1() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCopay_radioButton_18a1());
			Constants.test.log(Status.PASS, "select Out-of-Network Copay 18a1 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Copay 18a1 radio button");
			Assert.fail("failed to select Out-of-Network Copay 18a1 radio button");
		}
	}

	public static void select_outOfNetworkCopay_radioButton_18a4() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCopay_radioButton_18a4());
			Constants.test.log(Status.PASS, "select Out-of-Network Copay 18a4 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Copay 18a4 radio button");
			Assert.fail("failed to select Out-of-Network Copay 18a4 radio button");
		}
	}

	public static void select_outOfNetworkCoins_radioButton() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCoins_radioButton());
			Constants.test.log(Status.PASS, "select Out-of-Network Coins radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Coins radio button");
			Assert.fail("failed to select Out-of-Network Coins radio button");
		}
	}

	public static void select_outOfNetworkCoins_radioButton_18a1() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCoins_radioButton_18a1());
			Constants.test.log(Status.PASS, "select Out-of-Network Coins 18a1 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Coins 18a1 radio button");
			Assert.fail("failed to select Out-of-Network Coins 18a1 radio button");
		}
	}

	public static void select_outOfNetworkCoins_radioButton_18a4() {
		try {
			Utils.click(EGAncillaryPackagePage.outOfNetworkCoins_radioButton_18a4());
			Constants.test.log(Status.PASS, "select Out-of-Network Coins 18a4 radio button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Out-of-Network Coins 18a4 radio button");
			Assert.fail("failed to select Out-of-Network Coins 18a4 radio button");
		}
	}

	public static void enter_inNetwork_costShare(String costShare) {
		try {
			EGAncillaryPackagePage.inNetwork_costShare_textField().clear();
			EGAncillaryPackagePage.inNetwork_costShare_textField().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering InNetwork costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering InNetwork costShare value");
			Assert.fail("failed to enter InNetwork costShare value");
		}
	}

	public static void enter_inNetwork_costShare_18a1(String costShare) {
		try {
			EGAncillaryPackagePage.inNetwork_costShare_textField_18a1().clear();
			EGAncillaryPackagePage.inNetwork_costShare_textField_18a1().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering InNetwork 18a1 costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering InNetwork 18a1 costShare value");
			Assert.fail("failed to enter InNetwork 18a1 costShare value");
		}
	}

	public static void enter_inNetwork_costShare_18a4(String costShare) {
		try {
			EGAncillaryPackagePage.inNetwork_costShare_textField_18a4().clear();
			EGAncillaryPackagePage.inNetwork_costShare_textField_18a4().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering InNetwork 18a4 costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering InNetwork 18a4 costShare value");
			Assert.fail("failed to enter InNetwork 18a4 costShare value");
		}
	}

	public static void enter_outOfNetwork_costShare(String costShare) {
		try {
			EGAncillaryPackagePage.outOfNetwork_costShare_textField().clear();
			EGAncillaryPackagePage.outOfNetwork_costShare_textField().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering outOfNetwork costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering outOfNetwork costShare value");
			Assert.fail("failed to enter outOfNetwork costShare value");
		}
	}

	public static void enter_outOfNetwork_costShare_18a1(String costShare) {
		try {
			EGAncillaryPackagePage.outOfNetwork_costShare_textField_18a1().clear();
			EGAncillaryPackagePage.outOfNetwork_costShare_textField_18a1().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering outOfNetwork 18a1 costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering outOfNetwork 18a1 costShare value");
			Assert.fail("failed to enter outOfNetwork 18a1 costShare value");
		}
	}

	public static void enter_outOfNetwork_costShare_18a4(String costShare) {
		try {
			EGAncillaryPackagePage.outOfNetwork_costShare_textField_18a4().clear();
			EGAncillaryPackagePage.outOfNetwork_costShare_textField_18a4().sendKeys(costShare);
			Constants.test.log(Status.PASS, "Entering outOfNetwork 18a4 costShare value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering outOfNetwork 18a4 costShare value");
			Assert.fail("failed to enter outOfNetwork 18a4 costShare value");
		}
	}

	public static void enter_inNetwork_maxAllowPerVisit(String inNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.inNetwork_maxAllowPerVisit_textField().sendKeys(inNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering In-Network Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network Max Allow Per Visit value");
			Assert.fail("failed to enter In-Network Max Allow Per Visit value");
		}
	}

	public static void enter_inNetwork_maxAllowPerVisit_18a1(String inNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.inNetwork_maxAllowPerVisit_textField_18a1().sendKeys(inNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering In-Network 18a1 Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a1 Max Allow Per Visit value");
			Assert.fail("failed to enter In-Network 18a1 Max Allow Per Visit value");
		}
	}

	public static void enter_inNetwork_maxBenAllow_18a4(String inNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.inNetwork_maxBenAllow_textField_18a4().sendKeys(inNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering In-Network 18a4 Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a4 Max Allow Per Visit value");
			Assert.fail("failed to enter In-Network 18a4 Max Allow Per Visit value");
		}
	}

	public static void enter_outOfNetwork_maxAllowPerVisit(String outOfNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.outOfNetwork_maxAllowPerVisit_textField().sendKeys(outOfNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering Out-of-Network Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network Max Allow Per Visit value");
			Assert.fail("failed to enter Out-of-Network Max Allow Per Visit value");
		}
	}

	public static void enter_outOfNetwork_maxAllowPerVisit_18a1(String outOfNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.outOfNetwork_maxAllowPerVisit_textField_18a1()
					.sendKeys(outOfNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering Out-of-Network 18a1 Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network 18a1 Max Allow Per Visit value");
			Assert.fail("failed to enter Out-of-Network 18a1 Max Allow Per Visit value");
		}
	}

	public static void enter_outOfNetwork_maxBenAllow_18a4(String outOfNetwork_maxAllowPerVisit) {
		try {
			EGAncillaryPackagePage.outOfNetwork_maxBenAllow_textField_18a4()
					.sendKeys(outOfNetwork_maxAllowPerVisit);
			Constants.test.log(Status.PASS, "Entering Out-of-Network 18a4 Max Allow Per Visit value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network 18a4 Max Allow Per Visit value");
			Assert.fail("failed to enter Out-of-Network 18a4 Max Allow Per Visit value");
		}
	}

	public static void enter_inNetwork_visits(String inNetwork_visits) {
		try {
			EGAncillaryPackagePage.inNetwork_visits_textField().clear();
			EGAncillaryPackagePage.inNetwork_visits_textField().sendKeys(inNetwork_visits);
			Constants.test.log(Status.PASS, "Entering In-Network Visits value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network Visits value");
			Assert.fail("failed to enter In-Network Visits value");
		}
	}

	public static void enter_inNetwork_visits_18a1(String inNetwork_visits) {
		try {
			EGAncillaryPackagePage.inNetwork_visits_textField_18a1().clear();
			EGAncillaryPackagePage.inNetwork_visits_textField_18a1().sendKeys(inNetwork_visits);
			Constants.test.log(Status.PASS, "Entering In-Network 18a1 Visits value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a1 Visits value");
			Assert.fail("failed to enter In-Network 18a1 Visits value");
		}
	}

	public static void enter_inNetwork_devices_18a4(String inNetwork_devices) {
		try {
			EGAncillaryPackagePage.inNetwork_devices_textField_18a4().clear();
			EGAncillaryPackagePage.inNetwork_devices_textField_18a4().sendKeys(inNetwork_devices);
			Constants.test.log(Status.PASS, "Entering In-Network 18a4 devices value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a4 devices value");
			Assert.fail("failed to enter In-Network 18a4 devices value");
		}
	}

	public static void enter_outOfNetwork_visits(String outOfNetwork_visits) {
		try {
			EGAncillaryPackagePage.outOfNetwork_visits_textField().clear();
			EGAncillaryPackagePage.outOfNetwork_visits_textField().sendKeys(outOfNetwork_visits);
			Constants.test.log(Status.PASS, "Entering Out-of-Network Visits value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network Visits value");
			Assert.fail("failed to enter Out-of-Network Visits value");
		}
	}

	public static void enter_outOfNetwork_visits_18a1(String outOfNetwork_visits) {
		try {
			EGAncillaryPackagePage.outOfNetwork_visits_textField_18a1().clear();
			EGAncillaryPackagePage.outOfNetwork_visits_textField_18a1().sendKeys(outOfNetwork_visits);
			Constants.test.log(Status.PASS, "Entering Out-of-Network 18a1 Visits value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network 18a1 Visits value");
			Assert.fail("failed to enter Out-of-Network 18a1 Visits value");
		}
	}

	public static void enter_outOfNetwork_devices_18a4(String outOfNetwork_devices) {
		try {
			EGAncillaryPackagePage.outOfNetwork_devices_textField_18a4().clear();
			EGAncillaryPackagePage.outOfNetwork_devices_textField_18a4().sendKeys(outOfNetwork_devices);
			Constants.test.log(Status.PASS, "Entering Out-of-Network 18a4 devices value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering Out-of-Network 18a4 devices value");
			Assert.fail("failed to enter Out-of-Network 18a4 devices value");
		}
	}

	public static void select_inNetwork_visits_checkBox() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetwork_visits_checkBox());
			Constants.test.log(Status.PASS, "Select In-Network Visits Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select In-Network Visits Checkbox");
			Assert.fail("failed to Select In-Network Visits Checkbox");
		}
	}

	public static void select_inNetwork_visits_checkBox_18a1() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetwork_visits_checkBox_18a1());
			Constants.test.log(Status.PASS, "Select In-Network 18a1 Visits Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select In-Network 18a1 Visits Checkbox");
			Assert.fail("failed to Select In-Network 18a1 Visits Checkbox");
		}
	}

	public static void select_inNetwork_devices_checkBox_18a4() {
		try {
			Utils.click(EGAncillaryPackagePage.inNetwork_devices_checkBox_18a4());
			Constants.test.log(Status.PASS, "Select In-Network 18a4 devices Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select In-Network 18a4 devices Checkbox");
			Assert.fail("failed to Select In-Network 18a4 devices Checkbox");
		}
	}

	public static void select_outOfNetwork_visits_checkBox() {
		try {
			EGAncillaryPackagePage.outOfNetwork_visits_checkBox().click();
			;
			Constants.test.log(Status.PASS, "Select Out-of-Network Visits Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select Out-of-Network Visits Checkbox");
			Assert.fail("failed to Select Out-of-Network Visits Checkbox");
		}
	}

	public static void select_outOfNetwork_visits_checkBox_18a1() {
		try {
			EGAncillaryPackagePage.outOfNetwork_visits_checkBox_18a1().click();
			;
			Constants.test.log(Status.PASS, "Select Out-of-Network 18a1 Visits Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select Out-of-Network 18a1 Visits Checkbox");
			Assert.fail("failed to Select Out-of-Network 18a1 Visits Checkbox");
		}
	}

	public static void select_outOfNetwork_devices_checkBox_18a4() {
		try {
			EGAncillaryPackagePage.outOfNetwork_devices_checkBox_18a4().click();
			;
			Constants.test.log(Status.PASS, "Select Out-of-Network 18a4 Visits Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Select Out-of-Network 18a4 Visits Checkbox");
			Assert.fail("failed to Select Out-of-Network 18a4 Visits Checkbox");
		}
	}

	public static void select_inNetwork_ear_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.inNetwork_ear_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from 18a4 InNetwork Ear drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from 18a4 InNetwork Ear drop down");
			Assert.fail("failed to select an option from 18a4 InNetwork Ear drop down");
		}
	}
	
	public static void select_outOfNetwork_ear_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_ear_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from 18a4 outOfNetwork Ear drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from 18a4 outOfNetwork Ear drop down");
			Assert.fail("failed to select an option from 18a4 outOfNetwork Ear drop down");
		}
	}
	
	public static void select_inNetwork_periodicity_dropdown(String option) {
		try {
			EGAncillaryPackagePage.inNetwork_periodicity_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from InNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from InNetwork Periodicity drop down");
			Assert.fail("failed to select an option from InNetwork Periodicity drop down");
		}
	}

	public static void select_inNetwork_periodicity_dropdown_18a1(String option) {
		try {
			EGAncillaryPackagePage.inNetwork_periodicity_dropdown_18a1().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from 18a1 InNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from 18a1 InNetwork Periodicity drop down");
			Assert.fail("failed to select an option from 18a1 InNetwork Periodicity drop down");
		}
	}

	public static void select_inNetwork_periodicity_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.inNetwork_periodicity_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from 18a4 InNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from 18a4 InNetwork Periodicity drop down");
			Assert.fail("failed to select an option from 18a4 InNetwork Periodicity drop down");
		}
	}

	public static void select_outOfNetwork_periodicity_dropdown_18a1(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_periodicity_dropdown_18a1().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork Periodicity drop down");
			Assert.fail("failed to select an option from outOfNetwork Periodicity drop down");
		}
	}

	public static void select_outOfNetwork_periodicity_dropdown_18a4(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_periodicity_dropdown_18a4().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork Periodicity drop down");
			Assert.fail("failed to select an option from outOfNetwork Periodicity drop down");
		}
	}

	public static void select_outOfNetwork_periodicity_dropdown(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_periodicity_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork Periodicity drop down");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork Periodicity drop down");
			Assert.fail("failed to select an option from outOfNetwork Periodicity drop down");
		}
	}

	public static void enter_inNetwork_vendor(String inNetwork_vendor) {
		try {
			EGAncillaryPackagePage.inNetwork_vendor_textField().sendKeys(inNetwork_vendor);
			Constants.test.log(Status.PASS, "Entering In-Network Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network Vendor value");
			Assert.fail("failed to enter In-Network Vendor value");
		}
	}
	
	public static void enter_inNetwork_vendor_18a1(String inNetwork_vendor) {
		try {
			EGAncillaryPackagePage.inNetwork_vendor_textField_18a1().sendKeys(inNetwork_vendor);
			Constants.test.log(Status.PASS, "Entering In-Network 18a1 Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a1 Vendor value");
			Assert.fail("failed to enter In-Network 18a1 Vendor value");
		}
	}
	
	public static void enter_inNetwork_vendor_18a4(String inNetwork_vendor) {
		try {
			EGAncillaryPackagePage.inNetwork_vendor_textField_18a4().sendKeys(inNetwork_vendor);
			Constants.test.log(Status.PASS, "Entering In-Network 18a4 Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a4 Vendor value");
			Assert.fail("failed to enter In-Network 18a4 Vendor value");
		}
	}

	public static void enter_inNetwork_additionalVendor(String inNetwork_additionalVendor) {
		try {
			EGAncillaryPackagePage.inNetwork_additionalVendor_textField().sendKeys(inNetwork_additionalVendor);
			Constants.test.log(Status.PASS, "Entering In-Network Additional Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network Additional Vendor value");
			Assert.fail("failed to enter In-Network Additional Vendor value");
		}
	}
	
	public static void enter_inNetwork_additionalVendor_18a1(String inNetwork_additionalVendor) {
		try {
			EGAncillaryPackagePage.inNetwork_additionalVendor_textField_18a1().sendKeys(inNetwork_additionalVendor);
			Constants.test.log(Status.PASS, "Entering In-Network 18a1 Additional Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a1 Additional Vendor value");
			Assert.fail("failed to enter In-Network 18a1 Additional Vendor value");
		}
	}
	
	public static void enter_inNetwork_additionalVendor_18a4(String inNetwork_additionalVendor) {
		try {
			EGAncillaryPackagePage.inNetwork_additionalVendor_textField_18a4().sendKeys(inNetwork_additionalVendor);
			Constants.test.log(Status.PASS, "Entering In-Network 18a4 Additional Vendor value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Entering In-Network 18a4 Additional Vendor value");
			Assert.fail("failed to enter In-Network 18a4 Additional Vendor value");
		}
	}

	public static void select_inNetwork_chiroAndAcupunctureCombined_dropdown(String option) {
		try {
			EGAncillaryPackagePage.inNetwork_chiroAndAcupunctureCombined_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from inNetwork_chiroAndAcupunctureCombined_dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from inNetwork_chiroAndAcupunctureCombined_dropdown");
			Assert.fail("failed to select an option from InNetwork inNetwork_chiroAndAcupunctureCombined_dropdown");
		}
	}

	public static void select_outOfNetwork_chiroAndAcupunctureCombined_dropdown(String option) {
		try {
			EGAncillaryPackagePage.outOfNetwork_chiroAndAcupunctureCombined_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select an option from outOfNetwork_chiroAndAcupunctureCombined_dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select an option from outOfNetwork_chiroAndAcupunctureCombined_dropdown");
			Assert.fail("failed to select an option from InNetwork outOfNetwork_chiroAndAcupunctureCombined_dropdown");
		}
	}

	public static void clickOnCreateButton() {
		try {
			EGAncillaryPackagePage.create_button().click();
			Constants.test.log(Status.PASS, "Click on Create button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Create button");
			Assert.fail("unable to click on Create button");
		}
	}

	public static void clickOnCreateNewPackageCancelLink() {
		try {
			Utils.click(EGAncillaryPackagePage.createNewPackage_cancel_button());
			Constants.test.log(Status.PASS, "Click on Create New Package Cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Create New Package Cancel button");
			Assert.fail("unable to click on Create New Package Cancel button");
		}
	}

	public static void clickOnAlertOK() {
		try {
			driver.switchTo().alert().accept();
			Constants.test.log(Status.PASS, "Click on OK");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on OK");
			Assert.fail("unable to click on OK");
		}
	}

	public static void clickOnAlertCancel() {
		try {
			driver.switchTo().alert().dismiss();
			Constants.test.log(Status.PASS, "Click on Cancel");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on Cancel");
			Assert.fail("unable to click on Cancel");
		}
	}

	public static void clickOnEditCancelLink() {
		try {
			Thread.sleep(3000);
			Utils.click(IndividualRxWrapPage.edit_Cancel_link());
			Constants.test.log(Status.PASS, "Click on edit_Cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Click on edit_Cancel button");
			Assert.fail("unable to edit_Cancel button");
		}
	}

	public static String getRecordCount() {
		String count = null;
		try {
			count = IndividualRxWrapPage.records_Count().getText();
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Reading Records Count");
			Assert.fail("Unable to count the UI search results rows");
		}
		return count;
	}

	public static void compareSearchResultWithDBvalues()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// try {
		Thread.sleep(3000);

		// Accessing Input data file
		File file = new File((String) "./src/test/java/testData/IndividualRxWrap_Search.xlsx");
		FileInputStream input_Excel = new FileInputStream(file);
		XSSFWorkbook input_Workbook = new XSSFWorkbook(input_Excel);
		XSSFSheet input_Sheet = input_Workbook.getSheet("Sheet1");

		// passing arguments from input data sheet to query
		String QEREY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue();
		QEREY = QEREY.replace("parameter1", input_Sheet.getRow(1).getCell(0).getStringCellValue());
		QEREY = QEREY.replace("parameter2", input_Sheet.getRow(1).getCell(1).getStringCellValue());

		// Connecting to Database using method created in Utils package
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		LinkedHashMap<String, String> DBresult = new LinkedHashMap<String, String>();

		// Iterating loop to store DB results in DBresult
		for (int i = 0; Constants.resultset.next(); i++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresult.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}

		// Comparing DB values with UI values
		List<String> DB_results = new ArrayList<String>(DBresult.values());
		for (int i = 0; i < DB_results.size(); i++) {
			String UI_results = driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr/td")).get(i).getText();
			if (DB_results.get(i) == null) {
				DB_results.set(i, "null");
			}
			if (driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr/td")).get(i).getText().isEmpty()) {
				UI_results = "null";
			}
			if (UI_results.toString().trim().toUpperCase().equals(DB_results.get(i).toUpperCase().trim().toString())) {
				System.out.println(UI_results.toString());
				System.out.println(DB_results.get(i));
				Constants.test.log(Status.PASS, "compare search results with DB values");
				Assert.assertTrue(true);
			} else {
				Constants.test.log(Status.FAIL, "compare search results with DB values");
				Assert.assertTrue(false);
			}
		}
		input_Workbook.close();
		// } catch (Exception e) {
		// Constants.test.log(Status.FAIL, "compare search results with DB
		// values");
		// Assert.fail("failed to compare search results with DB values");
		// }
	}

	public static void compareDBrecordsCountWithUIsearchResultsCount() throws SQLException {
		String count = null;
		try {
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(Constants.Input_SQLS.getRow(6).getCell(1)
					.getStringCellValue().replace("parameter1", "2017").replace("parameter2", "H0543"));
			if (Constants.resultset.next()) {
				count = Constants.resultset.getString(1);
			}
			Assert.assertTrue(count.equalsIgnoreCase(getRecordCount()));
			Constants.test.log(Status.PASS, "Compare DB records count with UI search results rows count"
					+ "</br> DB Records Count: " + count + "</br> UI Search results count: " + getRecordCount());
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Compare DB records count with UI search results rows count"
					+ "</br> DB Records Count: " + count + "</br> UI Search results count: " + getRecordCount());
		}
	}
}
