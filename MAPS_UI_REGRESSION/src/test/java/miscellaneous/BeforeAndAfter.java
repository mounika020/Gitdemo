package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;

import utilities.Constants;
import utilities.Utils;

public class BeforeAndAfter {
	public static WebDriver driver;

	public void initiateBrowser() {
//		driver = Utils.getDriver_IE();
		driver = Utils.getDriver_phantoJSdriver();
		// driver = Utils.getDriver_FireFox();
		new BaseClass(driver);
		driver.manage().window().maximize();
		driver.get(Constants.MAPS_UI_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeSuite
	public void HTMLreporter() throws Exception {
		Constants.startReport();
		Constants.startInfobank();
	}

	// @BeforeClass
	// public void startConfig() throws Throwable {
	// driver = Utils.getDriver_IE();
	// new BaseClass(driver);
	// driver.manage().window().maximize();
	// driver.get(Constants.MAPS_UI_URL);
	// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// }

	@AfterMethod
	public void getResult(ITestResult result, Method method) throws Exception {
		String methodName = method.getName();
		if (result.getStatus() == ITestResult.FAILURE) {
			Utils.takeScreenShot_Ashot(Constants.currentDir + "/FailedScreenshots/", methodName);
			String screePath = Constants.currentDir + "/FailedScreenshots/" + methodName + ".png";
			// Constants.test.log(LogStatus.FAIL, result.getThrowable()
			// + Constants.test.addScreenCapture(screePath));
			Constants.test.fail(result.getThrowable()).addScreenCaptureFromPath(screePath);
			
//			TakesScreenshot tScreenshot=(TakesScreenshot)driver;
//			File src=tScreenshot.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(src, new File("./phantom/saple.png"));
//			String screePath = "./phantom/saple.png" + ".png";
//			// Constants.test.log(LogStatus.FAIL, result.getThrowable()
//			// + Constants.test.addScreenCapture(screePath));
//			Constants.test.fail(result.getThrowable()).addScreenCaptureFromPath(screePath);

		} else if (result.getStatus() == ITestResult.SKIP) {
			Constants.test.log(Status.SKIP, result.getThrowable());
		} else {
			// Constants.test.log(Status.PASS, "Testcase " + methodName + " has
			// been passed");
		}
//		driver.quit();
	}

	// @AfterTest
	// public void endreport() {
	// Constants.extent.flush();
	// // Utils.deleteAllCookies();
	// try {
	// Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
	// Runtime.getRuntime().exec("taskkill /F /IM chromedriver *32.exe");
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	@AfterSuite
	public void reportWriter() {
		Constants.extent.flush();
		// Utils.deleteAllCookies();
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver *32.exe");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
