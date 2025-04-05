package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	static String data;

	public static String readExcelData(int rowNo, int colNo) throws IOException {

		FileInputStream filePath = new FileInputStream(".\\src\\main\\resources\\TestData\\userdata.xlsx");
		Workbook wb = WorkbookFactory.create(filePath);
		Sheet sheet = wb.getSheet("sheet1");
		CellType celltype = sheet.getRow(rowNo).getCell(colNo).getCellType();
		// System.out.println(celltype);
		switch (celltype) {

		case STRING:
			data = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
			break;
		case NUMERIC:
			double data1 = sheet.getRow(rowNo).getCell(colNo).getNumericCellValue();
			data = String.valueOf(data1);
			break;
		case BOOLEAN:
			boolean data2 = sheet.getRow(rowNo).getCell(colNo).getBooleanCellValue();
			data = String.valueOf(data2);
			break;

		default:
			break;
		}

		System.out.println(data);
		return data;

	}

	public static void writeExcelData(int row,int col,String value) throws IOException {

		FileOutputStream fo = new FileOutputStream(".\\src\\main\\resources\\TestData\\OutputData.xlsx");
		try (Workbook wb = new XSSFWorkbook()) {
			Sheet st = wb.createSheet("Sheet1");
			Cell c = st.createRow(row).createCell(col);
			c.setCellValue(value);
			wb.write(fo);
		}
		fo.close();
		
	}

}
