package com.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Tables2 {
public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
//	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//	capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
	//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, "TRUE");
	//System.setProperty("webdriver.ie.driver","C:/Users/vbharga5/Documents/selenium java webdriver/IEDriver 3.2.0/IEDriverServer.exe");
	//WebDriver driver= new InternetExplorerDriver();
	//Thread.sleep(5000);
		//driver.get("http://demo.automationtesting.in/WebTable.html");
	
//	capabilities.setCapability(CapabilityType.VERSION, "11");
//	//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//	capabilities.setCapability("ignoreZoomSetting", true);

	
		System.setProperty("webdriver.gecko.driver","C:/Users/vbharga5/Documents/selenium java webdriver/New geckodriver/geckodriver.exe");
		 
		// Initialise browser
		 
		WebDriver driver=new FirefoxDriver();
		 
		// Load google.com
		 
		driver.get("http://www.google.com");



}

}
