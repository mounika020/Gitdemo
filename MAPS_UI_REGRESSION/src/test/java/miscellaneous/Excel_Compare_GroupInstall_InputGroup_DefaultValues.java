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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.Constants;
import utilities.Utils;

@SuppressWarnings("unused")

public class Excel_Compare_GroupInstall_InputGroup_DefaultValues extends BaseClass {

	public Excel_Compare_GroupInstall_InputGroup_DefaultValues(WebDriver driver) {
		super(driver);
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	LinkedHashMap<String, String> DefaultValue = null;
	LinkedHashMap<String, String> UIValue = null;
	List<String> UIValues_List;
	List<String> InputValues_List;
	FileOutputStream outputStream = null;
	Workbook outWorkbook = null;
	Sheet outSheet;
	int rowNum = 1;
	Row row = null;
	XSSFCellStyle backgroundStyle = null;
	XSSFFont font = null;
	int cell_columnName = 0;
	int cell_defaultValue = 1;
	int cell_UIValue = 2;
	int comapreColumn = 3;
	int passColumn = 4;
	int commnetsColumn = 5;
	int headingCount = 0;
	int temp_passStatus = 0;

	@SuppressWarnings("resource")
	public void UI_data(String filePath, String sheet, String outputFile)
			throws ClassNotFoundException, SQLException, IOException {

		// Reading input file data
		XSSFSheet inSheet = Utils.excel_sheet(filePath, sheet);

		// Iterating Input data
		DefaultValue = new LinkedHashMap<String, String>();
		int inRowCount = inSheet.getLastRowNum() - inSheet.getFirstRowNum();
		for (int i = 1; i <= inRowCount; i++) {
			for (int j = 2; j < inSheet.getRow(i).getLastCellNum(); j++) {
				DefaultValue.put(inSheet.getRow(0).getCell(j).getStringCellValue(),
						inSheet.getRow(i).getCell(j).getStringCellValue());
			}

		}

		InputValues_List = new ArrayList<String>(DefaultValue.values());
		// Output file
		outputStream = new FileOutputStream(outputFile);
		outWorkbook = new XSSFWorkbook();
		outSheet = outWorkbook.createSheet("testSheet");

		UIValue = new LinkedHashMap<String, String>();
		List<WebElement> data = driver.findElements(By.xpath(
				"//form[@action='/GroupInstallData' and @method='post']/descendant::*[@id='PCPRequiredOptions' or @id='defaultPCPOptions' or @id='GPSEmployerID' or @id='GPSBranchNumber' or @id='txtCommt' or @id='GetBCCIInput_ChangeRequiredToSourceSystem']"));
		List<WebElement> field = driver.findElements(By.xpath(
				"//form[@action='/GroupInstallData' and @method='post']/descendant::*[@for='GPS Branch Number' or @ for='GPSEmployerID' or @ for='DefaultPCP' or @ for='PCP Required' or @for='Comment' or @for='ChangeRequiredToSourceSystemOptions']"));
		int nextField = 0;
		for (WebElement d : data) {
			if (d.getTagName().equalsIgnoreCase("input")) {
				UIValue.put(field.get(nextField).getText(), d.getAttribute("value"));
			} else {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", d);
				UIValue.put(field.get(nextField).getText(), new Select(d).getFirstSelectedOption().getText());
			}
			nextField++;
		}

		// List created to store only DBValues
		UIValues_List = new ArrayList<String>(UIValue.values());

		// To Create 1000 empty rows in output sheet
		for (int i = 0; i < 1000; i++) {
			row = outSheet.createRow(i);
		}

		row = outSheet.getRow(0);
		Cell Heading1 = row.createCell(headingCount);
		Cell Heading2 = row.createCell(headingCount + 1);
		Cell Heading3 = row.createCell(headingCount + 2);
		Cell Heading4 = row.createCell(headingCount + 3);
		Cell Heading5 = row.createCell(headingCount + 4);
		Cell Heading6 = row.createCell(headingCount + 5);
		Heading1.setCellValue("Column Name");
		addBackgroundColor_Header(Heading1);
		Heading2.setCellValue("Default Value");
		addBackgroundColor_Header(Heading2);
		Heading3.setCellValue("UI Value");
		addBackgroundColor_Header(Heading3);
		Heading4.setCellValue("Compare");
		addBackgroundColor_Header(Heading4);
		Heading5.setCellValue("Pass/Fail");
		addBackgroundColor_Header(Heading5);
		Heading6.setCellValue("Comments");
		addBackgroundColor_Header(Heading6);

		// iterating and writing UI values in output sheet
		Iterator UI_values = UIValue.entrySet().iterator();
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
		Iterator input_values = DefaultValue.entrySet().iterator();
		while (input_values.hasNext()) {
			Entry ein = (Entry) input_values.next();
			String input_Key = (String) ein.getKey().toString();
			String input_Val = (String) ein.getValue();
			row = outSheet.getRow(rowNum++);
			Cell input_value = row.createCell(cell_defaultValue);
			input_value.setCellValue(input_Val);
		}

		cell_columnName += 7;
		cell_defaultValue += 7;
		cell_UIValue += 7;
		headingCount += 7;
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

		if (InputValues_List.size() == UIValues_List.size()) {

			for (int i = 0; i < InputValues_List.size(); i++) {
				if (i > 0) {
					for (int j = 0; j <= UIValues_List.size(); j++) {
						row = outSheet.getRow(j);
						Cell gapColumn = row.createCell(commnetsColumn + 1);
						addBackgroundColor_gapColumn(gapColumn);
					}
				}
				try {
					if (UIValues_List.get(i).isEmpty() && InputValues_List.get(i).isEmpty()) {
						row = outSheet.getRow(i + 1);
						Cell compResutl = row.createCell(comapreColumn);
						compResutl.setCellValue("Pass");
					} else if (UIValues_List.get(i).isEmpty() || InputValues_List.get(i) == null) {
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
						if (InputValues_List.get(i).toString().equalsIgnoreCase(UIValues_List.get(i).toString())) {
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

	public static void generateCompareReport(String filePath, String sheetName, String outputFile)
			throws ClassNotFoundException, SQLException, IOException {
		String filepath = filePath;
		String outPutFile = outputFile;
		String sheet = sheetName;
		Excel_Compare_GroupInstall_InputGroup_DefaultValues h = new Excel_Compare_GroupInstall_InputGroup_DefaultValues(
				driver);
		h.UI_data(filepath, sheet, outPutFile);
		h.autoSizeColumns();
		h.writeFile();
	}

}
