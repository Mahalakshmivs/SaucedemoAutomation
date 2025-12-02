package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Descriptionpage extends BaseObject{

	public Descriptionpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@name='back-to-products']") WebElement backtoproducts;
	
	
	
	public void clickonback() {
		backtoproducts.click();
	}
	
	
	

}
