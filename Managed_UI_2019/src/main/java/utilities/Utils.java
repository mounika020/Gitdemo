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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Utils {
	public static LinkedHashMap<String, String> DBvalues = new LinkedHashMap<String, String>();
	public static ArrayList<String> updated_results = new ArrayList<String>();

	public static Connection getConnection_sqlServer(String url, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

	public static WebDriver getDriver_FireFox(WebDriver driver) {
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

	public static WebDriver getDriver_Chrome(WebDriver driver, String ChromeDriverPath) {
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		return driver;
	}

	public static void change_dropdownStyle(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", element);
	}

	public static void click(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void takeScreenShot_Ashot(WebDriver driver, String outputFilePath, String filename)
			throws IOException, InterruptedException, AWTException {
	
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(outputFilePath + filename + ".png"));
	}

	public static void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();

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
	/*	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection Conn = DriverManager.getConnection("jdbc:sqlserver://10.178.61.241:1433;databaseName=DBSET1625;database=MAPS;integratedSecurity=true;");
		Constants.databaseConnection = DriverManager.getConnection(
				"jdbc:sqlserver://" + DBserverIP + ":1433;databaseName=" + DBserverName + ";database=" + database,
				userName, password);
		Constants.statement = Constants.databaseConnection.createStatement();*/
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Constants.databaseConnection = DriverManager.getConnection(
				"jdbc:sqlserver://" + DBserverIP + ":1433;databaseName=" + DBserverName + ";database=" + database +";integratedSecurity=true;");
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

	public static String convertDateFormat_mmddyyHHMMSAMPM_To_YYYYMMDDHHMMSS(String inputDate) {
		SimpleDateFormat date1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formatedDate = null;
		try {
			formatedDate = date.format(date1.parse(inputDate)).replaceAll("/", "-");
		} catch (ParseException p) {

		}
		return formatedDate;

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

	public static void insertScreenshotForthisStep(WebDriver driver, String stepName) {
		try {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			Utils.waitForPageToLoad(driver);
		
			Utils.takeScreenShot_Ashot(driver, Constants.currentDir + "/FailedScreenshots/" + timeStamp + "_",
					stepName);
			String screePath = Constants.currentDir + "/FailedScreenshots/" + timeStamp + "_" + stepName + ".png";
			Reporter.addScreenCaptureFromPath(screePath);
		} catch (NullPointerException e) {

		} catch (Exception e) {
			Assert.fail();
		}
	}

	public static void selectByVisibleText(WebElement element, String visibleText) {
		new Select(element).selectByVisibleText(visibleText);
	}

	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String visibleText) {
		new Select(element).selectByValue(visibleText);
	}
	
	public boolean isEnabledAndNotPrefilledTextBox(WebElement elem) {
		if(!elem.isEnabled()) 
			return false;
		else if(elem.getText()!="" || elem.getText()!=null) 
			return false;
		else		
			return true;
	}
	
	public boolean isEnabledAndNotPrefilledDropdown(WebElement elem,Select dropdown) {
		if(!elem.isEnabled()) 
			return false;
		else if(dropdown.getFirstSelectedOption().getText()!="" || dropdown.getFirstSelectedOption().getText()!=null) 
			return false;
		else		
			return true;
	}
	
	
	public static boolean compare_UI_With_DB_Results(ArrayList<String> updated_results) throws ClassNotFoundException, SQLException {
		boolean matchStatus=false;
		String QEREY = Constants.Input_SQLS.getRow(41).getCell(1).getStringCellValue();
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QEREY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		List<String> DBresultsList = new ArrayList<String>(DBvalues.values());
		for (int k = 0; Constants.resultset.next(); k++) {
			for (int j = 1; j <= Constants.resultsetMetadata.getColumnCount(); j++) {
				DBresultsList.add(Constants.resultset.getString(j).trim());
			}
		}
		System.out.println(DBresultsList);
		System.out.println(updated_results);
		Collections.sort(updated_results);
		Collections.sort(DBresultsList);
		
		if (updated_results.size() == DBresultsList.size()) {
			boolean flag = true;
			for (int i = 0; i < updated_results.size(); i++) {
				if (flag == true) {
					try {
						if (updated_results.get(i) == null && DBresultsList.get(i) == null) {
							matchStatus=true;
							Assert.assertTrue(true);
						} else if (updated_results.get(i) == null && DBresultsList.get(i) != null) {
							System.out.println("Fail-->compare UI values with DB values");
							Assert.fail();
							matchStatus=false;
							break;
						} else if (!(updated_results.get(i) == null) && DBresultsList.get(i) == null) {
							System.out.println("Fail-->compare UI values with DB values");
							Assert.fail();
							matchStatus=false;
							break;
						} else {
							if (updated_results.get(i).equalsIgnoreCase(DBresultsList.get(i)) == true) {
								flag = true;
								matchStatus=true;
							} else {
								flag = false;
								matchStatus=false;
							}
						}
					} catch (Exception e) {
						System.out.println("Fail-->compare UI values with DB values");
						Assert.fail("failed to to compare UI values with DB values");
						matchStatus=false;
						break;
					}
				} else {
					System.out.println("Fail-->compare UI values with DB values");
					Assert.fail();
					matchStatus=false;
					break;
				}
			}
			if (flag == true) {
				System.out.println("Pass-->compare UI values with DB values");
				matchStatus=true;
			}
		} else {
			System.out.println("Fail-->compare UI values with DB values");
			matchStatus=false;
			Assert.fail();
		}
		return matchStatus;
	}
	
}
