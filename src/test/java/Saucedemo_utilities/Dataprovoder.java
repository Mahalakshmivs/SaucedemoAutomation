package Saucedemo_utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovoder {
	
	@DataProvider(name="logindata")
	public String[][] getdata() throws IOException{
		
		String path="D:\\Javaprograming\\TestAutomation1\\TestData\\logindata.xlsx";
		ExcelUtility ex=new ExcelUtility(path);
		int rows=ex.getRowCount("sheet1");
		int col=ex.getCellCount("sheet1", 1);
		
		String Logindata[][]=new String[rows][col];
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<col;j++)
			{
				Logindata[i-1][j]=ex.getCellData("sheet1", i, j);
			}
		}
		
		return Logindata;
		
	}

}
