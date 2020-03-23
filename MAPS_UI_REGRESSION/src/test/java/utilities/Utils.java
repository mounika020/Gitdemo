package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.Status;

import miscellaneous.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Utils extends BaseClass {

	public Utils(WebDriver driver) throws InvalidFormatException, IOException {
		super(driver);
	}

	// static WebDriverWait wait = new WebDriverWait(driver, 30000);

	public static Connection getConnection_sqlServer(String url, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

	public static WebDriver getDriver_FireFox() {
		System.setProperty("webdriver.gecko.driver", "./Lib/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver getDriver_IE() {
		System.setProperty("webdriver.ie.driver", "./Lib/IEDriverServer.exe");
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability("ignoreZoomSetting", true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, false);
		WebDriver driver = new InternetExplorerDriver(cap);
		return driver;
	}

	public static WebDriver getDriver_Chrome(String ChromeDriverPath) {
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		return driver;
	}

	public static void change_dropdownStyle(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", element);
	}

	public static void click(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void takeScreenShot_Ashot(String outputFilePath, String filename) throws IOException {
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(outputFilePath + filename + ".png"));
	}

	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();

	}

	public static String TestCasesSelector() throws InvalidFormatException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(new File(""));
		XSSFSheet sheet = workbook.getSheet("sheet1");

		String choice;
		choice = sheet.getRow(1).getCell(1).getStringCellValue();
		return choice;
	}

	public static void createFolderWithCurrenctTimestamp(String path) {
		(new File("./Excel_Comparision_Report/" + Constants.timeStamp)).mkdirs();
	}

	public static void connectToSqlserverDB() throws SQLException, ClassNotFoundException {
		String getEnvironment = Constants.Environments.getRow(1).getCell(0).getStringCellValue();
		String DBserverName = null;
		String DBserverIP = null;
		String database = null;
		String userName = null;
		String password = null;
		for (int i = 1; i <= Constants.Environments.getLastRowNum(); i++) {
			if (Constants.Environments.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(getEnvironment)) {
				DBserverName = Constants.Environments.getRow(i).getCell(3).getStringCellValue();
				DBserverIP = Constants.Environments.getRow(i).getCell(4).getStringCellValue();
				database = Constants.Environments.getRow(i).getCell(5).getStringCellValue();
				userName = Constants.Environments.getRow(i).getCell(6).getStringCellValue();
				password = Constants.Environments.getRow(i).getCell(7).getStringCellValue();

			}
		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Constants.databaseConnection = DriverManager.getConnection("jdbc:sqlserver://" + DBserverIP
//				+ ":1433;databaseName=" + DBserverName + ";database=" + database + ";integratedSecurity=true;");

		Constants.databaseConnection = DriverManager.getConnection(
				"jdbc:sqlserver://" + DBserverIP + ":1433;databaseName=" + DBserverName + ";database=" + database,
				userName, password);

		Constants.statement = Constants.databaseConnection.createStatement();
	}

	public static String convertDateFormat(String inputDate) {
		SimpleDateFormat date1 = new SimpleDateFormat("MM/DD/yyyy");
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/DD");
		String formatedDate = null;
		try {
			formatedDate = date.format(date1.parse(inputDate)).replaceAll("/", "-") + " 00:00:00.0";
		} catch (ParseException p) {

		}
		return formatedDate;

	}

	public static String convertDateFormat_yyyymmdd(String inputDate) {
		String inDate = inputDate.replaceAll("-", "/");
		SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		String formatedDate = null;
		try {
			formatedDate = date.format(date1.parse(inDate)).replaceAll("/", "-");
		} catch (ParseException p) {

		}
		return formatedDate;

	}

	public static String getTestCasePreferenceFromInfobank(String testCaseName) {
		String preference = null;
		for (int i = 1; i <= Constants.TestCases.getLastRowNum(); i++) {
			if (Constants.TestCases.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(testCaseName)) {
				preference = Constants.TestCases.getRow(i).getCell(0).getStringCellValue();
			}
		}
		return preference;
	}

	public static XSSFSheet excel_sheet(String FilePath, String SheetName) {
		XSSFSheet sheet = null;
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new File(FilePath));
			sheet = workbook.getSheet(SheetName);
		} catch (Exception e) {
			System.out.println("excel read operation has failed");
		}
		return sheet;
	}

	public static void waitForPageToLoad(WebDriver driver) {
		try {
			for (int i = 0; i <= i; i++) {
				if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
					break;
				}
			}
		} catch (JavascriptException e) {
		}
	}

	public static void refreshPage() {
		driver.get(driver.getCurrentUrl());
	}

	public static void pressEnter() {
		try {
			// wait.until(ExpectedConditions.alertIsPresent());
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			Constants.test.log(Status.FAIL, "Failed to press enter in keyboard");
		}
	}

	public static void waitForPageToLoad() {
		for (int i = 0; i <= i; i++) {
			if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
				break;
			}
		}
	}
	
	public static WebDriver getDriver_phantoJSdriver() {
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setJavascriptEnabled(true);                
//		caps.setCapability("takesScreenshot", true);  
//		caps.setCapability(
//		                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//		                        "./Lib/phantomjs.exe"
//		                    );
		System.setProperty("phantomjs.binary.path", "./Lib/phantomjs.exe");
		driver = new PhantomJSDriver();
		return driver;
	}

}
