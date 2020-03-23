package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class EOBGroupException extends BaseClass {

	public EOBGroupException(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	public static WebElement EOBPlanRuleListScreen() {
		return driver.findElement(By.xpath("//h2[contains(text(),'EOB Plan Rule List')]"));
	}

	public static WebElement CreateNewEOBPlanRule() {
		return driver.findElement(By.xpath("//a[contains(text(),'Create New EOB Plan Rule')]"));
	}

	public static WebElement CreateNewEOBGroupException() {
		return driver.findElement(By.xpath("//a[contains(text(),'Create New EOB Group Exception')]"));
	}

	public static WebElement SearchEOBGroupExceptions() {
		return driver.findElement(By.xpath("//a[contains(text(),'Search EOB Group Exceptions')]"));
	}

	public static WebElement EOBGroupExceptions() {
		return driver.findElement(By.xpath("//h2[contains(text(),'EOB Group Exceptions')]"));
	}

	public static WebElement EnterMasterGroupNumber_textfield() {
		return driver.findElement(By.xpath("//input[@id='MasterGroupNumber']"));
	}

	public static WebElement EnterGroupNumber_textfield() {
		return driver.findElement(By.xpath("//input[@id='GroupNumber']"));
	}

	public static WebElement EnterGroupEffectiveDate_textfield() {
		return driver.findElement(By.xpath("//input[@id='EffectiveDate']"));
	}
	public static WebElement SearchGroupEffectiveDate_textfield() {
		return driver.findElement(By.xpath("//input[@id='GroupEffectiveDate']"));
	}
////*[@id='create-rule-save']
	public static WebElement clickonupdatescreensavebutton() {
		return driver.findElement(By.xpath("//*[@id='create-rule-save']"));
	}
	public static Select SiteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SiteId']")));
	}
	public static Select SearchSiteName_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='SiteName']")));
	}

	public static Select EOBIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='IsEOB']")));
	}
	
	public static Select SearchEOBIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EOBIndicator']")));
	}
	public static Select updateEOBIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='IsEOB']")));
	}

	public static Select Searchlanguages_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='EOBLanguage']")));
	}

	public static Select Search_PlanYear_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
	}
	public static Select Search_Category_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}
	public static Select Search_Contract_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='ContractNumber']")));
	}
	public static Select Search_PBP_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='PBPNumber']")));
	}
	public static WebElement clickoncancellink() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[7]/a"));
	}

	public static WebElement VerifyCreateNewEOBGroupException() {
		return driver
				.findElement(By.xpath("//div[@class='container-fluid']/h2[text()='Create New EOB Group Exception']"));

	}

	// 2) TC_EOB Group Exceptions_Create Exception_Cancel_EOB_Y
	// remaning xpath is same as first test cases

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

	public static List<WebElement> languagesLabel() {
		return driver.findElements(By.xpath("//input[@name='EOBLanguages']//preceding::label"));
	}

	public static List<WebElement> Verifylanguages() {
		return driver.findElements(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[6]/div[2]/label"));
	}

	public static int searchResults_Count1() {
		List<WebElement> headings = new ArrayList<WebElement>();
		headings = driver.findElements(By.xpath("//div[@class='controls language-checklist']"));
		return headings.size();
	}

	public static List<WebElement> Eobgroupexception_Verifylanguages() {
		List<WebElement> languages = new ArrayList<WebElement>();
		languages = driver.findElements(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[6]/div[2]/label"));
		return languages;
	}

	// 3)TC_EOB Group Exceptions_Create Exception_DuplicateRecord_EOB_N
	// remaning xpath is same as first test cases
	public static WebElement Save_Button() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[7]/input"));
	}

	public static WebElement checkSuccessfullMessage() {
		return driver
				.findElement(By.xpath("//div[contains(text(),'Your new exception has been successfully created.')]"));
	}

	public static WebElement checkErrorMessage() {
		// TODO Auto-generated method stub
		return driver.findElement(
				By.xpath("//li[contains(text(),'Cannot create a new EOB exception, the exception already exists.')]"));
	}

	public static WebElement searchcount() {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//span[contains(text(),'13 Total records displayed')]"));

	}

	public static WebElement clickonSearch() {
		return driver.findElement(By.xpath("//input[@id='search-button']"));
	}
	public static WebElement updateclickonSearch() {
		return driver.findElement(By.xpath("//*[@id='eob-search-plans']"));
	}
	public static WebElement Countofrecordsaftersearch() {
		return driver.findElement(By.xpath("//span[contains(text(),'10 Total records displayed')]"));
	}

	public static WebElement verifyinggroupnumbers() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[3]"));
	}

	public static List<WebElement> searchResults_Count() {

		return driver.findElements(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr"));

	}

	public static WebElement verifyinghighlightedrecord() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr[2]"));
	}

	public static WebElement checkerror_message_GroupEffectiveDate() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/div/ul/li[3]"));

	}

	public static WebElement checkerror_message_GroupNumberisrequired() {
		return driver.findElement(
				By.xpath("//form[@id='createPlanRuleException']/div/ul/li[text()='Group Number is required.']"));
	}

	public static WebElement checkerror_message_MasterGroupNumberisrequired() {
		return driver.findElement(
				By.xpath("//form[@id='createPlanRuleException']/div/ul/li[text()='Master Group Number is required.']"));
	}

	public static WebElement checkerror_message_GroupEffectiveDateisrequired() {
		return driver.findElement(By
				.xpath("//form[@id='createPlanRuleException']/div/ul/li[text()='Group Effective Date is required.']"));
	}

	public static WebElement Succesfull_message_EOBGroupExceptions() {
		return driver
				.findElement(By.xpath("//div[contains(text(),'Your new exception has been successfully created.')]"));
	}

	public static WebElement VerifyMasterGroupNumber() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[1]/div[1]"));
	}

	public static WebElement VerifyGroupNumber() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[2]/div[1]"));
	}

	public static WebElement VerifyGroupEffectiveDate() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[3]/div[1]"));
	}

	public static WebElement VerifySiteName() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[4]/div[1]"));
	}

	public static WebElement VerifyEOBIndicator() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[5]/div[1]"));
	}

	public static WebElement VerifySearchButton() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[7]/input"));
	}

	public static WebElement VerifyCancelButton() {
		return driver.findElement(By.xpath("//form[@id='createPlanRuleException']/fieldset/div[7]/a"));
	}

	public static WebElement Mastergroupnumber_label() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[1]/label[contains(text(),'Master Group Number')]"));
	}

	public static WebElement groupnumber_label() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[2]/label[contains(text(),'Group Number')]"));
	}

	public static WebElement GroupEffectiveDate_label() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[3]/label[contains(text(),'Group Effective Date')]"));
	}

	public static WebElement SiteName_label() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[4]/label[contains(text(),'Site Name')]"));
	}

	public static WebElement EOBIndicator_label() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[5]/label[contains(text(),'EOB Indicator')]"));
	}

	public static WebElement Language_label() {
		return driver.findElement(By
				.xpath("//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[6]/label[contains(text(),'Language')]"));
	}

	public static WebElement ClickonDeleteGroupExceptions() {
		return driver.findElement(By.xpath("//input[@id='btnDelete']"));
	}

	public static WebElement Mastergroupnumber_result_grid() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-exception-search-grid']/thead/tr/th[2][contains(text(), 'Master Group Number')]"));
	}

	public static WebElement Groupnumber_result_grid() {
		return driver.findElement(
				By.xpath("//table[@id='eob-exception-search-grid']/thead/tr/th[3][contains(text(), 'Group Number')]"));
	}

	public static WebElement GroupName_result_grid() {
		return driver.findElement(
				By.xpath("//table[@id='eob-exception-search-grid']/thead/tr/th[4][contains(text(), 'Group Name')]"));
	}

	public static WebElement GroupEffectiveDate_result_grid() {
		return driver.findElement(By.xpath(
				"//table[@id='eob-exception-search-grid']/thead/tr/th[5][contains(text(), 'Group Effective Date')]"));
	}

	public static WebElement SiteName_result_grid() {
		return driver.findElement(
				By.xpath("//table[@id='eob-exception-search-grid']/thead/tr/th[6][contains(text(), 'Site Name')]"));
	}

	public static WebElement EOBIndicator_result_grid() {
		return driver.findElement(
				By.xpath("//table[@id='eob-exception-search-grid']/thead/tr/th[7][contains(text(), 'EOB Indicator')]"));
	}

	public static WebElement Language_result_grid() {
		return driver.findElement(
				By.xpath("//table[@id='eob-exception-search-grid']/thead/tr/th[8][contains(text(), 'Languages')]"));
	}

	public static WebElement Selectrecord() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr[11]/td[1]/input"));
	}

	public static List<WebElement> Selectparticularrowtext(String GroupNumber) {
		return driver.findElements(By.xpath("//td[text()='"+GroupNumber+"']/preceding-sibling::td[last()]/following-sibling::td"));
	}

	public static WebElement Loginid() {
		return driver.findElement(By.xpath("//p[@class='pull-right']/strong"));
	}

	public static List<WebElement> highLighted_groups() {
		List<WebElement> list = driver
				.findElements(By.cssSelector(""
						+ ""));
		return list;
	}
	public static WebElement SelectEmployerGrouprecord(String GroupNumber) {
	
		return driver.findElement(By.xpath(".//*[@id='eob-exception-search-grid']/tbody/tr/td[text()='"+GroupNumber+"']/preceding-sibling::td/input"));
	}
	public static List<WebElement> SelectmultiplegroupsEmployerGrouprecord(String GroupNumber,String Groupnumber1) {
		
		return driver.findElements(By.xpath(".//*[@id='eob-exception-search-grid']/tbody/tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']/preceding-sibling::td/input"));
	}
	public static WebElement DeleteGroupException() {
		return driver.findElement(By.xpath("//div[contains(text(),'Your 1 EOB Group Exception(s) were successfully deleted.')]"));
	}
	
	public static WebElement Clear_Button() {
		return driver.findElement(By.xpath("//input[@id='clear-search']"));
	}

	public static List<WebElement> VerifytextfieldsInUIScreen_isempty() {
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td/input"));
		return list;
	}
	
	public static List<WebElement> Ui() {
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()>1]"));
		return list;
	}
	////table[@id='eob-exception-search-grid']/tbody/tr/td[position()>1]
	
	public static List<WebElement>VerifydropdownsinUIScreen_isempty() {
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td/select"));
		return list;
	}
	public static WebElement verifysearchgrid() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr"));
	}
	public static WebElement SearchMasterGroupNumber_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=2]"));
	}
	public static WebElement SearchGroupNumber_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=3]"));
	}
	public static WebElement SearchGroupName_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=4]"));
	}
	public static WebElement SearchGroupEffectiveDate_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=5]"));
	}
	public static WebElement SearchSiteName_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=6]"));
	}
	public static WebElement SearchEOBIndicator_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=7]"));
	}
	public static WebElement SearchLanguages_text() {
		return driver.findElement(By.xpath("//table[@id='eob-exception-search-grid']/tbody/tr/td[position()=8]"));
	}
	
	public static List<WebElement> Selectmutliplerecords(String GroupNumber,String Groupnumber1,String Groupnumber2 ) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"' or text()='"+Groupnumber2+"']//parent::tr/td[1]/input"));
		return elements;
	}
	public static List<WebElement> Select_mutliplerecords(String GroupNumber,String Groupnumber1) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']//parent::tr/td[1]/input"));
		return elements;
	}
	public static List<WebElement> verifymutliplerecords_updatedscreen(String GroupNumber,String Groupnumber1,String Groupnumber2 ) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"' or text()='"+Groupnumber2+"']//parent::tr/td"));
		return elements;
	}
	public static List<WebElement> verifymutliplerecords_updatedscreen(String GroupNumber,String Groupnumber1) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']//parent::tr/td"));
		return elements;
	}
	
	 public static WebElement select_checkbox(String GroupNumber) {
			
			return driver.findElement(By.xpath(".//*[@id='eob-exception-search-grid']/tbody/tr/td[text()='"+GroupNumber+"']/preceding-sibling::td/input"));
		}
  public static WebElement verifysearchresultscount(){
	return driver.findElement(By.xpath("//span[contains(text(),'1 Total records displayed')]"));
	
}
	
	public static List<WebElement> verifymutliplerecords_searchscreen(String GroupNumber,String Groupnumber1,String Groupnumber2 ) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"' or text()='"+Groupnumber2+"']//parent::tr/td"));
		return elements;
	}
	public static List<WebElement> verifymutliplerecords_searchscreen(String GroupNumber,String Groupnumber1 ) {
		List<WebElement> elements=driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']//parent::tr/td"));
		return elements;
	}
	public static List<WebElement> verifyrecord_updatedscreen(String GroupNumber,String Groupnumber1 ) {
		List<WebElement> elements= driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']//parent::tr/td"));
		return elements;
		
	}
	
	public static WebElement select_searchscreen_checkbox(String Contractnumber,String pbp){
		return driver.findElement(By.xpath("//td[text()='"+Contractnumber+"']/following-sibling::td[text()='"+pbp+"']/parent::tr/td[1]/input"));
		
	}
	public static WebElement clickondeletebutton(){
		return driver.findElement(By.xpath("//*[@id='btnDelete']"));
		
	}
	public static List<WebElement> verifyrecord_searchscreen(String GroupNumber,String Groupnumber1 ) {
		List<WebElement> elements= driver.findElements(By.xpath("//tr/td[text()='"+GroupNumber+"' or text()='"+Groupnumber1+"']//parent::tr/td"));
		return elements;
		
	}

	public static List<WebElement> verifyrecord_updatedsearchscreen(String Contractnumber,String pbp) {
		List<WebElement> elements= driver.findElements(By.xpath("//tr/td[text()='"+Contractnumber+"' or text()='"+pbp+"']//parent::tr/td"));
		return elements;	
	}
	public static List<WebElement> verifyrecord_search_screen(String Contractnumber,String pbp) {
		List<WebElement> elements= driver.findElements(By.xpath("//tr/td[text()='Contractnumber' or text()='pbp']/parent::tr/td"));
		return elements;	
	}
	public static WebElement Clickonupdategroupexception() {
		return driver.findElement(By.xpath("//input[@id='btnUpdate']"));
	}
	public static WebElement Clickoncancel(){
		return driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"));
		
	}
	public static WebElement Clickonupdatebutton(){
		return driver.findElement(By.xpath("//input[@value='Update']"));
		
	}
	////*[@id='eob-exception-search-grid']/tbody/tr/td[text()='98781']/following-sibling::td[5]

	public static WebElement multipleDeleteGroupException() {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath("//div[contains(text(),'Your 2 EOB Group Exception(s) were successfully deleted.')]"));
	}
	 ////input[@name='EOBLanguages']
	public static List<WebElement> multiplecheckbox_languages(){
		List<WebElement> elements=driver.findElements(By.xpath("//input[@name='EOBLanguages']"));
		return elements;
	}
	
	public static WebElement SelectindividualGrouprecord(String contractnumber) {
		return driver.findElement(By.xpath("//table[@id='eob-rule-search-grid']/tbody/tr[1]/td[text()='"+contractnumber+"']"));
		}
	
}