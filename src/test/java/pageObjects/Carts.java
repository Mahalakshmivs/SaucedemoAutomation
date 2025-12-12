package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Carts extends BaseObject {

	public Carts(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='cart_item']//a")
	public List<WebElement> cartitems;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement removedproduct;

	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	WebElement remove;
	
	@FindBy(xpath="//button[contains(text(),'Continue Shopping')]")
	WebElement continuebtn;
	
	@FindBy(xpath="//div[@class='cart_contents_container']")
	WebElement emptycart;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//div[@class='cart_item']")
	WebElement cartitem;
    
	// verify the number of cart items present
	public int numofprodutsincart() {
		// PageFactory.initElements(driver, this);
		return cartitems.size();
	}
	public void removeoneproducts() {
		remove.click();
	}
	public boolean isitempresnt() {
		try {
			boolean isdisplayed = removedproduct.isDisplayed();
			return isdisplayed;
		} catch (Exception e) {
			 System.out.println(e.getStackTrace());
		}
		return false;
	}
	public void scrollintobtn() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", continuebtn);
		continuebtn.click();	
	}
	public boolean emptycartpage() {
		String empty=emptycart.getText();
		boolean msg=empty.contains("Your cart is empty");
		return msg;
	}
	public void checkout() {
		checkoutbtn.click();
	}
	
	public boolean cartitemsisdisplayed() {
		boolean itempresent=cartitem.isDisplayed();
		return itempresent;
	}

}
