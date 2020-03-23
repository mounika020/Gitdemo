package stepDefinitions;

import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import miscellaneous.BaseClass;
import utilities.Constants;
import utilities.Utils;

public class Hooks {
	public static WebDriver driver;

	@After
	public void closeDriver(Scenario scenario) {
		System.out.println("=================================");
		System.out.println(scenario.getName() + " : Status : " + scenario.getStatus());
		System.out.println("=================================");

//		driver.close();
     	driver.quit();
	}

	@AfterMethod
	void tearDownBrowser() {
//		driver.close();
	}

	@Before
	public void openBrowser(Scenario scenario) {
		System.out.println("=================================");
		System.out.println("Starting : " + scenario.getName());
		System.out.println("=================================");
	/*	String downloadFilepath = "C:/Saffron work";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);*/
		
		//Resize current window to the set dimension
		

		// driver = Utils.getDriver_IE();
		System.setProperty("webdriver.ie.driver", "./Lib/IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability("ignoreZoomSetting", true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, false);
		driver = new InternetExplorerDriver(cap);
		new BaseClass(driver);
		driver.manage().window().maximize();
		driver.get(Constants.MAPS_UI_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
