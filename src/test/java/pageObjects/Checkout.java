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
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement Lastname_txt;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement Zipcodename_txt;
	@FindBy(xpath="//input[@id='continue']") 
	WebElement continue_btn;
	@FindBy(xpath="//button[@id='cancel']") 
	WebElement cancel_btn;
	@FindBy(xpath="//div[@class='error-message-container error']") 
	WebElement error_btn;
	@FindBy(xpath="//span[@class='title']") 
	WebElement overview_title;
	@FindBy(xpath="//button[id='cancel']")
	WebElement caancel_btn;
	
	public void firstName(String firstName) {
		firstname_txt.sendKeys(firstName);
	}
	public void lastName(String lastName ) {
		Lastname_txt.sendKeys(lastName);
	}
	public void zipCode(String zipCode) {
		Zipcodename_txt.sendKeys(zipCode);
	}
	
	public void clickoncontinue() {
		continue_btn.click();
	}
	
	public String getmsg() {
		String error_msg=error_btn.getText();
		return error_msg;
	}
	
	public String zipMsg() {
		String error_msg=error_btn.getText();
		return error_msg;
	}
	
	public boolean overviewtitle() {
		boolean title=overview_title.isDisplayed();
		return title;
	}
	public void cancelAction() {
		caancel_btn.click();
	}

}
