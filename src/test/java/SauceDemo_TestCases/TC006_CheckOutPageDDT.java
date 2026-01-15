package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Saucedemo_utilities.Dataprovider_Checkout;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC006_CheckOutPageDDT extends saucedemo_BaseClasses {

	public void resetToCheckout() {
		check.cancelAction();
		pl.clickOnCart();
		cart.checkout();
	}

	@Test(groups = "masters")
	public void gotocart() throws InterruptedException {
		Thread.sleep(10000);
		pl.clickOnAddToCart();
		pl.clickOnCart();
		cart.checkout();
	}

	@Test(dataProvider = "CheckoutPageData", dataProviderClass = Dataprovider_Checkout.class, dependsOnMethods = "gotocart" ,groups = "masters")
	public void testCheckOutPage(String FirstName, String LastName, String Zipcode, String expected) {
		check.firstName(FirstName);
		check.lastName(LastName);
		check.zipCode(Zipcode);
		check.clickOnContinue();
		if (expected.equalsIgnoreCase("invalid")) {
			resetToCheckout();
			Assert.assertFalse(check.overViewTitle(), "Test didn't pass for invalid data it accepted the spl characters");
		}
		if (expected.equalsIgnoreCase("valid")) {
			resetToCheckout();
			Assert.assertTrue(check.overViewTitle(), "Test Failed for valid form data for checking out");
		}

	}
}
