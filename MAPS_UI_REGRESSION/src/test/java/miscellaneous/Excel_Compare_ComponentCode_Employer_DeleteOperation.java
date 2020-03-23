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

import utilities.Constants;

public class Excel_Compare_ComponentCode_Employer_DeleteOperation {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	String userName = "maps_read";
	String password = "z4qasputHu";
	String url = "jdbc:sqlserver://10.178.61.241:1433;databaseName=DBSET1625;database=MAPS";
	public static LinkedHashMap<String, String> DBValue;
	public static LinkedHashMap<String, String> InputValue;
	public static LinkedHashMap<String, String> DBParameters;
	public static List<String> DBValues_List;
	public static List<String> InputValues_List;
	public static String RecordType;
	public static String GroupNumber;
	public static String MasterGroupNumber;
	public static String ContractNumber;
	public static String PBPNumber;
	public static String Division;
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

	public LinkedHashMap<String, String> DB_data(String filePath, String RecordType, String GroupNumber,
			String MasterGroupNumber, String ContractNumber, String PBPNumber, String Division)
			throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement statement = con.createStatement();
		// Reading MAPS_INFOBANK excel file
		File file = new File((String) filePath);
		FileInputStream query_Excel = new FileInputStream(file);
		XSSFWorkbook queryworkbook = new XSSFWorkbook(query_Excel);
		XSSFSheet SQL_Sheet = queryworkbook.getSheet("Input_SQLS");
		int queryRowCount = SQL_Sheet.getLastRowNum() - SQL_Sheet.getFirstRowNum();
		// Reading Input file
		String verSQLQuery = SQL_Sheet.getRow(2).getCell(1).getStringCellValue();
		verSQLQuery = verSQLQuery.replace("parameter1", RecordType);
		verSQLQuery = verSQLQuery.replace("parameter2", GroupNumber);
		verSQLQuery = verSQLQuery.replace("parameter3", MasterGroupNumber);
		verSQLQuery = verSQLQuery.replace("parameter4", ContractNumber);
		verSQLQuery = verSQLQuery.replace("parameter5", PBPNumber);
		verSQLQuery = verSQLQuery.replace("parameter6", Division);
		ResultSet recoSet = statement.executeQuery(verSQLQuery);
		ResultSetMetaData metadata = recoSet.getMetaData();
		DBValue = new LinkedHashMap<String, String>();
		for (int DBRecRow = 0; recoSet.next(); DBRecRow++) {
			for (int DBRecCol = 0; DBRecCol < metadata.getColumnCount(); DBRecCol++) {
				DBValue.put(metadata.getColumnName(DBRecCol + 1), recoSet.getString(DBRecCol + 1));
			}
		}
		DBValues_List = new ArrayList<String>(DBValue.values());
		return DBValue;

	}

	@SuppressWarnings("resource")
	public void Input_data(String filePath, String outputFile)
			throws ClassNotFoundException, SQLException, IOException {
		Workbook inWorkbook = null;
		String fileName = filePath;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		FileInputStream input_Excel = new FileInputStream(fileName);
		inWorkbook = new XSSFWorkbook(input_Excel);
		Sheet inSheet = inWorkbook.getSheet("Sheet1");
		outputStream = new FileOutputStream(outputFile);
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");
		for (int i = 0; i < 1000; i++) {
			row = outSheet.createRow(i);
		}
		int inRowCount = inSheet.getLastRowNum() - inSheet.getFirstRowNum();
		for (int i = 1; i <= inRowCount; i++) {
			InputValue = new LinkedHashMap<String, String>();
			for (int j = 1; j < inSheet.getRow(i).getLastCellNum(); j++) {

				try {
					RecordType = inSheet.getRow(i).getCell(1).getStringCellValue();
					GroupNumber = inSheet.getRow(i).getCell(2).getStringCellValue();
					MasterGroupNumber = inSheet.getRow(i).getCell(3).getStringCellValue();
					ContractNumber = inSheet.getRow(i).getCell(4).getStringCellValue();
					PBPNumber = inSheet.getRow(i).getCell(5).getStringCellValue();
					Division = inSheet.getRow(i).getCell(6).getStringCellValue();
					InputValue.put(inSheet.getRow(0).getCell(j).getStringCellValue(),
							inSheet.getRow(i).getCell(j).getStringCellValue());
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
			InputValues_List = new ArrayList<String>(InputValue.values());
			DBValue = DB_data(Constants.MAPS_INFOBANK_FILEPATH, RecordType, GroupNumber, MasterGroupNumber,
					ContractNumber, PBPNumber, Division);
			Iterator in_Val_It = InputValue.entrySet().iterator();
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
		if (DBValues_List.size() == 0) {
			for (int i = 0; i < InputValues_List.size(); i++) {
				if (i > 0) {
					for (int j = 0; j <= InputValues_List.size(); j++) {
						row = outSheet.getRow(j);
						Cell gapColumn = row.createCell(commnetsColumn + 1);
						addBackgroundColor_gapColumn(gapColumn);
					}
				}
				row = outSheet.getRow(i + 1);
				Cell compResutl = row.createCell(comapreColumn);
				compResutl.setCellValue("Pass");
			}
			Cell passStatus = outSheet.getRow(1).createCell(passColumn);
			passStatus.setCellValue("Pass");
			addBackgroundColor_Pass(passStatus);
		} else {
			row = outSheet.getRow(1);
			Cell Pass = row.createCell(passColumn);
			Cell Comment = row.createCell(commnetsColumn);
			Pass.setCellValue("Fail");
			addBackgroundColor_Fail(Pass);
			temp_passStatus += 1;
			Comment.setCellValue("Delete operation was unsuccessful");
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
		Excel_Compare_ComponentCode_Employer_DeleteOperation h = new Excel_Compare_ComponentCode_Employer_DeleteOperation();
		h.Input_data(filepath, outPutFile);
		h.autoSizeColumns();
		h.writeFile();
	}

}
