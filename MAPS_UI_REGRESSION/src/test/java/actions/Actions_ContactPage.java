package actions;

import java.sql.Driver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.ContactPage;
import pageObjects.PlanPage;
import utilities.Constants;
import utilities.Utils;

public class Actions_ContactPage extends BaseClass {

	public Actions_ContactPage(WebDriver driver) {
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
		}

		catch (Exception e) {
		Constants.test.log(Status.FAIL, "check Alert is displayed");
		Assert.fail("failed to check Alert is displayed");
		}
		}
	
	public static void Alert_Reject() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(8000);
		alert.dismiss();
		Constants.test.log(Status.PASS, "check Alert is displayed");
		}

		catch (Exception e) {
		Constants.test.log(Status.FAIL, "check Alert is displayed");
		Assert.fail("failed to check Alert is displayed");
		}
		}
	
	public static void enterContract(String cntract) {
		try {
			if (cntract.equalsIgnoreCase("null")) {
				ContactPage.contract_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter contract");
			} else {
				ContactPage.contract_textField().sendKeys(cntract);
				Constants.test.log(Status.PASS, "enter contract");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter contract");
			Assert.fail("failed to enter value in contract text field");
		}
	}
	
	public static void enterPBP(String planLongName) {
		try {
			if (planLongName.equalsIgnoreCase("null")) {
				ContactPage.PBP_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter PBP number");
			} else {
				PlanPage.PBP_textField().sendKeys(planLongName);
				Constants.test.log(Status.PASS, "enter PBP number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter PBP number");
			Assert.fail("failed to enter value in PBP text field");
		}
	}
	
	public static void enterAddress1(String Address1) {
		try {
			if (Address1.equalsIgnoreCase("null")) {
				ContactPage.Address1_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 1");
			} else {
				ContactPage.Address1_textField().sendKeys(Address1);
				Constants.test.log(Status.PASS, "enter Address 1");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 1");
			Assert.fail("failed to enter value in Address 1 text field");
		}
	}
	
	public static void enterMassAddress1(String Address1) {
		try {
			if (Address1.equalsIgnoreCase("null")) {
				ContactPage.MassAddress1_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 1");
			} else {
				ContactPage.MassAddress1_textField().sendKeys(Address1);
				Constants.test.log(Status.PASS, "enter Address 1");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 1");
			Assert.fail("failed to enter value in Address 1 text field");
		}
	}
	
	public static void clearAddress1() {
		try {
			ContactPage.Edit_Address1_textField().clear();
			Constants.test.log(Status.PASS, "Address 1 is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address 1 is not set to empty");
			Assert.fail("failed to empty Address 1 field");
		}
	}
	
	public static void clearAddress2() {
		try {
			ContactPage.Edit_Address2_textField().clear();
			Constants.test.log(Status.PASS, "Address 2 is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Address 2 is not set to empty");
			Assert.fail("failed to empty Address 2 field");
		}
	}
	
	public static void clearCity() {
		try {
			ContactPage.Edit_City_textField().clear();
			Constants.test.log(Status.PASS, "City is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "City is not set to empty");
			Assert.fail("failed to empty City field");
		}
	}
	
	public static void clearZip() {
		try {
			ContactPage.Edit_Zipcode_textField().clear();
			Constants.test.log(Status.PASS, "Zip is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Zip is not set to empty");
			Assert.fail("failed to empty Zip field");
		}
	}
	
	public static void clearPhone() {
		try {
			ContactPage.Edit_Phone_textField().clear();
			Constants.test.log(Status.PASS, "Phone is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Phone is not set to empty");
			Assert.fail("failed to empty Phone field");
		}
	}
	
	public static void clearTTY() {
		try {
			ContactPage.Edit_TTY_textField().clear();
			Constants.test.log(Status.PASS, "TTY is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "TTY is not set to empty");
			Assert.fail("failed to empty TTY field");
		}
	}
	
	public static void clearEmail() {
		try {
			ContactPage.Edit_Email_textField().clear();
			Constants.test.log(Status.PASS, "Email is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Email is not set to empty");
			Assert.fail("failed to empty Email field");
		}
	}
	
	public static void clearFax() {
		try {
			ContactPage.Edit_Fax_textField().clear();
			Constants.test.log(Status.PASS, "Fax is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Fax is not set to empty");
			Assert.fail("failed to empty Fax field");
		}
	}
	
	public static void clearWebsite() {
		try {
			ContactPage.Edit_Website_textField().clear();
			Constants.test.log(Status.PASS, "Website is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Website is not set to empty");
			Assert.fail("failed to empty Website field");
		}
	}
	
	public static void clearHoursOfOperation() {
		try {
			ContactPage.Edit_Hours_textField().clear();
			Constants.test.log(Status.PASS, "HoursOfOperation is set to empty");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "HoursOfOperation is not set to empty");
			Assert.fail("failed to empty HoursOfOperation field");
		}
	}
	
	public static void enterFax(String Fax) {
		try {
			if (Fax.equalsIgnoreCase("null")) {
				ContactPage.Fax_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Fax");
			} else {
				ContactPage.Fax_textField().sendKeys(Fax);
				Constants.test.log(Status.PASS, "enter Fax");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Fax");
			Assert.fail("failed to enter value in Fax text field");
		}
	}
	
	public static void enterAddress2(String Address2) {
		try {
			if (Address2.equalsIgnoreCase("null")) {
				ContactPage.Address2_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 2");
			} else {
				ContactPage.Address2_textField().sendKeys(Address2);
				Constants.test.log(Status.PASS, "enter Address 2");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 2");
			Assert.fail("failed to enter value in Address 2 text field");
		}
	}
	
	public static void enterMassAddress2(String Address2) {
		try {
			if (Address2.equalsIgnoreCase("null")) {
				ContactPage.MassAddress2_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 2");
			} else {
				ContactPage.MassAddress2_textField().sendKeys(Address2);
				Constants.test.log(Status.PASS, "enter Address 2");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 2");
			Assert.fail("failed to enter value in Address 2 text field");
		}
	}
	
	public static void enterCity(String City) {
		try {
			if (City.equalsIgnoreCase("null")) {
				ContactPage.City_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter City");
			} else {
				ContactPage.City_textField().sendKeys(City);
				Constants.test.log(Status.PASS, "enter City");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter City");
			Assert.fail("failed to enter value in City text field");
		}
	}
	
	public static void enterMassCity(String City) {
		try {
			if (City.equalsIgnoreCase("null")) {
				ContactPage.City_MasstextField().sendKeys("");
				Constants.test.log(Status.PASS, "enter City");
			} else {
				ContactPage.City_MasstextField().sendKeys(City);
				Constants.test.log(Status.PASS, "enter City");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter City");
			Assert.fail("failed to enter value in City text field");
		}
	}
	
	public static void enterZip(String Zip) {
		try {
			if (Zip.equalsIgnoreCase("null")) {
				ContactPage.Zipcode_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Zip");
			} else {
				ContactPage.Zipcode_textField().sendKeys(Zip);
				Constants.test.log(Status.PASS, "enter Zip");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Zip");
			Assert.fail("failed to enter value in City text field");
		}
	}
	
	public static void enterExceptionsZip(String Zip) {
		try {
			if (Zip.equalsIgnoreCase("null")) {
				ContactPage.Create_ZipCode_Edit().sendKeys("");
				Constants.test.log(Status.PASS, "enter Zip");
			} else {
				ContactPage.Create_ZipCode_Edit().sendKeys(Zip);
				Constants.test.log(Status.PASS, "enter Zip");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Zip");
			Assert.fail("failed to enter value in Zip text field");
		}
	}
	
	public static void enterMassZip(String Zip) {
		try {
			if (Zip.equalsIgnoreCase("null")) {
				ContactPage.Mass_ZipCode_Edit().sendKeys("");
				Constants.test.log(Status.PASS, "enter Zip");
			} else {
				ContactPage.Mass_ZipCode_Edit().sendKeys(Zip);
				Constants.test.log(Status.PASS, "enter Zip");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Zip");
			Assert.fail("failed to enter value in Zip text field");
		}
	}
	
	public static void enterPhone(String Phone) {
		try {
			if (Phone.equalsIgnoreCase("null")) {
				ContactPage.Phone_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Phone");
			} else {
				ContactPage.Phone_textField().sendKeys(Phone);
				Constants.test.log(Status.PASS, "enter Phone");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Phone");
			Assert.fail("failed to enter value in Phone text field");
		}
	}
	
	public static void enterHours(String Hours) {
		try {
			if (Hours.equalsIgnoreCase("null")) {
				ContactPage.Hours_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Hours");
			} else {
				ContactPage.Hours_textField().sendKeys(Hours);
				Constants.test.log(Status.PASS, "enter Hours");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Hours");
			Assert.fail("failed to enter value in Hours text field");
		}
	}
	
	public static void enterWebsite(String Website) {
		try {
			if (Website.equalsIgnoreCase("null")) {
				ContactPage.Website_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Website");
			} else {
				ContactPage.Website_textField().sendKeys(Website);
				Constants.test.log(Status.PASS, "enter Website");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Website");
			Assert.fail("failed to enter value in Website text field");
		}
	}
	
	public static void enterExceptionsWebsite(String Website) {
		try {
			if (Website.equalsIgnoreCase("null")) {
				ContactPage.Create_Website_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Website");
			} else {
				ContactPage.Create_Website_textField().sendKeys(Website);
				Constants.test.log(Status.PASS, "enter Website");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Website");
			Assert.fail("failed to enter value in Website text field");
		}
	}
	
	public static void enterEmail(String Email) {
		try {
			if (Email.equalsIgnoreCase("null")) {
				ContactPage.Email_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Email");
			} else {
				ContactPage.Email_textField().sendKeys(Email);
				Constants.test.log(Status.PASS, "enter Email");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Email");
			Assert.fail("failed to enter value in Email text field");
		}
	}
	
	public static void enterTTY(String TTY) {
		try {
			if (TTY.equalsIgnoreCase("null")) {
				ContactPage.TTY_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter TTY");
			} else {
				ContactPage.TTY_textField().sendKeys(TTY);
				Constants.test.log(Status.PASS, "enter TTY");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter TTY");
			Assert.fail("failed to enter value in TTY text field");
		}
	}
	
	public static void enterEditFax(String Fax) {
		try {
			if (Fax.equalsIgnoreCase("null")) {
				ContactPage.Edit_Fax_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Fax");
			} else {
				ContactPage.Edit_Fax_textField().sendKeys(Fax);
				Constants.test.log(Status.PASS, "enter Fax");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Fax");
			Assert.fail("failed to enter value in Fax text field");
		}
	}
	
	public static void enterGroupNumber(String groupNumber) {
		try {
			if (groupNumber.equalsIgnoreCase("null")) {
				ContactPage.GroupNumber_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter groupNumber");
			} else {
				ContactPage.GroupNumber_textField().sendKeys(groupNumber);
				Constants.test.log(Status.PASS, "enter groupNumber");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter groupNumber");
			Assert.fail("failed to enter value in groupNumber text field");
		}
	}
	
	public static void enterEditAddress2(String Address2) {
		try {
			if (Address2.equalsIgnoreCase("null")) {
				ContactPage.Edit_Address2_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 2");
			} else {
				ContactPage.Edit_Address2_textField().sendKeys(Address2);
				Constants.test.log(Status.PASS, "enter Address 2");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 2");
			Assert.fail("failed to enter value in Address 2 text field");
		}
	}
	public static void enterEditAddress1(String Address1) {
		try {
			if (Address1.equalsIgnoreCase("null")) {
				ContactPage.Edit_Address1_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Address 1");
			} else {
				ContactPage.Edit_Address1_textField().sendKeys(Address1);
				Constants.test.log(Status.PASS, "enter Address 1");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Address 1");
			Assert.fail("failed to enter value in Address 1 text field");
		}
	}
	
	public static void enterEditCity(String City) {
		try {
			if (City.equalsIgnoreCase("null")) {
				ContactPage.Edit_City_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter City");
			} else {
				ContactPage.Edit_City_textField().sendKeys(City);
				Constants.test.log(Status.PASS, "enter City");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter City");
			Assert.fail("failed to enter value in City text field");
		}
	}
	
	public static void enterEditZip(String Zip) {
		try {
			if (Zip.equalsIgnoreCase("null")) {
				ContactPage.Edit_Zipcode_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Zip");
			} else {
				ContactPage.Edit_Zipcode_textField().sendKeys(Zip);
				Constants.test.log(Status.PASS, "enter Zip");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Zip");
			Assert.fail("failed to enter value in City text field");
		}
	}
	public static void enterEditPhone(String Phone) {
		try {
			if (Phone.equalsIgnoreCase("null")) {
				ContactPage.Edit_Phone_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Phone");
			} else {
				ContactPage.Edit_Phone_textField().sendKeys(Phone);
				Constants.test.log(Status.PASS, "enter Phone");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Phone");
			Assert.fail("failed to enter value in Phone text field");
		}
	}
	
	public static void enterEditHours(String Hours) {
		try {
			if (Hours.equalsIgnoreCase("null")) {
				ContactPage.Edit_Hours_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Hours");
			} else {
				ContactPage.Edit_Hours_textField().sendKeys(Hours);
				Constants.test.log(Status.PASS, "enter Hours");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Hours");
			Assert.fail("failed to enter value in Hours text field");
		}
	}
	
	public static void enterEditWebsite(String Website) {
		try {
			if (Website.equalsIgnoreCase("null")) {
				ContactPage.Edit_Website_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Website");
			} else {
				ContactPage.Edit_Website_textField().sendKeys(Website);
				Constants.test.log(Status.PASS, "enter Website");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Website");
			Assert.fail("failed to enter value in Website text field");
		}
	}
	
	public static void enterEditEmail(String Email) {
		try {
			if (Email.equalsIgnoreCase("null")) {
				ContactPage.Edit_Email_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Email");
			} else {
				ContactPage.Edit_Email_textField().sendKeys(Email);
				Constants.test.log(Status.PASS, "enter Email");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Email");
			Assert.fail("failed to enter value in Email text field");
		}
	}
	
	public static void ValidateEditEmailCharLen(String lenEntered) {
		try {
			int intEmailEntered = Integer.parseInt(lenEntered);
			Integer len_email = ContactPage.Edit_Email_textField().getText().length();
			System.out.print(len_email);
			if (len_email == 251) {
				Constants.test.log(Status.PASS, "Email length verified :" + len_email + "Number of characters entered" + intEmailEntered);
			} else {
				Constants.test.log(Status.FAIL, "Email length not verified :" + len_email + "Number of characters entered" + intEmailEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Email text field");
			Assert.fail("failed to get character lengh in Email text field");
		}
	}
	
	public static void ValidateEditAddress1CharLen(String lenEntered) {
		try {
			int intAddress1Entered = Integer.parseInt(lenEntered);
			Integer len_Address1 = ContactPage.Address1_textField().getText().length();
			System.out.print(len_Address1);
			if (len_Address1 == 201) {
				Constants.test.log(Status.PASS, "Address1 length verified :" + len_Address1 + "Number of characters entered" + intAddress1Entered);
			} else {
				Constants.test.log(Status.FAIL, "Address1 length not verified :" + len_Address1 + "Number of characters entered" + intAddress1Entered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Address1 text field");
			Assert.fail("failed to get character lengh in Address1 text field");
		}
	}
	
	public static void ValidateEditAddress2CharLen(String lenEntered) {
		try {
			int intAddress2Entered = Integer.parseInt(lenEntered);
			Integer len_Address2 = ContactPage.Address2_textField().getText().length();
			System.out.print(len_Address2);
			if (len_Address2 == 202) {
				Constants.test.log(Status.PASS, "Address2 length verified :" + len_Address2 + "Number of characters entered" + intAddress2Entered);
			} else {
				Constants.test.log(Status.FAIL, "Address2 length not verified :" + len_Address2 + "Number of characters entered" + intAddress2Entered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Address2 text field");
			Assert.fail("failed to get character lengh in Address2 text field");
		}
	}
	
	public static void ValidateEditCityCharLen(String lenEntered) {
		try {
			int intCityEntered = Integer.parseInt(lenEntered);
			Integer len_City = ContactPage.Create_City_Edit().getText().length();
			System.out.print(len_City);
			if (len_City == 51) {
				Constants.test.log(Status.PASS, "City length verified :" + len_City + "Number of characters entered" + intCityEntered);
			} else {
				Constants.test.log(Status.FAIL, "City length not verified :" + len_City + "Number of characters entered" + intCityEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in City text field");
			Assert.fail("failed to get character lengh in City text field");
		}
	}
	
	public static void ValidateEditZipCharLen(String lenEntered) {
		try {
			int intZipEntered = Integer.parseInt(lenEntered);
			Integer len_Zip = ContactPage.Create_ZipCode_Edit().getText().length();
			System.out.print(len_Zip);
			if (len_Zip == 16) {
				Constants.test.log(Status.PASS, "Zip length verified :" + len_Zip + "Number of characters entered" + intZipEntered);
			} else {
				Constants.test.log(Status.FAIL, "Zip length not verified :" + len_Zip + "Number of characters entered" + intZipEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Zip text field");
			Assert.fail("failed to get character lengh in Zip text field");
		}
	}
	
	public static void ValidateEditTTYCharLen(String lenEntered) {
		try {
			int intTTYEntered = Integer.parseInt(lenEntered);
			Integer len_TTY = ContactPage.Create_TTY_Edit().getText().length();
			System.out.print(len_TTY);
			if (len_TTY == 14) {
				Constants.test.log(Status.PASS, "TTY length verified :" + len_TTY + "Number of characters entered" + intTTYEntered);
			} else {
				Constants.test.log(Status.FAIL, "TTY length not verified :" + len_TTY + "Number of characters entered" + intTTYEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in TTY text field");
			Assert.fail("failed to get character lengh in TTY text field");
		}
	}
	
	public static void ValidateEditWebsiteCharLen(String lenEntered) {
		try {
			int intWebsiteEntered = Integer.parseInt(lenEntered);
			Integer len_Website = ContactPage.Create_Website_textField().getText().length();
			System.out.print(len_Website);
			if (len_Website == 14) {
				Constants.test.log(Status.PASS, "Website length verified :" + len_Website + "Number of characters entered" + intWebsiteEntered);
			} else {
				Constants.test.log(Status.FAIL, "Website length not verified :" + len_Website + "Number of characters entered" + intWebsiteEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Website text field");
			Assert.fail("failed to get character lengh in Website text field");
		}
	}
	
	public static void ValidateEditHoursCharLen(String lenEntered) {
		try {
			int intHoursEntered = Integer.parseInt(lenEntered);
			Integer len_Hours = ContactPage.Create_HoursOfOperation_Edit().getText().length();
			System.out.print(len_Hours);
			if (len_Hours == 14) {
				Constants.test.log(Status.PASS, "Hours length verified :" + len_Hours + "Number of characters entered" + intHoursEntered);
			} else {
				Constants.test.log(Status.FAIL, "Hours length not verified :" + len_Hours + "Number of characters entered" + intHoursEntered);
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "failed to get character lengh in Hours text field");
			Assert.fail("failed to get character lengh in Hours text field");
		}
	}
	
	public static void enterEditTTY(String TTY) {
		try {
			if (TTY.equalsIgnoreCase("null")) {
				ContactPage.Edit_TTY_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter TTY");
			} else {
				ContactPage.Edit_TTY_textField().sendKeys(TTY);
				Constants.test.log(Status.PASS, "enter TTY");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter TTY");
			Assert.fail("failed to enter value in TTY text field");
		}
	}
	
	public static void selectPlanYear(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanYear').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				ContactPage.year_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select plan year");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select plan year");
			Assert.fail("failed to select an option from plan year dropdown");
		}
	}
	
	public static void selectContractRule(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContractNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Contract Number year");
			} else {
				ContactPage.ContractRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Contract Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Contract Number");
			Assert.fail("failed to select an option from Contract Number dropdown");
		}
	}
	
	public static void selectRulePlanName(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanName').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Plan Name");
			} else {
				ContactPage.PlanNameRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Plan Name");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Plan Name");
			Assert.fail("failed to select an option from Plan Name dropdown");
		}
	}
	public static void selectPBPRule(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PBPNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				ContactPage.PBPRule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select PBPNumber");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select PBPNumber");
			Assert.fail("failed to select an option from PBPNumber dropdown");
		}
	}
	
	public static void selectRuleState(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactFields_0__StateCode').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Rule State");
			} else {
				ContactPage.State_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Rule State");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Rule State");
			Assert.fail("failed to select an option from Rule State dropdown");
		}
	}
	
	public static void selectExceptionsState(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('StateCode'");
				Constants.test.log(Status.PASS, "select Exceptions State");
			} else {
				ContactPage.Create_State_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Exceptions State");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Exceptions State");
			Assert.fail("failed to select an option from Exceptions State dropdown");
		}
	}
	
	public static void selectMassState(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactRuleData_StateCode'");
				Constants.test.log(Status.PASS, "select Mass State");
			} else {
				ContactPage.Mass_State_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Mass State");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Mass State");
			Assert.fail("failed to select an option from Mass State dropdown");
		}
	}

	public static void selectIncludeIndicator(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('IncludeIndicator').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select plan year");
			} else {
				ContactPage.IncludeIndicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Include Indicator");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Include Indicator");
			Assert.fail("failed to select an option from Include Indicator dropdown");
		}
	}
	
	public static void selectGroupType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('GroupType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select category");
			} else {
				ContactPage.GroupType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select category");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select category");
			Assert.fail("failed to select an optoin from category dropdown");
		}
	}

	public static void selectRuleType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactRuleType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				ContactPage.RuleType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	
	public static void selectContactType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select status");
			} else {
				ContactPage.ContactType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	
	public static void selectAllContactType() {
		try {
			Constants.test.log(Status.PASS, "select Contact Type");
			List<WebElement> contactTypeOptions = ContactPage.ContactType_dropdown().getOptions();
			for (WebElement item : contactTypeOptions){
				ContactPage.ContactType_dropdown().selectByVisibleText(item.getText());
				Thread.sleep(2000);
				Actions_ContactPage.selectAllRuleType();
			}
			Constants.test.log(Status.PASS, "All values selected for Contact Type Dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an optoin from status dropdown");
		}
	}
	
	public static void selectAllRuleType() {
		try {
			Constants.test.log(Status.PASS, "select status");
			List<WebElement> ruleTypeOptions = ContactPage.RuleType_dropdown().getOptions();
			for (WebElement rule : ruleTypeOptions){
				ContactPage.RuleType_dropdown().selectByVisibleText(rule.getText());
			}
			Constants.test.log(Status.PASS, "All values selected for Rule Type Dropdown");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select status");
			Assert.fail("failed to select an option from Rule dropdown");
		}
	}
	
	public static void selectCreateRuleType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('ContactRuleType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Rule Type");
			} else {
				ContactPage.RuleType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Rule Type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Rule Type");
			Assert.fail("failed to select an option from Rule Type dropdown");
		}
	}

	public static void clickOnSearchContactsButton() {
		try {
			ContactPage.searchContact_button().click();
			Constants.test.log(Status.PASS, "click on search Contact button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search Contact button");
			Assert.fail("failed to click on search Contact button");
		}
	}
	
	public static void clickOnMassUpdateButton() {
		try {
			ContactPage.MassUpdate_button().click();
			Constants.test.log(Status.PASS, "click on Mass Update button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Mass Update button");
			Assert.fail("failed to click on Mass Update button");
		}
	}
	
	public static void clickOnSubmitRecordButton() {
		try {
			ContactPage.submitRecord_button().click();
			Constants.test.log(Status.PASS, "click on Submit Record button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Submit Record button");
			Assert.fail("failed to click on Submit Record button");
		}
	}
	
	public static void clickOnSearchIndExceptionsButton() {
		try {
			ContactPage.SearchContactExceptions_Button().click();
			Constants.test.log(Status.PASS, "click on search Contact Exceptions button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search Contact Exceptions button");
			Assert.fail("failed to click on search Contact Exceptions button");
		}
	}
	
	public static void clickOnSearchGroupExceptionsButton() {
		try {
			ContactPage.SearchGroupContactExceptions_Button().click();
			Constants.test.log(Status.PASS, "click on search Contact Exceptions button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search Contact Exceptions button");
			Assert.fail("failed to click on search Contact Exceptions button");
		}
	}
	
	public static void clickOnruleSaveButton() {
		try {
			ContactPage.rule_Save_button().click();
			Constants.test.log(Status.PASS, "click on Rule Save button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Rule Save button");
			Assert.fail("failed to click on Rule Save button");
		}
	}
	
	public static void clickOnruleSaveEditButton() {
		try {
			ContactPage.rule_SaveEdit_button().click();
			Constants.test.log(Status.PASS, "click on Rule Save button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Rule Save button");
			Assert.fail("failed to click on Rule Save button");
		}
	}
	
	public static void clickOnDefaultPlanCheckbox() {
		try {
			ContactPage.checkbox_SelectDefaultPlan().click();
			Constants.test.log(Status.PASS, "click on Default Plan Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Default Plan Checkbox");
			Assert.fail("failed to click on Default Plan Checkbox");
		}
	}
	
	public static void clickOnFirstEditCheckbox() {
		try {
			ContactPage.checkbox_EditRecord().click();
			Constants.test.log(Status.PASS, "click on Default Contact Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Default Contact Checkbox");
			Assert.fail("failed to click on Default Contact Checkbox");
		}
	}
	
	public static void clickOnSecondEditCheckbox() {
		try {
			ContactPage.checkbox_EditSecondRecord().click();
			Constants.test.log(Status.PASS, "click on Second Contact Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Second Contact Checkbox");
			Assert.fail("failed to click on Second Contact Checkbox");
		}
	}
	
	public static void clickOnDeleteContactButton() {
		try {
			ContactPage.DeleteContact_button().click();
			Constants.test.log(Status.PASS, "click on Delete Contact button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Delete Contact button");
			Assert.fail("failed to click on Delete Contact button");
		}
	}
	public static void clickOnCreateRuleButton() {
		try {
			ContactPage.createRule_button().click();
			Constants.test.log(Status.PASS, "click on Create Rule button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Create Rule button");
			Assert.fail("failed to click on Create Rule button");
		}
	}
	
	public static void clickOnSearchPlans() {
		try {
			ContactPage.SearchPlans_button().click();
			Constants.test.log(Status.PASS, "click on Search Plans button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Plans button");
			Assert.fail("failed to click on Search Plans button");
		}
	}
	
	public static void clickOnSearchMassEdit() {
		try {
			ContactPage.SearchMassEdit_button().click();
			Constants.test.log(Status.PASS, "click on Search Contact button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Contact button");
			Assert.fail("failed to click on Search Contact button");
		}
	}
	
	public static void clickOnEditContactLink() {
		try {
			ContactPage.EditContact_link().click();
			Constants.test.log(Status.PASS, "click on Edit Contact Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Edit Contact Link");
			Assert.fail("failed to click on Edit Contact Link");
		}
	}
	
	public static void clickOnEditRuleLink() {
		try {
			ContactPage.EditRule_link().click();
			Constants.test.log(Status.PASS, "click on Edit Rule Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Edit Rule Link");
			Assert.fail("failed to click on Edit Rule Link");
		}
	}
	
	public static void clickOnSelectPlanCheckbox() {
		try {
			Utils.click(ContactPage.checkbox_SelectDefaultPlan());
			Constants.test.log(Status.PASS, "click on Select Plan Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Select Plan Checkbox");
			Assert.fail("failed to click on Select Plan Checkbox");
		}
	}

	public static void compareUIsearchResutlsWithDatabase_employer() {
		try {
			XSSFSheet sheet = Utils.excel_sheet("./src/test/java/testData/Plan/Plan_SearchTab_AllFields.xlsx",
					"Individual");
			String QEREY = Constants.Input_SQLS.getRow(4).getCell(1).getStringCellValue();
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(1).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(1).getCell(0).getStringCellValue());
			System.out.println(QEREY);
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int i = 0; i < Constants.resultsetMetadata.getColumnCount(); i++) {
				DBresults.put(Constants.resultsetMetadata.getColumnName(i), Constants.resultset.getString(i));
			}
			System.out.println(Constants.resultset);
			Assert.assertTrue(ContactPage.serchResult_noOf_rows() == 1);
			Assert.assertTrue(driver.getPageSource().contains("2017 - H0251 - 002"));
			Assert.assertTrue(driver.getPageSource().contains("UnitedHealthcare Dual Complete (HMO SNP)"));
			Constants.test.log(Status.PASS, "compare UI search results with database");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}

	public static void compareUIsearchResutlsWithDatabase(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(row).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(row).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				Assert.assertTrue(ContactPage.serchResult_noOf_rows() == 1);
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(driver.getPageSource().contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactTypeWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.ContactType_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactContractWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.ContractRule_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactPBPWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.PBPRule_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactPlanNameWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.PlanNameRule_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactBrandWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.BrandRule_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void compareContactBusinessWithDatabase(String Query, String inputFileName, String sheetName, Integer parameterCol)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(1).getCell(parameterCol).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			ArrayList<String> arrList = new ArrayList<String>();
			List<WebElement> contactTypeOptions = ContactPage.BusinessSegmentRule_dropdown().getOptions();			
			for (WebElement item : contactTypeOptions){
				arrList.add(item.getText());
			}
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					if (value != null)
						System.out.println(value);
						Assert.assertTrue(arrList.contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		}
			catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void VerifyContactRuleDataStatus(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(row).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(row).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				Assert.assertTrue(ContactPage.serchResult_noOf_rows() == 1);
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(value != "3");
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void VerifyContactRuleDataStatusUpdate(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(row).getCell(8).getStringCellValue())
					.replace("parameter3", sheet.getRow(row).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				Assert.assertTrue(ContactPage.serchResult_noOf_rows() == 1);
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(value == "2");
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void VerifyContactDeletedRuleDataStatus(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(row).getCell(5).getStringCellValue())
					.replace("parameter3", sheet.getRow(row).getCell(0).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(value == "3");
				}
				Constants.test.log(Status.PASS, "Contact Rule data status ID verified: Pass");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Contact Rule data status ID not verified: Fail");
			Assert.fail("Contact Rule data status ID not verified: Fail");
		}
	}
	
	public static void VerifyNoRecordsinDatabase(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(4).getStringCellValue())
					.replace("parameter2", sheet.getRow(row).getCell(5).getStringCellValue())
					.replace("parameter3", sheet.getRow(row).getCell(6).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value == null);
					Constants.test.log(Status.PASS, "Data does not exist in database");
				}
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Data exist in database");
			Assert.fail("Data exist in database");
		}
	}

	public static void VerifyPlanStatus(String option) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(option));
			Constants.test.log(Status.PASS, "Plan Status verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Plan Status verification failed");
			Assert.fail("Plan Status verification failed");
		}
	}
	
	public static void VerifyNoSearchRecords() {
		try {
			Assert.assertTrue(ContactPage.SearchExceptions_NoRecords().isDisplayed());
			Constants.test.log(Status.PASS, "No records displayed for Invalid Group Number verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Records displayed for Invalid Group Number verification Passed");
			Assert.fail("Records displayed for Invalid Group Number verification Passed");
		}
	}
	
	public static void VerifyUserIsOnSamePage() {
		try {
			Assert.assertTrue(ContactPage.rule_Save_button().isDisplayed());
			Constants.test.log(Status.PASS, "User is on Create New Individual Rule page: Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "User is on Create New Individual Rule page: failed");
			Assert.fail("User is on Create New Individual Rule page: failed");
		}
	}
	
	public static void VerifyGroupType(String option) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(option));
			Constants.test.log(Status.PASS, "Group Type verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Group Type verification failed");
			Assert.fail("Group Type verification failed");
		}
	}
	
	public static void VerifyRecordsCount(String option) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(option));
			Constants.test.log(Status.PASS, "Record Count verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Record Count verification failed");
			Assert.fail("Record Count verification failed");
		}
	}
	
	public static void VerifyStateError(String option) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(option));
			Constants.test.log(Status.PASS, "State Error verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "State Error verification failed");
			Assert.fail("State Error verification failed");
		}
	}
	
	public static void VerifyFaxError(String option) {
		try {
			Assert.assertTrue(driver.getPageSource().contains(option));
			Constants.test.log(Status.PASS, "Fax Error verification Passed");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Fax Error verification failed");
			Assert.fail("Fax Error verification failed");
		}
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
		try {
		for (int i = 0; i <= i; i++) {
		if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
		break;
		}
		}
		} catch (JavascriptException e) {
		}
		}
	
	public static void compareContactRule(String Query, String inputFileName, String sheetName, Integer row, String Option)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", Option);
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(driver.getPageSource().contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI search results with database");
			Assert.fail("failed to compare UI search results with database");
		}
	}
	
	public static void VerifyGroupSearchResults(String Query, String inputFileName, String sheetName, Integer row)
			throws ClassNotFoundException, SQLException, InterruptedException {
		try {
			XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
			String QEREY = Query;
			QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(1).getStringCellValue());
			Utils.connectToSqlserverDB();
			Thread.sleep(3000);
			Constants.resultset = Constants.statement.executeQuery(QEREY);
			Thread.sleep(3000);
			Constants.resultsetMetadata = Constants.resultset.getMetaData();
			LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
			for (int k = 0; Constants.resultset.next(); k++) {
				for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
					DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
				}

				Assert.assertTrue(ContactPage.serchContactExpResult_noOf_rows() == 1);
				for (String value : DBresults.values()) {
					System.out.println(value);
					if (value != null)
						Assert.assertTrue(driver.getPageSource().contains(value));
				}
				Constants.test.log(Status.PASS, "compare UI Contact Exceptions search results with database");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "compare UI Contact Exceptions search results with database");
			Assert.fail("failed to compare UI Contact Exceptions search results with database");
		}
	}
	public static void clickOnCheckAllCheckbox() {
		try {
			ContactPage.checkbox_SelectGroupRecordAll().click();
			Constants.test.log(Status.PASS, "click on Select All Group Checkbox");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Select All Group Checkbox");
			Assert.fail("failed to click on Select All Group Checkbox");
		}
	}
	public static void clickOnDeleteExceptionButton() {
		try {
			ContactPage.GroupDelete_Button().click();
			Constants.test.log(Status.PASS, "click on Delete Exception button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Delete Exception button");
			Assert.fail("failed to click on Delete Exception button");
		}
	}
	
	public static void clickOnUpdateExceptionButton() {
		try {
			ContactPage.GroupUpdate_Button().click();
			Constants.test.log(Status.PASS, "click on Update Exception button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Update Exception button");
			Assert.fail("failed to click on Update Exception button");
		}
	}
	
	public static void clickOnCreateExceptionButton() {
		try {
			ContactPage.CreateContactExceptions_Button().click();
			Constants.test.log(Status.PASS, "click on Create Exceptions button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Create Exceptions button");
			Assert.fail("failed to click on Create Exceptions button");
		}
	}
	
	public static void enterMasterGroupNumber(String MasterGroup) {
		try {
			if (MasterGroup.equalsIgnoreCase("null")) {
				ContactPage.Create_MasterGroupNumber_Edit().sendKeys("");
				Constants.test.log(Status.PASS, "enter MasterGroup");
			} else {
				ContactPage.Create_MasterGroupNumber_Edit().sendKeys(MasterGroup);
				Constants.test.log(Status.PASS, "enter MasterGroup");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter MasterGroup");
			Assert.fail("failed to enter value in MasterGroup text field");
		}
	}
	
	public static void enterCreateGroupNumber(String GroupNumber) {
		try {
			if (GroupNumber.equalsIgnoreCase("null")) {
				ContactPage.Create_GroupNumber_Edit().sendKeys("");
				Constants.test.log(Status.PASS, "enter GroupNumber");
			} else {
				ContactPage.Create_GroupNumber_Edit().sendKeys(GroupNumber);
				Constants.test.log(Status.PASS, "enter GroupNumber");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter GroupNumber");
			Assert.fail("failed to enter value in GroupNumber text field");
		}
	}
		
		public static void enterEffectiveDate(String EffectiveDate) {
			try {
				if (EffectiveDate.equalsIgnoreCase("null")) {
					ContactPage.Create_EffectiveDate_Edit().sendKeys("");
					Constants.test.log(Status.PASS, "enter EffectiveDate");
				} else {
					ContactPage.Create_EffectiveDate_Edit().sendKeys(EffectiveDate);
					Constants.test.log(Status.PASS, "enter EffectiveDate");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "enter EffectiveDate");
				Assert.fail("failed to enter value in EffectiveDate text field");
			}
	}
		
		public static void selectSiteName(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('DivisionID').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select SiteName");
				} else {
					ContactPage.Create_SiteName_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select SiteName");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select SiteName");
				Assert.fail("failed to select an option from SiteName dropdown");
			}
		}	
		
		public static void selectContactTypeException(String option) {
			try {
				if (option.equalsIgnoreCase("null")) {
					((JavascriptExecutor) driver).executeScript("document.getElementById('ContactTypeID').selectedIndex=0;");
					Constants.test.log(Status.PASS, "select ContactTypeException");
				} else {
					ContactPage.Create_ContactTypeID_dropdown().selectByVisibleText(option);
					Constants.test.log(Status.PASS, "select ContactTypeException");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select ContactTypeException");
				Assert.fail("failed to select an option from ContactTypeException dropdown");
			}
		}	
		public static void clickOnSaveExceptionButton() {
			try {
				ContactPage.Create_Save_Button().click();
				Constants.test.log(Status.PASS, "click on SaveException button");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on SaveException button");
				Assert.fail("failed to click on SaveException button");
			}
		}
		
		public static void VerifyNoRecordsinIndividualTable(String Query, String inputFileName, String sheetName, Integer row)
				throws ClassNotFoundException, SQLException, InterruptedException {
			try {
				XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
				String QEREY = Query;
				QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(1).getStringCellValue());
				Utils.connectToSqlserverDB();
				Thread.sleep(3000);
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				Thread.sleep(3000);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
				for (int k = 0; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
					}

					for (String value : DBresults.values()) {
						System.out.println(value);
						if (value == null);
						Constants.test.log(Status.PASS, "Data does not exist in database");
					}
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Data exist in database");
				Assert.fail("Data exist in database");
			}
		}
		public static void clickOnAddress1Checkbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateAddress1());
				Constants.test.log(Status.PASS, "click on Address1 Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Address1 Checkbox");
				Assert.fail("failed to click on Select Address1 Checkbox");
			}
		}
		
		public static void clickOnMassddress1Checkbox() {
			try {
				Utils.click(ContactPage.checkbox_MassUpdateAddress1());
				Constants.test.log(Status.PASS, "click on Address1 Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Address1 Checkbox");
				Assert.fail("failed to click on Select Address1 Checkbox");
			}
		}
		
		public static void clickOnAddress2Checkbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateAddress2());
				Constants.test.log(Status.PASS, "click on Address2 Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Address2 Checkbox");
				Assert.fail("failed to click on Select Address2 Checkbox");
			}
		}
		
		public static void clickOnMassAddress2Checkbox() {
			try {
				Utils.click(ContactPage.checkbox_MassAddress2());
				Constants.test.log(Status.PASS, "click on Address2 Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Address2 Checkbox");
				Assert.fail("failed to click on Select Address2 Checkbox");
			}
		}
		
		public static void clickOnCityCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateCity());
				Constants.test.log(Status.PASS, "click on City Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on City Checkbox");
				Assert.fail("failed to click on Select City Checkbox");
			}
		}
		
		public static void clickOnMassCityCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_MassCity());
				Constants.test.log(Status.PASS, "click on City Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on City Checkbox");
				Assert.fail("failed to click on Select City Checkbox");
			}
		}
		
		public static void clickOnStateCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateState());
				Constants.test.log(Status.PASS, "click on State Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on State Checkbox");
				Assert.fail("failed to click on Select State Checkbox");
			}
		}
		
		public static void clickOnMassStateCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_MassState());
				Constants.test.log(Status.PASS, "click on State Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on State Checkbox");
				Assert.fail("failed to click on Select State Checkbox");
			}
		}
		
		public static void clickOnZipCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateZip());
				Constants.test.log(Status.PASS, "click on Zip Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Zip Checkbox");
				Assert.fail("failed to click on Select Zip Checkbox");
			}
		}
		
		public static void clickOnMassZipCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_MassZip());
				Constants.test.log(Status.PASS, "click on Zip Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Zip Checkbox");
				Assert.fail("failed to click on Select Zip Checkbox");
			}
		}
		
		public static void clickOnPhoneCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdatePhone());
				Constants.test.log(Status.PASS, "click on Phone Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Phone Checkbox");
				Assert.fail("failed to click on Select Phone Checkbox");
			}
		}
		
		public static void clickOnTTYCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateTTY());
				Constants.test.log(Status.PASS, "click on TTY Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on TTY Checkbox");
				Assert.fail("failed to click on Select TTY Checkbox");
			}
		}
		
		public static void clickOnFaxCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateFax());
				Constants.test.log(Status.PASS, "click on Fax Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Fax Checkbox");
				Assert.fail("failed to click on Select Fax Checkbox");
			}
		}
		
		public static void clickOnEmailCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateEmail());
				Constants.test.log(Status.PASS, "click on Email Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Email Checkbox");
				Assert.fail("failed to click on Select Email Checkbox");
			}
		}
		
		public static void clickOnWebsiteCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateWebsite());
				Constants.test.log(Status.PASS, "click on Website Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Website Checkbox");
				Assert.fail("failed to click on Select Website Checkbox");
			}
		}
		
		public static void clickOnHoursCheckbox() {
			try {
				Utils.click(ContactPage.checkbox_UpdateHours());
				Constants.test.log(Status.PASS, "click on Hours Checkbox");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Hours Checkbox");
				Assert.fail("failed to click on Select Hours Checkbox");
			}
		}
		public static void clickOnCreateRule() {
			try {
				ContactPage.createRule_button().click();
				Constants.test.log(Status.PASS, "Clicked on Create Rule");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Clicked on Create Rule");
				Assert.fail("failed to Click on Create Rule button");
			}
		}
		public static void clickOnUpdateButton() {
			try {
				ContactPage.Button_Update().click();
				Constants.test.log(Status.PASS, "click on Update button");
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "click on Update button");
				Assert.fail("failed to click on Update button");
			}
		}
		
		public static void selectRule(String option) {
			try {

				ContactPage.rule_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select status");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from status dropdown");
			}
		}
		public static void selectContract(String option) {
			try {

				ContactPage.contract_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select contract");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from contract dropdown");
			}
		}
		public static void selectPBP(String option) {
			try {

				ContactPage.PBP_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select PBP");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "select status");
				Assert.fail("failed to select an optoin from PBP dropdown");
			}
		}
		public static void clickOnSearchPlan() {
			try {
				ContactPage.searchPlan_button().click();
				Constants.test.log(Status.PASS, "Clicked on Search plan");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Clicked on Search plan");
				Assert.fail("failed to Click on Search plan button");
			}
		}
		
		public static void checkPlanCheckbox(String contract, String PBP) {
			try {
				ContactPage.plan_checkBox(contract,PBP).click();
				Constants.test.log(Status.PASS, "Clicked on Search plan");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Clicked on Search plan");
				Assert.fail("failed to Click on Search plan button");
			}
		}
		public static void enterPhoneNumber(String phoneNumber) {
			try {
				ContactPage.phoneNumber_textField().sendKeys(phoneNumber);
				Constants.test.log(Status.PASS, "enter phoneNumber");

			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "enter phoneNumber");
				Assert.fail("failed to enter value in phoneNumber text field");
			}
		}
		public static void VerifyExceptionUpdateResults(String Query, String inputFileName, String sheetName, Integer row)
				throws ClassNotFoundException, SQLException, InterruptedException {
			try {
				XSSFSheet sheet = Utils.excel_sheet(inputFileName, sheetName);
				String QEREY = Query;
				QEREY = QEREY.replace("parameter1", sheet.getRow(row).getCell(1).getStringCellValue());
				Utils.connectToSqlserverDB();
				Thread.sleep(3000);
				Constants.resultset = Constants.statement.executeQuery(QEREY);
				Thread.sleep(3000);
				Constants.resultsetMetadata = Constants.resultset.getMetaData();
				LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
				for (int k = 0; Constants.resultset.next(); k++) {
					for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
						DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
					}
					for (String value : DBresults.values()) {
						System.out.println(value);
						if (value == sheet.getRow(row).getCell(19).getStringCellValue())
							Assert.assertTrue(driver.getPageSource().contains(value));
					}
					Constants.test.log(Status.PASS, "Contact Exceptions data updated successfully in database");
				}
			} catch (Exception e) {
				Constants.test.log(Status.FAIL, "Contact Exceptions data updated not successfully in database");
				Assert.fail("Contact Exceptions data updated not successfully in database");
			}
		}
}

