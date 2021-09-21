package pageObjects;

import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseManager;


public class AllBrandsPage {
	
	private WebDriver driver;
	private BaseManager base;
			
	public AllBrandsPage(BaseManager base){
		this.driver=base.getWebdrivermanager().getDriver();
		PageFactory.initElements(driver, this);
}
   
	//Method to retrieve All Brand Page URL
//	public String getAllBrandPageURL() {
//		return base.getConfig().readProperty("base_url") + base.getConfig().readProperty("all_brand");
//	}

	//Locators for all Webelements on SignupConfirmation Page
	@FindBy(xpath="(//div[contains(@class,'header toggle')]//span)[3]")
	private WebElement genderdropdown; 
	
	@FindBy(xpath="//ul[@class='gender-list']/li/a")
	private List<WebElement> gender;
	
	@FindBy(xpath="//ul[@class='gender-list']//a")
	private WebElement women;
	
	@FindBy(xpath="//div[@class='brands col']")
	private WebElement search_brands;
	
	@FindBy(xpath="//div[@class='menu-wrap show-menu']/input")
	private WebElement search_brands_text;

	@FindBy(xpath="//a[@class='brands-btn btn action-featured-black']")
	private WebElement brandSave;
	
	@FindBy(xpath="(//div[contains(@class,'header toggle')])[2]")
	private WebElement categories;
	
	@FindBy(xpath="//label[text()='Shoes']")
	private WebElement category_select;
	
	@FindBy(xpath="//a[@class='btn action-featured-black']")
	private WebElement save;
	
	@FindBy(xpath="(//a[@class='action-featured-black'])[2]")
	private WebElement ShopNow;
	
	@FindBy(xpath=".//a[@class='brand-link']")
	private WebElement loadedbrand;
	
	@FindBy(xpath="//form[@class='brand-list']")
	private WebElement brand_list;
	
	public WebElement getloadedbrand() {
		return loadedbrand;
	}
	
	public WebElement genderdropdown() {
		return genderdropdown;
	}
	
	public List<WebElement> gender()
	{
		return gender;
	}
	
	public WebElement women() {
		return women;
	}
	
	public WebElement search_brands() {
		return search_brands;
	}
	
	public WebElement search_brands_text() {
		return search_brands_text;
	}
	
	public WebElement categories() {
		return categories;
	}
	
	public WebElement category_select() {
		return category_select;
	}
	
	public WebElement save() {
		return save;
	}
	
	public WebElement ShopNow() {
		return ShopNow;
	}
	
	public WebElement brandSave() {
		return brandSave;
	}
	
	public WebElement brandList() {
		return brand_list;
	}
}
