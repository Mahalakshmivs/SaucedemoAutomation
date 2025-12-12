package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Saucedemo_utilities.DataProviders;
import pageObjects.Sidemenu;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC001_Login extends saucedemo_BaseClasses {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class)
	public void adlogin(String Username, String Password, String exp) throws InterruptedException {

		loginpage ad = new loginpage(driver);
		Sidemenu menu = new Sidemenu(driver);
		ad.enterEmail(Username);
		ad.enterPassword(Password);
		ad.clicklogin();
		boolean msg = ad.logoisplayed();
		if (exp.equalsIgnoreCase("valid")) {
			if (msg == true) {
				Thread.sleep(2000);
				menu.clickonhamburger();
				menu.clickonlogout();
				Assert.assertTrue(msg);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equalsIgnoreCase("invalid")) {
			if (msg == true) {
				menu.clickonhamburger();
				menu.clickonlogout();
				Assert.fail("Invalid login passed unexpectedly!");
			} else {
				Assert.assertTrue(true);
			}
		}

		driver.navigate().refresh();
	}

}
