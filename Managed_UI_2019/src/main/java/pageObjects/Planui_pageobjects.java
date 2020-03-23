package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import miscellaneous.BaseClass;

public class Planui_pageobjects extends BaseClass {
		public Planui_pageobjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement Planedit_link()
	{
		return driver.findElement(By.xpath("//ul[@class='nav']/li[5]/ul/li[1]/a[text()='Plan Edit']"));
		
	}
	
	public static Select year_dropdown() 
	{
		return new Select(driver.findElement(By.xpath("//select[@id='PlanYear']")));
		
	}
	
	public static WebElement Searchplans() {
		return driver.findElement(By.xpath("//input[@id='SearchPlanButton']"));
		
	}
	public static WebElement checkbox_forSelectedPlan() {
		return driver.findElement(By.xpath("//*[@id='grid']/tbody/tr[1]/td[1]/input"));
	}
	
	public static WebElement click_ExportResults_button() {
		return driver.findElement(By.xpath("//input[@id='btnPlanUIExport']"));
	}
	public static WebElement click_DSNPPlanSetup_link() {
		return driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[2]/a[text()='DSNP Plan Setup']"));
		
	}
	public static WebElement verify_DSNPSearch_screen() {
		return driver.findElement(By.xpath("//div[@class='container-fluid']/h1"));
		
	}
	public static WebElement click_DSNPexportresults() {
		return driver.findElement(By.xpath("//*[@id='btnDSNPPlanUIExport']"));
		
	}
	
	}
	

