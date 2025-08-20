package demo.handling.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\testing1.xlsx");
		
													
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("write");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int noOfRows = scanner.nextInt();
		System.out.println("Enter number of cells: ");
		int noOfCells = scanner.nextInt();
		
		for(int r=0;r<=noOfRows;r++) {
			
			XSSFRow currentRow = sheet.createRow(r);
			
			for(int c=0;c<noOfCells;c++)
			{
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(scanner.next().toString());
			}
		
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
	}

}
