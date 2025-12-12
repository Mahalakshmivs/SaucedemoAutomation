package saucedemo_BaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.Carts;
import pageObjects.Checkout;
import pageObjects.ProductsListing;
import pageObjects.loginpage;

public class saucedemo_BaseClasses{
	
	 public WebDriver driver;
	 public Alert myalert;
	 public Properties pro;
	 public Select drp;
	 public ProductsListing pl;
	 public Carts cart;
	 public loginpage ad;
	 public Checkout check;
	
	@BeforeClass
	public void baseSetUp() throws IOException{
		
		FileReader filepath=new FileReader("./src//test//resources//Config.properties");
		pro=new Properties();
		pro.load(filepath);
		driver=new ChromeDriver();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		ad = new loginpage(driver);
		pl= new ProductsListing(driver);
		check=new Checkout(driver);
		cart= new Carts(driver);
		ad.enterEmail(pro.getProperty("username"));
		ad.enterPassword(pro.getProperty("password"));
		ad.clicklogin();

	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


	public String captureScreen(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
