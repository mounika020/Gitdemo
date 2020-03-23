package actions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import pageObjects.EOBPage;
import utilities.Constants;
import utilities.Utils;

public class Action_EOBPage extends BaseClass {

	public Action_EOBPage(WebDriver driver) {
		super(driver);
	}

	static WebDriverWait wait = new WebDriverWait(driver, 20);

	public static void verify_planYear_defaultValue() {
		try {
			Assert.assertTrue(EOBPage.planYear_dropdown().getAllSelectedOptions().toString()
					.equalsIgnoreCase(Integer.toString(Calendar.YEAR)));
			Constants.test.log(Status.PASS, "verify plan year default value");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify plan year default value");
			Assert.fail("failed to verify plan year default value");
		}
	}

	public static void verify_category_dropDownValue() {
		try {
			List dropdWonOptions = new ArrayList();
			dropdWonOptions.add("Individual");
			dropdWonOptions.add("Employer");
			dropdWonOptions.add("Managed");
			Assert.assertTrue(EOBPage.category_dropdown().getOptions().containsAll(dropdWonOptions));
			Constants.test.log(Status.PASS, "verify values in category drop down");

		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify values in category drop down");
			Assert.fail("failed to verify values in category drop down");
		}
	}

	public static void verify_contractNumber_forIndividual() {
		try {
			List<WebElement> dropDownOptoins = EOBPage.contract_dropdown().getOptions();
			Utils.connectToSqlserverDB();
			Constants.resultset = Constants.statement.executeQuery(
					"select distinct contractnumber from [contract] c inner join [Plan] p on c.contractid = p.contractid inner join BusinessSegment b on b.BusinessSegmentID = p.BusinessSegmentID where year(p.effectivedate)='2017' and PBPnumber not like '8%' and PBPnumber not like '9%' and c.contractNumber not in ('MCAID', 'DENTL', 'MDSUP', 'SRSUP') and b.name not in ('Medica', 'Harvard Pilgrim', 'SCOT')");
			System.out.println(Constants.resultset.getRow() + " --> row position");
			Constants.resultset.last();
			System.out.println(Constants.resultset.getRow() + " --> row position");
			Assert.assertTrue(dropDownOptoins.size() == Constants.resultset.getRow());
			for (int i = 0; Constants.resultset.next(); i++) {
				Assert.assertTrue(Constants.resultset.getString(i).equalsIgnoreCase(dropDownOptoins.get(i).getText()));
			}
			Constants.test.log(Status.PASS, "verify contract numbers for individual");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "verify contract numbers for individual");
			Assert.fail("failed to verify contract numbers for individual");
		}
	}

	public static void selectPlanYear(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PlanYear').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Plan year");
			} else {
				EOBPage.planYear_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Plan year");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Plan year");
			Assert.fail("failed to select an option from plan year dropdown");
		}
	}

	public static void selectEOBCategory(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('GroupType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select EOB category");
			} else {
				System.out.println(option);
				EOBPage.category_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select EOB category");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select EOB category");
			Assert.fail("failed to select an option from EOB category dropdown");
		}
	}

	public static void selectContract(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('ContractNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select contract");
			} else {
				EOBPage.contract_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select contract");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select contract");
			Assert.fail("failed to select an option from contract dropdown");
		}
	}

	public static void selectPBP(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('PBPNumber').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select PBP");
			} else {
				EOBPage.PBP_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select PBP");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select PBP");
			Assert.fail("failed to select an option from PBP dropdown");
		}
	}

	public static void selectDrugCoverageType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('DrugCoverageType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Drug Coverage Type");
			} else {
				EOBPage.drugCoverageType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Drug Coverage Type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Drug Coverage Type");
			Assert.fail("failed to select an option from Drug Coverage Type dropdown");
		}
	}

	public static void selectClaimsSystem(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SourceSystem').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Claims System");
			} else {
				EOBPage.claimsSystem_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Claims System");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Claims System");
			Assert.fail("failed to select an option from Claims System dropdown");
		}
	}

	public static void selectBusinessSegment(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById('BusinessSegment').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Business Segment");
			} else {
				EOBPage.businessSegment_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Business Segment");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Business Segment");
			Assert.fail("failed to select an option from Business Segment dropdown");
		}
	}

	public static void selectEOBIndicator(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('EOBIndicator').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select EOB Indicator");
			} else {
				EOBPage.EOBindicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select EOB Indicator");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select EOB Indicator");
			Assert.fail("failed to select an option from EOB Indicator dropdown");
		}
	}

	public static void selectEOBLanguage(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('EOBLanguage').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select EOB Language");
			} else {
				EOBPage.language_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select EOB Language");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select EOB Language");
			Assert.fail("failed to select an option from EOB Language dropdown");
		}
	}

	public static void selectSNPType(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SNPType').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select SNP Type");
			} else {
				EOBPage.SNPType_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select SNP Type");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select SNP Type");
			Assert.fail("failed to select an option from SNP Type dropdown");
		}
	}

	public static void selectSiteName(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('SiteName').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select Site Name");
			} else {
				EOBPage.siteName_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select Site Name");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select Site Name");
			Assert.fail("failed to select an option from Site Name dropdown");
		}
	}

	public static void enterMasterGroupNumber(String mastergrpnum) {
		try {
			if (mastergrpnum.equalsIgnoreCase("null")) {
				EOBPage.master_group_number_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Master Group Number");
			} else {
				EOBPage.master_group_number_textField().sendKeys(mastergrpnum);
				Constants.test.log(Status.PASS, "enter Master Group Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Master Group Number");
			Assert.fail("failed to enter value in Master Group Number text field");
		}
	}

	public static void enterGroupNumber(String grpnum) {
		try {
			if (grpnum.equalsIgnoreCase("null")) {
				EOBPage.group_number_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Group Number");
			} else {
				EOBPage.group_number_textField().sendKeys(grpnum);
				Constants.test.log(Status.PASS, "enter Group Number");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Group Number");
			Assert.fail("failed to enter value in Group Number text field");
		}
	}

	public static void enterGroupEffectiveDate(String date) {
		try {
			if (date.equalsIgnoreCase("null")) {
				EOBPage.group_effective_date_textField().sendKeys("");
				Constants.test.log(Status.PASS, "enter Group Effective Date");
			} else {
				EOBPage.group_effective_date_textField().sendKeys(date);
				Constants.test.log(Status.PASS, "enter Group Effective Date");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "enter Group Effective Date");
			Assert.fail("failed to enter value in Group Effective Date text field");
		}
	}

	public static void clickOnSearchButton() {
		try {
			Utils.click(EOBPage.search_button());
			Constants.test.log(Status.PASS, "click on search plans button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search plans button");
			Assert.fail("failed to click on search plans button");
		}
	}

	public static void clickOnCreateEOBPlanRuleButton() {
		try {
			Utils.click(EOBPage.searchEOBGroupExceptions_button());
			Constants.test.log(Status.PASS, "click on search EOB Group Exceptions button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search EOB Group Exceptions button");
			Assert.fail("failed to click on search EOB Group Exceptions button");
		}
	}

	public static void clickOnsearchEOBGroupExceptionsButton() {
		try {
			Utils.click(EOBPage.searchEOBGroupExceptions_button());
			Constants.test.log(Status.PASS, "click on search EOB Group Exceptions button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on search EOB Group Exceptions button");
			Assert.fail("failed to click on search EOB Group Exceptions button");
		}
	}

	public static void select_checkboxEOBGroupException(String masterGroupNumber, String groupNumber,
			String effectiveDate, String siteName) {
		try {

			Utils.click(
					EOBPage.EOBGroupException_single_chkbox(masterGroupNumber, groupNumber, effectiveDate, siteName));
			Constants.test.log(Status.PASS, "selecting all checkbox for EOB Group Exception");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting all checkbox for EOB Group Exception");
			Assert.fail("failed to select checkbox for EOB Group Exception");
		}
	}

	public static void clickOnUpdateGrpException() {
		try {
			Utils.click(EOBPage.udpateGroupException_button());
			Constants.test.log(Status.PASS, "click on update Group Exception button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on update Group Exception button");
			Assert.fail("failed to click on update Group Exceptions button");
		}
	}

	public static void selectIsEOB(String option) {
		try {
			if (option.equalsIgnoreCase("null")) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('isEOB').selectedIndex=0;");
				Constants.test.log(Status.PASS, "select EOB category");
			} else {
				EOBPage.EOBindicator_dropdown().selectByVisibleText(option);
				Constants.test.log(Status.PASS, "select EOB category");
			}
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "select EOB category");
			Assert.fail("failed to select an option from EOB category dropdown");
		}
	}

	public static void select_ArabicCheckbox() {
		try {
			Utils.click(EOBPage.Arabic_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Arabic checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Arabic checkbox for EOB Language");
			Assert.fail("failed to select Arabic checkbox for EOB Language");
		}
	}

	public static void select_ChineseMandarinCheckbox() {
		try {
			Utils.click(EOBPage.Chinese_Mandarin_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Chinese Mandarin checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Chinese Mandarin checkbox for EOB Language");
			Assert.fail("failed to select Chinese Mandarin checkbox for EOB Language");
		}
	}

	public static void select_KoreanCheckbox() {
		try {
			Utils.click(EOBPage.Korean_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Korean checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Korean checkbox for EOB Language");
			Assert.fail("failed to select Korean checkbox for EOB Language");
		}
	}

	public static void select_SpanishCheckbox() {
		try {
			Utils.click(EOBPage.Spanish_Language_chkbox());
			Constants.test.log(Status.PASS, "selecting Spanish checkbox for EOB Language");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "selecting Spanish checkbox for EOB Language");
			Assert.fail("failed to select Spanish checkbox for EOB Language");
		}
	}

	public static void clickOnlanguageUpdateButton() {
		try {
			Utils.click(EOBPage.update_button());
			Constants.test.log(Status.PASS, "click on language Update button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on language Update button");
			Assert.fail("failed to click on language Update button");
		}
	}

	public static void clickOnCancel() {
		try {
			Utils.click(EOBPage.cancel_link());
			Constants.test.log(Status.PASS, "click on cancel button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on cancel button");
			Assert.fail("failed to click on cancels button");
		}
	}

	public static void clickOnClear() {
		try {
			Utils.click(EOBPage.clear_button());
			Constants.test.log(Status.PASS, "click on clear button");
		} catch (Exception e) {
			Constants.test.log(Status.FAIL, "click on clear button");
			Assert.fail("failed to click on clears button");
		}
	}

	public static String getTitle() {

		String page = driver.getTitle();
		System.out.println(page);
		return page;

	}
}
