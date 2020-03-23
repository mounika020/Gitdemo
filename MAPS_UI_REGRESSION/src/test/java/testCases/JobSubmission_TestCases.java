package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Actions_JobSubmission;
import miscellaneous.BaseClass;
import miscellaneous.BeforeAndAfter;
import pageObjects.Header;
import utilities.Constants;
import utilities.QueryBank;
import utilities.Utils;

public class JobSubmission_TestCases extends BeforeAndAfter {
	Workbook inWorkbook = null;

	@Test
	public void JobSubmission()
			throws ClassNotFoundException, SQLException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("JobSubmission");
		//initiateBrowser();
		FileInputStream input_Excel;
	
		try {
			input_Excel = new FileInputStream("./src/test/java/testData/JobSubmission/JobSubmission.xlsx");
			inWorkbook = new XSSFWorkbook(input_Excel);
			
		} catch (FileNotFoundException e) {
			Constants.test.log(Status.FAIL, "Input/test file not found");
			Assert.fail();
		} catch (IOException e) {
			Constants.test.log(Status.FAIL, "Input/test file not found");
			Assert.fail();
		}
		Sheet inSheet = inWorkbook.getSheet("JobSubmission");
		WebDriver driver;
		driver = Utils.getDriver_IE();
		new BaseClass(driver);
		driver.manage().window().maximize();
		driver.get(inSheet.getRow(1).getCell(2).getStringCellValue());
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Actions_JobSubmission.clickBatchCatalogLink();
		Thread.sleep(10000);
		Actions_JobSubmission.clickTWSServiceRequest();
		Thread.sleep(3000);
		Actions_JobSubmission.enterShortDescription(inSheet.getRow(1).getCell(4).getStringCellValue());
		Actions_JobSubmission.selectTWSEnvironment(inSheet.getRow(1).getCell(5).getStringCellValue());
		Actions_JobSubmission.selectActionType(inSheet.getRow(1).getCell(6).getStringCellValue());	
		Thread.sleep(2000);
		Actions_JobSubmission.selectObjectType(inSheet.getRow(1).getCell(7).getStringCellValue());	
		Actions_JobSubmission.enterJobFamily(inSheet.getRow(1).getCell(8).getStringCellValue());
		Actions_JobSubmission.selectAction(inSheet.getRow(1).getCell(9).getStringCellValue());
		Actions_JobSubmission.clickAddWorkStation();
		Thread.sleep(2000);
		Actions_JobSubmission.clickSearchWorkStation();
		Actions_JobSubmission.selectWorkStation(inSheet.getRow(1).getCell(10).getStringCellValue());
		Actions_JobSubmission.clickSelectWorkStation();
		Actions_JobSubmission.clickOKButton();
		Thread.sleep(2000);
		Actions_JobSubmission.clickAddJob();
		Thread.sleep(2000);
		Actions_JobSubmission.clickSearchJob();
		Actions_JobSubmission.selectWorkStation(inSheet.getRow(1).getCell(11).getStringCellValue());
		Actions_JobSubmission.clickSelectWorkStation();
		Actions_JobSubmission.clickOKButton();
		Thread.sleep(2000);
		Actions_JobSubmission.clickSubmitJob();
		Thread.sleep(2000);
		Actions_JobSubmission.clickJobID();
		Thread.sleep(2000);
		Actions_JobSubmission.clickExecute();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions_JobSubmission.VerifyJobStatus();
		driver.quit();
		
		//Launch IBM Job Monitoring tool
		driver = Utils.getDriver_IE();
		new BaseClass(driver);
		driver.manage().window().maximize();
		driver.get(inSheet.getRow(1).getCell(3).getStringCellValue());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions_JobSubmission.enterUserID(inSheet.getRow(1).getCell(0).getStringCellValue());
		Actions_JobSubmission.enterPassword(inSheet.getRow(1).getCell(1).getStringCellValue());
		Actions_JobSubmission.clickGo();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions_JobSubmission.clickOkToEndSession();
		Actions_JobSubmission.clickMonitorLoad();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Actions_JobSubmission.enterQuery(inSheet.getRow(1).getCell(12).getStringCellValue());
		Actions_JobSubmission.clickRun();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Actions_JobSubmission.verifyStatus(inSheet.getRow(1).getCell(13).getStringCellValue());
		driver.quit();
	}
}
