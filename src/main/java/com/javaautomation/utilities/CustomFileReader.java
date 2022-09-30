package com.javaautomation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CustomFileReader {

	public static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
	public File f;
	public FileInputStream fis;
	private Workbook wb;
	private Sheet sheatName;
	private Row row;
	private Cell cell;

	public CustomFileReader() {
		
		try {
			f = new File(path);
			fis = new FileInputStream(f);
			wb = WorkbookFactory.create(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getRowNumber(String excelSheetName) {
		sheatName = wb.getSheet(excelSheetName);
		if (sheatName == null) {
			return 0;
		} else {
			int totalRow = sheatName.getLastRowNum() + 1;
			return totalRow;
		}

	}

	public int getColNumber(String excelSheetName) {
		sheatName = wb.getSheet(excelSheetName);
		if (sheatName == null) {
			return 0;
		} else {
			row = sheatName.getRow(0);
			int totalCol = row.getLastCellNum();
			return totalCol;
		}
	}

	public String getCellData(String excelSheetName, int colNum, int rowNum) {

		if (rowNum < 0) {
			return "Error";
		}
		sheatName = wb.getSheet(excelSheetName);
		if (sheatName == null) {
			return "Error";
		}
		row = sheatName.getRow(rowNum);
		if (row == null) {
			return "Error";
		}
		cell = row.getCell(colNum);
        if (cell == null) {
        	return "Error";
        }
        if (cell.getCellType().name().equals("STRING")) {
        	return cell.getStringCellValue();
        } else if (cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA")) {
        	return String.valueOf((int)cell.getNumericCellValue());
        } else if (cell.getCellType().name().equals("BLANK")) {
        	return "";
        } else 
        	return String.valueOf(cell.getBooleanCellValue());

	}

}
