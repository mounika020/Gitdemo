package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import miscellaneous.BaseClass;

public class ManagedPlanArea_pageObjects extends BaseClass {
	public ManagedPlanArea_pageObjects(WebDriver driver) {
		super(driver);
	}
	
	 public static WebElement ManagedPlanArea_label(){
		 	return driver.findElement(By.xpath("//a[contains(text(),'Managed Plan Area')]"));
	    }
	 
	 public static WebElement AddState_button() {
		 	return driver.findElement(By.xpath("//input[@id='MasterGroupNumber']"));
	 	}
	 
	 public static WebElement Create_button() {
		 	return driver.findElement(By.xpath("//input[contains(text(),'Create')]"));
	 	}	 
		
	 public static Select selectState_dropdown() {
			return new Select(driver.findElement(By.xpath("//select[@id='state']")));
		}
		 
	 public static Select selectCounty_dropdown() {
			return new Select(driver.findElement(By.xpath("//select[@id='county']")));
		}
}