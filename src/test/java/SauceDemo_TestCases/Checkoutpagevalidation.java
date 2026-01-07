package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import saucedemo_BaseClass.saucedemo_BaseClasses;

public class Checkoutpagevalidation extends saucedemo_BaseClasses {

	@Test
	public void validateZipCode() throws InterruptedException {
		pl.clickonaddtocart();
		Thread.sleep(10000);
		pl.clickoncart();
		cart.checkout();
		check.ZipCodeValidation("Maha", "vs");
		check.clickoncontinue();
		String myZipCodeErrMsg = check.zipMsg();
		Assert.assertEquals(myZipCodeErrMsg, "Error: Postal Code is required");
	}

	@Test(dependsOnMethods = "validateZipCode")
	public void CancelButtonValidation() throws InterruptedException {
//		pl.clickonaddtocart();
//		Thread.sleep(10000);
//		pl.clickoncart();
//		cart.checkout();
		check.clearfileds();
		check.validDataNavigation("Maha", "vs", "560037");
		check.clickoncontinue();
		check.cancelAction();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "CancelButtonValidation")
	public void vaildateFinishfun() throws InterruptedException {
		pl.clickoncart();
		cart.checkout();
		Thread.sleep(10000);
		check.clearfileds();
		check.validDataNavigation("Maha", "vs", "560037");
		check.clickoncontinue();
		check.finishbtn();
		Assert.assertEquals(check.getSucessMessage(), "Thank you for your order!");

	}
	
	@Test(dependsOnMethods = "vaildateFinishfun")
	public void  backToHomebtn() throws InterruptedException {
		Thread.sleep(10000);
		check.pressBacktoHome();
		String homeUrl=driver.getCurrentUrl();
		Assert.assertEquals(homeUrl, "https://www.saucedemo.com/inventory.html");

	}

}
