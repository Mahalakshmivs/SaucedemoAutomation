package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(xpath="//button[@name='back-to-products']") WebElement backtoproducts;
	

	public List<String> verifyttle() {
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
	
	public void clickoneachimages() {
		for (int i = 0; i < product_images.size(); i++) {
		    product_images.get(i).click();
		    backtoproducts.click();
		}
	}
	
	
	public void clickoneachtitle() {
		for (int i=0;i<product_title.size();i++)
		{
			product_title.get(i).click();
			backtoproducts.click();
		}
	}
	}
	
	

