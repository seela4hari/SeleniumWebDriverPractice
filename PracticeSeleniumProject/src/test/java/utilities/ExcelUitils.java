package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUitils {

	
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		FileInputStream fis;
		FileOutputStream fos;
		String xlfile;
		
		public ExcelUitils(String xlfile){
			this.xlfile = xlfile;
		}

		//Fetch number of rows in the excel file
		public int getRowCount(String xlsheet) throws IOException {
			
			fis = new FileInputStream(xlfile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlsheet);
			int rowCount = sheet.getLastRowNum();
			workbook.close();
			fis.close();
			return rowCount;
	}
		
		//Fetch number of columns in the excel file
		public int getColumnCount(String xlsheet, int rowNumber) throws IOException {
			
			fis = new FileInputStream(xlfile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlsheet);
			row = sheet.getRow(rowNumber);
			int columnCount = row.getLastCellNum();
			workbook.close();
			fis.close();
			return columnCount;
		}
		
		//Get the cell data from excel
		public String getCellData(String xlsheet, int rowNumber, int column) throws IOException {
			
			fis = new FileInputStream(xlfile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlsheet);
			row=sheet.getRow(rowNumber);
			cell = row.getCell(column);
			String data;
			try {
				data = cell.toString();
			}
			catch(Exception e){
				data="";
			}
			workbook.close();
			fis.close();
			return data;
		}
		
		//Set the cell value in excel file
		public void setCellData(String xlsheet, int rowNumber, int column, String data) throws IOException {
			
			fis = new FileInputStream(xlfile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(xlsheet);
			row=sheet.getRow(rowNumber);
			cell = row.createCell(column);
			cell.setCellValue(data);
			fos = new FileOutputStream(xlfile);
			workbook.write(fos);
			workbook.close();
			fos.close();
			fis.close();
		}
		
		
		
		

}













