package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Carts;
import pageObjects.ProductsListing;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC004_Cartfunctionalites extends saucedemo_BaseClasses {

	@Test
	public void addproductstocart() throws InterruptedException {
		loginpage ad = new loginpage(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();
		ProductsListing pl = new ProductsListing(driver);
		pl.clickonaddtocart();
		Assert.assertTrue(pl.isbadgedisplayed());
		Assert.assertEquals(pl.getthetextofbadge(), "2");
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "addproductstocart")
	public void addproductsusingdesc() {
		ProductsListing pl = new ProductsListing(driver);
		pl.clickonproducttoaddcart();
		Assert.assertTrue(pl.isbadgedisplayed());
		Assert.assertEquals(pl.getthetextofbadge(), "4");
	}

	@Test(dependsOnMethods = "addproductsusingdesc")
	public void cartpage() throws InterruptedException {
		ProductsListing pl = new ProductsListing(driver);
		pl.clickoncart();
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "cartpage")
	public void getnumberofitems() throws InterruptedException {
		Carts cart = new Carts(driver);
		Thread.sleep(2000);
		System.out.println(cart.numofprodutsincart());
		Assert.assertEquals(cart.numofprodutsincart(), 4, "Test failed due to mismatch");
	}

	@Test(dependsOnMethods = "getnumberofitems")
	public void removeproductsfromcart() {
		Carts cart = new Carts(driver);
		cart.removeoneproducts();
		Assert.assertFalse(cart.isitempresnt());
	}

	@Test(dependsOnMethods = "removeproductsfromcart")
	public void clickoncontinue() throws InterruptedException {
		Carts cart = new Carts(driver);
		cart.scrollintobtn();
		Thread.sleep(10000);
		String url2 = driver.getCurrentUrl();
		Assert.assertEquals(url2, "https://www.saucedemo.com/inventory.html");
	}
	@Test(dependsOnMethods = "clickoncontinue")
	public void refershpage() {
		ProductsListing pl = new ProductsListing(driver);
		Carts cart = new Carts(driver);
		pl.clickoncart();
		driver.navigate().refresh();
		Assert.assertEquals(true, cart.cartitemsisdisplayed());
	}

}
