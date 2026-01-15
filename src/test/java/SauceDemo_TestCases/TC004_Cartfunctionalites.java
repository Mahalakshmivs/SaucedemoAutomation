package SauceDemo_TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC004_Cartfunctionalites extends saucedemo_BaseClasses {

	@Test(groups = "masters")
	public void addProductsToCart() throws InterruptedException {
		pl.clickOnAddToCart();
		Assert.assertTrue(pl.isbadgeDisplayed());
		Assert.assertEquals(pl.getTextOfBadge(), "2");
	}

	@Test(dependsOnMethods = "addProductsToCart",groups = "masters")
	public void addProductsUsingDesc() throws InterruptedException {
		pl.clickOnProductToAddcart();
		Assert.assertTrue(pl.isbadgeDisplayed());
		Assert.assertEquals(pl.getTextOfBadge(), "4");
	}

	@Test(dependsOnMethods = "addProductsUsingDesc",groups = "masters")
	public void cartPage() throws InterruptedException {
		pl.clickOnCart();
	}

	@Test(dependsOnMethods = "cartPage" ,groups = "masters")
	public void getNumberOfItems() throws InterruptedException {
		System.out.println(cart.numofprodutsincart());
		Assert.assertEquals(cart.numofprodutsincart(), 4, "Test failed due to mismatch");
	}

	@Test(dependsOnMethods = "getNumberOfItems" ,groups = "masters")
	public void removeProductsFromCart() {
		cart.removeoneproducts();
		Assert.assertFalse(cart.isitempresnt());
	}

	@Test(dependsOnMethods = "removeProductsFromCart",groups = "masters")
	public void clickOnContinue() throws InterruptedException {
		cart.scrollintobtn();
		String url2 = driver.getCurrentUrl();
		Assert.assertEquals(url2, "https://www.saucedemo.com/inventory.html");
	}
	@Test(dependsOnMethods = "clickOnContinue",groups = "masters")
	public void refreshPage() {
		pl.clickOnCart();
		driver.navigate().refresh();
		Assert.assertTrue(cart.cartitemsisdisplayed());
	}

}
