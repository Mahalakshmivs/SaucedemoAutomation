package SauceDemo_TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsListing;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC003_ProductFilters extends saucedemo_BaseClasses {
	// Validate that the user can view all the dropdown and able to select all the
	// value in dropdown
	// vaild the dropwndown is also displayed

	@Test
	public void verifyDisplayofDropdown() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		WebElement drpdisplayed = pl.drp_filter;
		Assert.assertEquals(drpdisplayed.isDisplayed(), true);
		Thread.sleep(2000);

	}

	@Test(dependsOnMethods = "verifyDisplayofDropdown")
	public void selectionOfFilters() {
		ProductsListing pl = new ProductsListing(driver);
		mywait.until(ExpectedConditions.visibilityOf(pl.drp_filter));
		pl.clickonfilter();
		pl.selectfilters();
	}

}
