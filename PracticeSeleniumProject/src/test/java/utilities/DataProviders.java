package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

		//Read excel data
		@DataProvider(name = "loginData")
		public String[][] getLoginExcelData() throws IOException{
			
			String xlPath = ".//testData//openCartLoingData.xlsx";// file path in current directory
			ExcelUitils util = new ExcelUitils(xlPath);
			//get row count and column counts from excel
			int rowCount = util.getRowCount("Sheet1");
			int columnCount = util.getColumnCount("Sheet1", 1);
			String loginData[][] = new String[rowCount][columnCount]; //creating two dimensional array
			
			//read data from excel and store in two dimensional array
			for(int r=1;r<=rowCount;r++) {
				for(int c=0;c<columnCount;c++) {
					loginData[r-1][c] = util.getCellData("Sheet1", r, c);
				}
			}
			
			return loginData;
	}

}
