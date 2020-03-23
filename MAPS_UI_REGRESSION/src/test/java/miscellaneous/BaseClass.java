package miscellaneous;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class BaseClass {

	public static WebDriver driver;
	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
	}


}
