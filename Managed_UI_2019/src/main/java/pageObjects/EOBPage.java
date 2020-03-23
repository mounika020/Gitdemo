package pageObjects;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import utilities.Constants;
import utilities.Utils;

public class EOBPage extends BaseClass {

	public EOBPage(WebDriver driver) {
		super(driver);

	}

	public static WebElement createNewEOBPlanRule_button() {
		return driver.findElement(By.linkText("Create New EOB Plan Rule"));
	}

	public static WebElement searchEOBGroupExceptions_button() {
		return driver.findElement(By.xpath("//a[contains(@href,'/EOB/SearchPlanRuleException')]"));
	}

	public static WebElement CreateNewEOBGroupException_button() {
		return driver.findElement(By.linkText("Create New EOB Group Exception"));
	}

	public static Select planYear_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
	}

	public static Select category_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}

	public static Select contract_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContractNumber']")));
	}

	public static Select PBP_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PBPNumber']")));
	}

	public static Select drugCoverageType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='DrugCoverageType']")));
	}

	public static Select claimsSystem_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SourceSystem']")));
	}

	public static Select businessSegment_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='BusinessSegment']")));
	}

	public static Select language_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EOBLanguage']")));
	}

	public static Select SNPType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SNPType']")));
	}

	public static WebElement search_button() {
		return driver.findElement(By.xpath("//input[@id='search-button']"));
	}

	public static WebElement clear_button() {
		return driver.findElement(By.xpath("//input[@id='clear-search']"));
	}

	public static WebElement deletePlanRules_button() {
		return driver.findElement(By.xpath("//input[@id='btnDelete']"));
	}

	public static WebElement Arabic_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Arabic')]/input"));
	}

	public static WebElement Chinese_Cantonese_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Chinese (Cantonese)')]/input"));
	}

	public static WebElement Chinese_Mandarin_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Chinese (Mandarin)')]/input"));
	}

	public static WebElement Creole_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Creole')]/input"));
	}

	public static WebElement French_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'French')]/input"));
	}

	public static WebElement Hawaiian_Pidgin_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Hawaiian (Pidgin)')]/input"));
	}

	public static WebElement Hindi_India_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Hindi (India)')]/input"));
	}

	public static WebElement Italian_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Italian')]/input"));
	}

	public static WebElement Korean_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Korean')]/input"));
	}

	public static WebElement Philippine_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Philippine')]/input"));
	}

	public static WebElement Polish_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Polish')]/input"));
	}

	public static WebElement Spanish_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Spanish')]/input"));
	}

	public static WebElement Russian_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Russian')]/input"));
	}

	public static WebElement Vietnamese_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Vietnamese')]/input"));
	}

	public static WebElement save_button() {
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}

	public static WebElement cancel_link() {
		return driver.findElement(By.xpath("//a[text()='Cancel']"));
	}

	public static WebElement master_group_number_textField() {
		return driver.findElement(By.xpath("//input[@id='MasterGroupNumber']"));
	}

	public static WebElement group_number_textField() {
		return driver.findElement(By.xpath("//input[@id='GroupNumber']"));
	}

	public static WebElement group_effective_date_textField() {
		return driver.findElement(By.xpath("//input[@id='GroupEffectiveDate']"));
	}

	public static Select siteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SiteName']")));
	}

	public static Select searchEOBgroup_EOBindicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EOBIndicator']")));
	}

	public static WebElement deleteGroupException_button() {
		return driver.findElement(By.xpath("//input[@value='Delete Group Exception(s)']"));
	}

	public static WebElement udpateGroupException_button() {
		return driver.findElement(By.xpath("//input[@value='Update Group Exception(s)']"));
	}

	public static WebElement update_button() {
		return driver.findElement(By.xpath("//input[@value='Update']"));
	}

	public static Select EOBindicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='IsEOB']")));
	}

	public static WebElement EOBGroupException_single_chkbox(String masterGroupNumber, String groupNumber,
			String effectiveDate, String siteName) {
		return driver.findElement(By.xpath("//tr[contains(.,'" + masterGroupNumber + groupNumber + "') and contains(.,'"
				+ effectiveDate + siteName + "')]"));
	}

	public static WebElement EOBGroupException_All_chkbox() {
		return driver.findElement(By.xpath(".//*[@id='chkAll']"));
	}
}
