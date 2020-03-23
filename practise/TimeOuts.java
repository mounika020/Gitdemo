import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOuts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.id("ctl00_TopNav_repeaterItems_ctl01_TopNavImage")).click();
				//driver.findElement(By.linkText("Businesses")).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//Thread.sleep(50000);
				new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Businesses")))).click();
				

	}

}
