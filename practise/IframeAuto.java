import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IframeAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
				driver.manage().window().maximize();
				//driver.switchTo().frame("vmFteIfrm"); 
				driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='WebPartWPQ11']/iframe")));
				driver.findElement(By.id("loc")).sendKeys("Hyderabad");
				driver.switchTo().defaultContent();
	}

}
