import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWindowSwitch {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
				driver.manage().window().maximize();
				driver.findElement(By.id("ctl00_TopNav_repeaterItems_ctl01_TopNavImage")).click();
				String parentWin=driver.getWindowHandle();
				Set<String> setOfWIDs=driver.getWindowHandles();
				int count=1;
				
				
				for(String wID:setOfWIDs)
			{
					//String pageTitle=driver.
					if(count==2)
					{
						driver.switchTo().window(wID);
						driver.findElement(By.id("username01")).sendKeys("Test");
					}
					++count;	
				}
				
				driver.switchTo().window(parentWin);
				driver.findElement(By.id("ctl00_TopNav_repeaterItems_ctl01_TopNavImage")).click();
				

	}

}
