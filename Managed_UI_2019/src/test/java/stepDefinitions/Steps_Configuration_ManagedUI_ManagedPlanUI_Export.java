package stepDefinitions;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageObjects.Contactui_pageobjects;
import pageObjects.Managed_UI_Pageobjects;
import pageObjects.Planui_pageobjects;
//import pageObjects.RuntimeSettings_pageObjects;
//import pageObjects.Test1_pageObjects;
import utilities.Constants;
import utilities.Utils;

public class Steps_Configuration_ManagedUI_ManagedPlanUI_Export {
	static WebDriver driver;
	int rowCount=0;
	String colValue="";
	String OrderByTypeGobal="";
	FileInputStream reqFile=null;
	Workbook reqWorkbook=null;
	Sheet reqSheet=null;
	FileInputStream file = null;
    XSSFWorkbook workbook = null;
    XSSFSheet sheet = null;
    XSSFRow row = null;
    XSSFCell cell = null;
    String PlanDetail="";
	String planType="";
	String planName="";
	String contractNumber="";
	String pbpNumber="";
	String BusinessSegment="";
	String StateCode="";
	String CMSCountyCode="";
	String DrugCoverageType="";
	String EnrolleeType="";
	String SNPFlag="";
	String SNPType="";
	String Status="";
	String arrayDetails[];
	int numRec=3;
	int TotalRecords=0;
	HashMap<Integer, TreeMap<String, String>> OuterHmp = new HashMap<Integer, TreeMap<String,String>>();
	HashMap<Integer, TreeMap<String, String>> OuterHmp2 = new HashMap<Integer, TreeMap<String,String>>();
	LinkedHashMap<String, String> DBresults = new LinkedHashMap<String, String>();
	TreeMap<String,String> InnerHmp;
	TreeMap<String,String> InnerHmp2;
	ArrayList<String> actualStateOrderUI=new ArrayList<String>();
	ArrayList<String> ExpectedStateOrderUI=new ArrayList<String>();
	ArrayList<String> actualProductTypeUI=new ArrayList<String>();
	ArrayList<String> ExpectedProductTypUI=new ArrayList<String>();
	ArrayList<String> actualContactNumberUI=new ArrayList<String>();
	ArrayList<String> ExpectedContactNumberUI=new ArrayList<String>();
	ArrayList<String> actualBusinessSegmentUI=new ArrayList<String>();
	ArrayList<String> ExpectedBusinessSegmentUI=new ArrayList<String>();
	ArrayList<String> actualStateOrderExportSheet=new ArrayList<String>();
	ArrayList<String> ExpectedStateOrderExportSheet=new ArrayList<String>();
	ArrayList<String> actualBusinessSegmentExportSheet=new ArrayList<String>();
	ArrayList<String> ExpectedBusinessSegmentExportSheet=new ArrayList<String>();
	ArrayList<String> actualProductTypeExportSheet=new ArrayList<String>();
	ArrayList<String> ExpectedProductTypeExportSheet=new ArrayList<String>();
	ArrayList<String> actualContactNumberExportSheet=new ArrayList<String>();
	ArrayList<String> ExpectedContactNumberExportSheet=new ArrayList<String>();
	DataFormatter formatter = new DataFormatter();
	static String Contract;
	static String PBP;
	static String year;
	int tempStateCount=0;
	boolean isResultDisplayed=false;
	ArrayList<String> DBResult;
	
	public Steps_Configuration_ManagedUI_ManagedPlanUI_Export() {
		this.driver = Hooks.driver;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}

@Given("^Login the Maps UI and click on Managed plan UI link$")
public void login_the_Maps_UI_and_click_on_Managed_plan_UI_link() throws Throwable {
	//Renaming if required file already exist
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    System.out.println(timeStamp);
   	File oldName =new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
   	if(oldName.exists()) {
	   	File newName = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export " + timeStamp + ".xlsx");
	   	if(oldName.renameTo(newName)) {
	   		System.out.println("renamed");
	   	} else {
	   		System.out.println("Error");
	   	}
   	}
	try {
		Utils.click(driver,Managed_UI_Pageobjects.click_Plan_link(driver));
		Thread.sleep(2000);
		Utils.click(driver,Managed_UI_Pageobjects.click_ManagedPlanSetup_link(driver));
	     }
	catch(Exception e)
	{
		Assert.fail("Failed to click on Manage Plan Setup link");
	}
}

@Then("^Managed plan search screen is displayed$")
public void managed_plan_search_screen_is_displayed() throws Throwable {
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).isDisplayed(), "Verify_Create_Managed_Plan_Screen");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify Managed plan search screen ");
		  }
}

@Then("^Select current Year from the dropdown$")
public void select_current_Year_from_the_dropdown() throws Throwable {
	try	{	
		int yr = Calendar.getInstance().get(Calendar.YEAR);
		yr=yr+1;
		String year=Integer.toString(yr);
		Managed_UI_Pageobjects.select_planyear_dropdown(driver).selectByVisibleText(year);
	}
catch(Exception e){
	Assert.fail("Failed to select the year and contact on the screen");
	}
}

@Then("^Click Search Plans button$")
public void click_Search_Plans_button() throws Throwable {
	try {
		Utils.click(driver, Managed_UI_Pageobjects.click_searchPlan_button(driver));
	}
	catch(Exception e) {
		Assert.fail("Failed to click on Search button");
	}
}

@Then("^data is displayed in result table and Export Results button is displayed$")
public void data_is_displayed_in_result_table_and_Export_Results_button_is_displayed() throws Throwable {
	Thread.sleep(4000);
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	try {
	if(tableRows.size()>1) {
		isResultDisplayed=true;
		Assert.assertTrue(tableRows.size()>1, "data is displayed in search results");}
		else 
		{
			isResultDisplayed=false;
			Assert.fail("Failed as data is not displayed in search results");
		}
		Assert.assertTrue(Managed_UI_Pageobjects.Export_Results_button(driver).isDisplayed(), "Verify Export Results button is displayed");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify Export button");
		  }
}

@When("^data is displayed in result table$")
public void data_is_displayed_in_result_table() throws Throwable {
	Assert.assertTrue(isResultDisplayed, "data is displayed in search results");
}

@When("^Click on Export Results button$")
public void click_on_Export_Results_button() throws Throwable {
	try {
		Managed_UI_Pageobjects.Export_Results_button(driver).click();
	}
	catch(Exception e) {
		Assert.fail("Failed to click on Export Results button");
	}
}

@Then("^verify confirmation pop up window with message \"([^\"]*)\" is displayed$")
public void verify_confirmation_pop_up_window_with_message_is_displayed(String errorMessage) throws Throwable {
	String alertMessage="";
	Alert alert = driver.switchTo().alert();
	alertMessage=alert.getText();	
	System.out.println("alertMessage==="+alertMessage);
	try {
		Assert.assertTrue(alertMessage.equalsIgnoreCase(errorMessage));
	}
	catch(Exception e) {
		Assert.fail("Alert message pop up validation Failed");
	}
}

@Then("^click ok button$")
public void click_ok_button() throws Throwable {
	try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		}
	catch(Exception e) {
		Assert.fail("Failed to click on ok button"); 
	}
}

@Then("^Managed plan search screen is be displayed$")
public void managed_plan_search_screen_is_be_displayed() throws Throwable {
	try {
		Assert.assertTrue(Managed_UI_Pageobjects.Verify_Managed_plan_search(driver).isDisplayed(), "Verify_Create_Managed_Plan_Screen");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to verify Managed plan search screen ");
		  }
	}

@When("^Select any record from the table$")
public void select_any_record_from_the_table() throws Throwable {
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	if(tableRows.size()>0) {
		WebElement checkboxObj=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[1]/input"));
		checkboxObj.click();
		PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[2]")).getText();
    	System.out.println("PlanDetail="+PlanDetail);
    	String[] part1=PlanDetail.split(": ");
		String[] part3=part1[1].split("\n");
		planType=part3[0];
		planName=part1[part1.length-1];
		System.out.println("planType="+planType);
		System.out.println("planName="+planName);
		String[] part2=part1[2].split(" - ");
		year=part2[0];
		contractNumber=part2[1];
		String[] part4=part2[2].split("\n");
		pbpNumber=part4[0];
		System.out.println("year="+year);
		System.out.println("contractNumber="+contractNumber);
		System.out.println("pbpNumber="+pbpNumber);
		BusinessSegment=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[3]")).getText();
		StateCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[4]")).getText();
		CMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[5]")).getText();
		DrugCoverageType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[6]")).getText();
		EnrolleeType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[7]")).getText();
		SNPFlag=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[8]")).getText();
		SNPType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[9]")).getText();
		Status=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr[1]/td[10]")).getText();
		System.out.println("BusinessSegment="+BusinessSegment);
		System.out.println("StateCode="+StateCode);
		System.out.println("CMSCountyCode="+CMSCountyCode);
		System.out.println("DrugCoverageType="+DrugCoverageType);
		System.out.println("EnrolleeType="+EnrolleeType);
		System.out.println("SNPFlag="+SNPFlag);
		System.out.println("SNPType="+SNPType);
		System.out.println("Status="+Status);
	}
}

@Then("^Open the file$")
public void open_the_file() throws Throwable {
	file = new FileInputStream(new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx"));
    workbook = new XSSFWorkbook(file);
    sheet = workbook.getSheetAt(0);
}

@Then("^verify the order and names of columns in excel file$")
public void verify_the_order_and_names_of_columns_in_excel_file() throws Throwable {
	Row headRow=sheet.getRow(0);
	Assert.assertTrue(headRow.getLastCellNum()==14, "Verify Total number of columns in Sheet are as expected");
	System.out.println("Total number of columns in excel sheet="+headRow.getLastCellNum());
    for(int i=0;i<14;i++) {
    	System.out.println(headRow.getCell(i).getStringCellValue().trim());
    	colValue=headRow.getCell(i).getStringCellValue().trim();
    	switch(i) {
    	case 0:
    		Assert.assertTrue(colValue.equals("Year"), "Verify First Column name in excel sheet is --> Year");
//    		Constants.test.log(Status.PASS, "Verify First Column name in excel sheet is --> Year");
    		break;
    	case 1:
    		Assert.assertTrue(colValue.equals("Contract Number"), "Verify Second Column name in excel sheet is --> Contract Number");
//    		Constants.test.log(Status.PASS, "Verify Second Column name in excel sheet is --> Contract Number");
    		break;	
    	case 2:
    		Assert.assertTrue(colValue.equals("PBP"), "Verify Third Column name in excel sheet is --> PBP");
//    		Constants.test.log(Status.PASS, "Verify Third Column name in excel sheet is --> PBP");
    		break;	
    	case 3:
    		Assert.assertTrue(colValue.equals("Status"), "Verify Fourth Column name in excel sheet is --> Status");
//    		Constants.test.log(Status.PASS,"Verify Fourth Column name in excel sheet is --> Status");
    		break;
    	case 4:
    		Assert.assertTrue(colValue.equals("Market Product Name"), "Verify Fifth Column name in excel sheet is --> Market Product Name");
//    		Constants.test.log(Status.PASS, "Verify Fifth Column name in excel sheet is --> Market Product Name");
    		break;	
    	case 5:
    		Assert.assertTrue(colValue.equals("Product Type"), "Verify Sixth Column name in excel sheet is --> Product Type");
//    		Constants.test.log(Status.PASS, "Verify Sixth Column name in excel sheet is --> Product Type");
    		break;
    	case 6:
    		Assert.assertTrue(colValue.equals("CMS State Code"), "Verify Seventh Column name in excel sheet is --> CMS State Code");
//    		Constants.test.log(Status.PASS, "Verify Seventh Column name in excel sheet is --> CMS State Code");
    		break;	
    	case 7:
    		Assert.assertTrue(colValue.equals("CMS County Code"), "Verify Eighth Column name in excel sheet is --> Year");
//    		Constants.test.log(Status.PASS, "Verify Eighth Column name in excel sheet is --> Year");
    		break;
    	case 8:
    		Assert.assertTrue(colValue.equals("State Code"), "Verify Ninth Column name in excel sheet is --> State Code");
//    		Constants.test.log(Status.PASS, "Verify Ninth Column name in excel sheet is --> State Code");
    		break;	
    	case 9:
    		Assert.assertTrue(colValue.equals("SNP Flag"), "Verify Tenth Column name in excel sheet is --> SNP Flag");
//    		Constants.test.log(Status.PASS, "Verify Tenth Column name in excel sheet is --> SNP Flag");
    		break;	
    	case 10:
    		Assert.assertTrue(colValue.equals("SNP Type"), "Verify Eleventh Column name in excel sheet is --> SNP Type");
//    		Constants.test.log(Status.PASS, "Verify Eleventh Column name in excel sheet is --> SNP Type");
    		break;	
    	case 11:
    		Assert.assertTrue(colValue.equals("Business Segment"), "Verify Twelth Column name in excel sheet is --> Business Segment");
//    		Constants.test.log(Status.PASS, "Verify Twelth Column name in excel sheet is --> Business Segment");
    		break;	
    	case 12:
    		Assert.assertTrue(colValue.equals("Drug Coverage Type"), "Verify Thirteenth Column name in excel sheet is --> Drug Coverage Type");
//    		Constants.test.log(Status.PASS, "Verify Thirteenth Column name in excel sheet is --> Drug Coverage Type");
    		break;	
    	case 13:
    		Assert.assertTrue(colValue.equals("Enrollee Type"), "Verify Fourteenth Column name in excel sheet is --> Enrollee Type");
//    		Constants.test.log(Status.PASS, "Verify Fourteenth Column name in excel sheet is --> Enrollee Type");
    		break;	
    		
    	default:
    		System.out.println("DEFAULT---> Required column does not exist in excel sheet");
    		break;
     	   	}
    	}
	    workbook.close();
		Thread.sleep(2000);
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    System.out.println(timeStamp);
	   	File oldName =new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
	   	File newName = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export " + timeStamp + ".xlsx");
	   	if(oldName.renameTo(newName)) {
	   		System.out.println("renamed");
	   	} else {
	   		System.out.println("Error");
	   	}
	}

@Then("^verify number of Records are same as in UI$")
public void verify_number_of_Records_are_same_as_in_UI() throws Throwable {
	File file1 = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
    if(file1.exists()) {
    	reqFile = new FileInputStream("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
    	reqWorkbook = WorkbookFactory.create(reqFile);
    	reqSheet = reqWorkbook.getSheet("Managed Plan UI Export");
        rowCount=reqSheet.getLastRowNum();
        Assert.assertTrue(rowCount==numRec, "Verify number of records in UI and Excel sheet are same");
    }
    else {
    	Assert.fail("File does not exist");
    }
}

@Then("^verify the data for rows in Excel file match with UI$")
public void verify_the_data_for_rows_in_Excel_file_match_with_UI() throws Throwable {
	DataFormatter formatter = new DataFormatter();
	String DBVal="";
	String stateCode="";
	String CMSStateCode="";
	String reqData="";
	String reqHeader="";
	Row headRow=reqSheet.getRow(0);
	int colCount=headRow.getLastCellNum();
	for(int i=1;i<=rowCount;i++) {
	Row currRow=reqSheet.getRow(i);
	TreeMap TempInnerHmp2 = new TreeMap<String, String>();
	for(int j=0;j<colCount;j++) {
		reqHeader=formatter.formatCellValue(headRow.getCell(j));
		reqData= formatter.formatCellValue(currRow.getCell(j));
		System.out.println(reqHeader);
		System.out.println(reqData);
		if(reqHeader.equals("CMS State Code")) {
			CMSStateCode=reqData;
		}
		else {
			if(reqHeader.equals("State Code")){
				stateCode=reqData;
			}
			if(reqHeader.equalsIgnoreCase("SNP Flag")){
				if(reqData.equals("Yes"))
					reqData="Y";
				else if(reqData.equalsIgnoreCase("No"))
					reqData="N";
				else
					reqData=reqData;
			}
			TempInnerHmp2.put(reqHeader, reqData);
		}
		InnerHmp2=TempInnerHmp2;
	}
	OuterHmp2.put(i,InnerHmp2);
	Utils.connectToSqlserverDB();
	String Query="select distinct(stgm.cmsstatecode) from [dbo].[StgManagedPlansLoad] stgm inner join [state] s on s.cmsstatecode=stgm.cmsstatecode where s.StateCode='strStateCode'";
	Query=Query.replace("strStateCode", stateCode);
	System.out.println("Query==>"+Query);
	try {
		Constants.resultset = Constants.statement.executeQuery(Query);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();	
		for (int k = 1; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresults.put(Constants.resultsetMetadata.getColumnName(j), Constants.resultset.getString(j));
			}
		}
		System.out.println(DBresults);
	}
	catch (Exception e) {
	Assert.fail("failed to compare UI search results with database");
	}
	for (String value : DBresults.values()) {
		if (value != null)
			Assert.assertTrue(value.equals(CMSStateCode), "Validate-CMS State code in DB ans Excel sheet are matching " );
		else
			Assert.fail("CMS State code validation in DB failed");  
		}
	}
	System.out.println(OuterHmp);
	System.out.println(OuterHmp2);
	for(int k=1;k<=numRec;k++) {
		Assert.assertTrue(OuterHmp.get(k).equals(OuterHmp2.get(k)), "Validate-UI and Export data is matching " );
	}
	reqWorkbook.close();
	Thread.sleep(2000);
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    System.out.println(timeStamp);
   	File oldName =new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
   	File newName = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export " + timeStamp + ".xlsx");
   	if(oldName.renameTo(newName)) {
   		System.out.println("renamed");
   	} else {
   		System.out.println("Error");
   	}
}

@When("^Select Order by dropdown value as \"([^\"]*)\"$")
public void select_Order_by_dropdown_value_as(String orderType) throws Throwable {
	OrderByTypeGobal=orderType;
	Managed_UI_Pageobjects.select_OrderBy_dropdown(driver).selectByVisibleText(orderType);
	Thread.sleep(4000);
}

@Then("^verify data is sorted as per order selected$")
public void verify_data_is_sorted_as_per_order_selected() throws Throwable {
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	if(tableRows.size()>0) {
		switch(OrderByTypeGobal) {
	    case "State Code" :
	    	for(int i=1;i<=tableRows.size();i++) {
		    	StateCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[4]")).getText();
				actualStateOrderUI.add(StateCode);
				ExpectedStateOrderUI.add(StateCode);
	    	}
			Collections.sort(ExpectedStateOrderUI);
			System.out.println("actualStateOrderUI="+actualStateOrderUI);
			System.out.println("ExpectedStateOrderUI="+ExpectedStateOrderUI);
			Assert.assertTrue(actualStateOrderUI.equals(ExpectedStateOrderUI), "Verify UI State Code Column is in sorted order-ascending");
			break;
	    case "Business Segment" :
	    	for(int i=1;i<=tableRows.size();i++) {
	    		BusinessSegment=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[3]")).getText();
		    	actualBusinessSegmentUI.add(BusinessSegment);
		    	ExpectedBusinessSegmentUI.add(BusinessSegment);
	    	}
			Collections.sort(ExpectedBusinessSegmentUI);
			System.out.println("actualBusinessSegmentUI="+actualBusinessSegmentUI);
			System.out.println("ExpectedBusinessSegmentUI="+ExpectedBusinessSegmentUI);
			Assert.assertTrue(actualBusinessSegmentUI.equals(ExpectedBusinessSegmentUI), "Verify UI Business Segment Column is in sorted order-ascending");
	  	  break;
	    case "Product Type" :
	    	for(int i=1;i<=tableRows.size();i++) {
	    		PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[2]")).getText();
	    		String[] part1=PlanDetail.split(": ");
				String[] part3=part1[1].split("\n");
				planType=part3[0];
				actualProductTypeUI.add(planType);
				ExpectedProductTypUI.add(planType);
	    	}
			Collections.sort(ExpectedProductTypUI);
			System.out.println("actualProductTypeUI="+actualProductTypeUI);
			System.out.println("ExpectedProductTypUI="+ExpectedProductTypUI);
			Assert.assertTrue(actualProductTypeUI.equals(ExpectedProductTypUI), "Verify UI Product Type Column is in sorted order-ascending");
			break;
	    case "Contract Number" :
	    	ArrayList<String> actualContactNumberUI=new ArrayList<String>();
	    	ArrayList<String> ExpectedContactNumberUI=new ArrayList<String>();
	    	for(int i=1;i<=tableRows.size();i++) {
	    		PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[2]")).getText();
	    		String[] part1=PlanDetail.split(": ");
				String[] part3=part1[1].split("\n");
				String[] part2=part1[2].split(" - ");
				contractNumber=part2[1];
				actualContactNumberUI.add(contractNumber);
				ExpectedContactNumberUI.add(contractNumber);
	    	}
			Collections.sort(ExpectedStateOrderUI);
			System.out.println("actualContactNumberUI="+actualContactNumberUI);
			System.out.println("ExpectedContactNumberUI="+ExpectedContactNumberUI);
			Assert.assertTrue(actualContactNumberUI.equals(ExpectedContactNumberUI), "Verify UI Contract Number Column is in sorted order-ascending");
			break;
	    default :
	  	  Assert.fail("Failed to check sorting on UI");  
		  }
	}
	else {
		Assert.fail("Table rows are not present");  
	}
}

@Then("^Select all records from the table$")
public void select_all_records_from_the_table() throws Throwable {
	Managed_UI_Pageobjects.All_Checkbox(driver).click();
	Thread.sleep(3000);
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	TotalRecords=tableRows.size();
}

@Then("^verify number of Records should be same as UI$")
public void verify_number_of_Records_should_be_same_as_UI() throws Throwable {
	File file1 = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
    if(file1.exists()) {
    	reqFile = new FileInputStream("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
    	reqWorkbook = WorkbookFactory.create(reqFile);
    	reqSheet = reqWorkbook.getSheet("Managed Plan UI Export");
        rowCount=reqSheet.getLastRowNum();
        Assert.assertTrue(rowCount==TotalRecords, "Verify number of records in UI and Excel sheet are same");
    }
    else {
    	Assert.fail("File does not exist");
    }
}

@Then("^All values of \"([^\"]*)\" feild must be in same order as UI$")
public void all_values_of_feild_must_be_in_same_order_as_UI(String arg1) throws Throwable {
		String value="";
			switch(OrderByTypeGobal) {
		    case "State Code" :
		    	for(int i=1;i<=rowCount;i++) {
		    		Row currRow=reqSheet.getRow(i);
		    		value=formatter.formatCellValue(currRow.getCell(8));
		    		actualStateOrderExportSheet.add(value);
		    		ExpectedStateOrderExportSheet.add(value);
		    	}
				Collections.sort(ExpectedStateOrderExportSheet);
				System.out.println("actualStateOrderExportSheet="+actualStateOrderExportSheet);
				System.out.println("ExpectedStateOrderExportSheet="+ExpectedStateOrderExportSheet);
				Assert.assertTrue(actualStateOrderExportSheet.equals(ExpectedStateOrderExportSheet), "Verify Export Sheet State Code Column is in sorted order-ascending");
				break;
		    case "Business Segment" :
		    	for(int i=1;i<=rowCount;i++) {
		    		Row currRow=reqSheet.getRow(i);
		    		value=formatter.formatCellValue(currRow.getCell(11));
		    		actualBusinessSegmentExportSheet.add(value);
		    		ExpectedBusinessSegmentExportSheet.add(value);
		    	}
				Collections.sort(ExpectedStateOrderExportSheet);
				System.out.println("actualBusinessSegmentExportSheet="+actualBusinessSegmentExportSheet);
				System.out.println("ExpectedBusinessSegmentExportSheet="+ExpectedBusinessSegmentExportSheet);
				Assert.assertTrue(actualBusinessSegmentExportSheet.equals(ExpectedBusinessSegmentExportSheet), "Verify Export Sheet Business Segment Column is in sorted order-ascending");
				break;	
		    case "Product Type" :
		    	for(int i=1;i<=rowCount;i++) {
		    		Row currRow=reqSheet.getRow(i);
		    		value=formatter.formatCellValue(currRow.getCell(5));
		    		actualProductTypeExportSheet.add(value);
		    		ExpectedProductTypeExportSheet.add(value);
		    	}
				Collections.sort(ExpectedProductTypeExportSheet);
				System.out.println("actualProductTypeExportSheet="+actualProductTypeExportSheet);
				System.out.println("ExpectedProductTypeExportSheet="+ExpectedProductTypeExportSheet);
				Assert.assertTrue(actualProductTypeExportSheet.equals(ExpectedProductTypeExportSheet), "Verify Export Sheet Product Type Column is in sorted order-ascending");
				break;
		    case "Contract Number" :
		    	for(int i=1;i<=rowCount;i++) {
		    		Row currRow=reqSheet.getRow(i);
		    		value=formatter.formatCellValue(currRow.getCell(1));
		    		actualContactNumberExportSheet.add(value);
		    		ExpectedContactNumberExportSheet.add(value);
		    	}
				Collections.sort(ExpectedContactNumberExportSheet);
				System.out.println("actualContactNumberExportSheet="+actualContactNumberExportSheet);
				System.out.println("ExpectedContactNumberExportSheet="+ExpectedContactNumberExportSheet);
				Assert.assertTrue(actualContactNumberExportSheet.equals(ExpectedContactNumberExportSheet), "Verify Export Sheet Business Segment Column is in sorted order-ascending");
				break;	
		    default :
			  	  Assert.fail("Failed to check sorting on Export sheet"); 
			}
		reqWorkbook.close();
		Thread.sleep(2000);
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    System.out.println(timeStamp);
	   	File oldName =new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
	   	File newName = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export " + timeStamp + ".xlsx");
	   	if(oldName.renameTo(newName)) {
	   		System.out.println("renamed");
	   	} else {
	   		System.out.println("Error");
	   	}
}

@When("^Click on Export Results button and save the Excel file$")
public void click_on_Export_Results_button_and_save_the_Excel_file() throws Throwable {
	try {
		Utils.click(driver, Managed_UI_Pageobjects.Export_Results_button(driver));
	    Thread.sleep(5000);
	    Robot robot=new Robot();
	    robot.keyPress(KeyEvent.VK_ALT);
	    robot.keyPress(KeyEvent.VK_S);
	    robot.keyRelease(KeyEvent.VK_ALT);
	    robot.keyRelease(KeyEvent.VK_S);
	    Thread.sleep(3000);
	    }
		catch(Exception e)
		{
			Assert.fail("failed to download the exported file");
		}
}

@Then("^the file with name Managed Plan UI Export should get downloaded$")
public void the_file_with_name_Managed_Plan_UI_Export_should_get_downloaded() throws Throwable {
	try {
		boolean exists=false;
		File file = new File("C:\\Downloads\\Saffron\\Managed Plan UI Export.xlsx");
	    exists = file.exists();
		Assert.assertTrue(exists, "Verify Managed Plan UI Export.xlsx file is sucessfuly saved");
	  }
	 catch(Exception e) {
			Assert.fail("Failed to Verify Managed Plan UI Export.xlsx file is saved");
	 	}
}

@When("^Select multiple records from the table$")
public void select_multiple_records_from_the_table() throws Throwable {
	arrayDetails=new String[numRec];
	String PlanDetail="";
	int selectedRow=0;
	List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='grid']/tbody/tr"));
	try {
		if(tableRows.size()<numRec) {
			Assert.assertTrue(tableRows.size()<numRec, "Table does not contains required number of records");}
			else 
			{
				int keyOuter1=1;
			   for(int i=1;i<tableRows.size();i++)
			   {
	        		InnerHmp = new TreeMap<String, String>();
		        	WebElement checkboxObj=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[1]/input"));
		        	PlanDetail=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[2]")).getText();
		        	BusinessSegment=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[3]")).getText();
					StateCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[4]")).getText();
					CMSCountyCode=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[5]")).getText();
					DrugCoverageType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[6]")).getText();
					EnrolleeType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[7]")).getText();
					SNPFlag=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[8]")).getText();
					SNPType=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[9]")).getText();
					Status=driver.findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[10]")).getText();
		        	arrayDetails[selectedRow]=PlanDetail;
		        	System.out.println("PlanDetail="+PlanDetail);
		        	String[] part1=PlanDetail.split(": ");
					String[] part3=part1[1].split("\n");
					planType=part3[0];
					planName=part1[part1.length-1];
					System.out.println("planType="+planType);
					System.out.println("planName="+planName);
					String[] part2=part1[2].split(" - ");
					year=part2[0];
					contractNumber=part2[1];
					String[] part4=part2[2].split("\n");
					pbpNumber=part4[0];
					System.out.println("year="+year);
					System.out.println("contractNumber="+contractNumber);
					System.out.println("pbpNumber="+pbpNumber);
					System.out.println("BusinessSegment="+BusinessSegment);
					System.out.println("StateCode="+StateCode);
					System.out.println("CMSCountyCode="+CMSCountyCode);
					System.out.println("DrugCoverageType="+DrugCoverageType);
					System.out.println("EnrolleeType="+EnrolleeType);
					System.out.println("SNPFlag="+SNPFlag);
					System.out.println("SNPType="+SNPType);
					System.out.println("Status="+Status);
					InnerHmp.put("Year", year);
					InnerHmp.put("Contract Number", contractNumber);
					InnerHmp.put("PBP", pbpNumber);
					InnerHmp.put("Product Type", planType);
					InnerHmp.put("Market Product Name", planName);
					InnerHmp.put("Business Segment", BusinessSegment);
					InnerHmp.put("State Code", StateCode);
					InnerHmp.put("CMS County Code", CMSCountyCode);
					InnerHmp.put("Drug Coverage Type", DrugCoverageType);
					InnerHmp.put("Enrollee Type", EnrolleeType);
					InnerHmp.put("SNP Flag", SNPFlag);
					InnerHmp.put("SNP Type", SNPType);
					InnerHmp.put("Status", Status);
					OuterHmp.put(keyOuter1,InnerHmp);
					keyOuter1++;
		        	checkboxObj.click();
		        	selectedRow++;
		        	if(selectedRow==numRec) {
		        		break;
		        	}
			   }
			}
	}
		 catch(Exception e) 
			{
				Assert.fail("Failed to select records from the table");
			  }
			System.out.println(OuterHmp);
	}
}