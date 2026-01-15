package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC007_CheckoutPage extends saucedemo_BaseClasses {

	@Test(groups = "masters")
	public void validateEmptyZipCode() {
		pl.clickOnAddToCart();
		pl.clickOnCart();
		cart.checkout();
		check.ZipCodeValidation("Maha", "vs");
		check.clickOnContinue();
		String myZipCodeErrMsg = check.zipMsg();
		Assert.assertEquals(myZipCodeErrMsg, "Error: Postal Code is required");
	}

	@Test(dependsOnMethods = "validateEmptyZipCode",groups = "masters")
	public void validateCancelCheckout() {
		check.clearInputFields();
		check.validDataNavigation("Maha", "vs", "560037");
		check.clickOnContinue();
		check.cancelAction();
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://www.saucedemo.com/inventory.html");
	}

	@Test(dependsOnMethods = "validateCancelCheckout",groups = "masters")
	public void validateFinishOrder(){
		pl.clickOnCart();
		cart.checkout();
		check.clearInputFields();
		check.validDataNavigation("Maha", "vs", "560037");
		check.clickOnContinue();
		check.clickOnFinishbBtn();
		Assert.assertEquals(check.getSucessMessage(), "Thank you for your order!");

	}

	@Test(dependsOnMethods = "validateFinishOrder",groups = "masters")
	public void navigateHomePage() {
		check.pressBacktoHome();
		String homeUrl = driver.getCurrentUrl();
		Assert.assertTrue(homeUrl.contains("inventory.html"));

	}

}
