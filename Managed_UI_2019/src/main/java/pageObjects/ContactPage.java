package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class ContactPage extends BaseClass {

	

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static Select year_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
	}
	
	public static Select ContractRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContractNumber']")));
	}
	
	public static Select PlanNameRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanName']")));
	}
	
	public static Select BrandRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='Brand']")));
	}
	
	public static Select BusinessSegmentRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='BusinessSegment']")));
	}
	
	public static Select PBPRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PBPNumber']")));
	}
	
	public static Select IncludeIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='IncludeIndicator']")));
	}
	
	public static Select RuleType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactRuleType']")));
	}

	public static Select ContactType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactType']")));
	}
	
	public static WebElement contract_textField() {
		return driver.findElement(By.xpath("//input[@id='ContractNumber']"));
	}
	
	public static Select State_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactFields_0__StateCode']")));
	}
	
	public static WebElement Address1_textField() {
		return driver.findElement(By.xpath("//input[@id='Address1']"));
	}
	
	public static WebElement MassAddress1_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_Address1']"));
	}
	
	public static WebElement Address2_textField() {
		return driver.findElement(By.xpath("//input[@id='Address2']"));
	}
	
	public static WebElement MassAddress2_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_Address2']"));
	}
	
	public static WebElement City_textField() {
		return driver.findElement(By.xpath("//input[@id='City']"));
	}
	
	public static WebElement City_MasstextField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_City']"));
	}
	
	public static WebElement Zipcode_textField() {
		return driver.findElement(By.xpath("//input[@id='Zipcode']"));
	}
	
	public static WebElement Phone_textField() {
		return driver.findElement(By.xpath("//input[@id='PhoneNumber']"));
	}
	
	public static WebElement PhoneNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='PhoneNumber']"));
	}
	
	public static WebElement TTY_textField() {
		return driver.findElement(By.xpath("//input[@id='TTY']"));
	}

	public static WebElement Fax_textField() {
		return driver.findElement(By.xpath("//input[@id='FaxNumber']"));
	}
	
	public static WebElement Email_textField() {
		return driver.findElement(By.xpath("//input[@id='EmailAddress']"));
	}
	
	public static WebElement Website_textField() {
		return driver.findElement(By.xpath("//input[@id='WebsiteUrl']"));
	}
	
	public static WebElement Create_Website_textField() {
		return driver.findElement(By.xpath("//input[@id='WebSiteURL']"));
	}
	
	
	public static WebElement Hours_textField() {
		return driver.findElement(By.xpath("//input[@id='HoursOfOperation']"));
	}
	
	public static WebElement Edit_Address1_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[2]/div/input"));
	}
	
	public static WebElement Edit_Address2_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[3]/div/input"));
	}
	
	public static WebElement Edit_City_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[4]/div/input"));
	}
	
	public static WebElement Edit_Zipcode_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[6]/div/input"));
	}
	
	public static WebElement Edit_Phone_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[7]/div/input"));
	}
	
	public static WebElement Edit_TTY_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[8]/div/input"));
	}

	public static WebElement Edit_Fax_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[9]/div/input"));
	}
	
	public static WebElement Edit_Email_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[10]/div/input"));
	}
	
	public static WebElement Edit_Website_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[11]/div/input"));
	}
	
	public static WebElement Edit_Hours_textField() {
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[12]/div/input"));
	}
	
	public static WebElement PBP_textField() {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
	}
	
	public static WebElement EditRule_link() {
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr/td[14]/a"));
	}
	
	public static WebElement EditContact_link() {
		return driver.findElement(By.xpath("//a[@href='/Edit']"));
	}

	public static WebElement searchContact_button() {
		return driver.findElement(By.xpath("//input[@id='SearchContactRuleButton']"));
	}
	
	public static WebElement MassUpdate_button() {
		return driver.findElement(By.xpath("//input[@id='mass-edit-button']"));
	}
	public static WebElement submitRecord_button() {
		return driver.findElement(By.xpath("//input[@value='Submit Records']"));
	}
	public static WebElement DeleteContact_button() {
		return driver.findElement(By.xpath("//*[@id='button-container']/a[2]"));
	}
	public static WebElement createRule_button() {
		return driver.findElement(By.xpath("//*[@id='button-container']/a[1]"));
	}
	public static WebElement SearchPlans_button() {
		return driver.findElement(By.xpath("//input[@id='search-plans']"));
	}
	public static WebElement SearchMassEdit_button() {
		return driver.findElement(By.xpath("//input[@id='mass-edit-search-btn']"));
	}
	public static WebElement rule_Save_button() {
		return driver.findElement(By.xpath("//*[@id='edit-contactrule-wrapper']/div[3]/input[2]"));
	}
	public static WebElement rule_SaveEdit_button() {
		return driver.findElement(By.xpath("//*[@id='editRule']/div[3]/input"));
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
	
	public static WebElement checkbox_EditRecord() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[1]/input"));
	}
	
	public static WebElement checkbox_EditSecondRecord() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[2]/td[1]/input"));
	}
	
	public static WebElement checkbox_SelectDefaultPlan() {
		return driver.findElement(By.xpath(".//*[@id='individual-rule-search-grid']/tbody/tr[1]/td[1]/input"));
	}
	
	public static WebElement checkbox_SelectSecondContact() {
		return driver.findElement(By.xpath(".//*[@id='individual-rule-search-grid']/tbody/tr[1]/td[1]/input"));
	}

	public static WebElement checkbox_forSelectedPlan(String year, String contract, String PBP) {
		return driver.findElement(By.xpath("//td[contains(.,'Year/Contract/PBP: " + year + " - " + contract + " - "
				+ PBP + "')]/preceding-sibling::td/input[@type='checkbox']"));
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
	
	public static WebElement serchResult_GroupNumber_Status() {
		return driver.findElement(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[11]"));
	}
	
	public static int serchResult_noOf_rows() {
		return driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr[1]/td[11]")).size();
	}
	
	public static int serchContactExpResult_noOf_rows() {
		return driver.findElements(By.xpath(".//*[@id='GroupContactExceptionSearchGrid']/tbody/tr[1]/td[3]")).size();
	}
	
	public static WebElement SearchContactExceptions_Button() {
		return driver.findElement(By.xpath("//a[@href='/GroupContactException?type=I']"));
	}
	
	public static WebElement SearchGroupContactExceptions_Button() {
		return driver.findElement(By.xpath("//*[@id='SearchGroupContactException']/div/div[2]/input[1]"));
	}
	
	public static Select GroupType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}
	
	public static WebElement CreateContactExceptions_Button() {
		return driver.findElement(By.xpath("//a[@href='/GroupContactException/CreateIndividualGroupException']"));
	}
	
	public static WebElement GroupEffectiveDate_textField() {
		return driver.findElement(By.xpath("//input[@id='GroupEffectiveDateValue']"));
	}
	
	public static WebElement GroupNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='GroupNumber']"));
	}
	
	public static WebElement GroupPBPNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
	}
	
	public static WebElement MasterGroupNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='MasterGroupNumber']"));
	}
	
	public static WebElement ContactNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactNumber']"));
	}
	
	public static Select GroupContactType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactTypeID']")));
	}
	
	public static Select GroupSiteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='DivisionID']")));
	}
	
	public static WebElement GroupSearch_Button() {
		return driver.findElement(By.xpath("//input[@value='Search']"));
	}
	
	public static WebElement GroupClear_Button() {
		return driver.findElement(By.xpath("//input[@value='Clear']"));
	}
	
	public static WebElement GroupDelete_Button() {
		return driver.findElement(By.xpath("//input[@id='btnDelete']"));
	}
	
	public static WebElement GroupUpdate_Button() {
		return driver.findElement(By.xpath("//input[@id='btnUpdate']"));
	}
	
	public static WebElement checkbox_SelectGroupRecordAll() {
		return driver.findElement(By.xpath(".//input[@id='checkAll']"));
	}
	
	public static WebElement checkbox_SelectGroupRecordDefault() {
		return driver.findElement(By.xpath(".//*[@id='GroupContactExceptionSearchGrid']/tbody/tr[1]/td[1]/input"));
	}
	
	public static WebElement Create_MasterGroupNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='MasterGroupNumber']"));
	}
	
	public static WebElement Create_GroupNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='GroupNumber']"));
	}
	
	public static WebElement Create_EffectiveDate_Edit() {
		return driver.findElement(By.xpath(".//input[@id='GroupEffectiveDateValue']"));
	}
	
	public static WebElement Create_ContactNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='ContractNumber']"));
	}
	
	public static WebElement Create_PBPNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='PBPNumber']"));
	}
	
	public static WebElement Create_Address1_Edit() {
		return driver.findElement(By.xpath(".//input[@id='Address1']"));
	}
	
	public static WebElement Create_Address2_Edit() {
		return driver.findElement(By.xpath(".//input[@id='Address2']"));
	}
	
	public static WebElement Create_City_Edit() {
		return driver.findElement(By.xpath(".//input[@id='City']"));
	}
	
	public static WebElement Create_ZipCode_Edit() {
		return driver.findElement(By.xpath(".//input[@id='ZipCode']"));
	}
	
	public static WebElement Mass_ZipCode_Edit() {
		return driver.findElement(By.xpath(".//input[@id='ContactRuleData_Zipcode']"));
	}
	
	public static WebElement Create_PhoneNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='PhoneNumber']"));
	}
	
	public static WebElement Create_FaxNumber_Edit() {
		return driver.findElement(By.xpath(".//input[@id='FaxNumber']"));
	}
	
	public static WebElement Create_EmailAddress_Edit() {
		return driver.findElement(By.xpath(".//input[@id='EmailAddress']"));
	}
	
	public static WebElement Create_WebSiteURL_Edit() {
		return driver.findElement(By.xpath(".//input[@id='WebSiteURL']"));
	}
	
	public static WebElement Create_HoursOfOperation_Edit() {
		return driver.findElement(By.xpath(".//input[@id='HoursOfOperation']"));
	}
	
	public static WebElement Create_TTY_Edit() {
		return driver.findElement(By.xpath(".//input[@id='TTY']"));
	}
	
	public static Select Create_SiteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='DivisionID']")));
	}
	
	public static Select Create_ContactTypeID_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactTypeID']")));
	}
	
	public static Select Create_StateCode_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='StateCode']")));
	}
	
	public static WebElement Create_Save_Button() {
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}
	
	public static WebElement Create_Cancel_Button() {
		return driver.findElement(By.xpath("//a[@href='/GroupContactException']"));
	}
	
	public static WebElement SearchExceptions_NoRecords() {
		return driver.findElement(By.xpath("//*[@id='GroupContactExceptionSearchGrid']/tbody/tr/td/strong"));
	}
	
	public static Select Create_State_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='StateCode']")));
	}
	
	public static Select Mass_State_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactRuleData_StateCode']")));
	}
	
	public static WebElement checkbox_UpdateAddress1() {
		return driver.findElement(By.xpath(".//*[@id='CanEditAddress1']"));
	}
	
	public static WebElement checkbox_MassUpdateAddress1() {
		return driver.findElement(By.xpath(".//*[@id='IsAddress1Selected']"));
	}
	
	public static WebElement checkbox_UpdateAddress2() {
		return driver.findElement(By.xpath(".//*[@id='CanEditAddress2']"));
	}
	
	public static WebElement checkbox_MassAddress2() {
		return driver.findElement(By.xpath(".//*[@id='IsAddress2Selected']"));
	}
	
	public static WebElement checkbox_UpdateCity() {
		return driver.findElement(By.xpath(".//*[@id='CanEditCity']"));
	}
	
	public static WebElement checkbox_MassCity() {
		return driver.findElement(By.xpath(".//*[@id='IsCitySelected']"));
	}
	
	
	public static WebElement checkbox_UpdateState() {
		return driver.findElement(By.xpath(".//*[@id='CanEditStateCode']"));
	}
	
	public static WebElement checkbox_MassState() {
		return driver.findElement(By.xpath(".//*[@id='IsStateCodeSelected']"));
	}
	
	public static WebElement checkbox_UpdateZip() {
		return driver.findElement(By.xpath(".//*[@id='CanEditZipCode']"));
	}
	

	public static WebElement checkbox_MassZip() {
		return driver.findElement(By.xpath(".//*[@id='IsZipcodeSelected']"));
	}
	
	public static WebElement checkbox_UpdatePhone() {
		return driver.findElement(By.xpath(".//*[@id='CanEditPhoneNumber']"));
	}
	
	public static WebElement checkbox_UpdateTTY() {
		return driver.findElement(By.xpath(".//*[@id='CanEditTTY']"));
	}
	
	public static WebElement checkbox_UpdateFax() {
		return driver.findElement(By.xpath(".//*[@id='CanEditFaxNumber']"));
	}
	
	public static WebElement checkbox_UpdateEmail() {
		return driver.findElement(By.xpath(".//*[@id='CanEditEmailAddress']"));
	}
	
	public static WebElement checkbox_UpdateWebsite() {
		return driver.findElement(By.xpath(".//*[@id='CanEditWebSiteURL']"));
	}
	
	public static WebElement checkbox_UpdateHours() {
		return driver.findElement(By.xpath(".//*[@id='CanEditHoursOfOperation']"));
	}
	public static WebElement Button_Update() {
		return driver.findElement(By.xpath("//input[@value='Update']"));
	}
	public static WebElement Button_Cancel() {
		return driver.findElement(By.xpath("//a[@href='/GroupContactException']"));
	}
	public static Select contract_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContractNumber']")));
	}
	public static Select PBP_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PBPNumber']")));
	}
	public static WebElement searchPlan_button() {
		return driver.findElement(By.xpath("//input[@id='search-plans']"));
	}
	public static WebElement plan_checkBox(String contract,String PBP) {
		return driver.findElement(By.xpath("//td[text()='"+contract+"']/following-sibling::td[text()='"+PBP+"']/parent::tr/td[1]/input"));
	}
	public static WebElement phoneNumber_textField() {
		return driver.findElement(By.xpath("//input[@id='PhoneNumber']"));
	}
	public static Select rule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactRuleType']")));
	}
	
}
