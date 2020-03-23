package testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import actions.Action_EOBPage;
import miscellaneous.BeforeAndAfter;
import pageObjects.Header;
import utilities.Constants;
import utilities.Utils;

public class EOB_Page_TestCases extends BeforeAndAfter {

	@Test
	public void TC_EOB_PlanRule_Create_New_EOB_PlanRule_Search_parameters() {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("TC_EOB_PlanRule_Create_New_EOB_PlanRule_Search_parameters");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_EOB_PlanRule_Create_New_EOB_PlanRule_Search_parameters")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			Utils.click(Header.EOB_link());
			Action_EOBPage.clickOnCreateEOBPlanRuleButton();
			Action_EOBPage.verify_planYear_defaultValue();
			Action_EOBPage.verify_category_dropDownValue();
			Action_EOBPage.verify_contractNumber_forIndividual();
		} else
		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
}
