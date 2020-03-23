import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAutomation {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTrainsgSOftware\\chromedriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
		System.out.println(driver.findElement(By.className("headerWelcome")).getText());
		driver.findElement(By.xpath("//div/img[@alt='HRdirect']")).click();
		driver.findElement(By.linkText("AppStore")).click();
		

		

	}

}
