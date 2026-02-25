package com.example.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

	public static List<List<String>> readExcelData(String filePath, String sheetName) {
		List<List<String>> data = new ArrayList<>();

		try (FileInputStream fileInputStream = new FileInputStream(filePath);
				Workbook workbook = new XSSFWorkbook(fileInputStream)) {

			Sheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				List<String> rowData = new ArrayList<>();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					rowData.add(getCellValueAsString(cell));
				}

				data.add(rowData);
			}

		} catch (IOException e) {
			e.printStackTrace();
			// Handle the exception according to your needs
		}

		return data;
	}

	private static String getCellValueAsString(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return "";
		}
	}

	public static void main(String[] args) {
		// Example usage:
		String filePath = "src\\test\\resources\\testData\\testdata.xlsx";
		String sheetName = "Sheet1";

		List<List<String>> excelData = readExcelData(filePath, sheetName);

		// Display the read data
		for (List<String> row : excelData) {
			System.out.println(row);
		}
	}
}




