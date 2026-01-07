package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

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
	@FindBy(xpath="//div[@class='error-message-container error']") 
	WebElement error_btn;
	@FindBy(xpath="//span[@class='title']") 
	WebElement overview_title;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement caancel_btn;
	@FindBy(xpath="//div[@class='error-message-container error']")
	WebElement errorcontainer;
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish_btn;
	@FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
	WebElement orderSucessMsg;
	@FindBy(xpath="//button[contains(text(),'Back Home')]")
	WebElement backtoHome_btn;
    
	
	
	public void firstName(String firstName ) {
		Lastname_txt.clear();
		Lastname_txt.sendKeys(firstName);
	}
	
	public void lastName(String lastName ) {
		Lastname_txt.clear();
		Lastname_txt.sendKeys(lastName);
	}
	public void zipCode(String zipCode) {
		Zipcodename_txt.clear();
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
		    JavascriptExecutor js= (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView();",caancel_btn);
		    caancel_btn.click();
		    
	}
	public boolean errorcontainerisdisplayed() {
		boolean errorcontainerclass=errorcontainer.isDisplayed();
		return errorcontainerclass;
	}
	
	public void ZipCodeValidation(String Username ,String Lastname) {
		firstname_txt.sendKeys(Username);
		Lastname_txt.sendKeys(Lastname);
	}
	public void finishbtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",finish_btn);
		finish_btn.click();
	}
	public void validDataNavigation(String Firstname ,String Lastname ,String Zipcode) {
		firstname_txt.sendKeys(Firstname);
		Lastname_txt.sendKeys(Lastname);
		Zipcodename_txt.sendKeys(Zipcode);
	}
	
	 public String getSucessMessage() {
			String success= orderSucessMsg.getText();
			return success;
		 }
	 public void pressBacktoHome() {
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView()",backtoHome_btn);
			backtoHome_btn.click();
			
		 } 
	public void clearfileds() {
		firstname_txt.clear();
		Lastname_txt.clear();
		Zipcodename_txt.clear();
		
	}

}
