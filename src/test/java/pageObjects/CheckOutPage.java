package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseManager;

public class CheckOutPage {

	private BaseManager base;
	private WebDriver driver;

	public CheckOutPage(BaseManager base) {
		this.base = base;
		this.driver = base.getWebdrivermanager().getDriver();
		PageFactory.initElements(driver, this);
	}

	// Method to retrieve CheckOut page url
	public String getCheckOutPageURL() {
		return base.getConfig().readProperty("base_url");
	}

	// Locators for all Webelements on CheckOut Page
	@FindBy(id = "shipping_first_name")
	private WebElement first_name;

	@FindBy(id = "shipping_last_name")
	private WebElement last_name;

	@FindBy(id = "shipping_email")
	private WebElement email;

	@FindBy(id = "shipping_email_repeat")
	private WebElement email_verify;

	@FindBy(id = "shipping_phone")
	private WebElement phone;

	@FindBy(id = "select2-shipping_country-container")
	private WebElement country_selection;

	@FindBy(id = "select2-search__field")
	private WebElement country_text;

	@FindBy(id = "shipping_postcode")
	private WebElement postcode;

	@FindBy(id = "shipping_house_number")
	private WebElement house_no;

	@FindBy(id = "shipping_city")
	private WebElement city;

	@FindBy(id = "shipping_street_name")
	private WebElement street_name;

	@FindBy(xpath = "//button[@class='checkout-btn-cnt-new active continue-checkout' and text()='Continue to pay']")
	private WebElement checkout_btn;
	
	@FindBy(xpath = "//h4[@class='review-order-title']")
	private WebElement payment_method;
	
	@FindBy(xpath= "//div[@class='css-1f734rb']")
	private WebElement brand_page;

	// Methods to acess Webelements on CheckOut page
	public void first_name(String fname) {
		first_name.sendKeys(fname);
	}

	public void last_name(String lname) {
		last_name.sendKeys(lname);
	}

	public void email(String eml) {
		email.sendKeys(eml);
	}
	
	public void emailverify(String repeatemail)
	{
		email_verify.sendKeys(repeatemail);
	}

	public void phone(String phn) {
		phone.sendKeys(phn);
	}

	public void country_selection() {
		country_selection.click();
	}

	public void country_text(String country_txt) {
		country_text.sendKeys(country_txt);
	}

	public void postcode(String post) {
		postcode.sendKeys(post);
	}

	public void house_no(String houseno) {
		house_no.sendKeys(houseno);
	}

	public void city(String cty) {
		city.sendKeys(cty);
	}

	public void street_name(String street) {
		street_name.sendKeys(street);
	}

	public WebElement checkout_btn() {
		return checkout_btn;
	}
	
	public String payment_method() {
		 return payment_method.getAttribute("innerText");
	}
	
	public String brand_page() {
		 return brand_page.getText();
	}

}
