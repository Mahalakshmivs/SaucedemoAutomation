package SauceDemo_TestCases;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductsListing;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC002_Productlisting extends saucedemo_BaseClasses {
	// Validate that the 'Product Name' titles are displayed
	@Test(groups = "masters")
	public void verifyProductTitlesAreNotEmpty() throws InterruptedException {
		List<String> titles = pl.verifyTitle();
		for (String t : titles) {
			Assert.assertFalse(t.isEmpty(), "The test failed because the product titles are blank");
		}
		System.out.println("Product titles displayed: " + titles);
	}
	// Validate all the 'Products Images' are displaying properly and is in the
	// required format.
	@Test(dependsOnMethods = "verifyProductTitlesAreNotEmpty",groups = "masters")
	public void verifyProductImageExtensions() {
		mywait.until(ExpectedConditions.visibilityOfAllElements(pl.productImages));
		List<String> imageExtension = pl.verifyProductsImages();
		for (String img : imageExtension) {
			Assert.assertTrue(img.toLowerCase().endsWith(".jpg"),"Image does not have .jpg extension: " + img);
		}
		System.out.println("All products images are " + imageExtension);
		
	}

	// Validate that the product details are displayed if user clicks on the image
	@Test(dependsOnMethods = "verifyProductImageExtensions",groups = "masters")
	public void verifyProductImageNavigation() {
		List<String> allUrls = pl.clickOnEachImages();
		for (String u : allUrls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the Expected Parameters");
		}
	}
	// Validate that the product details are displayed if user clicks on product
	// name
	@Test(dependsOnMethods = "verifyProductImageNavigation",groups = "masters")
	public void verifyProduvtTitleNavigation()  {
		ProductsListing pl = new ProductsListing(driver);
		List<String> allUrls = pl.clickOnEachTitle();
		for (String u : allUrls) {
			Assert.assertTrue(u.contains("inventory-item.html"),
					"Test failed becoz the url was not containing the Expected Parameters");
		}
	}
}
