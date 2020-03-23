package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import actions.Action_EOB_Page;
import utilities.Constants;
import utilities.Utils;

public class TestCasesSelector extends BeforeAndAfter {
	@Test
	void count_practise() throws ClassNotFoundException, SQLException {
		// starting extent HTML report
		Constants.test = Constants.extent.createTest("count_practise");

		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("count_practise")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/TC_EOB_GroupExceptions_CreateException_Cancel_EOB_N_Y.xlsx","Sheet1");
			Action_EOB_Page.clickOnMaterials();
			Action_EOB_Page.clickOnEOB_Link();
			
			
			
		}}}