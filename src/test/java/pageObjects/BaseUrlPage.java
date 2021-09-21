package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseManager;


public class BaseUrlPage {
	
	private WebDriver driver;
	private BaseManager base;
			
	public BaseUrlPage(BaseManager base){
		this.base=base;
		this.driver=base.getWebdrivermanager().getDriver();
		PageFactory.initElements(driver, this);
}

    //Method to retrieve BaseUrl
	public String getBasePageURL() {
		return base.getConfig().readProperty("base_url");
	}

	//Locators for all Webelements on SignupConfirmation Page
	@FindBy(className="css-83bdt0")
	private WebElement cookie;
	
	
	@FindBy(xpath="//span[text()='All brands']")
	private WebElement all_brands;
	
	public WebElement all_brands() {
		return all_brands;
	}
	
	public WebElement cookie() {
		return cookie;
	}
	
}
