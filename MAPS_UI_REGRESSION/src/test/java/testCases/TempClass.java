package testCases;

import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import miscellaneous.BeforeAndAfter;
import utilities.Constants;
import utilities.QueryBank;
import utilities.Utils;

public class TempClass extends BeforeAndAfter {
	@Test
	public void lastFileModified()
			throws InterruptedException, ClassNotFoundException, SQLException, InvalidFormatException, IOException {
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery("");
		while (Constants.resultset.next()) {
			System.out.println(Constants.resultset.getString(1));
		}
	}

	XSSFWorkbook workbook1 = null;
	XSSFWorkbook workbook2 = null;

	@Test
	public void test1() throws IOException, ClassNotFoundException, SQLException {
		
	}
}
