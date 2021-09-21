package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseManager;


public class RegisterPage {
	
	private WebDriver driver;
	private BaseManager base;
			
	public RegisterPage(BaseManager base){
		this.base=base;
		this.driver=base.getWebdrivermanager().getDriver();
		PageFactory.initElements(driver, this);
}

	//Locators for all Webelements on SignupConfirmation Page
	@FindBy(xpath="//div[@class='css-4cffwv']/button/span")
	private List<WebElement> gender;
	
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(xpath="//span[text()='Create an account']")
	private WebElement create_acct_btn;
	
	@FindBy(xpath="//div[@class='Modal__content_slide--false']/div/div[2]/div/div[2]/button")
	private WebElement accept;
	
	public List<WebElement> gender() {	
		return gender;
	}
	
	public WebElement email() {
		return email;
	}

	public WebElement create_acct_btn() {
		return create_acct_btn;
	}
	
	public WebElement accept() {
		return accept;
	}
	
	
}


