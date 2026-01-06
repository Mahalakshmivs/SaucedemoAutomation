package SauceDemo_TestCases;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import Saucedemo_utilities.Dataprovider_Checkout;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC006_CheckOutPage extends saucedemo_BaseClasses {

	@Test
	public void gotocart() throws InterruptedException {
		Thread.sleep(10000);
		pl.clickonaddtocart();
		pl.clickoncart();
		cart.checkout();
	}

	@Test(dataProvider = "CheckoutPageData", dataProviderClass = Dataprovider_Checkout.class, dependsOnMethods = "gotocart")
	public void testCheckOutPage(String FirstName, String LastName, String Zipcode, String expected) {
		check.firstName(FirstName);
		check.lastName(LastName);
		check.zipCode(Zipcode);
		boolean overview = check.overviewtitle();
		if (expected.equalsIgnoreCase("valid")) {
			Assert.assertTrue(overview, "Test passed for th valid data ");
		} else if (expected.equalsIgnoreCase("invalid")) {
			
			if (overview == true) {
				check.cancelAction();
			}

				Assert.assertFalse(overview, "Test passed for the invalid data ");

		}

		driver.navigate().refresh();
	}

}
