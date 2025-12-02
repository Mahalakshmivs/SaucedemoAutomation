package saucedemo_BaseClass;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class saucedemo_BaseClasses<DataProvoder_BAL> {
	 public WebDriver driver;
	 public DataProvoder_BAL dp;
	
	
	@BeforeClass
	public void baseSetUp(){
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
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
