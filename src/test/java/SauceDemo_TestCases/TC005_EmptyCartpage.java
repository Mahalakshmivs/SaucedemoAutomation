package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Carts;
import pageObjects.ProductsListing;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC005_EmptyCartpage extends saucedemo_BaseClasses{
	
	@Test (priority = 1)
	public  void emptycartpage() {
		loginpage ad = new loginpage(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();
		ProductsListing pl = new ProductsListing(driver);
		pl.clickoncart();
		Carts cart=new Carts(driver);
		Assert.assertEquals(true,cart.emptycartpage());
		
	}
	@Test(priority = 2 ,alwaysRun = true)
	public void checkoutpagewithproducts() {
		Carts cart=new Carts(driver);
		cart.checkout();
		String url =driver.getCurrentUrl();
		if (url=="https://www.saucedemo.com/checkout-step-one.html")
		{
		  Assert.fail();	
		}
		
	}
	

}
