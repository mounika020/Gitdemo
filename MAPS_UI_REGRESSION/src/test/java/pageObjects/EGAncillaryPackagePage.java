package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class EGAncillaryPackagePage extends BaseClass {

	public EGAncillaryPackagePage(WebDriver driver) {
		super(driver);
	}

	public static Select packageType_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='PackageTypeId']")));
	}

	public static WebElement createNewPackage_button() {
		return driver.findElement(By.xpath("//a[contains(text(), '   Create new package')]"));
	}

	public static WebElement packageNumber_textField() {
		return driver.findElement(By.xpath(".//input[@id='PackageNumber']"));
	}

	public static WebElement next_button() {
		return driver.findElement(By.xpath("//input[@value ='Next']"));
	}

	public static WebElement cancel_link() {
		return driver.findElement(By.linkText("//input[@value ='Next']/following-sibling::a"));
	}

	public static Select benefitOption_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='ChiroExamBenType']")));
	}

	public static Select benefitOption_dropdown_18a1() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingExamBenType']")));
	}

	public static Select benefitOption_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingHardwareBenType']")));
	}

	public static Select outOfNetwork_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@name='ChiroExamNetwork2']")));
	}

	public static Select outOfNetwork_dropdown_18a1() {
		return new Select(driver.findElement(By.xpath(".//select[@name='HearingExamNetwork2']")));
	}

	public static Select outOfNetwork_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath(".//select[@name='HearingHardwareNetwork2']")));
	}

	public static WebElement inNetworkCopay_radioButton() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[1]"));
	}

	public static WebElement inNetworkCopay_radioButton_18a1() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[1]"));
	}

	public static WebElement inNetworkCopay_radioButton_18a4() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[3]"));
	}

	public static WebElement inNetworkCoins_radioButton() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[1]"));
	}

	public static WebElement inNetworkCoins_radioButton_18a1() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[1]"));
	}

	public static WebElement inNetworkCoins_radioButton_18a4() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[3]"));
	}

	public static WebElement outOfNetworkCopay_radioButton() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[2]"));
	}

	public static WebElement outOfNetworkCopay_radioButton_18a1() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[2]"));
	}

	public static WebElement outOfNetworkCopay_radioButton_18a4() {
		return driver.findElement(By.xpath("(//input[@value = 'copay'])[4]"));
	}

	public static WebElement outOfNetworkCoins_radioButton() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[2]"));
	}

	public static WebElement outOfNetworkCoins_radioButton_18a1() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[2]"));
	}

	public static WebElement outOfNetworkCoins_radioButton_18a4() {
		return driver.findElement(By.xpath("(//input[@value = 'coinsurance'])[4]"));
	}

	public static WebElement inNetwork_costShare_textField() {
		return driver.findElement(By.xpath(".//input[@id='ChiroExamCostshare1']"));
	}

	public static WebElement inNetwork_costShare_textField_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamCostshare1']"));
	}

	public static WebElement inNetwork_costShare_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name='HearingHardwareCostshare1']"));
	}

	public static WebElement outOfNetwork_costShare_textField() {
		return driver.findElement(By.xpath(".//input[@id='ChiroExamCostshare2']"));
	}

	public static WebElement outOfNetwork_costShare_textField_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamCostshare2']"));
	}

	public static WebElement outOfNetwork_costShare_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name='HearingHardwareCostshare2']"));
	}

	public static WebElement inNetwork_maxAllowPerVisit_textField() {
		return driver.findElement(By.xpath(".//input[@name='ChiroExamMaxAllowPerVisit1']"));
	}

	public static WebElement inNetwork_maxAllowPerVisit_textField_18a1() {
		return driver.findElement(By.xpath(".//input[@name='HearingExamMaxAllowPerVisit1']"));
	}

	public static WebElement inNetwork_maxBenAllow_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name='HearingHardwareMaxAllowPerVisit1']"));
	}

	public static WebElement outOfNetwork_maxAllowPerVisit_textField() {
		return driver.findElement(By.xpath(".//input[@name='ChiroExamMaxAllowPerVisit2']"));
	}

	public static WebElement outOfNetwork_maxAllowPerVisit_textField_18a1() {
		return driver.findElement(By.xpath(".//input[@name='HearingExamMaxAllowPerVisit2']"));
	}

	public static WebElement outOfNetwork_maxBenAllow_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name='HearingHardwareMaxAllowPerVisit2']"));
	}

	public static WebElement inNetwork_visits_textField() {
		return driver.findElement(By.xpath("(//input[@class='unlimitable'])[1]"));
	}

	public static WebElement inNetwork_visits_textField_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamNumberOfVisits1']"));
	}

	public static WebElement inNetwork_devices_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name = 'HearingHardwareNumberOfVisits1']"));
	}

	public static WebElement outOfNetwork_visits_textField() {
		return driver.findElement(By.xpath("(//input[@class='unlimitable'])[2]"));
	}

	public static WebElement outOfNetwork_visits_textField_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamNumberOfVisits2']"));
	}

	public static WebElement outOfNetwork_devices_textField_18a4() {
		return driver.findElement(By.xpath("//input[@name = 'HearingHardwareNumberOfVisits2']"));
	}

	public static Select inNetwork_ear_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath("//select[@name = 'HearingHardwarePerEarOrCombined1']")));
	}

	public static Select outOfNetwork_ear_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath("//select[@name = 'HearingHardwarePerEarOrCombined2']")));
	}

	public static WebElement inNetwork_visits_checkBox() {
		return driver.findElement(By.xpath("(//input[@class='unlimited'])[1]"));
	}

	public static WebElement inNetwork_visits_checkBox_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamNumberOfVisitsUnlimited1']"));
	}

	public static WebElement inNetwork_devices_checkBox_18a4() {
		return driver.findElement(By.xpath("//input[@name = 'HearingHardwareNumberOfVisitsUnlimited1']"));
	}

	public static WebElement outOfNetwork_visits_checkBox() {
		return driver.findElement(By.xpath("(//input[@class='unlimited'])[2]"));
	}

	public static WebElement outOfNetwork_visits_checkBox_18a1() {
		return driver.findElement(By.xpath("//input[@name = 'HearingExamNumberOfVisitsUnlimited2']"));
	}

	public static WebElement outOfNetwork_devices_checkBox_18a4() {
		return driver.findElement(By.xpath("//input[@name = 'HearingHardwareNumberOfVisitsUnlimited2']"));
	}

	public static Select inNetwork_periodicity_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='ChiroExamPeriodicity1']")));
	}

	public static Select inNetwork_periodicity_dropdown_18a1() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingExamPeriodicity1']")));
	}

	public static Select inNetwork_periodicity_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingHardwarePeriodicity1']")));
	}

	public static Select outOfNetwork_periodicity_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@id='ChiroExamPeriodicity2']")));
	}

	public static Select outOfNetwork_periodicity_dropdown_18a1() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingExamPeriodicity2']")));
	}

	public static Select outOfNetwork_periodicity_dropdown_18a4() {
		return new Select(driver.findElement(By.xpath(".//select[@id='HearingHardwarePeriodicity2']")));
	}

	public static WebElement inNetwork_vendor_textField() {
		return driver.findElement(By.xpath(".//input[@name='ChiroExamVendor1']"));
	}

	public static WebElement inNetwork_vendor_textField_18a1() {
		return driver.findElement(By.xpath(".//input[@name='HearingExamVendor1']"));
	}

	public static WebElement inNetwork_vendor_textField_18a4() {
		return driver.findElement(By.xpath(".//input[@name='HearingHardwareVendor1']"));
	}

	public static WebElement inNetwork_additionalVendor_textField() {
		return driver.findElement(By.xpath(".//input[@name='ChiroExamAdditionalVendor1']"));
	}

	public static WebElement inNetwork_additionalVendor_textField_18a1() {
		return driver.findElement(By.xpath(".//input[@name='HearingExamAdditionalVendor1']"));
	}

	public static WebElement inNetwork_additionalVendor_textField_18a4() {
		return driver.findElement(By.xpath(".//input[@name='HearingHardwareAdditionalVendor1']"));
	}

	public static Select inNetwork_chiroAndAcupunctureCombined_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@name='IsCombinedWithAccupuncture1']")));
	}

	public static Select outOfNetwork_chiroAndAcupunctureCombined_dropdown() {
		return new Select(driver.findElement(By.xpath(".//select[@name='IsCombinedWithAccupuncture2']")));
	}

	public static WebElement create_button() {
		return driver.findElement(By.xpath(".//input[@value='Create']"));
	}

	public static WebElement createNewPackage_cancel_button() {
		return driver.findElement(By.xpath(".//input[@value='Create']/following-sibling::a"));
	}

}
