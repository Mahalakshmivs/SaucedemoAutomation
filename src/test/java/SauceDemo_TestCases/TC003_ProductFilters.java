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

	@Test(groups = "masters")
	public void verifyDisplayOfDropdown() throws InterruptedException {
		WebElement drpDisplayed = pl.dropdown_filter;
		Assert.assertEquals(drpDisplayed.isDisplayed(), true);

	}

	@Test(dependsOnMethods = "verifyDisplayOfDropdown",groups = "masters")
	public void selectionOfFilters() {
		mywait.until(ExpectedConditions.visibilityOf(pl.dropdown_filter));
		pl.clickOnFilters();
		pl.selectFilters();
	}

}
