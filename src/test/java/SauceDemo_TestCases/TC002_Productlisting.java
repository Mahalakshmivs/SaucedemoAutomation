package SauceDemo_TestCases;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsListing;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC002_Productlisting extends saucedemo_BaseClasses {

	// Validate that the 'Product Name' titles are displayed
	@Test
	public void productListing() {
		ProductsListing pl = new ProductsListing(driver);
		mywait.until(ExpectedConditions.visibilityOfAllElements(pl.product_title));
		List<String> titles = pl.verifyttle();
		for (String t : titles) {
			Assert.assertFalse(t.isEmpty(), "The test failed becoz the product images are blank");
		}
		System.out.println("All products title are " + titles);
	}

	// Validate all the 'Products Images' are displaying properly and is in the
	// required format.
	@Test(dependsOnMethods = "productListing")
	public void imageExtentions() {
		ProductsListing pl = new ProductsListing(driver);
		mywait.until(ExpectedConditions.visibilityOfAllElements(pl.product_images));
		List<String> imageextension = pl.verifyproductsimages();
		for (String img : imageextension) {
			Assert.assertTrue(img.endsWith(".jpg"), "The image does not contain file extension of ending with .jpg");
		}
		System.out.println("All products images are " + imageextension);
	}

	// Validate that the product details are displayed if user clicks on the image
	@Test(dependsOnMethods = "imageExtentions")
	public void imageNaivagtion() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		Thread.sleep(10000);
		List<String> allurls = pl.clickoneachimages();
		for (String u : allurls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the correct Parameters");
		}
	}

	// Validate that the product details are displayed if user clicks on product
	// name
	@Test(dependsOnMethods = "imageNaivagtion")
	public void titleNavigation() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		Thread.sleep(10000);
		List<String> allurls = pl.clickoneachtitle();
		for (String u : allurls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the correct Parameters");
		}
	}

}
