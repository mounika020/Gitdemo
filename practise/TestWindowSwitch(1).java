import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWindowSwitch {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
				driver.manage().window().maximize();
				driver.findElement(By.id("ctl00_TopNav_repeaterItems_ctl01_TopNavImage")).click();
				String parentWin=driver.getWindowHandle();
				Set<String> setOfWIDs=driver.getWindowHandles();
				
				
				
				for(String wID:setOfWIDs)
			{
			
					driver.switchTo().window(wID);
					String pageTitle=driver.getTitle();
					if(pageTitle.equals("Login | ONE connect"))
					{
						driver.findElement(By.id("username01")).sendKeys("Test");
					}
						
				}
					Thread.sleep(2000);
				driver.switchTo().window(parentWin);
				driver.findElement(By.linkText("Businesses")).click();
				driver.quit();
				

	}
	}

