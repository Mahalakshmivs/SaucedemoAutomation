package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC006_CheckOutPage extends saucedemo_BaseClasses{
	
	@Test
	public void gotocart() throws InterruptedException {
		Thread.sleep(10000);
		pl.clickonaddtocart();
		pl.clickoncart();
		cart.checkout();
	}
    @Test(dependsOnMethods = "gotocart")
	public void checkoutpagewithoutcred() throws InterruptedException {
    	check.clickoncontinue();
    	Thread.sleep(10000);
    	Assert.assertEquals(check.getmsg(),"Error: First Name is required");

	}
}
