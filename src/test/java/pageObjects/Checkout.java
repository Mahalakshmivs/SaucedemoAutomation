package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends BaseObject {

	public Checkout(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstname_txt;
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement Lastname_txt;
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement Zipcodename_txt;
	@FindBy(xpath="//input[@id='continue']") 
	WebElement continue_btn;
	@FindBy(xpath="//button[@id='cancel']") 
	WebElement cancel_btn;
	@FindBy(xpath="//div[@class='error-message-container error']") 
	WebElement error_btn;
	
	
	public void clickoncontinue() {
		continue_btn.click();

	}
	
	public String getmsg() {
		String error_msg=error_btn.getText();
		return error_msg;
	}
	

}
