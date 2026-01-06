package Saucedemo_utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider_Checkout {
	
	@DataProvider(name="CheckoutPageData")
	public String[][] getDataCheckout() throws IOException {
		
		String path="D:\\Javaprograming\\TestAutomation1\\TestData\\CheckoutData1.xlsx";
		
		ExcelUtility exe=new ExcelUtility(path);
		
		int rows=exe.getRowCount("sheet1");
		int cols=exe.getCellCount("sheet1", 1);
		
		String checkoutformdata[][]=new String[rows][cols];
		
		for(int i=1;i<=rows;i++) {
			for(int j=0 ;j<cols;j++)
			{
				checkoutformdata[i-1][j]=exe.getCellData("sheet1", i, j);
			}
		}
		
		return checkoutformdata;
	}
	

}
