package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Carts extends BaseObject {

	public Carts(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//a[@class='shopping_cart_link']")
	public WebElement cart;
	
	public void clickoncart() {
		cart.click();
	}

}
