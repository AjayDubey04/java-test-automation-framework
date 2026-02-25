package testng.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ApachePoi {

	
	public  void excelDataReader() throws IOException {

		//  Excel(XLS).files for old version  -- HSSf
		//  Excel(XLSX).format for New version -- XSSF
		//	Excel - workbook - sheet - row - cell 

		File fileObj=new File("src\\test\\resources\\ExcelData.xlsx");
		FileInputStream fileInput=new FileInputStream(fileObj);
		try (Workbook workbook = new XSSFWorkbook(fileInput)) {
			Sheet sheet=workbook.getSheetAt(0);
			int rowNo=sheet.getLastRowNum();
			System.out.println("Row Number-->"+rowNo);

			//			Row row=sheet.getRow(1);
			//			System.out.println("Cell Number-->"+row.getLastCellNum());

			// try to get all data from excel
			for (int i = 0; i<=rowNo; i++) {
				Row row=sheet.getRow(i);
				int cellNo=row.getLastCellNum();
				for (int j=0; j<cellNo; j++) {
					Cell cellValue=row.getCell(j);
					System.out.print(cellValue.getStringCellValue()+" , ");
				}
				System.out.println();
			}


			// For String Value 
			//		  Cell cell=row.getCell(3,MissingCellPolicy.CREATE_NULL_AS_BLANK);
			//		  String value=cell.getStringCellValue();

			// For Numeric Data
			//			Cell cell=row.getCell(3);
			//			Double intVlaue=cell.getNumericCellValue();
			//			int cellValue=intVlaue.intValue();
			//			System.out.println(cellValue);



		}


	}

}
