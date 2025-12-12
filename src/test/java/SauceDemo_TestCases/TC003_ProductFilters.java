package SauceDemo_TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsListing;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC003_ProductFilters extends saucedemo_BaseClasses {
	// Validate that the user can view all the dropdown and able to select all the
	// value in dropdown
	// vaild the dropwndown is also displayed

	@Test
	public void verifydisplayofdropdown() {
		loginpage ad = new loginpage(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();
		ProductsListing pl = new ProductsListing(driver);
		WebElement drpdisplayed = pl.drp_filter;
		Assert.assertEquals(drpdisplayed.isDisplayed(), true);

	}

	@Test(dependsOnMethods = "verifydisplayofdropdown")
	public void selectionoffilters() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		pl.clickonfilter();
		Thread.sleep(2000);
		pl.selectfilters();
	}

}
