package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class PlanPage extends BaseClass {

	public PlanPage(WebDriver driver) {
		super(driver);
	}

	public static Select year_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
	}

	public static Select category_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Category']")));
	}

	public static Select status_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Status']")));
	}

	public static WebElement planName_textField() {
		return driver.findElement(By.xpath("//input[@id='PlanName']"));
	}

	public static WebElement contract_textField() {
		return driver.findElement(By.xpath("//input[@id='ContractNumber']"));
	}

	public static Select planType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanType']")));
	}

	public static Select businessSegment_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='BusinessSegment']")));
	}

	public static WebElement planLongName_textField() {
		return driver.findElement(By.xpath("//input[@id='PlanLongName']"));
	}

	public static WebElement PBP_textField() {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
	}

	public static Select SNPtype_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SNPType']")));
	}

	public static Select brand_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Brand']")));
	}

	public static Select splitDelegationIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SplitDelegationValue']")));
	}

	public static Select claimSystems_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SourceSystem']")));
	}

	public static Select AARP_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='AARPValue']")));
	}

	public static Select planPCPrequired_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanPCPRequiredValue']")));
	}

	public static WebElement searchPlans_button() {
		return driver.findElement(By.xpath("//input[@id='SearchPlanButton']"));
	}

	public static WebElement deleteSelectedItems_button() {
		return driver.findElement(By.xpath("//input[@id='btnDelete']"));
	}

	public static WebElement makeSelectedItemPublic_button() {
		return driver.findElement(By.xpath("//input[@id='btnDeactivate']"));
	}

	public static WebElement makeSelectedItemSecure_button() {
		return driver.findElement(By.xpath("//input[@id='btnActivate']"));
	}

	public static WebElement massDetaUpdate_button() {
		return driver.findElement(By.xpath("//input[@id='btnMassUpdate']"));
	}

	public static Select orderBy_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanPCPRequiredValue']")));
	}

	public static WebElement selectAllCheckBox() {
		return driver.findElement(By.xpath("//input[@id='checkAll']"));
	}

	public static WebElement SearchResultsTableColumnHeadings() {
		return driver.findElement(By.xpath("//table/tbody/tr"));
	}

	public static WebElement searchResultsTableAllRows() {
		return driver.findElement(By.xpath("//table/tbody/tr"));
	}

	public static WebElement searchResultsTableSingleRow_(int rowNumber) {
		return driver.findElement(By.xpath("//table/tbody/tr[" + rowNumber + "]"));
	}

	public static WebElement EditRecord_forSelectedPlan_link(String year, String contract, String PBP) {
		return driver.findElement(By.xpath("//td[contains(.,'Year/Contract/PBP: " + year + " - " + contract + " - "
				+ PBP + "')]/following-sibling::td[last()]/a"));
	}

	public static WebElement checkbox_forSelectedPlan(String year, String contract, String PBP) {
		return driver.findElement(By.xpath("//td[contains(.,'Year/Contract/PBP: " + year + " - " + contract + " - "
				+ PBP + "')]/preceding-sibling::td/input[@type='checkbox']"));
	}
	
	public static WebElement submitRecords_makePublic_button() {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	
	public static WebElement serchResult_firstRow_ExceptDetails() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[position()>2 and not( position()=last())]"));
	}
	
	public static WebElement serchResult_firstRow_segment() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[3]"));
	}
	
	public static WebElement serchResult_firstRow_PlanType() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[4]"));
	}
	
	public static WebElement serchResult_firstRow_SNP() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[5]"));
	}
	
	public static WebElement serchResult_firstRow_splitDeligationIndicator() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[5]"));
	}
	
	public static WebElement serchResult_firstRow_AARP() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[6]"));
	}
	
	public static WebElement serchResult_firstRow_Brand() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[7]"));
	}
	
	public static WebElement serchResult_firstRow_Category() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[8]"));
	}
	
	public static WebElement serchResult_firstRow_ClaimsSystem() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[9]"));
	}
	
	public static WebElement serchResult_firstRow_PlanPCPreq() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[10]"));
	}
	
	public static WebElement serchResult_firstRow_Status() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[11]"));
	}
	
	public static int serchResult_noOf_rows() {
		return driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[11]")).size();
	}

}
