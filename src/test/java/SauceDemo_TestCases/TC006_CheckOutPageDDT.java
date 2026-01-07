package SauceDemo_TestCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;
import Saucedemo_utilities.Dataprovider_Checkout;
import pageObjects.ProductsListing;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC006_CheckOutPageDDT extends saucedemo_BaseClasses {

	public void resettocheckout() {
		check.cancelAction();
		pl.clickoncart();
		cart.checkout();
	}

	@Test
	public void gotocart() throws InterruptedException {
		Thread.sleep(10000);
		pl.clickonaddtocart();
		pl.clickoncart();
		cart.checkout();
	}

	@Test(dataProvider = "CheckoutPageData", dataProviderClass = Dataprovider_Checkout.class, dependsOnMethods = "gotocart")
	public void testCheckOutPage(String FirstName, String LastName, String Zipcode, String expected)
			throws InterruptedException {
		check.firstName(FirstName);
		check.lastName(LastName);
		check.zipCode(Zipcode);
		check.clickoncontinue();
		if (expected.equalsIgnoreCase("invalid")) {
			resettocheckout();
			Assert.assertFalse(check.overviewtitle(), "Test didn't pass for invalid data ");
		}
		if (expected.equalsIgnoreCase("valid")) {
			resettocheckout();
			Assert.assertTrue(check.overviewtitle(), "Test passed failed for valid data ");
		}

	}
}
