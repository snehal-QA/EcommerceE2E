package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseManager;


public class BrandPage {
	
	private WebDriver driver;
	private BaseManager base;
			
	public BrandPage(BaseManager base){
		this.base=base;
		this.driver=base.getWebdrivermanager().getDriver();
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//span[@class='Checkbox__label']/span")
	private List<WebElement> shopping_type;
	
	@FindBy(xpath="//div[@class='ProductCard__product']")
	private List<WebElement> getBrandProducts;
	
	@FindBy(xpath="//div[@class='default text']")
	private WebElement categorySize;
	
	@FindBy(xpath="//div[@class='selected item']")
	private WebElement select_categorySize;
	
	@FindBy(xpath="//div[@class='css-9os4pq']")
	private WebElement addToBasket;
	
	@FindBy(xpath="//span[@class='mainHeader__cartCount css-1uim69z']")
	private WebElement toCart;
	
	@FindBy(xpath="//a[@class='action-featured-black proceed-to-checkout action-fill-black']")
	private WebElement toCheckout;
		
	public List<WebElement> shopping_type() {
		return shopping_type;
	}
	
	public List<WebElement> getBrandProducts() {
		return getBrandProducts;
	}

	public WebElement categorySize() {
		return categorySize;
	}
	
	public WebElement select_categorySize() {
		return select_categorySize;
	}
	
	public WebElement addToBasket() {
		return addToBasket;
	}
	
	public WebElement toCart() {
		return toCart;
	}
	
	public WebElement toCheckout() {
		return toCheckout;
	}
}


