package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsListing extends BaseObject {

	public ProductsListing(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='inventory_item_img']//a//img")
	public List<WebElement> product_images;
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	public List<WebElement> product_title;
	@FindBy(xpath = "//div[@class='inventory_item_description']")
	public List<WebElement> product_descriptions;
	@FindBy(xpath = "//button[@name='back-to-products']")
	public WebElement backtoproducts;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	public WebElement drp_filter;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement p1_addtocartbtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement p2_addtocartbtn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement cart;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement cartbadge;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	public WebElement p1;
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
	public WebElement p2;
	@FindBy(xpath = "//button[@id='add-to-cart']")
	public WebElement addcart;
	
	
	//div[@class='cart_item']
	
	public List<String> verifyTitle() {
		List<String> Alltitle = new ArrayList<>();
		for (WebElement title : product_title) {
			Alltitle.add(title.getText());
		}
		return Alltitle;
	}

	public List<String> verifyproductsimages() {
		List<String> Allimages = new ArrayList<>();
		for (WebElement imgformat : product_images) {
			Allimages.add(imgformat.getAttribute("src"));
		}
		return Allimages;
	}

	public List<String> verifyproductdescription() {

		List<String> productdescription = new ArrayList<>();
		for (WebElement desc : product_descriptions) {
			productdescription.add(desc.getAttribute("src"));
		}
		return productdescription;
	}

	public List<String> clickoneachimages() {
		List<String> urls = new ArrayList<>();

		for (int i = 0; i < product_images.size(); i++) {
			product_images.get(i).click();
			urls.add(driver.getCurrentUrl());
			backtoproducts.click();
		}
		return urls;
	}

	public List<String> clickoneachtitle() {
		List<String> urls = new ArrayList<>();

		for (int i = 0; i < product_title.size(); i++) {
			product_title.get(i).click();
			urls.add(driver.getCurrentUrl());
			backtoproducts.click();
		}
		return urls;
	}

	public void clickonfilter() {
		drp_filter.click();
	}

	public void selectfilters() {
		drp = new Select(drp_filter);
		List<WebElement> alloptions = drp.getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			drp.selectByIndex(i);
		}
	}

	public void clickonaddtocart() {
		p1_addtocartbtn.click();
		p2_addtocartbtn.click();
	}
	
	public void clickonproducttoaddcart() {
		p1.click();
		addcart.click();
		backtoproducts.click();
		p2.click();
		addcart.click();
		backtoproducts.click();	
	}

	public void clickoncart() {
		cart.click();
	}

	public boolean isbadgedisplayed() {
		boolean badge = cartbadge.isDisplayed();
		return badge;
	}
	
	public String getthetextofbadge() {
		String badgenumbers=cartbadge.getText();
		return  badgenumbers; 
		
	}

}
