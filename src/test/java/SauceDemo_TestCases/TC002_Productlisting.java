package SauceDemo_TestCases;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.formula.ThreeDEval;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsListing;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC002_Productlisting extends saucedemo_BaseClasses{
	
	@Test
	public  void testtheproductlisting() throws InterruptedException {
		loginpage ad = new loginpage(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();
		ProductsListing pl=new ProductsListing(driver);
		 List<String> titles = pl.verifyttle();
		 for(String t:titles) {
			 Assert.assertFalse(t.isEmpty(),"The test failed becoz the product images are blank");
		 }
		 System.out.println("All products title are " +titles);
		 Thread.sleep(10000);
		 
	}
		 @Test(dependsOnMethods = "testtheproductlisting")
		 public void verifyingtheimageextentions() throws InterruptedException {
			 ProductsListing pl=new ProductsListing(driver);
			 List<String> imageextension=pl.verifyproductsimages();
			 for(String img:imageextension) {
				 Assert.assertTrue(img.endsWith(".jpg"), "The image does not contain file extension of ending with .jpg");
			 }
			 System.out.println("All products images are " +imageextension);
			 Thread.sleep(4000);
			 
		 }
		 
		 @Test(dependsOnMethods = "verifyingtheimageextentions")
		 public void imagenaivagtion() throws InterruptedException {
			 ProductsListing pl=new ProductsListing(driver);
			 pl.clickoneachimages(); 
			 Thread.sleep(4000);
		 }
		 
		 @Test(dependsOnMethods = "imagenaivagtion")
		 public void titlenavigation() {
			 ProductsListing pl=new ProductsListing(driver);
			 pl.clickoneachtitle(); 
		 }
		
	}


