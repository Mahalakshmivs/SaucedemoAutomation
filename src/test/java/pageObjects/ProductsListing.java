package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsListing extends BaseObject {

	public ProductsListing(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='inventory_item_img']//a//img")
	public List<WebElement> productImages;
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	public List<WebElement> productTitles;
	@FindBy(xpath = "//div[@class='inventory_item_description']")
	public List<WebElement> productDescriptions;
	@FindBy(xpath = "//button[@name='back-to-products']")
	public WebElement backToProducts_btn;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	public WebElement dropdown_filter;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement p1_addToCart_btn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement p2_addtocartbtn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement cart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement cartBadge;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	public WebElement firstProduct;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
	public WebElement secondProduct;
	@FindBy(xpath = "//button[@id='add-to-cart']")
	public WebElement addToCart;
	
	
	//div[@class='cart_item']
	
	public List<String> verifyTitle() {
		mywait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
		List<String> Alltitle = new ArrayList<>();
		for (WebElement title : productTitles) {
			Alltitle.add(title.getText());
		}
		return Alltitle;
	}

	public List<String> verifyProductsImages() {
		List<String> Allimages = new ArrayList<>();
		for (WebElement imgformat : productImages) {
			Allimages.add(imgformat.getAttribute("src"));
		}
		return Allimages;
	}

	public List<String> verifyProductDescription() {

		List<String> productdescription = new ArrayList<>();
		for (WebElement desc : productDescriptions) {
			productdescription.add(desc.getAttribute("src"));
		}
		return productdescription;
	}

	public List<String> clickOnEachImages() {
		List<String> urls = new ArrayList<>();
		for (int i = 0; i < productImages.size(); i++) {
			mywait.until(ExpectedConditions.visibilityOfAllElements(productImages)).get(i).click();
			urls.add(driver.getCurrentUrl());
			mywait.until(ExpectedConditions.visibilityOf(backToProducts_btn)).click();
		}
		return urls;
	}

	public List<String> clickOnEachTitle() {
		List<String> urls = new ArrayList<>();

		for (int i = 0; i < productTitles.size(); i++) {
			productTitles.get(i).click();
			urls.add(driver.getCurrentUrl());
			mywait.until(ExpectedConditions.visibilityOf(backToProducts_btn)).click();
		}
		return urls;
	}

	public void clickOnFilters() {
		dropdown_filter.click();
	}

	public void selectFilters() {
		drp = new Select(dropdown_filter);
		List<WebElement> alloptions = drp.getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			drp.selectByIndex(i);
		}
	}
	public void clickOnAddToCart() {
		mywait.until(ExpectedConditions.visibilityOf(firstProduct)).click();
		mywait.until(ExpectedConditions.visibilityOf(secondProduct)).click();
	}
	public void clickOnProductToAddcart() {
		mywait.until(ExpectedConditions.visibilityOf(p1_addToCart_btn)).click();
		addToCart.click();
		backToProducts_btn.click();
		mywait.until(ExpectedConditions.visibilityOf(p2_addtocartbtn)).click();
		addToCart.click();
		backToProducts_btn.click();
	}
	public void clickOnCart() {
		mywait.until(ExpectedConditions.visibilityOf(cart)).click();
	}

	public boolean isbadgeDisplayed() {
		boolean badge = cartBadge.isDisplayed();
		return badge;
	}
	
	public String getTextOfBadge() {
		String badgenumbers=cartBadge.getText();
		return  badgenumbers; 
		
	}

}
