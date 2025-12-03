package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BaseObject {
	
	WebDriver driver;
	public Select drp;
	
	public BaseObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	

}
