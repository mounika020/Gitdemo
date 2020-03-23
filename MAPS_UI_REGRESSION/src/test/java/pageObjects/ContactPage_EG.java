package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class ContactPage_EG extends BaseClass {

	public ContactPage_EG(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static Select GroupType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}
	
	public static WebElement createRule_button() {
		return driver.findElement(By.xpath("//*[@id='button-container']/a[1]"));
	}

	public static Select IncludeIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='IncludeIndicator']")));
	}
	
	public static Select RuleType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactRuleType']")));
	}

	public static Select ContactType_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactType' and @name='ContactType']")));
	}
	
	public static Select ContactType_StateMOffice() {
		return new Select(driver.findElement(By.xpath("//select[3]")));
	}
	
	public static Select ContractRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContractNumber']")));
	}

	public static Select PBPRule_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PBPNumber']")));
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
	
	public static Select Contract_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContractNumber']")));
	}

	
	public static Select year_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
	}
	
	
	public static WebElement contract_textField() {
		return driver.findElement(By.xpath("//input[@id='ContractNumber']"));
	}
	
	public static WebElement searchContact_button() {
		return driver.findElement(By.xpath("//input[@id='SearchContactRuleButton']"));
	}
	
	
	public static WebElement ResultNotFound() {
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr/td/strong"));
	}
	public static WebElement SearchPlans_button() {
		return driver.findElement(By.xpath("//input[@id='search-plans']"));
	}
	
	public static WebElement selectPlanCheckBox() {
		return driver.findElement(By.xpath("//*[@id='employer-rule-search-grid']/tbody/tr[1]/td[1]/input"));
	}
	
	public static WebElement enterContactTypeLabel_textField() {
		return driver.findElement(By.xpath("//fieldset/div[1]/div/input[@class='input-large']"));
	}
	public static WebElement Address1_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_Address1']"));
	}
	public static WebElement Address2_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_Address2']"));
	}
	
	public static WebElement City_textField() {
		return driver.findElement(By.xpath("//input[@id='ContactRuleData_City']"));
	}
	public static Select State_dropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='ContactRuleData_StateCode']")));
	}
	public static WebElement ZipCode_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_Zipcode']"));
	}
	public static WebElement Phone_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_PhoneNumber']"));
	}
	public static WebElement TTY_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_TTY']"));
	}
	
	public static WebElement Fax_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_FaxNumber']"));
	}
	public static WebElement Email_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_EmailAddress']"));
	}
	
	public static WebElement WebSite_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_WebsiteUrl']"));
	}
	public static WebElement Hours_textField() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_HoursOfOperation']"));
	}
	public static WebElement CreateNewRulesButton() {
		return driver.findElement(By.xpath("//*[@id='rule-form-wrapper']/fieldset/div[14]/input[2]"));
	}
	
	public static WebElement PBP_textField() {
		return driver.findElement(By.xpath("//input[@id='PBPNumber']"));
	}
	
	public static WebElement ErrorMessage_stateBlank() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_State-error']"));
	}
	
	public static WebElement ErrorMessage_CityBlank() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_City-error']"));
	}
	public static WebElement ErrorMessage_ZipCodeBlank() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_Zipcode-error']"));
	}
	public static WebElement ErrorMessage_FaxNum() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_FaxNumber-error']"));
	}
	public static WebElement ErrorMessage_PhoneNum() {
		return driver.findElement(By.xpath("//*[@id='ContactRuleData_PhoneNumber-error']"));
	}
	
	public static WebElement MassUpdate_button() {
		return driver.findElement(By.xpath("//input[@id='mass-edit-button']"));
	}
	
	public static WebElement EmployerGroup_text() {
		return driver.findElement(By.xpath("//span[@id='groupTypeName']"));
	}
	public static WebElement ContractNumer_checked() {
		return driver.findElement(By.xpath("//*[@id='employer-rule-search-grid']/tbody/tr[1]/td[2]"));
	}
	public static int rowCount_ResultPage(){
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='grid']/tbody/tr"));
		return rows.size();
	}
	public static int rowCount_ResultNewPage(){
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='individual-rule-search-grid']/tbody/tr"));
		return rows.size();
	}
	public static WebElement contactnum_InGrid(int i){
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr["+i+"]/td[7]"));
	}
	public static WebElement ContactLabel_InGrid(int i){
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr["+i+"]/td[4]"));
	}
	
	public static WebElement state_InGrid(int i){
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr["+i+"]/td[11]"));
	}
	public static WebElement Editlink_InGrid(int i){
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr["+i+"]/td[14]/a"));
	}
	
	public static int rowCount_EditPage(){
		List<WebElement> rows = driver.findElements(By.xpath("//fieldset[@id='fieldset_0']/div"));
		return rows.size();
	}
	
	public static WebElement Edit_AddressState(int i){
		return driver.findElement(By.xpath("//fieldset/div["+i+"]/div/select"));
	}
	public static WebElement Edit_Addresses(int i){
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div["+i+"]/div/input")); 
	}
	public static WebElement Edit_Addresses1(){
		return driver.findElement(By.xpath("//*[@id='fieldset_0']/div[2]/div/input")); 
	}
	public static WebElement Edit_IndAddresses1(){
		return driver.findElement(By.xpath("//fieldset[@id='fieldset_0']/div[2]/table/tbody/tr/td[1]/div/input")); 
	}
	public static WebElement SaveButton_UpdateScreen(){
		return driver.findElement(By.xpath("//*[@class='form-actions']/input"));
	}
	public static WebElement CheckBox_ResultGrid(int k) {
		return driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+k+"]/td/input"));
	}
	public static WebElement CheckBox_CreateNewresultpage(int k) {
		return driver.findElement(By.xpath("//table[@id='individual-rule-search-grid']/tbody/tr["+k+"]/td[1]/input[@name='planid']"));
	}
	public static WebElement DrugCoverage_CreateNewresultpage(int k) {
		return driver.findElement(By.xpath("//table[@id='individual-rule-search-grid']/tbody/tr["+k+"]/td[7]"));
	}
	public static WebElement ContractNumber_ResultGrid(int k) {
		return driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+k+"]/td[7]"));
	}
	public static WebElement ContractType_ResultGrid(int k) {
		return driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+k+"]/td[3]"));
	}
	public static WebElement DeleteSelectedButton() {
		return driver.findElement(By.xpath("//div[@id='button-container']/a[@class='btn btn-danger']"));
	}
	public static WebElement submitRecord_Deletion() {
		return driver.findElement(By.xpath("//input[@value='Submit Records']"));
	}
	public static Select GLState_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='rule-state-state']")));
	}

	public static Select Edit_StateInAddress(){
		return new Select (driver.findElement(By.xpath("//fieldset/div[5]/div/select")));
	}
	
	public static WebElement SaveButton_CreateNewGL(){
		return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
	}
	public static WebElement ContactTypeLabel_textBox(int i){ //start with zero
		return driver.findElement(By.xpath("//fieldset[@id='fieldset_"+i+"']/div[@class='control-group']/ div/input[@name='ContactFields["+i+"].ContactTypeLabel']"));
	}
	public static WebElement AddButton_CreateNewGL(int i){  //last field set value add will present starts from 0
		return driver.findElement(By.xpath("//fieldset[@id='fieldset_"+i+"']/div[@class='control-group']/div/a[@class='btn btn-mini addRow']"));
	}
	public static WebElement AddButton_CreateNewGL(){  //last field set value add will present starts from 0
		return driver.findElement(By.xpath("//a[@class='btn btn-mini addRow']"));
	}
	public static WebElement DeleteButton_CreateNewGL(int i){  //Not using
		return driver.findElement(By.xpath("//fieldset[@id='fieldset_"+i+"']/div[@class='control-group']/div/a[@class='btn btn-mini deleteRow']"));
	}	
	
	public static Select StateInAddress_Multiple(int i){ //state drop down in edit address frame starts from 0
		return new Select (driver.findElement(By.xpath("//fieldset[@id='fieldset_"+i+"']/div[5]/div/select")));
	}
	
	public static WebElement AddAddress_Multiple(int i, int j){
		return driver.findElement(By.xpath("//fieldset[@id='fieldset_"+i+"']/div["+j+"]/div/input")); 
	}
	public static WebElement ContractNumber(int i){
		return driver.findElement(By.xpath("//table[@id='individual-rule-search-grid']/tbody/tr["+i+"]/td[2]")); 
	}
	
}

