package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidemenu extends BaseObject{

	public Sidemenu(WebDriver driver) {
		super(driver);
		
	}
	 //locators
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") 
	WebElement btn_hamburger;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']") 
	WebElement a_logout;
	
	public void clickonhamburger() {
		btn_hamburger.click();
		
	}
	public void clickonlogout() {
		a_logout.click();	
	}
	
	
	

}
