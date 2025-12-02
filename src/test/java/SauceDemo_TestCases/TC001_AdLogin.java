package SauceDemo_TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Saucedemo_utilities.Dataprovoder;
import pageObjects.Sidemenu;
import pageObjects.loginpage;
import saucedemo_BaseClass.saucedemo_BaseClasses;

public class TC001_AdLogin extends saucedemo_BaseClasses {
	@Test(dataProvider = "logindata", dataProviderClass = Dataprovoder.class)
	public void adlogin(String Username, String Password ,String exp ) {

		try {
			loginpage ad = new loginpage(driver);
			Sidemenu menu=new Sidemenu(driver);
			ad.enterEmail(Username);
			ad.enterPassword(Password);
			ad.clicklogin();
			boolean msg=ad.logoisplayed();
			if(exp.equalsIgnoreCase("valid")) {
				if(msg==true) {
					menu.clickonhamburger();
					menu.clickonlogout();
					Assert.assertTrue(true);
				}
			else {
				Assert.assertTrue(false);
			}
			}
			if(exp.equalsIgnoreCase("invalid")) {
				if(msg==true) 
				{  
					menu.clickonhamburger();
					menu.clickonlogout();
					Assert.fail("Invalid login unexpectedly succeeded");
				}	
			else
			{   
				 Assert.assertTrue(true, "Invalid login correctly failed");
			}
			}
			
		} catch (Exception e) {

			//logger.error("execution failed");
			//logger.debug("debug the logs ");
			Assert.fail();
		}


	}

}
