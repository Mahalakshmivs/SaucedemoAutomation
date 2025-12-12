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

public class TC002_Productlisting extends saucedemo_BaseClasses {

	// Validate that the 'Product Name' titles are displayed
	@Test
	public void testtheproductlisting() throws InterruptedException {
		loginpage ad = new loginpage(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();
		ProductsListing pl = new ProductsListing(driver);
		List<String> titles = pl.verifyttle();
		for (String t : titles) {
			Assert.assertFalse(t.isEmpty(), "The test failed becoz the product images are blank");
		}
		System.out.println("All products title are " + titles);
		Thread.sleep(3000);

	}

    // Validate all the 'Products Images' are displaying properly and is in the required format.
	@Test(dependsOnMethods = "testtheproductlisting")
	public void verifyingtheimageextentions() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		List<String> imageextension = pl.verifyproductsimages();
		for (String img : imageextension) {
			Assert.assertTrue(img.endsWith(".jpg"), "The image does not contain file extension of ending with .jpg");
		}
		System.out.println("All products images are " + imageextension);
		Thread.sleep(4000);

	}

	// Validate that the product details are displayed if user clicks on the image

	@Test(dependsOnMethods = "verifyingtheimageextentions")
	public void imagenaivagtion() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		List<String> allurls = pl.clickoneachimages();
		for (String u : allurls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the correct Parameters");
		}
		Thread.sleep(4000);
	}

	// Validate that the product details are displayed if user clicks on product
	// name

	@Test(dependsOnMethods = "imagenaivagtion")
	public void titlenavigation() {
		ProductsListing pl = new ProductsListing(driver);
		List<String> allurls = pl.clickoneachtitle();
		for (String u : allurls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the correct Parameters");
		}
	}

}
