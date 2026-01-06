package SauceDemo_TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;


import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC004_Cartfunctionalites extends saucedemo_BaseClasses {

	@Test
	public void addProductsToCart() throws InterruptedException {
		pl.clickonaddtocart();
		Assert.assertTrue(pl.isbadgedisplayed());
		Assert.assertEquals(pl.getthetextofbadge(), "2");
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "addProductsToCart")
	public void addProductsUsingDesc() throws InterruptedException {
		pl.clickonproducttoaddcart();
		Assert.assertTrue(pl.isbadgedisplayed());
		Assert.assertEquals(pl.getthetextofbadge(), "4");
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "addProductsUsingDesc")
	public void cartPage() throws InterruptedException {
		pl.clickoncart();
		Thread.sleep(10000);
	}

	@Test(dependsOnMethods = "cartPage")
	public void getNumberOfItems() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(cart.numofprodutsincart());
		Assert.assertEquals(cart.numofprodutsincart(), 4, "Test failed due to mismatch");
	}

	@Test(dependsOnMethods = "getNumberOfItems")
	public void removeProductsFromCart() {
		cart.removeoneproducts();
		Assert.assertFalse(cart.isitempresnt());
	}

	@Test(dependsOnMethods = "removeProductsFromCart")
	public void clickOnContinue() throws InterruptedException {
		cart.scrollintobtn();
		Thread.sleep(10000);
		String url2 = driver.getCurrentUrl();
		Assert.assertEquals(url2, "https://www.saucedemo.com/inventory.html");
	}
	@Test(dependsOnMethods = "clickOnContinue")
	public void refreshPage() {
		pl.clickoncart();
		driver.navigate().refresh();
		Assert.assertTrue(cart.cartitemsisdisplayed());
	}

}
