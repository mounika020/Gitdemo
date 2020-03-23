package runners;
import java.io.File;
import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./Features/Saffaron_Maps_US1225937_Managed Plan UI_Managed Plan Area_State and Counties.feature", glue = {
		"stepDefinitions" }, dryRun = false, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:", "pretty",
		"html:cucumber_reports/HTML/Test1.html"},monochrome = true)

public class Runner_Configuration_US1225937_ManagedUI_ManagedPlanArea_StatesAndCounties extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Platform", "Windows 7");
		Reporter.setSystemInfo("Environment", "QA");
	}
}