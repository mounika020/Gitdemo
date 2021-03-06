package miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.Constants;
import utilities.Utils;

@SuppressWarnings("unused")

public class Excel_Compare_Mapping_Configuration_SearchMapping extends BaseClass {

	public Excel_Compare_Mapping_Configuration_SearchMapping(WebDriver driver) {
		super(driver);
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	LinkedHashMap<String, String> DBValue = null;
	ArrayList<String> DBValues_List = null;
	public static LinkedHashMap<String, String> InputValue;
	public static LinkedHashMap<String, String> DBParameters;
	public static List<String> UIValues_List;
	public static LinkedHashMap<String, String> UI_results;
	public static String InstanceName;
	public static String SettingVersion;
	FileOutputStream outputStream = null;
	Workbook outWorkbook = null;
	Sheet inSheet;
	Sheet outSheet;
	int rowNum = 1;
	Row row = null;
	XSSFCellStyle backgroundStyle = null;
	XSSFFont font = null;
	int cell_columnName = 0;
	int cell_inputValue = 1;
	int cell_dbValue = 2;
	int comapreColumn = 3;
	int passColumn = 4;
	int commnetsColumn = 5;
	int headingCount = 0;
	int temp_passStatus = 0;

	public LinkedHashMap<String, String> DB_data(String InstanceName, String SettingVersion)
			throws ClassNotFoundException, SQLException, IOException {

		// Using Constants.Input_SQLS reading MAPS_InfoBank queries sheet and
		// replacing parameters
		String QUERY = Constants.Input_SQLS.getRow(2).getCell(1).getStringCellValue()
				.replace("parameter1", InstanceName).replace("parameter2", SettingVersion);

		// Connecting to MAPS DB
		Utils.connectToSqlserverDB();
		Constants.resultset = Constants.statement.executeQuery(QUERY);
		Constants.resultsetMetadata = Constants.resultset.getMetaData();
		DBValue = new LinkedHashMap<String, String>();

		// Storing Query results in Key, Value pairs in DBValue object
		for (int DBRecRow = 0; Constants.resultset.next(); DBRecRow++) {
			for (int DBRecCol = 0; DBRecCol < Constants.resultsetMetadata.getColumnCount(); DBRecCol++) {
				DBValue.put(Constants.resultsetMetadata.getColumnName(DBRecCol + 1),
						Constants.resultset.getString(DBRecCol + 1));
			}
		}

		// List created to store only DBValues
		DBValues_List = new ArrayList<String>(DBValue.values());
		// System.out.println("DB values Results: "+ DBValues_List.size());
		return DBValue;

	}

	@SuppressWarnings("resource")
	public void UI_data(String filePath, String outputFile) throws ClassNotFoundException, SQLException, IOException {

		// Reading input file data
		inSheet = Utils.excel_sheet(filePath, "SearchMapping");

		// Output file
		outputStream = new FileOutputStream(outputFile);
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");
		// for (int i = 1; i <=
		// driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr")).size();
		// i++) {
		//
		// }
		// // List for search result headings
		List<WebElement> columnsHeadingsInUI = driver
				.findElements(By.xpath(".//*[@id='grid']/thead/tr/th[position()>1 and position()<last()]"));

		// List created for search result values present in a row
		List<WebElement> columnsInUI = driver
				.findElements(By.xpath(".//*[@id='grid']/tbody/tr/td[position()>1 and position()<last()]"));

		// UI_results hash map object to store search result values in key value
		// pairs
		UI_results = new LinkedHashMap<String, String>();
		for (int i = 0; i < columnsInUI.size(); i++) {
			UI_results.put(columnsHeadingsInUI.get(i).getText().toString().trim(),
					columnsInUI.get(i).getText().toString());
			System.out.println(columnsInUI.size());
			System.out.println(UI_results);
		}

		// List created to store only UIValues
		UIValues_List = new ArrayList<String>(UI_results.values());

		System.out.println("UI values Results: " + UIValues_List.size());
		for (String s : UIValues_List) {
			System.out.println(s);
		}
		String date = Utils.convertDateFormat_mmddyyHHMMSAMPM_To_YYYYMMDDHHMMSS(UIValues_List.get(4));
		System.out.println(UIValues_List.get(4));
		System.out.println(date);
		UIValues_List.set(4, date);
		// To Create 1000 empty rows in output sheet
		for (int i = 0; i < 1000; i++) {
			row = outSheet.createRow(i);
		}

		// Assigning values to YEAR, GroupNumber from Input file
		InstanceName = inSheet.getRow(1).getCell(0).getStringCellValue();
		SettingVersion = inSheet.getRow(1).getCell(1).getStringCellValue();

		// Calling DB_data method
		DBValue = DB_data(InstanceName, SettingVersion);

		row = outSheet.getRow(0);
		Cell Heading1 = row.createCell(headingCount);
		Cell Heading2 = row.createCell(headingCount + 1);
		Cell Heading3 = row.createCell(headingCount + 2);
		Cell Heading4 = row.createCell(headingCount + 3);
		Cell Heading5 = row.createCell(headingCount + 4);
		Cell Heading6 = row.createCell(headingCount + 5);
		Heading1.setCellValue("Column Name");
		addBackgroundColor_Header(Heading1);
		Heading2.setCellValue("UI Value");
		addBackgroundColor_Header(Heading2);
		Heading3.setCellValue("DB Value");
		addBackgroundColor_Header(Heading3);
		Heading4.setCellValue("Compare");
		addBackgroundColor_Header(Heading4);
		Heading5.setCellValue("Pass/Fail");
		addBackgroundColor_Header(Heading5);
		Heading6.setCellValue("Comments");
		addBackgroundColor_Header(Heading6);

		// iterating Hash Map values
		Iterator UI_values = UI_results.entrySet().iterator();
		while (UI_values.hasNext()) {
			Entry ein = (Entry) UI_values.next();
			String Exl_Key = (String) ein.getKey().toString();
			String Exl_Val = (String) ein.getValue();
			row = outSheet.getRow(rowNum++);
			Cell columnName = row.createCell(cell_columnName);
			Cell inputValue = row.createCell(cell_inputValue);
			columnName.setCellValue(Exl_Key);
			inputValue.setCellValue(Exl_Val);
		}

		// iterating Hash Map values
		rowNum = 1;
		Iterator DB_Val_It = DBValue.entrySet().iterator();
		while (DB_Val_It.hasNext()) {
			row = outSheet.getRow(rowNum++);
			Entry ein = (Entry) DB_Val_It.next();
			String DB_Key = (String) ein.getKey().toString();
			String DB_Val = (String) ein.getValue();
			Cell DBValue = row.createCell(cell_dbValue);
			if (DB_Val == null) {
				DBValue.setCellValue("null");
			} else {
				DBValue.setCellValue(DB_Val);
			}
		}
		cell_columnName += 7;
		cell_inputValue += 7;
		cell_dbValue += 7;
		headingCount += 7;
		rowNum = 1;
		compareResult();
	}

	private char[] UIValues_List(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void autoSizeColumns() {
		int numberOfSheets = outWorkbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			Sheet sheet = outWorkbook.getSheetAt(i);
			if (sheet.getPhysicalNumberOfRows() > 0) {
				Row row = sheet.getRow(0);
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					sheet.autoSizeColumn(columnIndex);
				}
			}
		}
	}

	public void writeFile() throws IOException {
		outWorkbook.write(outputStream);
		outWorkbook.close();
	}

	public void compareResult() throws IOException {

		if (DBValues_List.size() == UIValues_List.size()) {

			for (int i = 0; i < DBValues_List.size(); i++) {
				if (i > 0) {
					for (int j = 0; j <= UIValues_List.size(); j++) {
						row = outSheet.getRow(j);
						Cell gapColumn = row.createCell(commnetsColumn + 1);
						addBackgroundColor_gapColumn(gapColumn);
					}
				}
				try {
					if (UIValues_List.get(i).isEmpty() && DBValues_List.get(i) == null) {
						row = outSheet.getRow(i + 1);
						Cell compResutl = row.createCell(comapreColumn);
						compResutl.setCellValue("Pass");
					} else if (UIValues_List.get(i).isEmpty() || DBValues_List.get(i) == null) {
						if (UIValues_List.get(i).isEmpty() == true) {
							row = outSheet.getRow(i + 1);
							Cell Comment = row.createCell(commnetsColumn);
							Comment.setCellValue("Input column value is empty but found value in Database");
						} else {
							row = outSheet.getRow(i + 1);
							Cell Comment = row.createCell(commnetsColumn);
							Comment.setCellValue("No matching column value found in Database");
						}
						row = outSheet.getRow(i + 1);
						Cell compResutl = row.createCell(comapreColumn);
						compResutl.setCellValue("Fail");
						temp_passStatus += 1;
					} else {
						if (DBValues_List.get(i).toString().equalsIgnoreCase(UIValues_List.get(i).toString())) {
							row = outSheet.getRow(i + 1);
							Cell compResutl = row.createCell(comapreColumn);
							compResutl.setCellValue("Pass");
						} else {
							row = outSheet.getRow(i + 1);
							Cell compResutl = row.createCell(comapreColumn);
							compResutl.setCellValue("Fail");
							temp_passStatus += 1;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e);
				}
			}
			if (temp_passStatus == 0) {
				Cell passStatus = outSheet.getRow(1).createCell(passColumn);
				passStatus.setCellValue("Pass");
				addBackgroundColor_Pass(passStatus);
			} else {
				Cell passStatus = outSheet.getRow(1).createCell(passColumn);
				passStatus.setCellValue("Fail");
				addBackgroundColor_Fail(passStatus);

			}
		} else {
			row = outSheet.getRow(1);
			Cell Pass = row.createCell(passColumn);
			Cell Comment = row.createCell(commnetsColumn);
			Pass.setCellValue("Fail");
			addBackgroundColor_Fail(Pass);
			temp_passStatus += 1;
			Comment.setCellValue("DB columns count and input file column count are not matching");
		}

		comapreColumn += 7;
		commnetsColumn += 7;
		passColumn += 7;
		temp_passStatus = 0;
	}

	public void addBackgroundColor_Pass(Cell object) {
		backgroundStyle = (XSSFCellStyle) outWorkbook.createCellStyle();
		font = (XSSFFont) outWorkbook.createFont();
		backgroundStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		backgroundStyle.setFont(font);
		object.setCellStyle(backgroundStyle);
	}

	public void addBackgroundColor_Fail(Cell object) {
		backgroundStyle = (XSSFCellStyle) outWorkbook.createCellStyle();
		font = (XSSFFont) outWorkbook.createFont();
		backgroundStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		backgroundStyle.setAlignment(CellStyle.ALIGN_CENTER);
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		backgroundStyle.setFont(font);
		object.setCellStyle(backgroundStyle);
	}

	public void addBackgroundColor_gapColumn(Cell object) {
		backgroundStyle = (XSSFCellStyle) outWorkbook.createCellStyle();
		backgroundStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		object.setCellStyle(backgroundStyle);
	}

	public void addBackgroundColor_Header(Cell object) {
		backgroundStyle = (XSSFCellStyle) outWorkbook.createCellStyle();
		font = (XSSFFont) outWorkbook.createFont();
		font.setBold(true);
		backgroundStyle.setFillForegroundColor(IndexedColors.TAN.getIndex());
		backgroundStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		backgroundStyle.setFont(font);
		object.setCellStyle(backgroundStyle);
	}

	public static void generateCompareReport(String filePath, String outputFile)
			throws ClassNotFoundException, SQLException, IOException {
		String filepath = filePath;
		String outPutFile = outputFile;
		Excel_Compare_Mapping_Configuration_SearchMapping h = new Excel_Compare_Mapping_Configuration_SearchMapping(
				driver);
		h.UI_data(filepath, outPutFile);
		h.autoSizeColumns();
		h.writeFile();
	}

}
