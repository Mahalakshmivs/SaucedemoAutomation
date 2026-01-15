package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class Checkout extends BaseObject {

	public Checkout(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName_txt;
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName_txt;
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement zipCodeName_txt;
	@FindBy(xpath="//input[@id='continue']") 
	WebElement continue_btn;
	@FindBy(xpath="//div[@class='error-message-container error']") 
	WebElement error_btn;
	@FindBy(xpath="//span[@class='title']") 
	WebElement overview_title;
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancel_btn;
	@FindBy(xpath="//div[@class='error-message-container error']")
	WebElement errorContainer;
	@FindBy(xpath="//button[@id='finish']")
	WebElement finish_btn;
	@FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
	WebElement orderSucessMsg;
	@FindBy(xpath="//button[contains(text(),'Back Home')]")
	WebElement backToHome_btn;
    
	
	
	public void firstName(String firstName ) {
		firstName_txt.clear();
		firstName_txt.sendKeys(firstName);
	}
	
	public void lastName(String lastName ) {
		lastName_txt.clear();
		lastName_txt.sendKeys(lastName);
	}
	public void zipCode(String zipCode) {
		zipCodeName_txt.clear();
		zipCodeName_txt.sendKeys(zipCode);
	}
	
	public void clickOnContinue() {
		continue_btn.click();
	}
	
	public String getMsg() {
		String error_msg=error_btn.getText();
		return error_msg;
	}
	
	public String zipMsg() {
		String error_msg=error_btn.getText();
		return error_msg;
	}
	
	public boolean overViewTitle() {
		boolean title=overview_title.isDisplayed();
		return title;
	}
	public void cancelAction() {
		    JavascriptExecutor js= (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView();",cancel_btn);
		    cancel_btn.click();
		    
	}
	public boolean errorContainerIsdisplayed() {
		boolean errorContainerclass=errorContainer.isDisplayed();
		return errorContainerclass;
	}
	
	public void ZipCodeValidation(String Username ,String Lastname) {
		firstName_txt.sendKeys(Username);
		lastName_txt.sendKeys(Lastname);
	}
	public void clickOnFinishbBtn() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",finish_btn);
		finish_btn.click();
	}
	public void validDataNavigation(String Firstname ,String Lastname ,String Zipcode) {
		mywait.until(ExpectedConditions.visibilityOf(firstName_txt)).sendKeys(Firstname);
		mywait.until(ExpectedConditions.visibilityOf(lastName_txt)).sendKeys(Lastname);
		mywait.until(ExpectedConditions.visibilityOf(zipCodeName_txt)).sendKeys(Zipcode);
		
	}
	
	 public String getSucessMessage() {
			String success= orderSucessMsg.getText();
			return success;
		 }
	 public void pressBacktoHome() {
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView()",backToHome_btn);
			backToHome_btn.click();
			
		 } 
	public void clearInputFields() {
		firstName_txt.clear();
		lastName_txt.clear();
		zipCodeName_txt.clear();
		
	}

}
