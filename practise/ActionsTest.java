import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://frontier.uhg.com/Pages/Home.aspx");
				driver.manage().window().maximize();
				Actions action=new Actions(driver);
				
				action.moveToElement(driver.findElement(By.linkText("Businesses")));
				action.contextClick();
				action.sendKeys(Keys.ARROW_DOWN);
				action.sendKeys(Keys.ENTER);
				action.build().perform();
	}

}
