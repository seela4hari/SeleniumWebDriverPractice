package demo.handling.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int noOfRows = sheet.getLastRowNum();
		int noOfCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total rows: "+noOfRows);
		System.out.println("Total cells: "+noOfCells);
		
		for(int r=0;r<=noOfRows;r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for(int c=0;c<noOfCells;c++) {
				XSSFCell cell = currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
	}

}
