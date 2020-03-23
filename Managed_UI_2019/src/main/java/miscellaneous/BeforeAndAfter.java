package miscellaneous;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utilities.Constants;

public class BeforeAndAfter {
	public static XSSFWorkbook TestData_Maintenance_Sheet;

//	public static void initiate_testDataMaintenanceSheet()
//			throws InvalidFormatException, IOException, ClassNotFoundException, SQLException {
//		TestData_Maintenance_Sheet = new XSSFWorkbook(new File("./TestData/IGE_TestData_Maintenance_Sheet.xlsx"));
//		Utils.connectToSqlserverDB();
//		for (int i = 0; i < TestData_Maintenance_Sheet.getNumberOfSheets(); i++) {
//			for (int j = 1; j <= TestData_Maintenance_Sheet.getSheetAt(i).getLastRowNum(); j++) {
//				try {
//					Constants.statement.executeUpdate(
//							TestData_Maintenance_Sheet.getSheetAt(i).getRow(j).getCell(2).getStringCellValue());
//				} catch (NullPointerException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

	@BeforeSuite
	public void beforeSuit() throws InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		Constants.startInfobank();
//		initiate_testDataMaintenanceSheet();
	}

	@AfterSuite
	public void afterSuit() {
	}

}
