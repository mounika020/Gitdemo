package testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Action_loginPage;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class pageName_page_testCases extends BeforeAndAfter {

	@Test
	void TC_IND_Insert_Chart_ANOC() {
		Constants.test = Constants.extent.createTest("TC_IND_Insert_Chart_ANOC");

		if (Utils.getTestCasePreferenceFromInfobank("TC_IND_Insert_Chart_ANOC").equalsIgnoreCase("Y")) {
			initiateBrowser();
			Action_loginPage.typeUserName();
			Action_loginPage.typePassword();
		} else {
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}

	}
}
