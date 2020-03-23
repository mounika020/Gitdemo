package miscellaneous;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Utils;

public class Test {

	static WebDriver driver;

	public static void test() {
		driver = Utils.getDriver_IE();
		driver.get(
				"http://maps-test2.uhc.com/GroupRxData?groupNumber=88005&groupkeyid=0&sourceFileDetailFinalIid=0&contractYear=01%2F01%2F2018%2000%3A00%3A00");
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		List<WebElement> data = driver.findElements(By.xpath("//div/div/span[2]/descendant::*[1]"));
		List<WebElement> field = driver
				.findElements(By.xpath("//div/div/span[2]/descendant::*[1]/ancestor::div[1]/span[1]"));
		int i = 0;
		for (WebElement d : data) {
			System.err.println(i);
			if (d.getTagName().equalsIgnoreCase("input")) {
				map.put(field.get(i).getText(), d.getAttribute("value"));
			} else {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", d);
				map.put(field.get(i).getText(), new Select(d).getFirstSelectedOption().getText());
			}
			i++;
		}

		 for (Entry<String, String> m : map.entrySet()) {
		 System.out.println(m.getKey());
		 System.out.println(m.getValue());
		 }
	}

	public static void main(String[] args) {
		test();
	}

}
