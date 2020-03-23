import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new FirefoxDriver();
driver.get("http://www.javascriptkit.com/javatutors/alert2.shtml");
driver.manage().window().maximize();
driver.findElement(By.name("B2")).click();
Alert alert=driver.switchTo().alert();
String alertText=alert.getText();
System.out.println(alertText);
Thread.sleep(1000);
alert.accept();

	}

}
