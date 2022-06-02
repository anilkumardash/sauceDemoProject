package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	private By home_title=By.xpath("//span[@class='title']");
	private By products=By.xpath("//div[@class='inventory_item_name']");
	private By productName=By.xpath("//div[@class='inventory_details_name large_size']");
	private By click_addToCart=By.xpath("//button[text()='Add to cart']");
	private By remove=By.xpath("//button[text()='Remove']");
	private By cart_logo=By.xpath("//div[@id='shopping_cart_container']");
	private By openmenu=By.xpath("//button[text()='Open Menu']");
	private By logoutBtn=By.xpath("//a[text()='Logout']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	public boolean getCartLogo() {
		return getLogo(cart_logo);
	}


	public String getHomepage_header() {
		return getPageHeader(home_title);
	}
	
	
	public List<WebElement> getProductNames() {
		return getElements(products);
//		 return (List<WebElement>) getInstance(AddToCartPage.class);
		
	}
	
	public String getProductName() {
		return getPageHeader(productName);
		
	}
	
	public WebElement getClick_addToCart() {
		return getElement(click_addToCart);
	}
	
	public String getRemove() {
		return getPageHeader(remove);
	}
	public AddToCartPage getClickCart() {
		getElement(cart_logo).click();
		return getInstance(AddToCartPage.class);
		
	}

	public WebElement getMenu() {
		return getElement(openmenu);
	}

	public WebElement getLogoutBtn() {
		return getElement(logoutBtn);
	}
	public LogoutPage clickLogout() throws InterruptedException{
		getMenu().click();
		Thread.sleep(2000);
		getLogoutBtn().click();
		return getInstance(LogoutPage.class);
		
	}
}
