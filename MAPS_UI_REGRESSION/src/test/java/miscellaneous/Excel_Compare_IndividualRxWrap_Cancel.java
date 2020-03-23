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

public class Excel_Compare_IndividualRxWrap_Cancel extends BaseClass {

	public Excel_Compare_IndividualRxWrap_Cancel(WebDriver driver) {
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
	LinkedHashMap<String, String> InputValue = null;
	LinkedHashMap<String, String> DBParameters;
	LinkedHashMap<String, String> UI_results = null;
	List<String> UIValues_List;
	List<String> InputValues_List;
	public static String YEAR;
	public static String GroupNumber;
	FileOutputStream outputStream = null;
	Workbook outWorkbook = null;
	Sheet outSheet;
	int rowNum = 1;
	Row row = null;
	XSSFCellStyle backgroundStyle = null;
	XSSFFont font = null;
	int cell_columnName = 0;
	int cell_inputValue = 1;
	int cell_UIValue = 2;
	int cell_dbValue = 3;
	int comapreColumn = 4;
	int passColumn = 5;
	int commnetsColumn = 6;
	int headingCount = 0;
	int temp_passStatus = 0;

	public LinkedHashMap<String, String> DB_data(String Year, String GroupNumber)
			throws ClassNotFoundException, SQLException, IOException {

		// Using Constants.Input_SQLS reading MAPS_InfoBank queries sheet and
		// replacing parameters
		String QUERY = Constants.Input_SQLS.getRow(5).getCell(1).getStringCellValue().replace("parameter1", Year)
				.replace("parameter2", GroupNumber);

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
		FileInputStream input_Excel = new FileInputStream(new File(filePath));
		XSSFWorkbook input_Workbook = new XSSFWorkbook(input_Excel);
		XSSFSheet inSheet = input_Workbook.getSheet("Sheet1");

		// Iterating Input data
		InputValue = new LinkedHashMap<String, String>();
		int inRowCount = inSheet.getLastRowNum() - inSheet.getFirstRowNum();
		//System.out.println(inRowCount);
		//System.out.println(inSheet.getRow(1).getLastCellNum());
		for (int i = 1; i <= inRowCount; i++) {
			System.out.println(i);
			for (int j = 0; j < inSheet.getRow(i).getLastCellNum(); j++) {
				//System.out.println(i+" "+j);
				InputValue.put(inSheet.getRow(0).getCell(j).getStringCellValue(),
						inSheet.getRow(i).getCell(j).getStringCellValue());
				//System.out.println(InputValue.values());
			}

		}

		InputValues_List = new ArrayList<String>(InputValue.values());
		//System.out.println("input values Results: " + InputValues_List.size());
		// Output file
		outputStream = new FileOutputStream(outputFile);
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");

		// Iterating UI Search results
		// List created for search result values present in a row
		List<WebElement> columnsInUI = driver.findElements(By.xpath(".//*[@id='grid']/tbody/tr[1]/td"));

		// List for search result headings
		List<WebElement> columnsHeadingsInUI = driver.findElements(By.xpath(".//*[@id='grid']/thead/tr/th"));

		// UI_results hash map object to store search result values in key value
		// pairs
		UI_results = new LinkedHashMap<String, String>();
		for (int i = 0; i < columnsInUI.size() - 1; i++) {
			UI_results.put(columnsHeadingsInUI.get(i).getText().toString().trim(),
					columnsInUI.get(i).getText().toString());
		}

		// List created to store only DBValues
		UIValues_List = new ArrayList<String>(UI_results.values());
		// System.out.println("UI values Results: "+ UIValues_List.size());

		// To Create 1000 empty rows in output sheet
		for (int i = 0; i < 1000; i++) {
			row = outSheet.createRow(i);
		}

		// Assigning values to YEAR, GroupNumber from Input file
		YEAR = inSheet.getRow(1).getCell(0).getStringCellValue();
		GroupNumber = inSheet.getRow(1).getCell(1).getStringCellValue();

		// Calling DB_data method
		DBValue = DB_data(YEAR, GroupNumber);

		row = outSheet.getRow(0);
		Cell Heading1 = row.createCell(headingCount	);
		Cell Heading2 = row.createCell(headingCount + 1);
		Cell Heading3 = row.createCell(headingCount + 2);
		Cell Heading4 = row.createCell(headingCount + 3);
		Cell Heading5 = row.createCell(headingCount + 4);
		Cell Heading6 = row.createCell(headingCount + 5);
		Cell Heading7 = row.createCell(headingCount + 6);
		Heading1.setCellValue("Column Name");
		addBackgroundColor_Header(Heading1);
		Heading2.setCellValue("Input Value");
		addBackgroundColor_Header(Heading2);
		Heading3.setCellValue("UI Value");
		addBackgroundColor_Header(Heading3);
		Heading4.setCellValue("DB Value");
		addBackgroundColor_Header(Heading4);
		Heading5.setCellValue("Compare");
		addBackgroundColor_Header(Heading5);
		Heading6.setCellValue("Pass/Fail");
		addBackgroundColor_Header(Heading6);
		Heading7.setCellValue("Comments");
		addBackgroundColor_Header(Heading7);

		// iterating and writing UI values in output sheet
		Iterator UI_values = UI_results.entrySet().iterator();
		while (UI_values.hasNext()) {
			Entry ein = (Entry) UI_values.next();
			String UI_Key = (String) ein.getKey().toString();
			String UI_Val = (String) ein.getValue();
			row = outSheet.getRow(rowNum++);
			Cell columnName = row.createCell(cell_columnName);
			Cell UIValue = row.createCell(cell_UIValue);
			columnName.setCellValue(UI_Key);
			UIValue.setCellValue(UI_Val);
		}

		// iterating and writing Input values in output sheet
		rowNum = 1;
		Iterator input_values = InputValue.entrySet().iterator();
		while (input_values.hasNext()) {
			Entry ein = (Entry) input_values.next();
			String input_Key = (String) ein.getKey().toString();
			String input_Val = (String) ein.getValue();
			row = outSheet.getRow(rowNum++);
			Cell input_value = row.createCell(cell_inputValue);
			input_value.setCellValue(input_Val);
		}

		// iterating and writing DB values in output sheet
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
		cell_columnName += 8;
		cell_inputValue +=8;
		cell_UIValue += 8;
		cell_dbValue += 8;
		headingCount += 8;
		rowNum = 1;
		compareResult();
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

		comapreColumn += 8;
		commnetsColumn += 8;
		passColumn += 8;
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
		Excel_Compare_IndividualRxWrap_Cancel h = new Excel_Compare_IndividualRxWrap_Cancel(driver);
		h.UI_data(filepath, outPutFile);
		h.autoSizeColumns();
		h.writeFile();
	}

}
