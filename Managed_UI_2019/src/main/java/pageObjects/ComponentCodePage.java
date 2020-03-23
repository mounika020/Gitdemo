package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class ComponentCodePage extends BaseClass {

	public ComponentCodePage(WebDriver driver) throws InvalidFormatException, IOException {
		super(driver);
	}

	public static WebElement uploadFileTemplate_button() {
		return driver.findElement(By.xpath("//a[text()='Upload File Template' and @class='btn btn-primary']"));
	}

	public static WebElement uploadFileTemplate_popUp_browsButton() {
		return driver.findElement(By.xpath("//*[@id='file']"));
	}

	public static WebElement uploadFileTemplate_popUp_upload_button() {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}

	public static WebElement uploadFileTemplate_popUp_cancel_button() {
		return driver.findElement(By.xpath("//button[text()='Cancel']"));
	}

	public static WebElement proceesRecords_button() {
		return driver.findElement(By.xpath("//input[@value='Process Records']"));
	}

	public static WebElement click_here_linkToReturnToMainScreen() {
		return driver.findElement(By.xpath("//a[@href='/ComponentCode']"));
	}

	public static Select dataType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}

	public static Select recordType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='RecordType']")));
	}

	public static WebElement componentCode_textField() {
		return driver.findElement(By.xpath("//input[@id='ComponentCode']"));
	}

	public static Select planYear_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='IndividualComponentCodeModel_PlanYear']")));
	}

	public static Select contractNumber_dropdown_individual() {
		return new Select(driver.findElement(By.xpath(".//select[@id='IndividualComponentCodeModel_ContractNumber']")));
	}
	
	public static Select contractNumber_dropdown_employer() {
		return new Select(driver.findElement(By.xpath(".//select[@id='EmployerComponentCodeModel_ContractNumber']")));
	}


	public static Select PBPnumber_dropdown_individual() {
		return new Select(driver.findElement(By.xpath(".//select[@id='IndividualComponentCodeModel_PBPNumber']")));
	}
	
	public static Select PBPnumber_dropdown_employer() {
		return new Select(driver.findElement(By.xpath(".//select[@id='EmployerComponentCodeModel_PBPNumber']")));
	}

	public static Select compareContractNumber_dropdown_individual() {
		return new Select(
				driver.findElement(By.xpath(".//select[@id='IndividualComponentCodeModel_CompareContractNumber']")));
	}
	
	public static Select compareContractNumber_dropdown_employer() {
		return new Select(
				driver.findElement(By.xpath(".//select[@id='EmployerComponentCodeModel_CompareContractNumber']")));
	}

	public static Select comparePBPnumber_dropdown() {
		return new Select(
				driver.findElement(By.xpath(".//select[@id='EmployerComponentCodeModel_CompareMasterGroupNumber']")));
	}

	public static WebElement search_button() {
		return driver.findElement(By.xpath(".//input[@id='SearchComponentButton']"));
	}

	public static int searchResults_tableHeadingsCount() {
		List<WebElement> headings = new ArrayList<WebElement>();
		headings = driver.findElements(By.xpath("//table[@id='grid']/thead/tr/th"));
		return headings.size();
	}

	public static WebElement searchResults_tableHeadings_index(int index) {
		return driver.findElement(By.xpath("//table[@id='grid']/thead/tr/th[" + index + "]"));
	}

	public static List<WebElement> searchResults_tableValues(int rowNumber) {
		List<WebElement> headings = new ArrayList<WebElement>();
		headings = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr[" + rowNumber + "]/td"));
		return headings;
	}

	public static WebElement searchResults_tableValues(int rowNumber, int columnNumber) {
		return driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[" + rowNumber + "]/td[" + rowNumber + "]"));
	}

	public static List<WebElement> searchResults_numberOfRows() {
		List<WebElement> rows = new ArrayList<WebElement>();
		rows = driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
		return rows;
	}

	public static WebElement errorMessage() {
		return driver.findElement(By.xpath("//tr[@class='gridrow']/td[last()]"));
	}

	public static Select effectiveDate_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_EffectiveDate']")));
	}
	
	public static Select masterGroup_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_MasterGroupNumber']")));
	}

	public static Select groupNumber_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_GroupNumber']")));
	}

	public static Select masterNumber_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_MasterGroupNumber']")));
	}

	public static Select division_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_Division']")));
	}

	public static Select compareEffectiveDate_dropdown() {
		return new Select(
				driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_CompareEffectiveDate']")));
	}

	public static Select compareGroupNumber_dropdown() {
		return new Select(
				driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_CompareGroupNumber']")));
	}

	public static Select compareMasterGroup_dropdown() {
		return new Select(
				driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_CompareMasterGroupNumber']")));
	}

	public static Select compareDivision_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EmployerComponentCodeModel_CompareDivision']")));
	}
}
