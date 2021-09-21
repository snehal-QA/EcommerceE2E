package pageObjects;

import utilities.ConfigFileReader;
import utilities.Generators;
import utilities.WebDriverManager;

public class PageObjectsManager {

	private BaseUrlPage baseurlpage;
	private AllBrandsPage allbrandsPage;
	private CheckOutPage checkOutPage;
	private RegisterPage registerPage;
	private BrandPage brandPage;

	public PageObjectsManager(BaseUrlPage baseurlPage, 
							  AllBrandsPage allbrandsPage, 
							  CheckOutPage checkOutPage, 
							  RegisterPage registerPage,
							  BrandPage brandPage) {

		this.baseurlpage = baseurlPage;
		this.allbrandsPage = allbrandsPage;
		this.checkOutPage = checkOutPage;
		this.registerPage = registerPage;
		this.brandPage=brandPage;
	}

	public BaseUrlPage getBaseurlpage() {
		return baseurlpage;
	}

	public AllBrandsPage getAllbrandsPage() {
		return allbrandsPage;
	}

	public CheckOutPage getCheckOutPage() {
		return checkOutPage;
	}

	public RegisterPage getRegisterPage() {
		return registerPage;
	}
	
	public BrandPage getBrandPage() {
		return brandPage;
	}
	
}
