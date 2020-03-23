package actions;

import java.sql.Driver;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.steadystate.css.parser.ParseException;

import miscellaneous.BaseClass;
import pageObjects.JobSubmission;
import utilities.Constants;
import utilities.Utils;

public class Actions_JobSubmission extends BaseClass {

	public Actions_JobSubmission(WebDriver driver) {
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
	
	public static void clickBatchIntakeLink() {
		try {
			JobSubmission.lnk_BatchIntake().click();
			Constants.test.log(Status.PASS, "click on Batch Intake Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Batch Intake Link");
			Assert.fail("failed to click on Batch Intake Link");
		}
	}
	
	public static void clickBatchCatalogLink() {
		try {
			JobSubmission.lnk_BatchCatalog().click();
			Constants.test.log(Status.PASS, "click on Batch Catalog Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Batch Catalog Link");
			Assert.fail("failed to click on Batch Catalog Link");
		}
	}
	
	public static void LoginServiveNow(String userID, String password) {
		try {
			JobSubmission.lnk_BatchCatalog().click();
			Constants.test.log(Status.PASS, "click on Batch Catalog Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Batch Catalog Link");
			Assert.fail("failed to click on Batch Catalog Link");
		}
	}
	
	public static void clickTWSServiceRequest() {
		try {
			driver.switchTo().frame(JobSubmission.frame1());
			Thread.sleep(3000);
			JobSubmission.lnk_TWSServiceRequest().click();
			Constants.test.log(Status.PASS, "click on TWS Service Request Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on TWS Service Request Link");
			Assert.fail("failed to click on TWS Service Request Link");
		}
	}
	
	public static void enterShortDescription(String ShortDesc) {
		try {
			if (ShortDesc.equalsIgnoreCase("null")) {
				JobSubmission.edit_ShortDescription().sendKeys("");
				Constants.test.log(Status.PASS, "enter Short Description");
			} else {
				JobSubmission.edit_ShortDescription().sendKeys(ShortDesc);
				Constants.test.log(Status.PASS, "enter Short Description");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Short Description");
			Assert.fail("failed to enter value in Short Description text field");
		}
	}
	
	public static void selectTWSEnvironment(String option) {
		try {
			JobSubmission.TWS_Envi_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select TWS Environment");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select TWS Environment");
			Assert.fail("failed to select an option from TWS Environment dropdown");
		}
	}
	
	public static void selectActionType(String option) {
		try {
			wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Action Type')]/following::div[1]/select"))));
			JobSubmission.Action_Type_dropdown().selectByValue(option);
			Constants.test.log(Status.PASS, "select Action Type");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Action Type");
			Assert.fail("failed to select an option from Action Type dropdown");
		}
	}
	
	public static void selectObjectType(String option) {
		try {
			JobSubmission.Object_Type_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select Object Type");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Object Type");
			Assert.fail("failed to select an option from Object Type dropdown");
		}
	}
	
	public static void enterJobFamily(String option) {
		try {
			JobSubmission.edit_Job_Family().sendKeys(option);
			JobSubmission.edit_Job_Family().sendKeys(Keys.TAB);
			Thread.sleep(2000);
			Constants.test.log(Status.PASS, "enter Job Family");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Job Family");
			Assert.fail("failed to enter Job Family");
		}
	}
	
	public static void selectAction(String option) {
		try {
			JobSubmission.Action_dropdown().selectByValue("submit");
			Thread.sleep(2000);
			Constants.test.log(Status.PASS, "select Action Type");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Action Type");
			Assert.fail("failed to select an option from Action Type dropdown");
		}
	}
	
	public static void clickAddWorkStation() {
		try {
			JobSubmission.btn_Add_WorkStation().click();
			Constants.test.log(Status.PASS, "click on Add Workstation Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Add Workstation Button");
			Assert.fail("failed to click on Add Workstation Button");
		}
	}
	
	public static void clickSearchWorkStation() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Search_WorkStation()));
			JobSubmission.btn_Search_WorkStation().click();
			Constants.test.log(Status.PASS, "click on Search Workstation Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Workstation Button");
			Assert.fail("failed to click on Search Workstation Button");
		}
	}
	
	public static void selectWorkStation(String option) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='slush_left']")));
			JobSubmission.WorkStation_dropdown().selectByVisibleText(option);
			Constants.test.log(Status.PASS, "select WorkStation/Job");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select WorkStation/Job");
			Assert.fail("failed to select an option from WorkStation/Job dropdown");
		}
	}
	
	public static void clickSelectWorkStation() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Select_WorkStation()));
			JobSubmission.btn_Select_WorkStation().click();
			Constants.test.log(Status.PASS, "click on Select Workstation/Job Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Select Workstation/Job Button");
			Assert.fail("failed to click on Select Button");
		}
	}
	
	public static void clickOKButton() {
		try {
			JobSubmission.btn_OK_WorkStation().click();
			Constants.test.log(Status.PASS, "click on OK Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on OK Button");
			Assert.fail("failed to click on OK Button");
		}
	}
	
	public static void clickAddJob() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Add_Job()));
			JobSubmission.btn_Add_Job().click();
			Constants.test.log(Status.PASS, "click on Add Job Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Add Job Button");
			Assert.fail("failed to click on Add Job Button");
		}
	}
	
	public static void clickSearchJob() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Search_Job()));
			JobSubmission.btn_Search_Job().click();
			Constants.test.log(Status.PASS, "click on Search Job Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Search Job Button");
			Assert.fail("failed to click on Search Job Button");
		}
	}
	
	public static void clickSubmitJob() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Submit_Job()));
			JobSubmission.btn_Submit_Job().click();
			Constants.test.log(Status.PASS, "click on Submit Job Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Submit Job Button");
			Assert.fail("failed to click on Submit Job Button");
		}
	}
	
	public static void clickJobID() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.lnk_Job_ID()));
			JobSubmission.lnk_Job_ID().click();
			Constants.test.log(Status.PASS, "click on Job ID Link");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Job ID Link");
			Assert.fail("failed to click on Job ID Link");
		}
	}
	
	public static void clickExecute() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Execute()));
			JobSubmission.btn_Execute().click();
			Constants.test.log(Status.PASS, "click on Execute Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Execute Button");
			Assert.fail("failed to click on Execute Button");
		}
	}
	
	public static void VerifyJobStatus() {
		try {
			Thread.sleep(6000);
			String sumbmissionStatus = JobSubmission.element_JobStatus().getFirstSelectedOption().getText();		
			System.out.println(sumbmissionStatus);
			if (sumbmissionStatus == "Complete") {
				Constants.test.log(Status.PASS, "Job Status Verified for Job ID " + JobSubmission.lnk_Job_ID().getText());
			}			
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Job Status not Verified for Job ID " + JobSubmission.lnk_Job_ID().getText());
			Assert.fail("Job Status not Verified for Job ID " + JobSubmission.lnk_Job_ID().getText());
		}
	}
	
	public static void enterUserID(String userID) {
		try {
			if (userID.equalsIgnoreCase("null")) {
				JobSubmission.edit_UserID().sendKeys("");
				Constants.test.log(Status.PASS, "enter user ID");
			} else {
				JobSubmission.edit_UserID().sendKeys(userID);
				Constants.test.log(Status.PASS, "enter user ID");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter user ID");
			Assert.fail("failed to enter value in user ID text field");
		}
	}
	
	public static void enterPassword(String password) {
		try {
			if (password.equalsIgnoreCase("null")) {
				JobSubmission.edit_Password().sendKeys("");
				Constants.test.log(Status.PASS, "enter password");
			} else {
				JobSubmission.edit_Password().sendKeys(password);
				Constants.test.log(Status.PASS, "enter password");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter password");
			Assert.fail("failed to enter value in password text field");
		}
	}
	
	public static void clickGo() {
		try {
			JobSubmission.btn_Go().click();
			Constants.test.log(Status.PASS, "click on Go Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Go Button");
			Assert.fail("failed to click on Go Button");
		}
	}
	
	public static void clickMonitorLoad() {
		try {
			Thread.sleep(10000);
			driver.switchTo().frame(JobSubmission.frameMonitorJob());
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Monitor_Load()));
			JobSubmission.btn_Monitor_Load().click();
			Constants.test.log(Status.PASS, "click on Monitor Load Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Monitor Load Button");
			Assert.fail("failed to click on Monitor Load Button");
		}
	}
	
	public static void enterQuery(String query) {
		try {
			Thread.sleep(5000);
			driver.switchTo().frame(JobSubmission.frameMonitorJob());
			wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.edit_Query()));
			JobSubmission.edit_Query().clear();
			if (query.equalsIgnoreCase("null")) {
				JobSubmission.edit_Query().sendKeys("");
				JobSubmission.edit_Query().sendKeys(Keys.TAB);
				Constants.test.log(Status.PASS, "enter query");
			} else {
				JobSubmission.edit_Query().sendKeys(query);
				JobSubmission.edit_Query().sendKeys(Keys.TAB);
				Constants.test.log(Status.PASS, "enter query");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter query");
			Assert.fail("failed to enter value in query text field");
		}
	}
	
	public static void clickRun() {
		try {
			Thread.sleep(5000);
			JobSubmission.btn_Run().click();
			Constants.test.log(Status.PASS, "click on Run Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Run Button");
			Assert.fail("failed to click on Run Button");
		}
	}
	
	public static void clickApplyFilter() {
		try {
			Thread.sleep(2000);
			JobSubmission.btn_Filter().click();
			Constants.test.log(Status.PASS, "click on Apply Filter Button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on Apply Filter Button");
			Assert.fail("failed to click on Apply Filter Button");
		}
	}
	
	public static void clickOkToEndSession() {
		try {
			Thread.sleep(5000); 	
			if(JobSubmission.btn_OkToEndSession().isDisplayed()){
				System.out.print(JobSubmission.btn_OkToEndSession().isDisplayed());
				JobSubmission.btn_OkToEndSession().click();
				Constants.test.log(Status.PASS, "click Ok Button to end other session");
			}			
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click Ok Button to end other session");
			Assert.fail("failed to click Ok Button to end other session");
		}
	}
	
	public static void enterJobFilter(String jobStatus) {
		try {
			Thread.sleep(2000);
			JobSubmission.edit_Filter().sendKeys(jobStatus);
			JobSubmission.edit_Filter().sendKeys(Keys.TAB);
			JobSubmission.edit_Filter().sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			Constants.test.log(Status.PASS, "Enter Job name in filer");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "Failed to enter Job name in filer");
			Assert.fail("Failed to enter Job name in filer");
		}
	}
	
	public static void verifyStatus(String job) {
		try {		
			Thread.sleep(30000);
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.switchTo().frame(1);
			Thread.sleep(10000);
			Actions_JobSubmission.enterJobFilter(job);
			Thread.sleep(10000);
			String status =  JobSubmission.element_getStatus().getText();
			System.out.println("Job status is" + status);
			int timeOutCount = 1;
			while((status.equalsIgnoreCase("Running")))
			{
				Thread.sleep(10000);
				JobSubmission.btn_Refresh().click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(JobSubmission.btn_Refresh()));
				status =  JobSubmission.element_getStatus().getText();
				System.out.println("Jobstatus: "+status +", Timeout: " + timeOutCount);
				timeOutCount++;
			}	
			if (status == "Successful" ) {
				Constants.test.log(Status.PASS, "Job submitted successfully");
			} else {
				Constants.test.log(Status.PASS, "Job Submission failed with status as:" + status);
			}

			}catch (Exception e) {
			Constants.test.log(Status.FAIL, "Job processing failed");
			Assert.fail("Job processing failed");
		}
	}	
}

