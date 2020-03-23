package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Action_EOB_Page;
import actions.Actions_GroupAdmin;
import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.Utils;

public class GroupAdmin_TestCases extends BeforeAndAfter {
	// TC_EOB Group Exceptions_Create Exception_Cancel_EOB_N

	@Test()
	void TC_MAPS_WEB_UI_GroupAdminTab_Individual_Edit() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		
		Constants.test = Constants.extent.createTest("TC_MAPS_WEB_UI_GroupAdminTab_Individual_Edit");
		// checking the execution flag in Mapa_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_MAPS_WEB_UI_GroupAdminTab_Individual_Edit")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			
			//XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
			Actions_GroupAdmin.clickOnAdmin();
			Actions_GroupAdmin.clickOnGroupAdmin_Link();
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();
			Actions_GroupAdmin.InputParameters();
			Actions_GroupAdmin.EnterMasterGroupNumber(Actions_GroupAdmin.Inputvalues.get("MasterGroupNumber"));
			Actions_GroupAdmin.EnterGroupNumber(Actions_GroupAdmin.Inputvalues.get("GroupNumber"));
			Actions_GroupAdmin.EnterContract(Actions_GroupAdmin.Inputvalues.get("Contract"));
			Actions_GroupAdmin.EnterPBP(Actions_GroupAdmin.Inputvalues.get("PBP"));
			Actions_GroupAdmin.IndividualGroupListSiteName_Dropdown(Actions_GroupAdmin.Inputvalues.get("SiteName"));
			Actions_GroupAdmin.IndividualGroupListYear_Dropdown(Actions_GroupAdmin.Inputvalues.get("Year"));
			Actions_GroupAdmin.IndividualGroupListClaimsSystem_Dropdown(Actions_GroupAdmin.Inputvalues.get("ClaimsSystem"));
			Actions_GroupAdmin.clickOnSearchGroups_Link();
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyGroupEditScreen();
			Actions_GroupAdmin.VerifyGroupEditScreen_Contract_PBP_Year();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupNumber();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupName();
			Actions_GroupAdmin.VerifyGroupEditScreen_Location();
			Actions_GroupAdmin.VerifyGroupEditScreen_EffectiveDate();
			Actions_GroupAdmin.VerifyGroupEditScreen_TerminationDate();
			Actions_GroupAdmin.VerifyGroupEditScreen_RxVendor();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupType();
			
			// Date updates
			Actions_GroupAdmin.clickOnTerminationDate_Checkbox();
			Actions_GroupAdmin.EditTerminationDate(Actions_GroupAdmin.Inputvalues.get("TerminationDate"));
			Actions_GroupAdmin.clickOnRxVendor_Checkbox();
			Actions_GroupAdmin.EditClearRxVendor();
			Actions_GroupAdmin.EditRxVendor(Actions_GroupAdmin.Inputvalues.get("RxVendor"));
			Actions_GroupAdmin.clickOnSaveOnEditScreen();
			Actions_GroupAdmin.Alert_Accept();
			Actions_GroupAdmin.clickOnAdmin();
			Actions_GroupAdmin.clickOnGroupAdmin_Link();
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyGroupEditScreen();
			Actions_GroupAdmin.VerifyUpdatedData_TerminationDate();
			Actions_GroupAdmin.VerifyUpdatedData_RxVendor();
			Actions_GroupAdmin.CompareSearchResultWithDBvalues();
			Actions_GroupAdmin.clickOnTerminationDate_Checkbox();
			Actions_GroupAdmin.EditTerminationDate(Actions_GroupAdmin.Inputvalues.get("TerminationDate_1"));
			Actions_GroupAdmin.clickOnRxVendor_Checkbox();
			Actions_GroupAdmin.EditClearRxVendor();
			Actions_GroupAdmin.EditRxVendor(Actions_GroupAdmin.Inputvalues.get("RxVendor_1"));
			Actions_GroupAdmin.clickOnCancelOnEditScreen();
			
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();	
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyUpdatedData_TerminationDate();
			Actions_GroupAdmin.VerifyUpdatedData_RxVendor();
			Actions_GroupAdmin.CompareSearchResultWithDBvalues();		
		}
		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	
	@Test()
	void TC_MAPS_WEB_UI_GroupAdminTab_Individual_LogicalDelete() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		
		Constants.test = Constants.extent.createTest("TC_MAPS_WEB_UI_GroupAdminTab_Individual_LogicalDelete");
		
		// checking the execution flag in Maps_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_MAPS_WEB_UI_GroupAdminTab_Individual_LogicalDelete")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			Actions_GroupAdmin.clickOnAdmin();
			Actions_GroupAdmin.clickOnGroupAdmin_Link();
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();
			Actions_GroupAdmin.InputParameters();
			Actions_GroupAdmin.EnterMasterGroupNumber(Actions_GroupAdmin.Inputvalues.get("MasterGroupNumber"));
			Actions_GroupAdmin.EnterGroupNumber(Actions_GroupAdmin.Inputvalues.get("GroupNumber"));
			Actions_GroupAdmin.EnterContract(Actions_GroupAdmin.Inputvalues.get("Contract"));
			Actions_GroupAdmin.EnterPBP(Actions_GroupAdmin.Inputvalues.get("PBP"));
			Actions_GroupAdmin.IndividualGroupListSiteName_Dropdown(Actions_GroupAdmin.Inputvalues.get("SiteName"));
			Actions_GroupAdmin.IndividualGroupListYear_Dropdown(Actions_GroupAdmin.Inputvalues.get("Year"));
			Actions_GroupAdmin.IndividualGroupListClaimsSystem_Dropdown(Actions_GroupAdmin.Inputvalues.get("ClaimsSystem"));
			Actions_GroupAdmin.clickOnSearchGroups_Link();
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyGroupEditScreen();
			Actions_GroupAdmin.VerifyGroupEditScreen_Contract_PBP_Year();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupNumber();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupName();
			Actions_GroupAdmin.VerifyGroupEditScreen_Location();
			Actions_GroupAdmin.VerifyGroupEditScreen_EffectiveDate();
			Actions_GroupAdmin.VerifyGroupEditScreen_TerminationDate();
			Actions_GroupAdmin.VerifyGroupEditScreen_RxVendor();
			Actions_GroupAdmin.VerifyGroupEditScreen_GroupType();
			
			// Date updates
			Actions_GroupAdmin.clickOnTerminationDate_Checkbox();
			Actions_GroupAdmin.EditTerminationDate(Actions_GroupAdmin.Inputvalues.get("TerminationDate"));
			Actions_GroupAdmin.clickOnRxVendor_Checkbox();
			Actions_GroupAdmin.EditClearRxVendor();
			Actions_GroupAdmin.EditRxVendor(Actions_GroupAdmin.Inputvalues.get("RxVendor"));
			Actions_GroupAdmin.clickOnSaveOnEditScreen();
			Actions_GroupAdmin.Alert_Accept();
			
			// verifying the updated data on UI
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();
			/*Actions_GroupAdmin.InputParameters();
			Actions_GroupAdmin.IndividualGroupList_ClearGroupNumber();
			Actions_GroupAdmin.IndividualGroupList_ClearMasterGroupNumber();
			Actions_GroupAdmin.IndividualGroupList_ClearContract();
			Actions_GroupAdmin.IndividualGroupList_ClearPBP();
			Actions_GroupAdmin.EnterMasterGroupNumber(Actions_GroupAdmin.Inputvalues.get("MasterGroupNumber"));
			Actions_GroupAdmin.EnterGroupNumber(Actions_GroupAdmin.Inputvalues.get("GroupNumber"));
			Actions_GroupAdmin.EnterContract(Actions_GroupAdmin.Inputvalues.get("Contract"));
			Actions_GroupAdmin.EnterPBP(Actions_GroupAdmin.Inputvalues.get("PBP"));
			Actions_GroupAdmin.IndividualGroupListSiteName_Dropdown(Actions_GroupAdmin.Inputvalues.get("SiteName"));
			Actions_GroupAdmin.IndividualGroupListYear_Dropdown(Actions_GroupAdmin.Inputvalues.get("Year"));
			Actions_GroupAdmin.IndividualGroupListClaimsSystem_Dropdown(Actions_GroupAdmin.Inputvalues.get("ClaimsSystem"));
			Actions_GroupAdmin.clickOnSearchGroups_Link();*/
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyGroupEditScreen();
			
			Actions_GroupAdmin.VerifyUpdatedData_TerminationDate();
			Actions_GroupAdmin.VerifyUpdatedData_RxVendor();
			Actions_GroupAdmin.CompareSearchResultWithDBvalues();

			//Cancel validation			
			// Data updates
			
			Actions_GroupAdmin.clickOnTerminationDate_Checkbox();
			Actions_GroupAdmin.EditTerminationDate(Actions_GroupAdmin.Inputvalues.get("TerminationDate_1"));
			Actions_GroupAdmin.clickOnRxVendor_Checkbox();
			Actions_GroupAdmin.EditClearRxVendor();
			Actions_GroupAdmin.EditRxVendor(Actions_GroupAdmin.Inputvalues.get("RxVendor_1"));
			Actions_GroupAdmin.clickOnCancelOnEditScreen();
			
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();	
			Actions_GroupAdmin.clickOnEdit_Link();
			Utils.waitForPageToLoad(driver);
			Actions_GroupAdmin.VerifyUpdatedData_TerminationDate();
			Actions_GroupAdmin.VerifyUpdatedData_RxVendor();
			Actions_GroupAdmin.CompareSearchResultWithDBvalues();		
		}
		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
	
	@Test()
	void TC_MAPS_WEB_UI_GroupAdminTab_Individual_MarkAsEmployer() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
		XSSFSheet inSheet = Utils.excel_sheet("./src/test/java/testData/GroupAdmin.xlsx", "Individual_Groups");
		Constants.test = Constants.extent.createTest("TC_MAPS_WEB_UI_GroupAdminTab_Individual_LogicalDelete");
		
		// checking the execution flag in Maps_Infobank
		if (Utils.getTestCasePreferenceFromInfobank("TC_MAPS_WEB_UI_GroupAdminTab_Individual_LogicalDelete")
				.equalsIgnoreCase("Y")) {
			initiateBrowser();
			
			Actions_GroupAdmin.clickOnAdmin();
			Actions_GroupAdmin.clickOnGroupAdmin_Link();
			Actions_GroupAdmin.VerifyIndividualGroupListScreen();
			//loading test data into Inputparameters list
			Actions_GroupAdmin.InputParameters();
			Actions_GroupAdmin.IndividualGroupListYear_Dropdown(Actions_GroupAdmin.Inputvalues.get("Year"));
			Actions_GroupAdmin.clickOnSearchGroups_Link();
			Actions_GroupAdmin.select_Group_inSearchgrid_Checkbox(Actions_GroupAdmin.Inputvalues.get("GroupNumber"));
			Actions_GroupAdmin.clickOnMarkasEmployer_Button();
		    Actions_GroupAdmin.Alert_Accept();
		   System.out.println(Actions_GroupAdmin.Inputvalues.get("GroupType"));
		   Thread.sleep(3000);
			Actions_GroupAdmin.IndividualGrouptype_Dropdown(Actions_GroupAdmin.Inputvalues.get("GroupType"));
			Actions_GroupAdmin.clickOnSearchGroups_Link();
			Actions_GroupAdmin.select_Group_inSearchgrid_Checkbox(Actions_GroupAdmin.Inputvalues.get("GroupNumber"));
			Actions_GroupAdmin.Compare_Status_withDbValus();
			Actions_GroupAdmin.clickOnflipgroup();
			 Actions_GroupAdmin.Alert_Accept();
			
			
			
	        
	
		}
		else

		{
			Constants.test.log(Status.SKIP, "Test Case has been skipped");
			throw new SkipException("Skipping this test case");
		}
	}
}
