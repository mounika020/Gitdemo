package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import miscellaneous.BaseClass;

public class Constants {
	public static String USER_NAME = "";
	public static String PASSWORD = "";

	public static String INDIVIDUAL_FILEPATH = "./src/test/java/testData/Individual.xlsx";
	public static String INDIVIDUAL_FILEPATH_INSERT = "./src/test/java/testData/TC_IND_Insert_Chart_ANOC.xlsx";
	public static String INDIVIDUAL_FILEPATH_UPDATE = "./src/test/java/testData/TC_IND_Update_Chart_ANOC.xlsx";
	public static String INDIVIDUAL_FILEPATH_DELETE = "./src/test/java/testData/TC_IND_Delete_Chart_ANOC.xlsx";
	public static String MAPS_INFOBANK_FILEPATH = "./src/test/java/testData/MAPS_INFOBANK.xlsm";
	public static String RESULT_FILEPATH = "./Output/CompareTask.xlsx";

	public static Connection databaseConnection;
	public static Statement statement;
	public static ResultSet resultset;
	public static ResultSet resultset1;
	public static ResultSet resultset2;
	public static ResultSetMetaData resultsetMetadata1;
	public static ResultSetMetaData resultsetMetadata2;
	public static ResultSetMetaData resultsetMetadata;
	public static CallableStatement callableStatement;
	public static PreparedStatement preparedstatement;

	public static XSSFWorkbook workbook;
	public static XSSFWorkbook MAPS_Infobank;
	public static XSSFSheet Environments;
	public static XSSFSheet Input_SQLS;
	public static XSSFSheet TestCases;

	public static String DATABASE_URL_SQL_TEST3 = "jdbc:sqlserver://10.178.61.241:1433;databaseName=DBSET1625;database=MAPS";
	public static String DATABASE_USERNAME_SQL_TEST3 = "maps_read";
	public static String DATABASE_PASSWORD_SQL_TEST3 = "z4qasputHu";
//http://maps-test2.uhc.com/
	public static String MAPS_UI_URL = "https://maps-test.uhc.com/DSNP";
	//public static String MAPS_UI_URL = "http://maps-test.uhc.com/";
	//maps-test2.uhc.com/ComponentCode
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public static Path currentRelativePath = Paths.get("");
	public static String currentDir = currentRelativePath.toAbsolutePath().normalize().toString();
	public static ExtentReports extent;
	public static ExtentTest test;
	static ExtentHtmlReporter htmlReporter;
	public static final String ReportsPath = currentDir + "\\Reports\\";

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
	}

}
