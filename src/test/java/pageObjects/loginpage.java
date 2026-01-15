package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		mywait.until(ExpectedConditions.visibilityOf(txt_email)).sendKeys(username);
	}
	public void enterPassword(String password) {
		mywait.until(ExpectedConditions.visibilityOf(txt_password)).sendKeys(password);
	}
	public void clicklogin() {
		mywait.until(ExpectedConditions.visibilityOf(btn_submit)).click();
	}
	public boolean logoisplayed() {
	    try {
	    	return logo.isDisplayed();
	    } catch (Exception e) {
	        return false;  
	    }
	}



}
