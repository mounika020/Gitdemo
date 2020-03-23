package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Constants {
	public static String MAPS_INFOBANK_FILEPATH = "./TestData/MAPS_INFOBANK.xlsm";
	public static String RESULT_FILEPATH = "./Output/CompareTask.xlsx";

	public static Connection databaseConnection;
	public static Statement statement;
	public static ResultSet resultset;
	public static ResultSetMetaData resultsetMetadata;
	
	public static Connection databaseConnection1;
	public static Statement statement1;
	public static ResultSet resultset1;
	public static ResultSetMetaData resultsetMetadata1;

	public static XSSFWorkbook workbook;
	public static XSSFWorkbook MAPS_Infobank;
	public static XSSFSheet Environments;
	public static XSSFSheet Input_SQLS;
	public static XSSFSheet TestCases;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String MAPS_UI_URL;
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public static Path currentRelativePath = Paths.get("");
	static ExtentHtmlReporter htmlReporter;
	public static String currentDir = currentRelativePath.toAbsolutePath().normalize().toString();
	public static final String ReportsPath = currentDir + "\\output\\";

	public static void startReport() throws Exception {

		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(ReportsPath + "HTML_Report_" + timeStamp + ".html");

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Platform", "Windows 7");
		extent.setSystemInfo("Host Name", "");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "QA");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("UnitedHealth Group");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName("MAPS UI Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public static void startInfobank() throws InvalidFormatException, IOException {
		MAPS_Infobank = new XSSFWorkbook(new File(Constants.MAPS_INFOBANK_FILEPATH));
		Environments = MAPS_Infobank.getSheet("Environments");
		Input_SQLS = MAPS_Infobank.getSheet("Input_SQLS");
		TestCases = MAPS_Infobank.getSheet("TestCases");
		String getEnvironment = Constants.Environments.getRow(1).getCell(0).getStringCellValue();
		for (int i = 1; i <= Constants.Environments.getLastRowNum(); i++) {
			if (Constants.Environments.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(getEnvironment)) {
				MAPS_UI_URL = Constants.Environments.getRow(i).getCell(2).getStringCellValue();
			}
		}
	}

}
