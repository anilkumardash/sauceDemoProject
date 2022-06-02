package Tests;

import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;

public class HomePageTest extends BaseTest {
	
	HomePage home;
	
//	
	@Test(priority=1)
	public void validateHomepageLogo() {
		home=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean Cart_logo =home.getCartLogo();
		Assert.assertTrue(Cart_logo);
	}
	@Test(priority=2)
	public void validateproduct() throws InterruptedException {
		home=page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		List<WebElement> productname=home. getProductNames();
		for(int i=0;i<productname.size();i++) {
			String pro=productname.get(i).getText();
			System.out.println(pro);
			if(pro.contentEquals("Sauce Labs Onesie")){
				productname.get(i).click();
				break;
				
			}
			
		}
		String clicked_product = home.getProductName();
		Assert.assertEquals(clicked_product, prop.getProperty("product_name"));
		home.getClick_addToCart().click();
	
		String removeText =home.getRemove();
		System.out.println(removeText);
		Assert.assertEquals(removeText, "REMOVE");
		
	}
}
