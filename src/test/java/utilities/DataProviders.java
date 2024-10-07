package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_logindata.xlsx"; //taking xl file from testdata
				
		ExcelUtility xlutil= new ExcelUtility(path); // creating an object for xlUtility
		
		int totalrows=xlutil.getROwCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];//created for 2 dimensional array which can store
		for(int i=1;i<totalrows;i++) //  read data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++) //i is rows j is cols
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1",i,j);
			}
		}
		return logindata; //returning 2 dimensional array
	}
	

}
