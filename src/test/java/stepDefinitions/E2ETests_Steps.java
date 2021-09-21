package stepDefinitions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectsManager;
import utilities.BaseManager;
import utilities.Log;

public class E2ETests_Steps {
	private WebDriver driver;
	private Scenario scenario;
	private BaseManager base;
	private PageObjectsManager pageom;
	private String register_email;
	private String gender;

	SoftAssert softAssert = new SoftAssert();

	// Dependency Injection to use data from various classes
	public E2ETests_Steps(BaseManager base, PageObjectsManager pageom) {
		this.pageom = pageom;
		this.base = base;
		this.driver = base.getWebdrivermanager().getDriver();
	}

	@Before(order = 2)
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	// SoftAsserts are used to make sure all asserts/verification are executed even
	// if one fails
	@After(order = 2)
	public void after(Scenario scenario) {
		softAssert.assertAll();
		base.getWebdrivermanager().getDriver().quit();
		this.scenario = scenario;

	}

	////////////////////////////////////// Common methods used across feature files
	////////////////////////////////////// /////////////////////////////////////////////////////////////

	@Given("unauthenticated user navigates to Otrium.com page")
	public void user_navigates_to_otrium_com_sign_up_page() {
		driver.get(pageom.getBaseurlpage().getBasePageURL());
		pageom.getBaseurlpage().cookie().click();
		Log.info("Title : " + driver.getTitle()
				+ "\n Expected : Otrium | The Online Fashion Outlet | Get Exclusive Access");
		scenario.log("Title :" + driver.getTitle()
				+ "\n Expected : Otrium | The Online Fashion Outlet | Get Exclusive Access");
		softAssert.assertEquals(driver.getTitle(), "Otrium | The Online Fashion Outlet | Get Exclusive Access");
		softAssert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.otrium.com/"));
	}

	@When("user clicks on {string} option")
	public void user_clicks_on_option(String string) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", pageom.getBaseurlpage().all_brands());
	}

	@Then("user navigates to {string}")
	public void user_navigates_to(String expectedpagetitle) {
		Log.info("Title : " + driver.getTitle() + "\n Expected : Otrium | All Brands");
		scenario.log("Title :" + driver.getTitle() + "\n Expected : Otrium | All Brands");
		softAssert.assertTrue(driver.getTitle().contains(expectedpagetitle));
		softAssert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.otrium.com/all-brands/"));
	}

	@When("user selects gender {string}")
	public void selects_gender(String requiredGender) throws InterruptedException {
		gender = requiredGender;
		pageom.getAllbrandsPage().genderdropdown().click();
		List<WebElement> selectgender = pageom.getAllbrandsPage().gender();
		selectgender.stream().filter(i -> i.getText().equalsIgnoreCase(requiredGender)).forEach(i -> i.click()); 
	}

	@When("user selects brand {string}")
	public void selects_the_option(String brand) throws InterruptedException {

		Thread.sleep(5000);
		WebElement we = pageom.getAllbrandsPage().search_brands();
//		
//		WebDriverWait wait = new WebDriverWait(driver, 15);	 
//		wait.until(ExpectedConditions.elementToBeClickable(we)).click();
		// Actions actions = new Actions(driver);
		// actions.moveToElement(pageom.getAllbrandsPage().search_brands()).click().perform();
		pageom.getAllbrandsPage().search_brands().click();

//	    WebDriverWait wd=new WebDriverWait(driver,60);
//	    WebElement element =wd.until(ExpectedConditions.elementToBeClickable(we))	;
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", we);
//		
//		WebElement textbox=driver.findElement(By.xpath("//div[@class='menu-wrap show-menu']/input"));
//		WebDriverWait wd1=new WebDriverWait(driver,60);
//	    WebElement element1 =wd.until(ExpectedConditions.visibilityOf(textbox));
//      we.click();
//		System.out.println("Element1: "+element1);		
//		((JavascriptExecutor)driver).executeScript("arguments[0].value='" + brand + "';", pageom.getAllbrandsPage().search_brands_text());
//		
//		actions.moveToElement(pageom.getAllbrandsPage().search_brands()).sendKeys(brand).perform();
		pageom.getAllbrandsPage().search_brands_text().sendKeys(brand);

		// actions.moveToElement(pageom.getAllbrandsPage().brandList()).click().perform();
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click()",
		// pageom.getAllbrandsPage().brandList());
		// WebDriverWait wd=new WebDriverWait(driver,10);
		// wd.until(ExpectedConditions.elementToBeClickable(pageom.getAllbrandsPage().brandList())).click();
		pageom.getAllbrandsPage().brandList().click();

		// driver.findElement(By.xpath(".//form[@class='brand-list']")).click();
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click()",
		// pageom.getAllbrandsPage().brandSave());

		// actions.moveToElement(pageom.getAllbrandsPage().brandSave()).click().perform();
		pageom.getAllbrandsPage().brandSave().click();
	}

	@Then("user is redirected to page having brand {string} image to continue shopping")
	public void user_redirects_brand_continue_shopping(String brandname) throws InterruptedException {
		Thread.sleep(3000);
//		 WebDriverWait wd=new WebDriverWait(driver,5);
//    	 wd.until(ExpectedConditions.visibilityOf(pageom.getAllbrandsPage().getloadedbrand()));
		softAssert.assertTrue((pageom.getAllbrandsPage().getloadedbrand().getAttribute("data-saleslanding"))
				.toLowerCase().contains((brandname).toLowerCase()), "Loaded brand data-saleslandingurl: " + brandname);
		softAssert.assertTrue((pageom.getAllbrandsPage().getloadedbrand().getAttribute("sales-url")).toLowerCase()
				.contains((brandname).toLowerCase()), "Loaded brand salesurl: " + brandname);
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String webelement) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m1 = pageom.getAllbrandsPage().getClass().getMethod(webelement, null);
		WebElement we = ((WebElement) m1.invoke(pageom.getAllbrandsPage(), null));
//	    WebDriverWait wd=new WebDriverWait(driver,200);
//		wd.until(ExpectedConditions.visibilityOf(we));
		// we.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", we);
	}

	@When("user finish registration page")
	public void user_finish_registration_page() throws InterruptedException {
		register_email = base.getGenerators().email();
		List<WebElement> selectgender = pageom.getRegisterPage().gender();
		selectgender.stream().filter(i -> i.getText().equalsIgnoreCase(gender)).forEach(i -> i.click());
		pageom.getRegisterPage().email().sendKeys(register_email);
		pageom.getRegisterPage().create_acct_btn().click();
		Thread.sleep(2500);
		pageom.getRegisterPage().accept().click();
		Thread.sleep(3500);
	}

	@When("selects {string} option")
	public void selects_option(String Shopping_type) {
		List<WebElement> shoppingType = pageom.getBrandPage().shopping_type();
		shoppingType.stream().filter(i -> i.getAttribute("innerText").equalsIgnoreCase(Shopping_type))
				.forEach(i -> i.click());
	}

	@When("user sends shoe with related size for checkout")
	public void user_sends_shoe_with_related_size_for_checkout() throws InterruptedException {
		Thread.sleep(3000);
		pageom.getBrandPage().getBrandProducts().get(0).click();
		pageom.getBrandPage().categorySize().click();
		pageom.getBrandPage().select_categorySize().click();
		// Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", pageom.getBrandPage().addToBasket());
		pageom.getBrandPage().toCart().click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", pageom.getBrandPage().toCheckout());

	}

	@Then("user enters the checkout details for payment")
	public void user_enters_the_checkout_details_for_payment() throws InterruptedException {
		pageom.getCheckOutPage().first_name(base.getGenerators().first_name());
		pageom.getCheckOutPage().last_name(base.getGenerators().last_name());
		pageom.getCheckOutPage().emailverify(register_email);
		pageom.getCheckOutPage().phone((base.getGenerators().phone()));
		pageom.getCheckOutPage().postcode(base.getGenerators().postCode());
		pageom.getCheckOutPage().house_no(base.getGenerators().houseNo());
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", pageom.getCheckOutPage().checkout_btn());

	}

	@Then("page is moved to payment page")
	public void page_is_moved_to_payment_page() {
		Log.info("Current Page : " + pageom.getCheckOutPage().payment_method());
		softAssert.assertTrue(pageom.getCheckOutPage().payment_method().equalsIgnoreCase("PAYMENT METHOD"));
	}

}
