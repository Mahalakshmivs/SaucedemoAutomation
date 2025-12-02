package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BaseObject {

	public loginpage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btn_submit;
	
	
	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement logo;

	// actions methods
	public void enterEmail(String username) {
		txt_email.sendKeys(username);
	}
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	public void clicklogin() {
		btn_submit.click();
	}
	public void clearEmail() {
		txt_email.clear();
	}
	public void clearPassword() {
		txt_password.clear();
	}
	
	public boolean logoisplayed() {
	    try {
	        return logo.isDisplayed();
	    } catch (Exception e) {
	        return false;  
	    }
	}



}
