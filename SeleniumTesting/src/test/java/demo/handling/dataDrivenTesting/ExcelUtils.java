package demo.handling.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//get number of rows in excel
	public static int getRowCount(String filePath,String xlsheet) throws IOException {
		
		fis=new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		int noOfRows = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return noOfRows;
	}
	
	//get total columns or cell count in a row
	public static int getCellCount(String filePath,String xlsheet, int rowNum) throws IOException {
		
		fis=new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	}
	
	//read data from cell
	public static String getCellData(String filePath,String xlsheet, int rowNum, int cellNum) throws IOException {
		
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		try {
			data = cell.toString();
		} catch (Exception e) {
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	//writing data to cell
	public static void setCellData(String filePath,String xlsheet, int rowNum, int cellNum, String data) throws IOException {
		
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		fos.close();
		fis.close();		
	}
}
