package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class DSNP extends BeforeAndAfter {
	// TC_EOB Group Exceptions_Create Exception_Cancel_EOB_Na
	@Test()
	void TC_dsnp()
			throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		// starting extent HTML report
		Constants.test = Constants.extent
				.createTest("DSNP");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank(
				"TC_DSNP").equalsIgnoreCase("Y")) {
			initiateBrowser();
			
			
		}
	
	}}
