
package pageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class EOBPlanRule extends BaseClass{
		public EOBPlanRule(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		public static  WebElement Materials() {
			return driver.findElement(By.xpath(".//a[contains(text(),'Materials')]"));
		}
		public static WebElement EOB() {
			return driver.findElement(By.xpath(".//ul[@class='dropdown-menu']/li[2]/a[contains(text(),'EOB')]"));
}

		public static WebElement CreateNewEOBplanRule () {
			return driver.findElement(By.xpath(".//a[contains(text(),'Create New EOB Plan Rule')]"));
		}
		
		public static WebElement VerifyCreateNewEOBplanRule () {
			return driver.findElement(By.xpath("//h2[contains(text(),'Create New EOB Plan Rule')]"));
		}
		public static WebElement verify_planyear_parameter () {
			return driver.findElement(By.xpath("//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[1]/label"));
		}
	public static Select planyear_parameter() {
			return new Select(driver.findElement(By.xpath("//table[@id='eob-rule-search-criteria']/tbody/tr[1]/td[1]/label")));
}
	public static WebElement verify_Category_parameter() {
		return driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[1]/td[2]/label"));
}

public static WebElement verify_Contract_parameter() {
	return driver.findElement(By.xpath("//*[@id='eob-rule-search-criteria']/tbody/tr[1]/td[3]/label"));
}
	public static Select contract_dropdown() {//a[Contains(text(),'Create New EOB Plan Rule')]
		return new Select(driver.findElement(By.xpath(".//*[@id='ContractNumber']")));
}
	
	public static Select PBP_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='PBPNumber']")));
}
////select[@id='PlanYear']
	public static Select planyear() {
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
}
	public static Select Category() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
}
	public static  WebElement Search() {
		return driver.findElement(By.xpath("//input[@id='eob-search-plans']"));
	}
public static  WebElement verify_PBP_parameter() {
	return driver.findElement(By.xpath("//label[contains(text(),'PBP')]"));
}
public static  WebElement verify_DrugCoverageType_parameter() {
	return driver.findElement(By.xpath("//label[contains(text(),'Drug Coverage Type')]"));
}
public static  WebElement verify_ClaimsSystem_parameter() {
	return driver.findElement(By.xpath("//label[contains(text(),'Claims System')]"));
}
public static  WebElement verify_BusinessSegment_parameter() {
	return driver.findElement(By.xpath("//label[contains(text(),'Business Segment')]"));
}
public static  WebElement verify_SNPType_parameter() {
	return driver.findElement(By.xpath("//label[contains(text(),'SNP Type')]"));
}
public static Select Drugcoveragetype_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[1]/td[5]/label")));
	}
	public static Select Claimssystem_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[1]/td[6]/label")));
}
	public static Select Businesssegment_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[1]/td[7]/label")));
	}
	public static Select EOBIndicator_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[2]/td[1]/label")));
	}
	public static Select Language_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='eob-rule-search-criteria']/tbody/tr[2]/td[2]/label")));
	}
	public static WebElement searchPlans_button() {
		return driver.findElement(By.xpath(".//*[@id='search-button']"));
  }
	
	public static Select categorydropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='GroupType']")));
	}
	public static Select EOBdropdown() {
		return new Select(driver.findElement(By.xpath("//select[@id='IsEOB']")));
	}
	public static WebElement clickonSearch() {
		return driver.findElement(By.xpath("//input[@id='eob-search-plans']"));
	}
	public static WebElement SelectEmployerGrouprecord() {
	return driver.findElement(By.xpath("//table[@id='eob-rule-search-grid']/tbody/tr/td/input"));
}
	public static Select Contractdropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='ContractNumber']")));
}
	public static Select SelectPBP_dropdown() {
		return new Select(driver.findElement(By.xpath(".//*[@id='PBPNumber']")));
}

	public static WebElement Selectaleternateplan(String Contractnumber, String pbp) {
		return driver.findElement(By.xpath("//td[text()='"+Contractnumber+"']/following-sibling::td[text()='"+pbp+"']/parent::tr/td[1]/input"));
		}
	
	public static WebElement Spanish_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Spanish')]/input"));
	}

	public static WebElement Russian_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Russian')]/input"));
	}

	public static WebElement Vietnamese_Language_chkbox() {
		return driver.findElement(By.xpath("//label[contains(.,'Vietnamese')]/input"));

	}
	public static WebElement VerifyEOBPlanRuleList () {
		return driver.findElement(By.xpath("//h2[contains(text(),'EOB Plan Rule List')]"));
	}
public static WebElement VerifyPlanYear(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=2]"));
	
}
public static WebElement VerifyCategory(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=3]"));
	
}
public static WebElement VerifyContract(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=4]"));
	
}
public static WebElement VerifyPBP(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=5]"));
	
}
public static WebElement verifyDrugCoverageType(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=6]"));
	
}
public static WebElement verifySNPTypeType(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=7]"));
	
}
public static WebElement verifyclaimssystem(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=8]"));
}
public static WebElement verifyBusinessSegment(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=9]"));
	
}
public static WebElement verifyEOBIndicator(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=10]"));
	
}
public static WebElement verifyLanguages(){
	return driver.findElement(By.xpath("//td[text()='H5420']/following-sibling::td[text()='003']/parent::tr/td[position()=11]"));
	
}

	public static WebElement deleteplanrule() {
		return driver.findElement(By.xpath(".//*[@id='btnDelete']"));
	}
	public static WebElement Select_plan_chkbox() {
		return driver.findElement(By.xpath(".//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[1]"));
		
    }
	public static WebElement planyear_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=2]"));
		
	}
	public static WebElement Category_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=3]"));
		
	}
	public static WebElement Contract_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=4]"));
	}
	
	public static WebElement PBP_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=5]"));
		
	}
	
	public static WebElement DrugCoverageType_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=6]"));
	}
	public static WebElement SNPType_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=7]"));
	}
	
	public static WebElement ClaimsSystem_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=8]"));
		
	}
	
	public static WebElement BusinessSegment_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=9]"));
	}
	public static WebElement EOBIndicator_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=10]"));
	}
	
	public static WebElement Languages_text(){
		return driver.findElement(By.xpath("//*[@id='eob-rule-search-grid']/tbody/tr[1]/td[position()=11]"));
	}
public static WebElement clickonSave() {
	return driver.findElement(By.xpath(".//*[@id='create-rule-save']"));
}

	
}

// completeplanrule Xpaths - .//*[@id='eob-rule-search-grid']
// deleteplanrule xpath - .//*[@id='btnDelete']
	