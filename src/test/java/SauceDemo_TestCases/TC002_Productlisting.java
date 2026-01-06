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
	public void productListing() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		mywait.until(ExpectedConditions.visibilityOfAllElements(pl.product_title));
		List<String> titles = pl.verifyTitle();
		for (String t : titles) {
			Assert.assertFalse(t.isEmpty(), "The test failed because the product titles are blank");
		}
		System.out.println("Product titles displayed: " + titles);
		Thread.sleep(10000);
	}
	// Validate all the 'Products Images' are displaying properly and is in the
	// required format.
	@Test(dependsOnMethods = "productListing")
	public void imageExtensions() {
		ProductsListing pl = new ProductsListing(driver);
		mywait.until(ExpectedConditions.visibilityOfAllElements(pl.product_images));
		List<String> imageExtension = pl.verifyproductsimages();
		for (String img : imageExtension) {
			Assert.assertTrue(img.toLowerCase().endsWith(".jpg"),"Image does not have .jpg extension: " + img);
		}
		System.out.println("All products images are " + imageExtension);
	}

	// Validate that the product details are displayed if user clicks on the image
	@Test(dependsOnMethods = "imageExtensions")
	public void imageNavigation() {
		ProductsListing pl = new ProductsListing(driver);
		List<String> allUrls = pl.clickoneachimages();
		for (String u : allUrls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the Expected Parameters");
		}
	}
	// Validate that the product details are displayed if user clicks on product
	// name
	@Test(dependsOnMethods = "imageNavigation")
	public void titleNavigation()  {
		ProductsListing pl = new ProductsListing(driver);
		List<String> allUrls = pl.clickoneachtitle();
		for (String u : allUrls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the Expected Parameters");
		}
	}
}
