package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class JobSubmission extends BaseClass {

	public JobSubmission(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	public static WebElement lnk_BatchIntake() {
		return driver.findElement(By.xpath("//*[@id='gsft_nav']/div/magellan-application-tree/ul/li[2]/a/span"));
	}
	
	public static WebElement lnk_BatchCatalog() {
		return driver.findElement(By.xpath("//a[@title='Catalog']/div[1]"));
	}
	
	public static WebElement lnk_EmployeeID() {
		return driver.findElement(By.xpath("//a[@title='Catalog']/div[1]"));
	}
	
	public static WebElement lnk_TWSServiceRequest() {
		return driver.findElement(By.xpath("//a[contains(text(),'TWS Self Service Request')]"));		
	}
	
	public static WebElement frame1() {
		return driver.findElement(By.xpath("//iframe[@id='gsft_main']"));		
	}
	
	public static WebElement frameMonitorJob() {
		return driver.findElement(By.name("isc_iframe"));		
	}
	
	public static WebElement frameMonitorTable() {
		return driver.findElement(By.name("(//iframe[@name='isc_iframe'])[last()]"));		
	}
	
	public static WebElement edit_ShortDescription() {
		return driver.findElement(By.xpath("//span[text()='Short description']/following::div[1]/input[2]"));
	}
	
	public static Select TWS_Envi_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='IO:a8ef10b513f97640cbee73076144b0ab']")));
	}
	
	public static Select Action_Type_dropdown() {
		return new Select(driver.findElement(By.xpath("//span[contains(text(),'Action Type')]/following::div[1]/select")));
	}
	
	public static Select Object_Type_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='IO:c15128b513f97640cbee73076144b054']")));
	}
	
	public static WebElement edit_Job_Family() {
		return driver.findElement(By.xpath("//*[@id='sys_display.IO:1822a8f513f97640cbee73076144b02f']"));
	}
	
	public static Select Action_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='IO:82d2603913f97640cbee73076144b0ed']")));
	}
	
	public static WebElement btn_Submit() {
		return driver.findElement(By.xpath("//*[@id='submit_button']"));
	}
	
	public static WebElement btn_Add_WorkStation() {
		return driver.findElement(By.xpath("//*[@id='ws_macro']"));
	}
	
	public static WebElement btn_Search_WorkStation() {
		return driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
	}
	
	public static Select WorkStation_dropdown() {
		return new Select(driver.findElement(By.xpath("//*[@id='slush_left']")));
	}
	
	public static WebElement btn_Select_WorkStation() {
		return driver.findElement(By.xpath("//*[@id='addRemoveButtons']/tbody/tr[2]/td/a/img"));
	}
	
	public static WebElement btn_OK_WorkStation() {
		return driver.findElement(By.xpath("//*[@id='ok_button']"));
	}
	
	public static WebElement btn_Add_Job() {
		return driver.findElement(By.xpath("//*[@id='ws_job']"));
	}
	
	public static WebElement btn_Search_Job() {
		return driver.findElement(By.xpath("//*[@id='body_x_opt_batch_schedu_batch_custom_slush']/rendered_body/table[1]/tbody/tr/td[2]/button"));
	}
	
	public static WebElement btn_Submit_Job() {
		return driver.findElement(By.xpath("//*[@id='submit_button']"));
	}
	
	public static WebElement lnk_Job_ID() {
		return driver.findElement(By.xpath("//a[contains(text(),'TSS')]"));
	}
	
	public static WebElement btn_Execute() {
		return driver.findElement(By.xpath("//*[@id='do_execute']"));
	}
	
	public static Select element_JobStatus() {
		return new Select(driver.findElement(By.xpath("//select[@id='sys_readonly.x_opt_batch_schedu_tws_self_service.state']")));
	}
	
	public static WebElement edit_UserID() {
		return driver.findElement(By.xpath("//*[@id='j_username']"));
	}
	
	public static WebElement edit_Password() {
		return driver.findElement(By.xpath("//*[@id='j_password']"));
	}
	
	public static WebElement btn_Go() {
		return driver.findElement(By.xpath("//*[@id='login-button']"));
	}
	
	public static WebElement btn_Monitor_Load() {
		return driver.findElement(By.xpath("//*[@id='monitor']/a"));
	}
	
	public static WebElement edit_Query() {
		return driver.findElement(By.xpath("//*[@id='query']"));
	}
	
	public static WebElement btn_Run() {
		return driver.findElement(By.xpath("//*[@id='run_label']"));
	}
	
	public static WebElement btn_CloseTab1() {
		return driver.findElement(By.xpath("//*[@id='com_ibm_isclite_dijit_Tab_1']/div/div[2]"));
	}
	
	public static WebElement edit_Filter() {
		return driver.findElement(By.xpath("//input[starts-with(@id, 'AjaxTable') and contains(@id,'filter')]"));
	}
	
	public static WebElement btn_Filter() {
		return driver.findElement(By.xpath("//img[starts-with(@id, 'AjaxTable') and contains(@id,'filter_button')]/img"));
	}
	
	public static WebElement btn_OkToEndSession() {
		return driver.findElement(By.xpath(".//*[@value='OK']"));
	}
	
	public static WebElement element_getStatus() {
		return driver.findElement(By.xpath("//table[starts-with(@id, 'AjaxTable') and contains(@id,'t1')]/tbody/tr[1]/td[2]/span"));
	}
		
	public static WebElement btn_Refresh() {
		return driver.findElement(By.xpath("//table[starts-with(@id, 'AjaxTable') and contains(@id,'toolbar')]/a[1]/img"));
	}	
	
	public static WebElement btn_Profile() {
		return driver.findElement(By.xpath("//span[@id='userButton']/span[1]"));
	}	
	
	public static WebElement btn_LogOut() {
		return driver.findElement(By.xpath("//*[@id='logout_nav_action']"));
	}	
}

	