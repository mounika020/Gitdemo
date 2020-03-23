package runners;
import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./Features/Saffron_US1223994_Managed Plan UI - Mass Update Screen.feature", glue = {
		"stepDefinitions" }, dryRun = false, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:", "pretty",
		"html:cucumber_reports/HTML/Test1.html"},monochrome = true)

public class Runner_Managed_Mass_Update extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Platform", "Windows 7");
		Reporter.setSystemInfo("Environment", "QA");
	}
}

//package runners;
//
//import java.io.File;
//
//import org.testng.annotations.AfterClass;
//
//import com.cucumber.listener.Reporter;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//
//@CucumberOptions(features = "./Features/Saffron_US1223994_Managed Plan UI - Mass Update Screen.feature", glue = {
//		"stepDefinitions" }, dryRun = false, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:", "pretty",
//		"html:cucumber_reports/HTML/US761928.html"},monochrome = true)
//public class Runner_Managed_Mass_Update extends AbstractTestNGCucumberTests {
//	@AfterClass
//	public static void teardown() {
//		Reporter.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
//		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//		Reporter.setSystemInfo("Platform", "Windows 7");
//		Reporter.setSystemInfo("Environment", "QA");
//	}
//}
