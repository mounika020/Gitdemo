package miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;
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

import pageObjects.ComponentCodePage;
import utilities.Constants;
import utilities.Utils;

@SuppressWarnings("unused")

public class Excel_Compare_EGAncillaryPackage {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static LinkedHashMap<String, String> DBValue;
	public static LinkedHashMap<String, String> InputValue;
	public static LinkedHashMap<String, String> DBParameters;
	public static List<String> DBValues_List;
	public static List<String> InputValues_List;
	public static String PackageNumber;
	public static String NetworkType;
	FileOutputStream outputStream = null;
	Workbook outWorkbook = null;
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
	public static String packageNumber = RandomStringUtils.randomAlphanumeric(6);

	public LinkedHashMap<String, String> DB_data(String PackageNumber, String NetworkType)
			throws ClassNotFoundException, SQLException, IOException {

		// Using Constants.Input_SQLS reading MAPS_InfoBank queries sheet and
		// replacing parameters
		String QUERY = Constants.Input_SQLS.getRow(7).getCell(1).getStringCellValue()
				.replace("parameter1", PackageNumber).replace("parameter2", NetworkType);

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
	public void Input_data(String filePath, String outputFile, XSSFSheet sheet)
			throws ClassNotFoundException, SQLException, IOException {
		// Reading input file data

		XSSFSheet inSheet = sheet;
		// Output file
		outputStream = new FileOutputStream(outputFile);
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");
		for (int i = 0; i < 1000; i++) {
			row = outSheet.createRow(i);
		}
		int inRowCount = inSheet.getLastRowNum() - inSheet.getFirstRowNum();
		for (int i = 1; i <= inRowCount; i++) {
			InputValue = new LinkedHashMap<String, String>();
			System.out.println(i);
			for (int j = 0; j < inSheet.getRow(i).getLastCellNum(); j++) {
				System.out.println(i);
				System.out.println(j);
				try {
					PackageNumber = packageNumber;
					NetworkType = inSheet.getRow(i).getCell(3).getStringCellValue();
					InputValue.put(inSheet.getRow(0).getCell(j).getStringCellValue(),
							inSheet.getRow(i).getCell(j).getStringCellValue());
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
			InputValue.replace(inSheet.getRow(0).getCell(1).getStringCellValue(), packageNumber);

			InputValues_List = new ArrayList<String>(InputValue.values());
			DBValue = DB_data(PackageNumber, NetworkType);

			row = outSheet.getRow(0);
			Cell Heading1 = row.createCell(headingCount);
			Cell Heading2 = row.createCell(headingCount + 1);
			Cell Heading3 = row.createCell(headingCount + 2);
			Cell Heading4 = row.createCell(headingCount + 3);
			Cell Heading5 = row.createCell(headingCount + 4);
			Cell Heading6 = row.createCell(headingCount + 5);
			Heading1.setCellValue("Column Name");
			addBackgroundColor_Header(Heading1);
			Heading2.setCellValue("Input Value");
			addBackgroundColor_Header(Heading2);
			Heading3.setCellValue("DB Value");
			addBackgroundColor_Header(Heading3);
			Heading4.setCellValue("Compare");
			addBackgroundColor_Header(Heading4);
			Heading5.setCellValue("Pass/Fail");
			addBackgroundColor_Header(Heading5);
			Heading6.setCellValue("Comments");
			addBackgroundColor_Header(Heading6);

			Iterator in_Val_It = InputValue.entrySet().iterator();
			while (in_Val_It.hasNext()) {
				Entry ein = (Entry) in_Val_It.next();
				String Exl_Key = (String) ein.getKey().toString().replace(" ", "");
				String Exl_Val = (String) ein.getValue();
				row = outSheet.getRow(rowNum++);
				Cell columnName = row.createCell(cell_columnName);
				Cell inputValue = row.createCell(cell_inputValue);
				columnName.setCellValue(Exl_Key);
				inputValue.setCellValue(Exl_Val);
			}

			rowNum = 1;
			Iterator DB_Val_It = DBValue.entrySet().iterator();
			while (DB_Val_It.hasNext()) {
				row = outSheet.getRow(rowNum++);
				Entry ein = (Entry) DB_Val_It.next();
				String DB_Key = (String) ein.getKey().toString().replace(" ", "");
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

		if (DBValues_List.size() == InputValues_List.size()) {

			for (int i = 0; i < DBValues_List.size(); i++) {
				if (i > 0) {
					for (int j = 0; j <= InputValues_List.size(); j++) {
						row = outSheet.getRow(j);
						Cell gapColumn = row.createCell(commnetsColumn + 1);
						addBackgroundColor_gapColumn(gapColumn);
					}
				}
				try {
					if (InputValues_List.get(i).isEmpty() && DBValues_List.get(i) == null) {
						row = outSheet.getRow(i + 1);
						Cell compResutl = row.createCell(comapreColumn);
						compResutl.setCellValue("Pass");
					} else if (InputValues_List.get(i).isEmpty() || DBValues_List.get(i) == null) {
						if (InputValues_List.get(i).isEmpty() == true) {
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
						// In DB cost share and MaxAllowVisit values extract as
						// Money for comparison need to convert input values
						if (DBValues_List.get(i).toString().contains(".00")) {
							// Adding .0000 to input value in the List for excel
							// compare reporting purpose
							if (i == 4) {
								InputValues_List.set(i, InputValues_List.get(i).toString().concat(".0000"));
							}
							
							if (i == 5) {
								InputValues_List.set(i, InputValues_List.get(i).toString().concat(".00"));
							}

							if (i == 6) {
								InputValues_List.set(i, InputValues_List.get(i).toString().concat(".0000"));
							}
							
							if (i == 13) {
								InputValues_List.set(i, InputValues_List.get(i).toString().concat(".0000"));
							}
						}
						if (DBValues_List.get(i).toString().equalsIgnoreCase(InputValues_List.get(i).toString())) {
							row = outSheet.getRow(i + 1);
							Cell compResutl = row.createCell(comapreColumn);
							compResutl.setCellValue("Pass");
						} else {
							row = outSheet.getRow(i + 1);
							Cell compResutl = row.createCell(comapreColumn);
							compResutl.setCellValue("Fail");
							// row = outSheet.getRow(1);
							// Cell Resutl = row.createCell(passColumn);
							// Resutl.setCellValue("Fail");
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

	public static void generateCompareReport(String filePath, String outputFile, XSSFSheet sheet)
			throws ClassNotFoundException, SQLException, IOException {
		//System.out.println(packageNumber);
		String filepath = filePath;
		String outPutFile = outputFile;
		Excel_Compare_EGAncillaryPackage h = new Excel_Compare_EGAncillaryPackage();
		h.Input_data(filepath, outPutFile, sheet);
		h.autoSizeColumns();
		h.writeFile();
	}

}
