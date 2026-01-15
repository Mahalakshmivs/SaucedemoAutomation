package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseObject {
	
	WebDriver driver;
	public Select drp;
	public WebDriverWait mywait;
	
	public BaseObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		mywait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	

	

}
