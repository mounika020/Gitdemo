import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementOperations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTrainsgSOftware\\chromedriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
			driver.manage().window().maximize();
		driver.findElement(By.id("frontier_search_input")).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(By.id("frontier_search_input")).clear();
				driver.navigate().refresh();
				driver.findElement(By.xpath("//li/a[text()='Businesses']")).click();
		
	}

}
